package museumHeist.sprites;

import java.awt.EventQueue;
import museumHeist.GUI.Classes.GameBoardInterface;

public class Main {
	//skapade en mainklass bara för att leka med objekten lite 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameBoardInterface gb = new GameBoardInterface();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}}

