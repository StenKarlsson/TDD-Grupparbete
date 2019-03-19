package museumHeist.sprites;

import museum_heist.Position;

public class Wall extends GameItem{
	
	Position position; 
	
	public Wall(int x, int y) {
		setPosition(x,y); 
	}
	
	public void setPosition(int x, int y) 
	{
		this.position = new Position(x,y); 
	}

	public Position getPosition() {
		
		return position;
	}
}
