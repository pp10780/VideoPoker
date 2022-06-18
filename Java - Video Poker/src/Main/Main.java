package Main;
import Game.*;


public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		
		//game.initGame_deb(10000, "C:\\Users\\pedro\\Desktop\\POO\\Projeto\\Test Files\\81-cmd-file.txt", "C:\\Users\\pedro\\Desktop\\POO\\Projeto\\Test Files\\81-card-file.txt");
		game.initGame_sim(args, 100000, 1000000, 5);
	}

}
