package Level2;

import javax.swing.JFrame;

/**
 * Main method to test Level 2 class.
 * Time Spent: 5 minutes
 * 
 * @author Alex Zhu
 * @version 0.1.0
 * @date 05/18/2023
 */

public class Level2Driver {
    /**
     * Temporary main method to run Level2
     */
    public static void main(String[] args){
        Level2Rule t = new Level2Rule();

        JFrame frame = new JFrame("Race Against Time");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setFocusable(true);
        frame.setVisible(true);

        frame.add(t.frame());
    }
}
