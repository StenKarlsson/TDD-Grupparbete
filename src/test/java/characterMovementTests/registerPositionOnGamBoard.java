package characterMovementTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import museumHeist.sprites.GameCharacter;
import museum_heist.Position;

public class registerPositionOnGamBoard {
	//Här testas ifall spelkaraktären kan känna av vilket värde som finns
	//på den plats som den är på i 2darrayen som är spelbrädet
	
	//Om figuren inte har flyttat sig ska den läsa in värde 0
	@Test
	public void dontMoveGetValue() {
		GameCharacter mainCharacter = new GameCharacter(1,1); 
		
		System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition());
		assertEquals(0,mainCharacter.getGameBoardValueOfCurrentPosition()); 
	}
	
	//Om figuren flyttas 1 steg åt höger ska den läsa in värde 0
		@Test
		public void moveRightGetValue() {
			GameCharacter mainCharacter = new GameCharacter(1,1); 
			mainCharacter.moveOneTileRight();
			System.out.println(mainCharacter.getGameBoardValueOfCurrentPosition());
			assertEquals(0,mainCharacter.getGameBoardValueOfCurrentPosition()); 
		}
		//Om figuren flyttas 1 steg åt höger och sedan ett steg åt vänster ska den läsa in värde 0
				@Test
				public void moveRightLeftGetValue() {
					GameCharacter mainCharacter2 = new GameCharacter(1,1); 
					mainCharacter2.moveOneTileRight();
					mainCharacter2.moveOneTileLeft();
					System.out.println(mainCharacter2.getGameBoardValueOfCurrentPosition());
					assertEquals(0,mainCharacter2.getGameBoardValueOfCurrentPosition()); 
				}
				//Om figuren flyttas 1 steg åt höger och 1 steg ned ska den läsa in värde 3
				@Test
				public void moveRightDownGetValue() {
					GameCharacter mainCharacter3 = new GameCharacter(1,1); 
					mainCharacter3.moveOneTileRight();
					mainCharacter3.moveOneTileDown();
					System.out.println(mainCharacter3.getGameBoardValueOfCurrentPosition());
					assertEquals(3,mainCharacter3.getGameBoardValueOfCurrentPosition()); 
				}
				
				//Om figuren flyttas 1 steg åt höger och 1 steg ned sedan 1 steg upp ska den läsa in värde 0
				@Test
				public void moveRightDownUpGetValue() {
					GameCharacter mainCharacter4 = new GameCharacter(1,1); 
					mainCharacter4.moveOneTileRight();
					mainCharacter4.moveOneTileDown();
					mainCharacter4.moveOneTileUp();
					System.out.println(mainCharacter4.getGameBoardValueOfCurrentPosition());
					assertEquals(0,mainCharacter4.getGameBoardValueOfCurrentPosition()); 
				}
				// Om figuren flyttas två steg åt höger och ett upp ska värdet vara 1 (vägg)
				@Test
				public void moveRightRightUpGetValue() {
					GameCharacter mainCharacter4 = new GameCharacter(1,1); 
					mainCharacter4.moveOneTileRight();
					mainCharacter4.moveOneTileRight();
					mainCharacter4.moveOneTileUp();
					System.out.println(mainCharacter4.getGameBoardValueOfCurrentPosition());
					assertEquals(1,mainCharacter4.getGameBoardValueOfCurrentPosition()); 
				}
	
}
