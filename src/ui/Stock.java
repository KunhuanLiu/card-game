package ui;
import java.awt.*;
import java.awt.event.MouseListener;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import content.*;

public class Stock extends JButton{
	private CardStack myStack;
	private int x; //the position for image
	private int y;//position for image
	private ImageIcon image;

	public Stock() {
		x=285;
		y=280;
		myStack = new CardStack(52);
		shuffle();
		image=getPic();
		setIcon(image);
		setLocation(x, y);
		setSize(70,120);
	 	setBorderPainted(false);
	 	setContentAreaFilled(true);
	 	setIconTextGap(0);
	}
	
	public void test(){
		setIcon(null);
	}

	public void act(ArrayList<Tableau> tabs){
		PlayingCard temp;
		for(Tableau a:tabs){
			temp=myStack.pop();
			a.add(temp);
		}
		if (this.isEmpty()){
			setIcon(null);
			setEnabled(false);
		}
	}
	

	public void shuffle(){
		myStack.clear();
		ArrayList<PlayingCard> arr = new ArrayList<PlayingCard>(52);
		for (int i=0;i<4;i++){
			for (int j=1;j<14;j++){
				arr.add(new PlayingCard(i, j));
			}
		}
		//System.out.println(arr.size());
		Random a;int b;
		for (int i=51;i>=1;i--){
		a = new Random();
		b=a.nextInt(i);
		myStack.add(arr.remove(b));
		//System.out.println(arr.get(b));
		}
		myStack.add(arr.remove(0));
		//System.out.println(arr.size()+"aa");
		setIcon(getPic());
	}



	public boolean isEmpty(){
		if (myStack.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}

/*
	public void repaint(){
		c.repaint(x-10, y-10, 90, 140);
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(x-2, y-2, 74, 124);
		if(image!=null){
			//System.out.println(x);
			//System.out.println(y);
		image.paintIcon(this, g, x, y);
		super.paintComponent(g);
		}
	}
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
	}
	 	protected void paintComponent(Graphics g) {
		ImageIcon image=getPic();
		//TODO ¼ÓÒ»¸ö±ß¿ò
		g.setColor(Color.black);
		g.drawRect(x-2, y-2, 74, 124);
		if(image!=null){
			//System.out.println(x);
			//System.out.println(y);
		image.paintIcon(this, g, x, y);
		super.paintComponent(g);
	}
		 */
	
	
	/**
	 * 
	 * @return the image icon object whose location is in src/ui/cards/
	 */
	private ImageIcon getPic(){
		if (myStack.isEmpty()){
			return null;
		}
		else{
			URL picUri= Stock.class.getResource("/ui/cards/back.png");
			System.out.println(picUri);
			return new ImageIcon(picUri);
		}
	}

	public static void main(String[] args) {
		Stock a =new Stock();
		a.shuffle();
	}

}
