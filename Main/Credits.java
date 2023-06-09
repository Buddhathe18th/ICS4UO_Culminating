package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Credit class to give credit to the developers
 * Time spent: 30 minutes
 * 
 * @author Lukas Li
 * @version 1.0.0
 * @date 06/09/23
 */

public class Credits implements ActionListener {

    /**
     * Frane to be displayed
     */
    public JInternalFrame frame;

    /**
     * JPanel to hold all content
     */
    public Panel innerPanel;

    /**
     * Button to go to Main Menu
     */
    private JButton mainMenu;

    /**
     * Creates the frame to be displayed
     * @return The frane to be displayed
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

        mainMenu = new JButton("Main Menu");
        mainMenu.addActionListener(this);

        innerPanel.add(mainMenu);
        mainMenu.setSize(new Dimension(600, 50));
        mainMenu.setLocation(305, 505);

        return frame;
    }

    /**
     * Panel class to hold all drawings and components
     */
    public class Panel extends JPanel {

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

            Image[] iArr = new Image[1];
            try {
                iArr[0] = ImageIO.read(new File("Main\\logo.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            g.drawImage(iArr[0], 500, 100, 200, 150, null);

            g.setFont(new Font("Courier New", Font.PLAIN, 50));
            g.drawString("LC Studios", 450, 330);
            g.setFont(new Font("Courier New", Font.PLAIN, 70));
            g.drawString("Race Against Time", 245, 430);
            g.setFont(new Font("Courier New", Font.PLAIN, 20));
            g.drawString("Developers: Alex Zhu, Lukas Li", 400, 490);
        }
    }

    /**
     * Action listener
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.screenNum = 3;

    }
}