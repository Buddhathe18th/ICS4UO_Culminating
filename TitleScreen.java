import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The TitleScreen class will create the screen for the title screen
 * Time Spent: 45 minutes
 * 
 * @author Alex Zhu
 * @version 0.1.0
 * @date 05/15/2023
 */

public class TitleScreen implements KeyListener{

    Drawing draw = new Drawing();

    public JInternalFrame frame() {

        JInternalFrame frame = new JInternalFrame("", false, false, false, false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);
        frame.add(draw);

        
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        draw.addKeyListener(this);
        frame.addKeyListener(this);
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

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            Main.screenNum=2;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            Main.screenNum=2;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            Main.screenNum=2;
        }
        
    }
}