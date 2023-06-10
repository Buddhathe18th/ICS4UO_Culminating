package Level3;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import Helper.DragAndDrop;
import Helper.MoveFrame;

/**
 * Level 2 game class
 * Time Spent: 2 hours
 * 
 * <h2>Modifications</h2>
 * Changed layout of drag and drop items into an arraylist, so far just has the 6 out of the 10 needed
 * Panel class to contain all of the graphics stops some issues with the JFrame
 * There are also more attributes such as objLeft and score to be implemented better with the actual game
 * Spent around 3 hours
 * 
 * <h2> Modifications</h2>
 * 
 * Final 8 drag and drops are added, changed collision to the correct bins
 * 
 * 
 * @author Alex Zhu
 * @version 1.0.0
 * 
 */

public class Level3 {

    /**
     * One drag and droppable item on the screen
     */
    public ArrayList<DragAndDrop> draggableArrayList = new ArrayList<DragAndDrop>(6);
    

    /**
     * The screen to display on the JFrame
     */
    public MoveFrame frame;

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
     * The hand that grabs items
     */
    public CharacterHand hand = new CharacterHand();

    /**
     * Score of the player, goes up if sorted correctly, goes down if sorted wrong
     */
    public static int score = 0;

    /**
     * Constructor for the Level 2 class
     */
    public Level3(){
        score=0;

        //Image array of the images on the components, so far just one image
        Image[] iArr = new Image[8];
        try {
            iArr[0] = ImageIO.read(getClass().getResource("Images\\nitendoSwitch.png"));
            iArr[1] = ImageIO.read(getClass().getResource("Images\\laptop.png"));
            iArr[2] = ImageIO.read(getClass().getResource("Images\\phone.png"));
            iArr[3] = ImageIO.read(getClass().getResource("Images\\basketball.png"));

            iArr[4] = ImageIO.read(getClass().getResource("Images\\calculator.png"));
            iArr[5] = ImageIO.read(getClass().getResource("Images\\pencil.png"));
            iArr[6] = ImageIO.read(getClass().getResource("Images\\backPack.png"));
            iArr[7] = ImageIO.read(getClass().getResource("Images\\binder.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        addDrag(iArr[0], 100, 50, false, 400, 325);
        addDrag(iArr[1], 200, 200, false, 800, 325);
        addDrag(iArr[2], 80, 80, false, 200, 625);
        addDrag(iArr[3], 120, 120, false, 900, 625);


        //Add all components that belong in the school-related bin

        for(int i = 4; i<=7;i++){
            DragAndDrop i1 = new DragAndDrop(iArr[i], 100, 100,true);
            draggableArrayList.add(i1);
            i1.setLocation(300+i*100, i*100);
        }

        hand.setLocation(0, 0);
    }

    /**
     * Method to add a new DragAndDrop item to the screen
     * @param i Image the item would be
     * @param w width of the item
     * @param h height of the item
     * @param school whether or not the item should belong in the school bin
     * @param x the x coordinates of the top left corner
     * @param y the y coordinates of the top left corner
     */
    
    public void addDrag(Image i,int w, int h, boolean school,int x, int y){
        DragAndDrop d = new DragAndDrop(i, w, h,school);
            draggableArrayList.add(d);
            d.setLocation(x,y);
    }

    /**
     *  Makes all components and drawings that will be on the Level 2 game screen
     * 
     * @return the JInternalFrame to add to the screen
     */
    public JInternalFrame frame() {
        MoveFrame frame = new MoveFrame();

        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 960);
        frame.setFocusable(true);
        frame.setVisible(true);
        frame.requestFocus();
        frame.addKeyListener(frame);
        
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

            Image[] iArr = new Image[2];
            try {
                iArr[0] = ImageIO.read(getClass().getResource("..\\Level3\\Images\\schoolBin.png"));
                iArr[0] = ImageIO.read(getClass().getResource("..\\Level3\\Images\\nonschoolBin.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            //The two bins

            g.drawImage(iArr[0], 0, 500, 200, 180, null);
            g.drawImage(iArr[1], 1220, 500, 200, 180, null);

            Image[] iArr1 = new Image[1];
            try {
                iArr1[0] = ImageIO.read(getClass().getResource("..\\Level3\\Images\\table.png"));
            } catch (IOException e) {
                System.out.println("broken");
            }

            //The table
            g.drawImage(iArr1[0], 300, 230, 800, 600, null);

            //Trim size of the arraylist to the size of the current amount of elements
            draggableArrayList.trimToSize();

            //On screen showing the number of components left
            g.drawString("Objects remaining: " + String.valueOf(draggableArrayList.size()), 100, 100);
            g.drawString("Score: "+String.valueOf(score),100,150);
        }
    }
}