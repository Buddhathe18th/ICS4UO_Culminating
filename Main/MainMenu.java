package Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The MainMenu class will create the screen of the main menu
 * Time Spent: 2 hour
 * 
 * @author Alex Zhu
 * @version 1.0.0
 */
   
public class MainMenu implements ActionListener {

    /**
     * Buttons that will be on the Main Menu
     */
    JButton level1 = new JButton("Level 1"), level2 = new JButton("Level 2"), level3 = new JButton("Level 3"), credits = new JButton("Credits"), exit = new JButton("Exit");

    /**
     * The frame that will be passed to the Main class
     */
    JInternalFrame frame;

    /**
     * Panel to display everything
     */
    Panel innerPanel;
    
    /**
     * Default constructor for the MainMenu class
     */
    public MainMenu() {}

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
     * Add button methods
     * @param jb JButton to add
     * @param x Top left coordinate of x
     * @param y Top left coordinate of y
     */
    public void addButton(JButton jb, int x, int y){
        innerPanel.add(jb);
        jb.setSize(new Dimension(600, 50));
        jb.setLocation(x,y);
    }

    /**
     * JPanel class to have all drawing and components
     */
    public class Panel extends JPanel{

        /**
         * Default constructor for the Panel class
         */
        public Panel() {
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setFont(new Font("Courier New", Font.PLAIN, 100));
            g.drawString("Main Menu",310,200);
        }
    }


    /**
     * Action listener for the button on level1, button for level 2 brings to the
     * 2nd level
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