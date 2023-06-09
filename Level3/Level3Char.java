package Level3;

import javax.swing.JComponent;

import Helper.DragAndDrop;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

/**
 * Character class that will be on screen for the Level 2
 * Will be implemented to be movable by the arrow keys and to grab the items
 * Time Spent: ten minutes
 * 
 * 
 * @author Alex Zhu
 * @version 0.3.0
 * @date 06/04/2023
 * 
 */

public class Level3Char extends JComponent{
    /**
     * X coordinates of the top left corner of the component
     */
    public int x = 0;

    /**
     * Y coordinates of the top left corner of the component
     */
    public int y = 0;

    public int row;
    public int column;

    /**
     * Constructor for the Level3Char class
     */
    public Level3Char() {
        row=0;
        column=11;
        setBounds(0, 0, 100, 100);
        setSize(100, 100);
        setOpaque(false);
        setLocation(column*20,row*20+250);
    }

    /**
     * Draws the character to the Game Panel.
     *
     * @param g the Graphics context in which to paint
     */
    public void paintComponent(Graphics g) {
        // Paint method just draws a 400 by 400 red square, with image specified
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(0, 0, 20, 20);

    }
}