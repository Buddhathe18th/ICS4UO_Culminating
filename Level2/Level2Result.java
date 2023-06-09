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
 * Level 2 game class. So far includes just one draggable component.
 * Time Spent: 0.5 hours
 * 
 * <h2>Modifications</h2>
 * Changed layout of drag and drop items into an arraylist, so far just has the 6 out of the 10 needed
 * Panel class to contain all of the graphics stops some issues with the JFrame
 * There are also more attributes such as objLeft and score to be implemented better with the actual game
 * Spent around 3 hours
 * 
 * 
 * @author Alex Zhu
 * @version 0.2.0
 * @date 05/28/2023
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
    Panel innerPanel = new Panel();;

    /**
     * whether the user won the level 2 or not
     */
    
    boolean win;

    /**
     * Button for Level 3
     */
    JButton buttonL3;

    /**
     * Button for main menu
     */
    JButton mainMenu;

    TextBox winText = new TextBox(1, 0, 1185, 25, "Success! You have successfully cleaned Johnny’s table. He’s now able to work on his homework without distractions!");
    TextBox loseText = new TextBox(1, 0, 1185, 25, "Uh oh, you messed up a little bit. Next time, help Johnny clear his desk better so he can work!");

    /**
     * Constructor for the Level 2 class
     */

    public Level2Result(){
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

        if(Level2.score>0){
            innerPanel.add(winText);
        }
        else{
            innerPanel.add(loseText);
        }

        buttonL3 = new JButton("Level 3");
        mainMenu = new JButton("Main menu");
        buttonL3.addActionListener(this);
        mainMenu.addActionListener(this);




        innerPanel.add(buttonL3);
        innerPanel.add(mainMenu);
        buttonL3.setSize(new Dimension(600, 50));
        mainMenu.setSize(new Dimension(600,50));
        buttonL3.setLocation(405, 300);
        mainMenu.setLocation(405, 375);

        return frame;
    }

    /**
     * Panel class to hold all drawings and components
     */
    public class Panel extends JPanel {
        /**
         * Paints the background onto the screen
         */
        protected void paintComponent(Graphics g) {
            Image[] iArr = new Image[1];
            try {
                iArr[0] = ImageIO.read(new File("Level2\\Images\\bin.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // The two bins

            g.drawImage(iArr[0], 0, 600, 200, 180, null);
            g.drawImage(iArr[0], 950, 600, 200, 180, null);

            Image[] iArr1 = new Image[1];
            try {
                iArr1[0] = ImageIO.read(new File("Level2\\Images\\table.png"));
            } catch (IOException e) {
                System.out.println("broken");
            }

            // The table
            g.drawImage(iArr1[0], 250, 130, 700, 525, null);

            g.setColor(new Color(238,238,238,140));
            g.fillRect(0,0,1920,1080);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==buttonL3){
            Main.Main.screenNum=15;//TODO: change to level 3 number when implemented
        }
        else if(e.getSource()==mainMenu){
            Main.Main.screenNum=3;//change screen to main menu
        }
        
    }
}