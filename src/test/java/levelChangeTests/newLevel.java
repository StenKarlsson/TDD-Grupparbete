package levelChangeTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.junit.Test;
import museumHeist.GUI.Classes.GameBoardInterface;
import museum_heist.Position;

public class newLevel {

	@Test
	public void assertDoorOpensWhenTreasuresAreFound() {
	/*I denna metod görs antagandet att om karaktären samlat på sig 10 stycken skatter ska
	 *  dörren byta tillstån från låst till olåst */

	//Arrange 
	GameBoardInterface gb = new GameBoardInterface(); 
		
	//Act 
	gb.getDoor().setdoorIsLocked(true); //Dörren är låst från början
	
	//10 skatter plockas upp från banan
	for(int i = 0; i<10; i++) {
		gb.decreaseTreasuresLeftOnLevel();
	}

	//Assertera att dörren nu är öppen
	assertFalse(gb.getDoor().getDoorIsLocked());
	}
	
	@Test
	public void assertLevelChangesWhenCharacterEntersDoor() {
		
		/*I denna metod görs antagandet att om dörren är olåst och spelaren
		 *  befinner sig på samma position som dörren ska spelet byta bana */

		//Arrange 
		GameBoardInterface gb = new GameBoardInterface(); 
			
		//Act 
		gb.setLevel(1); //Börja på första banan
		gb.getDoor().setdoorIsLocked(false);
		//Karaktären sätts på samma position som dörren
	
		//10 skatter plockas upp från banan
		for(int i = 0; i<10; i++) {
			gb.decreaseTreasuresLeftOnLevel();
		}
		
		//Placerakaraktären på platsen där dörren är. 
		gb.getCharacter().setCurrentPosition((int) gb.getDoor().getDoorsPosition().getX(),(int) gb.getDoor().getDoorsPosition().getX());
		//Anrop av metod som avgör vad som ska ända om karaktären befinner sig på en position
		gb.positionEvent(gb.getDoor().getDoorsPosition(), "North"); 
		
		//Assert
		//Ny bana ska genereras och levelcound därmed vara 2 
		assertTrue(gb.getLevelCount()==2);	
		
		
		
	}
}
