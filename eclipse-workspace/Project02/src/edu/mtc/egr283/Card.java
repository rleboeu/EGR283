package edu.mtc.egr283;

/**
 * Card class
 * @author ryanleboeuf
 * @version 1.00 21-09-03
 */
public class Card {

	// fields
	private CardColor cardColor;
	private String cardMessage;
	private boolean forceMove;
	private boolean forceDrawRed;
	private int spacesToMove;
	
	/**
	 * Constructor (no-args)
	 */
	public Card() {
		this(CardColor.YELLOW, "Default Message", false, false, 0);
	}// Ending bracket of constructor
	
	/**
	 * Constructor (args)
	 * @param color of the card
	 * @param message on the card
	 * @param newForceMove if the player should be forced to move spaces
	 * @param newForceDraw if the player should be forced to draw a red card
	 * @param moveSpaces number of spaces for the player to move
	 */
	public Card(CardColor color, String message, boolean newForceMove, boolean newForceDraw, int moveSpaces) {
		this.setCardColor(color);
		this.setMessage(message);
		this.setForceMove(newForceMove);
		this.setForceDrawRed(newForceDraw);
		this.setSpacesToMove(moveSpaces);
	}// Ending bracket of constructor
	
	/*
	 * ACCESSORS AND MUTATORS
	 */
	
	/**
	 * Accessor for cardColor
	 * @return CardColor.RED or CardColor.YELLOW
	 */
	public CardColor getCardColor() {
		return this.cardColor;
	}// Ending bracket of method getCardColor
	
	// mutator for cardColor
	private void setCardColor(CardColor newColor) {
		this.cardColor = newColor;
	}// Ending bracket of method setCardColor
	
	/**
	 * Accessor for cardMessage
	 * @return cardMessage
	 */
	public String getMessage() {
		return this.cardMessage;
	}// Ending bracket of method getMessage
	
	// mutator for cardMessage
	private void setMessage(String newMessage) {
		this.cardMessage = newMessage;
	}// Ending bracket of method setMessage

	/**
	 * Accessor for forceMove (if the card dictates the player should move)
	 * @return true or false if the card forces the player to move
	 */
	public boolean isForceMove() {
		return forceMove;
	}// Ending bracket of method isForceMove

	// mutator for forceMove
	private void setForceMove(boolean forceMove) {
		this.forceMove = forceMove;
	}// Ending bracket of method setForceMove

	/**
	 * Accessor for forceDrawRed (if the card dictates the player should draw red)
	 * @return true or false if the card forces the player to draw a red card
	 */
	public boolean isForceDrawRed() {
		return forceDrawRed;
	}// Ending bracket of method isForceDrawRed

	// mutator for forceDrawRed
	private void setForceDrawRed(boolean forceDrawRed) {
		this.forceDrawRed = forceDrawRed;
	}// Ending bracket of method setForceDrawRed
	
	/**
	 * Accessor for spacesToMove
	 * @return [-150,150]
	 */
	public int getSpacesToMove() {
		return this.spacesToMove;
	}// Ending bracket of method getSpacesToMove
	
	// mutator for spacesToMove
	private void setSpacesToMove(int newSpaces) {
		this.spacesToMove = newSpaces;
	}// Ending bracket of method setSpacesToMove
	
}// Ending bracket of class Card
