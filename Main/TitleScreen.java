package Main;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * The TitleScreen class will create the screen for the title screen
 * Time Spent: 45 minutes
 * 
 * @author Alex Zhu
 * @version 1.0.0
 */

public class TitleScreen implements KeyListener {

    /**
     * Elements that will be drawn on the JInternalFrame with the paint() method
     */
    private Drawing draw = new Drawing();

    /**
     * Makes all components and drawings that will be on the Title Screen
     * 
     * @return the JInternalFrame to add to the screen
     */

    /**
     * Default constructor for the TitleScreen class
     */
    public TitleScreen() {
    }

    /**
     * Creates the frame to be displayed
     * 
     * @return The frane to be displayed
     */
    public JInternalFrame frame() {

        JInternalFrame frame = new JInternalFrame("", false, false, false, false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);
        frame.add(draw);

        frame.setSize(1920, 1080);
        frame.setVisible(true);
        draw.addKeyListener(this);
        frame.addKeyListener(this);
        return frame;
    }

    /**
     * Drawing class for painting text and images onto the Title Screen
     */
    class Drawing extends Canvas {
        public void paint(Graphics g) {
            Image[] iArr = new Image[2];
            try {
                iArr[0] = ImageIO.read(getClass().getResource("logo.png"));
                iArr[1] = ImageIO.read(getClass().getResource("background.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            g.drawImage(iArr[1], 0, 0, 1300, 950, null);
            g.drawImage(iArr[0], 30, 82, 190, 150, null);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.BOLD, 70));
            g.drawString("LC Studios Presents...", 200, 200);
            g.setFont(new Font("Courier New", Font.BOLD, 50));
            g.drawString("Race Against Time", 315, 400);
            g.setFont(new Font("Courier New", Font.BOLD, 20));
            g.drawString("Press enter to continue", 400, 600);

        }
    }

    /**
     * Overidded KeyListener methods to listen for the enter key to change screens
     */

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Main.screenNum = 2;
        }
    }

    /**
     * Overidded KeyListener methods to listen for the enter key to change screens
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Main.screenNum = 2;
        }
    }

    /**
     * Overidded KeyListener methods to listen for the enter key to change screens
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Main.screenNum = 2;
        }
    }
}