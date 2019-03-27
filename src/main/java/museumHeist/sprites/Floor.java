package museumHeist.sprites;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Floor extends JButton{
	
	Image image;
	public Floor() 
	{
		this.setBackground(Color.WHITE);
		
		try {
			image = ImageIO.read(this.getClass().getResource("/gameSprites/Ground.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		this.setIcon(new ImageIcon(image));
	}
	
}