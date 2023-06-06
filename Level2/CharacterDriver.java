package Level2;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Helper.DragAndDrop;
import Helper.MoveFrame;

public class CharacterDriver {
    static CharacterHand t = new CharacterHand();

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("test");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setFocusable(true);
        frame.setVisible(true);

        MoveFrame f = new MoveFrame(t);

        f.setSize(1920, 1080);
        f.setVisible(true);

        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1920, 1080);
        f.setFocusable(true);
        f.setVisible(true); 
        f.setFocusable(true);
        f.addKeyListener(f);

        f.add(t);
        frame.add(f);

        Panel innerPanel = new Panel();

        innerPanel.setLayout(null);
        innerPanel.addKeyListener(frame);
        DragAndDrop i1 = new DragAndDrop(null, 100, 100,true);

        for(int i = 1; i<=6;i++){
            innerPanel.add(i1);;
        }
        frame.add(t);
        frame.add(innerPanel);
        

        frame.setSize(1920, 1080);
        frame.setVisible(true);
        innerPanel.addKeyListener(frame);

        public class Panel extends JPanel {

            /**
             * Paints the background onto the screen
             */
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
    
                Image[] iArr = new Image[1];
                try {
                    iArr[0] = ImageIO.read(new File("Level2\\bin.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
    
                //The two bins
    
                g.drawImage(iArr[0], 0, 500, 200, 180, null);
                g.drawImage(iArr[0], 1220, 500, 200, 180, null);
    
                Image[] iArr1 = new Image[1];
                try {
                    iArr1[0] = ImageIO.read(new File("Level2\\table.png"));
                } catch (IOException e) {
                    System.out.println("broken");
                }
    
                //The table
                g.drawImage(iArr1[0], 300, 130, 800, 600, null);
    
                //On screen showing the number of components left
                g.drawString("Objects remaining: " + String.valueOf(draggableArrayList.size()), 100, 100);
                g.drawString("Score: "+String.valueOf(score),100,150);
            }
        }
    }
}
