package content;


public class PlayingCard implements Comparable<PlayingCard> {
	
	private int suit;
	private int rank;
	public static final int HEART=0;
	public static final int DIAMOND=1;
	public static final int CLUB=2;
	public static final int SPADE=3;
	public static final int JACK=11;
	public static final int QUEEN=12;
	public static final int KING=13;
	public static final int ACE=1;
	
	
	

	public PlayingCard(int suit, int rank) {
		switch (suit){
		case HEART:
			this.suit=HEART;
			break;
		case DIAMOND:
			this.suit=DIAMOND;
			break;
		case CLUB:
			this.suit=CLUB;
			break;
		case SPADE:
			this.suit=SPADE;
			break;
		default:
			throw new IllegalArgumentException("unrecognizable suit type");		
		}
		this.rank=rank;
	}

	
	public int compareTo(PlayingCard o) {
		if (o==null) throw new NullPointerException();
		return this.rank-o.rank;
	}
	
	public int getSuitType(){
		return this.suit;
	}
	
	public String getSuitName(){
		String name="";
		switch (this.suit){
		case DIAMOND:
			name="Diamond";
			break;
		case HEART:
			name="Heart";
			break;
		case SPADE:
			name="Spade";
			break;
		case CLUB:
			name="Club";
			break;
		}
		return name;
	}
	
	
	public int getRank(){
		return this.rank;
	}
	
	@Override
	public String toString() {
		String s = getSuitName()+", "+getRank();
		return s;
	}
	
	public static void main(String[] args) {
		PlayingCard a=new PlayingCard(0,0);
		
	}

}
