package main;
import game.*;

/**
 * Main class, receives the arguments from the command line and starts the game
 * @author Sofia Silveira, Joana Afonso, Pedro Martins
 * */
public class Main {

	public static void main(String[] args) {
		
		Game game = new Game(new DoubleBonus(), new DoubleBonus_10_7());
		
		if(args.length != 4)
		{
			System.out.println("\nWrong number of arguments!" + "\n" +  "Number of Arguments: " + args.length);
			System.exit(0);
		}

		try{
			Integer.parseInt(args[1]);
		} 
		catch(NumberFormatException e)
		{
			System.out.println("Invalid argument for initial credit!");
			System.exit(0);
		}
		
		if(args[0].equals("-s"))
		{
			try{
				Integer.parseInt(args[2]);
				Integer.parseInt(args[3]);
			} 
			catch(NumberFormatException e)
			{
				System.out.println("Invalid argument for the number of deals or bet size!");
				System.exit(0);
			}
			if(Integer.parseInt(args[2]) < 1 || Integer.parseInt(args[2]) > 5)
			{
				System.out.println("Invalid bet size! (Bet Size must be between 1 and 5 credits!)");
				System.exit(0);
			}
			game.initGameSim(Integer.parseInt(args[1]), Integer.parseInt(args[3]), Integer.parseInt(args[2]));
		}
		else if(args[0].equals("-d"))
			game.initGameDeb(Integer.parseInt(args[1]), args[2], args[3]);
		else
			System.out.println("The chosen game mode does not exist!");
		
	}
}
