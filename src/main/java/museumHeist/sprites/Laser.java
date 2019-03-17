package museumHeist.sprites;

import museum_heist.Position;

public class Laser extends GameItem{
	Position position;

	
	public Laser(int x, int y) 
	{
		setPosition(x,y); 
		
	}
	
	public Position getPosition() {
		
		return this.position;
	}
	
	public void setPosition(int x, int y) 
	{
		this.position = new Position(x,y); 
	}
	
}
