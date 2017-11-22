package content;


public class CardStack extends Stack<PlayingCard> {

	public CardStack(int cap) {
		super(cap);
	}
	
	public static void main(String[] args) {
		//testing
		CardStack a = new CardStack(20);
		a.add(null);
		a.pop();
		a.isEmpty();
		a.peek();
		
	}

}
