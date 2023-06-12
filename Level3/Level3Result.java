package Level3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Helper.MoveFrame;
import Helper.TextBox;

/**
 * Level 2 result class, displays if the user wins or loses
 * Time Spent: 1 hours
 * 
 * <h2>Modifications</h2>
 * Works with boolean of the Level 2 win
 * Time Spent: 1 hours
 * 
 * 
 * @author Alex Zhu
 * @version 1.0.0
 * 
 */

public class Level3Result implements ActionListener{
    /**
     * The screen to display on the JFrame
     */
    JInternalFrame frame;
    
    /**
     * Panel containing all graphics
     */
    Panel innerPanel = new Panel();

    /**
     * whether the user won the level 2 or not
     */
    
    boolean win;

    /**
     * Button for Level 3
     */
    JButton creditButton;

    /**
     * Button for main menu
     */
    JButton mainMenu;

    JButton restartButton;

    /**
     * Textbox of wining
     */
    TextBox winText = new TextBox(1, 0, 1185, 25, "Success! You have successfully cleaned Johnny's table. He's now able to work on his homework without distractions!");
    
    /**
     * Textbox of losing
     */
    TextBox loseText = new TextBox(1, 0, 1185, 25, "Uh oh, you messed up a little bit. Next time, help Johnny clear his desk better so he can work!");

    /**
     * Default constructor for the Level 2 class
     */
    public Level3Result() {}

    /**
     *  Makes all components and drawings that will be on the Level 2 game screen
     * 
     * @return the JInternalFrame to add to the screen
     */
    public JInternalFrame frame() {
        frame = new JInternalFrame("", false, false, false, false);
        frame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setWindowDecorationStyle(0);

        innerPanel.setLayout(null);

        frame.add(innerPanel);

        frame.setSize(1920, 1080);
        frame.setVisible(true);

        if(MoveFrame.score>=4){
            innerPanel.add(winText);
            Main.Main.win2=true;
        }
        else{
            innerPanel.add(loseText);
        }

        restartButton = new JButton("Restart");
        creditButton = new JButton("Credits");
        mainMenu = new JButton("Main menu");
        restartButton.addActionListener(this);
        creditButton.addActionListener(this);
        mainMenu.addActionListener(this);

        restartButton.setBackground(new Color(70, 100, 200));
        restartButton.setForeground(Color.WHITE);
        restartButton.setFocusPainted(false);
        restartButton.setFont(new Font("Tahoma", Font.BOLD, 24));
        restartButton.setBorder(BorderFactory.createLineBorder(new Color(50, 70, 150), 3));
        creditButton.setBackground(new Color(70, 100, 200));
        creditButton.setForeground(Color.WHITE);
        creditButton.setFocusPainted(false);
        creditButton.setFont(new Font("Tahoma", Font.BOLD, 24));
        creditButton.setBorder(BorderFactory.createLineBorder(new Color(50, 70, 150), 3));
        mainMenu.setBackground(new Color(70, 100, 200));
        mainMenu.setForeground(Color.WHITE);
        mainMenu.setFocusPainted(false);
        mainMenu.setFont(new Font("Tahoma", Font.BOLD, 24));
        mainMenu.setBorder(BorderFactory.createLineBorder(new Color(50, 70, 150), 3));
        

        if(Main.Main.win2){
            innerPanel.add(creditButton);
        }
        else{
            innerPanel.add(restartButton);
        }


        
        innerPanel.add(mainMenu);
        restartButton.setSize(new Dimension(600, 50));
        creditButton.setSize(new Dimension(600, 50));
        mainMenu.setSize(new Dimension(600,50));
        restartButton.setLocation(405, 300);
        creditButton.setLocation(405, 300);
        mainMenu.setLocation(405, 375);

        return frame;
    }

    /**
     * Panel class to hold all drawings and components
     */
    public class Panel extends JPanel {

        /**
         * Default constructor for the Panel class
         */
        public Panel() {
        }

        /**
         * Paints the background onto the screen
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            Image[] iArr = new Image[1];
            try {
                iArr[0] = ImageIO.read(getClass().getResource("mainBackground.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            g.drawImage(iArr[0], 0, 0, 1300, 951, null);
        }
    }

    /**
     * Button action listener to prompt buttons
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==creditButton){
            Main.Main.screenNum=15;//TODO: change to level 3 number when implemented
        }
        else if(e.getSource()==mainMenu){
            Main.Main.screenNum=3;//change screen to main menu
        }
        
    }
}