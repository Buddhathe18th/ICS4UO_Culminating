package Level3;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Helper.DragAndDrop;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

/**
 * Character class that will be on screen for the Level 2
 * Moves around by the arrow keys and space bar to grab any items
 * Time Spent: 1 hour
 * 
 * 
 * @author Alex Zhu
 * @version 1.0.0
 * 
 */
public class CharacterHand extends JComponent {

    /**
     * Whether or not the character is grabbing an item
     */
    public boolean grab = false;

    /**
     * Object that the hand has grabbed
     */

    public static DragAndDrop grabbedObj;

    /**
     * X coordinates of the top left corner of the component
     */
    public int x = 0;

    /**
     * Y coordinates of the top left corner of the component
     */
    public int y = 0;

    /**
     * Contructor for the CharacterHand class
     */
    public CharacterHand() {
        grabbedObj = null;
        
        setBounds(0, 0, 100, 100);
        setSize(100, 100);
        setOpaque(false);

    }

    /**
     * Draws the hand to the Game Panel.
     *
     * @param g the Graphics context in which to paint
     */
    public void paintComponent(Graphics g) {
        // Paint method just draws a 400 by 400 red square, with image specified
        super.paintComponent(g);

        Image[] iArr = new Image[2];
        try {
            iArr[0] = ImageIO.read(getClass().getResource("openHand.png"));
            iArr[1] = ImageIO.read(getClass().getResource("closedHand.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!grab) {
            g.drawImage(iArr[0], 0, 0, 100, 100, null);
        } else {

            g.drawImage(iArr[1], 0, 0, 100, 100, null);
        }
    }
}
