package Level3;
import javax.swing.*;
import java.awt.*;

/**
 * Class for the maze in Level 3. So far only one line.
 * Time Spent: 5 minutes
 * 
 * @author Lukas Li
 * @version 0.1.0
 * @date 05/18/2023
 * 
 */

public class Level3Maze extends JComponent {
    private Item[] items;
    public void paint(Graphics g) {
        g.drawLine(300, 300, 300, 500);
    }
}