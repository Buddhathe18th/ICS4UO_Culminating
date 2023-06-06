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

    /**
     * The items that are to be collected
     */
    private Item[] items;

    /**
     * Panel containing all graphics
     */
    private Panel innerPanel = new Panel();

    /**
     *  Makes all components and drawings that will be on the Level 3 game screen
     * 
     * @return the JInternalFrame to add to the screen
     */
    public JInternalFrame frame() {
        JInternalFrame frame = new JInternalFrame("", false, false, false, false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);

        innerPanel.setLayout(null);

        frame.add(innerPanel);

        frame.setSize(1920, 1080);
        frame.setVisible(true);
        return frame;
    }

    /**
     * Panel class to hold all drawings and components
     */
    public class Panel extends JPanel {
        /**
         * Draws the text boxes to the Game Panel.
         *
         * @param g the Graphics context in which to paint
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    }

}