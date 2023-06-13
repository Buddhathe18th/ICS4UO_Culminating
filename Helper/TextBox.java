package Helper;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.*;

/**
 * The TextBox class allows for easy creation of text boxes
 * Time Spent: 2 hours
 * 
 * @author Lukas Li
 * @version 0.1.0
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
        textPerLine = (int)(w*1.43/fontSize)-5;
        String[] text = t.split(" ");
        int maxLen = textPerLine;
        lines = new ArrayList<String>();

        String temp = "";
        for (String l: text) {
            if(l.equals("newLine")){
                maxLen = textPerLine;
                lines.add(temp);
                temp = "";
                continue;
            }
            else if (maxLen - l.length() < 0) {
                maxLen = textPerLine;
                lines.add(temp);
                temp = "";
            }
            temp += l + " ";
            maxLen -= l.length();
        }
        lines.add(temp);

        setBounds(x, y, width+1000, (int) (lines.size()+0.25)*fontSize+10);
        setLocation(x, y);
        setSize(width, (int)(lines.size()+0.25)*fontSize+10);
        setOpaque(false);
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
    
    /**
     * Sets the text to be shown in the text box.
     * 
     * @param text The text to be shown in the text box
     */
    public void setText(String text) {
        lines.clear();
        String[] words = text.split(" ");
        int maxLen = textPerLine;
        String temp = "";

        for (String word : words) {
            if(word.equals("newLine")){
                maxLen = textPerLine;
                lines.add(temp);
                temp = "";
                continue;
            }
            else if (maxLen - word.length() < 0) {
                maxLen = textPerLine;
                lines.add(temp);
                temp = "";
            }
            
            temp += word + " ";
            maxLen -= word.length();
        }
        lines.add(temp);
    }
    
    /**
     * Draws the text boxes to the Game Panel.
     *
     * @param g the Graphics context in which to paint
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, width, (int)((getText().size()+0.25)*fontSize)+10);
        g.setFont(new Font("Courier New", Font.PLAIN, fontSize));
        g.setColor(Color.black);
        // Draws the text in the text boxes, line by line
        for (int i = 0; i < getText().size(); i++) g.drawString(getText().get(i), getCoords()[0], getCoords()[1]+(i+1)*fontSize);
    }
}