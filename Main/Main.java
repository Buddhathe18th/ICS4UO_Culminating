package Main;

import java.awt.event.*;
import javax.swing.*;

import Helper.DragAndDrop;
import Level2.Level2;
import Level2.Level2Rule;

/**
 * The Main class is the class that runs and calls all other classes. This class
 * has complete control on which screen to display.
 * Time Spent: 2 hours
 * 
 * @author Alex Zhu
 * @version 0.1.0
 * @date 05/15/2023
 * 
 */

public class Main implements KeyListener {
    public static int screenNum = 1;
    JInternalFrame content = new JInternalFrame();
    boolean run = true;
    JFrame frame;

    public static void main(String[] args) {
        new Main();
    }

    /**
     * The Main class has a JFrame and each screen is returned as a JInternalFrame,
     * displayed on the JFrame
     */
    public Main() {
        frame = new JFrame("Race Against Time");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setFocusable(true);
        frame.addKeyListener(this);
        frame.setVisible(true);

        // While the user has not closed the program or pressed the exit button in the
        // Main Menu
        while (run) {
            // Remove previous screens
            frame.getContentPane().removeAll();
            frame.requestFocusInWindow();

            // Depending on screenNum, different screen will be displayed
            switch (screenNum) {
                case 1: {
                    TitleScreen t = new TitleScreen();
                    JInternalFrame test = t.frame();
                    frame.add(test);
                    test.setLocation(0, -15);
                    break;
                }
                case 2: {
                    MainMenu t = new MainMenu();
                    JInternalFrame test = t.frame();
                    frame.add(test);
                    test.setLocation(0, -15);
                    break;
                }
                case 10: {
                    Level2Rule t = new Level2Rule();
                    JInternalFrame test = t.frame();
                    frame.add(test);
                    test.setLocation(0, -15);
                    break;
                }
                case 11: {
                    Level2 l2 = new Level2();
                    JInternalFrame test = l2.frame();
                    frame.add(test);
                    test.setLocation(0, -15);

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
                                } else if (d.checkCollision(l2InnerPanel.getX() + 1220, l2InnerPanel.getY() + 500, 200,
                                        180)) {
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
                                l2.draggableArrayList.trimToSize();
                                l2InnerPanel.revalidate();
                                l2.frame.revalidate();
                                l2InnerPanel.repaint();
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
                                } else if (d.checkCollision(l2InnerPanel.getX() + 1220, l2InnerPanel.getY() + 500, 200,
                                        180)) {
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
                                l2.draggableArrayList.trimToSize();
                                l2InnerPanel.revalidate();
                                l2.frame.revalidate();
                                l2InnerPanel.repaint();
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
                    Main.screenNum++;
                }
            }

            int pastFrame = screenNum;

            // While the screen has not been changed by the user
            while (pastFrame == screenNum) {
                try {
                    // Stops the program from running for 1 second to preserve computer power
                    Thread.sleep(1000);
                    System.out.println(screenNum);
                } catch (Exception e) {
                    System.out.println("Sleep method is broken");
                }

            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    // KeyListener methods for when the focus of the user is on the JFrame

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && screenNum == 1) {
            Main.screenNum = 2;
        }

    }
}