package Level2;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Helper.DragAndDrop;

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
    public static void main(String[] args) {
        Level2 t = new Level2();

        JFrame frame = new JFrame("Race Against Time");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setFocusable(true);
        frame.setVisible(true);

        frame.add(t.frame());
        JPanel h = t.t;

        while (true) {
            for (DragAndDrop d : t.drag) {
                if (d.checkCollision(h.getX(), h.getY() + 500, 200, 180)
                        || d.checkCollision(h.getX() + 1720, h.getY() + 500, 200, 180)) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    h.remove(d);
                    d.setVisible(false);
                    d = null;
                    t.objLeft--;
                    h.revalidate();
                    t.frame.revalidate();
                    h.repaint();
                }
            }
        }
    }
}
