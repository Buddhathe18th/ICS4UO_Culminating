import javax.swing.*;
import java.awt.*;
import java.time.format.TextStyle;
import java.util.*;

class TextBox extends JComponent {
    private int x;
    private int y;
    private int width;
    private int fontSize;
    private int textPerLine;
    private ArrayList<String> lines;

    public TextBox(int x1, int y1, int w, int f, String t) {
        x = x1;
        y = y1;
        width = w;
        fontSize = f;
        textPerLine = (int)(w*1.4/fontSize);
        String[] text = t.split(" ");
        int maxLen = textPerLine;
        lines = new ArrayList<String>();

        String temp = "";
        for (String l: text) {
            if (maxLen - l.length() < 0) {
                maxLen = textPerLine;
                lines.add(temp);
                temp = "";
            }
            temp += l + " ";
            maxLen -= l.length();
        }
        lines.add(temp);
    }

    public int getFontSize() {
        return fontSize;
    }

    public int[] getCoords() {
        return new int[] {x, y};
    }

    public int getWidth() {
        return width;
    }

    public ArrayList<String> getText() {
        return lines;
    }
}