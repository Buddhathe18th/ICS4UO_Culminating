import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TitleScreen {
    
    Drawing draw = new Drawing();

    public JInternalFrame test(){
        
        JInternalFrame frame = new JInternalFrame("",false,false,false,false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);
        frame.add(draw);

        

        KeyListener k = new KeyListener() {
            public void keyTyped(KeyEvent event) {
                return;
            }

            public void keyReleased(KeyEvent event) {
                return;
            }

            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == event.VK_ENTER) {
                    Main.screenNum=2;
                }
            }
        };
        frame.addKeyListener(k);
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        return frame;
    }


    class Drawing extends Canvas {
        public void paint(Graphics g) {
            Toolkit t = Toolkit.getDefaultToolkit();
            Image i = t.getImage("logo.png");
            g.drawImage(i, 35, 52, this);

            g.setFont(new Font("Courier New", Font.PLAIN, 80));
            g.drawString("LC Studios Presents...", 325, 200);
            g.setFont(new Font("Courier New", Font.PLAIN, 50));
            g.drawString("Race Against Time", 475, 400);
            g.setFont(new Font("Courier New", Font.PLAIN, 20));
            g.drawString("Press enter to continue", 550, 600);

        }
    }
}