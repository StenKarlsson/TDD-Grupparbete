package museumHeist.sprites;

public class Main {
	//skapade en mainklass bara för att leka med objekten lite 
	public static void main(String[] args) {
		GameCharacter c1 = new GameCharacter(); 
		GameCharacter c2 = new GameCharacter(0,1); 
		System.out.println(c1.getCurrentPosition());
		
		c1.moveOneTileRight();
		System.out.println(c1.getCurrentPosition());
		
		
		
	}
	
}
