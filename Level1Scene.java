import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Level1Scene extends JComponent{
    private Image[] images;
    private TextBox[] textBoxes;

    public Level1Scene(/*Image[] i, */String initial, String[] choices, String info) {
        //images = i;
        textBoxes = new TextBox[4];
        textBoxes[0] = new TextBox(0, 0, 1000, 25, initial);
        textBoxes[1] = new TextBox(100, 500, 500, 25, choices[0]);
        textBoxes[2] = new TextBox(800, 500, 500, 25, choices[1]);
        textBoxes[3] = new TextBox(0, 700, 1000, 25, info);
    }

    public void paint(Graphics g) {
        int fontSize;
        int width;
        int[] coords;
        ArrayList<String> text;

        for (TextBox t: textBoxes) {
            fontSize = t.getFontSize();
            width = t.getWidth();
            coords = t.getCoords();
            text = t.getText();
            g.setFont(new Font("Courier New", Font.PLAIN, fontSize));
            g.drawRect(coords[0], coords[1], width, (int)((text.size()+0.25)*fontSize));
            for (int i = 0; i < text.size(); i++) g.drawString(text.get(i), coords[0], coords[1]+(i+1)*fontSize);
        }
    }
}