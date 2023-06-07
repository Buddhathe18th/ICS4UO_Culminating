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

            Image[] iArr = new Image[1];
            try {
                iArr[0] = ImageIO.read(new File("Level2\\bin.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // The two bins

            g.drawImage(iArr[0], 0, 500, 200, 180, null);
            g.drawImage(iArr[0], 1220, 500, 200, 180, null);

            Image[] iArr1 = new Image[1];
            try {
                iArr1[0] = ImageIO.read(new File("Level2\\table.png"));
            } catch (IOException e) {
                System.out.println("broken");
            }

            // The table
            g.drawImage(iArr1[0], 300, 130, 800, 600, null);

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
        // Image array of the images on the components, so far just one image
        Image[] iArr = new Image[1];
        try {
            iArr[0] = ImageIO.read(new File("Level2\\a.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Adds all components that belong in non-school related bin
        for (int i = 1; i <= 6; i++) {
            DragAndDrop i1 = new DragAndDrop(iArr[0], 100, 100, false);
            draggableArrayList.add(i1);
            i1.setLocation(i * 100, i * 100);
            innerPanel.add(i1);
        }

        innerPanel.setLayout(null);
        innerPanel.setVisible(true);
        innerPanel.setSize(1920, 1080);
        this.add(innerPanel);

        innerPanel.add(hand);
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
            if (hand.grab) {
                if (hand.grabbedObj.school==true){
                    if (hand.grabbedObj.checkCollision(innerPanel.getX(), innerPanel.getY() + 500, 200, 180)) {

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
                    } else if (hand.grabbedObj.checkCollision(innerPanel.getX() + 1220, innerPanel.getY() + 500, 200,
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
                }
                else{
                    if (hand.grabbedObj.checkCollision(innerPanel.getX(), innerPanel.getY() + 500, 200, 180)) {

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
                    } else if (hand.grabbedObj.checkCollision(innerPanel.getX() + 1220, innerPanel.getY() + 500, 200,
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

                if(draggableArrayList.size()<=0){
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
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
