package characterMovementTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import museumHeist.sprites.GameCharacter;
import museum_heist.Position;



public class performMovement {
	
	GameCharacter mainCharacter;
	
	// Varje test körs separat och därför kan objektet instansieras före varje test
	@Before 
	public void setup() 
	{
		mainCharacter = new GameCharacter(0,0); //har 0,0 som startposition
	}

	//här testas om figuren rör sig i en viss riktning så ska dess position vara det förväntade 
	@Test
	public void moveOneRight() {
		mainCharacter.moveOneTileRight();
		assertEquals(mainCharacter.getCurrentPosition(),new Position(0,1)); 
	}
	@Test
	public void moveBackAndForth() {
		mainCharacter.moveOneTileRight();
		mainCharacter.moveOneTileLeft();
		assertEquals(mainCharacter.getCurrentPosition(),new Position(0,0)); 
	}
	@Test
	public void moveDown() {
		mainCharacter.moveOneTileDown();
		assertEquals(mainCharacter.getCurrentPosition(),new Position(1,0)); 
	}
	@Test
	public void moveDownTwice() {
		mainCharacter.moveOneTileDown();
		mainCharacter.moveOneTileDown();
	
		assertEquals(mainCharacter.getCurrentPosition(),new Position(2,0)); 
	}
	
	
	
	
}
