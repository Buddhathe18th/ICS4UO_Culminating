import javax.swing.*;
import java.awt.*;

class TextBox extends JComponent {
    private int x;
    private int y;
    private int width;
    private int fontSize;
    private int textPerLine;
    private String[] text;
    private Font font;

    public TextBox(int x1, int y1, int w, int f, String t) {
        x = x1;
        y = y1;
        width = w;
        fontSize = f;
        textPerLine = (int)(w*1.5/fontSize);
        text = t.split("(?<=\\G.{" + textPerLine + "})");
        font = new Font("Courier New", Font.PLAIN, fontSize);
    }
    
    public void paint(Graphics g) {
        
        g.setFont(font);
        g.drawRect(x, y, width, (int)((text.length+0.25)*fontSize));
        for (int i = 0; i < text.length; i++) g.drawString(text[i], 0, (i+1)*fontSize);
    }
}