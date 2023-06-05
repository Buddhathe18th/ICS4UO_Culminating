package Level2;

import javax.swing.JComponent;

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

public class Character extends JComponent implements KeyListener {

    /**
     * Whether or not the character is grabbing an item
     */
    boolean grab = false;

    

    /**
     * KeyListener methods
     */

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Level2.charX = Level2.charX + 10;
            revalidate();
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }
}
