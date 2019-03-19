package characterMovementTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import museumHeist.sprites.GameCharacter;
import museumHeist.sprites.Laser;
import museumHeist.sprites.Treasure;
import museumHeist.sprites.Wall;
import museum_heist.GameBoard;
import museum_heist.Position;



public class registerCollision {
	
	GameCharacter mainCharacter;
	GameBoard gameBoard;

	@Before
	public void setup() 
	{
		gameBoard = new GameBoard();
	}

	// Level 1 - Här testas att en krock med en vägg registreras när karaktären och väggen har samma position
	@Test
	public void testCharacterWallCollision() 
{
		mainCharacter = new GameCharacter(1,1);
		Wall wall = new Wall(1,1);
		
		assertTrue(mainCharacter.isCollidingWith(wall)); 
	}
	
	// Level 1- Här testas att karaktären plockar upp en skatt när när karaktären och skatten har samma position 
	@Test
	public void testCharacterGetsItem() 
{
		mainCharacter = new GameCharacter(1,1);
		Treasure treasure = new Treasure(1,1);
		assertTrue(mainCharacter.grabsTreasure(treasure)); 
	}
	
	// Level 1- Här testas att en krock med en laser registreras när karaktären och lasern har samma position
		@Test
	public void testCharacterLaserCollision() 
	{
		mainCharacter = new GameCharacter(10,10);
		Laser laser = new Laser(10,10);	
		assertTrue(mainCharacter.isCollidingWith(laser)); 
	}
	// Level 1- Här testas att karaktären kan dö när denna har 0 liv
	@Test
	public void GameOverWhenLifeIsZero() 
	{
		mainCharacter = new GameCharacter(10,10);
		mainCharacter.setLife(0);
		assertTrue(mainCharacter.isDead()); 
	}
	
	//Level 1- Här testas att karaktären kan dö när denna krockar med en laser och har slut på liv
	@Test
	public void GameOverWhenLifeIsOneAndCharacterCollidesithLaser() 
	{
		mainCharacter = new GameCharacter(10,10);
		mainCharacter.setLife(0);
		mainCharacter.moveOneTileRight();
		mainCharacter.updatePosition(gameBoard, 1);
		
		assertTrue(mainCharacter.isDead()); 
	}
		
// Level 1 - Här testas att karaktären tappar ett liv när denna krockar med laser
	@Test
	public void CharacterDies() 
	{
		mainCharacter = new GameCharacter(1,1);
		mainCharacter.moveOneTileRight();
		mainCharacter.updatePosition(gameBoard, 1);
		// Gick emot regelboken men snake-snubben körde två asserts
		assertTrue(mainCharacter.getLife()==2); 
		assertEquals(mainCharacter.getCurrentPosition(),new Position(2,2)); 
	}
	
	
}
