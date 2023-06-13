package Level1;

import javax.swing.*;
import java.awt.*;

/**
 * Level 1 game and driver class for now. Includes 4 functional scenarios with
 * buttons and images.
 * Time Spent: 6 hours
 * 
 * <h2>Modifications</h2>
 * Cleaned up code, added more text, and allowed the level to be displayed on a
 * specified JFrame
 * 
 * @author Lukas Li
 * @version 1.0.0
 * 
 */
public class Level1 extends JComponent {

    /**
     * Number of different situations the player will solve in Level 1
     */
    private int scenarios;

    /**
     * The photos of objects the player will choose between
     */
    private Image[] images;

    /**
     * Initial text that is shown to the user at the beginning of the game
     */
    private String[] initial;

    /**
     * The reaction messages the game will have depending on the user's choice
     */
    private String[] choices;

    /**
     * The fun fact displayed after each scenario
     */
    private String[] info;

    /**
     * The names of the choices displayed in each scenario
     */
    private String[] choiceNames;

    /**
     * If the scene is to be changed
     */
    private static boolean changed;

    /**
     * No argument constructor for the Level1 class.
     */
    public Level1() {
    }

    /**
     * Constructor for the Level1 class.
     * 
     * @param f   The JFrame on which all the scenes are displayed
     * @param im  Images to be displayed in the scenarios.
     * @param in  The initial text shown at the top of the screen in each scenario,
     *            introducing the scenario
     * @param c   The text blurbs show at the bottom of each choice after the player
     *            selects one, showing if they are correct or not
     * @param inf The info blurbs show at the bottom of the screen every time the
     *            player completes a scenario.
     * @param cN  The names of the choices to be used in the scene
     */
    public Level1(JFrame f, Image[] im, String[] in, String[] c, String inf[], String[] cN) {
        scenarios = 4;
        images = new Image[scenarios * 2];

        images = im;
        initial = in;
        choices = c;
        info = inf;
        changed = true;
        choiceNames = cN;
        int scene = 0;
        while (scene < scenarios + 1) {
            if (changed) {
                if (scene < scenarios) {
                    changed = false;
                    f.getContentPane().removeAll();
                    f.add(new Level1Scene(new Image[] { images[scene * 2], images[scene * 2 + 1] }, initial[scene],
                            new String[] { choices[scene * 2], choices[scene * 2 + 1] }, info[scene],
                            new String[] { choiceNames[scene * 2], choiceNames[scene++ * 2 + 1] }).frame())
                            .setLocation(0, -15);
                    f.getContentPane().repaint();
                } else {
                    changed = false;
                    f.getContentPane().removeAll();
                    scene++;
                }
            }
            try {
                Thread.sleep(500);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Changes the scene being displayed
     */
    public static void changeScene() {
        changed = true;
    }
}