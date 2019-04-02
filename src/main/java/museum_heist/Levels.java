package museum_heist;

public class Levels {

  
  /*
	 * 1 = vägg
	 * 2 = dörr
	 * 3 = laser
	 * 4 = startposition för spelare
	 * 5 = skatt
	 */
  
  
	private static final int[][] level1 = {   
											  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
										      {1, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
										      {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 6, 3, 0, 0, 0, 0, 1, 6, 6, 6, 6, 1},
										      {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 6, 3, 0, 0, 0, 0, 1, 0, 0, 0, 6, 1},
										      {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 6, 3, 0, 0, 9, 0, 1, 3, 3, 0, 6, 1},
										      {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 6, 3, 0, 0, 0, 0, 1, 5, 3, 0, 6, 1},
										      {1, 0, 1, 1, 1, 1, 1, 3, 3, 6, 6, 1, 0, 6, 3, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1},
										      {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
										      {1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 6, 0, 0, 0, 1},
										      {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1},
										      {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 3, 0, 1, 3, 3, 1, 0, 1},
										      {1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 3, 0, 1, 5, 6, 1, 0, 1},
										      {1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 6, 3, 0, 1, 1, 3, 1, 0, 1},
										      {1, 5, 0, 0, 0, 0, 0, 0, 1, 0, 5, 1, 0, 0, 0, 1, 0, 6, 0, 1, 1, 6, 5, 0, 1},
										      {1, 0, 0, 0, 3, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 1, 3, 0, 0, 1},
									          {1, 0, 6, 3, 3, 3, 3, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 6, 3, 1, 1, 1, 0, 1},
									          {1, 0, 0, 6, 6, 0, 0, 0, 1, 0, 0, 1, 6, 6, 0, 0, 0, 1, 6, 3, 0, 0, 1, 0, 1},
									          {1, 0, 0, 6, 0, 0, 0, 0, 1, 0, 0, 1, 3, 3, 2, 3, 3, 1, 6, 3, 0, 0, 1, 0, 1},
									          {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 6, 6, 0, 0, 0, 1, 0, 3, 1, 1, 1, 0, 1},
									          {1, 0, 0, 6, 0, 3, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1},
									          {1, 0, 0, 6, 0, 3, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1},
									          {1, 0, 0, 6, 0, 3, 0, 0, 1, 0, 0, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
									          {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
									          {1, 5, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 5, 1},
								 	          {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
																												};
									
	
	private static final int[][] level2 = {   
			  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		      {1, 0, 1, 0, 0, 3, 0, 0, 1, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 6, 0, 3, 5, 1},
		      {1, 0, 1, 5, 0, 3, 0, 0, 1, 0, 0, 0, 0, 6, 3, 0, 0, 0, 0, 1, 0, 0, 3, 0, 1},
		      {1, 0, 1, 0, 6, 0, 0, 0, 1, 0, 0, 0, 0, 6, 3, 0, 0, 0, 0, 1, 6, 0, 3, 3, 1},
		      {1, 0, 1, 0, 6, 0, 0, 0, 1, 1, 1, 1, 0, 6, 3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
		      {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 6, 3, 0, 0, 0, 0, 1, 9, 0, 6, 6, 1},
		      {1, 0, 1, 1, 1, 1, 1, 3, 3, 6, 6, 1, 0, 6, 3, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1},
		      {1, 0, 1, 0, 0, 6, 1, 0, 0, 0, 0, 1, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
		      {1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1},
		      {1, 0, 1, 0, 6, 3, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
		      {1, 0, 1, 5, 6, 3, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 3, 0, 1, 0, 0, 0, 0, 1},
		      {1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 3, 0, 1, 0, 0, 0, 0, 1},
		      {1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 6, 3, 0, 1, 0, 0, 0, 0, 1},
		      {1, 5, 1, 0, 0, 0, 0, 0, 1, 0, 5, 1, 0, 0, 0, 1, 0, 6, 0, 1, 0, 0, 5, 0, 1},
		      {1, 0, 1, 0, 3, 0, 0, 0, 1, 3, 3, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 1},
	          {1, 0, 6, 3, 3, 3, 3, 0, 1, 3, 3, 1, 0, 0, 0, 0, 0, 1, 6, 3, 0, 0, 1, 0, 1},
	          {1, 0, 0, 6, 6, 0, 0, 0, 1, 3, 3, 1, 6, 6, 0, 0, 0, 1, 6, 3, 0, 0, 1, 0, 1},
	          {1, 0, 1, 6, 0, 0, 0, 0, 1, 6, 0, 1, 3, 3, 2, 3, 3, 1, 6, 3, 0, 0, 1, 0, 1},
	          {1, 0, 1, 1, 1, 1, 1, 1, 1, 6, 6, 1, 6, 6, 0, 0, 0, 1, 0, 3, 0, 0, 1, 0, 1},
	          {1, 0, 1, 5, 6, 0, 6, 6, 1, 6, 6, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1},
	          {1, 0, 1, 6, 6, 6, 6, 6, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1},
	          {1, 0, 1, 3, 6, 6, 6, 0, 1, 0, 0, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 1},
	          {1, 0, 1, 1, 1, 1, 1, 3, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 8, 1},
	          {1, 0, 1, 0, 6, 6, 3, 3, 3, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 1},
	          {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
																				};
	
	
	private static final int[][] level3 = {   {  1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
												{1, 0, 3, 5, 1, 5, 3, 3, 3, 1, 5, 3, 3, 3, 3, 3, 3, 3, 3, 6, 6, 0, 1, 5, 1},
												{1, 6, 6, 6, 1, 3, 3, 3, 3, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 6, 0, 1, 3, 1},
												{1, 0, 3, 0, 1, 3, 3, 3, 3, 1, 3, 3, 3, 3, 0, 3, 3, 3, 3, 3, 6, 0, 1, 3, 1},
												{1, 0, 3, 0, 1, 3, 3, 0, 0, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 6, 0, 1, 5, 1},
												{1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 6, 0, 1, 6, 1},
												{1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 6, 0, 1, 6, 1},
												{1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 6, 0, 1, 6, 1},
												{1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 6, 0, 1, 5, 1},
												{1, 0, 1, 3, 3, 3, 3, 1, 0, 1, 3, 3, 3, 3, 0, 3, 3, 3, 3, 3, 5, 0, 1, 3, 1},
									            {1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 6, 0, 1, 3, 1},
									            {1, 0, 1, 6, 6, 6, 6, 1, 0, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 6, 0, 1, 3, 1},
									            {1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 8, 1},
									            {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 6, 1},
									            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 6, 1},
									            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 3, 3, 3, 3, 3, 5, 1, 0, 1, 0, 0, 1, 6, 1},
												{1, 0, 1, 0, 0, 0, 1, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 1, 0, 1, 0, 0, 1, 5, 1},
												{1, 0, 1, 0, 1, 0, 1, 0, 1, 3, 3, 3, 6, 0, 2, 3, 3, 1, 0, 1, 0, 0, 1, 3, 1},
												{1, 0, 1, 0, 1, 0, 1, 0, 1, 3, 3, 3, 3, 3, 3, 3, 3, 1, 0, 1, 0, 0, 1, 3, 1},
												{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 6, 3, 3, 3, 3, 6, 0, 1, 0, 1, 0, 0, 1, 3, 1},
												{1, 0, 1, 0, 1, 0, 1, 0, 1, 3, 3, 3, 3, 0, 6, 3, 3, 1, 0, 1, 0, 0, 1, 3, 1},
												{1, 0, 0, 0, 1, 0, 0, 0, 1, 3, 3, 3, 3, 3, 3, 3, 5, 1, 0, 1, 0, 0, 1, 0, 1},
												{1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 6, 1},
												{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
												{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,}
};

	private static final int[][] level4 = 
		{     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		      {1, 0, 3, 3, 6, 6, 6, 3, 3, 3, 6, 6, 6, 6, 3, 3, 3, 6, 6, 6, 5, 6, 6, 3, 1},
		      {1, 3, 3, 3, 6, 6, 6, 3, 3, 3, 6, 6, 5, 0, 3, 3, 3, 6, 6, 6, 6, 6, 6, 3, 1},
		      {1, 3, 3, 0, 6, 6, 6, 3, 3, 3, 6, 6, 6, 6, 3, 3, 0, 8, 6, 6, 6, 6, 6, 3, 1},
		      {1, 6, 6, 6, 6, 6, 6, 3, 3, 3, 0, 6, 6, 6, 3, 3, 3, 6, 6, 6, 6, 6, 6, 3, 1},
		      {1, 6, 6, 6, 6, 6, 5, 3, 3, 3, 0, 6, 6, 6, 3, 3, 3, 6, 6, 6, 6, 6, 6, 3, 1},
		      {1, 6, 6, 6, 6, 6, 0, 3, 3, 3, 6, 6, 6, 6, 3, 3, 3, 6, 6, 6, 6, 6, 6, 3, 1},
		      {1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 6, 6, 6, 6, 0, 3, 3, 0, 6, 6, 6, 6, 6, 3, 1},
		      {1, 3, 3, 3, 3, 3, 3, 3, 1, 0, 6, 6, 6, 6, 3, 3, 3, 6, 6, 6, 6, 6, 6, 3, 1},
		      {1, 3, 5, 3, 3, 3, 3, 3, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1},
		      {1, 6, 6, 6, 6, 6, 6, 6, 1, 6, 6, 6, 6, 6, 3, 3, 3, 6, 6, 6, 6, 6, 6, 3, 1},
		      {1, 6, 6, 6, 6, 6, 6, 6, 1, 6, 6, 6, 6, 6, 3, 3, 3, 6, 6, 6, 6, 6, 6, 3, 1},
		      {1, 6, 6, 6, 6, 6, 6, 6, 1, 6, 6, 6, 6, 6, 3, 3, 3, 6, 6, 6, 6, 6, 6, 3, 1},
		      {1, 6, 5, 6, 6, 6, 6, 6, 1, 6, 6, 6, 6, 0, 3, 3, 3, 6, 6, 6, 6, 6, 6, 3, 1},
		      {1, 3, 3, 3, 3, 3, 3, 3, 1, 3, 5, 3, 3, 3, 3, 3, 3, 6, 6, 6, 6, 6, 6, 3, 1},
	          {1, 3, 3, 3, 3, 3, 3, 3, 1, 3, 3, 3, 3, 3, 3, 3, 3, 6, 6, 5, 6, 6, 6, 3, 1},
	          {1, 3, 3, 3, 3, 3, 3, 3, 1, 3, 3, 3, 3, 3, 3, 3, 0, 6, 6, 6, 6, 6, 6, 3, 1},
	          {1, 6, 0, 6, 6, 6, 6, 6, 1, 6, 6, 6, 6, 6, 2, 6, 6, 6, 6, 6, 6, 6, 6, 3, 1},
	          {1, 6, 6, 6, 6, 6, 6, 6, 1, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 6, 6, 6, 3, 1},
	          {1, 6, 6, 6, 6, 6, 6, 6, 1, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 3, 1},
	          {1, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 6, 6, 6, 3, 1},
	          {1, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 3, 1},
	          {1, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 0, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 3, 1},
	          {1, 3, 3, 3, 3, 3, 5, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1},
	          {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
};
	
	private static final int[][] level_monsterMovement = 
		{     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
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
	          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
	          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
	          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
	          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 7, 0, 0, 1},
	          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	          {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
};
	
	private static final int[][] level_IntelligentMonsterMovement = 
		{     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
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
	          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
	          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 7, 1, 0, 1},
	          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1},
	          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	          {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
};
	private static final int[][] level999 = {   {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
												{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
								                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
												{1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1},
												{1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
												{1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1},
												{1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
												{1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1},
												{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
												{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
								                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
												{1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1},
												{1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
												{1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1},
												{1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1},
												{1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1},
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
	
	

	
	
	
	
	public static int[][] getLevel(int level){
		switch (level) {
		case 1: return level1;
		case 2: return level2;
		case 3: return level3;
		case 4: return level4;
		case 10: return level_monsterMovement;
		case 11: return level_IntelligentMonsterMovement;
		default: return level999;
		}
	}
	

}
