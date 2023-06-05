package Level2;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import Helper.DragAndDrop;

/**
 * Level 2 game class
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

public class Level2 {

    /**
     * One drag and droppable item on the screen
     */
    public ArrayList<DragAndDrop> draggableArrayList = new ArrayList<DragAndDrop>(6);
    

    /**
     * The screen to display on the JFrame
     */
    JInternalFrame frame;

    /**
     * X coordinates of the character
     */

    public static int charX;

    /**
     * Y coordinates of the character
     */

    public static int charY;
    
    /**
     * Panel containing all graphics
     */
    public Panel innerPanel = new Panel();

    /**
     * Number of objects left to sort
     */
    public int objLeft=6;

    /**
     * Score of the player, goes up if sorted correctly, goes down if sorted wrong
     */
    public int score = 0;

    /**
     * Constructor for the Level 2 class
     */

    public Level2(){

        //Image array of the images on the components, so far just one image
        Image[] iArr = new Image[1];
        try {
            iArr[0] = ImageIO.read(new File("Level2\\a.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Adds all components that belong in non-school related bin
        for(int i = 1; i<=3;i++){
            DragAndDrop i1 = new DragAndDrop(iArr[0], 100, 100,false);
            draggableArrayList.add(i1);
            i1.setLocation(i*100, i*100);
        }

        //Add all components that belong in the school-related bin

        for(int i = 1; i<=3;i++){
            DragAndDrop i1 = new DragAndDrop(iArr[0], 100, 100,true);
            draggableArrayList.add(i1);
            i1.setLocation(300+i*100, i*100);
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

        for(int i = 1; i<=6;i++){
            innerPanel.add(draggableArrayList.get(i-1));;
        }

        frame.add(innerPanel);

        frame.setSize(1920, 1080);
        frame.setVisible(true);
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

            //Trim size of the arraylist to the size of the current amount of elements
            draggableArrayList.trimToSize();

            //On screen showing the number of components left
            g.drawString("Objects remaining: " + String.valueOf(draggableArrayList.size()), 100, 100);
            g.drawString("Score: "+String.valueOf(score),100,150);
        }
    }
}