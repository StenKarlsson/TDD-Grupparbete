package museumHeist.sprites;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import museumHeist.GUI.Classes.GameBoardInterface;

import museum_heist.GameBoard;
import museum_heist.Position;

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

