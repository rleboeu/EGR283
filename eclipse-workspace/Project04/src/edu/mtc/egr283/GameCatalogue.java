package edu.mtc.egr283;

import java.util.Scanner;

/**
 * GameCatalogue for storing games
 * @author leboe
 * @version 1.0.0	10-14-2021
 */
public class GameCatalogue {

	// fields
	private SLL<Integer> index;
	private SLL<Game> games;
	
	/**
	 * No-args constructor
	 */
	public GameCatalogue() {
		this.index = new SLL<Integer>();
		this.games = new SLL<Game>();
	}// Ending bracket of constructor
	
	/**
	 * Adds a game to the HEAD of the games SLL
	 * @param g game to add
	 */
	public void addGame(Game g) {
		this.incrementIndices();
		this.games.addAtHead(g);
		this.index.addAtHead(0);
	}// Ending bracket of method addGame
	
	// increment indices to accommodate for adding at head
	private void incrementIndices() {
		int currentData, newData;
		
		for (int i = 0; i < this.index.size(); ++i) {
			currentData = this.index.getDataAtPosition(i);
			newData = currentData + 1;
			
			this.index.setData(newData, i);
		}// Ending bracket of for loop
	}// Ending bracket of method incrementIndices
	
	/**
	 * Returns the Game data at the specified index
	 * @param index
	 * @return Game at index
	 */
	public Game getGame(int index) {
		return this.games.getDataAtPosition(index);
	}// Ending bracket of method getGame
	
	/**
	 * Return the size of the Game SLL
	 * @return
	 */
	public int getSize() {
		return this.index.size();
	}// Ending bracket of method getSize
	
	/**
	 * Returns the first Game in the catalogue that matches name
	 * @param name
	 * @return game data 
	 */
	public Game findGame(String name) {
		Game match = null;
		Game cursor = null;
		
		for (int i = 0; i < this.games.size(); ++i) {
			cursor = this.games.getDataAtPosition(i);
			if (cursor.getName().equals(name)) {
				match = cursor;
				break;
			}// Ending bracket of if
		}// Ending bracket of for loop
		
		return match;
	}// Ending bracket of method findGame
	
	/**
	 * Reads and stores a GameCatalogue file
	 * @param inFile
	 */
	public void readFile(Scanner inFile) {
		while (inFile.hasNextLine()) {
			this.addGame(Game.readGame(inFile));
		}// Ending bracket of while loop
	}// Ending bracket of method readFile
	
	/**
	 * Sorts catalogue alphabetically (inefficient sort algorithm)
	 */
	public void sortCatalogue() {
		Game currentPayload, nextPayload;
		int currentIndex, nextIndex;
		boolean indexDataWasChanged = false;
		
		for (int i = 0; i < this.index.size()-1; ++i) {
			currentIndex = this.index.getDataAtPosition(i);
			nextIndex = this.index.getDataAtPosition(i+1);
			
			currentPayload = this.games.getDataAtPosition(currentIndex);
			nextPayload = this.games.getDataAtPosition(nextIndex);
			
			if (currentPayload.compareTo(nextPayload) > 0) {
				indexDataWasChanged = true;
				this.index.setData(nextIndex, i);
				this.index.setData(currentIndex, i+1);
			}// Ending bracket of if
		}// Ending bracket of for loop
		
		if (indexDataWasChanged) {
			this.sortCatalogue();
		}// Ending bracket of if
	}// Ending bracket of method sortCatalogue
	
	/**
	 * Returns a formatted String representation of the GameCatalogue
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		int currentIndex = 0;
		Game currentData = null;
		String separator = "-------------------------\n";
		
		for (int i = 0; i < this.index.size(); ++i) {
			currentIndex = this.index.getDataAtPosition(i);
			currentData = this.games.getDataAtPosition(currentIndex);
			sb.append(separator + currentData.toString());
		}// Ending bracket of for loop
		
		sb.append(separator);
		return sb.toString();
	}// Ending bracket of method toString
	
}// Ending bracket of class GameCatalogue
