package museumHeist.GUI.Classes;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import museumHeist.sprites.GameCharacter;
import museum_heist.Levels;
import museum_heist.Position;


public class GameBoardInterface extends JFrame {
	
	 
	private GameCharacter characterObject = new GameCharacter(1,1);
    private JButton[][] squares = new JButton[25][25]; //
	private JPanel board;
	int levelCounter = 3;
	private int[][]  currentLevel  = Levels.getLevel(levelCounter);
	
	
	public GameBoardInterface() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(1200,1200);
		
		
		
		board = new JPanel(new GridLayout(25, 25));
	
	   //För varje vågrät rad i int []startArray...
	    for (int row = 0; row < currentLevel.length ; row++) {
	    	System.out.println();
	    		//...så itererar vi igenom varje kolumn
	    	for (int col = 0; col < currentLevel[row].length ; col++) {
	       		//Om positionen i 2D-array är = 1 måla motsvarande ruta i squares med svart 
	    		if(currentLevel[row][col] == 1) {
	    			JButton newButton = new JButton();
	    			newButton.setBorderPainted(false);
	    			newButton.setBackground(Color.BLACK);
	    			squares[row][col]=newButton; 
	    		}
	    		
	    		//Om positionen i 2D-array är = 0 måla motsvarande ruta med svart 
	    		if(currentLevel[row][col] == 0) {
	    			JButton newButton = new JButton();
	    			newButton.setBorderPainted(false);
	    			newButton.setBackground(Color.WHITE);
	    			squares[row][col]=newButton; 
	    		}
	    		if (currentLevel[row][col] == 5) {
	    			JButton newButton = new JButton();
	    			newButton.setBorderPainted(false);
	    			newButton.setBackground(Color.ORANGE);
	    			squares[row][col]=newButton; 
				}
	    		
	    }
	    }
	
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

			if(keyCode==KeyEvent.VK_W) {
				updateCharacterPosition("North");	
			}
			if(keyCode==KeyEvent.VK_S) {
				updateCharacterPosition("South");
			
			}
			if(keyCode==KeyEvent.VK_A) {
			updateCharacterPosition("West");
			
			}
			if(keyCode==KeyEvent.VK_D) {
				updateCharacterPosition("East");
			}
		}
	});
  }
	  //färglägger en enskild ruta i grid
	private void colouriseSquare(Color colour, Position position) {
		squares[(int) position.getX()][(int) position.getY()].setBackground(colour);
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
				colouriseSquare(Color.WHITE, characterObject.getCurrentPosition());
				characterObject.moveOneTileRight();
				colouriseSquare(Color.CYAN, characterObject.getCurrentPosition());
				break;
			}
			
			case "West": {
				colouriseSquare(Color.WHITE, characterObject.getCurrentPosition());
				characterObject.moveOneTileLeft();
				colouriseSquare(Color.CYAN, characterObject.getCurrentPosition());
				break;
			}
			case "South": {
				colouriseSquare(Color.WHITE, characterObject.getCurrentPosition());
				characterObject.moveOneTileDown();
				colouriseSquare(Color.CYAN, characterObject.getCurrentPosition());
				break;
			}
			case "North": {
				colouriseSquare(Color.WHITE, characterObject.getCurrentPosition());
				characterObject.moveOneTileUp();
				colouriseSquare(Color.CYAN, characterObject.getCurrentPosition());
			}
		}
	}
	//returnerar färgen på en specifik ruta i rutnätet som utgör spelplanen
	public Color getColorOfTile(Position position) {
		
		JButton button = squares[(int) position.getX()][(int) position.getY()];
		Color color = button.getBackground();  
		return color; 
	}
	//Getters 
	public GameCharacter getCharacter() {
		return characterObject;
		}
	public JButton[][] getGridContent() {
		return squares; 
		}
	
	
}

