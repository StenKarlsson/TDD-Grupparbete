
package museumHeist.sprites;

import java.awt.EventQueue;

import org.omg.CORBA.SystemException;

import museumHeist.GUI.Classes.GameBoardInterface;
import museum_heist.Levels;

public class Main {
	
	// Skiss av trådar och laserfunktion
		
	
	
	static int timeInSeconds = 180;
	protected static boolean playerIsMoving = false;
	
	
	
	public static void main(String[] args) 
	
	{
		
				Thread gameThread = new Thread(new Runnable() 
				{
				    public void run()
				    {
				    	final GameBoardInterface gb = new GameBoardInterface();	
				    	Thread Laser = new Thread(new Runnable() 
						{
						    public void run()
						    {
						    	while(timeInSeconds != 0) // Går tills tiden är slut
								{
									try 
									
										{
									gb.flipLaserOnGameBoard(gb.getSquares());
										 	
										 	gb.showTimer(timeInSeconds);
									
										 	Thread.sleep(250);
										} 
									
									catch (InterruptedException e) 
										{
											e.printStackTrace();
										         }
										} gb.setCurrentLevel(Levels.getLevel(999));gb.repaintGameBoard();
						    		
						    }}); 
						Laser.start();	
				    }}); 
				gameThread.start();	 
				
				
				
				
				Thread TimerThread = new Thread(new Runnable() 
				{
					public void run()
						    
					{
						while(timeInSeconds != 0) // Går tills tiden är slut
						{
							try 
							
								{
								 	System.out.println("timer " + (String.valueOf(timeInSeconds)));
								 	if(playerIsMoving) {timeInSeconds--;}
								 	
								 	Thread.sleep(1000);
								} 
							
							catch (InterruptedException e) 
								{
									e.printStackTrace();
								         }
								} 
					}});  
				
				TimerThread.start();
				
				
						     
					 
			
	}
		

	public static int getTimeInSeconds() {
		return timeInSeconds;
	}


	public static void setTimeInSeconds(int timeInSeconds) {
		Main.timeInSeconds = timeInSeconds;
	}


	public static boolean isPlayerIsMoving() {
		return playerIsMoving;
	}


	public static void setPlayerIsMoving(boolean playerIsMoving) {
		Main.playerIsMoving = playerIsMoving;
	}
}
=======
package museumHeist.sprites;

import java.awt.EventQueue;

import org.omg.CORBA.SystemException;

import museumHeist.GUI.Classes.GameBoardInterface;
import museum_heist.Levels;

public class Main {
	
	// Skiss av trådar och laserfunktion
	

	
	static int timeInSeconds = 150;
	protected static boolean playerIsMoving = false;
	private static int laserSpeed = 2000;
	
	
	
	public static void main(String[] args) 
	
	{
		
				Thread gameThread = new Thread(new Runnable() 
				{
				    public void run()
				    {
				    	final GameBoardInterface gb = new GameBoardInterface();	
				    	Thread Laser = new Thread(new Runnable() 
						{
						    

							public void run()
						    {
						    	while(timeInSeconds != 0) // Går tills tiden är slut
								{
									try 
									
										{
									gb.flipLaserOnGameBoard(gb.getSquares());
										 	
										 	gb.showTimer(timeInSeconds);
									

										 	Thread.sleep(laserSpeed);

										} 
									
									catch (InterruptedException e) 
										{
											e.printStackTrace();
										         }
										} gb.setCurrentLevel(Levels.getLevel(999));gb.repaintGameBoard();
						    		
						    }}); 
						Laser.start();	
				    }}); 
				gameThread.start();	 
				
				
				
				
				Thread TimerThread = new Thread(new Runnable() 
				{
					public void run()
						    
					{
						while(timeInSeconds != 0) // Går tills tiden är slut
						{
							try 
							
								{
								 	System.out.println("timer " + (String.valueOf(timeInSeconds)));
								 	if(playerIsMoving) {timeInSeconds--;}
								 	
								 	Thread.sleep(1000);
								} 
							
							catch (InterruptedException e) 
								{
									e.printStackTrace();
								         }
								} 
					}});  
				
				TimerThread.start();
				
				
						     
					 
			
	}
		

	public static int getTimeInSeconds() {
		return timeInSeconds;
	}


	public static void setTimeInSeconds(int timeInSeconds) {
		Main.timeInSeconds = timeInSeconds;
	}


	public static boolean isPlayerIsMoving() {
		return playerIsMoving;
	}


	public static void setPlayerIsMoving(boolean playerIsMoving) {
		Main.playerIsMoving = playerIsMoving;
	}


	public static int getLaserSpeed() {
		return laserSpeed;
	}


	public static void setLaserSpeed(int laserSpeed) {
		Main.laserSpeed = laserSpeed;
	}
}
