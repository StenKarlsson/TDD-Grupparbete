package museum_heist_test;

import org.junit.Test;

import museum_heist.MuseumHeist;

public class MuseumHeistTest {

	@Test
	public void moveLeft() {
		MuseumHeist game = new MuseumHeist();
		game.move(LEFT);
		assertThat(game.getPosition(), is()) // behöver argument i "is" för att kolla att positionen har ändrats ett steg åt vänster
	}
	
	
}
