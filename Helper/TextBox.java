package Helper;

import javax.swing.*;
import java.util.*;

/**
 * The TextBox class allows for easy creation of text boxes
 * Time Spent: 2 hours
 * 
 * @author Lukas Li
 * @version 0.1.0
 * @date 05/15/2023
 */

public class TextBox extends JComponent {

    /**
     * The x-coordinate of the top left corner of the text box
     */
    private int x;

    /**
     * The y-coordinate of the top left corner of the text box
     */
    private int y;
    
    /**
     * The width of the text box
     */
    private int width;

    /**
     * The font size
     */
    private int fontSize;

    /**
     * Maximum number of characters in each line
     */
    private int textPerLine;

    /**
     * The lines of text that will be in each textbox
     */
    private ArrayList<String> lines;
    
    /**
     * Constructor for the TextBox class.
     * 
     * @param x1 The x-coordinate of the top left corner of the text box
     * @param y1 The y-coordinate of the top left corner of the text box
     * @param w The width of the text box
     * @param f The size of the font
     * @param t The text to be shown in the text box
     */
    public TextBox(int x1, int y1, int w, int f, String t) {
        x = x1;
        y = y1;
        width = w;
        fontSize = f;
        textPerLine = (int)(w*1.43/fontSize);
        String[] text = t.split(" ");
        int maxLen = textPerLine;
        lines = new ArrayList<String>();

        String temp = "";
        for (String l: text) {
            if (maxLen - l.length() < 0) {
                maxLen = textPerLine;
                lines.add(temp);
                temp = "";
            }
            temp += l + " ";
            maxLen -= l.length();
        }
        lines.add(temp);
    }

    /**
     * Gets the size of the font in the text box
     * @return The size of the font in the text box 
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     * Gets the coordinates of the top left corner of the text box
     * @return Int array [x, y], the x and y coordinates of the text box
     */
    public int[] getCoords() {
        return new int[] {x, y};
    }

    /**
     * Gets the width of the text box
     * @return The width of the text box
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the lines of text in the text box
     * @return The lines of text in the text box, seperated into different indices of an ArrayList
     */
    public ArrayList<String> getText() {
        return lines;
    }
}