import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    static int screenNum = 1;
    JInternalFrame content = new JInternalFrame();
    boolean run = true;
    JFrame frame;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        frame = new JFrame("Race Against Time");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setFocusable(true);
        System.out.println(frame.isDisplayable());//TODO: The JFrame is not displayable
        System.out.println(frame.requestFocusInWindow());
        frame.setVisible(true);

        KeyListener k = new KeyListener() {
            public void keyTyped(KeyEvent event) {
                return;
            }

            public void keyReleased(KeyEvent event) {
                return;
            }

            public void keyPressed(KeyEvent event) {
                System.out.println("here");
                if (event.getKeyCode() == KeyEvent.VK_ENTER&&screenNum==1) {
                    screenNum = 2;
                    frame.add(new JLabel("testdsfdsfds00"));
                }
            }
        };
        frame.addKeyListener(k);
        
        

        while (run) {
            frame.getContentPane().removeAll();

            switch (screenNum) {
                case 1: {
                    TitleScreen t = new TitleScreen();
                    JInternalFrame test = t.test();
                    frame.add(test);
                    System.out.println("added");
                    test.setLocation(0, -15);
                    
                    break;
                }
                case 2: {
                    MainMenu t = new MainMenu();
                    JInternalFrame test = t.test();
                    frame.add(test);
                    test.setLocation(0, -15);
                    break;

                }
                

            }
            
            

            int pastFrame = screenNum;

            while (pastFrame == screenNum) {
                try {
                    Thread.sleep(1000);
                    System.out.println(screenNum);
                    
                } catch (Exception e) {//TODO: Current thread is not owner issue
                    System.out.println("Broekn");
                }

            }
        }

    }
}