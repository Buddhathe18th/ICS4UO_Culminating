package Level2;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.text.StyleConstants.CharacterConstants;

import Helper.DragAndDrop;
import Helper.MoveFrame;

public class CharacterDriver {
    static CharacterHand t = new CharacterHand();

    public static void main(String[] args) {

        int i = 0;
        

        JFrame frame = new JFrame("test");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setFocusable(true);
        frame.setVisible(true);

        MoveFrame f = new MoveFrame();

        f.setSize(1920, 1080);
        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1920, 1080);
        f.setFocusable(true);
        f.setVisible(true);
        f.setFocusable(true);
        f.addKeyListener(f);
        frame.add(f);


        t.setLocation(0, 0);
    }
}
