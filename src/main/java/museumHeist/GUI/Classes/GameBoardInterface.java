package museumHeist.GUI.Classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.lang.model.element.Element;
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
import soundTest.SoundPlayer;


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
	private SoundPlayer player; 
	public boolean LevelCompleted = false;
	Position startposition = new Position (1,1);
	Position currentMonsterStartPosition;
	

	static boolean laserOn = true;
	private static boolean laserActive = true;
	
	// Länkar till sprites-bilderna
	
	String picPlayer = "/gameSprites/Player.png";
	String picLaser = "/gameSprites/Laser.png";
	String picGround = "/gameSprites/Ground.png";
	String picWall = "/gameSprites/Wall.png";
	String picWallGrey = "/gameSprites/Wall_grey.png";
	String picLifeGrey = "/gameSprites/Life_grey.png";		
	String picLife = "/gameSprites/Life.png";
	String picDoor = "/gameSprites/Door.png";
	String picDoorClosed = "/gameSprites/DoorClosed.png";
	String picTreasure = "/gameSprites/Treasure.png";
	String picQuestionMark = "/gameSprites/QuestionMark.png";
	String picPortal = "/gameSprites/portal.png";
	String picMonster = "/gameSprites/Monster.png";
	private boolean setRandForTesting;
	
	
	
	
	public GameBoardInterface() {
		player = new SoundPlayer(); 
		setSquares(new JButton[25][25]);
		setCurrentLevel(Levels.getLevel(1));
		levelCount=1; 
		this.setSize(1000, 1000);
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

        // Keybindings för att styra spelaren
        
        
		addKeyBinding(board, KeyEvent.VK_W, "Up", (evt) -> {
			updateCharacterPosition("Up");
		});
		
		addKeyBinding(board, KeyEvent.VK_S, "Down", (evt) -> {
			updateCharacterPosition("Down");
		});
		
		addKeyBinding(board, KeyEvent.VK_D, "Right", (evt) -> {
			updateCharacterPosition("Right");
		});
		
		addKeyBinding(board, KeyEvent.VK_A, "Left", (evt) -> {
			updateCharacterPosition("Left");
		});
			player.loopLevelSound();
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

 	//Målar ut de färglagda knapparna på panelen, ruta för ruta. 
	private void paintButtonArray() {
		for (int boardRows = 0; boardRows < 25; boardRows++) {
			for (int boardColumns = 0; boardColumns < 25; boardColumns++) {
				board.add(getSquares()[boardRows][boardColumns]);
			}
		}
	}

	
	
	// Ittererar igenom knappArrayen och lägger till färg och bildikon
	
	private JButton[][] buildButtonArray() 
	{
		for (int row = 0; row < getCurrentLevel().length; row++) 
		{
			for (int col = 0; col < getCurrentLevel()[row].length; col++) 
			{
				
				if (getCurrentLevel()[row][col] == 0 || getCurrentLevel()[row][col] == 6) 
				{
					setupButton(row, col, picGround, Color.WHITE);
				}
				
				if (getCurrentLevel()[row][col] == 1) 
				{
					
					if (isEven(levelCount)) 
					{
					if(squares[row][col]==squares[0][2]) {setupButton(row, col, picLifeGrey, Color.BLACK);}
					else setupButton(row, col, picWallGrey, Color.BLACK);
					}
					
					else 
					{
						if(squares[row][col]==squares[0][2]) {setupButton(row, col, picLife, Color.BLACK);}
						else setupButton(row, col, picWall, Color.BLACK);
					}
					
				}
			
				if(getCurrentLevel()[row][col] == 2) 
					
				{ 
					setupButton(row, col, picDoorClosed, Color.GREEN); door.setDoorsPosition(new Position(row,col));
				}	
				
				if (getCurrentLevel()[row][col] == 3) 
				{
					setupButton(row, col, picLaser, Color.RED);
				}
	
				if (getCurrentLevel()[row][col] == 5) 
				
				{
					setupButton(row, col, picTreasure, Color.ORANGE);
				}
					
				if(getCurrentLevel()[row][col] == 7) 
					
				{ 
					setupButton(row, col, picMonster, Color.LIGHT_GRAY); 
					currentMonsterStartPosition= new Position(row, col);
				}	
				
				if(getCurrentLevel()[row][col] == 8) 
					
				{ 
					setupButton(row, col, picQuestionMark, Color.MAGENTA); 
				}	
				
				if(getCurrentLevel()[row][col] == 9) 
					
				{ 
					setupButton(row, col, picPortal, Color.YELLOW); 
				}	
			}
			
		}
		
		return getSquares();
	}
	
	// Sätter ikon på knappar
	public void setupButton(int row,int col, String pictureLink, Color color) 
	{
		try {							
			Image image = ImageIO.read(this.getClass().getResource(pictureLink));
			getSquares()[row][col] = createButton(color);
			getSquares()[row][col].setIcon(new ImageIcon(image));
			
		} catch (IOException e) 
			{
			e.printStackTrace();
			}

	}
	
	// Metod som skapar knapp samt sätter egenskaper
		private JButton createButton(Color color) 
		{
			JButton newButton = new JButton("");
			newButton.setBorderPainted(false);
			newButton.setOpaque(true);
			newButton.setBackground(color);
			
			// Textmetoderna är för att sätta text synlig ovanpå knappen
			newButton.setHorizontalTextPosition(SwingConstants.CENTER);
			newButton.setForeground(Color.WHITE);
			newButton.setFont(new Font("Arial", Font.PLAIN, 15));
			
			return newButton;
			
		}
	
	
	
	//färglägger en enskild ruta i grid
	
	
	public void colouriseSquare(Color colour, Position position) 
	{
	
		Image image = null;
		getSquares()[(int) position.getX()][(int) position.getY()].setBackground(colour);
		
		try {
			if (colour == Color.CYAN) // Spelare
				image = ImageIO.read(this.getClass().getResource(picPlayer));
			if (colour == Color.BLACK) // Vägg - Variation av bild
				{
				if (isEven(levelCount)) { image = ImageIO.read(this.getClass().getResource(picWallGrey));}
				else image = ImageIO.read(this.getClass().getResource(picWall));
				}
			if (colour == Color.ORANGE) // Skatt
				image = ImageIO.read(this.getClass().getResource(picTreasure));
			if (colour == Color.RED) // Laser 
				image = ImageIO.read(this.getClass().getResource(picLaser));
			if (colour == Color.GREEN) // Dörr
				image = ImageIO.read(this.getClass().getResource(picDoorClosed));
			if (colour == Color.PINK) // Dörr öppen
				image = ImageIO.read(this.getClass().getResource(picDoor));
			if (colour == Color.WHITE) // Golv
				image = ImageIO.read(this.getClass().getResource(picGround));
			if (colour == Color.MAGENTA) // Frågetecken
				image = ImageIO.read(this.getClass().getResource(picQuestionMark));
			if (colour == Color.YELLOW) // portal
				image = ImageIO.read(this.getClass().getResource(picPortal));
			if (colour == Color.LIGHT_GRAY) // Monster
				image = ImageIO.read(this.getClass().getResource(picMonster));
			
		} catch (IOException e) {
			
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
			player.playDoorEntrySound();
			levelCount++; 
			setCurrentLevel(Levels.getLevel(levelCount));
			this.characterObject.addLife(1); // Lägger till ett liv vid klarad bana
			repaintGameBoard(); 

			Main.setTimeInSeconds(150); // Sätter nästa banas timer

			treasuresLeftOnCurrentLevel = 10; 
			printLife();
	
		}
						
		if (getColorOfTile(nextTileDirection)==Color.ORANGE) // Skatt
			
		{

			player.playTreasureSound();
			characterObject.grabTreasure(); // Skatt +1
			showTotalTreasure(); // Skriver ut totalt antal skatter i högra hörnet
			decreaseTreasuresLeftOnLevel();
			//skapa nytt ljudklipp 
			
		}
		
		if (getColorOfTile(nextTileDirection)==Color.MAGENTA) // Frågetecken
			
		{

				    int rand = 1;
				    rand = randomNumberGenerator(8.0);
				    
				    //setRandForTesting(6);
				    
				    switch(rand) 
				    {
				      case 0: // Tar ett liv
				    	  	characterLoseLife(1);
				        break;
				      case 1: // Plockar upp 5 skatter
				    	  	characterPickUpTreasure(5);
				        break;
				      case 2: // Stänger av lasern
				    	 turnOffLaser();
				        break;
				      case 3: // Lägger till 3 liv
				    	  this.
				    	  printLife();
				    	break;
				      case 4: // Lägger till 30 sek
				    	  Main.setTimeInSeconds(Main.getTimeInSeconds()+30);
				        break;
				      case 5: // Tar bort 30 sek
				    	  Main.setTimeInSeconds(Main.getTimeInSeconds()-30);
				    	  break;
				      case 6: // Sänker Laserns hastighet
				    	  Main.setLaserSpeed(3000);
				        break;
				      case 7: // Ökar Laserns hastighet
				    	  Main.setLaserSpeed(500);
				        break;
				  
				}
			
			showTotalTreasure(); // Skriver ut totalt antal skatter i högra hörnet
			
		}
		
		if (getColorOfTile(nextTileDirection)==Color.BLACK) // Vägg
			
		{
			System.out.println("Wall to the " + direction);
			runCode = false; // Flytta inte spelaren
		}
		
		
		
		if (getColorOfTile(nextTileDirection)==Color.RED) // Laser
			
		{
			// Flyttar till spelaren till startposition 
			characterIsKilled();
			player.playRespawnSound();
			Main.setLaserSpeed(1500);
			
			
			runCode = false;
		}
		
		if (getColorOfTile(nextTileDirection)==Color.LIGHT_GRAY) // Monster
			
		{
			// Flyttar till spelaren till startposition 
			Position impact = characterObject.getCurrentPosition();
			characterIsKilled();
			
			// Här ska monstret flyttas till startpositionen
			colouriseSquare(Color.WHITE, nextTileDirection);
			colouriseSquare(Color.LIGHT_GRAY, currentMonsterStartPosition);
			
			
			runCode = false;
		}
		
		if (getColorOfTile(nextTileDirection)==Color.GREEN) // Dörr
			
		{
			
			runCode = false;
			
		}
		
		if (getColorOfTile(nextTileDirection)==Color.YELLOW) // Warp-Zone
			
		{
			// Färgar positionen WHITE
			colouriseSquare(Color.WHITE, characterObject.getCurrentPosition());	
						
			boolean CharacterMoved = false;
			// Förflyttning
			
			
			while(!CharacterMoved) 
			{

				int row = randomNumberGenerator(25.0);
				int col = randomNumberGenerator(25.0);
				
				for ( int q = 0; q < squares.length; q++ )
				  {
				      for ( int x = 0; x < squares[0].length; x++ )
				      {
				      	
				    	  if (getGridValueOfPosition(new Position(row, col))==0)
				    	  {
				    		  this.characterObject.setCurrentPosition(row, col); 
				    		  CharacterMoved = true;
				    	  
				    	  }
				    	  
				      }   
				 }
				
			}
			
			// Färgar positionen CYAN
			colouriseSquare(Color.CYAN, characterObject.getCurrentPosition());
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
			colouriseSquare(Color.PINK, door.getDoorsPosition());
			}
	}
	

	//Ändrar spelarens/karaktärens position samt byter färg på rutan den flyttar till
	public void updateCharacterPosition(String direction) {
		String recievedString = direction;
		boolean _runCode = true;
		switch (recievedString) 
		{
			case "Right": 
			{
				//Undersöker positionen åt höger
				Position nextTileRight = (new Position((int)characterObject.getCurrentPosition().getX(),
						(int)characterObject.getCurrentPosition().getY()+1));
				
				
				_runCode= positionEvent(nextTileRight, recievedString);
				break;
	
			}
			
			case "Left": {
				
				//Undersöker positionen åt vänster
				Position nextTileLeft = (new Position((int)characterObject.getCurrentPosition().getX(),
				(int)characterObject.getCurrentPosition().getY()-1)); 
				
				_runCode =positionEvent(nextTileLeft, recievedString);
				break;
				
			}
			case "Down": {
				
				//Undersöker positionen neråt
				Position nextTileDown = (new Position((int)characterObject.getCurrentPosition().getX()+1,
				(int)characterObject.getCurrentPosition().getY())); 
				
				_runCode= positionEvent(nextTileDown, recievedString);
				break;
				
						
				
			}
			case "Up": {
				//Undersöker positionen uppåt
				Position nextTileUp = (new Position((int)characterObject.getCurrentPosition().getX()-1,
				(int)characterObject.getCurrentPosition().getY())); 
				
				_runCode = positionEvent(nextTileUp, recievedString);
				break;
						
				
				} 
		}
		
		if(_runCode) 
		{
			Main.setPlayerIsMoving(true);
			// Färgar positionen WHITE
			colouriseSquare(Color.WHITE, characterObject.getCurrentPosition());	
			
			// Spelaren förflyttar sig
			if (direction.equals("Right")){characterObject.moveOneTileRight();}
			if (direction.equals("Left")){characterObject.moveOneTileLeft();}
			if (direction.equals("Down")){characterObject.moveOneTileDown();}
			if (direction.equals("Up")){characterObject.moveOneTileUp();}
			
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
	
	
	// Målar om GameBoarden vid banbyte , överlagrad metod som bara används vid game over för bana 999
		
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
				
				// Ser till att ta bort spelare och monster
				if (getColorOfTile(new Position(row, col)).equals(Color.LIGHT_GRAY)) 
				{
					colouriseSquare(Color.WHITE, new Position(row, col));
				}
				
				if (getColorOfTile(new Position(row, col)).equals(Color.CYAN))  
				{
					colouriseSquare(Color.WHITE, new Position(row, col));
				}
					
				
			}
		}
		
			
	}
	
	// Målar om GameBoarden vid banbyte, Ittererar igenom rad och kolumn
	// Färgar knappen beroende på värdet i den nya banans it Array.
	// Sist målas spelaren ut på startpositionen
	public void repaintGameBoard() 
	{

		laserActive=true;
		Main.setPlayerIsMoving(false);
		for (int row = 0; row < getCurrentLevel().length; row++) {
			System.out.println();
			for (int col = 0; col < getCurrentLevel()[row].length; col++) 
			{
				
				if (getCurrentLevel()[row][col] == 0 || getCurrentLevel()[row][col] == 6) 
				{	
					colouriseSquare(Color.WHITE, new Position(row, col));
				}
				if (getCurrentLevel()[row][col] == 1) 
				{
					colouriseSquare(Color.BLACK, new Position(row, col));	
				}
				if(getCurrentLevel()[row][col] == 2) 	
				{
					colouriseSquare(Color.GREEN, new Position(row, col));
				}
				if (getCurrentLevel()[row][col] == 3) 	
				{
					colouriseSquare(Color.RED, new Position(row, col));	
				}
				if (getCurrentLevel()[row][col] == 5)	
				{
					colouriseSquare(Color.ORANGE, new Position(row, col));
				}
				if(getCurrentLevel()[row][col] == 7) 
				{
					colouriseSquare(Color.LIGHT_GRAY, new Position(row, col));	
				}
				if (getCurrentLevel()[row][col] == 8)	
				{
					colouriseSquare(Color.MAGENTA, new Position(row, col));
				}
				if(getCurrentLevel()[row][col] == 9) 	
					
				{
					currentMonsterStartPosition = new Position(row, col);
					colouriseSquare(Color.YELLOW, new Position(row, col));
					
				}
				

			}
		}
		
		this.characterObject.setCurrentPosition(1,1);
		colouriseSquare(Color.CYAN, new Position(1, 1));
	}

	// Växlar mellan att visa lasern med intArrayvärde 3 och 6 (Ritas i Levels)
	
	public void flipLaserOnGameBoard(JButton[][] squares) 
	{
		for ( int q = 0; q < squares.length; q++ )
        {
            for ( int x = 0; x < squares[0].length; x++ )
            {
            	Position position = new Position(q, x);
                Color color = getColorOfTile(position);
                int value = getGridValueOfPosition(position);
                if(laserActive) {
                if (value==3 || value ==6) 
                {
                	
                	if (color == color.RED) {colouriseSquare(color.WHITE,position);}
                	else if(getColorOfTile(position).equals(color.LIGHT_GRAY)) {colouriseSquare(color.LIGHT_GRAY,position);}
            		
                	else 
                	{
                		colouriseSquare(color.RED,position);
                		if(this.characterObject.getCurrentPosition().equals(position)) 
                		{
                			
                			// Om lasern rör sig på spelaren så tappar den ett liv och flyttas till start
                			
                			
                			characterObject.setCurrentPosition(1, 1);
                			colouriseSquare(Color.CYAN, characterObject.getCurrentPosition());
                			characterLoseLife(1);
                			Main.setLaserSpeed(1500);
                		}
                		
                		
                	
                	}
                	
                }
                }
 
            }
            
       }
	
	}
	
	private void characterIsKilled() 
	{
		colouriseSquare(Color.WHITE, characterObject.getCurrentPosition());
		
		if(this.characterObject.getLife()>0) 
		{
			characterObject.setCurrentPosition(1, 1);
		}
		colouriseSquare(Color.CYAN, characterObject.getCurrentPosition());
		characterLoseLife(1);
	}

	// Skriver ut tiden på timern på sista rutan översta raden
	public void showTimer(int timer) {
		
		this.squares[0][24].setText(Integer.toString(timer));
		
	}
	

	
	private void printLife() 
	{
		Image image;
		try 
		{
			if (isEven(levelCount)) { image = ImageIO.read(this.getClass().getResource(picLifeGrey));}
			else image = ImageIO.read(this.getClass().getResource(picLife));

			for ( int i = 0; this.characterObject.getLife()>i; i++ )
	        {
	        	getSquares()[0][i].setIcon(new ImageIcon(image));
	
	        }
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	// Skriver ut tiden på timern på sista rutan översta raden
	public void showTotalTreasure() {
		
		this.squares[0][23].setText(Integer.toString(this.characterObject.getTreasures()));
	}


		public boolean monsterCanMoveTowardsCharacter(JButton[][] squares2) 
	{
		// Går igenom alla index i arrayen
		for ( int x = 0; x < squares.length; x++ )
        {
            for ( int y = 0; y < squares[0].length; y++ )
            {
            	

            	int new_x = 0;
            	int new_y = 0;
                
                int char_x = (int)characterObject.getCurrentPosition().getX();
                int char_y = (int)characterObject.getCurrentPosition().getY();
                
                // Om färgen på rutan är LIGHT_GREY som representerar monstret så ändras positionen
                
                if (getColorOfTile(new Position(x, y)).equals(Color.LIGHT_GRAY)) 
                {
                	// Säger att monstret ska öka x-värde om spelaren har högre x-värde och tvärt om
                	if (x>char_x) 
                	{
                		new_x= x-1;
                	}
                	else if (x==char_x) {new_x=x;}
                	else new_x= x+1;
                	
                	
                	// Säger att monstret ska sänka y-värde om spelaren har högre y-värde och tvärt om
                	if (y>char_y) 
                	{
                		new_y= y-1;
                	}
                	else if (y==char_y) {new_y= y;}
                	else new_y= y+1;
                	
                	
                	
                	Position PossibleMonsterDirection = new Position(new_x, new_y);
                	int _value = getGridValueOfPosition(PossibleMonsterDirection);
                	
                	// Om den nya positionen är vit och har värdet 0 så kan monstret flytta sig
                	
                	if (getColorOfTile(new Position(new_x, new_y)).equals(Color.WHITE)|| _value == 0 || getColorOfTile(new Position(new_x, new_y)).equals(Color.CYAN)) 
                	{
                		// Om positionen är spelkaraktären så ska ett liv tas och karaktär och monster starta från ursprungliga positioner
                		
	                	if(getColorOfTile(new Position(new_x, new_y)).equals(Color.CYAN)) {
	                		characterIsKilled();
	            			
	            			// Här ska monstrets nuvarande position sättas till vit och flytta denna till 21,21
	            			if(this.characterObject.getLife()>0) 
	            			{
	            			colouriseSquare(Color.WHITE, new Position(x,  y));
	            			colouriseSquare(Color.LIGHT_GRAY, currentMonsterStartPosition);
	            			}
	                	}	
	                	
	                	else {colouriseSquare(Color.LIGHT_GRAY, new Position(new_x,  new_y));
	                	colouriseSquare(Color.WHITE, new Position(x, y));}
	                	return true;
                	
                	}
                	
                }
 
            }
            
       } return false; // Monstret kan inte gå mot spelkaraktären
		
	}
	
	
	// Metod som flyttar monstret till närmaste golv på spelplanen om det inte går att gå mot karaktären
	
	public boolean forceMonsterToMove() 
	{
		for ( int y = 0; y < squares.length; y++ )
        {
            for ( int x = 0; x < squares[0].length; x++ )
            {
            	Position position = new Position(x, y);
                Color color = getColorOfTile(position);
                
                
            	if (color.equals(Color.LIGHT_GRAY)) 
            	{ 
            		
            		if (getColorOfTile(new Position(x, y+1)).equals(Color.WHITE)) 
					{
            			return forcedMovement(x, y, 0, 1, position );
					}
            		
            		else if (getColorOfTile(new Position(x, y-1)).equals(Color.WHITE)) 
					{
            			return forcedMovement(x, y, 0, -1, position );
	
					}
            		
            		else if (getColorOfTile(new Position(x+1, y)).equals(Color.WHITE)) 
					{
            			return forcedMovement(x, y, +1, 0, position ); 	
					}
            		
            		else if (getColorOfTile(new Position(x-1, y)).equals(Color.WHITE)) 
					{
            			return forcedMovement(x, y, -1, 0, position );	
					}
            				 
            	}
            }
            
        }
		return false; // Om monstret inte har någon väg att gå
		
	}
	
	
	
	// Metod som flyttar monstret ett steg åt någon riktning
	
	public boolean forcedMovement(int monster_x, int monster_y, int x_change, int y_change, Position position) 
	{
		int movement_x = (int) position.getX()+x_change;
		int movement_y = (int)position.getY()+y_change;
		colouriseSquare(Color.WHITE, new Position(monster_x, monster_y));
		colouriseSquare(Color.LIGHT_GRAY, new Position(movement_x,  movement_y));
		return true; 
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

	boolean isEven(double num) { return ((num % 2) == 0); }

	public int randomNumberGenerator(double d) {
		return (int)(d*Math.random());
	}

	public void characterLoseLife(int amount) {
		characterObject.subractLife(amount);
		
		Image image;
		try {
			if (isEven(levelCount)) { image = ImageIO.read(this.getClass().getResource(picWallGrey));}
			else image = ImageIO.read(this.getClass().getResource(picWall));
			
			getSquares()[0][this.characterObject.getLife()].setIcon(new ImageIcon(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (this.characterObject.getLife()==0) {repaintGameBoard(999); }
		
		
	}

	public int characterGetLives() {
		return characterObject.getLife();
	}

	public void characterPickUpTreasure(int amount) {
		characterObject.grabTreasure(5);
		treasuresLeftOnCurrentLevel -= amount;				//Skatter kvar på banan - amount
		System.out.println("Skatt upplockad, totalt " + treasuresLeftOnCurrentLevel +" kvar på banan" );
		
		//dörren byter tillstånd från låst till öppen om alla skatter är funna
		if(treasuresLeftOnCurrentLevel<=0) {
			door.setdoorIsLocked(false);
			colouriseSquare(Color.PINK, door.getDoorsPosition());
			}		
	}

	public int characterGetTreasures() throws Exception {
		
		if (treasuresLeftOnCurrentLevel == characterObject.getTreasures()) {
			return treasuresLeftOnCurrentLevel;
		}
		else{
			throw new Exception("Something is wrong with the treasure counter, please contact the support");
		}
	}

	public void turnOffLaser() {
		 laserActive=false;
   	  for ( int q = 0; q < squares.length; q++ )
         {
             for ( int x = 0; x < squares[0].length; x++ )
             {
             	Position position = new Position(q, x);
                 Color color = getColorOfTile(position);
                 int value = getGridValueOfPosition(position);
                 if (value==3 || value ==6) 
                 {
                 	colouriseSquare(color.WHITE,position);	
                 }
             }   
        }
	}

	public boolean getLaserStatus() {
		return laserActive;
	}

	public void characterAddLives(int amount) {
		characterObject.addLife(amount);
		printLife();
	}

	 
}
