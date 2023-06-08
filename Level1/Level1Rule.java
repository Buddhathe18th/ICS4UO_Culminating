package Level1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Helper.TextBox;

/**
 * The MainMenu class will create the screen of the main menu
 * Time Spent: 1 hour
 * 
 * @author Alex Zhu
 * @version 0.1.0
 * @date 05/16/2023
 */

public class Level1Rule implements KeyListener{

    /**
     *  The drawing that will be on the screen
     */ 
    Drawing draw = new Drawing();

    /**
     * The frame that will be passed to the Main class
     */
    JInternalFrame frame;

    TextBox t = new TextBox(0, 0, 1920, 25, "On the screen, two items will pop up, one will be helpful to Johnny for school work, and the other will be a distraction. Click on the items that are helpful to Johnny!\nPress enter to continue");
    /**
     * Returns the frame to be displayed on the main menu screen. Currently unfinished, button for Level 1 will bring you to the Title Screen
     * @return the frame to be displayed
     */

    public JInternalFrame frame(){
        
        frame = new JInternalFrame("",false,false,false,false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);
        frame.setLayout(null);
        
        
        frame.add(t);
        
        frame.getContentPane().setFocusable(false);
        frame.setFocusable(false);

        frame.addKeyListener(this);
        

        frame.getContentPane().setBackground(Color.red);
        frame.add(draw);

        frame.setSize(1920, 1080);
        frame.setVisible(true);
        return frame;
    }

    /**
     * Drawing class for paiting text onto the Main Menu screen
     */
    class Drawing extends Canvas {
        public void paint(Graphics g) {
            // g.setFont(new Font("Courier New", Font.PLAIN, 80));
            // g.drawString("Race Against Time", 0, 0);
            // g.setColor(new Color(255, 190, 50));
        }
    }

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