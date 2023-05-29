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

public class DragAndDrop extends JComponent implements MouseListener, MouseMotionListener {

  /**
   * Absolute x position of the mouse of the screen
   */
  private int screenX = 0;

  /**
   * Absolute y position of the mouse of the screen
   */
  private int screenY = 0;

  /**
   * X coordinates of the top left corner of the component
   */
  private int x = 0;

  /**
   * Y coordinates of the top left corner of the component
   */
  private int y = 0;

  /**
   * Image of the component
   */
  private Image image;

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

    width = xNew;
    height = yNew;
    school = schoolRelated;

    image = im;
    setBounds(0, 0, width, height);
    setSize(width, height);
    setOpaque(false);

    addMouseListener(this);
    addMouseMotionListener(this);
  }

  public void paintComponent(Graphics g) {
    // Paint method just draws a 400 by 400 red square, with image specified
    super.paintComponent(g);
    g.setColor(getBackground());

    g.setColor(new Color(255, 0, 0, 177));
    g.drawRect(0, 0, width, height);
    g.drawString(String.valueOf(image == null), 0, 0);
    g.drawImage(image, 0, 0, width, height, null);
  }

  public boolean checkCollision(int binX, int binY, int binWidth, int binHeight) {
    //Debuggin print statements, prints coordinates, and the boolean expressions for the two axis
    System.out.println(x + " " + y + "   " + binX + " " + binY);
    System.out.println(y + height < binY || y > binY + binHeight);
    System.out.println((x + width < binX || x > binX + binWidth) + "\n");
    if (!((y + height < binY || y > binY + binHeight) || (x + width < binX || x > binX + binWidth)))
      return true;
    return false;
  }

  // MouseListener methods

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mousePressed(MouseEvent e) {
    screenX = e.getXOnScreen();
    screenY = e.getYOnScreen();
    x = getX();
    y = getY();
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  // MouseMotionListener methods

  @Override
  public void mouseDragged(MouseEvent e) {
    int changeX = e.getXOnScreen() - screenX;
    int changeY = e.getYOnScreen() - screenY;

    // Change the location of the component depending on the distance the mouse was
    // moved
    setLocation(x + changeX, y + changeY);
    x = getX();
    y = getY();
    screenX = e.getXOnScreen();
    screenY = e.getYOnScreen();
  }

  @Override
  public void mouseMoved(MouseEvent e) {
  }

}