import javax.swing.*;
import java.awt.*;

class LevelOne extends JComponent {
    private int scenarios;
    private Image[] images;

    public LevelOne() {
        scenarios = 4;
        images = new Image[scenarios*2];
        JFrame frame = new JFrame("Graphical Greeting");
        frame.setSize(1920,1080);
        frame.add(new TextBox(0, 0, 400, 50, "qwertyuiopasdfghjklzxcvb"));
        frame.setVisible(true);
    }

    public boolean Scen1() {
        return true;
    }

    public boolean Scen2() {
        return true;
    }

    public boolean Scen3() {
        return true;
    }

    public static void main(String[] args) {
        new LevelOne();
    }
}