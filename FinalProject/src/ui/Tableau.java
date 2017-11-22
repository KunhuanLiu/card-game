package ui;
import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.*;

import content.*;

public class Tableau extends JButton{
	private CardStack myStack;
	private PlayingCard top;
	private int x; //the position for image
	private int y;//position for image
	private ImageIcon image;

	public Tableau(int stackNumber) {
		super();
		x=((2*stackNumber-1)*70);
		y=70;
		myStack = new CardStack(20);
		top=null;
		image=getPic();
		setIcon(image);
		setLocation(x, y);
		setSize(70,120);
	 	setBorderPainted(false);
	 	setContentAreaFilled(true);
	 	setIconTextGap(0);
	}
	

	public void add(PlayingCard card){
		top = card;
		myStack.add(card);
		setIcon(getPic());
	}
	
	public int getSuitType(){
		return top.getSuitType();
	}
	
	public int getRank(){
		return top.getRank();
	}
	
	/**
	 * After you delete the card, you HAVE TO call Tableau to repaint by repaint(Component c) method. Otherwise the card change will not show. 
	 */
	private void delete(){
		PlayingCard t = myStack.pop();
		System.out.println(t.toString()+" is removed.");
		if(myStack.isEmpty()){top=null;}else{
			top=myStack.peek();
		}
		setIcon(getPic());
		repaint();
	}
	
	/*
	public void draw(Component c,Graphics g){
		ImageIcon image=getPic();
		if(image!=null){
			System.out.println(x);
			System.out.println(y);
		image.paintIcon(c, g, x, y);
		}
	}
	*/
	public void clear(){
		myStack.clear();
		top=null;
		setIcon(getPic());
		repaint();
	}
	
	

	/**
	 * 
	 * @return the image icon object whose location is in src/ui/cards/
	 */
	private ImageIcon getPic(){
		if (myStack.isEmpty()){
			return null;
		}
		else{
			URL picUri= Stock.class.getResource("/ui/cards/"+picName());
			System.out.println(picUri+"shows up now.");
			return new ImageIcon(picUri);
		}
	}
	
	private String picName(){
			String name="";
			switch (top.getSuitType()){
			case PlayingCard.DIAMOND:
				name="d";
				break;
			case PlayingCard.HEART:
				name="h";
				break;
			case PlayingCard.SPADE:
				name="s";
				break;
			case PlayingCard.CLUB:
				name="c";
				break;
			}
			String rank="";
			int temp=top.getRank();
			switch (temp){
			case 1:
				rank="a";
				break;
			case 11:
				rank="j";
				break;
			case 12:
				rank="q";
				break;
			case 13:
				rank="k";
				break;
			default:
				rank=String.valueOf(temp);
				break;
			}
			String pic=rank+name+".png";
			//System.out.println(pic);
			return pic;
		
	}
	
	public boolean isEmpty(){
		if (myStack.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		/*Tableau a = new Tableau();
		PlayingCard b=new PlayingCard(1,1);
		a.add(b);
		a.getRank();
		a.getPic();*/
	}


	/**
	 * Remove method needs to take care of a)both tabs; b)one tab;
	 * @param tabList
	 * @param realgame
	 * @return if no possible move, return null; if can only remove myself, return myself; if can remove both, return the other
	 */
	public Tableau checkMove(ArrayList<Tableau> tabList, boolean realgame) {
		if (this.isEmpty()) return null;
		for (Tableau a: tabList){
			if ((a!=this) && (!a.isEmpty())){
				//check them
				if (realgame){
					int a_rank=a.top.getRank();
					int m_rank=this.top.getRank();
					if (a_rank==m_rank){
						return a;
					}
					else if (a.top.getSuitType()==this.top.getSuitType() && a_rank>m_rank){
						return this;
					}
				}
				else{
					return a;
				}
			}
			//end of a turn
		}
		//after the examination and nothing returned--no match
		return null;
	}


	public void tryAct(ArrayList<Tableau> tabs, boolean realgame) {
		// 1.看是否能动
		// 2.如果能动，就delete
		// 3.不能动
		Tableau temp=checkMove(tabs, realgame);
		if (temp!=null){
			if (temp==this){
				this.delete();
			}
			else{
				this.delete();
				temp.delete();
			}
		}
		
	}

}
