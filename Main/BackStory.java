package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import Helper.TextBox;
import Main.Main;

public class BackStory {

    /**
     * Inner panel to hold all content
     */
    Panel innerPanel = new Panel();

    /**
     * The frame that will be passed to the Main class
     */
    JInternalFrame frame;

    /**
     * Textbox to hold the information
     */
    TextBox t = new TextBox(1, 0, 1185, 25,
            "Johnny is an 8th grade student at Silver Oak Middle School. Each day he spends hours playing video games. He’s currently plagued by the greatest disease of this generation… newLine newLine PROCRASTINATION                                      Press enter to continue");


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

        innerPanel.setLayout(null);
        frame.getContentPane().setFocusable(false);

        frame.add(innerPanel);
        innerPanel.add(t);

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
        }

        /**
         * Paints the background onto the screen
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Image[] iArr = new Image[4];
            try {
                iArr[0] = ImageIO.read(new File("Main\\gaming.png"));

            } catch (IOException e) {
                e.printStackTrace();
            }

            g.drawImage(iArr[0], 140, 130, 1280, 680, null);

        }
    }
}