package Level1;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Helper.TextBox;

/**
 * The MainMenu class will create the screen of the main menu
 * Time Spent: 1 hour
 * 
 * @author Alex Zhu
 * @version 0.1.0
 */

public class Level1Rule implements KeyListener {

    /**
     * The drawing that will be on the screen
     */
    Drawing draw = new Drawing();

    /**
     * The frame that will be passed to the Main class
     */
    JInternalFrame frame;

    /**
     * The info text box with instructions
     */
    TextBox t = new TextBox(1, 0, 1185, 25,
            "On the screen, two items will pop up, one will be helpful to Johnny for school work, and the other will be a distraction. Click on the items that are helpful to Johnny! Press enter to continue");

    /**
     * Default constructor for the Level1Rule class
     */
    public Level1Rule() {
    }

    /**
     * JPanel to hold the drawing and text box
     * 
     */
    Panel innerPanel;

    /**
     * Returns the frame to be displayed on the main menu screen. Currently
     * unfinished, button for Level 1 will bring you to the Title Screen
     * 
     * @return the frame to be displayed
     */
    public JInternalFrame frame() {

        frame = new JInternalFrame("", false, false, false, false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);

        innerPanel = new Panel();
        innerPanel.setLayout(null);

        frame.add(innerPanel);

        frame.setSize(1920, 1080);
        frame.setVisible(true);

        innerPanel.add(t);

        return frame;
    }

    /**
     * Drawing class for painting text onto the Main Menu screen
     */
    class Drawing extends Canvas {
        public void paint(Graphics g) {
            Image[] iArr = new Image[1];
            try {
                iArr[0] = ImageIO.read(getClass().getResource("mainBackground.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // The two bins

            g.drawImage(iArr[0], 0, 0, 150, 900, null);
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
        }

        /**
         * Paints the background onto the screen
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Image[] iArr = new Image[1];
            try {
                iArr[0] = ImageIO.read(getClass().getResource("mainBackground.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // The two bins

            g.drawImage(iArr[0], 0, 0, 1300, 951, null);
        }
    }

    /**
     * Key Listener Methods
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Key Listener Methods
     */
    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     * Key Listener Methods
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Main.Main.screenNum++;
        }
    }
}