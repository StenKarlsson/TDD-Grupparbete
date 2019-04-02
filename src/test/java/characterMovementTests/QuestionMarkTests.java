package characterMovementTests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import museumHeist.GUI.Classes.GameBoardInterface;
import museumHeist.sprites.Main;

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
	
	
	
	//Här testas metoden som genererad slumpade nummer, som används för att avgöra vad som ska hända när spelaren går på en ruta med frågetecken
	@Ignore
	@Test
	public void randomNumbersWithinRangeTest() {
		//Arrange
		int min = 3;
		int max = 3;
		int rand;
		int expectedMin = 0;
		int expectedMax = 7;
		//Act
		for (int i = 0; i < 100000; i++) {
			rand = gb.randomNumberGenerator(8.0);
			
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
	public void loseOneLifeTest() {
		
		//Arrange
		int actualLives;
		int expectedLives = 2;
		
		//Act
		gb.characterLoseLife(1);
		actualLives = gb.characterGetLives();
		//Assert
		assertEquals(actualLives, expectedLives);
	}
	
	@Ignore
	@Test
	public void pickUpFiveTreasuresTest() throws Exception {
		//Arrange
		int expectedTreasures = 5;
		int actualTreasures;
		//Act
		gb.characterPickUpTreasure(5);
		actualTreasures = gb.characterGetTreasures(); //måste även kontrollera att antalet skatter o characterObject stämmer
		//Assert
		assertEquals(actualTreasures, expectedTreasures);
		
	}
	
	@Ignore
	@Test
	public void turnOffLaserTest() {
		//Arrange
		boolean expected = false;
		boolean actual;
		//Act
		gb.turnOffLaser();
		actual = gb.getLaserStatus();
		//Assert
		assertEquals(actual, expected);
		
	}
	
	@Ignore
	@Test
	public void addThreeLives() {
		//Arrange
		int expectedLives = 6;
		int actualLives;
		//Act
		gb.characterAddLives(3);
		actualLives = gb.characterGetLives();
		
		//Assert
		assertEquals(actualLives, expectedLives);
		
	}
	
	@Ignore
	@Test
	public void add30SecondsToTimer() {
		//Arrange
		int expectedTime;
		int actualTime;
		//Act
		expectedTime = 150+30;				// 150 sekunder är standard tiden
		Main.setTimeInSeconds(Main.getTimeInSeconds()+30);
		actualTime = Main.getTimeInSeconds();
		
		//Assert
		assertEquals(actualTime, expectedTime);
		
	}
	
	@Ignore
	@Test
	public void subtract30SecondsFromTimer() {
		//Arrange
		int expectedTime;
		int actualTime;
		//Act
		expectedTime = 150-30;
		Main.setTimeInSeconds(Main.getTimeInSeconds()-30);
		actualTime = Main.getTimeInSeconds();
		
		//Assert
		assertEquals(actualTime, expectedTime);
	}
	
	
	
	@Ignore
	@Test
	public void slowDownLaserTest() {
		//Arrange
		int actualLaserSpeed;
		int expectedLaserSpeed;
		//Act
		expectedLaserSpeed = 3000;
		Main.setLaserSpeed(3000);
		actualLaserSpeed = Main.getLaserSpeed();
		
		//Assert
		assertEquals(actualLaserSpeed, expectedLaserSpeed);
		
	}

	
	@Test
	public void speedUpLaser() {
		//Arrange
		int actualLaserSpeed;
		int expectedLaserSpeed;
		//Act
		expectedLaserSpeed = 500;
		Main.setLaserSpeed(500);
		actualLaserSpeed = Main.getLaserSpeed();
		//Assert
		assertEquals(actualLaserSpeed, expectedLaserSpeed);
	}
}
