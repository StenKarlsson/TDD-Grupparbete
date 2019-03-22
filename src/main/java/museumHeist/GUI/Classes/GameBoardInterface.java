package museumHeist.GUI.Classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import museumHeist.sprites.GameCharacter;
import museum_heist.Position;
	
public class GameBoardInterface extends JFrame {
	
	private GameCharacter characterObject = new GameCharacter(1, 1);
	private JButton[][] squares = new JButton[25][25]; //
	private JPanel board;
	private int[][]  currentLevel  = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
								      {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 		    	          {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,}
																										};
	
	public GameBoardInterface() {
		
		
		this.setSize(1200, 1200);
		board = new JPanel(new GridLayout(25, 25));
	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//För varje vågrät rad i int []startArray...
		for (int row = 0; row < currentLevel.length; row++) {
			System.out.println();
			//...så itererar vi igenom varje kolumn
			for (int col = 0; col < currentLevel[row].length; col++) {
				//Om positionen i 2D-array är = 1 måla motsvarande ruta i squares med svart 
				if (currentLevel[row][col] == 1) {
					JButton newButton = new JButton();
					newButton.setBorderPainted(false);
				
				newButton.setBackground(Color.BLACK);
				//Borkommenterad kod målar ut bilder istället för färger 
//					try {							
//					Image image = ImageIO.read(this.getClass().getResource("/gameSprites/wallStone02_0000.png"));
//					newButton.setIcon(new ImageIcon(image));
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
					squares[row][col] = newButton;
				}
				
				//Om positionen i 2D-array är = 0 måla motsvarande ruta med svart 
				if (currentLevel[row][col] == 0) {
					JButton newButton = new JButton();
					newButton.setBorderPainted(false);
					newButton.setBackground(Color.WHITE);
				
					//Bortkommenterad kod målar ut bilder istället för färger
//					try {							
//						Image image = ImageIO.read(this.getClass().getResource("/gameSprites/wallEarth01_0002.png"));
//						newButton.setIcon(new ImageIcon(image));
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
					squares[row][col] = newButton;
				}

			}
		}
		this.setVisible(true);

		//Måla ut de färglagda knapparna på panelen, ruta för ruta. 
		for (int boardRows = 0; boardRows < 25; boardRows++) {
			for (int boardColumns = 0; boardColumns < 25; boardColumns++) {
				board.add(squares[boardRows][boardColumns]);
			}
		}
		this.add(board);
		drawCharacterStartingPosition();

		//Keylistener till knapparna som ska styra figuren
		this.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
				//Denna metod måste implementeras men används inte
			}
			
			public void keyReleased(KeyEvent e) {
				//Denna metod måste implementeras men används inte
			}
			
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				
				if (keyCode == KeyEvent.VK_W) {
					updateCharacterPosition("North");
				}
			
				if (keyCode == KeyEvent.VK_S) {
					updateCharacterPosition("South");
					
				}
				if (keyCode == KeyEvent.VK_A) {
					updateCharacterPosition("West");
					
				}
				if (keyCode == KeyEvent.VK_D) {
					updateCharacterPosition("East");
				}
			}
		});
	
	}
	
	//färglägger en enskild ruta i grid
	private void colouriseSquare(Color colour, Position position) {
	
		squares[(int) position.getX()][(int) position.getY()].setBackground(colour);
		
		//Borkommenterad kod målar ut bilder istället för färger 
//	try {							
//			Image image = ImageIO.read(this.getClass().getResource("/gameSprites/skull0000.png"));
//			squares[(int) position.getX()][(int) position.getY()].setIcon(new ImageIcon(image));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
}
	
	//Placerar spelaren på startposition	
	private void drawCharacterStartingPosition() {
		colouriseSquare(Color.CYAN, characterObject.getCurrentPosition());
		
	}
	
	
	
	//Ändrar spelarens/karaktärens position samt byter färg på rutan den flyttar till
	public void updateCharacterPosition(String direction) {
		String recievedString = direction;
		switch (recievedString) {
			case "East": {
				
				//Kolla att positionen till höger inte är en vägg
				Position nextTileRight = (new Position((int)characterObject.getCurrentPosition().getX(),
				(int)characterObject.getCurrentPosition().getY()+1)); 
						
				if (1 == getGridValueOfPosition(nextTileRight)) {
					System.out.println("Kan inte gå in i vägg till höger");
				break; 	
				} else { //Om det inte är vägg kan den gå höger
				
				colouriseSquare(Color.WHITE, characterObject.getCurrentPosition());
				characterObject.moveOneTileRight();
				colouriseSquare(Color.CYAN, characterObject.getCurrentPosition());
				System.out.println(characterObject.getCurrentPosition().getX());
				System.out.println(characterObject.getCurrentPosition().getY());
				
				break;
				}
			}
			
			case "West": {
				
				//Kolla att positionen till vänster inte är en vägg
				Position nextTileLeft = (new Position((int)characterObject.getCurrentPosition().getX(),
				(int)characterObject.getCurrentPosition().getY()-1)); 
						
				if (1 == getGridValueOfPosition(nextTileLeft)) {
					System.out.println("Kan inte gå in i vägg till vänster");
					break; 
				} else { //Om det inte är vägg kan den gå vänster
					
				colouriseSquare(Color.WHITE, characterObject.getCurrentPosition());
				characterObject.moveOneTileLeft();
				colouriseSquare(Color.CYAN, characterObject.getCurrentPosition());
				System.out.println(characterObject.getCurrentPosition().getX());
				System.out.println(characterObject.getCurrentPosition().getY());
				break;
				}
			}
			case "South": {
				
				//Kolla att positionen under inte är en vägg
				Position nextTileDown = (new Position((int)characterObject.getCurrentPosition().getX()+1,
				(int)characterObject.getCurrentPosition().getY())); 
						
				if (1 == getGridValueOfPosition(nextTileDown)) {
					System.out.println("Kan inte gå in i vägg nedan");
					break; 
				} else { //Om det inte är vägg kan den gå nedåt
					
				colouriseSquare(Color.WHITE, characterObject.getCurrentPosition());
				characterObject.moveOneTileDown();
				colouriseSquare(Color.CYAN, characterObject.getCurrentPosition());
				System.out.println(characterObject.getCurrentPosition().getX());
				System.out.println(characterObject.getCurrentPosition().getY());
				break;
				}
			}
			case "North": {
				//Kolla att positionen ovanför inte är en vägg
				Position nextTileUp = (new Position((int)characterObject.getCurrentPosition().getX()-1,
				(int)characterObject.getCurrentPosition().getY())); 
						
				if (1 == getGridValueOfPosition(nextTileUp)) {
					System.out.println("Kan inte gå in i vägg ovan");
					break; 
				} else { //Om det inte är vägg kan den gå uppåt
					
					colouriseSquare(Color.WHITE, characterObject.getCurrentPosition());
					characterObject.moveOneTileUp();
					colouriseSquare(Color.CYAN, characterObject.getCurrentPosition());
					System.out.println(characterObject.getCurrentPosition().getX());
					System.out.println(characterObject.getCurrentPosition().getY());
				break; 
				}
				}
		}
	}
	
	//returnerar färgen på en specifik ruta i rutnätet som utgör spelplanen
	public Color getColorOfTile(Position position) {
		
		JButton button = squares[(int) position.getX()][(int) position.getY()];
		Color color = button.getBackground();
		return color;
	}
	
	
	public GameCharacter getCharacter() {
		return characterObject;
	}
	
	public JButton[][] getGridContent() {
		return squares;
	}

	private int getGridValueOfPosition(Position pos) {
		int row = (int) pos.getX();
		int column = (int)pos.getY();
		int value = currentLevel[row][column];
		return value;
	} 
}

