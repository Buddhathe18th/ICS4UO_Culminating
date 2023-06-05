package Helper;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MoveFrame extends JFrame implements KeyListener{
    public Character t;

    public ArrayList<DragAndDrop> draggableArrayList = new ArrayList<DragAndDrop>(1);

    public MoveFrame() {
        t= new Character();
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
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            if(t.grab){
                t.grabbedObj.setLocation(t.grabbedObj.x + 100, t.grabbedObj.y);
                t.grabbedObj.x = t.grabbedObj.x + 100;
            }
            System.out.println("right");
            t.setLocation(t.x + 100, t.y);
            t.x = t.x + 100;
            revalidate();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            if(t.grab){
                t.grabbedObj.setLocation(t.grabbedObj.x - 100, t.grabbedObj.y);
                t.grabbedObj.x = t.grabbedObj.x - 100;
            }

            System.out.println("left");
            t.setLocation(t.x - 100, t.y);
            t.x = t.x - 100;
            revalidate();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {

            if(t.grab){
                t.grabbedObj.setLocation(t.grabbedObj.x, t.grabbedObj.y-100);
                t.grabbedObj.y = t.grabbedObj.y - 100;
            }

            System.out.println("up");
            t.setLocation(t.x, t.y - 100);
            t.y = t.y - 100;
            revalidate();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

            if(t.grab){
                t.grabbedObj.setLocation(t.grabbedObj.x, t.grabbedObj.y+100);
                t.grabbedObj.y = t.grabbedObj.y + 100;
            }
            System.out.println("down");
            t.setLocation(t.x, t.y + 100);
            t.y = t.y + 100;
            revalidate();
            repaint();
        }

        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (t.grab) {
                t.grabbedObj.grabbed = false;
                t.grab = false;
            } else {
                for (DragAndDrop d : draggableArrayList) {
                    if (d.checkCollision(t.x, t.y, 100, 100)){
                        t.grab=true;
                        d.grabbed=true;
                        t.grabbedObj=d;
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
