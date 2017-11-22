package reference;

import java.awt.Component;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * A Mole graphical object that can draw itself in a Component
 */
public class Mole {
  
  /** width and height of the graphical object */
  private static final int WIDTH = 80;
  private static final int HEIGHT = 80;
  
  /** location in the component */
  private int x, y;
  
  /** an ImageIcon to be drawn for this graphical object */
  private ImageIcon image;
  
  /** Creates the Mole graphical object to be drawn at a random location */
  public Mole() {
    
    // create the file name and image icon object
    String filename = "FinalProject\\ui\\mole.jpg";
    //String filename = "mole.jpg";

    this.image = new ImageIcon(filename);
    System.out.println(image.getDescription());
    // put the mole at a random location on the screen
    Random rand = new Random();
    this.x = rand.nextInt(MolePanel.WIDTH - this.WIDTH);
    this.y = rand.nextInt(MolePanel.HEIGHT - this.HEIGHT);
  }
  
  /** draws the Mole graphical object on the screen
    * @param c The Component the Mole will be drawn in
    * @param g The Graphics object for drawing the image
    */
  public void draw(Component c, Graphics g) {
    
    // mole draws itself by telling the ImageIcon to paint
    // needs the component to be drawn in, graphics object, and location
    image.paintIcon(c, g, x, y);
  }
  

}
    