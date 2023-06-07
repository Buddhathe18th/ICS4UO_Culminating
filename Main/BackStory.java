package Main;
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

public class BackStory implements KeyListener{

    /**
     *  The drawing that will be on the screen
     */ 
    Drawing draw = new Drawing();

    /**
     * The frame that will be passed to the Main class
     */
    JInternalFrame frame;

    TextBox t = new TextBox(0, 0, 1920, 25, "Johnny is an 8th grade student at Silver Oak Middle School. Each day he spends hours and hours playing video games. He’s currently plagued by the greatest disease of this generation…\n\nPROCRASTINATION                                                     Press enter to continue\n");

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
        frame.add(draw);
        
        frame.add(t);
        
        
        frame.getContentPane().setFocusable(false);
        frame.setFocusable(false);
        
        frame.addKeyListener(this);
        draw.addKeyListener(this);
        t.addKeyListener(this);
        
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        frame.requestFocus();
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
    public void keyTyped(KeyEvent e) {
        System.out.println("next");
       if (e.getKeyCode()==KeyEvent.VK_ENTER){
        Main.screenNum++;
       }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("next");
       if (e.getKeyCode()==KeyEvent.VK_ENTER){
        Main.screenNum++;
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        System.out.println("next");
       if (e.getKeyCode()==KeyEvent.VK_ENTER){
        Main.screenNum++;
       }
    }
}