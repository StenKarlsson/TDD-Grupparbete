package museumHeist.sprites;

import museum_heist.Position;

public class Treasure {

	Position position; 
	
	
	
	public Treasure(int x, int y) 
	{
		setPosition(x,y); 
		
	}
	public Position getPosition() {
		
		return position;
	}
	
	public void setPosition(int x, int y) 
	{
		this.position = new Position(x,y); 
	}

}
