package characterMovementTests;

import static org.junit.Assert.assertEquals;
import java.awt.Color;

import org.junit.Test;

import museumHeist.GUI.Classes.GameBoardInterface;
import museum_heist.Position;

public class TileTests {

	//Dessa tester funkar för tillfället bara på 1
	
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
		
		Position pos = new Position(0,0);
		Color actualColor = gb.getColorOfTile(pos);
		
		assertEquals(actualColor, Color.BLACK);
	}
	
	@Test
	public void checkIfTileIsTreasure() {
		
		GameBoardInterface gb = new GameBoardInterface();
		
		Position pos = new Position(1,5);
		Color actualColor = gb.getColorOfTile(pos);
		
		assertEquals(actualColor, Color.ORANGE);
	}
	
	@Test
	public void checkIfTileIsLaser() {
		
		//Arrange
		GameBoardInterface gb = new GameBoardInterface();
		Position pos = new Position(1,14);
		
		//Act
		Color actualColor = gb.getColorOfTile(pos);
		
		//Assert
		assertEquals(actualColor, Color.RED);
		
	}
	
	@Test
	public void checkIfTileIsDoor() {
		
		//Arrange
		GameBoardInterface gb = new GameBoardInterface();
		Position pos = new Position(17,14);
		
		//Act
		Color actualColor = gb.getColorOfTile(pos);
		
		//Assert
		assertEquals(actualColor, Color.GREEN);
	}
	
	
	
}
