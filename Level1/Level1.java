package Level1;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Level 1 game and driver class for now. Includes 1 scenario so far without images.
 * Time Spent: 3 hours
 * 
 * <h2>Modifications</h2>
 * Drew new images and allowed the images to be clicked
 * 
 * @author Lukas Li
 * @version 0.2.0
 * @date 05/28/2023
 * 
 */

class Level1 extends JComponent {

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
    String[] initial;

    /**
     * The reaction messages the game will have depending on the user's choice
     */
    String[] choices;

    /**
     * The fun fact displayed after each scenario
     */
    String[] info;

    static boolean changed;

    public Level1() {}

    /**
     * Constructor for the Level1 class.
     * 
     * @param im Images to be displayed in the scenarios. Not implemented yet.
     * @param in The initial text shown at the top of the screen in each scenario, introducing the scenario
     * @param c The text blurbs show at the bottom of each choice after the player selects one, showing if they are correct or not 
     * @param inf The info blurbs show at the bottom of the screen every time the player completes a scenario.
     */
    public Level1(Image[] im, String[] in, String[] c, String inf[]) {
        scenarios = 4;
        images = new Image[scenarios*2];
        JFrame frame = new JFrame("Level 1");
        frame.setSize(1920,1080);
        
        images = im;
        initial = in;
        choices = c;
        info = inf;
        changed = true;
        int scene = 0;
        frame.setVisible(true);
        while (scene < scenarios) {
            if (changed) {
                changed = false;
                frame.getContentPane().removeAll();
                frame.add(new Level1Scene(new Image[] {images[scene*2], images[scene*2+1]}, initial[scene], new String[] {choices[scene*2], choices[scene*2+1]}, info[scene++]).frame());
                frame.getContentPane().repaint();
            }
            System.out.print("");
        }
    }
    
    /**
     * Temporary main class used to test the scenarios.
     */

    public static void changeScene() {
        changed = true;
    }
    public static void main(String[] args) {
        
        String[] init = {"Johnny wants to go play basketball, but has a math assignment due tomorrow. Which choice should he make?", 
                        "Johnny has been playing Minecraft with his best friend, Bernie, for two hours now. Johnny also has to finish a journal for English. Which option should Johnny pick?", 
                        "Johnny has a big science project due next week. However, he also has some history homework due tomorrow. Which assignment should he work on?   ", 
                        "It’s 1am, and Johnny just finished his assignment. He has an urge to watch some Youtube. What should he do?"};
        String[] c = {"Incorrect! If Johnny has an assignment due tomorrow, delaying it further could be impeding his learning.", 
                    "Correct! If Johnny has a math assignment due tomorrow, getting started on it will be the better choice.", 
                    "Correct! If Johnny has an English assignment, he should prioritize doing it over playing video games.", 
                    "Incorrect! If Johnny continues playing Minecraft with his friend, he would have less time to finish his homework.", 
                    "Incorrect! Johnny should prioritize assignments that are due earlier.", 
                    "Correct! Johnny should prioritize assignments that are due earlier, regardless of if he likes the subject or not.", 
                    "Correct! Sleeping can help keep your body healthy and ready for the next day!", 
                    "Incorrect! Without sleep, Johnny will be fatigued and very unfocused the next day.", 
                };
        String[] inf = {"Fun Fact! Sports are good for your mental health, but at times like these, commiting and working is still the overall best choice! Press enter to continue...", 
                        "Fun Fact! According to research from Brigham Young University, video game breaks can increase productivity by up to 20%. But make sure not to play too much! Too many video games can lead to many problems such as a reduced attention span.", 
                        "Fun Fact! According to research from Brigham Young University, video game breaks can increase productivity by up to 20%, but make sure not to play too much! Too many video games can lead to many problems such as a decreased attention span and eye strain.", 
                        "Fun Fact! Being sleep deprived will make you behave in similar ways to being drunk! According to Harvard Medical School, going 48 hours without sleep is equivalent to having a 0.1% blood alcohol content, which is higher than the legal amount to drive!", 
                        };
        Image[] i = new Image[8];
        try {
            i[0] = ImageIO.read(new File("Level1\\Image\\atom.png"));
            i[1] = ImageIO.read(new File("Level1\\Image\\basketball.png"));
            i[2] = ImageIO.read(new File("Level1\\Image\\calculator.png"));
            i[3] = ImageIO.read(new File("Level1\\Image\\history.png"));
            i[4] = ImageIO.read(new File("Level1\\Image\\ipad.png"));
            i[5] = ImageIO.read(new File("Level1\\Image\\pencil.png"));
            i[6] = ImageIO.read(new File("Level1\\Image\\pillow.png"));
            i[7] = ImageIO.read(new File("Level1\\Image\\youtube.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        new Level1(i, init, c, inf);
    }
}