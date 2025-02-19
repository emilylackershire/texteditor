package edu.grinnell.csc207.texteditor;

import java.util.Arrays;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {

    private int arrLength = 10000;
    private char gapBuffer[] = new char[arrLength];
    private int gapStart;
    private int gapEnd;
    private int cursor = 0;
    private int size = 0;

    public void insert(char ch) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public void delete() {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public int getCursorPosition() {
        return cursor;
    }

    public void moveLeft() {
        cursor -= 1;
    }

    public void moveRight() {
        cursor += 1;
    }

    public int getSize() {
        return size;
    }

    public char getChar(int i) {
        return gapBuffer[i];
    }

    @Override
    public String toString() {
        return Arrays.toString(gapBuffer);
    }
}
