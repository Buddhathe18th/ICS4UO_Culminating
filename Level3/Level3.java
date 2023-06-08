package Level3;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Level 3 game and driver class for now. Very general for now.
 * Time Spent: 10 minutes
 * 
 * @author Lukas Li
 * @version 0.1.0
 * @date 05/18/2023
 * 
 */

public class Level3 extends JComponent {

    /**
     * Temporary main class used to test the level.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Level 3");
        frame.setSize(1920,1080);
        frame.setVisible(true);
        Level3Frame g = new Level3Frame();
        frame.add(g);
        frame.addKeyListener(g);
        while(true){
            try {
                
                // Stops the program from running for 1 second to preserve computer power
                Thread.sleep(1000);
                System.out.println(g.timeLeft+" "+g.win);
                if(g.timeLeft>=0&&!g.win){
                    g.timeLeft--;
                    g.revalidate();
                    g.repaint();
                }
                else{
                    System.out.println("winning teh game");
                    break;
                    
                }
                
            } catch (Exception e) {
                System.out.println("Sleep method is broken");
            }
        }
    }
}