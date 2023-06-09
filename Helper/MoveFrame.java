package Helper;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import Level2.CharacterHand;

public class MoveFrame extends JInternalFrame implements KeyListener {

    public int score = 0;

    /**
     * Panel containing all graphics
     */
    public Panel innerPanel = new Panel();

    public CharacterHand hand;

    public ArrayList<DragAndDrop> draggableArrayList = new ArrayList<DragAndDrop>(6);

    public class Panel extends JPanel {

        /**
         * Paints the background onto the screen
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Image[] iArr = new Image[2];
            try {
                iArr[0] = ImageIO.read(new File("Level2\\Images\\schoolBin.png"));
                iArr[1] = ImageIO.read(new File("Level2\\Images\\nonschoolBin.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            //The two bins

            g.drawImage(iArr[0], 0, 500, 200, 180, null);
            g.drawImage(iArr[1], 950, 500, 200, 180, null);

            Image[] iArr1 = new Image[1];
            try {
                iArr1[0] = ImageIO.read(new File("Level2\\Images\\table.png"));
            } catch (IOException e) {
                System.out.println("broken");
            }

            //The table
            g.drawImage(iArr1[0], 200, 180, 800, 450, null);

            // Trim size of the arraylist to the size of the current amount of elements
            draggableArrayList.trimToSize();

            // On screen showing the number of components left
            g.drawString("Objects remaining: " + String.valueOf(draggableArrayList.size()), 100, 100);
            g.drawString("Score: " + String.valueOf(score), 100, 150);
        }
    }

    public MoveFrame() {
        super("", false, false, false, false);
        this.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getRootPane().setWindowDecorationStyle(0);

        this.setLayout(null);

        hand = new CharacterHand();
        innerPanel.add(hand);
        // Image array of the images on the components, so far just one image
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

        addDrag(iArr[0], 100, 50, false, 400, 200);
        addDrag(iArr[1], 200, 200, false, 550, 75);
        addDrag(iArr[2], 90, 90, false, 200, 465);
        addDrag(iArr[3], 120, 120, false, 860, 465);

        // Add all components that belong in the school-related bin

        addDrag(iArr[4], 90, 110, true, 400,495);
        addDrag(iArr[5], 100, 100, true, 800,185);
        addDrag(iArr[6], 200, 200, true, 537,486);
        addDrag(iArr[7], 150, 150, true, 700,426);

        innerPanel.setLayout(null);
        innerPanel.setVisible(true);
        innerPanel.setSize(1920, 1080);
        this.add(innerPanel);
    }

    public void addDrag(Image i,int w, int h, boolean school,int x, int y){
        DragAndDrop d = new DragAndDrop(i, w, h,school);
            draggableArrayList.add(d);
            d.setLocation(x,y);
            innerPanel.add(d);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(hand.grab);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("right");
            if (hand.grab) {
                hand.grabbedObj.setLocation(hand.grabbedObj.getX() + 10, hand.grabbedObj.getY());
            }
            hand.setLocation(hand.x + 10, hand.y);
            hand.x = hand.x + 10;
            revalidate();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("left");
            if (hand.grab) {
                hand.grabbedObj.setLocation(hand.grabbedObj.getX() - 10, hand.grabbedObj.getY());
            }
            hand.setLocation(hand.x - 10, hand.y);
            hand.x = hand.x - 10;
            revalidate();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("up");
            if (hand.grab) {
                hand.grabbedObj.setLocation(hand.grabbedObj.getX(), hand.grabbedObj.getY() - 10);
            }
            hand.setLocation(hand.x, hand.y - 10);
            hand.y = hand.y - 10;
            revalidate();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("down");

            if (hand.grab) {
                hand.grabbedObj.setLocation(hand.grabbedObj.getX(), hand.grabbedObj.getY() + 10);
            }
            hand.setLocation(hand.x, hand.y + 10);
            hand.y = hand.y + 10;
            revalidate();
            repaint();
        }

        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Space bar");
            innerPanel.revalidate();
            revalidate();
            innerPanel.repaint();
            if (hand.grab) {
                if (hand.grabbedObj.school == true) {
                    if (hand.grabbedObj.checkCollision(innerPanel.getX(), innerPanel.getY() + 600, 200, 180)) {

                        // Removing and repainting the screens
                        innerPanel.remove(hand.grabbedObj);
                        innerPanel.revalidate();
                        revalidate();
                        innerPanel.repaint();
                        score++;

                        // To delete this later to not run into a ConcurrentModification exception
                        draggableArrayList.remove(hand.grabbedObj);
                        draggableArrayList.trimToSize();
                        hand.grabbedObj = null;
                    } else if (hand.grabbedObj.checkCollision(innerPanel.getX() + 950, innerPanel.getY() + 600, 200,
                            180)) {
                        innerPanel.remove(hand.grabbedObj);
                        innerPanel.revalidate();
                        revalidate();
                        innerPanel.repaint();
                        score--;
                        draggableArrayList.remove(hand.grabbedObj);
                        draggableArrayList.trimToSize();
                        hand.grabbedObj = null;
                    }
                } else {
                    if (hand.grabbedObj.checkCollision(innerPanel.getX(), innerPanel.getY() + 600, 200, 180)) {

                        // Removing and repainting the screens
                        innerPanel.remove(hand.grabbedObj);
                        innerPanel.revalidate();
                        revalidate();
                        innerPanel.repaint();
                        score--;

                        // To delete this later to not run into a ConcurrentModification exception
                        draggableArrayList.remove(hand.grabbedObj);
                        draggableArrayList.trimToSize();
                        hand.grabbedObj = null;
                    } else if (hand.grabbedObj.checkCollision(innerPanel.getX() + 950, innerPanel.getY() + 600, 200,
                            180)) {
                        innerPanel.remove(hand.grabbedObj);
                        innerPanel.revalidate();
                        revalidate();
                        innerPanel.repaint();
                        score++;
                        draggableArrayList.remove(hand.grabbedObj);
                        draggableArrayList.trimToSize();
                        hand.grabbedObj = null;
                    }
                }

                if (draggableArrayList.size() <= 0) {
                    Main.Main.screenNum++;
                }

                System.out.println("set value 1" + hand.grab);
                hand.grab = !hand.grab;
                hand.grabbedObj = null;
            } else {
                for (DragAndDrop d : draggableArrayList) {
                    if (d.checkCollision(hand.x, hand.y, 100, 100)) {
                        System.out.println("set value 2" + hand.grab);
                        hand.grab = true;
                        d.grabbed = true;
                        hand.grabbedObj = d;
                    }
                }
            }
        }
        hand.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
