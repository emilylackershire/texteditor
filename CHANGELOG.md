## Comments Made 

For an M:
- Your program needs to pass all autograder tests. Currently, it is failing a cursor movement test. Test edge cases to figure out why the cursor is going to an index that is out of bounds in certain scenarios (hint: the cursor can be out of bounds if the index is greater than or equal to the length of the buffer, but also if it goes to a negative index).
- you need to give a reasoning for the runtime of insert in addition to just the runtime itself.

For an E:
- Each character is on a newline instead of on the same line. The cursor gets stuck after the first character, not updating to the newlines with additional characters. Lastly, the program does nothing if the argument file already exists, i.e. upon saving a file, we are unable to access it through the texteditor again (you can consult PM for help on fixing the correctness of your texteditor)
- you need to ensure that the given analysis for the runtime of insert is correct

## Changes Made

Changed my Big-O from O(1) to O(n), so that it is applicable and added a justification section.  

I had a lanterna error because of working on a windows machine that was not letting the window pop up. I talked to Professor Osera about this, and he was able to fix it for me in TextEditor on lines 51-59. 

I first implemented a method checkCursor to find out where the out of bounds error was happening, and it was because I was subtracting 1 in move right when I should't have been in move right, for gapStart.

I then noticed that it was still failing one of Professor Osera's tests, as the cursor position was returning 3 when it was 4 after the very last move right.



I then tried to fix the thing with each letter being on a new line instead of next to each other, and this was very simple it was just switching where rows and columns were in line 36 of the text editor! I had it as screen.setCharacter(row, col, text); and changed it to screen.setCharacter(col, row, text); and that made everything work right. 




I then realized that my delete was lowkey just moving left and not acctually deleting, so things were replaced when you wrote over them but not as you "deleted" them. I fixed this, but then there was something really weird going on with size when you decremented it, so it wouldn't show up when you did that. This was super weird as I size isn't even used in delete. 


code from gap buffer - ignore if its still here I forgot to delete it sorry! 
package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer based implementation of a text buffer.
 */
public class GapBuffer {

    private int arrLength = 1;
    private char gapBuffer[] = new char[arrLength];
    private int gapStart = 0;
    private int gapEnd = arrLength;
    private int cursor = 0;
    private int size = 0;


    public String checkCursor(String message) {
        if(cursor <= arrLength) { 
            return ("length is greater than or equal to cursor in ");
        }
        if(cursor > 0) { 
            return ("length is negative in ");
        }
        return null;
    }

    /**
     * inserts character to string buffer
     * @param ch - character we want to add
     */
    public void insert(char ch) {
        if (gapStart >= gapEnd) {
            arrLength *= 2;
            char[] newGapBuffer = new char[arrLength];
            for (int i = 0; i < gapStart; i++) {
                newGapBuffer[i] = gapBuffer[i];
            }
            for (int j = gapEnd + (arrLength / 2); j < arrLength; j++) {
                newGapBuffer[j] = gapBuffer[j - (arrLength / 2)];
            }
            gapBuffer = newGapBuffer;
            gapEnd = gapStart + (arrLength / 2);
        } 
        gapBuffer[cursor] = ch;
        checkCursor("insert");
        cursor++;
        checkCursor("insert");
        size++;
        gapStart++;
    }

    /**
     * deletes a character from the string buffer
     */
    public void delete() {
        if (cursor > 0 && size != 0) {
            gapBuffer[cursor - 1] = '\0';
            size--;
            gapStart--;
            cursor--;
        }
    }

    /**
     * returns the cursor position
     * @return cursorPosition
     */
    public int getCursorPosition() {
        return cursor;
    }
    /**
     * returns the cursor position
     * @return cursorPosition
     */
    public int getGapEnd() {
        return gapEnd;
    }

    /**
     * moves the cursor position to the left
     */
    public void moveLeft() {
        if (cursor != 0) {
            if (size != arrLength) {
                gapBuffer[gapEnd - 1] = gapBuffer[cursor - 1];
                gapBuffer[cursor] = '\0';
                gapEnd--;
                gapStart--;
            }
            checkCursor("insert");
            cursor -= 1;
            checkCursor("insert");
        }
    }

    /**
     * moves the cursor position to the right
     */
    public void moveRight() {
        if (cursor != arrLength) {
            if (size != arrLength) {
                gapBuffer[cursor] = gapBuffer[gapStart];
                gapBuffer[cursor] = '\0';
                gapEnd++;
                gapStart++;
            }
            checkCursor("insert");
            cursor += 1;
            checkCursor("insert");
        }
    }

    /**
     * returns size of string buffer
     * @return size 
     */
    public int getSize() {
        return size;
    }

    /**
     * gets character at index i and returns it
     * @param i - index we want to check character at
     * @return character at index i
     * @throws IndexOutOfBoundsException when i is an invalid index
     */
    public char getChar(int i) {
        return gapBuffer[i];
    }

    /**
     * returns the string buffer as a string
     * @return string buffer 
     */
    @Override
    public String toString() {
        String gapBufferString = new String(gapBuffer);
        gapBufferString = gapBufferString.replaceAll("\0", " ");
        return gapBufferString;
    }
}
