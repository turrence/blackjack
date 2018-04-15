import java.util.*;

public class Game{
	private Deck deck;
	private Player[] players;
	private Display display;//System.outs
	
	public Game(Player[] p, Display d){
		this.deck = new Deck();
		this.players = p;
		this.display = d;	
	}
	public boolean start(){
		for(int i = 0; i < players.length; i++){
			players[i].hit(deck.deal());
			players[i].hit(deck.deal());
		}
		ArrayList<Player> blackjackers = new ArrayList<Player>();
		for(int i = 0; i < players.length; i++){
			if(this.handSum(players[i]) == 21)
				blackjackers.add(players[i]);
		}
		if(blackjackers.size() != 0){
			if(display.blackJack(blackjackers)){
				this.resetGame();
				this.start();
			}
			else {
				return false;
			}
		} return true;
	}
	
	public void play(){
		boolean playing = true;
		for(int i = 0; i < players.length; i++){
			if((players[i].getClass().equals(Ai.class))){
				if (!(this.otherPlayersBust())){
					while(this.handSum(players[i]) < 16)
						players[i].hit(deck.deal());
				}
			} else {
				playing = true;
				while(playing){
					display.showCurrentHand(players[i]);
					switch(display.askAction()){
						case "HIT":
							display.hurt(players[i]);
							players[i].hit(deck.deal());
							if(this.checkBust(players[i])){
								display.loserMsg(players[i]);
								return;
							}
						break;
						case "STAND":
							playing = false;
							display.held(players[i]);
						break;
					}
				}
			}
		}
	}
	
	public boolean conclusion(){
		this.results();
		//needs to work
		this.resetGame();
		boolean again = display.playAgain();
		if(again)
			return true;
		display.goodbye();
		return false;
	}
		
	public void results(){
		int[] distanceTo21 = new int[players.length];
		for(int i = 0; i < players.length; i++){
			display.showHandSum(players[i], handSum(players[i]));
			distanceTo21[i] = 21 - this.handSum(players[i]);
		}
		this.winners(distanceTo21);
	}
	
	//who the winners are
	private void winners(int[] distances){
		int smol = 22;
		int counter = 1;
		int temp;
		ArrayList<Integer> winningIndex = new ArrayList<Integer>();
		for(int i = 0; i < distances.length; i++){
			temp = smol;
			smol = distances[i];
			if(smol < 0 || smol > temp){//if new value is greater than old value or if new value is negative ignore it
				smol = temp;
			} else if(smol == temp){//if old val
				winningIndex.add(i);
				counter++;
			} else if(smol < temp){
				winningIndex.clear();
				winningIndex.add(i);
				counter = 1;
			}
		}
		if(smol != 22){//original value of smol
			ArrayList<Player> winners = new ArrayList<Player>();
			for(int i = 0; i < winningIndex.size(); i++){
				winners.add(players[winningIndex.get(i)]);
			}
			display.winnerMsg(winners);
		} else {
			display.allLose();
		}
	}

	//for the AI
	//checks if all other players bust
	private boolean otherPlayersBust(){
		int numOfBust = 0;
		for(int i = 0; i < players.length; i++){
			if(this.checkBust(players[i]))
				numOfBust++;
		}
		if(numOfBust == players.length - 1)
			return true;
		return false;
	}
	
	private void resetGame(){
		for(int i = 0; i < players.length; i++){
			players[i].setHand(new ArrayList<Card>());
		}
	}
	//return true if bust
	//return false if not
	private boolean checkBust(Player p){
		return handSum(p) > 21;
	}
	
	private int handSum(Player p){
		ArrayList<Card> hand = p.getHand();
		int handTotal = 0;
		for(int i = 0; i < hand.size(); i++){
			if(hand.get(i).getValue() == 1)
				handTotal += 11;
			else if(hand.get(i).getValue() > 10)
				handTotal += 10;
			else 
				handTotal += hand.get(i).getValue();
		}
		if(handTotal > 21){
			handTotal = 0;
			for(int i = 0; i < hand.size(); i++){
				if(hand.get(i).getValue() > 10)
					handTotal += 10;
				else 
					handTotal += hand.get(i).getValue();
			}
		}
		return handTotal;
	}
}