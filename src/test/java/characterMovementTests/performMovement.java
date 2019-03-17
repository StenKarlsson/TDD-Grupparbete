package characterMovementTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.geom.Point2D;

import org.junit.Test;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import junit.framework.Assert;
import museumHeist.sprites.GameCharacter;
import museumHeist.sprites.Treasure;
import museumHeist.sprites.Wall;
import museum_heist.Position;



public class performMovement {

	//här testas om figuren rör sig i en viss riktning så ska dess position vara det förväntade 
	@Test
	public void moveOneRight() {
		GameCharacter mainCharacter = new GameCharacter(0,0); //har 0,0 som startposition
		mainCharacter.moveOneTileRight();
		assertEquals(mainCharacter.getCurrentPosition(),new Position(0,1)); 
	}
	@Test
	public void moveBackAndForth() {
		GameCharacter mainCharacter = new GameCharacter(0,0); //har 0,0 som startposition
		mainCharacter.moveOneTileRight();
		mainCharacter.moveOneTileLeft();
		assertEquals(mainCharacter.getCurrentPosition(),new Position(0,0)); 
	}
	@Test
	public void moveDown() {
		GameCharacter mainCharacter = new GameCharacter(0,0); //har 0,0 som startposition
		mainCharacter.moveOneTileDown();
	
		assertEquals(mainCharacter.getCurrentPosition(),new Position(1,0)); 
	}
	@Test
	public void moveDownTwice() {
		GameCharacter mainCharacter = new GameCharacter(0,0); //har 0,0 som startposition
		mainCharacter.moveOneTileDown();
		mainCharacter.moveOneTileDown();
	
		assertEquals(mainCharacter.getCurrentPosition(),new Position(2,0)); 
	}
	
	// Här testas att en krock med en vägg registreras när karaktären och väggen har samma position
	@Test
	public void testCharacterWallCollision() 
{
		GameCharacter mainCharacter = new GameCharacter(1,1);
		Wall wall = new Wall(1,1);
		
		assertTrue(mainCharacter.isCollidingWith(wall)); 
	}
	
	// Här testas att karaktären plockar upp en skatt när när karaktären och skatten har samma position 
	@Test
	public void testCharacterGetsItem() 
{
		GameCharacter mainCharacter = new GameCharacter(1,1);
		Treasure treasure = new Treasure(1,1);
		
		assertTrue(mainCharacter.grabsTreasure(treasure)); 
	}
	
	
}
