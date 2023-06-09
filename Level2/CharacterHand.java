package Level2;

import javax.swing.JComponent;

import Helper.DragAndDrop;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

/**
 * Character class that will be on screen for the Level 2
 * Will be implemented to be movable by the arrow keys and to grab the items
 * Time Spent: ten minutes
 * 
 * 
 * @author Alex Zhu
 * @version 0.3.0
 * @date 06/04/2023
 * 
 */

public class CharacterHand extends JComponent{

    /**
     * Whether or not the character is grabbing an item
     */
    public boolean grab = false;

    public static DragAndDrop grabbedObj;

    /**
     * X coordinates of the top left corner of the component
     */
    public int x = 0;

    /**
     * Y coordinates of the top left corner of the component
     */
    public int y = 0;

    public CharacterHand() {
        grabbedObj=null;
        System.out.println("char");
        setBounds(0, 0, 100, 100);
        setSize(100, 100);
        setOpaque(false);

    }


    public void paintComponent(Graphics g) {
        // Paint method just draws a 400 by 400 red square, with image specified
        super.paintComponent(g);

        if(!grab){
            g.setColor(getBackground());

            g.setColor(new Color(255, 0, 0, 177));
            g.setColor(Color.red);
            g.fillRect(0, 0, 100, 100);
        }
        else{
            g.setColor(getBackground());

            g.setColor(new Color(255, 0, 0, 177));
            g.setColor(Color.blue);
            g.fillRect(0, 0, 100, 100);
        }
        

    }
}
