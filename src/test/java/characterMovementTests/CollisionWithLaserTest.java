package characterMovementTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import museumHeist.GUI.Classes.GameBoardInterface;
import museum_heist.GameBoard;
import museum_heist.Position;

public class CollisionWithLaserTest {
	
	//Arrange
	GameBoardInterface gb;
	
	@Before
	public void setup() 
	{
		gb = new GameBoardInterface();
		
		
		
	}

	@Test
	public void CollisionWithFireKillsCharacter() 
	{
		//Arrange - spelkaraktären sätts en ruta före eld
		gb.getCharacter().setCurrentPosition(1, 13);
	
		// spelkaraktären har 3 liv
		assertEquals(3, gb.getCharacter().getLife());
		
		//Act - spelkaraktären går ett steg till höger på elden
	
		gb.updateCharacterPosition("Right");
		
		// spelkaraktären förlorar ett liv och har 2 kvar
		assertEquals(2, gb.getCharacter().getLife());
		
	}
	
	@Test
	public void CollisionWithFireMovesCharacterToStartPosition() 
	{
		//Arrange - spelkaraktären sätts en ruta före eld
		gb.getCharacter().setCurrentPosition(1, 13);
		//Act - spelkaraktären går ett steg till höger på elden
				
		gb.updateCharacterPosition("Right");
				
		// spelkaraktären får positionen 1, 1 som är satt som startposition
		assertEquals(new Position(1, 1), gb.getCharacter().getCurrentPosition());
	}
	
	@Test
	public void CollisionWithFireCausedByFireMovingToThePositionWhereCharacterIsShouldKill() 
	{
		//Arrange - spelkaraktären sätts en ruta före en rörlig eld
		gb.getCharacter().setCurrentPosition(2, 12);
		assertEquals(3, gb.getCharacter().getLife());
		//Act - spelkaraktären går ett steg till höger till den rörliga elden
				
		gb.updateCharacterPosition("Right");
		assertEquals(2, gb.getCharacter().getLife());
				
		
	}

}
