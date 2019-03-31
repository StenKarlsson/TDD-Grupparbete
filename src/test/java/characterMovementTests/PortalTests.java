package characterMovementTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import museumHeist.GUI.Classes.GameBoardInterface;
import museum_heist.Position;

public class PortalTests {

	//Arrange
		GameBoardInterface gb;
		
		@Before
		public void setup() 
		{
			gb = new GameBoardInterface();
			
			
			
		}
		
	// Här testas att spelkaraktären förflyttas till en annan ruta på spelplanen som är golv
	@Test
	public void test() {
		//Arrange
		gb.getCharacter().setCurrentPosition(4, 16);
		
		//Act - Spelkaraktären går till höger på en portal
		gb.updateCharacterPosition("Right");
		
		// Assert- Spelkaraktären ska inte länger befinna sig på den förväntade position 1,2
		
		assertFalse(gb.getCharacter().getCurrentPosition().equals(new Position(4, 17)));
		
	}

}