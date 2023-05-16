import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    static int screenNum=1;
    JInternalFrame content = new JInternalFrame();
    boolean run = true;

    public static void main(String[] args) {
        Main t = new Main();
    }

    public Main() {
        JFrame frame = new JFrame("Race Against Time");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setVisible(true);

        while (run){
            
            switch(screenNum){
                case 1: TitleScreen t = new TitleScreen();
                JInternalFrame test = t.test();
                
                frame.add(test);
                test.setLocation(0, -15);
            }
            System.out.println(screenNum);

            int pastFrame=screenNum;

            while(pastFrame==screenNum){
                try{
                    wait(1);
                }
                catch (InterruptedException e){
                    System.out.println("Broekn");
                }
                
            }
        }
        

        
    }
}