package museumHeist.GUI.Classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

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
import javax.swing.SwingConstants;

import museumHeist.sprites.Door;
import museumHeist.sprites.GameCharacter;
import museumHeist.sprites.Main;
import museum_heist.Levels;
import museum_heist.Position;


public class GameBoardInterface extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameCharacter characterObject = new GameCharacter(1, 1);
	private JButton[][] squares; 
	private JPanel board;
	private int levelCount; 
	private int[][]  currentLevel;
	private Door door; 
	private int treasuresLeftOnCurrentLevel; 
	int level = 1;
	
	public boolean LevelCompleted = false;
	Position startposition = new Position (1,1);
	

	static boolean laserOn = true;
	
	public GameBoardInterface() {
		setSquares(new JButton[25][25]);
		setCurrentLevel(Levels.getLevel(1));
		levelCount=1; 
		this.setSize(1200, 1200);
		board = new JPanel(new GridLayout(25, 25));
		door = new Door(); 
		door.setdoorIsLocked(true);
		treasuresLeftOnCurrentLevel = 10; 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildButtonArray();
		this.setVisible(true);

		paintButtonArray();
		this.add(board);
		drawCharacterStartingPosition();
		
        this.setFocusable(true);
        this.requestFocusInWindow();

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
				board.add(getSquares()[boardRows][boardColumns]);
			}
		}
	}

	private JButton createButton(Color color) 
	{
		JButton newButton = new JButton("");
		newButton.setBorderPainted(false);
		newButton.setOpaque(true);
		newButton.setBackground(color);
		// Sätter texten för timern på knappen istället för efter
		newButton.setHorizontalTextPosition(SwingConstants.CENTER);
		
		newButton.setForeground(Color.WHITE);
		newButton.setFont(new Font("Arial", Font.PLAIN, 25));
		
		return newButton;
		
	}
	
	private JButton[][] buildButtonArray() {
		//För varje vågrät rad i int []startArray...
		for (int row = 0; row < getCurrentLevel().length; row++) {
			System.out.println();
			//...så itererar vi igenom varje kolumn
			for (int col = 0; col < getCurrentLevel()[row].length; col++) {
				//Om positionen i 2D-array är = 1 måla motsvarande ruta i squares med svart 
				
				if (getCurrentLevel()[row][col] == 1) {
					
					
					
					
				//Borkommenterad kod målar ut bilder istället för färger 
					try {	
						Image image = null;
					if(squares[row][col]==squares[0][2]) // Ritar ut tre liv på översta tegelraden
					{ 
						
						image = ImageIO.read(this.getClass().getResource("/gameSprites/Life.png"));
					
					}
					else image = ImageIO.read(this.getClass().getResource("/gameSprites/Wall.png"));
					
					getSquares()[row][col] = createButton(Color.BLACK);
					getSquares()[row][col].setIcon(new ImageIcon(image));
				} catch (IOException e) {
					e.printStackTrace();
				}
					
				}
				
				//Om positionen i 2D-array är = 0 måla motsvarande ruta med svart 
				if (getCurrentLevel()[row][col] == 0 || getCurrentLevel()[row][col] == 6) 
				{
					
				
					//Bortkommenterad kod målar ut bilder istället för färger
					try {							
						Image image = ImageIO.read(this.getClass().getResource("/gameSprites/Ground.png"));
						getSquares()[row][col] = createButton(Color.WHITE);
						getSquares()[row][col].setIcon(new ImageIcon(image));
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				if (getCurrentLevel()[row][col] == 5) {
					
					try {							
						Image image = ImageIO.read(this.getClass().getResource("/gameSprites/Treasure.png"));
						getSquares()[row][col] = createButton(Color.ORANGE);
						getSquares()[row][col].setIcon(new ImageIcon(image));
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				if (getCurrentLevel()[row][col] == 3) {
					
					try {							
						Image image = ImageIO.read(this.getClass().getResource("/gameSprites/Laser.png"));
						getSquares()[row][col] = createButton(Color.RED);
						getSquares()[row][col].setIcon(new ImageIcon(image));
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					
					
				}
				if(getCurrentLevel()[row][col] == 2) {
				
					try {							
						Image image = ImageIO.read(this.getClass().getResource("/gameSprites/DoorClosed.png"));
						getSquares()[row][col] = createButton(Color.RED);
						getSquares()[row][col].setIcon(new ImageIcon(image));
						door.setDoorsPosition(new Position(row,col));
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					
				}
				
				
				
				

			}
		}
		
		return getSquares();
	}
	
	public void showTimer(int timer) {
		
		this.squares[0][24].setText(Integer.toString(timer));
		
		
	}
	
	//färglägger en enskild ruta i grid
	
	
	private void colouriseSquare(Color colour, Position position) 
	{
	
		Image image = null;
		getSquares()[(int) position.getX()][(int) position.getY()].setBackground(colour);
		
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
				image = ImageIO.read(this.getClass().getResource("/gameSprites/DoorClosed.png"));
			if (colour == Color.PINK) // Dörr öppen
				image = ImageIO.read(this.getClass().getResource("/gameSprites/Door.png"));
			if (colour == Color.WHITE) // Golv
				image = ImageIO.read(this.getClass().getResource("/gameSprites/Ground.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		getSquares()[(int) position.getX()][(int) position.getY()].setIcon(new ImageIcon(image));
		
		
	}
	
	//Placerar spelaren på startposition	
	private void drawCharacterStartingPosition() {
		colouriseSquare(Color.CYAN, characterObject.getCurrentPosition());
		
	}
	
	
	
	// Bestämmer vad som händer när karaktären går på diverse objekt/siffra i arrayen
	public boolean positionEvent(Position nextTileDirection, String direction) 
	
	{
		boolean runCode = true;
		
		if (getColorOfTile(nextTileDirection)==Color.PINK) // öppen dörr
		{ 	
			levelCount++; 
			setCurrentLevel(Levels.getLevel(levelCount));
			
			this.characterObject.addLife(1); // Lägger till ett liv vid klarad bana
			repaintGameBoard(); 
			Main.setTimeInSeconds(30); // Sätter nästa banas timer
			

			Image image;
			try {
				image = ImageIO.read(this.getClass().getResource("/gameSprites/Life.png"));
				// Ritar ut hjärtan för antal liv. KAN SKRIVAS SNYGGARE!!
				if (this.characterObject.getLife()>=1) {getSquares()[0][0].setIcon(new ImageIcon(image));}
				if (this.characterObject.getLife()>=2) {getSquares()[0][1].setIcon(new ImageIcon(image));}
				if (this.characterObject.getLife()>=3) {getSquares()[0][2].setIcon(new ImageIcon(image));}
				if (this.characterObject.getLife()>=4) {getSquares()[0][3].setIcon(new ImageIcon(image));}
				if (this.characterObject.getLife()>=5) {getSquares()[0][4].setIcon(new ImageIcon(image));}
				if (this.characterObject.getLife()>=6) {getSquares()[0][5].setIcon(new ImageIcon(image));}
				if (this.characterObject.getLife()>=7) {getSquares()[0][6].setIcon(new ImageIcon(image));}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
						
						
					}
					
		
			
		if (getColorOfTile(nextTileDirection)==Color.ORANGE) // Skatt
			
		{
			
			characterObject.grabTreasure(); // Skatt +1
			System.out.println("Skatt upplockad, totalt " + characterObject.getTreasures() );
			decreaseTreasuresLeftOnLevel();
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
			this.characterObject.subractLife(1);
			
			
			Image image;
			try {
				image = ImageIO.read(this.getClass().getResource("/gameSprites/Wall.png"));
				getSquares()[0][this.characterObject.getLife()].setIcon(new ImageIcon(image));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (this.characterObject.getLife()==0) {repaintGameBoard(3);}
			System.out.println("Hit Laser -1 life, total life = " + this.characterObject.getLife());
			
			
			runCode = false;
		}
		
		if (getColorOfTile(nextTileDirection)==Color.GREEN) // Dörr
			
		{
			
			runCode = false;
			
		}

		
		return runCode; // Ska spelaren flytta sig?
		
	}
	
	public void decreaseTreasuresLeftOnLevel() {
		treasuresLeftOnCurrentLevel --; 				//Skatter kvar på banan -1
		System.out.println("Skatt upplockad, totalt " + treasuresLeftOnCurrentLevel +" kvar på banan" );
		
		//dörren byter tillstånd från låst till öppen om alla skatter är funna
		if(treasuresLeftOnCurrentLevel==0) {
			door.setdoorIsLocked(false);
			colouriseSquare(Color.pink, door.getDoorsPosition());
			}
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
		
		JButton button = getSquares()[(int) position.getX()][(int) position.getY()];
		Color color = button.getBackground();
		return color;
	}
	
	
	public GameCharacter getCharacter() {
		return characterObject;
	}
	
	public JButton[][] getGridContent() {
		return getSquares();
	}

	public int getGridValueOfPosition(Position pos) {
		int row = (int) pos.getX();
		int column = (int)pos.getY();
		int value = getCurrentLevel()[row][column];
		return value;
	} 
	public Door getDoor() {
		return door; 
	}
	
	
	public void setLevel(int i) {
		setCurrentLevel(Levels.getLevel(i)); 
		buildButtonArray(); 
	}

	public int getTreasuresLeftOnCurrentLevel() {
		return treasuresLeftOnCurrentLevel;
	}

	public void setTreasuresLeftOnCurrentLevel(int treasuresLeftOnCurrentLevel) {
		this.treasuresLeftOnCurrentLevel = treasuresLeftOnCurrentLevel;
	}
	
	public int getLevelCount() {
		return levelCount;
	}
	// Målar om GameBoarden vid banbyte
		// Målar om GameBoarden vid banbyte
	public void repaintGameBoard(int level) 
	{
		// ny array - bana 2
		int[][]  _nextLevel = Levels.getLevel(level);
		//  nuvarande bana får dessa värden
		setCurrentLevel(_nextLevel);
		
		
		for (int row = 0; row < getCurrentLevel().length; row++) {
			System.out.println();
			//...så itererar vi igenom varje kolumn
			for (int col = 0; col < getCurrentLevel()[row].length; col++) {

				// Färgar knapp beroende på värde (som sedan är kopplat till ikon)
				if (getCurrentLevel()[row][col] == 1) 
				{
					colouriseSquare(Color.BLACK, new Position(row, col));
				}
				
				if (getCurrentLevel()[row][col] == 0 || getCurrentLevel()[row][col] == 6) 
				{
					colouriseSquare(Color.WHITE, new Position(row, col));
				}
				
				if (getCurrentLevel()[row][col] == 5)
					
				{
					colouriseSquare(Color.ORANGE, new Position(row, col));
				}
				if (getCurrentLevel()[row][col] == 3) 
					
				{
					colouriseSquare(Color.RED, new Position(row, col));	
				}
				if(getCurrentLevel()[row][col] == 2) 
					
				{
					colouriseSquare(Color.GREEN, new Position(row, col));
				}
				
				

			}
		}
		
		// Ritar ut spelaren på startpositionen
		this.characterObject.setCurrentPosition(1,1);
		colouriseSquare(Color.CYAN, new Position(1, 1));
	}// Målar om GameBoarden vid banbyte
	
	
	public void repaintGameBoard() 
	{

		for (int row = 0; row < getCurrentLevel().length; row++) {
			System.out.println();
			//...så itererar vi igenom varje kolumn
			for (int col = 0; col < getCurrentLevel()[row].length; col++) {

				// Färgar knapp beroende på värde (som sedan är kopplat till ikon)
				if (getCurrentLevel()[row][col] == 1) 
				{
					colouriseSquare(Color.BLACK, new Position(row, col));
					
				}
				
				if (getCurrentLevel()[row][col] == 0 || getCurrentLevel()[row][col] == 6) 
				{
					
					
					colouriseSquare(Color.WHITE, new Position(row, col));
				}
				
				if (getCurrentLevel()[row][col] == 5)
					
				{
					colouriseSquare(Color.ORANGE, new Position(row, col));
				}
				if (getCurrentLevel()[row][col] == 3) 
					
				{
					colouriseSquare(Color.RED, new Position(row, col));	
				}
				if(getCurrentLevel()[row][col] == 2) 
					
				{
					colouriseSquare(Color.GREEN, new Position(row, col));
				}

			}
		}
		
		// Ritar ut spelaren på startpositionen
		this.characterObject.setCurrentPosition(1,1);
		colouriseSquare(Color.CYAN, new Position(1, 1));
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

	public JButton[][] getSquares() {
		return squares;
	}

	public void setSquares(JButton[][] squares) {
		this.squares = squares;
	}

	public int[][] getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int[][] currentLevel) {
		this.currentLevel = currentLevel;
	}

	

	 
}
