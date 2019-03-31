package characterMovementTests;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

import museumHeist.GUI.Classes.GameBoardInterface;
import museumHeist.sprites.GameCharacter;
import museum_heist.Position;

public class GuiControlledMovementTests {
	/*Här testas ifall färgsättningen av spelplanens rutnät följer med en 
	 * förflyttning av spelkaraktären åt en viss riktning dvs karaktärens förändrade position ska 
	 * påverka spelbrädets färgsättning
	 * Detta genom GUIs egna metoder för förflyttning
	*/
	
	 
	//Färgen på rutan spelaren befinner sig på ska vara cyan
	//Efter förflyttning skett ska samma ruta vara vit 
	@Test
	public void tileChangesColorWhenMovedFrom() {
		//Arrange 
		GameBoardInterface gb = new GameBoardInterface();
		gb.getCharacter().setCurrentPosition(1, 1);//spelkaraktären flyttas till en specifik position
		Position pos = new Position(1, 1); //Variabeln pos antar dess uvarande värde
		//Act 
		//Färgen på rutan (pos) innan förflyttningen 
		Color colorOnTileBeforeMovement = gb.getColorOfTile(pos); 
		//Assert
		//Färgen innan förflyttningen ska vara cyan 
		assertEquals(colorOnTileBeforeMovement,Color.CYAN);
		
		//karakträen flyttar från rutan via metoden i gui
		gb.updateCharacterPosition("Right");
		//Färgen på samma ruta (pos) efter förflyttningen ska vara vit
		Color colorOnTileAfterMovement = gb.getColorOfTile(pos); 
		assertEquals(colorOnTileAfterMovement,Color.WHITE);
		}
	
	
	//Färgen till höger om karaktärens position ska vara vit 
	//När karaktären flyttar till höger ska samma ruta anta färgen cyan
	public void tileChangesColorWhenMovedTo() {
		//Arrange 
		GameBoardInterface gb = new GameBoardInterface();
		gb.getCharacter().setCurrentPosition(1, 1);//spelkaraktären flyttas till en specifik position
		Position pos = new Position(1, 2); //Variabeln pos representerar rutan till höger om karaktären
		
		//Act 
		
		//Färgen på rutan (pos) innan förflyttningen 
		Color colorOnTile = gb.getColorOfTile(pos); 
		//Assert
		//Färgen innan spelaren flyttat dit ska vara vit 
		assertEquals(colorOnTile,Color.WHITE);
		
		//karaktären flyttar till till höger via metoden i gui
		gb.updateCharacterPosition("Left");
		
		//Färgen på samma ruta (pos) efter förflyttningen ska vara cyan
		assertEquals(colorOnTile,Color.CYAN);
		}
	
	
	
}
