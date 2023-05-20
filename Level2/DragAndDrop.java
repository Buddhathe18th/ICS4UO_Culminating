package Level2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Basic template for all components that are drag and droppable.
 * Basic idea from <a href="https://stackoverflow.com/questions/874360/swing-creating-a-draggable-component">StackExchange</a>
 * Spent around 1.5 hours on this class.
 * 
 * @author Alex Zhu
 * @version 0.1.0
 * @date 05/18/2023
 */

public class DragAndDrop extends JComponent implements MouseListener, MouseMotionListener {

  /**
   * Absolute position of the mouse of the screen
   */
  private int screenX = 0;
  private int screenY = 0;

  /**
   * Coordinates of the top left corner of the component
   */
  private int x = 0;
  private int y = 0;

  /**
   * Image of the component
   */
  private Image image;

  /**
   * Width of the image
   */
  private int width;

  /**
   * Height of the image
   */
  private int height;

  /**
   * Constructor for the DragAndDrop class.
   * 
   * @param im Image for the component to look like. Not implemented yet.
   * @param xNew Width of the component
   * @param yNew Height of the component
   */

  public DragAndDrop(Image im, int xNew, int yNew) {
    width = xNew;
    height = yNew;

    image = im;// For when we have an image for the drag and drop
    setBounds(0, 0, width, height);
    setOpaque(false);

    addMouseListener(this);
    addMouseMotionListener(this);
  }

  public void paint(Graphics g) {
    //Paint method just draws a 400 by 400 red square

    // g.drawImage(image, 0, 0, width, height, null);
    // int[] xCoord={100,100,300,300};
    // int[] yCoord={100,300,300,100};
    // g.fillPolygon(xCoord, yCoord, 4);
    g.setColor(Color.RED);
    g.drawRect(0, 0, 400, 400);
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

    //Change the location of the component depending on the distance the mouse was moved
    setLocation(x + changeX, y + changeY);
  }

  @Override
  public void mouseMoved(MouseEvent e) {
  }

}