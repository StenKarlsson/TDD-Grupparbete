package museum_heist;

public class GameBoard {
	
	
	
	
	int[][]  board  =  { {1,   1,  1,  1,  1},
						 {1,   0,  0,  0,  1},
						 {1,   0,  0,  0,  1},
						 {1,   0,  0,  0,  1},
						 {1,   0,  0,  0,  1},
						 {1,   0,  0,  0,  1},
						 {1,   0,  0,  0,  1},
						 {1,  1,   1,  1,  1}					
						 						};
	
	
	
	//returnerar värdet som återfinns på den inskickade positionen
	public int getGameBoardValue(Position pos) {
		int row = (int) pos.getX();
		int column = (int)pos.getY();
		int value = board[row][column];
		return value;
	} 
}
