package Main;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Helper.TextBox;
import Main.TitleScreen.Drawing;

/**
 * The MainMenu class will create the screen of the main menu
 * Time Spent: 1 hour
 * 
 * @author Alex Zhu
 * @version 0.1.0
 */

public class WinCredits implements KeyListener {

    /**
     * The frame that will be passed to the Main class
     */
    JInternalFrame frame;

    /**
     * Textbox of the story of the character
     */
    TextBox t = new TextBox(0, 1, 1185, 25,
            "Twenty years later... after keeping up the work habits he developed in 8th grade and prioritizing activities that matter to him, Johnny has progressed a long way. Now, Johnny is the CEO of Apple! newLine newLine Press enter to continue");

    /**
     * Default constructor for the TitleScreen class
     */
    public WinCredits() {
        Main.win1 = false;
        Main.win2 = false;
        Main.win3 = false;
    }

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
        frame.setLayout(null);

        frame.getContentPane().setFocusable(false);
        frame.setFocusable(false);

        frame.addKeyListener(this);
        innerPanel = new Panel();
        innerPanel.setLayout(null);
        innerPanel.add(t);// TODO: Add drawing
        t.setLocation(0, 0);
        frame.add(innerPanel);
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        return frame;
    }

    /**
     * Panel class to hold all drawings and components
     */
    public class Panel extends JPanel {

        /**
         * Default constructor for the Panel class
         */
        public Panel() {
            setSize(1200, 960);
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

            Image[] iArr = new Image[2];
            try {
                iArr[0] = ImageIO.read(getClass().getResource("ceo.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(iArr[0], 0, 130, 1185, 811, null);
        }
    }

    /**
     * Overidded KeyListener methods to listen for the enter key to change screens
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Overidded KeyListener methods to listen for the enter key to change screens
     */
    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     * Overidded KeyListener methods to listen for the enter key to change screens
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Main.screenNum++;
        }
    }
}