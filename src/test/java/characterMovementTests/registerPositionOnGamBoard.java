package characterMovementTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import museumHeist.sprites.GameCharacter;
import museum_heist.Position;

public class registerPositionOnGamBoard {
	//Här testas ifall spelkaraktären kan känna av vilket värde som finns
	//på den plats som den är på i 2darrayen som är spelbrädet
	
	//Om figuren inte har flyttat sig ska den läsa in värde 1
	@Test
	public void dontMoveGetValue() {
		GameCharacter mainCharacter = new GameCharacter(); //har 0,0 som startposition
		
		System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition());
		assertEquals(1,mainCharacter.getGameBoardValueOfCurrentPosition()); 
	}
	
	//Om figuren flyttas 1 steg åt höger ska den läsa in värde 2
		@Test
		public void moveRightGetValue() {
			GameCharacter mainCharacter = new GameCharacter(); //har 0,0 som startposition
			mainCharacter.moveOneTileRight();
			System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition());
			assertEquals(2,mainCharacter.getGameBoardValueOfCurrentPosition()); 
		}
		//Om figuren flyttas 1 steg åt höger och sedan ett steg åt vänster ska den läsa in värde 1
				@Test
				public void moveRightLeftGetValue() {
					GameCharacter mainCharacter = new GameCharacter(); //har 0,0 som startposition
					mainCharacter.moveOneTileRight();
					mainCharacter.moveOneTileLeft();
					System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition());
					assertEquals(1,mainCharacter.getGameBoardValueOfCurrentPosition()); 
				}
				//Om figuren flyttas 1 steg åt höger och 1 steg ned ska den läsa in värde 7
				@Test
				public void moveRightDownGetValue() {
					GameCharacter mainCharacter = new GameCharacter(); //har 0,0 som startposition
					mainCharacter.moveOneTileRight();
					mainCharacter.moveOneTileDown();
					System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition());
					assertEquals(7,mainCharacter.getGameBoardValueOfCurrentPosition()); 
				}
				
				//Om figuren flyttas 1 steg åt höger och 1 steg ned sedan 1 steg upp ska den läsa in värde 2
				@Test
				public void moveRightDownUpGetValue() {
					GameCharacter mainCharacter = new GameCharacter(); //har 0,0 som startposition
					mainCharacter.moveOneTileRight();
					mainCharacter.moveOneTileDown();
					mainCharacter.moveOneTileUp();
					System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition());
					assertEquals(2,mainCharacter.getGameBoardValueOfCurrentPosition()); 
				}
	
}
