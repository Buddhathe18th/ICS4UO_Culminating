import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    int screenNum=1;
    public static void main(String[] args) {
        Main t = new Main();
    }

    public Main() {
        JFrame frame = new JFrame("Race Against Time");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1920, 1080);
        frame.setVisible(true);
    }
}