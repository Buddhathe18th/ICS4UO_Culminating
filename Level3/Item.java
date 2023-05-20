package Level3;
import java.awt.*;

/**
 * A general item class for Level 3.
 * Time Spent: 10 minutes
 * 
 * @author Lukas Li
 * @version 0.1.0
 * @date 05/18/2023
 * 
 */

public class Item {

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

    public Item (Image i) {
        image = i;
        collected = false;
    }

    /**
     * Sets the collected variable to true when the player has collected the item and removes the item from the scene
     */
    public void collect() {
        collected = true;
        //Make image transparent and unable to be picked up
    }
}
