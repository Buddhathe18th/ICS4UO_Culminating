package Level1;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Level 1 scene class. Draws all the textboxes and images required for each scene.
 * Time Spent: 2 hours
 * 
 * @author Lukas Li
 * @version 0.1.0
 * @date 05/15/2023
 * 
 */

public class Level1Scene extends JComponent{

    /**
     * Images used in the scene
     */
    private Image[] images;

    /**
     * Textboxes in each scene
     */
    private TextBox[] textBoxes;

    /**
     * Constructor for the Level1Scene.
     * 
     * @param i The 2 images to be displayed in the scenario. Not implemented yet.
     * @param initial The initial text shown at the top of the screen,introducing the player to scenario
     * @param choices The text blurbs show at the bottom of each choice after the player selects one, showing if they are correct or not 
     * @param info The info blurb show at the bottom of the screen after the player completes the scenario
     */
    public Level1Scene(/*Image[] i, */String initial, String[] choices, String info) {
        //images = i;
        textBoxes = new TextBox[4];
        textBoxes[0] = new TextBox(0, 0, 1280, 25, initial);
        textBoxes[1] = new TextBox(100, 600, 500, 25, choices[0]);
        textBoxes[2] = new TextBox(680, 600, 500, 25, choices[1]);
        textBoxes[3] = new TextBox(0, 896, 1280, 25, info);
    }

    /**
     * Pain method to draw on all textboxes and images
     */

    public void paint(Graphics g) {
        int fontSize;
        int width;
        int[] coords;
        ArrayList<String> text;

        // Draws the text boxes
        for (TextBox t: textBoxes) {
            fontSize = t.getFontSize();
            width = t.getWidth();
            coords = t.getCoords();
            text = t.getText();
            g.setFont(new Font("Courier New", Font.PLAIN, fontSize));
            // Draws a rectangular box at specified coordinates
            g.drawRect(coords[0], coords[1], width, (int)((text.size()+0.25)*fontSize));
            // Draws the text in the text boxes, line by line
            for (int i = 0; i < text.size(); i++) g.drawString(text.get(i), coords[0], coords[1]+(i+1)*fontSize);
        }
    }
}