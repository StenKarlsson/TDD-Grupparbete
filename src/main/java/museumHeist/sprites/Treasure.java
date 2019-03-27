package museumHeist.sprites;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Treasure extends JButton{
	
	Image image;
	public Treasure() 
	{
		this.setBackground(Color.ORANGE);
		
		try {
			image = ImageIO.read(this.getClass().getResource("/gameSprites/Treasure.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		this.setIcon(new ImageIcon(image));
	}
	
}
