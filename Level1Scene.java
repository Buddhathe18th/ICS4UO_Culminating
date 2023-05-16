import javax.swing.*;
import java.awt.*;

public class Level1Scene {
    private Image[] images;
    private TextBox initialText;
    private TextBox[] afterText;
    private TextBox infoText;

    public Level1Scene(/*Image[] i, */String initial, String[] choices, String info) {
        //images = i;
        afterText = new TextBox[2];
        initialText = new TextBox(0, 0, 1000, 25, initial);
        afterText[0] = new TextBox(100, 500, 500, 25, choices[0]);
        afterText[1] = new TextBox(800, 500, 500, 25, choices[1]);
        infoText = new TextBox(0, 700, 1000, 25, info);
    }

    public void paint(Graphics g) {

    }
}