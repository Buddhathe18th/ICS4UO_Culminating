package Level2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Helper.TextBox;

/**
 * The TitleScreen class will create the screen for the title screen
 * Time Spent: 45 minutes
 * 
 * @author Alex Zhu
 * @version 0.1.0
 * @date 05/15/2023
 */

public class Level2Rule implements KeyListener{


    /**
     * Elements that will be drawn on the JInternalFrame with the paint() method
     */
    private Drawing draw = new Drawing();

    /**
     * Textbox on the top of the page, with the rules of the level
     */

    public TextBox t = new TextBox(0,0,1920,25,"Now, Johnny is ready to work, but oh no! All of his belongings are on his table! Help Johnny by dragging and dropping each item on the table to the right bin! And remember, Johnny has to finish his work fast! You only have one minute to sort these. Each wrong item is a time penalty of 5 second!\nPress enter to continue");

    /**
     * Makes all components and drawings that will be on the Title Screen
     * 
     * @return the JInternalFrame to add to the screen
     */
    public JInternalFrame frame() {
        JInternalFrame frame = new JInternalFrame("", false, false, false, false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);
              
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        draw.addKeyListener(this);
        frame.addKeyListener(this);
        frame.add(draw);
        draw.setLocation(0,0);
        frame.add(t);  
        t.setLocation(0,0);

        frame.add(new JLabel("test"));
        return frame;
    }

    /**
     * Drawing class for painting text and images onto the Title Screen
     */

    class Drawing extends Canvas {
        public void paint(Graphics g) {
            Toolkit t = Toolkit.getDefaultToolkit();
            Image i = t.getImage("table.png");
            g.drawImage(i, 0, 0, null);
           

            g.drawString("hi",0,0);
        }
    }

    /**
     * Overidded KeyListener methods to listen for the enter key to change screens
     */

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            Main.Main.screenNum=2;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            Main.Main.screenNum=2;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            Main.Main.screenNum=2;
        }
        
    }
}