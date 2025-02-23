package edu.grinnell.csc207.texteditor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {

    /**
     * Takes in a gap buffer and adds the elements of that gapbuffer to the screen
     * @param buf - gap buffer that we are using 
     * @param screen - screen that we ar using 
     * @throws IOException - throws io exception if the screen can't refresh
     */
    public static void drawBuffer(GapBuffer buf, Screen screen) throws IOException {
        int row = 0;
        int screenWidth = 80;
        int col = 0;
    
        for (int i = 0; i < buf.getSize(); i++) {
            char ch = buf.getChar(i);
            row = i / screenWidth;
            col = i % screenWidth;
            TextCharacter text = new TextCharacter(ch);
            screen.setCharacter(row, col, text);
        }
        screen.refresh();
    }
        
    /**
     * The main entry point for the TextEditor application.
     * @param args command-line arguments.
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java TextEditor: missing a file");
            System.exit(1);
        }
    
        Screen screen = new DefaultTerminalFactory().createScreen();
        screen.startScreen();
            
        String fileName = args[0];
        Path filePath = Paths.get(fileName);
        GapBuffer gapbuffer = new GapBuffer();

        if (Files.exists(filePath)) {
            if (Files.isRegularFile(filePath)) {
                String fileString = Files.readString(filePath);
                for (int i = 0; i < fileString.length(); i++) {
                    gapbuffer.insert(gapbuffer.getChar(i));
                }
            }
        }
        drawBuffer(gapbuffer, screen);

        boolean isRunning = true;
        while (isRunning) {
            KeyStroke stroke = screen.readInput();
            KeyType key = stroke.getKeyType();
            if (key == KeyType.Character) {
                char ch = stroke.getCharacter();
                gapbuffer.insert(ch);
            } else if (key == KeyType.ArrowLeft) {
                gapbuffer.moveLeft();
            } else if (key == KeyType.ArrowRight) {
                gapbuffer.moveRight();
            } else if (key == KeyType.Backspace) {
                gapbuffer.delete();
            } else if (key == KeyType.Escape) {
                isRunning = false;
            }
            drawBuffer(gapbuffer, screen);
        }
        screen.stopScreen();
        Files.writeString(filePath, gapbuffer.toString());
    }
}
