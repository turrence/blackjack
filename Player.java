import java.util.*;

abstract public class Player{
	
	private ArrayList<Card> hand;
	private String name;
	private int id;
	
	public void hit(Card c){hand.add(c);}
	abstract public void stand();
	
	public Player(String n, int i, ArrayList<Card> c){
		this.name = n;
		this.id = id;
		this.hand = c;
	}
	
	public void setName(String n){this.name = n;}
	public void setId(int n){this.id = n;}
	public void setHand(ArrayList<Card> c){this.hand = c;}
	
	public String getName(){return this.name;}
	public ArrayList<Card> getHand(){return hand;}
	public int getId(){return this.id;}
	

}