package Level2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Helper.TextBox;

/**
 * Level 3 result page
 * Time Spent: 2 hours
 * 
 * 
 * 
 * @author Alex Zhu
 * @version 1.0.0
 * 
 */

public class Level2Result implements ActionListener{
    /**
     * The screen to display on the JFrame
     */
    JInternalFrame frame;
    
    /**
     * Panel containing all graphics
     */
    Panel innerPanel = new Panel();

    /**
     * whether the character has reached the maze exit
     */
    boolean win;

    /**
     * Button for Level 3
     */
    JButton buttonL3;

    /**
     * Restart button
     */
    JButton restartButton;

    /**
     * Button for main menu
     */
    JButton mainMenu;

    /**
     * If the player has won level 3
     */
    boolean level3Win=false;

    /**
     * Winning textbox
     */
    TextBox winText = new TextBox(1, 0, 1185, 25, "Success! Johnny has successfully picked up all of the items he needs. He now can study diligently at school!");
    
    /**
     * Losing textbox
     */
    TextBox loseText = new TextBox(1, 0, 1185, 25, "Uh oh, you missed a few items and then Johnny missed the bus! Better luck next time!");

    /**
     * Constructor for the Level 3 result
     */
    public Level2Result(){
        Level2Frame.itemsLeft.trimToSize();
        if(Level2Frame.itemsLeft.size()<=0){
            level3Win=true;
        }
    }

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

        Main.Main.g.itemsLeft.trimToSize();
        if(Main.Main.g.timeLeft >= 0 && Main.Main.g.itemsLeft.size()==0){
            innerPanel.add(winText);
            Main.Main.win3=true;
        }
        else{
            innerPanel.add(loseText);
        }

        buttonL3 = new JButton("Level 3");
        mainMenu = new JButton("Main menu");
        restartButton = new JButton("Restart");
        buttonL3.addActionListener(this);
        mainMenu.addActionListener(this);
        restartButton.addActionListener(this);



        if(Main.Main.win3){
            innerPanel.add(buttonL3);
        }
        else{
            innerPanel.add(restartButton);
        }

        
        innerPanel.add(mainMenu);
        buttonL3.setSize(new Dimension(600, 50));
        restartButton.setSize(new Dimension(600, 50));
        mainMenu.setSize(new Dimension(600,50));
        buttonL3.setLocation(300, 300);
        restartButton.setLocation(300, 300);
        mainMenu.setLocation(300, 375);

        Main.Main.buttonFormatting(buttonL3);
        Main.Main.buttonFormatting(restartButton);
        Main.Main.buttonFormatting(mainMenu);

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

            // The two bins

            g.drawImage(iArr[0], 0, 0, 1300, 951, null);
        }
    }

    /**
     * Action listener methods
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==buttonL3){
            Main.Main.screenNum=14;//TODO: change to level 3 number when implemented
        }
        else if(e.getSource()==mainMenu){
            Main.Main.screenNum=3;//change screen to main menu
        }
        else if(e.getSource()==restartButton){
            Main.Main.screenNum=10;//change screen to main menu
            Main.Main.g=new Level2Frame();
        }
        
    }
}