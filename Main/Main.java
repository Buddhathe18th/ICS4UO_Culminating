package Main;

import java.awt.event.*;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.Robot;

import javax.swing.*;
import javax.imageio.*;
import java.io.*;

import Level1.Level1;
import Level1.Level1Finish;
import Level1.Level1Rule;
import Helper.DragAndDrop;
import Helper.MoveFrame;
import Level2.Level2;
import Level2.Level2Result;
import Level2.Level2Rule;
import Level3.Level3Frame;
import Level3.Level3Result;
import Level3.Level3Rule;

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
    static JFrame frame;

    public static boolean win1;
    public static boolean win2;
    public static boolean win3;

    public Level3Frame g = new Level3Frame();

    public static void main(String[] args) {
        new Main();
    }

    /**
     * The Main class has a JFrame and each screen is returned as a JInternalFrame,
     * displayed on the JFrame
     */
    public Main() {
        win1=true;
        win2=true;
        win3=true;
        frame = new JFrame("Race Against Time");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 960);
        frame.setFocusable(true);
        frame.setResizable(false);
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
                case 1: { // Unfinished
                    TitleScreen t = new TitleScreen();
                    JInternalFrame test = t.frame();
                    frame.add(test);
                    test.setLocation(0, -15);
                    break;
                }
                case 2: {
                    BackStory t = new BackStory();
                    JInternalFrame test = t.frame();
                    frame.add(test);
                    test.setLocation(0, -15);
                    break;
                }
                case 3: {
                    MainMenu t = new MainMenu();
                    JInternalFrame test = t.frame();
                    frame.add(test);
                    test.setLocation(0, -15);
                    break;
                }
                case 4: {
                    Level1Rule t = new Level1Rule();
                    JInternalFrame test = t.frame();
                    frame.add(test);
                    test.setLocation(0, -15);
                    break;
                }
                case 5: {
                    String[] init = {"Johnny wants to go play basketball, but has a math assignment due tomorrow. Which choice should he make?", 
                        "Johnny has been playing Minecraft with his best friend, Bernie, for two hours now. Johnny also has to finish a journal for English. Which option should Johnny pick?", 
                        "Johnny has a big science project due next week, which he is already 3/4 done. However, he also has some history homework due tomorrow that he hasn't started. Which assignment should he work on?   ", 
                        "It’s 1am, and Johnny just finished his assignment. He has an urge to watch some Youtube. What should he do?"};
                    String[] c = {"Incorrect! If Johnny has an assignment due tomorrow, delaying it further could be impeding his learning.", 
                                "Correct! If Johnny has a math assignment due tomorrow, getting started on it will be the better choice.", 
                                "Correct! If Johnny has an English assignment, he should prioritize doing it over playing video games.", 
                                "Incorrect! If Johnny continues playing Minecraft with his friend, he would have less time to finish his homework.", 
                                "Incorrect! Johnny should prioritize assignments that are due earlier. He has plenty of time to finish his science project.", 
                                "Correct! Johnny should prioritize assignments that are due earlier, regardless of if he likes the subject or not.", 
                                "Correct! Sleeping can help keep your body healthy and ready for the next day!", 
                                "Incorrect! Without sleep, Johnny will be fatigued and very unfocused the next day.", };
                    String[] inf = {"Fun Fact! Sports are good for your mental health, but at times like these, commiting and working is still the overall best choice! Press enter to continue...", 
                                    "Fun Fact! According to research from Brigham Young University, video game breaks can increase productivity by up to 20%. But make sure not to play too much! Too many video games can lead to many problems such as a reduced attention span. Press enter to continue...", 
                                    "Fun Fact! According to research from Brigham Young University, video game breaks can increase productivity by up to 20%, but make sure not to play too much! Too many video games can lead to many problems such as a decreased attention span and eye strain. Press enter to continue...", 
                                    "Fun Fact! Being sleep deprived will make you behave in similar ways to being drunk! According to Harvard Medical School, going 48 hours without sleep is equivalent to having a 0.1% blood alcohol content, which is higher than the legal amount to drive! Press enter to continue...", };
                    
                    String[] txt = {"Play basketball", "Do math", 
                                    "Do english", "Play Minecraft", 
                                    "Work on science", "Work on history", 
                                    "Sleep", "Watch Youtube"};
                    Image[] i = new Image[8];
                    try {
                        i[0] = ImageIO.read(new File("Level1\\Images\\basketball.png"));
                        i[1] = ImageIO.read(new File("Level1\\Images\\calculator.png"));
                        i[2] = ImageIO.read(new File("Level1\\Images\\pencil.png"));
                        i[3] = ImageIO.read(new File("Level1\\Images\\ipad.png"));
                        i[4] = ImageIO.read(new File("Level1\\Images\\atom.png"));
                        i[5] = ImageIO.read(new File("Level1\\Images\\history.png"));
                        i[6] = ImageIO.read(new File("Level1\\Images\\pillow.png"));
                        i[7] = ImageIO.read(new File("Level1\\Images\\youtube.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    new Level1(frame, i, init, c, inf, txt);
                    screenNum=9;
                    break;
                }

                case 9: {
                    Level1Finish t = new Level1Finish();
                    JInternalFrame test = t.frame();
                    frame.add(test);
                    test.setLocation(0, -15);
                    win1=true;
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
                    Level2 t = new Level2();
                    JInternalFrame test = t.frame();
                    frame.add(test);
                    test.setLocation(0, -15);

                    try {
                        Robot bot = new Robot();
                        bot.mouseMove(100, 100);
                        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                        System.out.println("clicked screen");
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }

                    break;
                }
                case 12: {
                    Level2Result t = new Level2Result();
                    JInternalFrame test = t.frame();
                    frame.add(test);
                    test.setLocation(0, -15);
                    break;
                }

                case 14: {
                    Level3Rule t = new Level3Rule();
                    JInternalFrame test = t.frame();
                    frame.add(test);
                    test.setLocation(0, -15);
                    break;
                }

                case 15: {
                    frame.add(g);
                    g.setLocation(0, -15);
                    frame.addKeyListener(g);

                    while (true) {
                        try {

                            // Stops the program from running for 1 second to preserve computer power
                            Thread.sleep(1000);
                            System.out.println(g.timeLeft + " " + g.win);
                            if (g.timeLeft >= 0 && !g.win) {
                                g.timeLeft--;
                                g.revalidate();
                                g.repaint();
                            } else {
                                System.out.println("winning teh game");
                                break;

                            }

                        } catch (Exception e) {
                            System.out.println("Sleep method is broken");
                        }

                    }

                    frame.getContentPane().removeAll();
                    frame.requestFocusInWindow();
                }
                case 16: {
                    Level3Result t = new Level3Result();
                    JInternalFrame test = t.frame();
                    frame.add(test);
                    test.setLocation(0, -15);
                    break;
                }
                case 17: {
                    if(win1&&win2&&win3){
                        WinCredits t = new WinCredits();
                        JInternalFrame test = t.frame();
                        frame.add(test);
                        test.setLocation(0, -15);
                        break;
                    }
                    else{
                        screenNum++;
                    }
                    
                }
                case 18: {
                    Credits t = new Credits();
                    JInternalFrame test = t.frame();
                    frame.add(test);
                    test.setLocation(0, -15);
                    break;
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

            if (pastFrame == 15) {
                frame.removeKeyListener(g);
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
        if (e.getKeyCode() == KeyEvent.VK_ENTER && (screenNum == 1 || screenNum == 2 || screenNum == 4 || screenNum==10||screenNum==14||screenNum==17)) {
            Main.screenNum++;
        }

    }
}