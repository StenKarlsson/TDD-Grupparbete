package museumHeist.GUI.Classes;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import javafx.scene.chart.ValueAxis;
import museumHeist.sprites.GameCharacter;
import museum_heist.Levels;
import museum_heist.Position;


public class GameBoardInterface extends JFrame {
	
	public boolean LevelCompleted = false;
	private GameCharacter characterObject = new GameCharacter(1, 1);
	public JButton[][] squares = new JButton[25][25]; //
	private JPanel board;
	
	private int[][]  currentLevel = Levels.getLevel(1);
	static boolean laserOn = true;
	
	

	
	public GameBoardInterface() {
		
		
		this.setSize(1200, 1200);
		board = new JPanel(new GridLayout(25, 25));
	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildButtonArray();
		this.setVisible(true);

		paintButtonArray();
		this.add(board);
		drawCharacterStartingPosition();
		
		addKeyBinding(board, KeyEvent.VK_W, "North", (evt) -> {
			updateCharacterPosition("North");
		});
		
		addKeyBinding(board, KeyEvent.VK_S, "South", (evt) -> {
			updateCharacterPosition("South");
		});
		
		addKeyBinding(board, KeyEvent.VK_D, "East", (evt) -> {
			updateCharacterPosition("East");
		});
		
		addKeyBinding(board, KeyEvent.VK_A, "West", (evt) -> {
			updateCharacterPosition("West");
		});
	}
	
public static void addKeyBinding(JComponent comp, int keyCode, String id, final ActionListener actionListener) {
		InputMap im = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap ap = comp.getActionMap();
		
		im.put(KeyStroke.getKeyStroke(keyCode, 0), id);
		
		ap.put(id, new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				actionListener.actionPerformed(e);
				
			}
		});
		
	}

	private void paintButtonArray() {
		//Måla ut de färglagda knapparna på panelen, ruta för ruta. 
		for (int boardRows = 0; boardRows < 25; boardRows++) {
			for (int boardColumns = 0; boardColumns < 25; boardColumns++) {
				board.add(squares[boardRows][boardColumns]);
			}
		}
	}

	private JButton createButton(Color color) 
	{
		JButton newButton = new JButton();
		newButton.setBorderPainted(false);
		newButton.setOpaque(true);
		newButton.setBackground(color);
		
		return newButton;
		
	}
	private void buildButtonArray() {
		//För varje vågrät rad i int []startArray...
		for (int row = 0; row < currentLevel.length; row++) {
			System.out.println();
			//...så itererar vi igenom varje kolumn
			for (int col = 0; col < currentLevel[row].length; col++) {
				//Om positionen i 2D-array är = 1 måla motsvarande ruta i squares med svart 
				
				if (currentLevel[row][col] == 1) {
					
					
					
					
				//Borkommenterad kod målar ut bilder istället för färger 
					try {							
					Image image = ImageIO.read(this.getClass().getResource("/gameSprites/Wall.png"));
					
					squares[row][col] = createButton(Color.BLACK);
					squares[row][col].setIcon(new ImageIcon(image));
				} catch (IOException e) {
					e.printStackTrace();
				}
					//squares[row][col] = createButton(Color.BLACK);
				}
				
				//Om positionen i 2D-array är = 0 måla motsvarande ruta med svart 
				if (currentLevel[row][col] == 0 || currentLevel[row][col] == 6) {
					
				
					//Bortkommenterad kod målar ut bilder istället för färger
					try {							
						Image image = ImageIO.read(this.getClass().getResource("/gameSprites/Ground.png"));
						squares[row][col] = createButton(Color.WHITE);
						squares[row][col].setIcon(new ImageIcon(image));
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					//squares[row][col] = createButton(Color.WHITE);
				}
				if (currentLevel[row][col] == 5) {
					
					try {							
						Image image = ImageIO.read(this.getClass().getResource("/gameSprites/Treasure.png"));
						squares[row][col] = createButton(Color.WHITE);
						squares[row][col].setIcon(new ImageIcon(image));
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					//squares[row][col] = createButton(Color.ORANGE);
				}
				if (currentLevel[row][col] == 3) {
					
					try {							
						Image image = ImageIO.read(this.getClass().getResource("/gameSprites/Laser.png"));
						squares[row][col] = createButton(Color.WHITE);
						squares[row][col].setIcon(new ImageIcon(image));
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					//squares[row][col] = createButton(Color.RED);
					
				}
				if(currentLevel[row][col] == 2) {
				
					try {							
						Image image = ImageIO.read(this.getClass().getResource("/gameSprites/Player.png"));
						squares[row][col] = createButton(Color.GREEN);
						squares[row][col].setIcon(new ImageIcon(image));
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					//squares[row][col] = createButton(Color.GREEN);
				}
				

			}
		}
	}
	
	//färglägger en enskild ruta i grid
	private void colouriseSquare(Color colour, Position position) 
	{
	
		Image image = null;
		squares[(int) position.getX()][(int) position.getY()].setBackground(colour);
		
		try {
			if (colour == Color.CYAN) // Spelare
				image = ImageIO.read(this.getClass().getResource("/gameSprites/Player.png"));
			if (colour == Color.BLACK) // Vägg
				image = ImageIO.read(this.getClass().getResource("/gameSprites/Wall.png"));
			if (colour == Color.ORANGE) // Skatt
				image = ImageIO.read(this.getClass().getResource("/gameSprites/Treasure.png"));
			if (colour == Color.RED) // Laser 
				image = ImageIO.read(this.getClass().getResource("/gameSprites/Laser.png"));
			if (colour == Color.GREEN) // Dörr
				image = ImageIO.read(this.getClass().getResource("/gameSprites/Door.png"));
			if (colour == Color.WHITE) // Golv
				image = ImageIO.read(this.getClass().getResource("/gameSprites/Ground.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		pictuizeSquare(image, position);
		
		
	}
	
	private void pictuizeSquare(Image image, Position position) {
		
		
		
		squares[(int) position.getX()][(int) position.getY()].setIcon(new ImageIcon(image));
	
	
}
	
	//Placerar spelaren på startposition	
	private void drawCharacterStartingPosition() {
		colouriseSquare(Color.CYAN, characterObject.getCurrentPosition());
		
		
	}
	
	
	
	// Bestämmer vad som händer när karaktären går på diverse objekt/siffra i arrayen
	public boolean positionEvent(Position nextTileDirection, String direction) 
	
	{
		boolean runCode = true;
		
		if (getColorOfTile(nextTileDirection)==Color.ORANGE) // Skatt
			
		{
			
			characterObject.grabTreasure(); // Skatt +1
			System.out.println("Skatt upplockad, totalt " + characterObject.getTreasures() );
		}
		
		if (getColorOfTile(nextTileDirection)==Color.BLACK) // Vägg
			
		{
			System.out.println("Wall to the " + direction);
			runCode = false; // Flytta inte spelaren
		}
		
		if (getColorOfTile(nextTileDirection)==Color.RED) // Laser
			
		{
			// Flyttar till spelaren till startposition 
			colouriseSquare(Color.WHITE, characterObject.getCurrentPosition());
			
			characterObject.setCurrentPosition(1, 1);
			colouriseSquare(Color.CYAN, characterObject.getCurrentPosition());
			
			runCode = false;
		}
		
		if (getColorOfTile(nextTileDirection)==Color.GREEN) // Dörr
			
		{
			
			this.LevelCompleted=true;
			
		}

		
		return runCode; // Ska spelaren flytta sig?
		
	}
	
	//Ändrar spelarens/karaktärens position samt byter färg på rutan den flyttar till
	public void updateCharacterPosition(String direction) {
		String recievedString = direction;
		boolean _runCode = true;
		switch (recievedString) 
		{
			case "East": 
			{
				//Undersöker positionen åt höger
				Position nextTileRight = (new Position((int)characterObject.getCurrentPosition().getX(),
						(int)characterObject.getCurrentPosition().getY()+1));
				
				
				_runCode= positionEvent(nextTileRight, recievedString);
				break;
				
				
			}
			
			case "West": {
				
				//Undersöker positionen åt vänster
				Position nextTileLeft = (new Position((int)characterObject.getCurrentPosition().getX(),
				(int)characterObject.getCurrentPosition().getY()-1)); 
				
				_runCode =positionEvent(nextTileLeft, recievedString);
				break;
				
			}
			case "South": {
				
				//Undersöker positionen neråt
				Position nextTileDown = (new Position((int)characterObject.getCurrentPosition().getX()+1,
				(int)characterObject.getCurrentPosition().getY())); 
				
				_runCode= positionEvent(nextTileDown, recievedString);
				break;
				
						
				
			}
			case "North": {
				//Undersöker positionen uppåt
				Position nextTileUp = (new Position((int)characterObject.getCurrentPosition().getX()-1,
				(int)characterObject.getCurrentPosition().getY())); 
				
				_runCode = positionEvent(nextTileUp, recievedString);
				break;
						
				
				} 
		}
		
		if(_runCode) 
		{
			// Färgar positionen WHITE
			colouriseSquare(Color.WHITE, characterObject.getCurrentPosition());	
			
			// Spelaren förflyttar sig
			if (direction.equals("East")){characterObject.moveOneTileRight();}
			if (direction.equals("West")){characterObject.moveOneTileLeft();}
			if (direction.equals("South")){characterObject.moveOneTileDown();}
			if (direction.equals("North")){characterObject.moveOneTileUp();}
			
			// Färgar positionen CYAN
			colouriseSquare(Color.CYAN, characterObject.getCurrentPosition());
			System.out.println(characterObject.getCurrentPosition().getX());
			System.out.println(characterObject.getCurrentPosition().getY());
			
			
			
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
	
	public static boolean flipLaser() 
	{
		System.out.println(laserOn);
		
		return laserOn =!laserOn; 
	
	}
	
	public void flipLaserOnGameBoard(JButton[][] squares) 
	{
		for ( int q = 0; q < squares.length; q++ )
        {
            for ( int x = 0; x < squares[0].length; x++ )
            {
            	Position position = new Position(q, x);
                Color color = getColorOfTile(position);
                int value = getGridValueOfPosition(position);
                if (value==3 || value ==6) 
                {
                	if (color == color.RED) {colouriseSquare(color.WHITE,position);}
                	else colouriseSquare(color.RED,position);
                	
                }
                
                
                
            }
            
       }
		
		
	}

	

	 
}
