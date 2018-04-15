import java.util.*;
public class Blackjack {

    public static void main(String [] args)
    {
		Display display  = new Display();
		int human = display.nPlayers();
		Player[] players = new Player[human];
		for(int i = 0; i < players.length; i++){
			players[i] = new Human(display.askName(i + 1), i, new ArrayList<Card>());
			display.greeting(players[i]);
		}
		int ai = display.nAi();
		players = Arrays.copyOf(players, players.length + ai);
		for(int i = human; i < players.length; i++){
			players[i] = new Ai("CPU " + ((i+1) - human), i, new ArrayList<Card>());
		}
		
		Game game = new Game(players, display);	
		while(true){
			if(!game.start())
				break;
			else {
				game.play();
				if(!game.conclusion())
					break;
			}
		}
	}
}