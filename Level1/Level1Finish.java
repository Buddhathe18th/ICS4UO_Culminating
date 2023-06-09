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
     * Panel containing all graphics
     */
    Panel innerPanel = new Panel();

    /**
     * The frame that will be passed to the Main class
     */
    JInternalFrame frame;

    TextBox t = new TextBox(1, 0, 1185, 25,
            "You successfully helped Johnny through those tricky situations! Give yourself a pat on the back. ");

    JButton buttonL2;
    JButton mainMenu;

    /**
     * Default constructor for the Level1Finish class
     */
    public Level1Finish() {}

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

        innerPanel.add(t);

        buttonL2 = new JButton("Level 2");
        mainMenu = new JButton("Main menu");
        buttonL2.addActionListener(this);
        mainMenu.addActionListener(this);




        innerPanel.add(buttonL2);
        innerPanel.add(mainMenu);
        buttonL2.setSize(new Dimension(600, 50));
        mainMenu.setSize(new Dimension(600,50));
        buttonL2.setLocation(305, 300);
        mainMenu.setLocation(305, 375);

        return frame;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("click");
        if (e.getSource() == buttonL2) {
            Main.screenNum = 10;
            System.out.println(Main.screenNum);
        } else if (e.getSource() == mainMenu) {
            Main.screenNum = 3;
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

            Image[] iArr = new Image[2];
            try {
                iArr[0] = ImageIO.read(new File("Level3\\Images\\schoolBin.png"));
                iArr[1] = ImageIO.read(new File("Level3\\Images\\nonschoolBin.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            //The two bins

            g.drawImage(iArr[0], 0, 500, 200, 180, null);
            g.drawImage(iArr[1], 950, 500, 200, 180, null);

            Image[] iArr1 = new Image[1];
            try {
                iArr1[0] = ImageIO.read(new File("Level3\\Images\\table.png"));
            } catch (IOException e) {
                System.out.println("broken");
            }

            //The table
            g.drawImage(iArr1[0], 200, 180, 800, 450, null);

            g.setColor(new Color(238,238,238,140));
            g.fillRect(0,0,1920,1080);
        }
    }
}