import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main implements KeyListener{
    static int screenNum = 2;
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
        frame.addKeyListener(this);

        
        frame.setVisible(true);
        

        
        
        

        while (run) {
            frame.getContentPane().removeAll();
            frame.requestFocusInWindow();

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
                    
                } catch (Exception e) {
                    System.out.println("Broekn");
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

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER&&screenNum==1){
            Main.screenNum=2;
        }
        
    }
}