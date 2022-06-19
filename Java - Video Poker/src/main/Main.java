package main;
import game.*;

/**
 * Main class, receives the arguments from the command line and starts the game
 * @author Sofia Silveira, Joana Afonso, Pedro Martins
 * */
public class Main {

	public static void main(String[] args) {
		Game game = new Game(new DoubleBonus(), new DoubleBonus_10_7());
		
		//game.initGameDeb(10000, "C:\\Users\\pedro\\Desktop\\POO\\Projeto\\Test_Files\\81-cmd-file.txt", "C:\\Users\\pedro\\Desktop\\POO\\Projeto\\Test_Files\\81-card-file.txt");
		game.initGameSim(args, 100000000, 100000, 5);	
		if(args.length != 4)
		{
			System.out.println("\nWrong number of arguments!" + "\n" +  "Number of Arguments: " + args.length);
			System.exit(0);
		}
		
		if(args[0].equals("-s"))
			game.initGameSim(args, Integer.parseInt(args[1]), Integer.parseInt(args[3]), Integer.parseInt(args[2]));
		
		else if(args[0].equals("-d"))
			game.initGameDeb(Integer.parseInt(args[1]), args[2], args[3]);
		else
			System.out.println("The chosen game mode does not exist!");
		
	}
}
