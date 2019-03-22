package characterMovementTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.awt.Color;

import org.junit.Test;

import museumHeist.GUI.Classes.GameBoardInterface;
import museum_heist.Position;

public class TileTests {

	
	
	@Test
	public void checkIfTileIsPlayer() {
		
		//Arrange 
		GameBoardInterface gb = new GameBoardInterface();
		gb.getCharacter().setCurrentPosition(1, 1);//spelkaraktären flyttas till en specifik position
		Position pos = new Position(1, 1); //Variabeln pos antar dess uvarande värde
		//Act 
		//Färgen på rutan (pos) innan förflyttningen 
		Color actualColor = gb.getColorOfTile(pos);
		
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
