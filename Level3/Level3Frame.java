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

import Level2.CharacterHand;

public class Level3Frame extends JInternalFrame implements KeyListener {

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

        // Adds all components that belong in non-school related bin
        for (int i = 1; i <= 6; i++) {
            Item i1 = new Item(iArr[0]);
            itemsLeft.add(i1);
            i1.setLocation(i * 100, i * 100+10);
            innerPanel.add(i1);
        }

        innerPanel.setLayout(null);
        innerPanel.setVisible(true);
        innerPanel.setSize(1920, 1080);
        this.add(innerPanel);
        this.addKeyListener(this);
        innerPanel.addKeyListener(this);
        this.requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("right");
            if (level3Char.column + 1 < 25
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
            if (level3Char.row + 1 < 25
                    && maze[level3Char.row + 1][level3Char.column] == 0) {
                level3Char.row++;
            }
            innerPanel.revalidate();
            innerPanel.repaint();
            revalidate();
            repaint();
        }

        level3Char.setLocation(level3Char.column * 20, level3Char.row * 20+250);


        for(Item i: itemsLeft){
            if (level3Char.getX()==i.getX()&&level3Char.getY()==i.getY()){
                i.setVisible(false);
                i.collect();

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
                    g.fillRect(x, y+250, 20, 20);
                }
            }

            g.setColor(Color.BLACK);
            g.fillPolygon(new int[] {0, 500, 250 }, new int[] { 0, 0, -200 }, 3);
        }
    }
}
