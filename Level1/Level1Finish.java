package Level1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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

public class Level1Finish implements ActionListener {

    /**
     * The drawing that will be on the screen
     */
    Drawing draw = new Drawing();

    Panel innerPanel = new Panel();

    /**
     * The frame that will be passed to the Main class
     */
    JInternalFrame frame;

    TextBox t = new TextBox(0, 0, 1920, 25,
            "On the screen, two items will pop up, one will be helpful to Johnny for school work, and the other will be a distraction. Click on the items that are helpful to Johnny!\nPress enter to continue");

    JButton buttonL2;
    JButton mainMenu;

    public Level1Finish() {
        
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

        innerPanel.setLayout(null);

        frame.add(innerPanel);

        frame.setSize(1920, 1080);
        frame.setVisible(true);

        buttonL2 = new JButton("Level 2");
        mainMenu = new JButton("Main menu");
        buttonL2.addActionListener(this);
        mainMenu.addActionListener(this);

        innerPanel.add(buttonL2);
        innerPanel.add(mainMenu);
        buttonL2.setSize(new Dimension(600, 50));
        mainMenu.setSize(new Dimension(600, 50));
        buttonL2.setLocation(405, 300);
        mainMenu.setLocation(405, 375);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonL2) {
            Main.screenNum = 10;
        } else if (e.getSource() == mainMenu) {
            Main.screenNum = 3;
        }
    }

    public class Panel extends JPanel {
        /**
         * Paints the background onto the screen
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Image[] iArr = new Image[1];
            try {
                iArr[0] = ImageIO.read(new File("Level2\\bin.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            //The two bins

            g.drawImage(iArr[0], 0, 500, 200, 180, null);
            g.drawImage(iArr[0], 1220, 500, 200, 180, null);

            Image[] iArr1 = new Image[1];
            try {
                iArr1[0] = ImageIO.read(new File("Level2\\table.png"));
            } catch (IOException e) {
                System.out.println("broken");
            }

            //The table
            g.drawImage(iArr1[0], 300, 130, 800, 600, null);

            g.setColor(new Color(238,238,238,140));
            g.fillRect(0,0,1920,1080);
        }
    }

}
