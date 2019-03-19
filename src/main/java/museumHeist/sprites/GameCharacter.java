package museumHeist.sprites;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;

import museum_heist.GameBoard;
import museum_heist.Position;

public class GameCharacter extends GameItem /*implements KeyListener*/  {

	Position currentPosition; 
	
	public GameCharacter() {
		int startx = 0;
		int starty = 0; 
		currentPosition = new Position(startx,starty); 
		}
	
	

	//startposition kan sättas via konstruktorn
	public GameCharacter(int x, int y) {
		setCurrentPosition(x,y); 
	}
	
	public int getGameBoardValueOfCurrentPosition() {
		GameBoard gb = new GameBoard(); 
		return gb.getGameBoardValue(currentPosition);
	}

	public void setCurrentPosition(int x, int y) {
		this.currentPosition = new Position(x,y); 
	}
//	
//	public void keyTyped(KeyEvent e) {
//		// Ingen användning 
//	}
//
//	public void keyPressed(KeyEvent e) {
//		int keyCode = e.getKeyCode();
//	
//		if(keyCode==KeyEvent.VK_W) {
//			//do something
//		System.out.println("W pressed"); 	
//		}
//		if(keyCode==KeyEvent.VK_S) {
//			//do something
//		System.out.println("S pressed");
//		}
//		if(keyCode==KeyEvent.VK_A) {
//			//do something
//		System.out.println("A pressed");
//		}
//		if(keyCode==KeyEvent.VK_D) {
//			//do something
//		System.out.println("D pressed");
//		}
//	}
//
//	public void keyReleased(KeyEvent e) {
//		//Ingen användning
//		
//	}

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
	
	public Position getCurrentPosition() {
		return currentPosition;
	}
	}
