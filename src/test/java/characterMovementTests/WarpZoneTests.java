package characterMovementTests;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import museumHeist.GUI.Classes.GameBoardInterface;
import museum_heist.Position;

public class WarpZoneTests {

	//Arrange
		GameBoardInterface gb;
		
		@Before
		public void setup() 
		{
			gb = new GameBoardInterface();
			
			
			
		}
		
	// Här testas att spelkaraktären förflyttas från Warp_Zone
	@Ignore
	@Test
	public void WarpZoneMovesCharacterFromTile() {
		//Arrange
		gb.getCharacter().setCurrentPosition(4, 16);
		
		//Act - Spelkaraktären går till höger på en portal
		gb.updateCharacterPosition("Right");
		
		// Assert- Spelkaraktären ska inte länger befinna sig på den förväntade position 1,2
		
		assertFalse(gb.getCharacter().getCurrentPosition().equals(new Position(4, 17)));
		
	}
	
	@Ignore
	@Test
	public void test() {
		//Arrange
		gb.getCharacter().setCurrentPosition(4, 16);
		
		//Act - Spelkaraktären går till höger på en portal
		gb.updateCharacterPosition("Right");
		
		// Assert- Spelkaraktären ska inte länger befinna sig på den förväntade position 1,2
		
		assertFalse(gb.getCharacter().getCurrentPosition().equals(new Position(4, 17)));
		
	}

	
	// Test som kollar så att portalen skickar iväg karaktären
	@Test
	public void warpZoneDestinationTest() {
		//Arrange
		Position actualPos;
		Position expectedPos;
		//Act
		gb.getCharacter().setCurrentPosition(4, 16);
		gb.updateCharacterPosition("Right");
		expectedPos = new Position(4, 17);
		actualPos = gb.getCharacter().getCurrentPosition();
		//Assert
		assertFalse(actualPos.x == expectedPos.x && actualPos.y == expectedPos.y);
	}
	
	
}
