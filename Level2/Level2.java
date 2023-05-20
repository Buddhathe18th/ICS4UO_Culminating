package Level2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Level 2 game class. So far includes just one draggable component.
 * Time Spent: 0.5 hours
 * 
 * @author Alex Zhu
 * @version 0.1.0
 * @date 05/18/2023
 * 
 */

public class Level2 {
    
    /**
     * One drag and droppable item on the screen
     */
    DragAndDrop i1;

    /**
     * The screen to display on the JFrame
     */
    JInternalFrame frame;

    /**
     * Constructor for the Level 2 class
     */

    public Level2(){
        JFrame t = new JFrame();
        frame = new JInternalFrame("",false,false,false,false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);

        Toolkit tool = Toolkit.getDefaultToolkit();
        i1=new DragAndDrop(tool.getImage("a.png"),100,100);

        frame.add(i1);
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        t.add(frame);
        t.setSize(1920 ,1080);
        t.setVisible(true);
        
    }
}