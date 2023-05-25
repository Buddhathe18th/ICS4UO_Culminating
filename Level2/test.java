package Level2;

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

public class test implements ActionListener{
    
    /** 
     *Buttons that will be on the Main Menu
    */
    JButton level1 = new JButton("Level 1");
    JButton level2 = new JButton("Level 2");
    JButton level3 = new JButton("Level 3");
    JButton credits = new JButton("Credits");
    JButton exit = new JButton("Exit");

    /**
     *  The drawing that will be on the screen
     */ 
    Drawing draw = new Drawing();

    /**
     * The frame that will be passed to the Main class
     */
    JInternalFrame frame;

    /**
     * Returns the frame to be displayed on the main menu screen. Currently unfinished, button for Level 1 will bring you to the Title Screen
     * @return the frame to be displayed
     */

    public JInternalFrame frame(){
        
        frame = new JInternalFrame("",false,false,false,false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);
        
        frame.setLayout(new GridLayout(2, 3));
        
        JButton[] test = {level1, level2, level3, credits, exit};

        for( int i = 0; i<test.length;i++){
            frame.add(test[i]);
            test[i].setLocation(100, 300+150*i);
        }
        frame.add(draw);
        

        level1.addActionListener(this);
        level2.addActionListener(this);

        frame.getContentPane().setBackground(Color.red);

        frame.setSize(1920, 1080);
        frame.setVisible(true);
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

    /**
     * Action listener for the button on level1
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == level1)
            Main.screenNum=1;
        else if (e.getSource() == level2)
            Main.screenNum=10;
    }
}