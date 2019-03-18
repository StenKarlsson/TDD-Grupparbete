package museumHeist.GUI.Classes;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameBoardInterface extends JFrame implements KeyListener {
	
	 
	
    private JButton[][] squares = new JButton[15][15];
	private JPanel board;
	int[][]  startArray  = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			 				{1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				{1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				{1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				{1, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 1},
			 				{1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				{1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			 				{1, 0, 0, 3, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 1},
			 				{1, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 1},
			 				{1, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 1},
			 				{1, 0, 0, 0, 0, 0, 0, 3, 0, 0, 3, 0, 0, 0, 1},
			 				{1, 0, 0, 0, 0, 0, 0, 3, 0, 0, 3, 0, 0, 0, 1},
			 				{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
			 				{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
			 				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
			 									};
	
	
	public GameBoardInterface() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(1200,1200);
		addKeyListener(this);
		board = new JPanel(new GridLayout(15, 15));
	
	   //För varje vågrät rad...
	    for (int row = 0; row < startArray.length ; row++) {
	    	System.out.println();
	    		//...så itererar vi igenom varje kolumn
	    	for (int col = 0; col < startArray[row].length ; col++) {
	       		//Om positionen i 2D-array är = 1 måla motsvarande ruta med svart 
	    		if(startArray[row][col] == 1) {
	    			System.out.println(startArray[row][col]);
	    			JButton newButton = new JButton();
	    			newButton.setBorderPainted(false);
	    			newButton.setBackground(Color.BLACK);
	    			squares[row][col]=newButton; 
	    		}
	    		
	    		//Om positionen i 2D-array är = 0 måla motsvarande ruta med svart 
	    		if(startArray[row][col] == 0) {
	    			JButton newButton = new JButton();
	    			newButton.setBorderPainted(false);
	    			newButton.setBackground(Color.WHITE);
	    			squares[row][col]=newButton; 
	    		}
	    		
	    		//Om positionen i 2D-array är = 2 måla motsvarande ruta med gul 
	    		if(startArray[row][col] == 2) {
	    			JButton newButton = new JButton();
	    			newButton.setBorderPainted(false);
	    			newButton.setBackground(Color.YELLOW);
	    			squares[row][col]=newButton; 
	    		}
	    		//Om positionen i 2D-array är = 3 måla motsvarande ruta med röd 
	    		if(startArray[row][col] == 3) {
	    			JButton newButton = new JButton();
	    			newButton.setBorderPainted(false);
	    			newButton.setBackground(Color.RED);
	    			squares[row][col]=newButton; 
	    		}
	    		
	    		
	    	}
	    }
	
	    //Addera rutnätet till panelen board ruta för ruta 
	    for (int boardRows = 0; boardRows < 15; boardRows++) {
            for (int boardColumns = 0; boardColumns < 15; boardColumns++) {
             board.add(squares[boardColumns][boardRows]);
                }
            }
    this.add(board);
    }
	  
	public void keyTyped(KeyEvent e) {
		// Ingen användning 
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
	
		if(keyCode==KeyEvent.VK_W) {
			//do something
		System.out.println("W pressed"); 	
		}
		if(keyCode==KeyEvent.VK_S) {
			//do something
		System.out.println("S pressed");
		}
		if(keyCode==KeyEvent.VK_A) {
			//do something
		System.out.println("A pressed");
		}
		if(keyCode==KeyEvent.VK_D) {
			//do something
		System.out.println("D pressed");
		}
	}

	public void keyReleased(KeyEvent e) {
		//Ingen användning
		
	}
}
