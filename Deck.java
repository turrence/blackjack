//By Terence Tong
import java.util.*;

public class Deck{
	private Card[] cards;
	private ArrayList<Card> usedCards;
	private ArrayList<Card> unusedCards;
	
	public Deck(){
		Card[] c = new Card[52];
		//creates all the cards
			int j = 0;
			for(Suits s: Suits.values()){
				for(int i = 1; i < 14; i++){
					c[j] = new Card(i, s);
					j++;
				}
			}
		this.cards = c;
		this.usedCards = new ArrayList<>();
		this.unusedCards = new ArrayList<>();
		for(int i  = 0; i < cards.length; i++)
			this.unusedCards.add(this.cards[i]);
	}
	
	public String toString(){
		String msg = "";
		for(int i = 0; i < this.cards.length; i++){
			msg += cards[i].getDesc() + "\n";
		}
		return msg;
	}
	
	public Card[] cards(){return this.cards;}
	/* 
	public void standardShuffle(){
		Card[] d1 = new Card[this.cards.length/2];
		Card[] d2 = new Card[this.cards.length/2];
		for(int i = 0; i < cards.length; i++){
			if(i < this.cards.length/2){
				d1[i] = cards[i];
			} else {
				d2[i-this.cards.length/2] = cards[i];		
			}
		}
		for(int i = 0; i < cards.length; i++){
			if(i%2 == 0)
				cards[i] = d1[i/2];
			else
				cards[i] = d2[i/2];
		}
	}
	
	public void suitShuffle(){
		int index = 0;
		for(int i = 0; i < this.cards.length; i++){
			if(this.cards[i].getSuit().equals(Suits.Hearts))
				cards[i].setSuit(Suits.Diamonds);
			else if(this.cards[i].getSuit().equals(Suits.Diamonds))
				cards[i].setSuit(Suits.Hearts);
			else if(this.cards[i].getSuit().equals(Suits.Clubs))
				cards[i].setSuit(Suits.Spades);
			else if(this.cards[i].getSuit().equals(Suits.Spades))
				cards[i].setSuit(Suits.Clubs);
		}
	} 
	 */
	
	public Card deal(){
		if(this.unusedCards.size() == 0)
			this.reset();
		int num = (int) (Math.random()*unusedCards.size());
		Card removedCard = unusedCards.remove(num);
		this.usedCards.add(removedCard);
		return removedCard; 
	}
	
	private void reset(){
		for(int i = 0; i < usedCards.size(); i++){
			unusedCards.add(usedCards.get(i));
		}
	}
}