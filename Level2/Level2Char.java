package Level2;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

/**
 * Character class that will be on screen for the Level 3
 * Moves by arrow keys and picks up items
 * Time Spent: 1.5 hours
 * 
 * 
 * @author Alex Zhu
 * @version 1.0.0
 * 
 */

public class Level2Char extends JComponent {
    /**
     * X coordinates of the top left corner of the component
     */
    public int x = 0;

    /**
     * Y coordinates of the top left corner of the component
     */
    public int y = 0;

    /**
     * Row index in the 2d array of Maze
     */
    public int row;

    /**
     * Column index in the 2d array of Maze
     */
    public int column;

    /**
     * Constructor for the Level3Char class
     */
    public Level2Char() {
        row = 0;
        column = 11;
        setBounds(0, 0, 100, 100);
        setSize(100, 100);
        setOpaque(false);
        setLocation(column * 20 + 300, row * 20 + 250);
    }

    /**
     * Draws the character to the Game Panel.
     *
     * @param g the Graphics context in which to paint
     */
    public void paintComponent(Graphics g) {
        // Paint method just draws a 400 by 400 red square, with image specified
        super.paintComponent(g);
        Image[] iArr = new Image[1];
        try {
            iArr[0] = ImageIO.read(getClass().getResource("person.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(iArr[0], 0, 0, 20, 20, null);
    }
}