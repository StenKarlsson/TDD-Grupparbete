package characterMovementTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import museumHeist.GUI.Classes.GameBoardInterface;
import museum_heist.Position;

/*I den här klassen testar jag kollision med en vägg, det ska inte gå att gå till en position där en vägg finns
 * vägg representeras av en 1a i 2Darrayen och svart färg i arrayen av knappar. */
public class AvoidWallCollisionTest {
	
	@Test
	public void avoidUpwardsdMovementWhenTileWithValueOneIsAbove() {
		
		//Arrange  
		GameBoardInterface gb = new GameBoardInterface();
		//Act 
		//Sätt positionen 
		gb.getCharacter().setCurrentPosition(1, 1);
		//Spara nuvarande position
		Position expected = gb.getCharacter().getCurrentPosition();
		//prva förflyttning upp där svart ruta finns (det ska inte gå)
		gb.updateCharacterPosition("Up");
		
		//Assert 
		//Positionen ska vara samma som den urspringliga positionen dvs det ska inte gå att utföra rörelsen uppåt
		assertEquals(expected, gb.getCharacter().getCurrentPosition());
	}
	
	@Test
	public void avoidDownwardsdMovementWhenTileWithValueOneIsUnder() {
		
		//Arrange  
		GameBoardInterface gb = new GameBoardInterface();
		//Act 
		//Sätt positionen 
		gb.getCharacter().setCurrentPosition(23, 1);
		System.out.println();
		//Spara nuvarande position
		Position expected = gb.getCharacter().getCurrentPosition();
		//prva förflyttning nedåt där svart ruta finns (det ska inte gå)
		gb.updateCharacterPosition("Down");
		
		//Assert 
		//Positionen ska vara samma som den urspringliga positionen dvs det ska inte gå att utföra rörelsen uppåt
		assertEquals(expected, gb.getCharacter().getCurrentPosition());
	}
	
	@Test
	public void avoidRightMovementWhenTileWithValueOneIsOnRightSide() {
		
		//Arrange  
		GameBoardInterface gb = new GameBoardInterface();
		//Act 
		//Sätt positionen 
		gb.getCharacter().setCurrentPosition(1, 23);
		System.out.println();
		//Spara nuvarande position
		Position expected = gb.getCharacter().getCurrentPosition();
		//prva förflyttning höger där svart ruta finns (det ska inte gå)
		gb.updateCharacterPosition("Right");
		
		//Assert 
		//Positionen ska vara samma som den urspringliga positionen dvs det ska inte gå att utföra rörelsen uppåt
		assertEquals(expected, gb.getCharacter().getCurrentPosition());
	}
	
	@Test
	public void avoidLeftMovementWhenTileWithValueOneIsOnLeftSideOfCharacter() {
		
		//Arrange  
		GameBoardInterface gb = new GameBoardInterface();
		//Act 
		//Sätt positionen 
		gb.getCharacter().setCurrentPosition(1, 1);
		//Spara nuvarande position
		Position expected = gb.getCharacter().getCurrentPosition();
		//prva förflyttning upp där svart ruta finns (det ska inte gå)
		gb.updateCharacterPosition("Left");
		
		//Assert 
		//Positionen ska vara samma som den urspringliga positionen dvs det ska inte gå att utföra rörelsen uppåt
		assertEquals(expected, gb.getCharacter().getCurrentPosition());
	}
	
	//Gör test som kollar att det kastas outofboundsexception, när figuren åker utanför. 
}
