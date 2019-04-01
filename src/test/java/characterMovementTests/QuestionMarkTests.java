package characterMovementTests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import museumHeist.GUI.Classes.GameBoardInterface;

public class QuestionMarkTests {

	
	// Tester som ska göras - kolla så lumpmetoden slumpar mellan rätt antal case
	// Gör en massa test och returnera int 
	
	//Case 1 - Plockar upp 5 skatter
	// Testa så att dörren öppnas om man har mer än 4 skatter
	// Testa så att man kan gå ut genom dörren fast man har mer än 10 skatter 
	// Testa så att man treasuresLeftOnCurrentLevel är 10 på banan efter om man plcoat mer än 10 skatter
	
	//Case 2 - Stänger av lasern
	// Testa att det inte finns några röda knappar efter att case 2 körts
	// Testa så att det finns röda knappar på banan efter
	
	//Case 3 - Lägger till 2 liv
	// Testa att spelkaraktären får två liv extra
	
	//Case 4 - Lägger till 30 sek
	// Testa så att tiden ökar med 30 sek
	
	//Case 5 - Tar bort 20 sek
	// Testa så att det förvinner 20 sekunder. 
	//Att Game Over visas om tiden blir 0 eller mindre.
	
	GameBoardInterface gb = new GameBoardInterface();
	
	@Ignore
	@Test
	public void randomNumbersWithinRangeTest() {
		//Arrange
		int min = 3;
		int max = 3;
		int rand;
		int expectedMin = 0;
		int expectedMax = 6;
		//Act
		for (int i = 0; i < 100000; i++) {
			rand = gb.randomNumberGenerator(7.0);
			
			if (rand >= max) {
				max = rand;
			}
			
			if (rand <= min) {
				min = rand;
			}
			
		}
		//Assert
		assertEquals(min, expectedMin);
		assertEquals(max, expectedMax);
	}
	
	@Ignore
	@Test
	public void pickUpFiveTreasuresTest() {
		//Arrange
		int expectedTreasures = 5;
		int actualTreasures;
		//Act
		gb.decreaseTreasuresLeftOnLevel(5);
		actualTreasures = gb.getTreasuresLeftOnCurrentLevel(); //måste även kontrollera att antalet skatter o characterObject stämmer
		//Assert
		assertEquals(actualTreasures, expectedTreasures);
		
	}
	
	@Ignore
	@Test
	public void turnOffLaserTest() {
		//Arrange
		
		//Act
		
		//Assert
		
		
	}
	
	@Ignore
	@Test
	public void addTwoLives() {
		//Arrange
		int expectedLives = 5;
		int actualLives;
		//Act
		
		
		//Assert
		
		
	}
	
	@Ignore
	@Test
	public void add30SecondsToTimer() {
		fail("Not yet implemented");
		//Arrange
		
		//Act
		
		//Assert
		
		
	}
	
	@Ignore
	@Test
	public void remove20SecondsFromTimer() {
		fail("Not yet implemented");
		//Arrange
		
		//Act
		
		//Assert
		
		
	}

}
