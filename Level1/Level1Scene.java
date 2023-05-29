package Level1;

import javax.swing.*;
import Helper.TextBox;
import java.awt.*;
import java.util.ArrayList;

/**
 * Level 1 scene class. Draws all the text boxes and buttons required for each scene.
 * Time Spent: 2 hours
 * 
 * @author Lukas Li
 * @version 0.1.0
 * @date 05/15/2023
 */
public class Level1Scene extends JComponent{

    /**
     * Buttons used in the scene
     */
    private JButton[] buttons;

    /**
     * Textboxes in each scene
     */
    private TextBox[] textBoxes;

    /**
     * Constructor for the Level1Scene.
     * 
     * @param buttonTexts The texts to be displayed on the buttons.
     * @param initial The initial text shown at the top of the screen, introducing the player to the scenario.
     * @param choices The text blurbs shown at the bottom of each choice after the player selects one, indicating if they are correct or not.
     * @param info The info blurb shown at the bottom of the screen after the player completes the scenario.
     */
    public Level1Scene(Image[] images, String initial, String[] choices, String info) {
        buttons = new JButton[2];
        buttons[0] = createButton(images[0]);
        buttons[1] = createButton(images[1]);
        
        textBoxes = new TextBox[4];
        textBoxes[0] = new TextBox(0, 0, 1280, 25, initial);
        textBoxes[1] = new TextBox(200, 600, 300, 25, choices[0]);
        textBoxes[2] = new TextBox(780, 600, 300, 25, choices[1]);
        textBoxes[3] = new TextBox(0, 896, 1280, 25, info);
    }


    public JButton createButton(Image i) {
        JButton button = new JButton();
        button.setBounds(50, 50, i.getWidth(null), i.getHeight(null));
        try {
            button.setIcon(new ImageIcon(i));
            return button;
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    /**
     * Paint method to draw all text boxes and buttons.
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
            for (int i = 0; i < text.size(); i++) {
                g.drawString(text.get(i), coords[0], coords[1]+(i+1)*fontSize);
            }
        }
        
        // Draws the buttons
        buttons[0].setBounds(200, 250, 300, 300);
        buttons[1].setBounds(780, 250, 300, 300);
        for (JButton button : buttons) {
            add(button);
        }
    }
}
