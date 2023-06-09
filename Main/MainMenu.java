package Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The MainMenu class will create the screen of the main menu
 * Time Spent: 1 hour
 * 
 * @author Alex Zhu
 * @version 0.1.0
 * @date 05/16/2023
 */

public class MainMenu implements ActionListener {

    /**
     * Buttons that will be on the Main Menu
     */
    JButton level1 = new JButton("Level 1");
    JButton level2 = new JButton("Level 2");
    JButton level3 = new JButton("Level 3");
    JButton credits = new JButton("Credits");
    JButton exit = new JButton("Exit");

    /**
     * The frame that will be passed to the Main class
     */
    JInternalFrame frame;

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

        innerPanel = new Panel();
        innerPanel.setLayout(null);

        frame.add(innerPanel);

        frame.setSize(1920, 1080);
        frame.setVisible(true);

        level1.addActionListener(this);
        level2.addActionListener(this);
        level3.addActionListener(this);
        credits.addActionListener(this);
        exit.addActionListener(this);



        innerPanel.add(level1);
        innerPanel.add(level2);
        level1.setSize(new Dimension(600, 50));
        level2.setSize(new Dimension(600, 50));
        level1.setLocation(405, 300);
        level2.setLocation(405, 375);
        
        addButton(level1, 280, 300);
        addButton(level2, 280, 375);
        addButton(level3, 280, 450);
        addButton(credits,280, 525);
        addButton(exit, 280, 600);

        return frame;
    }

    /**
     *  Adds a button to the innerPanel
     * 
     * @param jb the button to be added to the innerPanel
     * @param x the x-coordinate of the upper left corner of the button
     * @param y the y-coordinate of the upper left corner of the button
     */
    public void addButton(JButton jb, int x, int y){
        innerPanel.add(jb);
        jb.setSize(new Dimension(600, 50));
        jb.setLocation(x,y);
    }

    /**
     * Panel class to hold all drawings and components
     */
    public class Panel extends JPanel{
        /**
         * Draws the main menu text to the Game Panel.
         *
         * @param g the Graphics context in which to paint
         */
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setFont(new Font("Courier New", Font.PLAIN, 100));
            g.drawString("Main Menu",310,200);
        }
    }


    /**
     * Action listener for the button on level1, button for level 2 brings to the
     * 2nd level
     * 
     * @param e the action event coming from the menu buttons
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == level1)
            Main.screenNum = 4;
        else if (e.getSource() == level2)
            Main.screenNum = 10;
        else if (e.getSource() == level3)
            Main.screenNum = 14;
        else if ( e.getSource()==credits)
            Main.screenNum=17;
        else if (e.getSource() == exit)
            System.exit(0);
    }
}