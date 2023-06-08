package Main;
import java.awt.*;

import javax.swing.*;

public class Credits {
    /**
     * Panel class to hold all drawings and components
     */
    public class Panel extends JPanel {

        public Panel() {
            setSize(1200,900);
            setOpaque(true);
            setBackground(Color.WHITE);
        }
        /**
         * Draws the text boxes to the Game Panel.
         *
         * @param g the Graphics context in which to paint
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    }

    public static void main(String[] args) {
        new Credits();
    }
}