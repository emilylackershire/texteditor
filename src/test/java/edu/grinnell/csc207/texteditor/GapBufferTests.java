package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class GapBufferTests {
    /**
     * test one for insert
     */
    @Test
    public void insertOneTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        String testString = gapbuffer.toString();
        assertEquals("h", testString);
    }

     /**
     * test two for insert
     */
    @Test
    public void insertTwoTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.insert('i');
        String testString = gapbuffer.toString();
        assertEquals("hi", testString);
    }

     /**
     * test one for delete
     */
    @Test
    public void deleteOneTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.insert('i');
        gapbuffer.delete();
        String testString = gapbuffer.toString();
        assertEquals("h ", testString);
    }

     /**
     * test two for delete
     */
    @Test
    public void deleteTwoTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.insert('i');
        gapbuffer.insert('!');
        gapbuffer.delete();
        String testString = gapbuffer.toString();
        assertEquals("hi", testString);
    }

    /**
     * test one for getCursorPosition
     */
    @Test
    public void positionOneTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.getCursorPosition();
        assertEquals(1, gapbuffer.getCursorPosition());
    }

     /**
     * test two for getCursorPosition
     */
    @Test
    public void positionTwoTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.insert('i');
        gapbuffer.insert('!');
        assertEquals(3, gapbuffer.getCursorPosition());
    }

    /**
     * test one for moveLeft
     */
    @Test
    public void leftOneTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.getCursorPosition();
        gapbuffer.moveLeft();
        assertEquals(0, gapbuffer.getCursorPosition());
    }

     /**
     * test two for moveLeft
     */
    @Test
    public void leftTwoTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.insert('i');
        gapbuffer.insert('!');
        gapbuffer.moveLeft();
        assertEquals(2, gapbuffer.getCursorPosition());
    }

    /**
     * test one for moveRight
     */
    @Test
    public void rightOneTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.moveLeft();
        gapbuffer.moveRight();
        assertEquals(1, gapbuffer.getCursorPosition());
    }

     /**
     * test two for moveRight
     */
    @Test
    public void rightTwoTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.insert('i');
        gapbuffer.insert('!');
        gapbuffer.moveLeft();
        gapbuffer.moveRight();
        assertEquals(3, gapbuffer.getCursorPosition());
    }
    
    /**
     * test one for size
     */
    @Test
    public void sizeOneTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.getCursorPosition();
        assertEquals(1, gapbuffer.getSize());
    }

     /**
     * test two for size
     */
    @Test
    public void sizeTwoTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.insert('i');
        gapbuffer.insert('!');
        assertEquals(3, gapbuffer.getSize());
    }

    /**
     * test one for size
     */
    @Test
    public void getCharOneTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        assertEquals('h', gapbuffer.getChar(0));
    }

     /**
     * test two for size
     */
    @Test
    public void getCharTwoTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.insert('i');
        gapbuffer.insert('!');
        assertEquals('!', gapbuffer.getChar(2));
    }

    @Property
    public boolean examplePropertyTest(@ForAll @IntRange(min = 1, max = 10) int sz) {
        char ch = 'e';
        GapBuffer gapbuffer = new GapBuffer();
        for (int i = 0; i < sz; i++) {
            gapbuffer.insert(ch);
        }
        return gapbuffer.getChar(sz - 1) == ch;
    }
}
