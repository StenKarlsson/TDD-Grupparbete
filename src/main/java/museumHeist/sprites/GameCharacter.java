package museumHeist.sprites;

import java.awt.geom.Point2D;

import javax.imageio.ImageTypeSpecifier;

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
	
	public int getGameBoardValueOfCurrentPosition(int level) {
		GameBoard gb = new GameBoard(); 
		return gb.getGameBoardValue(currentPosition, level);
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

	public boolean isDead() 
	{
	
		return this.life==0;
	}
	
	// Om karaktären dör så tappar denna ett liv och flyttas till startpositionen
	public void isKilled() 
	{
		this.life--;
		setCurrentPosition(2, 2);
		
	}

	

	public void updatePosition(GameBoard gameBoard, int level) 
	{
		// Om spelplanens position ger värdet 5 har karaktären gått in i en laser
		if (5==gameBoard.getGameBoardValue(this.currentPosition, level))
		{
			this.isKilled();
		}
		
		
	}

	

	

	
	}
