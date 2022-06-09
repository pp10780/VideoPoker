package Main;
import Card.Card;
import Dealer.*;
import Game.*;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		
		game.initGame_deb(10000, "C:\\Users\\pedro\\Desktop\\POO\\Projeto\\Test Files\\cmd-file.txt", "C:\\Users\\pedro\\Desktop\\POO\\Projeto\\Test Files\\card-file.txt");
	}

}
