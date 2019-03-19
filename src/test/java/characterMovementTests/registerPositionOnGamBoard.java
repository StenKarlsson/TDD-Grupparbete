package characterMovementTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import museumHeist.sprites.GameCharacter;
import museum_heist.Position;

public class registerPositionOnGamBoard {
	GameCharacter mainCharacter;
	
	// Körs innan varje test och eftersom startpositionen är densamma kan den sättas här
	@Before
	public void setup()
	{
		mainCharacter = new GameCharacter(1,1); 
		
		
	}

	//Här testas ifall spelkaraktären kan känna av vilket värde som finns
	//på den plats som den är på i 2darrayen som är spelbrädet
	
	//Om figuren inte har flyttat sig ska den läsa in värde 0
	@Test
	public void dontMoveGetValue() {
		System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition());
		assertEquals(0,mainCharacter.getGameBoardValueOfCurrentPosition()); 
	}
	
	//Om figuren flyttas 1 steg åt höger ska den läsa in värde 5
		@Test
		public void moveRightGetValue() {
			mainCharacter.moveOneTileRight();
			System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition());
			assertEquals(5,mainCharacter.getGameBoardValueOfCurrentPosition()); 
		}
		//Om figuren flyttas 1 steg åt höger och sedan ett steg åt vänster ska den läsa in värde 0
		@Test
		public void moveRightLeftGetValue() {
					
			mainCharacter.moveOneTileRight();
			mainCharacter.moveOneTileLeft();
			System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition());
			assertEquals(0,mainCharacter.getGameBoardValueOfCurrentPosition()); 
		}
		//Om figuren flyttas 1 steg åt höger och 1 steg ned ska den läsa in värde 3
		@Test
		public void moveRightDownGetValue() {
					 
			mainCharacter.moveOneTileRight();
			mainCharacter.moveOneTileDown();
			System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition());
			assertEquals(3,mainCharacter.getGameBoardValueOfCurrentPosition()); 
		}
				
		//Om figuren flyttas 1 steg åt höger och 1 steg ned sedan 1 steg upp ska den läsa in värde 5
		@Test
		public void moveRightDownUpGetValue() {
					
			mainCharacter.moveOneTileRight();
			mainCharacter.moveOneTileDown();
			mainCharacter.moveOneTileUp();
			System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition());
			assertEquals(5,mainCharacter.getGameBoardValueOfCurrentPosition()); 
		}
		// Om figuren flyttas två steg åt höger och ett upp ska värdet vara 1 (vägg)
		@Test
		public void moveRightRightUpGetValue() {
					 
			mainCharacter.moveOneTileRight();
			mainCharacter.moveOneTileRight();
			mainCharacter.moveOneTileUp();
			System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition());
			assertEquals(1,mainCharacter.getGameBoardValueOfCurrentPosition()); 
		}
	
}
