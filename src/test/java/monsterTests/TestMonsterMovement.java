package monsterTests;

import static org.junit.Assert.*;

import java.awt.Color;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import museumHeist.GUI.Classes.GameBoardInterface;
import museum_heist.Position;

public class TestMonsterMovement {

	//Arrange
		GameBoardInterface gb;
		
		
		@Before
		public void setup() 
		{
			gb = new GameBoardInterface();
			gb.setLevel(10); // Väljer den bana som är konstruerad för att testa monstrets rörelse
		}

		// Här undersöks monstrets rörelse som bygger på att x och y variablarna jämförs med spelkaraktärens position och flyttar mot denna.
		
		
		@Test
		public void MonsterShouldMoveTowardsCharacterFromLeft() 
		{
			//Arrange - spelkaraktären sätts två rutor till vänster om monstret
			gb.getCharacter().setCurrentPosition(19, 21);
		
			// Act - Monstret rör sig mot spelkaraktären en gång utifrån dennas position
			gb.monsterCanMoveTowardsCharacter(gb.getSquares());
			
			// Assert - monstret ska ha tagit ett steg mot spelkaraktären vars ruta nu ska ha färgen LIGHT_GREY
			
			assertEquals(Color.LIGHT_GRAY, gb.getColorOfTile(new Position(20, 21)));	
			
		}
		
		@Test
		public void MonsterShouldMoveTowardsCharacterFromRight() 
		{
			//Arrange - spelkaraktären sätts två rutor till höger om monstret
			gb.getCharacter().setCurrentPosition(21, 23);
		
			// Act - Monstret rör sig mot spelkaraktären en gång utifrån dennas position
			gb.monsterCanMoveTowardsCharacter(gb.getSquares());
			
			// Assert - monstret ska ha tagit ett steg mot spelkaraktären vars ruta nu ska ha färgen LIGHT_GREY
			
			assertEquals(Color.LIGHT_GRAY, gb.getColorOfTile(new Position(21, 22)));	
			
		}
		
		@Test
		public void MonsterShouldMoveTowardsCharacterFromUnder() 
		{
			//Arrange - spelkaraktären sätts två rutor ovanför monstret
			gb.getCharacter().setCurrentPosition(21, 19);
		
			// Act - Monstret rör sig mot spelkaraktären en gång utifrån dennas position
			gb.monsterCanMoveTowardsCharacter(gb.getSquares());
			
			// Assert - monstret ska ha tagit ett steg mot spelkaraktären vars ruta nu ska ha färgen LIGHT_GREY
			assertEquals(Color.LIGHT_GRAY, gb.getColorOfTile(new Position(21, 20)));	
			
		}
		
		@Test
		public void MonsterShouldMoveTowardsCharacterFromOver() 
		{
			//Arrange - spelkaraktären sätts två rutor under monstret
			gb.getCharacter().setCurrentPosition(21, 23);
		
			// Act - Monstret rör sig mot spelkaraktären en gång utifrån dennas position
			gb.monsterCanMoveTowardsCharacter(gb.getSquares());
			
			// Assert - monstret ska ha tagit ett steg mot spelkaraktären vars ruta nu ska ha färgen LIGHT_GREY
			
			assertEquals(Color.LIGHT_GRAY, gb.getColorOfTile(new Position(21, 22)));	
			
		}
		
		
		
		@Test
		public void MonsterShouldKillCharacterOnImpact() 
		{
			//Arrange - spelkaraktären sätts två rutor under monstret och ges färgen turkos
			gb.getCharacter().setCurrentPosition(21, 22);
			gb.colouriseSquare(Color.CYAN, gb.getCharacter().getCurrentPosition());
			
			// Act - Monstret rör sig mot spelkaraktären en gång utifrån dennas position
			gb.monsterCanMoveTowardsCharacter(gb.getSquares());
			
			// Assert - Spelaren ska tappa ett liv

			assertEquals(2, gb.getCharacter().getLife());
		}
		
		@Test
		public void MonsterShouldMoveCharacterToStartPosition() 
		{
			//Arrange - spelkaraktären sätts två rutor under monstret och ges färgen turkos 
			gb.getCharacter().setCurrentPosition(21, 22);
			gb.colouriseSquare(Color.CYAN, gb.getCharacter().getCurrentPosition());
			
			// Act - Monstret rör sig mot spelkaraktären en gång utifrån dennas position
			gb.monsterCanMoveTowardsCharacter(gb.getSquares());
			
			// Assert - Spelaren ska flytta till startpositionen

			assertEquals(new Position(1, 1), gb.getCharacter().getCurrentPosition());
		}
		
		@Test
		public void MonsterShouldMoveToStartPosition() 
		{
			//Arrange - spelkaraktären sätts två rutor under monstret och ges färgen turkos
			gb.getCharacter().setCurrentPosition(21, 22);
			gb.colouriseSquare(Color.CYAN, gb.getCharacter().getCurrentPosition());
			
			// Act - Monstret rör sig mot spelkaraktären en gång utifrån dennas position
			gb.monsterCanMoveTowardsCharacter(gb.getSquares());
			
			// Assert - Monstret ska flytta till startpositionen vilket betyder att position 21, 21 ska vara LIGHT_GREY

			assertEquals(Color.LIGHT_GRAY, gb.getColorOfTile(new Position(21, 21)));
		}
		
		// Rutan vid kollisonen ska inte vara LIGHT_GREY, dvs vara ett monster
		
		@Test
		public void MonsterShouldOnlyExistInOnePlace() 
		{
			//Arrange - spelkaraktären sätts två rutor under monstret och ges färgen turkos
			gb.getCharacter().setCurrentPosition(21, 22);
			gb.colouriseSquare(Color.CYAN, gb.getCharacter().getCurrentPosition());
			
			// Act - Monstret rör sig mot spelkaraktären en gång utifrån dennas position
			gb.monsterCanMoveTowardsCharacter(gb.getSquares());
			
			// Assert - Monstret ska flytta till startpositionen vilket betyder att position 21, 21 ska vara LIGHT_GREY

			assertEquals(Color.WHITE, gb.getColorOfTile(new Position(21, 22)));
		}
		
		// Även om det inte finns en position som är i riktning mot karaktären så ska monstret röra sig
		
				@Test
				public void MonsterShouldAlwaysMove() 
				{
					//Arrange - Monstret kan pga väggar bara gå i en riktning rkt bak bort från karaktären
					gb.setLevel(11);
					// Karaktären sätts ovanför monstret med en vägg mellan
					gb.getCharacter().setCurrentPosition(21, 19);
					gb.colouriseSquare(Color.CYAN, gb.getCharacter().getCurrentPosition());
					
					// Act - Monstret rör sig mot spelkaraktären en gång utifrån dennas position
					
					gb.forceMonsterToMove();
					
					 // Assert - monstret ska ha tagit ett steg nedåt, dvs positionen ska vara LIGHT__GREY
					assertEquals(Color.LIGHT_GRAY, gb.getColorOfTile(new Position(22, 21)));
				}
		

}
