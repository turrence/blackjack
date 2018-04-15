public class Card{
	
	private int value;//1 - 13
	private Suits suit;//hearts, diamonds, clubs, spades
	private String desc;//1 - 13 of suit
	
	public Card(int num, Suits suit){
		this.value = num;
		this.suit = suit;
		switch(value){
			case 1: this.desc = "Ace of " + this.suit; break;
			case 2: this.desc = "Two of " + this.suit; break;
			case 3: this.desc = "Three of " + this.suit; break;
			case 4: this.desc = "Four of " + this.suit; break;
			case 5: this.desc = "Five of " + this.suit; break;
			case 6: this.desc = "Six of " + this.suit; break;
			case 7: this.desc = "Seven of "  + this.suit; break;
			case 8: this.desc = "Eight of " + this.suit; break;
			case 9: this.desc = "Nine of " + this.suit; break;
			case 10: this.desc = "Ten of " + this.suit; break;
			case 11: this.desc = "Jack of "+ this.suit; break;
			case 12: this.desc = "Queen of "+ this.suit; break;
			case 13: this.desc = "King of "+ this.suit; break;
			default: this.desc = this.value + " of " + this.suit; break;
		}
	}
	
	public String getDesc(){return this.desc;}
	public Suits getSuit(){return this.suit;}
	public int getValue(){return this.value;}
	
	public String toString(){return this.desc;}
}