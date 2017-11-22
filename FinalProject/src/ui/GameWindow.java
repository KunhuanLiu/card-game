package ui;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow {
	private JFrame myFrame;
	private JPanel primary;
	private JPanel contentPanel;
	/* panelπ‹’‚–©∞°
	private Tableau tab1;
	private Tableau tab2;
	private Tableau tab3;
	private Tableau tab4;
	private Stock stock;
	*/

	public GameWindow() {
		this.myFrame=new JFrame();
		//size, close operation, and title
		myFrame.setSize(640,480);
		myFrame.setTitle("Idiot's Delight    --by Kunhuan Liu");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.primary=new JPanel();
		primary.setPreferredSize(new Dimension(640,480));
		myFrame.getContentPane().add(primary);
		
	}
	
	public void start(){
		
		

		GamePanel gPanel = new GamePanel();
		primary.add(gPanel);
		myFrame.pack();
		myFrame.setVisible(true);
		//gPanel.test();
	}
	
	

	
	public static void main(String[] args) {
		//Learnt from Oracle!! Not quite understand the mechanism of event-dispatching but I do understand this code!
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GameWindow newWindow = new GameWindow();
                newWindow.start();
            }
        });
	}

}
