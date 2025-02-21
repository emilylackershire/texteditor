package edu.grinnell.csc207.texteditor;
/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {
    private final StringBuffer stringbuffer = new StringBuffer("");
    private int cursorPosition = 0;
    private int size = 0;

    /**
     * inserts character to string buffer
     * @param ch - character we want to add
     */
    public void insert(char ch) {
        stringbuffer.insert(cursorPosition, ch);
        cursorPosition += 1;
        size++;
    }

    /**
     * deletes a character from the string buffer
     */
    public void delete() {
        if (size > 0) {
            stringbuffer.delete(cursorPosition - 1, cursorPosition);
            cursorPosition -= 1;
            size--;
        }
    }

    /**
     * returns the cursor position
     * @return cursorPosition
     */
    public int getCursorPosition() {
        return cursorPosition;
    }

    /**
     * moves the cursor position to the left
     */
    public void moveLeft() {
        if (cursorPosition != 0) {
            cursorPosition -= 1;
        }
    }

    /**
     * moves the cursor position to the right
     */
    public void moveRight() {
        if (cursorPosition != size) {
            cursorPosition += 1;
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
        if (i <= size) {
            return stringbuffer.charAt(i);
        }
        throw new IndexOutOfBoundsException("This index is out of bounds");
    }

    /**
     * returns the string buffer as a string
     * @return string buffer 
     */
    @Override
    public String toString() {
        return (stringbuffer.toString());
    }
}
