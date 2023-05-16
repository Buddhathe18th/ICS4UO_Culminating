import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TitleScreen {
    
    Drawing draw = new Drawing();

    public static void main(String[] args) {
        TitleScreen t = new TitleScreen();
    }

    public TitleScreen() {
        JFrame frame = new JFrame("Race Against Time");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(draw);

        KeyListener k = new KeyListener() {
            public void keyTyped(KeyEvent event) {
                return;
            }

            public void keyReleased(KeyEvent event) {
                return;
            }

            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == event.VK_ENTER) {
                    //nextFrame
                    draw.repaint();
                }
            }
        };
        frame.addKeyListener(k);

        // Add labelled input fields to display
        // JPanel inFieldPane = new JPanel();
        // inFieldPane.setLayout(new GridLayout(3, 0));
        // JPanel topTitle = new JPanel();
        // topTitle.add(new Drawing());
        // topTitle.add(new JLabel("LC Studios Presents..."));
        // inFieldPane.add(topTitle);
        // inFieldPane.add(new JLabel("Race Against Time"));
        // inFieldPane.add(new JLabel("Press enter to continue..."));
        // frame.add(inFieldPane);

        // inFieldPane.add(new JLabel("Given Name"));
        // inFieldPane.add(givenName);
        // givenName.addActionListener(this);
        // inFieldPane.add(new JLabel("Family Name"));
        // inFieldPane.add(familyName);
        // familyName.addActionListener(this);
        // frame.add(inFieldPane, BorderLayout.NORTH);
        // // Add submission button
        // JPanel submitPane = new JPanel();
        // submitPane.setLayout(new FlowLayout());
        // submitPane.add(new JLabel("Press Button to Enter Names"));
        // KeyListener k = new KeyListener() {
        // public void keyTyped(KeyEvent event) {
        // return;
        // }

        // public void keyReleased(KeyEvent event) {
        // return;
        // }

        // public void keyPressed(KeyEvent event) {
        // if (event.getKeyCode() == event.VK_ENTER) {
        // String fullString = familyName.getText().trim() + ", "
        // + givenName.getText().trim();
        // fullName.setText(fullString);
        // }
        // }
        // };
        // givenName.addKeyListener(k);
        // familyName.addKeyListener(k);
        // submitPane.add(submitButton);
        // frame.add(submitPane, BorderLayout.CENTER);

        // // Add Output fields
        // JPanel outFieldPane = new JPanel();
        // outFieldPane.setLayout(new GridLayout(1, 2));
        // outFieldPane.add(new JLabel("Full Name"));
        // outFieldPane.add(fullName);
        // frame.add(outFieldPane, BorderLayout.SOUTH);
        // // Display the final product
        frame.setSize(1920, 1080);
        frame.setVisible(true);
    }

    class Drawing extends Canvas {
        public void paint(Graphics g) {
            Toolkit t = Toolkit.getDefaultToolkit();
            Image i = t.getImage("logo.png");
            g.drawImage(i, 35, 52, this);

            g.setFont(new Font("Courier New", Font.PLAIN, 80));
            g.drawString("LC Studios Presents...", 325, 200);
            g.setFont(new Font("Courier New", Font.PLAIN, 50));
            g.drawString("Race Against Time", 475, 400);
            g.setFont(new Font("Courier New", Font.PLAIN, 20));
            g.drawString("Press enter to continue", 550, 600);

        }
    }
}