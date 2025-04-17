package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
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
        assertEquals("h", testString);
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
        gapbuffer.moveLeft();
        assertEquals(0, gapbuffer.getCursorPosition());
    }

    @Test
    public void leftThreeTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.insert('e');
        gapbuffer.insert('l');
        gapbuffer.insert('l');
        gapbuffer.insert('o');
        gapbuffer.moveLeft();
        gapbuffer.moveLeft();
        gapbuffer.moveLeft();
        assertEquals(2, gapbuffer.getCursorPosition());
    }

    @Test
    public void leftManyTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.moveLeft();
        gapbuffer.moveLeft();
        gapbuffer.moveLeft();
        gapbuffer.moveLeft();
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
        assertEquals(0, gapbuffer.getCursorPosition());
    }

    @Test
    public void rightManyTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.insert('i');
        gapbuffer.insert('!');
        gapbuffer.moveLeft();
        gapbuffer.moveRight();
        gapbuffer.moveRight();
        gapbuffer.moveRight();
        gapbuffer.moveRight();
        gapbuffer.moveRight();
        assertEquals(3, gapbuffer.getCursorPosition());
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

    @Test
    public void deleteZero() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.delete();
        assertEquals("", gapbuffer.toString());
    }

    @Test
    public void leftAlreadyOnZero() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.moveLeft();
        gapbuffer.moveLeft();
        gapbuffer.moveLeft();
        gapbuffer.moveLeft();
        gapbuffer.moveLeft();
        gapbuffer.moveLeft();
        assertEquals(0, gapbuffer.getCursorPosition());
    }

    @Test
    public void rightAlreadyOnMax() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.moveRight();
        gapbuffer.moveRight();
        gapbuffer.moveRight();
        gapbuffer.moveRight();
        gapbuffer.moveRight();
        assertEquals(1, gapbuffer.getCursorPosition());
    }

    @Test
    public void deleteFrontTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.insert('i');
        gapbuffer.insert('!');
        gapbuffer.moveLeft();
        gapbuffer.moveLeft();
        gapbuffer.delete();
        assertEquals("i!", gapbuffer.toString());
    }

    @Test
    public void longMoveTest() {
        GapBuffer gapbuffer = new GapBuffer();
        gapbuffer.insert('h');
        gapbuffer.insert('i');
        gapbuffer.insert('!');
        gapbuffer.insert('e');
        gapbuffer.insert('m');
        gapbuffer.insert('i');
        gapbuffer.insert('l');
        gapbuffer.insert('y');
        gapbuffer.moveLeft();
        gapbuffer.moveLeft();
        gapbuffer.moveLeft();
        gapbuffer.moveLeft();
        gapbuffer.moveLeft();
        gapbuffer.moveLeft();
        gapbuffer.moveRight();
        gapbuffer.delete();
        assertEquals("h!emily", gapbuffer.toString());
    }

    @Test
    @DisplayName("Gap: hello end-to-end")
    public void helloExampleTest() {
        GapBuffer buffer = new GapBuffer();
        buffer.insert('h');
        buffer.insert('e');
        buffer.insert('l');
        buffer.insert('l');
        buffer.insert('o');
        buffer.insert(' ');
        buffer.insert('w');
        buffer.insert('o');
        buffer.insert('r');
        buffer.insert('l');
        buffer.insert('d');
    
        buffer.moveLeft();
        buffer.moveLeft();
        buffer.moveLeft();
        buffer.moveLeft();
        buffer.moveLeft();
        buffer.moveLeft();
        buffer.insert('!');
    
        buffer.moveLeft();
        buffer.delete();
        buffer.delete();
        buffer.delete();
        buffer.delete();
        buffer.delete();
    
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        assertEquals("abc! world", buffer.toString());
    }

    
        private GapBuffer makeBufferWith(String s) {
            GapBuffer buf = new GapBuffer();
            for (int i = 0; i < s.length(); i++) {
                buf.insert(s.charAt(i));
            }
            return buf;
        }
    

    @Test
    @DisplayName("Gap: empty")
    public void emptyBufTest() {
        GapBuffer buf = makeBufferWith("");
        assertEquals(0, buf.getSize(), "size");
        assertEquals(0, buf.getCursorPosition(), "cursor");
    }

    @Test
    @DisplayName("Gap: cursor movement")
    public void cursorMovementTest() {
        GapBuffer buf = makeBufferWith("abc");
        assertEquals(3, buf.getCursorPosition(), "initial cursor");
        buf.moveLeft();
        assertEquals(2, buf.getCursorPosition(), "after L");
        buf.moveLeft();
        assertEquals(1, buf.getCursorPosition(), "after LL");
        buf.moveLeft();
        assertEquals(0, buf.getCursorPosition(), "after LLL");
        buf.moveLeft();
        assertEquals(0, buf.getCursorPosition(), "after LLLL");
        buf.moveRight();
        assertEquals(1, buf.getCursorPosition(), "after LLLLR");
        buf.moveRight();
        assertEquals(2, buf.getCursorPosition(), "after LLLLRR");
        buf.moveRight();
        assertEquals(3, buf.getCursorPosition(), "after LLLLRRR");
        buf.moveRight();
        assertEquals(3, buf.getCursorPosition(), "after LLLLRRRR");
    }

    @Test
    @DisplayName("Gap: insert middle")
    public void cursorInsertMiddleTest() {
        GapBuffer buf = makeBufferWith("abc");
        buf.moveLeft();
        buf.moveLeft();
        buf.insert('!');
        buf.insert('!');
        assertEquals(5, buf.getSize(), "size");
        assertEquals(3, buf.getCursorPosition(), "cursor");
        assertEquals("a!!bc", buf.toString(), "contents");
    }

    @Test
    @DisplayName("Gap: delete middle")
    public void cursorDeleteMiddleTest() {
        GapBuffer buf = makeBufferWith("abc");
        buf.moveLeft();
        buf.delete();
        buf.delete();
        assertEquals(1, buf.getSize(), "size");
        assertEquals(0, buf.getCursorPosition(), "cursor");
        assertEquals("c", buf.toString(), "contents");
    }

    @Test
    @DisplayName("Gap: insert front")
    public void cursorInsertFrontTest() {
        GapBuffer buf = makeBufferWith("abc");
        for (int i = 0; i < 3; i++) {
            buf.moveLeft();
        }
        buf.insert('!');
        buf.insert('!');
        assertEquals(5, buf.getSize(), "size");
        assertEquals(2, buf.getCursorPosition(), "cursor");
        assertEquals("!!abc", buf.toString(), "contents");
    }

    @Test
    @DisplayName("Gap: delete front")
    public void cursorDeleteFrontTest() {
        GapBuffer buf = makeBufferWith("abc");
        for (int i = 0; i < 3; i++) {
            buf.moveLeft();
        }
        buf.delete();
        assertEquals(3, buf.getSize(), "size");
        assertEquals(0, buf.getCursorPosition(), "cursor");
        assertEquals("abc", buf.toString(), "contents");
    }

    @Test
    @DisplayName("Gap: delete end")
    public void cursorDeleteEndTest() {
        GapBuffer buf = makeBufferWith("abc");
        buf.delete();
        buf.delete();
        assertEquals(1, buf.getSize(), "size");
        assertEquals(1, buf.getCursorPosition(), "cursor");
        assertEquals("a", buf.toString(), "contents");
    }

    @Test
    @DisplayName("Gap: big buffer")
    public void bigBufferTest() {
        GapBuffer buf = new GapBuffer();
        for (int i = 0; i < 16384; i++) {
            buf.insert((char) (i % 10 + '0'));
        }
        assertEquals(16384, buf.getSize(), "size");
        assertEquals(16384, buf.getCursorPosition(), "cursor");

        for (int i = 0; i < 300; i++) {
            buf.moveLeft();
        }
        buf.insert('!');
        buf.insert('!');
        buf.delete();
        assertEquals(16385, buf.getSize(), "size");
        assertEquals(16085, buf.getCursorPosition(), "cursor");
    }
}