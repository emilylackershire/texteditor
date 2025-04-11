## Comments Made 

For an M:
- Your program needs to pass all autograder tests. Currently, it is failing a cursor movement test. Test edge cases to figure out why the cursor is going to an index that is out of bounds in certain scenarios (hint: the cursor can be out of bounds if the index is greater than or equal to the length of the buffer, but also if it goes to a negative index).
- you need to give a reasoning for the runtime of insert in addition to just the runtime itself.

For an E:
- Each character is on a newline instead of on the same line. The cursor gets stuck after the first character, not updating to the newlines with additional characters. Lastly, the program does nothing if the argument file already exists, i.e. upon saving a file, we are unable to access it through the texteditor again (you can consult PM for help on fixing the correctness of your texteditor)
- you need to ensure that the given analysis for the runtime of insert is correct

## Changes Made

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
            checkCursor("insert");
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
                gapBuffer[cursor - 1] = '\0';
                gapEnd--;
                gapStart--;
            }
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
                gapBuffer[cursor] = gapBuffer[gapStart - 1];
                gapBuffer[cursor] = '\0';
                gapEnd++;
                gapStart++;
            }
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
        gapBufferString = gapBufferString.replaceAll("\0", "");
        return gapBufferString;
    }
}
