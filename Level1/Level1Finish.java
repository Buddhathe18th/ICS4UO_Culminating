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
import javax.swing.BorderFactory;
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
        
        buttonL2.setBackground(new Color(70, 100, 200));
        buttonL2.setForeground(Color.WHITE);
        buttonL2.setFocusPainted(false);
        buttonL2.setFont(new Font("Tahoma", Font.BOLD, 24));
        buttonL2.setBorder(BorderFactory.createLineBorder(new Color(50, 70, 150), 3));
        mainMenu.setBackground(new Color(70, 100, 200));
        mainMenu.setForeground(Color.WHITE);
        mainMenu.setFocusPainted(false);
        mainMenu.setFont(new Font("Tahoma", Font.BOLD, 24));
        mainMenu.setBorder(BorderFactory.createLineBorder(new Color(50, 70, 150), 3));

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
}