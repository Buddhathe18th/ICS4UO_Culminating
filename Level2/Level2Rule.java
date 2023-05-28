package Level2;

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

import Helper.TextBox;

/**
 * The TitleScreen class will create the screen for the title screen
 * Time Spent: 45 minutes
 * 
 * @author Alex Zhu
 * @version 0.1.0
 * @date 05/15/2023
 */

public class Level2Rule {

    /**
     * Elements that will be drawn on the JInternalFrame with the paint() method
     */
    Drawing draw = new Drawing();

    /**
     * Textbox with rules
     */

    private TextBox t = new TextBox(0, 0, 1000, 25, "test");;

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
        frame.add(draw);

        frame.add(t);
        // frame.add(new JLabel("test"));

        frame.setSize(1800, 1080);
        frame.setVisible(true);
        // draw.addKeyListener(this);
        // frame.addKeyListener(this);
        return frame;
    }

    /**
     * Drawing class for painting text and images onto the Title Screen
     */

    class Drawing extends Canvas {
        public void paint(Graphics g) {
            Image[] iArr = new Image[1];
            try {
                iArr[0] = ImageIO.read(new File("Level2\\table.png"));
            } catch (IOException e) {
                System.out.println("broken");
            }

            g.drawImage(iArr[0], 450, 130, 800, 600, null);

            g.setFont(new Font("Courier New", Font.PLAIN, t.getFontSize()));
            // Draws a rectangular box at specified coordinates
            g.drawRect(t.getCoords()[0], t.getCoords()[1], t.getWidth(),
                    (int) ((t.getText().size() + 0.25) * t.getFontSize()));
            // Draws the text in the text boxes, line by line
            for (int i = 0; i < t.getText().size(); i++)
                g.drawString(t.getText().get(i), t.getCoords()[0], t.getCoords()[1] + (i + 1) * t.getFontSize());

            // int fontSize = t.getFontSize();
            // int width = t.getWidth();
            // int[] coords = t.getCoords();
            // ArrayList<String> text = t.getText();
            // t.setFont(new Font("Courier New", Font.PLAIN, fontSize));
            // // Draws a rectangular box at specified coordinates
            // g.drawRect(coords[0], coords[1], width, (int) ((text.size() + 0.25) *
            // fontSize));
            // // Draws the text in the text boxes, line by line
            // for (int j = 0; j < text.size(); j++)
            // g.drawString(text.get(j), coords[0], coords[1] + (j + 1) * fontSize);

            // g.setFont(new Font("Courier New", Font.PLAIN, 80));
            // g.drawString("LC Studios Presents...", 325, 200);
            // g.setFont(new Font("Courier New", Font.PLAIN, 50));
            // g.drawString("Race Against Time", 475, 400);
            // g.setFont(new Font("Courier New", Font.PLAIN, 20));
            // g.drawString("Press enter to continue", 550, 600);

        }

    }

    /**
     * Overidded KeyListener methods to listen for the enter key to change screens
     */

    // @Override
    // public void keyTyped(KeyEvent e) {
    // if (e.getKeyCode() == KeyEvent.VK_ENTER) {
    // Main.Main.screenNum = 2;
    // }
    // }

    // @Override
    // public void keyPressed(KeyEvent e) {
    // if (e.getKeyCode() == KeyEvent.VK_ENTER) {
    // Main.Main.screenNum = 2;
    // }
    // }

    // @Override
    // public void keyReleased(KeyEvent e) {
    // if (e.getKeyCode() == KeyEvent.VK_ENTER) {
    // Main.Main.screenNum = 2;
    // }

    // }
}