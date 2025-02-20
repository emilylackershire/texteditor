package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {

    private int arrLength = 1;
    private char gapBuffer[] = new char[arrLength];
    private int gapStart = 0;
    private int gapEnd = arrLength;
    private int cursor = 0;
    private int size = 0;

    /**
     * @param ch
     */
    public void insert(char ch) {
        if(gapStart >= gapEnd) {
            arrLength *= 2;
            char[] newGapBuffer = new char[arrLength];
            for(int i = 0; i < gapStart; i++) {
                newGapBuffer[i] = gapBuffer[i];
            }
            for(int j = gapEnd + (arrLength/2); j < arrLength; j++) {
                newGapBuffer[j] = gapBuffer[j-(arrLength/2)];
            }
            gapBuffer = newGapBuffer;
            gapEnd = gapStart + (arrLength/2);
        } 
        gapBuffer[cursor] = ch;
        cursor++;
        size++;
        gapStart++;
    }

    public void delete() {
        if(size != 0) {
            gapBuffer[cursor - 1] = '\0';
            size--;
            gapStart--;
            cursor--;
        }
    }

    public int getCursorPosition() {
        return cursor;
    }

    public void moveLeft() {
        if(cursor != 0){
            cursor -= 1;
            char temp = gapBuffer[cursor];
            for(int i = cursor + 1; i < arrLength - 1; i++) {
                gapBuffer[i] = temp;
                temp = gapBuffer[i + 1];
            }
        }
    }

    public void moveRight() {
        if(cursor != arrLength){
            char temp = gapBuffer[cursor];
            for(int i = cursor; i < arrLength - 1; i++) {
                gapBuffer[i] = temp;
                temp = gapBuffer[i - 1];
            }
            cursor += 1;
        }
    }

    public int getSize() {
        return size;
    }

    public char getChar(int i) {
        return gapBuffer[i];
    }

    @Override
    public String toString() {
        String gapBufferString = new String(gapBuffer);
        gapBufferString = gapBufferString.replaceAll("\0", "");
        return gapBufferString;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        System.out.println(gapbuffer.getCursorPosition());
        gapbuffer.moveLeft();
        gapbuffer.moveRight();
        System.out.println(gapbuffer.getCursorPosition());
        String testString = gapbuffer.toString();
        System.out.println(testString);
    }
}
