package edu.mtc.egr283;

/**
 * Player class
 * @author ryanleboeuf
 * @version 1.00 21-09-03
 */
public class Player {
	
	// fields
	private String name;
	private int currentSquare;
	private int score;
	private int turnDifferential;

	/**
	 * Default constructor
	 */
	public Player() {
		this("Robert");
	}// Ending bracket of default constructor
	
	/**
	 * Secondary constructor
	 * @param name of the player
	 */
	public Player(String name) {
		this.setName(name);
		this.setCurrentSquare(0);
		this.setScore(0);
		this.setTurnDifferential(0);
	}// Ending bracket of secondary constructor
	
	/**
	 * Move the player numSpaces amount of squares
	 * @param numSpaces to move
	 */
	public void move(int numSpaces) {
		this.setCurrentSquare(this.getCurrentSquare() + numSpaces);
	}// Ending bracket of method move
	
	/**
	 * Increment the score of the player
	 */
	public void incrementScore() {
		this.setScore(this.getScore() + 1);
	}// Ending bracket of method incrementScore
	
	/**
	 * Controls 'gain a turn' and 'lose N turns'
	 * @param adjustment amount (can be positive or negative)
	 */
	public void adjustTurnDifferential(int adjustment) {
		this.setTurnDifferential(this.getTurnDifferential() + adjustment);
	}// Ending bracket of method adjustTurnDifferential
	
	/*
	 * MUTATORS AND ACCESSORS
	 */
	
	/**
	 * Accessor for player name
	 * @return player name
	 */
	public String getName() {
		return this.name;
	}// Ending bracket of method getName
	
	// mutator for player name
	private void setName(String newName) {
		this.name = newName;
	}// Ending bracket of method setName
	
	/**
	 * Get the player's current spot on the board
	 * @return currentSquare of the player
	 */
	public int getCurrentSquare() {
		return this.currentSquare;
	}// Ending bracket of method getCurrentSquare
	
	// mutator for currentSquare
	private void setCurrentSquare(int newSquare) {
		this.currentSquare = newSquare;
	}// Ending bracket of method setCurrentSquare
	
	/**
	 * Resets the Player's currentSquare to 0
	 */
	public void resetCurrentSquare() {
		this.currentSquare = 0;
	}// Ending bracket of method resetCurrentSquare
	
	/**
	 * Get the number of wins of the player
	 * @return score
	 */
	public int getScore() {
		return this.score;
	}// Ending bracket of method getScore
	
	// mutator for score
	private void setScore(int newScore) {
		this.score = newScore;
	}// Ending bracket of method setScore
	
	/**
	 * Returns the turn differential (amount of turns player has lost)
	 * @return turnDifferential
	 */
	public int getTurnDifferential() {
		return this.turnDifferential;
	}// Ending bracket of method getTurnDifferential
	
	// mutator for turnDifferential
	private void setTurnDifferential(int diff) {
		this.turnDifferential = diff;
	}// Ending bracket of method setTurnDifferential
	
	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "+++  " + this.getName() + ", Current Square: " 
				+ this.getCurrentSquare() + ", Score: " + this.getScore() + "  +++";
	}// Ending bracket of method toString
	
}// Ending bracket of class Player
