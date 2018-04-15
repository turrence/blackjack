import java.util.*;

public class Display{
	private Scanner kboard;
	
	public Display(){
		this.kboard = new Scanner(System.in);
	}
	
	public int nPlayers(){
		System.out.println("How many human players are there?");
		while(!kboard.hasNextInt()){
			System.out.println("That is not a number");
			kboard.next();
		}
		int num = kboard.nextInt();
		kboard.nextLine();
		return num;
		
	}
	
	public String askName(int n){
		System.out.println("Welcome to Blackjack!");
		System.out.print("What is your name Player " + (n)+": ");
		String thing = kboard.next();
		kboard.nextLine();
		return thing;
	}
	
	public void greeting(Player p){
		System.out.println("Welcome " + p.getName());
		System.out.print("-----------------------------------------------------\n");
	}
	
	public int nAi(){
		System.out.println("How many Ai players are there?");
		while(!kboard.hasNextInt()){
			System.out.println("That is not a number");
			kboard.next();
		}
		int num = kboard.nextInt();
		kboard.nextLine();
		return num;
	}
	
	public void showCurrentHand(Player p){
		System.out.println("This is "+ p.getName()+"'s current hand: "+ p.getHand());
	}
	
	public boolean blackJack(ArrayList<Player> p){
		String h = "";
		String names = "";
		for(int i = 0; i < p.size(); i++){
			h = p.get(i).getHand().get(0)+" & "+p.get(i).getHand().get(1);
			this.showCurrentHand(p.get(i));
			System.out.println(p.get(i).getName() + " was dealt a Blackjack with a " + h);
			winnerMsg(p);
		}
		return this.playAgain();
	}
	
	public String askAction(){
		System.out.print("Would you like to HIT or STAND: ");
		String action = kboard.nextLine().toUpperCase();
		while(!("HIT".equals(action) || "STAND".equals(action))){
			System.out.print(action +" is not a valid move; HIT or STAND: ");	
			action = kboard.nextLine().toUpperCase();
		}
		return action;
	}
	
	public void held(Player p){
		System.out.println(p.getName() + " stood");
	}
	
	public void hurt(Player p){
		System.out.println(p.getName() + " hit");
	}
	
	public void showHandSum(Player p, int num){
		ArrayList<Card> hand = p.getHand();
		String h = "";
		for(int i = 0 ; i< hand.size();i++){
			if(i == hand.size() - 1)
				h += hand.get(i);
			else
				h += hand.get(i)+", ";
		}
		System.out.println("This is " + p.getName() +"'s hand: \n\t"+ h +"\n\t"+"Value: "+num);
	}
	
	public void loserMsg(Player p){
		System.out.println(p.getName()+" Bust!");
	}
	
	public void winnerMsg(ArrayList<Player> p){
		String msg = "";
		for(int i = 0; i < p.size(); i++){
			if(i == p.size() -1)
				msg += p.get(i).getName() + " won!";
			else 
				msg += p.get(i).getName() + " and ";
		}
		System.out.println(msg);
	}
	
	public void allLose(){
		System.out.println("Everyone Bust");
	}
	
	public boolean playAgain(){
		System.out.print("Play again?(Y/N) ");
		String word = kboard.nextLine().toUpperCase();
		while(true){
			switch(word){
				case "Y":
				case "YES":
					System.out.print("-----------------------------------------------------\n");
					return true;
				case "N":
				case "NO":
					return false;
				default:
					System.out.print("do you want to play a quality game of blackjack again? ");
					word = kboard.nextLine().toUpperCase();
					break;
			}
		}
	}
	
	public void goodbye(){
		System.out.println("bye");
	}
	

	
	
	
	
	
}