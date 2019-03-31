package characterMovementTests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import museumHeist.GUI.Classes.GameBoardInterface;
import museumHeist.sprites.GameCharacter;
import museum_heist.Position;

public class CollisionWithTreasureTest {
	
	GameBoardInterface gb;
	GameCharacter gameCharacter;
	
	
	
	@Before
	public void setup() 
	{
		//Arrange
		gb = new GameBoardInterface();
		gameCharacter = new GameCharacter();
		
	}
	

	// I den här klassen testas en kollision med en skatt, det ska gå att gå över en skatt
	// Den ska försvinna från spelplanen (färgen)
	// Den ska plockas upp när spelaren är på samma position och adderas till spelarens totala skatter
	
	
	
	@Test
	public void testTileColorBeforeAndAfterTreasureIsPickedUp() {
		//Assert 
		gb = new GameBoardInterface();

		// Hämtar färgen från positionen där skatten ligger (level 1)
		Color colorOfTileWithTreasure = gb.getColorOfTile(new Position(1, 5));
		
		// Sätter spelarens position till en ruta innan skatten
		gb.getCharacter().setCurrentPosition(1, 4);
		
		assertEquals("Tile color before picked Treasure", Color.ORANGE, colorOfTileWithTreasure);  
		
		//  Spelaren rör sig över skatten
		gb.updateCharacterPosition("Right"); // Skattens position 
		gb.updateCharacterPosition("Right");
		
		// Hämtar färgen på spelplanen efter att spelaren passerat/plockat skatten
		colorOfTileWithTreasure = gb.getColorOfTile(new Position(1, 5));
		
		assertEquals("Tile color after picked Treasure", Color.WHITE ,colorOfTileWithTreasure);  
		
	}
	
	@Test
	public void testTreasureisAddedToTreasureCount() {
		
		//Assert 
		gb = new GameBoardInterface();
		
		// Sätter spelarens position till en ruta innan skatten
		gameCharacter = gb.getCharacter();
		gameCharacter.setCurrentPosition(1, 4);
		
		// Antal skatter innan upplockad skatt
		int treasureCountBefore = gameCharacter.getTreasures();
		
		// Kollar om antal skatter är 0
		assertTrue(treasureCountBefore == 0);

		//  Spelaren ställer sig på skatten
		gb.updateCharacterPosition("Right"); // Skattens position 
		
		// Antal skatter efter upplockad skatt
		int treasureCountAfter = gameCharacter.getTreasures();
		
		//Kollar om antalet skatter 1
		assertTrue(treasureCountAfter == 1);
		}
	
	@Test
	public void testThatOneTreasureCantBePickedUpTwise() {
		
		//Assert 
		gb = new GameBoardInterface();
		
		// Sätter spelarens position till en ruta innan skatten
		gameCharacter = gb.getCharacter();
		gameCharacter.setCurrentPosition(1, 4);
		
		
		// Kollar om antal skatter är 0
		assertTrue(gameCharacter.getTreasures() == 0);

		//  Spelaren ställer sig på skatten
		gb.updateCharacterPosition("Right"); // Skattens position 
		gb.updateCharacterPosition("Left");
		//gb.updateCharacterPosition("East");
		
		
		//Kollar om antalet skatter 1
		assertTrue(gameCharacter.getTreasures() == 1);
		
	}
	

}
