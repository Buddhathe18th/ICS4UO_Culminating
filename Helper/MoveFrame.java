package Helper;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import Level2.CharacterHand;

public class MoveFrame extends JInternalFrame implements KeyListener{
    public CharacterHand hand;

    public ArrayList<DragAndDrop> draggableArrayList = new ArrayList<DragAndDrop>(1);

    public MoveFrame(CharacterHand h) {
        super("",false,false,false,false);
        hand= h;
        // Image array of the images on the components, so far just one image
        Image[] iArr = new Image[1];
        try {
            iArr[0] = ImageIO.read(new File("Level2\\a.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Adds all components that belong in non-school related bin
        for (int i = 1; i <= 1; i++) {
            DragAndDrop i1 = new DragAndDrop(iArr[0], 100, 100, false);
            draggableArrayList.add(i1);
            i1.setLocation(i * 100, i * 100);
            this.add(i1);
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("key");
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            if(hand.grab){
                hand.grabbedObj.setLocation(hand.grabbedObj.x + 100, hand.grabbedObj.y);
                hand.grabbedObj.x = hand.grabbedObj.x + 100;
            }
            System.out.println("right");
            hand.setLocation(hand.x + 100, hand.y);
            hand.x = hand.x + 100;
            revalidate();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            if(hand.grab){
                hand.grabbedObj.setLocation(hand.grabbedObj.x - 100, hand.grabbedObj.y);
                hand.grabbedObj.x = hand.grabbedObj.x - 100;
            }

            System.out.println("left");
            hand.setLocation(hand.x - 100, hand.y);
            hand.x = hand.x - 100;
            revalidate();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {

            if(hand.grab){
                hand.grabbedObj.setLocation(hand.grabbedObj.x, hand.grabbedObj.y-100);
                hand.grabbedObj.y = hand.grabbedObj.y - 100;
            }

            System.out.println("up");
            hand.setLocation(hand.x, hand.y - 100);
            hand.y = hand.y - 100;
            revalidate();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

            if(hand.grab){
                hand.grabbedObj.setLocation(hand.grabbedObj.x, hand.grabbedObj.y+100);
                hand.grabbedObj.y = hand.grabbedObj.y + 100;
            }
            System.out.println("down");
            hand.setLocation(hand.x, hand.y + 100);
            hand.y = hand.y + 100;
            revalidate();
            repaint();
        }

        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (hand.grab) {
                hand.grabbedObj.grabbed = false;
                hand.grab = false;
            } else {
                for (DragAndDrop d : draggableArrayList) {
                    if (d.checkCollision(hand.x, hand.y, 100, 100)){
                        hand.grab=true;
                        d.grabbed=true;
                        hand.grabbedObj=d;
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
