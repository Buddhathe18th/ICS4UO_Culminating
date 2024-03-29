package Level2;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Helper.TextBox;

/**
 * Level 3 rule page to explain how to play level 3
 * Time Spent: 1 hour
 * 
 * @author Alex Zhu, Lukas Li
 * @version 1.0.0
 */

public class Level2Rule implements KeyListener {

    /**
     * The drawing that will be on the screen
     */
    Drawing draw = new Drawing();

    /**
     * The frame that will be passed to the Main class
     */
    JInternalFrame frame;

    /**
     * JPanel to hold drawings and textboxes
     */
    Panel innerPanel;

    /**
     * The info text displayed before the maze
     */
    TextBox t = new TextBox(0, 1, 1185, 25,
            "Almost there! Johnny is at his door, ready to leave, but he needs to pack himself up to go to school, but where is his stuff? He's left it all around his house, and his belongings are all around the floor! Use the arrow keys to move around, you have 150 seconds to collect all of Johnny's items and then leave the house. Can you help Johnny navigate the room to collect all of the things on his checklist? newLine newLine Press enter to continue...");

    /**
     * Default constructor for the Level3Rule class
     */
    public Level2Rule() {
    }

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
     * Drawing class for paiting text onto the Main Menu screen
     */
    class Drawing extends Canvas {
        public void paint(Graphics g) {
            g.setFont(new Font("Courier New", Font.PLAIN, 80));
            g.drawString("Race Against Time", 0, 0);
            g.setColor(new Color(255, 190, 50));
        }
    }

    /**
     * Key Listener methods
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Key Listener methods
     */
    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     * Panel class to hold all of the items, maze and character
     */
    public class Panel extends JPanel {

        /**
         * Default constructor for the Panel class
         */
        public Panel() {
        }

        /**
         * Draws the text boxes to the Game Panel.
         *
         * @param g the Graphics context in which to paint
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
     * Key Listener methods
     */
    @Override
    public void keyReleased(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Main.Main.screenNum = 11;
        }
    }
}