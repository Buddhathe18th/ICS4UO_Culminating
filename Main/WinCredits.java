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
    public WinCredits() {}

    Panel innerPanel;
    
    /**
     * Returns the frame to be displayed on the main menu screen. Currently
     * unfinished, button for Level 1 will bring you to the Title Screen
     * 
     * @return the frame to be displayed
     */

    public JInternalFrame frame() {
        frame = new JInternalFrame("",false,false,false,false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);
        frame.setLayout(null);
        
    
        
        frame.getContentPane().setFocusable(false);
        frame.setFocusable(false);

        frame.addKeyListener(this);
        innerPanel = new Panel();
        innerPanel.add(t);//TODO: Add drawing
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
            setSize(1200, 900);
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
            g.drawImage(iArr[0], 0, 0, 1185, 951, null);

            g.setFont(new Font("Courier New", Font.PLAIN, 50));
            g.drawString("LC Studios", 450, 330);
            g.setFont(new Font("Courier New", Font.PLAIN, 70));
            g.drawString("Race Against Time", 245, 430);
            g.setFont(new Font("Courier New", Font.PLAIN, 20));
            g.drawString("Developers: Alex Zhu, Lukas Li", 400, 490);
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