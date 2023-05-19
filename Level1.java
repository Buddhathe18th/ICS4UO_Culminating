import javax.swing.*;
import java.awt.*;

class Level1 extends JComponent {
    private int scenarios;
    private Image[] images;
    String initial;
    String[] choices;
    String info;

    public Level1() {
        scenarios = 4;
        images = new Image[scenarios*2];
        JFrame frame = new JFrame("Level 1");
        frame.setSize(1920,1080);
        initial = "Johnny wants to go play basketball, but has a math assignment due tomorrow. Which choice should he make?";
        choices = new String[] {"Incorrect! If Johnny has an assignment due tomorrow, delaying it further could be impeding his learning.", 
                                "Correct! If Johnny has a math assignment due tomorrow, getting started on it will be the better choice."};
        info = "Fun Fact! Sports are good for your mental health, but at times like these, commiting and working is still the overall best choice!";
        frame.add(new Level1Scene(initial, choices, info));
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
        new Level1();
    }
}