package Level3;

import java.awt.*;

import javax.swing.JComponent;

/**
 * A general item class for Level 3.
 * Time Spent: 10 minutes
 * 
 * @author Lukas Li
 * @version 0.1.0
 * 
 */

public class Item extends JComponent {

    /**
     * Image of the object
     */
    private Image image;

    /**
     * If the item was collected or not
     */
    private boolean collected;

    /**
     * Constructor for the Item class.
     * 
     * @param i The image of the item.
     */

    public Item(Image i) {
        image = i;
        collected = false;

        setBounds(0, 0, 20, 20);
        setSize(20, 20);
        setOpaque(false);
    }

    /**
     * Sets the collected variable to true when the player has collected the item
     * and removes the item from the scene
     */
    public void collect() {
        collected = true;
        // Make image transparent and unable to be picked up
    }

    /**
     * Draws the items to the Game Panel.
     *
     * @param g the Graphics context in which to paint
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getBackground());
        g.drawImage(image, 0, 0, 20, 20, null);
    }
}