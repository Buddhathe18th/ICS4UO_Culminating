package Level2;

import javax.swing.JFrame;

public class Level2RDriver {
    
    public static void main(String[] args){
        Level2Result l2 = new Level2Result();

        JFrame frame = new JFrame("Race Against Time");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setFocusable(true);
        frame.setVisible(true);

        frame.add(l2.frame());
    }
}
