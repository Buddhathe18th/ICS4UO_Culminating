package Helper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Basic template for all components that are drag and droppable.
 * Basic idea from <a href=
 * "https://stackoverflow.com/questions/874360/swing-creating-a-draggable-component">StackExchange</a>
 * Spent around 1.5 hours on this class.
 * 
 * <h2>Modification</h2>
 * Added two new attributes, del and school, and one new method for checking for collisions
 * Spent around 30 minutes
 * 
 * @author Alex Zhu
 * @version 0.2.0
 * @date 05/28/2023
 */

public class DragAndDrop extends JComponent{

  /**
   * Image of the component
   */
  private Image image;

  public boolean grabbed = false;

  /**
   * To be deleted on the next collision check
   */

  public boolean del = false;

  /**
   * Width of the image
   */
  private int width;

  /**
   * Height of the image
   */
  private int height;

  /**
   * If the item should be in the school-related bin or the unrelated bin
   */
  public boolean school;

  /**
   * Constructor for the DragAndDrop class.
   * 
   * @param im   Image for the component to look like. Not implemented yet.
   * @param xNew Width of the component
   * @param yNew Height of the component
   */

  public DragAndDrop(Image im, int xNew, int yNew, boolean schoolRelated) {
    grabbed=false;
    width = xNew;
    height = yNew;
    school = schoolRelated;

    image = im;
    setBounds(0, 0, width, height);
    setSize(width, height);
    setOpaque(false);
  }

  public void paintComponent(Graphics g) {
    // Paint method just draws a 400 by 400 red square, with image specified
    super.paintComponent(g);
    g.setColor(getBackground());
    g.drawImage(image, 0, 0, width, height, null);
  }

  public boolean checkCollision(int binX, int binY, int binWidth, int binHeight) {
    //Debuggin print statements, prints coordinates, and the boolean expressions for the two axis
    if (!((getY() + height < binY || getY() > binY + binHeight) || (getX() + width < binX || getX() > binX + binWidth)))
      return true;
    return false;
  }
}