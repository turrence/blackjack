import java.util.*;

public class Ai extends Player{
	
	public Ai(String n, int i, ArrayList<Card> c){
		super(n, i , c);
	}
	
	public void hit(Card c){super.hit(c);}
	public void stand(){
		return;
	}
}