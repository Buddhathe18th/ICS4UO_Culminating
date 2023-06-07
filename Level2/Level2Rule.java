package Level2;

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

import Helper.TextBox;

/**
 * TWill show the rules and concepts used in Level 2
 * Time Spent: 45 minutes
 * 
 * @author Alex Zhu
 * @version 0.3.0
 * @date 06/04/2023
 */

public class Level2Rule {

    /**
     * Elements that will be drawn on the JInternalFrame with the paint() method
     */
    Drawing draw = new Drawing();

    /**
     * Textbox with rules
     */

    private TextBox t = new TextBox(0, 0, 1000, 25, "Uh oh, you ran out of time. Next time, help Johnny clear his desk faster so he has more time to work!");;

    JButton level3;
    JButton mainMenu;
    /**
     * Makes all components and drawings that will be on the Rule page
     * 
     * @return the JInternalFrame to add to the screen
     */
    public JInternalFrame frame() {

        JInternalFrame frame = new JInternalFrame("", false, false, false, false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);
        frame.add(draw);


        
        frame.getContentPane().setFocusable(false);
        frame.setFocusable(false);
        
        frame.add(t);
        // frame.add(new JLabel("test"));

        frame.setSize(1800, 1080);
        frame.setVisible(true);
        // draw.addKeyListener(this);
        // frame.addKeyListener(this);
        return frame;
    }

    /**
     * Drawing class for painting text and images onto the rule page
     */

    class Drawing extends Canvas {
        public void paint(Graphics g) {
            Image[] iArr = new Image[1];
            try {
                iArr[0] = ImageIO.read(new File("Level2\\Images\\table.png"));
            } catch (IOException e) {
                System.out.println("broken");
            }

            g.drawImage(iArr[0], 450, 130, 800, 600, null);

            g.setFont(new Font("Courier New", Font.PLAIN, t.getFontSize()));
            // Draws a rectangular box at specified coordinates
            g.drawRect(t.getCoords()[0], t.getCoords()[1], t.getWidth(),
                    (int) ((t.getText().size() + 0.25) * t.getFontSize()));
        

        }

    }
}