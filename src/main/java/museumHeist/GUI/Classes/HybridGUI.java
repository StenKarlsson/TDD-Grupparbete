package museumHeist.GUI.Classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class HybridGUI extends JFrame implements KeyListener {
	
    private JButton[][] squares = new JButton[5][5];
	private JPanel board;
	int[][]  int2DArray  = {{1,   1,  1,  1,  1},
			 				{1,   0,  0,  0,  1},
			 				{1,   0,  0,  0,  1},
			 				{1,   0,  0,  0,  1},
			 				{1,   1,  1,  1,  1},
			 										};
	
	
	public HybridGUI() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(1200,1200);
		addKeyListener(this);
		printArrayToConsole();
		
		GridLayout grid = new GridLayout(5,5);
		
		board = new JPanel(new GridLayout(5, 5)); //gridlayout ändra gränserna
	
	    
	    //För varje vågrät rad...
	    for (int row = 0; row < int2DArray.length ; row++) {
	    	System.out.println();
	    		//...så itererar vi igenom varje kolumn
	    	for (int col = 0; col < int2DArray[row].length ; col++) {
	      	
	    		if(int2DArray[row][col] == 1) {
	    			JButton newButton = new JButton();
	    			newButton.setBorderPainted(false);
	    			newButton.setBackground(Color.BLACK);
	    			squares[row][col]=newButton; 
	    		}
	    		if(int2DArray[row][col] == 0) {
	    			JButton newButton = new JButton();
	    			newButton.setBorderPainted(false);
	    			newButton.setBackground(Color.RED);
	    			squares[row][col]=newButton; 
	    		}
	    	}
	    }
	
	    for (int ii = 0; ii < 5; ii++) {
            for (int jj = 0; jj < 5; jj++) {
             board.add(squares[jj][ii]);
                }
            }
        

      this.add(board);

   }
	  
	    
	//iterera igenom 2Darray rad för rad och skriv ut arrayen till konsol 
	public void printArrayToConsole() {
		 //För varje vågrät rad...
	    for (int row = 0; row < int2DArray.length ; row++) {
	    	System.out.println();
	    		//...så itererar vi igenom varje kolumn
	    	for (int col = 0; col < int2DArray[row].length ; col++) {
	      	
	    			System.out.print(int2DArray[row][col]);
	    	 }
	    	
	    }
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
