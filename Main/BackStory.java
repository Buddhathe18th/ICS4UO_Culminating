package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import Helper.TextBox;
import Main.Main;

public class BackStory implements ActionListener {

    /**
     * The drawing that will be on the screen
     */
    Drawing draw = new Drawing();

    Panel innerPanel = new Panel();

    /**
     * The frame that will be passed to the Main class
     */
    JInternalFrame frame;

    // TextField t = new TextField("Johnny is an 8th grade student at Silver Oak Middle School. Each day he spends hours playing video games. He’s currently plagued by the greatest disease of this generation… PROCRASTINATION                                                     Press enter to continue",3);
    
    TextBox t = new TextBox(0, 0, 1280, 25,
            "Johnny is an 8th grade student at Silver Oak Middle School. Each day he spends hours playing video games. He’s currently plagued by the greatest disease of this generation… newLine newLine PROCRASTINATION                                            Press enter to continue");            
    public BackStory() {
        
    }

    /**
     * Returns the frame to be displayed on the main menu screen. Currently
     * unfinished, button for Level 1 will bring you to the Title Screen
     * 
     * @return the frame to be displayed
     */

    public JInternalFrame frame() {

        frame = new JInternalFrame("", false, false, false, false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);

        innerPanel.setLayout(null);
        frame.getContentPane().setFocusable(false);

        frame.add(innerPanel);
        innerPanel.add(t);

        frame.setSize(1920, 1080);
        frame.setVisible(true);
        

        

        return frame;

    }

    /**
     * Drawing class for paiting text onto the Main Menu screen
     */
    class Drawing extends Canvas {
        public void paint(Graphics g) {
            Image[] iArr = new Image[1];
            try {
                iArr[0] = ImageIO.read(new File("\\gaming.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            //The two bins

            g.drawImage(iArr[0], 0, 500, 200, 180, null);
            g.setFont(new Font("Courier New", Font.PLAIN, 80));
            g.drawString("Race Against Time", 0, 0);
            g.setColor(new Color(255, 190, 50));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public class Panel extends JPanel {
        /**
         * Paints the background onto the screen
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Image[] iArr = new Image[4];
            try {
                iArr[0] = ImageIO.read(new File("Main\\gaming.png"));
            
            } catch (IOException e) {
                e.printStackTrace();
            }

            g.drawImage(iArr[0], 140, 130,1280,680,null);



            // Image[] iArr = new Image[4];
            // try {
            //     iArr[0] = ImageIO.read(new File("Level2\\Images\\basketball.png"));
            //     iArr[1] = ImageIO.read(new File("Level2\\Images\\laptop.png"));
            //     iArr[2] = ImageIO.read(new File("Level2\\Images\\nitendoSwitch.png"));
            //     iArr[3] = ImageIO.read(new File("Level2\\Images\\phone.png"));
            // } catch (IOException e) {
            //     e.printStackTrace();
            // }

            // for(int i = 0; i<20; i++){
            //     int k =(int)(Math.random()*400)+150;
            //     g.drawImage(iArr[(int)(Math.random()*4)], (i%4)*320+(int)(Math.random()*20), (i/4)*320+(int)(Math.random()*20),k,k,null);
            // }

        }
    }
}