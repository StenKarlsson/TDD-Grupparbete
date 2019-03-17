package museumHeist.sprites;

import java.awt.geom.Point2D;

import museum_heist.GameBoard;
import museum_heist.Position;

public class GameCharacter extends GameItem{

	Position currentPosition;
	int life = 3;
	
	public GameCharacter() {
		int startx = 2;
		int starty = 2; 
		
		currentPosition = new Position(startx,starty); 
	}
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	//startposition kan sättas via konstruktorn
	public GameCharacter(int x, int y) {
		setCurrentPosition(x,y); 
	}
	
	public int getGameBoardValueOfCurrentPosition() {
		GameBoard gb = new GameBoard(); 
		return gb.getGameBoardValue(currentPosition);
	}

	public void setCurrentPosition(int x, int y) 
	{
		this.currentPosition = new Position(x,y); 
	}

	public void moveOneTileRight() {
		setCurrentPosition((int)currentPosition.getX(),(int)(currentPosition.getY()+1));  
		}
	public void moveOneTileLeft() {
		setCurrentPosition((int)currentPosition.getX(),(int)(currentPosition.getY()-1));  
		}
	public void moveOneTileUp() {
		setCurrentPosition((int)currentPosition.getX()-1,(int)(currentPosition.getY()));  
		}
	public void moveOneTileDown() {
		setCurrentPosition((int)currentPosition.getX()+1,(int)(currentPosition.getY()));  
		}
	
	// Hämtar aktuell position
	public Position getCurrentPosition() {
		return currentPosition;
	}

	
	public boolean isCollidingWith(Wall wall) {
		
		return currentPosition.equals(wall.getPosition());
	}

	public boolean grabsTreasure(Treasure treasure) {
		
		return currentPosition.equals(treasure.getPosition());
	
	}
	
	public boolean isCollidingWith(Laser laser) {
		
		
		return currentPosition.equals(laser.getPosition());
		
	}
	
	// Karaktären dör om den krockar med en laser och har 0 liv kvar

	public boolean isDead(Laser laser) 
	{
	
		return currentPosition.equals(laser.getPosition()) && this.life==0;
	}
	
	// Om karaktären dör så tappar denna ett liv och flyttas till startpositionen
	public void dies() {
		this.life--;
		setCurrentPosition(2, 2);
		
	}

	

	
	}
