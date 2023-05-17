package Level2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Level2 {
    
    Item i1;
    Item i2;

    JInternalFrame frame;

    public Level2(){
        JFrame t = new JFrame();
        frame = new JInternalFrame("",false,false,false,false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);

        frame.add(i1);
        frame.add(i2);


        frame.setSize(1920, 1080);
        frame.setVisible(true);

        t.add(frame);
        
    }

    public static void main(String[] args) {
        new Level2();
    }


    class Item extends Canvas {
        public void paint(Graphics g) {
            int [] x = {45, 55, 75, 55, 63, 43, 17, 31, 12, 35, 45};
            int [] y = {41, 65, 71, 83, 108, 88, 105, 78, 61, 63,41};
            g.drawPolygon(x, y, 10);
            g.setColor(Color.BLUE);
            g.fillPolygon(x, y, 10);
        }
    }

    // public void actionPerformed(ActionEvent e) {
    //     if (e.getSource() == level1)
    //         Main.screenNum=1;
    //         JFrame k = new JFrame("Sefes");
    //         k.setSize(100, 100);
    //         k.setVisible(true);
    // }
}