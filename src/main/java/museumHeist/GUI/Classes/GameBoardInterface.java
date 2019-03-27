package museumHeist.GUI.Classes;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import museumHeist.sprites.Door;
import museumHeist.sprites.GameCharacter;
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
	
	public GameBoardInterface() {
		squares = new JButton[25][25];
		currentLevel  = Levels.getLevel(1);
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
		//Keylistener till knapparna som ska styra figuren
//		this.addKeyListener(new KeyListener() {
//			
//			public void keyTyped(KeyEvent e) {
//				//Denna metod måste implementeras men används inte
//			}
//			
//			public void keyReleased(KeyEvent e) {
//				//Denna metod måste implementeras men används inte
//			}
//			
//			public void keyPressed(KeyEvent e) {
//				int keyCode = e.getKeyCode();
//				
//				if (keyCode == KeyEvent.VK_W) {
//					updateCharacterPosition("North");
//					
//				}
//			
//				if (keyCode == KeyEvent.VK_S) {
//					updateCharacterPosition("South");
//					
//				}
//				if (keyCode == KeyEvent.VK_A) {
//					updateCharacterPosition("West");
//					
//				}
//				if (keyCode == KeyEvent.VK_D) {
//					updateCharacterPosition("East");
//				}
//			}
//		});
//	
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
	
	//Målar upp ny bana med knappar i rutnät
	private void buildButtonArray() {
		//För varje vågrät rad i int []startArray...
		for (int row = 0; row < currentLevel.length; row++) {
			System.out.println();
			//...så itererar vi igenom varje kolumn
			for (int col = 0; col < currentLevel[row].length; col++) {
				//Om positionen i 2D-array är = 1 måla motsvarande ruta i squares med svart 
				
				if (currentLevel[row][col] == 1) {
					
					
					
					
				//Borkommenterad kod målar ut bilder istället för färger 
//					try {							
//					Image image = ImageIO.read(this.getClass().getResource("/gameSprites/wallStone02_0000.png"));
//					newButton.setIcon(new ImageIcon(image));
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
					squares[row][col] = createButton(Color.BLACK);
				}
				
				//Om positionen i 2D-array är = 0 måla motsvarande ruta med svart 
				if (currentLevel[row][col] == 0) {
					
				
					//Bortkommenterad kod målar ut bilder istället för färger
//					try {							
//						Image image = ImageIO.read(this.getClass().getResource("/gameSprites/wallEarth01_0002.png"));
//						newButton.setIcon(new ImageIcon(image));
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
					squares[row][col] = createButton(Color.WHITE);
				}
				if (currentLevel[row][col] == 5) {
					
					squares[row][col] = createButton(Color.ORANGE);
				}
				if (currentLevel[row][col] == 3) {
					
					squares[row][col] = createButton(Color.RED);
					
				}
				if(currentLevel[row][col] == 2) {
					squares[row][col] = createButton(Color.GREEN);
					door.setDoorsPosition(new Position(row,col));
				}
			}
		}
	}
	
	//färglägger en enskild ruta i grid
	public void colouriseSquare(Color colour, Position position) {
	
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
	
	
	
	// Bestämmer vad som händer när karaktären går på diverse objekt/siffra i arrayen
	public boolean positionEvent(Position nextTileDirection, String direction) 
	
	{
		boolean runCode = true;
		
		if (getColorOfTile(nextTileDirection)==Color.pink) // öppen dörr
		{ 	
			levelCount++; 
			currentLevel  = Levels.getLevel(levelCount);
			repaintGameBoard();
			
			
			
			}
		
		
		if (getColorOfTile(nextTileDirection)==Color.ORANGE) // Skatt
			
		{
			
			characterObject.grabTreasure(); // Skatt +1 till karaktären
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
			
		}
		
		if (getColorOfTile(nextTileDirection)==Color.GREEN) // Dörr
			
		{
			
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

	public int getGridValueOfPosition(Position pos) {
		int row = (int) pos.getX();
		int column = (int)pos.getY();
		int value = currentLevel[row][column];
		return value;
	} 
	public Door getDoor() {
		return door; 
	}
	
	
	public void setLevel(int i) {
		currentLevel = Levels.getLevel(i); 
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
		public void repaintGameBoard() 
		{
//			// ny array - bana 2
//			int[][]  _nextLevel = Levels.getLevel(level);
//			//  nuvarande bana får dessa värden
//			currentLevel = _nextLevel;
			
			
			for (int row = 0; row < currentLevel.length; row++) {
				System.out.println();
				//...så itererar vi igenom varje kolumn
				for (int col = 0; col < currentLevel[row].length; col++) {

					// Färgar knapp beroende på värde (som sedan är kopplat till ikon)
					if (currentLevel[row][col] == 1) 
					{
						colouriseSquare(Color.BLACK, new Position(row, col));
					}
					
					if (currentLevel[row][col] == 0 || currentLevel[row][col] == 6) 
					{
						colouriseSquare(Color.WHITE, new Position(row, col));
					}
					
					if (currentLevel[row][col] == 5)
						
					{
						colouriseSquare(Color.ORANGE, new Position(row, col));
					}
					if (currentLevel[row][col] == 3) 
						
					{
						colouriseSquare(Color.RED, new Position(row, col));	
					}
					if(currentLevel[row][col] == 2) 
						
					{
						colouriseSquare(Color.GREEN, new Position(row, col));
					}

				}
			}
			
			// Ritar ut spelaren på startpositionen
			this.characterObject.setCurrentPosition(1,1);
			colouriseSquare(Color.CYAN, new Position(1, 1));
		}
}
