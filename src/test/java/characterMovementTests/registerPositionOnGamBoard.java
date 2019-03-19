package characterMovementTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import museumHeist.sprites.GameCharacter;
import museum_heist.GameBoard;
import museum_heist.Position;

public class registerPositionOnGamBoard {
	GameCharacter mainCharacter;
	GameBoard gameBoard;
	// Körs innan varje test och eftersom startpositionen är densamma kan den sättas här
	@Before
	public void setup()
	{
		mainCharacter = new GameCharacter(0,0);
		gameBoard = new GameBoard();
		
		
	}

	//Här testas ifall spelkaraktären kan känna av vilket värde som finns
	//på den plats som den är på i 2darrayen som är spelbrädet
	
	//Om figuren inte har flyttat sig ska den läsa in värde 0
	@Test
	public void dontMoveGetValue() {
		System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition(0));
		assertEquals(1,mainCharacter.getGameBoardValueOfCurrentPosition(0)); 
	}
	
	//Om figuren flyttas 1 steg åt höger ska den läsa in värde 2
		@Test
		public void moveRightGetValue() {
			mainCharacter.moveOneTileRight();
			System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition(0));
			assertEquals(2,mainCharacter.getGameBoardValueOfCurrentPosition(0));  
		}
		//Om figuren flyttas 1 steg åt höger och sedan ett steg åt vänster ska den läsa in värde 1
		@Test
		public void moveRightLeftGetValue() {
					
			mainCharacter.moveOneTileRight();
			mainCharacter.moveOneTileLeft();
			System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition(0));
			assertEquals(1,mainCharacter.getGameBoardValueOfCurrentPosition(0));  
		}
		//Om figuren flyttas 1 steg åt höger och 1 steg ned ska den läsa in värde 7
		@Test
		public void moveRightDownGetValue() {
					 
			mainCharacter.moveOneTileRight();
			mainCharacter.moveOneTileDown();
			System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition(0));
			assertEquals(7,mainCharacter.getGameBoardValueOfCurrentPosition(0)); 
		}
				
		//Om figuren flyttas 1 steg åt höger och 1 steg ned sedan 2 steg upp ska den läsa in värde 5
		@Test
		public void moveRightDownUpGetValue() {
					
			mainCharacter.moveOneTileRight();
			mainCharacter.moveOneTileDown();
			mainCharacter.moveOneTileUp();
			System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition(0));
			assertEquals(2,mainCharacter.getGameBoardValueOfCurrentPosition(0));  
		}
		
		
		
	
}
