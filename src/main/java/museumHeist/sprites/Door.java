package museumHeist.sprites;

import museum_heist.Position;

public class Door extends GameItem{
	private boolean doorIsLocked;
	private Position doorsPosition;
	
	public Position getDoorsPosition() {
		return doorsPosition;
	}

	public void setDoorsPosition(Position doorsPosition) {
		this.doorsPosition = doorsPosition;
	}

	public boolean getDoorIsLocked() {
		return doorIsLocked; 
	}
	
	public void setdoorIsLocked(boolean isLocked ) {
		doorIsLocked=isLocked; 
	}
	
}
