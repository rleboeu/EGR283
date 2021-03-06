package edu.mtc.egr283;

import java.util.Scanner;

/**
 * Game class - represents a game in the catalogue
 * @author leboe
 * @version 1.0.0	10-14-2021
 */
public class Game {

	// fields
	private String name;
	private int minAge, maxAge;
	private int minPlayers, maxPlayers;
	private int minPlayTime, maxPlayTime;
	
	/**
	 * Reads a single game from a file and returns it
	 * @param inFile
	 * @return Game
	 */
	public static Game readGame(Scanner inFile) {
		Game result = new Game();
		
		result.setName(inFile.next());
		result.setMinAge(inFile.nextInt());
		result.setMaxAge(inFile.nextInt());
		result.setMinPlayers(inFile.nextInt());
		result.setMaxPlayers(inFile.nextInt());
		result.setMinPlayTime(inFile.nextInt());
		result.setMaxPlayTime(inFile.nextInt());
		
		return result;
	}// Ending bracket of method readGame
	
	/**
	 * Tests equality of calling Game's name to parameter otherName
	 * @param otherName to compareTo
	 * @return true if equal, false if not
	 */
	public boolean compareName(String otherName) {
		return this.getName().equals(otherName);
	}// Ending bracket of method compareName
	
	/**
	 * Compares the calling Game object's name to the parameter Game object's name
	 * @param otherGame
	 * @return int
	 */
	public int compareTo(Game otherGame) {
		return this.getName().compareTo(otherGame.getName());
	}// Ending bracket of method compareTo
	
	/**
	 * Return a String representation of the Game
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(this.getName() + "\n");
		sb.append("Age Range: " + this.getMinAge() + "-" + this.getMaxAge() + "\n");
		sb.append("Number of Players: " + this.getMinPlayers() + "-" + this.getMaxPlayers() + "\n");
		sb.append("Play Time: " + this.getMinPlayTime() + "-" + this.getMaxPlayTime() + "\n");
		
		return sb.toString();
	}// Ending bracket of method toString
	
	/**
	 * Accessor for name
	 * @return name of game
	 */
	public String getName() {
		return name;
	}// Ending bracket of method getName
	
	/**
	 * Mutator for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}// Ending bracket of method setName

	/**
	 * Accessor for minAge
	 * @return minAge of game
	 */
	public int getMinAge() {
		return minAge;
	}// Ending bracket of method getMinAge

	/**
	 * Mutator for minAge
	 * @param minAge
	 */
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}// Ending bracket of method setMinAge

	/**
	 * Accessor for maxAge
	 * @return maxAge of game
	 */
	public int getMaxAge() {
		return maxAge;
	}// Ending bracket of method getMaxAge

	/**
	 * Mutator for maxAge
	 * @param maxAge
	 */
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}// Ending bracket of method setMaxAge

	/**
	 * Accessor for getMinPlayers
	 * @return minPlayers of game
	 */
	public int getMinPlayers() {
		return minPlayers;
	}// Ending bracket of method getMinPlayers

	/**
	 * Mutator for minPlayers
	 * @param minPlayers
	 */
	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}// Ending bracket of method setMinPlayers

	/**
	 * Accessor for getMaxPlayers
	 * @return maxPlayers of game
	 */
	public int getMaxPlayers() {
		return maxPlayers;
	}// Ending bracket of method getMaxPlayers

	/**
	 * Mutator for maxPlayers
	 * @param maxPlayers
	 */
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}// Ending bracket of method setMaxPlayers

	/**
	 * Accessor for minPlayTime
	 * @return minPlayTime of game
	 */
	public int getMinPlayTime() {
		return minPlayTime;
	}// Ending bracket of method getMinPlayTime

	/**
	 * Mutator for minPlayTime
	 * @param minPlayTime
	 */
	public void setMinPlayTime(int minPlayTime) {
		this.minPlayTime = minPlayTime;
	}// Ending bracket of method setMinPlayTime

	/**
	 * Accessor for maxPlayTime
	 * @return maxPlayTime of game
	 */
	public int getMaxPlayTime() {
		return maxPlayTime;
	}// Ending bracket of method getMaxPlayTime

	/**
	 * Mutator for maxPlayTime
	 * @param maxPlayTime
	 */
	public void setMaxPlayTime(int maxPlayTime) {
		this.maxPlayTime = maxPlayTime;
	}// Ending bracket of method setMaxPlayTime
	
}// Ending bracket of class Game
