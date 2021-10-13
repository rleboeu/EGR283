package edu.mtc.egr283;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * GameCatalogueDriver - driver class for the Game Catalogue program
 * @author leboe
 * @version 1.0.0 10-14-2021
 */
public class GameCatalogueDriver {

	/**
	 * Main method
	 * @param args - command line arguments
	 */
	public static void main(String[] args) {
		GameCatalogue gc = new GameCatalogue();
		File fileIn = new File("in.txt");
		Scanner scnInput = null;
		
		try {
			scnInput = new Scanner(fileIn);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// Ending bracket of try/catch
		
		// readGame and Game.toString()
		Game firstGame = Game.readGame(scnInput);
		Game secondGame = Game.readGame(scnInput);
		System.out.println("First read game: " + firstGame.toString());
		
		// addGame and readFile
		gc.addGame(firstGame);
		gc.addGame(secondGame);
		gc.readFile(scnInput);
		
		// sortCatalogue and toString for GameCatalogue
		System.out.println("Full catalog: ");
		gc.sortCatalogue();
		System.out.println(gc.toString() + "\n\n\n");

		System.out.println("firstGame.compareName(secondGame.getName()) : " + firstGame.compareName(secondGame.getName()));
		
		scnInput.close();
	}// Ending bracket of method main
	
}// Ending bracket of class GameCatalogueDriver
