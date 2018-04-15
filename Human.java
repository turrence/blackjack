import java.util.*;

public class Human extends Player{
	/* 
	protected ArrayList<Card> hand;
	protected String name = "";
	protected int id = 0; 
	 */
	public Human(String n, int i, ArrayList<Card> c){
		super(n, i , c);
	}
	
	
	public void hit(Card c){super.hit(c);}

	public void stand(){
		return;
	}
}