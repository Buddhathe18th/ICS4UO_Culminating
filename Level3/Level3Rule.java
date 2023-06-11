package Level3;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Helper.TextBox;

/**
 * The Level2Rule will explain how to play level 2 to the user
 * Time Spent: 3 hour
 * 
 * @author Alex Zhu
 * @version 1.0.0
 */

public class Level3Rule implements KeyListener{

    /**
     *  The drawing that will be on the screen
     */ 
    Drawing draw = new Drawing();

    /**
     * The frame that will be passed to the Main class
     */
    JInternalFrame frame;

    Panel innerPanel;

    /**
     * Textbox on the top of the screen
     */

    TextBox t = new TextBox(0, 1, 1185, 25, "Now, Johnny is ready to work, but oh no! All of his belongings are on his table! Help Johnny by moving his character with arrow keys and clicking space to grab the items. Move all of the school-related items to the school bin and distractions to the non-school bin! Every right sort gives one point, and no deductions for wrong sorts! You want to get a score of at least 4! newLine newLine Press enter to continue");
    /**
     * Returns the frame to be displayed on the main menu screen. Currently unfinished, button for Level 1 will bring you to the Title Screen
     * @return the frame to be displayed
     */

    /**
     * Default constructor for the Level2Rule class
     */
    public Level3Rule() {}

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

    @Override
    public void keyPressed(KeyEvent e) {
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            Main.Main.screenNum++;
           }
    }
}