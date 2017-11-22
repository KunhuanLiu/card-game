package reference;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/** A basic GUI for displaying a Mole graphical object */
public class MoleGUI {
  
  /** width and height of the gui */
  private static final int WIDTH = 500;
  private static final int HEIGHT = 500;
  
  /** window for the gui */
  private JFrame frame;
  
  /** primary Panel all components will be added to */
  private JPanel primary;
  
  /** the components: a MolePanel */
  private MolePanel molePanel;
  
  /** Creates the MoleGUI */
  public MoleGUI() {
    
      // create the frame and primary panel
      this.frame = new JFrame ("MoleGUI");
      this.frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      this.primary = new JPanel();
      primary.setPreferredSize(new Dimension(WIDTH, HEIGHT));

      // create the molePanel and add to the primary panel
      this.molePanel = new MolePanel();
      this.primary.add(molePanel);
      
      // add primary panel to frame and display
      this.frame.getContentPane().add(this.primary);
      this.frame.pack();
      this.frame.setVisible(true);
  }

  /** main methods creates a new MoleGUI */
  public static void main (String[] args) {
    MoleGUI gui = new MoleGUI();
  }
  


}