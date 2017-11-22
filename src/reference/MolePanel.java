package reference;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/** A Panel that contains a single Mole graphical object */
public class MolePanel extends JPanel {
  
  /** width and height of the panel */
  public static final int WIDTH = 500;
  public static final int HEIGHT = 500;
  
  /** Mole graphical object to be drawn on this panel */
  private Mole mole;
  
  /** Creates a new MolePanel */
  public MolePanel() {
    
    // create a new Mole Object
    this.mole = new Mole();
    
    // set the size and background of the panel
    this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
    this.setBackground(Color.WHITE);
  }
  
  /** Overrides paintComponent to draw the Mole graphical object on the screen */
  public void paintComponent(Graphics g) {
    // call super class method
    super.paintComponent(g);
    
    // tell the mole to draw itself
    //It needs a reference to the component (this) and the graphics object
    this.mole.draw(this, g);
  }

}
    