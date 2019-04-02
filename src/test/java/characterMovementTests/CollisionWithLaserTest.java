package characterMovementTests;

import static org.junit.Assert.*;

import javax.swing.JButton;

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
	public void CollisionWithLaserKillsCharacter() 
	{
		//Arrange - spelkaraktären sätts en ruta före eld
		gb.getCharacter().setCurrentPosition(1, 13);
	
		// spelkaraktären ska ha 3 liv 
		assertEquals(3, gb.getCharacter().getLife());
		
		//Act - spelkaraktären går ett steg till höger på lasern
	
		gb.updateCharacterPosition("Right");
		
		//Assert - spelkaraktären förlorar ett liv och ska ha 2 liv
		assertEquals(2, gb.getCharacter().getLife());
		
	}
	
	@Test
	public void CollisionWithLaserMovesCharacterToStartPosition() 
	{
		//Arrange - spelkaraktären sätts en ruta före en laser
		gb.getCharacter().setCurrentPosition(1, 13);
		
		//Act - spelkaraktären går ett steg till höger på elden		
		gb.updateCharacterPosition("Right");
				
		//Assert - spelkaraktären ska flyttas till startpositionen 1,1
		assertEquals(new Position(1, 1), gb.getCharacter().getCurrentPosition());
	}
	
	@Test
	public void CollisionWithFireCausedByFireMovingToThePositionWhereCharacterIsKillsCharacter() 
	{
		
		
		//Arrange - spelkaraktären sätts en ruta före en rörlig laser
		gb.getCharacter().setCurrentPosition(2, 12);
		
		// En SpelplansArray skapas 
		JButton[][] laserMovement = gb.getSquares();
		
		// //Assert  - Antal liv ska vara 3
		assertEquals(3, gb.getCharacter().getLife());
		
		//Act - spelkaraktären går ett steg till höger till den rörliga elden som är inaktiv	
		gb.updateCharacterPosition("Right");
		
		// Metoden som sköter rörelsen av lasern körs och lasern aktiveras där karaktären står
		gb.flipLaserOnGameBoard(laserMovement); 
		
		// //Assert - Antal liv ska vara 2
		assertEquals(2, gb.getCharacter().getLife());
				
		
	}

}
