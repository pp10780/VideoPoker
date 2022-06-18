package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Game {

	private VideoPoker game;
	
	public void initGameDeb(int credit, String cmd_file, String card_file) {
		int i = 0;
		//Le ficheiro card_file
		String aux_cards = new String();
		int n_tokens;
		try {
		      File card_stack = new File(card_file);
		      Scanner reader = new Scanner(card_stack);
		      while (reader.hasNextLine()) {
		        aux_cards = aux_cards + " " + reader.nextLine();
		      }
		      reader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("File does not exist!");
		      e.printStackTrace();
		    }
		StringTokenizer token = new StringTokenizer(aux_cards);
		n_tokens = token.countTokens();
		
		String[] cards = new String[n_tokens];
		
		while(token.hasMoreTokens())
	    {
	    	cards[i] = token.nextToken();
	    	i++;
	    }
		
		//Le ficheiro cmd_file
		
		String aux_cmd = new String();
		try {
		      File card_stack = new File(cmd_file);
		      Scanner reader = new Scanner(card_stack);
		      while (reader.hasNextLine()) {
		        aux_cmd = aux_cmd + " " + reader.nextLine();
		      }
		      reader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("File does not exist!");
		      e.printStackTrace();
		    }
		token = new StringTokenizer(aux_cmd);
		n_tokens = token.countTokens();
		
		String[] cmd = new String[n_tokens];
		i = 0;
		while(token.hasMoreTokens())
	    {
	    	cmd[i] = token.nextToken();
	    	i++;
	    }
		
		game = new VideoPokerDeb(credit, cards);
		
		game.initGame(cmd);
		
	}
	
	public void initGameSim(String[] arg, int credit, int nbDeals, int betSize) {
		
		game = new VideoPokerSim(credit, nbDeals, betSize);
		
		game.initGame(arg);
	}
}