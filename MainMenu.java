import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu implements ActionListener{
    

    JButton level1 = new JButton("Level 1");
    JButton level2 = new JButton("Level 2");
    JButton level3 = new JButton("Level 3");
    JButton credits = new JButton("Credits");
    JButton exit = new JButton("Exit");


    Drawing draw = new Drawing();
    JInternalFrame frame;

    public JInternalFrame test(){
        
        frame = new JInternalFrame("",false,false,false,false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);
        
        frame.setLayout(null);
        
        JButton[] test = {level1, level2, level3, credits, exit};

        for( int i = 0; i<test.length;i++){
            frame.add(test[i]);
            test[i].setLocation(100, 300+150*i);
        }
        frame.add(draw);
        

        level1.addActionListener(this);

        frame.getContentPane().setBackground(Color.red);

        frame.setSize(1920, 1080);
        frame.setVisible(true);
        return frame;
    }


    class Drawing extends Canvas {
        public void paint(Graphics g) {
            g.setFont(new Font("Courier New", Font.PLAIN, 80));
            g.drawString("Race Against Time", 0, 0);
            g.setColor(new Color(255, 190, 50));
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == level1)
            Main.screenNum=1;
    }
}