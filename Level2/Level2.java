package Level2;

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

    public CharacterHand hand = new CharacterHand();

    /**
     * Score of the player, goes up if sorted correctly, goes down if sorted wrong
     */
    public static int score = 0;

    /**
     * Constructor for the Level 2 class
     */

    public Level2(){
        score=0;

        //Image array of the images on the components, so far just one image
        Image[] iArr = new Image[8];
        try {
            iArr[0] = ImageIO.read(new File("Level2\\Images\\nitendoSwitch.png"));
            iArr[1] = ImageIO.read(new File("Level2\\Images\\laptop.png"));
            iArr[2] = ImageIO.read(new File("Level2\\Images\\phone.png"));
            iArr[3] = ImageIO.read(new File("Level2\\Images\\basketball.png"));

            iArr[4] = ImageIO.read(new File("Level2\\Images\\calculator.png"));
            iArr[5] = ImageIO.read(new File("Level2\\Images\\pencil.png"));
            iArr[6] = ImageIO.read(new File("Level2\\Images\\backPack.png"));
            iArr[7] = ImageIO.read(new File("Level2\\Images\\binder.png"));
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
        frame.setSize(1200, 900);
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
         * Paints the background onto the screen
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Image[] iArr = new Image[1];
            try {
                iArr[0] = ImageIO.read(new File("Level2\\Images\\bin.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            //The two bins

            g.drawImage(iArr[0], 0, 500, 200, 180, null);
            g.drawImage(iArr[0], 1220, 500, 200, 180, null);

            Image[] iArr1 = new Image[1];
            try {
                iArr1[0] = ImageIO.read(new File("Level2\\Images\\table.png"));
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