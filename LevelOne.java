import javax.swing.*;
import java.awt.*;

class LevelOne extends JComponent {
    private int scenarios;
    private Image[] images;

    public LevelOne() {
        scenarios = 4;
        images = new Image[scenarios];
        JFrame frame = new JFrame("Graphical Greeting");
        frame.setSize(400,400);
        frame.add(new textBox(0, 0, 100, 100, 50, "123456789012"));
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

    class textBox extends JComponent
    {
        private int x;
        private int y;
        private int width;
        private int height;
        private int fontSize;
        private double fontScaling;
        private String text;
        public textBox(int x1, int y1, int w, int h, int f, String t) {
            x = x1;
            y = y1;
            width = w;
            height = h;
            fontSize = f;
            text = t;
            fontScaling = 100.0/3;
        }
        
        public void paint(Graphics g) {
            Font largeSerifFont = new Font("Courier New", Font.PLAIN, fontSize);
            g.setFont(largeSerifFont);
            g.drawRect(x, y, 1000, fontSize*5/4);
            g.drawString(text, 0, fontSize);
        }
        
    }
    public static void main(String[] args) {
        new LevelOne();
    }
}