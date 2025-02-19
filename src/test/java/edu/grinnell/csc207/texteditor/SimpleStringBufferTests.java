package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class SimpleStringBufferTests {
    /**
     * test one for insert
     */
    @Test
    public void insertOneTest() {
        SimpleStringBuffer stringbuffer = new SimpleStringBuffer();
        stringbuffer.insert('h');
        String testString = stringbuffer.toString();
        assertEquals("h", testString);
    }

     /**
     * test two for insert
     */
    @Test
    public void insertTwoTest() {
        SimpleStringBuffer stringbuffer = new SimpleStringBuffer();
        stringbuffer.insert('h');
        stringbuffer.insert('i');
        String testString = stringbuffer.toString();
        assertEquals("hi", testString);
    }

     /**
     * test one for delete
     */
    @Test
    public void deleteOneTest() {
        SimpleStringBuffer stringbuffer = new SimpleStringBuffer();
        stringbuffer.insert('h');
        stringbuffer.insert('i');
        stringbuffer.delete();
        String testString = stringbuffer.toString();
        assertEquals("h", testString);
    }

     /**
     * test two for delete
     */
    @Test
    public void deleteTwoTest() {
        SimpleStringBuffer stringbuffer = new SimpleStringBuffer();
        stringbuffer.insert('h');
        stringbuffer.insert('i');
        stringbuffer.insert('!');
        stringbuffer.delete();
        String testString = stringbuffer.toString();
        assertEquals("hi", testString);
    }

    /**
     * test one for getCursorPosition
     */
    @Test
    public void positionOneTest() {
        SimpleStringBuffer stringbuffer = new SimpleStringBuffer();
        stringbuffer.insert('h');
        stringbuffer.getCursorPosition();
        assertEquals(1, stringbuffer.getCursorPosition());
    }

     /**
     * test two for getCursorPosition
     */
    @Test
    public void positionTwoTest() {
        SimpleStringBuffer stringbuffer = new SimpleStringBuffer();
        stringbuffer.insert('h');
        stringbuffer.insert('i');
        stringbuffer.insert('!');
        assertEquals(3, stringbuffer.getCursorPosition());
    }

    /**
     * test one for moveLeft
     */
    @Test
    public void leftOneTest() {
        SimpleStringBuffer stringbuffer = new SimpleStringBuffer();
        stringbuffer.insert('h');
        stringbuffer.getCursorPosition();
        stringbuffer.moveLeft();
        assertEquals(0, stringbuffer.getCursorPosition());
    }

     /**
     * test two for moveLeft
     */
    @Test
    public void leftTwoTest() {
        SimpleStringBuffer stringbuffer = new SimpleStringBuffer();
        stringbuffer.insert('h');
        stringbuffer.insert('i');
        stringbuffer.insert('!');
        stringbuffer.moveLeft();
        assertEquals(2, stringbuffer.getCursorPosition());
    }

    /**
     * test one for moveRight
     */
    @Test
    public void rightOneTest() {
        SimpleStringBuffer stringbuffer = new SimpleStringBuffer();
        stringbuffer.insert('h');
        stringbuffer.getCursorPosition();
        stringbuffer.moveLeft();
        stringbuffer.moveRight();
        assertEquals(1, stringbuffer.getCursorPosition());
    }

     /**
     * test two for moveRight
     */
    @Test
    public void rightTwoTest() {
        SimpleStringBuffer stringbuffer = new SimpleStringBuffer();
        stringbuffer.insert('h');
        stringbuffer.insert('i');
        stringbuffer.insert('!');
        stringbuffer.moveLeft();
        stringbuffer.moveRight();
        assertEquals(3, stringbuffer.getCursorPosition());
    }
    
    /**
     * test one for size
     */
    @Test
    public void sizeOneTest() {
        SimpleStringBuffer stringbuffer = new SimpleStringBuffer();
        stringbuffer.insert('h');
        stringbuffer.getCursorPosition();
        assertEquals(1, stringbuffer.getSize());
    }

     /**
     * test two for size
     */
    @Test
    public void sizeTwoTest() {
        SimpleStringBuffer stringbuffer = new SimpleStringBuffer();
        stringbuffer.insert('h');
        stringbuffer.insert('i');
        stringbuffer.insert('!');
        assertEquals(3, stringbuffer.getSize());
    }

    /**
     * test one for size
     */
    @Test
    public void getCharOneTest() {
        SimpleStringBuffer stringbuffer = new SimpleStringBuffer();
        stringbuffer.insert('h');
        assertEquals('h', stringbuffer.getChar(0));
    }

     /**
     * test two for size
     */
    @Test
    public void getCharTwoTest() {
        SimpleStringBuffer stringbuffer = new SimpleStringBuffer();
        stringbuffer.insert('h');
        stringbuffer.insert('i');
        stringbuffer.insert('!');
        assertEquals('!', stringbuffer.getChar(2));
    }

    @Property
    public boolean examplePropertyTest(@ForAll @IntRange(min = 1, max = 10) int sz) {
        char ch = 'e';
        SimpleStringBuffer stringbuffer = new SimpleStringBuffer();
        for (int i = 0; i < sz; i++) {
            stringbuffer.insert(ch);
        }
        return stringbuffer.getChar(sz - 1) == ch;
    }
}

