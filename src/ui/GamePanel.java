package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import ui.listeners.ClickListener;
import content.PlayingCard;

public class GamePanel extends JPanel {
	private ArrayList<Tableau> myTableaus;
	private final static int WIDTH = 640;
	private final static int HEIGHT = 480;	
	private Stock myStock;
	private RuleCheckBox ruleBox;
	private JButton renew;
	private HelpCheckBox helpBox;
	
	public GamePanel() {
		super();
		myTableaus=new ArrayList<Tableau>(4);
	    this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
	    this.setBackground(Color.WHITE);
	    makeTab();
	    makeStock();
	    ruleBox=new RuleCheckBox("apply real rules");
	    helpBox=new HelpCheckBox("notify me before I deal cards");
	    makerenew();
		for (Tableau each : myTableaus){
			this.add(each);
		}
	    this.add(renew);
	    this.add(myStock);
	    this.add(ruleBox);
	    this.add(helpBox);
	    this.setLayout(null);
	}


	
	private void makerenew(){
	    renew=new JButton("new game");
	    renew.addMouseListener(new NewGameListener());
	    renew.setBackground(Color.white);
	    renew.setLocation(180, 350);
	    renew.setSize(100, 40);
	 	//renew.setBorderPainted(false);
	}

	class RuleCheckBox extends JCheckBox {

		public RuleCheckBox(String text) {
			super(text);
			this.setLocation(380, 350);
			this.setBackground(Color.white);
			this.setSize(180, 40);
		}
	}
	
	class HelpCheckBox extends JCheckBox {

		public HelpCheckBox(String text) {
			super(text);
			this.setLocation(380, 390);
			this.setBackground(Color.white);
			this.setSize(280, 40);
		}
	}
	
	
	
	
	
	private void makeTab(){
		for (int i=1;i<=4;i++){
		Tableau tab = new Tableau(i);
		tab.addMouseListener(new TabListener(tab));
		myTableaus.add(tab);
		}
		//System.out.println(myTableaus.size());
	}
	
    class StockListener extends ClickListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			JButton b=(JButton)e.getSource();
			if (!b.isEnabled()){
				return;
			}
			if (!checkHelp()){
			myStock.act(myTableaus);}
		}
    }
    
    class TabListener extends ClickListener{
    	private Tableau myTab;
    	public TabListener(Tableau tab){
    		myTab=tab;
    	}

		@Override
		public void mouseClicked(MouseEvent e) {
			Tableau b=(Tableau)e.getSource();
			if (!b.isEnabled() || b.isEmpty()){
				return;
			}
			myTab.tryAct(myTableaus, ruleBox.isSelected());
			checkGameResult();
		}
    }
    
    
    
    class NewGameListener extends ClickListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			JButton b=(JButton)e.getSource();
			if (!b.isEnabled()){
				return;
			}
			newgame();
		}
    }
    
    
	private void makeStock(){
	    myStock = new Stock();
	    myStock.addMouseListener(new StockListener());

	}
	
	private void newgame(){
		myStock.shuffle();
		myStock.setEnabled(true);
		//myStock.updateUI();
		for (Tableau each : myTableaus){
			each.setEnabled(true);
			each.clear();
		}
		System.out.println("new game.");
		repaint();
	}


	private boolean checkHelp(){
		if (helpBox.isSelected()){
				for (int i=0;i<4;i++){
					Tableau temp=myTableaus.get(i);
					if(temp.checkMove(myTableaus,ruleBox.isSelected())!=null){
						System.out.println("Tableau "+(i+1)+" is still removable.");
						return true;
					};
				}
				return false;
				
		}
		return false;
	}
	
	
	private void checkGameResult(){
		if (isWin()){
			System.out.println("You win!!");
			myStock.setEnabled(false);
			for (Tableau a:myTableaus){
				a.setEnabled(false);
			}
			System.out.println("p.s.you win the game but lose the life (¨s£à¡õ¡ä)¨s£¨©ß©¥©ß");
		}
		else{
		if (isLose()){
			System.out.println("You Lose....");
			myStock.setEnabled(false);
			for (Tableau a:myTableaus){
				a.setEnabled(false);
			}
		}}
	}

	private boolean isWin(){
		if (myStock.isEmpty()){
			for (Tableau each : myTableaus){
				if (!each.isEmpty()) return false;
			}
			return true;
		}
		else{
			return false;
		}
	}
	private boolean isLose(){
		if (myStock.isEmpty()){
			for (int i=0;i<4;i++){
				Tableau temp=myTableaus.get(i);
				if(temp.checkMove(myTableaus,ruleBox.isSelected())!=null){
					return false;
				};
			}
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		GameWindow a=new GameWindow();
		a.start();
	}
}
