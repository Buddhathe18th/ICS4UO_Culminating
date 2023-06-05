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
import javax.swing.KeyStroke;

import Helper.DragAndDrop;
import Helper.MoveFrame;

public class CharacterDriver {
    static Character t = new Character();

    public static void main(String[] args) {
        MoveFrame frame = new MoveFrame();

        frame.setSize(1920, 1080);
        frame.setVisible(true);

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setFocusable(true);
        frame.setVisible(true);
        frame.pack();
        frame.setFocusable(true);
        System.out.println(frame.requestFocusInWindow());
        frame.addKeyListener(frame);

        frame.add(t);
    }
}
