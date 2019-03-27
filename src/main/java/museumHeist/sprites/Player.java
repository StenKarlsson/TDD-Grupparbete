package museumHeist.sprites;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Player extends JButton{
	
	Image image;
	public Player() 
	{
		this.setBackground(Color.CYAN);
		
		try {
			image = ImageIO.read(this.getClass().getResource("/gameSprites/Player.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		this.setIcon(new ImageIcon(image));
	}
	
}
