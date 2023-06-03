package Level1;

import javax.swing.*;
import Helper.TextBox;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Level 1 scene class. Draws all the text boxes and buttons required for each scene.
 * Time Spent: 3 hours
 * 
 * <h2>Modifications</h2>
 * Added button functionality and methods allowing for the drawing of buttons
 * 
 * @author Lukas Li
 * @version 0.2.0
 * @date 05/15/2023
 */
public class Level1Scene extends Level1 implements ActionListener {

    /**
     * Buttons used in the scene
     */
    private JButton[] buttons;

    /**
     * Textboxes in each scene
     */
    private Set<TextBox> shownBoxes = new HashSet<TextBox>();

    /**
     * Textboxes in each scene
     */
    private TextBox[] textBoxes;

    /**
     * If the key to change scenes is pressed
     */
    private boolean pressed;

    
    /**
     * Panel containing all graphics
     */
    public Panel innerPanel = new Panel();

    JInternalFrame frame;

    /**
     * Constructor for the Level1Scene.
     * 
     * @param buttonTexts The texts to be displayed on the buttons.
     * @param initial The initial text shown at the top of the screen, introducing the player to the scenario.
     * @param choices The text blurbs shown at the bottom of each choice after the player selects one, indicating if they are correct or not.
     * @param info The info blurb shown at the bottom of the screen after the player completes the scenario.
     */
    public Level1Scene(Image[] images, String initial, String[] choices, String info) {
        super();
        pressed = false;
        textBoxes = new TextBox[4];
        textBoxes[0] = new TextBox(0, 0, 1280, 25, initial);
        textBoxes[1] = new TextBox(150, 600, 400, 25, choices[0]);
        textBoxes[2] = new TextBox(730, 600, 400, 25, choices[1]);
        textBoxes[3] = new TextBox(0, 896, 1280, 25, info);
        shownBoxes.add(textBoxes[0]);
        
        buttons = new JButton[2];
        buttons[0] = createButton(images[0]);
        buttons[1] = createButton(images[1]);
        innerPanel.getActionMap().put("changeScene", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pressed) {
                    changeScene();
                }
            }
        });
        innerPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "changeScene");

        // Add the buttons to the innerPanel
        for (JButton button: buttons) innerPanel.add(button);
        
        buttons[0].addActionListener(this);
        buttons[1].addActionListener(this);
    }

    /**
     *  Makes all components and drawings that will be on the Level 2 game screen
     * 
     * @return the JInternalFrame to add to the screen
     */
    public JInternalFrame frame() {
        frame = new JInternalFrame("", false, false, false, false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);

        innerPanel.setLayout(null);

        frame.add(innerPanel);

        frame.setSize(1920, 1080);
        frame.setVisible(true);
        return frame;
    }

    public void actionPerformed(ActionEvent e) {
        if (!pressed) {
            if (e.getSource() == buttons[0]) {
                shownBoxes.add( textBoxes[1]);
                shownBoxes.remove(textBoxes[2]);
            }
            if (e.getSource() == buttons[1]) {
                shownBoxes.add(textBoxes[2]);
                shownBoxes.remove(textBoxes[1]);
            }
            shownBoxes.add(textBoxes[3]);
            innerPanel.repaint();
        }
        pressed = true;
    }
    
    /**
     * Allows for the easy creation of buttons with an image on it 
     * 
     * @param i Image to be inserted into the button
     * @return button with the image on top of it
     */
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
     * Panel class to hold all drawings and components
     */
    public class Panel extends JPanel {
        /**
         * Draws the text boxes to the Game Panel.
         *
         * @param g the Graphics context in which to paint
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int fontSize;
            int width;
            int[] coords;
            ArrayList<String> text;

            // Draws the buttons
            buttons[0].setBounds(200, 250, 300, 300);
            buttons[1].setBounds(780, 250, 300, 300);
            
            // Draws the text boxes to be shown on screen
            for (TextBox t: shownBoxes) {
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
}