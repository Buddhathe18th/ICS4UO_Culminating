package Level3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.time.*;
import java.util.*;

import Level2.CharacterHand;

public class Level3Frame extends JInternalFrame implements KeyListener {

    public static boolean win = false;

    public int timeLeft;

    public Panel innerPanel;
    public int score = 0;

    public Level3Char level3Char;

    public ArrayList<Item> itemsLeft = new ArrayList<Item>(6);

    public final static int[][] maze = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
            { 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
            { 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1 },
            { 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
            { 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
            { 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

    public Level3Frame() {
        super("", false, false, false, false);

        Calendar calendar = Calendar.getInstance();
        timeLeft=200;
        setFocusable(false);
        this.getContentPane().setFocusable(false);

        level3Char = new Level3Char();
        innerPanel = new Panel();
        innerPanel.setLocation(300, 0);

        this.setSize(1920, 1080);
        this.setVisible(true);

        innerPanel.add(level3Char);

        this.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getRootPane().setWindowDecorationStyle(0);
        this.setLayout(null);

        // Image array of the images on the components, so far just one image
        Image[] iArr = new Image[1];
        try {
            iArr[0] = ImageIO.read(new File("Level2\\Images\\a.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        addItem(iArr[0], 4, 7);
        addItem(iArr[0], 2, 15);
        addItem(iArr[0], 7, 19);
        addItem(iArr[0], 9, 12);
        addItem(iArr[0], 15, 3);
        addItem(iArr[0], 16, 17);
        addItem(iArr[0], 20, 17);

        innerPanel.setLayout(null);
        innerPanel.setVisible(true);
        innerPanel.setSize(1920, 1080);
        this.add(innerPanel);
        this.addKeyListener(this);
        innerPanel.addKeyListener(this);
        this.requestFocus();
    }

    public void addItem(Image i, int x, int y) {

        Item i1 = new Item(i);
        itemsLeft.add(i1);
        i1.setLocation(20 * x, 250 + 20 * y);
        innerPanel.add(i1);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (level3Char.column == 25) {
                if (itemsLeft.size() == 0) {
                    win = true;
                }
                Main.Main.screenNum++;
            }

            System.out.println("right");
            if (level3Char.column + 1 < 26
                    && maze[level3Char.row][level3Char.column + 1] == 0) {
                level3Char.column++;
            }
            innerPanel.revalidate();
            innerPanel.repaint();
            revalidate();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("left");
            if (level3Char.column - 1 > -1
                    && maze[level3Char.row][level3Char.column - 1] == 0) {
                level3Char.column--;
            }
            innerPanel.revalidate();
            innerPanel.repaint();
            revalidate();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("up");
            if (level3Char.row - 1 > -1
                    && maze[level3Char.row - 1][level3Char.column] == 0) {
                level3Char.row--;
            }
            innerPanel.revalidate();
            innerPanel.repaint();
            revalidate();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("down");
            if (level3Char.row + 1 < 26
                    && maze[level3Char.row + 1][level3Char.column] == 0) {
                level3Char.row++;
            }
            innerPanel.revalidate();
            innerPanel.repaint();
            revalidate();
            repaint();
        }

        level3Char.setLocation(level3Char.column * 20, level3Char.row * 20 + 250);

        for (int i = 0; i < itemsLeft.size(); i++) {
            if (level3Char.getX() == itemsLeft.get(i).getX() && level3Char.getY() == itemsLeft.get(i).getY()) {
                itemsLeft.get(i).setVisible(false);
                itemsLeft.get(i).collect();
                itemsLeft.remove(itemsLeft.get(i));
                i--;
                itemsLeft.trimToSize();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * Panel class to hold all drawings and components
     */
    public class Panel extends JPanel {
        /**
         * Draws the text boxes to the Game Panel.
         *
         * @param g the Graphics context in which to paint
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int row = 0; row < maze.length; row++) {
                for (int col = 0; col < maze[row].length; col++) {
                    if (maze[row][col] == 1) {
                        g.setColor(Color.BLACK);
                    } else {
                        g.setColor(Color.WHITE);
                    }

                    int x = col * 20;
                    int y = row * 20;
                    g.fillRect(x, y + 250, 20, 20);
                }
            }

            g.drawString("Objects left: " + itemsLeft.size(), 0, 100);
            g.drawString("Time left: " + timeLeft, 0, 200);

            g.setColor(Color.BLACK);
            g.fillPolygon(new int[] { 0, 500, 250 }, new int[] { 0, 0, -200 }, 3);
        }
    }
}
