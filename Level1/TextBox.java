package Level1;
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

class TextBox extends JComponent {
    private int x;
    private int y;
    private int width;
    private int fontSize;
    private int textPerLine;
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
        textPerLine = (int)(w*1.4/fontSize);
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

    public int getFontSize() {
        return fontSize;
    }

    public int[] getCoords() {
        return new int[] {x, y};
    }

    public int getWidth() {
        return width;
    }

    public ArrayList<String> getText() {
        return lines;
    }
}