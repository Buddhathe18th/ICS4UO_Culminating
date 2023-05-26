package Level2;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Helper.DragAndDrop;

/**
 * Level 2 game class. So far includes just one draggable component.
 * Time Spent: 0.5 hours
 * 
 * @author Alex Zhu
 * @version 0.1.0
 * @date 05/18/2023
 * 
 */

public class Level2 {

    /**
     * One drag and droppable item on the screen
     */
    DragAndDrop[] drag=new DragAndDrop[1];

    /**
     * The screen to display on the JFrame
     */
    JInternalFrame frame;
    

    test t = new test();;

    int objLeft=1;

    /**
     * Constructor for the Level 2 class
     */

    public Level2(){

        Toolkit tool = Toolkit.getDefaultToolkit();
        DragAndDrop i1 = new DragAndDrop(tool.getImage("Level2\\a.png"), 100, 100);
        drag[0]=i1;

        while(true){
            for( DragAndDrop d: drag){
                if(d.checkCollision(t.getX(), t.getY()+500, 200, 180)||d.checkCollision(t.getX()+1720, t.getY()+500, 200, 180)){
                    frame.remove(d);
                    d.setVisible(false);
                    objLeft--;
                    t.repaint();
                    
                }
            }
        }
    }

    public JInternalFrame frame() {
        frame = new JInternalFrame("", false, false, false, false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);

        

       
        t.setLayout(null);
        t.add(drag[0]);
        // frame.add(new Drawing()).setLocation(0, 0);

        // frame.add(i1);
        // frame.setOpaque(true);

        // i1.setLocation(0, 0);

        frame.add(t);

        frame.setSize(1920, 1080);
        frame.setVisible(true);
        return frame;
    }

    public class test extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image[] iArr = new Image[1];
            try {
                iArr[0] = ImageIO.read(new File("Level2\\bin.png"));
            } catch (IOException e) {
                System.out.println("broken");
            }

            g.drawImage(iArr[0], 0, 500, 200, 180, null);
            g.drawImage(iArr[0], 1720, 500, 200, 180, null);

            Image[] iArr1 = new Image[1];
            try {
                iArr1[0] = ImageIO.read(new File("Level2\\table.png"));
            } catch (IOException e) {
                System.out.println("broken");
            }

            g.drawImage(iArr1[0], 450, 130, 800, 600, null);

            g.drawString(String.valueOf(objLeft), 0, 0);
        }
    }

    

    // public class Drawing extends Canvas {

    //     public void paint(Graphics g) {
    //         Image[] iArr = new Image[1];
    //         try {
    //             iArr[0] = ImageIO.read(new File("Level2\\bin.png"));
    //         } catch (IOException e) {
    //             System.out.println("broken");
    //         }

    //         g.drawImage(iArr[0], 0, 500, 200, 180, null);
    //         g.drawImage(iArr[0], 1720, 500, 200, 180, null);

    //         Image[] iArr1 = new Image[1];
    //         try {
    //             iArr1[0] = ImageIO.read(new File("Level2\\table.png"));
    //         } catch (IOException e) {
    //             System.out.println("broken");
    //         }

    //         g.drawImage(iArr1[0], 450, 130, 800, 600, null);
    //     }
    // }
}