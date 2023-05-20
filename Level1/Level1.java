package Level1;
import javax.swing.*;
import java.awt.*;

/**
 * Level 1 game and driver class for now. Includes 1 scenario so far without images.
 * Time Spent: 1.5 hours
 * 
 * @author Lukas Li
 * @version 0.1.0
 * @date 05/18/2023
 * 
 */

class Level1 extends JComponent {
    private int scenarios;
    private Image[] images;
    String[] initial;
    String[] choices;
    String[] info;

    /**
     * Constructor for the Level1 class.
     * 
     * @param im Images to be displayed in the scenarios. Not implemented yet.
     * @param in The initial text shown at the top of the screen in each scenario, introducing the scenario
     * @param c The text blurbs show at the bottom of each choice after the player selects one, showing if they are correct or not 
     * @param inf The info blurbs show at the bottom of the screen every time the player completes a scenario.
     */
    public Level1(/*Image[] im, */String[] in, String[] c, String inf[]) {
        scenarios = 4;
        images = new Image[scenarios*2];
        JFrame frame = new JFrame("Level 1");
        frame.setSize(1920,1080);
        
        //images = im;
        initial = in;
        choices = c;
        info = inf;

        for (int i = 0; i < initial.length; i++) {
            frame.add(new Level1Scene(initial[i], new String[] {choices[i*2], choices[i*2+1]}, info[i]));
            frame.setVisible(true);
            //Pause until player goes to next scene
        }
    }

    /**
     * Temporary main class used to test the scenarios.
     */
    public static void main(String[] args) {
        
        String[] init = {"Johnny wants to go play basketball, but has a math assignment due tomorrow. Which choice should he make?"};
        String[] c = {"Incorrect! If Johnny has an assignment due tomorrow, delaying it further could be impeding his learning.", 
                    "Correct! If Johnny has a math assignment due tomorrow, getting started on it will be the better choice."};
        String[] inf = {"Fun Fact! Sports are good for your mental health, but at times like these, commiting and working is still the overall best choice!"};
        new Level1(init, c, inf);
}
    }