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
                gapBuffer[cursor - 1] = '\0';
                gapEnd--;
                gapStart--;
            }
            cursor -= 1;
        }
    }

    /**
     * moves the cursor position to the right
     */
    public void moveRight() {
        if (cursor < arrLength) {
            if (size < arrLength && cursor != size) {
                gapBuffer[cursor] = gapBuffer[gapStart];
                gapBuffer[cursor] = '\0';
                gapEnd++;
                gapStart++;
                cursor += 1;
            }
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