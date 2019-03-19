package museum_heist;

import java.awt.Point;

//Position är en punkt i 2D
public class Position extends Point {

	public Position(int x, int y) {
		super(x,y); 
		}
	
	public Point getPosition() {
		return super.getLocation(); 
	}
	
	public void setPosition() {
		super.setLocation(x, y);
		
	}
	
}
