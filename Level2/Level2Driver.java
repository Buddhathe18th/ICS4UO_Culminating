package Level2;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Helper.DragAndDrop;

/**
 * Main method to test Level 2 class. No longer needed, Level 2 can be run through the Main class
 * Time Spent: 5 minutes
 * 
 * <h2>Modifications</h2>
 * Checks for collisions of the components and the bins
 * Time spent: 3 hours
 * 
 * @author Alex Zhu
 * @version 0.2.0
 * @date 05/28/2023
 */

public class Level2Driver {
    /**
     * Temporary main method to run Level2
     */
    public static void main(String[] args) {
        Level2 l2 = new Level2();

        JFrame frame = new JFrame("Race Against Time");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setFocusable(true);
        frame.setVisible(true);

        frame.add(l2.frame());
        JPanel l2InnerPanel = l2.innerPanel;

        // While there still are elements to check for collisions
        while (l2.draggableArrayList.size() > 0) {
            System.out.println(l2.draggableArrayList.size());

            // Iterate through all DragAndDrop components
            for (int i = 0; i < l2.draggableArrayList.size(); i++) {
                DragAndDrop d = l2.draggableArrayList.get(i);

                // To slow down how often this is checked
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // If it belongs in the left bin
                if (d.school) {
                    if (d.checkCollision(l2InnerPanel.getX(), l2InnerPanel.getY() + 500, 200, 180)) {

                        // Removing and repainting the screens
                        l2InnerPanel.remove(d);

                        l2.objLeft--;
                        l2InnerPanel.revalidate();
                        l2.frame.revalidate();
                        l2InnerPanel.repaint();
                        l2.score++;

                        // To delete this later to not run into a ConcurrentModification exception
                        d.del = true;
                    } else if (d.checkCollision(l2InnerPanel.getX() + 1220, l2InnerPanel.getY() + 500, 200, 180)) {
                        // Removing and repainting the screens
                        l2InnerPanel.remove(d);

                        l2.objLeft--;
                        l2InnerPanel.revalidate();
                        l2.frame.revalidate();
                        l2InnerPanel.repaint();
                        l2.score--;

                        // To delete this later to not run into a ConcurrentModification exception
                        d.del = true;
                    }
                } else {
                    if (d.checkCollision(l2InnerPanel.getX(), l2InnerPanel.getY() + 500, 200, 180)) {
                        // Removing and repainting the screens
                        l2InnerPanel.remove(d);

                        l2.objLeft--;
                        l2InnerPanel.revalidate();
                        l2.frame.revalidate();
                        l2InnerPanel.repaint();
                        l2.score--;

                        // To delete this later to not run into a ConcurrentModification exception
                        d.del = true;
                    } else if (d.checkCollision(l2InnerPanel.getX() + 1220, l2InnerPanel.getY() + 500, 200, 180)) {
                        // Removing and repainting the screens
                        l2InnerPanel.remove(d);

                        l2.objLeft--;
                        l2InnerPanel.revalidate();
                        l2.frame.revalidate();
                        l2InnerPanel.repaint();
                        l2.score++;

                        // To delete this later to not run into a ConcurrentModification exception
                        d.del = true;
                    }
                }
            }

            // Removing all components that should be deleted
            for (int i = 0; i < l2.draggableArrayList.size(); i++) {
                if (l2.draggableArrayList.get(i).del) {
                    l2.draggableArrayList.remove(i);
                    i--;
                }
            }
        }
    }
}
