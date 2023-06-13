package Level2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;


import java.util.*;

/**
 * Level 3 class
 * This class is a JInternalFrame, that can allow for the Level3Char to move
 * from the arrow keys
 * Time spent: 4 hours
 * 
 * @author Alex Zhu
 * @version 1.0.0
 */
public class Level2Frame extends JInternalFrame implements KeyListener {

    /**
     * If the player has won yet
     */
    public static boolean finish = false;

    /**
     * The amount of time the player has left
     */
    public int timeLeft;

    /**
     * Panel containing all graphics
     */
    public Panel innerPanel;

    /**
     * The amount of items the character has collected
     */
    public int score = 0;

    /**
     * The character in the maze
     */
    public Level2Char level3Char;

    /**
     * The amount of items left to be collected
     */
    public static ArrayList<Item> itemsLeft;

    /**
     * The boolean array fpr the maze, tells where the character can and can't go
     */
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
            { 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1 },
            { 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
            { 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
            { 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

    /**
     * Constructor for the Level3Frame class
     */
    public Level2Frame() {
        super("", false, false, false, false);
        finish = false;

        itemsLeft = new ArrayList<Item>(6);

        timeLeft = 150;
        setFocusable(false);
        this.getContentPane().setFocusable(false);

        level3Char = new Level2Char();
        level3Char.column = 11;
        level3Char.row = 0;
        innerPanel = new Panel();
        innerPanel.setLocation(0, 0);

        this.setSize(1200, 950);
        this.setVisible(true);

        innerPanel.add(level3Char);

        this.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getRootPane().setWindowDecorationStyle(0);
        this.setLayout(null);

        // Image array of the images on the components
        Image[] iArr = new Image[7];
        try {
            iArr[0] = ImageIO.read(getClass().getResource("backPack.png"));
            iArr[1] = ImageIO.read(getClass().getResource("binder.png"));
            iArr[2] = ImageIO.read(getClass().getResource("calculator.png"));
            iArr[3] = ImageIO.read(getClass().getResource("pencil.png"));
            iArr[4] = ImageIO.read(getClass().getResource("laptop.png"));
            iArr[5] = ImageIO.read(getClass().getResource("phone.png"));
            iArr[6] = ImageIO.read(getClass().getResource("history.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        addItem(iArr[0], 4, 7);
        addItem(iArr[1], 2, 15);
        addItem(iArr[2], 7, 19);
        addItem(iArr[3], 9, 12);
        addItem(iArr[4], 15, 3);
        addItem(iArr[5], 16, 17);
        addItem(iArr[6], 20, 17);

        innerPanel.setLayout(null);
        innerPanel.setVisible(true);
        innerPanel.setSize(1200, 950);
        this.add(innerPanel);
        this.addKeyListener(this);
        innerPanel.addKeyListener(this);
        this.requestFocus();
    }

    /**
     * Adding an item to the screen
     * 
     * @param i Image of the item
     * @param x column index
     * @param y row index
     */
    public void addItem(Image i, int x, int y) {

        Item i1 = new Item(i);
        itemsLeft.add(i1);
        i1.setLocation(20 * x + 300, 250 + 20 * y);
        innerPanel.add(i1);

    }

    /**
     * Key Listener methods
     */

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Key Listener methods
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            try {
                this.removeKeyListener(this);
                innerPanel.removeKeyListener(this);
                Thread.sleep(50);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            // 
            if (level3Char.column + 1 < 26
                    && maze[level3Char.row][level3Char.column + 1] == 0) {
                level3Char.column++;
            }
            innerPanel.revalidate();
            innerPanel.repaint();
            revalidate();
            repaint();
            this.addKeyListener(this);
            innerPanel.addKeyListener(this);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // 
            if (level3Char.column - 1 > -1
                    && maze[level3Char.row][level3Char.column - 1] == 0) {
                level3Char.column--;
            }
            innerPanel.revalidate();
            innerPanel.repaint();
            revalidate();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            // 
            if (level3Char.row - 1 > -1
                    && maze[level3Char.row - 1][level3Char.column] == 0) {
                level3Char.row--;
            }
            innerPanel.revalidate();
            innerPanel.repaint();
            revalidate();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            // 
            if (level3Char.row + 1 < 26
                    && maze[level3Char.row + 1][level3Char.column] == 0) {
                level3Char.row++;
            }
            innerPanel.revalidate();
            innerPanel.repaint();
            revalidate();
            repaint();
        }

        level3Char.setLocation(level3Char.column * 20 + 300, level3Char.row * 20 + 250);

        for (int i = 0; i < itemsLeft.size(); i++) {
            if (level3Char.getX() == itemsLeft.get(i).getX() && level3Char.getY() == itemsLeft.get(i).getY()) {
                itemsLeft.get(i).setVisible(false);
                itemsLeft.get(i).collect();
                itemsLeft.remove(itemsLeft.get(i));
                i--;
                itemsLeft.trimToSize();
            }
        }

        if (level3Char.column == 25 && level3Char.row == 23) {
            finish = true;
            
            Main.Main.screenNum = 12;
            level3Char.column = 11;
            level3Char.row = 0;
            return;
        }

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
         * Draws the text boxes to the Game Panel.
         *
         * @param g the Graphics context in which to paint
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Image[] iArr = new Image[1];
            try {
                iArr[0] = ImageIO.read(getClass().getResource("background.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            g.drawImage(iArr[0], -15, 5, 1200, 1185, null);

            for (int row = 0; row < maze.length; row++) {
                for (int col = 0; col < maze[row].length; col++) {
                    if (maze[row][col] == 1)
                        g.setColor(Color.BLACK);
                    else
                        g.setColor(Color.WHITE);

                    int x = col * 20;
                    int y = row * 20;
                    g.fillRect(x + 300, y + 250, 20, 20);
                }
            }

            g.setFont(new Font("Courier New", Font.BOLD, 30));

            g.drawString("Objects left: " + itemsLeft.size(), 100, 40);
            g.drawString("Time left: " + timeLeft, 100, 100);
        }
    }

    /**
     * Key Listener methods
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}