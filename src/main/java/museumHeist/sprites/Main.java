package museumHeist.sprites;

import museum_heist.GameBoard;

public class Main {
	//skapade en mainklass bara för att leka med objekten lite 
	public static void main(String[] args) {
		
		// Ritar upp en GameBoard beroende vilken level som sätts i metoden
		GameBoard gameBoard = new GameBoard();
		gameBoard.drawMap(gameBoard, 1);
		GameCharacter c1 = new GameCharacter(); 
		
		
		//GameCharacter c2 = new GameCharacter(0,1); 
		//System.out.println(c1.getCurrentPosition());
		
		//c1.moveOneTileRight();
		//System.out.println(c1.getCurrentPosition());
		
		
		
	}
	
}
