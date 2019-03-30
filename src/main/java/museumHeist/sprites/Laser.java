package museumHeist.sprites;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Laser extends JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Laser() {
		this.setBackground(Color.RED);
		
		try {							
			Image image = ImageIO.read(this.getClass().getResource("/gameSprites/laser2.png"));
			this.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean canMove() {
		return false;
	}
	
}
