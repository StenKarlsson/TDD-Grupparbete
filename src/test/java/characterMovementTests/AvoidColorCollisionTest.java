package characterMovementTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import museumHeist.GUI.Classes.GameBoardInterface;
import museum_heist.Position;

/*I den här klassen testar jag kollision med en vägg, det ska inte gå att gå till en position där en vägg finns
 * vägg representeras av en 1a i 2Darrayen och svart färg i arrayen av knappar. */
public class AvoidColorCollisionTest {
	
	@Test
	public void avoidMovementWhenMovingToBlackTile() {
		
		//Arrange  
		GameBoardInterface gb = new GameBoardInterface();
		//Act 
		//Sätt positionen 
		gb.getCharacter().setCurrentPosition(1, 1);
		//Spara nuvarande position
		Position expected = gb.getCharacter().getCurrentPosition();
		//prva förflyttning upp där svart ruta finns (det ska inte gå)
		gb.getCharacter().moveOneTileUp();
		
		//Assert 
		//Positionen ska vara samma som den urspringliga positionen dvs det ska inte gå att utföra rörelsen uppåt
		assertEquals(expected, gb.getCharacter().getCurrentPosition());
	}
	
	//Gör test som kollar att det kastas outofboundsexception, när figuren åker utanför. 
}
