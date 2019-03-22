package characterMovementTests;

import static org.junit.Assert.assertEquals;
import java.awt.Color;

import org.junit.Test;

import museumHeist.GUI.Classes.GameBoardInterface;
import museum_heist.Position;

public class TileTests {

	//Dessa tester funkar för tillfället bara på level999 (ändras i början av GameBoardInterface)
	
	@Test
	public void checkIfTileIsPlayer() {
		
		//Arrange 
		GameBoardInterface gb = new GameBoardInterface();
		gb.getCharacter().setCurrentPosition(1, 1);
		Position pos = new Position(1, 1);
		//Act 
		Color actualColor = gb.getColorOfTile(pos);
		
		//Assert
		assertEquals(actualColor, Color.CYAN);		
	}
	
	@Test
	public void checkIfTileIsWall() {
		
		GameBoardInterface gb = new GameBoardInterface();
		
		Position pos = new Position(5,5);
		Color actualColor = gb.getColorOfTile(pos);
		
		assertEquals(actualColor, Color.BLACK);
	}
	
	@Test
	public void checkIfTileIsTreasure() {
		
		GameBoardInterface gb = new GameBoardInterface();
		
		Position pos = new Position(2,2);
		Color actualColor = gb.getColorOfTile(pos);
		
		assertEquals(actualColor, Color.ORANGE);
	}
	
	@Test
	public void checkIfTileIsLaser() {
		
		//Arrange
		GameBoardInterface gb = new GameBoardInterface();
		Position pos = new Position(3,3);
		
		//Act
		Color actualColor = gb.getColorOfTile(pos);
		
		//Assert
		assertEquals(actualColor, Color.RED);
		
	}
	
	@Test
	public void checkIfTileIsDoor() {
		
		//Arrange
		GameBoardInterface gb = new GameBoardInterface();
		Position pos = new Position(7,7);
		
		//Act
		Color actualColor = gb.getColorOfTile(pos);
		
		//Assert
		assertEquals(actualColor, Color.GREEN);
	}
	
	
	
}
