package Level1;

import javax.imageio.ImageIO;
import javax.swing.*;
import Helper.TextBox;
import Helper.TextBoxCentered;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

/**
 * Level 1 scene class. Draws all the text boxes and buttons required for each scene.
 * Time Spent: 6 hours
 * 
 * <h2>Modifications</h2>
 * Added more text to each scene, fixed textbox positioning
 *  
 * @author Lukas Li
 * @version 1.0.0
 */
public class Level1Scene extends Level1 implements ActionListener, KeyListener {

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
    private Panel innerPanel = new Panel();

    /**
     * Constructor for the Level1Scene.
     * 
     * @param images The images to be displayed on the buttons.
     * @param initial The initial text shown at the top of the screen, introducing the player to the scenario.
     * @param choices The text blurbs shown at the bottom of each choice after the player selects one, indicating if they are correct or not.
     * @param info The info blurb shown at the bottom of the screen after the player completes the scenario.
     * @param choiceNames The names of the choices for the options
     */
    public Level1Scene(Image[] images, String initial, String[] choices, String info, String[] choiceNames) {
        pressed = false;
        textBoxes = new TextBox[6];
        textBoxes[0] = new TextBox(0, 0, 1180, 25, initial);
        textBoxes[1] = new TextBox(150, 600, 400, 25, choices[0]);
        textBoxes[2] = new TextBox(730, 600, 400, 25, choices[1]);
        textBoxes[3] = new TextBoxCentered(0, 925, 1180, 25, info, "bottomleft", false, true);
        textBoxes[4] = new TextBoxCentered(150, 225, 400, 25, choiceNames[0], "bottomleft", true, false);
        textBoxes[5] = new TextBoxCentered(730, 225, 400, 25, choiceNames[1], "bottomleft", true, false);
        shownBoxes.add(textBoxes[0]);
        shownBoxes.add(textBoxes[4]);
        shownBoxes.add(textBoxes[5]);
        
        // Create and add buttons
        buttons = new JButton[2];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = createButton(images[i]);
            buttons[i].addActionListener(this);
            buttons[i].setBorderPainted(false); 
            buttons[i].setContentAreaFilled(false); 
            buttons[i].setFocusPainted(false); 
            buttons[i].setOpaque(false);
            innerPanel.add(buttons[i]);
        }

        // Maps a method to a keyboard key, here the "changeScene" key is mapped to the enter key and changes the scene when it is pressed after a button is pressed
        innerPanel.getActionMap().put("changeScene", new AbstractAction() {
            @Override
            /**
             * The action being performed when the enter key is pressed
             * 
             * @param e The action event coming from the keyboard
             */
            public void actionPerformed(ActionEvent e) {
                if (pressed) changeScene();
            }
        });
        innerPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "changeScene");
    }

    /**
     *  Makes all components and drawings that will be on the Level 1 game screen
     * 
     * @return the JInternalFrame to add to the screen
     */
    public JInternalFrame frame() {
        JInternalFrame frame = new JInternalFrame("", false, false, false, false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);
        frame.getContentPane().setBackground(Color.WHITE);

        innerPanel.setLayout(null);

        frame.add(innerPanel);

        frame.setSize(1200, 960);
        frame.setVisible(true);
        return frame;
    }

    @Override
    /**
     * The action being performed when a button is pressed
     * 
     * @param e The action event coming from a button
     */
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

    public void keyPressed(KeyEvent e) {}
    
    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) changeScene();
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
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Panel class to hold all drawings and components
     */
    public class Panel extends JPanel {

        /**
         * Default constructor for the Panel class
         */
        public Panel() {
         setOpaque(true);
         setBackground(Color.WHITE);
        }

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

            Image[] iArr = new Image[1];
            try {
                iArr[0] = ImageIO.read(getClass().getResource("background.png"));

            } catch (IOException e) {
                e.printStackTrace();
            }

            g.drawImage(iArr[0], 0, 0, 1185, 980, null);
            
            // Draws the text boxes to be shown on screen
            for (TextBox t: shownBoxes) {
                fontSize = t.getFontSize();
                width = t.getWidth();
                coords = t.getCoords();
                text = t.getText();
                g.setFont(new Font("Courier New", Font.PLAIN, fontSize));
                // Draws a rectangular box at specified coordinates
                g.setColor(Color.WHITE);
                g.fillRect(coords[0], coords[1], width, (int)((text.size()+0.25)*fontSize));
                g.setColor(Color.BLACK);
                // Borders
                g.drawRect(coords[0], coords[1], width, (int)((text.size()+0.25)*fontSize));
                // Draws the text in the text boxes, line by line
                for (int i = 0; i < text.size(); i++) g.drawString(text.get(i), coords[0], coords[1]+(i+1)*fontSize);
            }
        }
    }
}