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

public class Level3 extends JComponent{

    /**
     * Constructor for the Level3 class. Not finished yet.
     */
    public Level3(JFrame frame) {
        frame.add(new Level3Maze());
    }

    /**
     * Temporary main class used to test the level.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Level 3");
        frame.setSize(1920,1080);
        frame.setVisible(true);
        new Level3(frame);
    }
}