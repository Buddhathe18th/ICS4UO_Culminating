package Level3;

import java.awt.*;

import javax.swing.JComponent;

/**
 * A general item class for Level 3.
 * Time Spent: 10 minutes
 * 
 * @author Lukas Li
 * @version 0.1.0
 * @date 05/18/2023
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
    }

    /**
     * Sets the collected variable to true when the player has collected the item
     * and removes the item from the scene
     */
    public void collect() {
        collected = true;
        // Make image transparent and unable to be picked up
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getBackground());

        g.setColor(new Color(255, 0, 0, 177));
        g.drawRect(0, 0, image.getWidth(null), image.getHeight(null));
        g.drawImage(image, 0, 0, 100, 100, null);
    }
}
