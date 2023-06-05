package Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

import Level1.Level1;

import Helper.DragAndDrop;
import Level2.Level2;
import Level2.Level2Rule;

/**
 * The Main class is the class that runs and calls all other classes. This class
 * has complete control on which screen to display.
 * Time Spent: 2 hours
 * 
 * <h2>Modifications</h2>
 * Started adding level 1 to the main class
 * 
 * @author Alex Zhu, Lukas Li
 * @version 0.3.0
 * @date 06/03/2023
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
                case 1: { //Unfinished
                    TitleScreen t = new TitleScreen();
                    JInternalFrame test = t.frame();
                    frame.add(test);
                    test.setLocation(0, -15);
                    String[] init = {"Johnny wants to go play basketball, but has a math assignment due tomorrow. Which choice should he make?", 
                        "Johnny has been playing Minecraft with his best friend, Bernie, for two hours now. Johnny also has to finish a journal for English. Which option should Johnny pick?", 
                        "Johnny has a big science project due next week. However, he also has some history homework due tomorrow. Which assignment should he work on?   ", 
                        "It’s 1am, and Johnny just finished his assignment. He has an urge to watch some Youtube. What should he do?"};
                    String[] c = {"Incorrect! If Johnny has an assignment due tomorrow, delaying it further could be impeding his learning.", 
                                "Correct! If Johnny has a math assignment due tomorrow, getting started on it will be the better choice.", 
                                "Correct! If Johnny has an English assignment, he should prioritize doing it over playing video games.", 
                                "Incorrect! If Johnny continues playing Minecraft with his friend, he would have less time to finish his homework.", 
                                "Incorrect! Johnny should prioritize assignments that are due earlier.", 
                                "Correct! Johnny should prioritize assignments that are due earlier, regardless of if he likes the subject or not.", 
                                "Correct! Sleeping can help keep your body healthy and ready for the next day!", 
                                "Incorrect! Without sleep, Johnny will be fatigued and very unfocused the next day.", 
                            };
                    String[] inf = {"Fun Fact! Sports are good for your mental health, but at times like these, commiting and working is still the overall best choice! Press enter to continue...", 
                                    "Fun Fact! According to research from Brigham Young University, video game breaks can increase productivity by up to 20%. But make sure not to play too much! Too many video games can lead to many problems such as a reduced attention span. Press enter to continue...", 
                                    "Fun Fact! According to research from Brigham Young University, video game breaks can increase productivity by up to 20%, but make sure not to play too much! Too many video games can lead to many problems such as a decreased attention span and eye strain. Press enter to continue...", 
                                    "Fun Fact! Being sleep deprived will make you behave in similar ways to being drunk! According to Harvard Medical School, going 48 hours without sleep is equivalent to having a 0.1% blood alcohol content, which is higher than the legal amount to drive! Press enter to continue...", 
                                    };
                    Image[] i = new Image[8];
                    try {
                        i[0] = ImageIO.read(new File("Level1\\Images\\atom.png"));
                        i[1] = ImageIO.read(new File("Level1\\Images\\basketball.png"));
                        i[2] = ImageIO.read(new File("Level1\\Images\\calculator.png"));
                        i[3] = ImageIO.read(new File("Level1\\Images\\history.png"));
                        i[4] = ImageIO.read(new File("Level1\\Images\\ipad.png"));
                        i[5] = ImageIO.read(new File("Level1\\Images\\pencil.png"));
                        i[6] = ImageIO.read(new File("Level1\\Images\\pillow.png"));
                        i[7] = ImageIO.read(new File("Level1\\Images\\youtube.png"));
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    new Level1(i, init, c, inf);
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