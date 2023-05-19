import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Level3 extends JComponent{

    public Level3() {
        JFrame frame = new JFrame("Level 3");
        frame.setSize(1920,1080);
        frame.add(new Level3Maze());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Level3();
    }
}