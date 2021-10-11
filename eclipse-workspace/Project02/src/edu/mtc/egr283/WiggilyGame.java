package edu.mtc.egr283;

import java.util.ArrayList;

/**
 * Main logic controller for Uncle Wiggily
 * @author ryanleboeuf
 * @version 1.00 21-09-03
 */
public class WiggilyGame {
	
	// static fields
	private static int numberOfRounds = 10;
	private static final int MAX_SQUARE_NUMBER = 150;
	
	// local fields
	private Board gameBoard;
	private Deck redDeck, yellowDeck;
	private ArrayList<Player> players;
	private Player winner = null;
	
	/**
	 * Default constructor
	 */
	public WiggilyGame() {
		this.gameBoard = new Board();
		this.redDeck = new Deck();
		this.yellowDeck = new Deck();
		this.players = new ArrayList<Player>();
		
		this.startGame();
	}// Ending bracket of constructor
	
	// contains the main game loop
	private void startGame() {
		this.initializePlayers();
		
		for (int i = 0; i < WiggilyGame.numberOfRounds; i++) {
			System.out.println("++++++     BEGIN ROUND " + (i+1) + "      ++++++");

			this.resetAllPlayerSquares();
			
			/* ***************************
			 * 		MAIN GAME LOOP
			 * ***************************/
			do {
				// each player gets one turn
				for (Player player : this.players) {
					if (this.canTakeTurn(player) == false) {
						player.adjustTurnDifferential(1);
						System.out.println("-----------------------");	// formatting
						continue;
					}// Ending bracket of if
					
					// replace decks if they are empty
					this.checkDecks();
					
					// print player information
					System.out.println(player.toString());
					
					// the player advances their turn
					this.takeTurn(player);
					
					// see if the player has landed on a special space
					this.checkForSpecialSpace(player);
					
					System.out.println("-----------------------");	// formatting
					
				}// Ending bracket of for each player
			} while (!this.checkForWinner());
			
			System.out.println(winner.getName() + " wins the round!");
			winner.incrementScore();
			
			// print the scores
			this.printPlayerStatistics();
		}// Ending bracket of for loop
	}// Ending bracket of method startGame
	
	// advance the player's turn
	private void takeTurn(Player player) {
		Card currentCard;
		String backOrForwardString;
		
		// draw a yellow card and print the instructions
		currentCard = this.yellowDeck.dealCard();
		System.out.println(player.getName() + " draws a yellow card: " + currentCard.getMessage());
		
		// if the player draws a red card, print the message
		if (currentCard.isForceDrawRed()) {
			currentCard = this.redDeck.dealCard();
			System.out.println(player.getName() + " draws a red card: " + currentCard.getMessage());
		}// Ending bracket of if
		
		// handle the movement
		if (currentCard.isForceMove()) {
			backOrForwardString = currentCard.getSpacesToMove() < 0 ? " moves back " : " moves forward ";
			System.out.println(player.getName() + backOrForwardString + Math.abs(currentCard.getSpacesToMove()) + " spaces.");
			
			this.playerMoveCheck(player, currentCard.getSpacesToMove());
			System.out.println(player.getName() + " is now on square " + player.getCurrentSquare() + ".");
		}// Ending bracket of if
	}// Ending bracket of method takeTurn
	
	// check to see if the player has landed on a special space and, if so, handle accordingly
	private void checkForSpecialSpace(Player player) {
		int currentSquare = player.getCurrentSquare();
		SpecialSpace specialSpace = this.gameBoard.getSpecialSpaceAt(currentSquare);
		
		if (specialSpace != null) {
			System.out.println(player.getName() + " stopped on a special space!");
			
			switch (specialSpace.getType()) {
				case SKIP_TO_SPACE:
					int targetSquare = specialSpace.getValue();
					String backOrForward = targetSquare < currentSquare ? " moves back " : " moves forward ";
					
					System.out.println(specialSpace.getName() + ": " + player.getName() 
							+ backOrForward + "to square " + targetSquare + ".");
					
					int difference = targetSquare - currentSquare;
					this.playerMoveCheck(player, difference);
					
					break;
				case LOSE_TURN:
					int numTurnsLost = specialSpace.getValue();
					System.out.println(specialSpace.getName() + " : " 
							+ player.getName() + " lost " + numTurnsLost + " turns!");
					player.adjustTurnDifferential(numTurnsLost * (-1));
					
					break;
				default:
					break;
			}// Ending bracket of switch on specialSpace.getType()
		}// Ending bracket of if statement
	}// Ending bracket of method checkForSpecialSpace
	
	// checks to see if the player can take their turn
	private boolean canTakeTurn(Player player) {
		// is the player still at a loss for turns
		if (player.getTurnDifferential() < 0) {
			System.out.println(player.getName() + " cannot take their turn!");
			System.out.println("They have " + Math.abs(player.getTurnDifferential()) 
				+ " turn(s) left until they can go...");
		}// Ending bracket of if
		
		return player.getTurnDifferential() >= 0;
	}// Ending bracket of method canTakeTurn
	
	// check if decks need to be re-created
	private void checkDecks() {
		// re-create decks if necessary
		if (this.yellowDeck.size() == 0) {
			this.createNewDeck(CardColor.YELLOW);
		}// Ending bracket of if
		if (this.redDeck.size() == 0) {
			this.createNewDeck(CardColor.RED);
		}// Ending bracket of if
	}// Ending bracket of method checkDecks
	
	// asks for player names and appends them to player list
	private void initializePlayers() {
		// Ask for player names
		for (int i = 1; i <= 4; i++) {
			System.out.print("Enter name for player " + i + ": ");
			this.players.add(new Player(Driver.USER_INPUT.next()));
		}// Ending bracket of for loop
	}// Ending bracket of method initializePlayers
	
	// checks all players to see if any are on square 150
	private boolean checkForWinner() {
		boolean rv = false;
		
		for (Player p : this.players) {
			if (p.getCurrentSquare() == WiggilyGame.MAX_SQUARE_NUMBER) {
				rv = true;
				winner = p;
				break;
			}// Ending bracket of if
		}// Ending bracket of for each player
		
		return rv;
	}// Ending bracket of method checkForWinner
	
	// bounds checks the player's movement
	private void playerMoveCheck(Player p, int spacesToMove) {
		int targetSquare = p.getCurrentSquare() + spacesToMove;
		if (targetSquare > WiggilyGame.MAX_SQUARE_NUMBER) {
			p.move(WiggilyGame.MAX_SQUARE_NUMBER - p.getCurrentSquare());
		} else if (targetSquare < 0) {
			p.resetCurrentSquare();
		} else {
			p.move(spacesToMove);
		}// Ending bracket of if-else
	}// Ending bracket of method playerMoveCheck
	
	// prints the statistics of each player to the screen
	private void printPlayerStatistics() {
		for (Player p : this.players) {
			System.out.println(p.toString());
		}// Ending bracket of for each player
	}// Ending bracket of method printPlayerStatistics
	
	// sets each player's currentSquare to 0
	private void resetAllPlayerSquares() {
		for (Player p : this.players) {
			p.resetCurrentSquare();
		}// Ending bracket of for loop
	}// Ending bracket of method resetAllPlayerSquares
	
	// method to initalize the decks
	private void createNewDeck(CardColor color) {
		switch (color) {
			case RED:
				this.redDeck.clear();
				
				this.redDeck.add(new Card(CardColor.RED,
						"We really hope you won't feel blue. But Uncle Wiggily must go back two.", true, false, -2));
				this.redDeck.add(new Card(CardColor.RED,
						"Uncle Wiggily must jump back three. It's not the best place for him to be.", true, false, -3));
				this.redDeck.add(new Card(CardColor.RED,
						"Uncle Wiggily must hop back four. Hope this won't happen any more.", true, false, -4));
				this.redDeck.add(new Card(CardColor.RED,
						"Uncle Wiggily must go back five. Nobody knows when he will arrive.", true, false, 5));
				this.redDeck.add(new Card(CardColor.RED,
						"Hurry! Hurry! Don't be late! Move Uncle Wiggily ahead by eight.", true, false, 8));
				this.redDeck.add(new Card(CardColor.RED,
						"Uncle Wiggily hops ahead by nine. He thinks this game is really fine.", true, false, 9));
				this.redDeck.add(new Card(CardColor.RED,
						"Hope you get this card again! Uncle Wiggily goes ahead by ten.", true, false, 10));
				this.redDeck.add(new Card(CardColor.RED,
						"A card this good is not often seen. Move Uncle Wiggily ahead by thirteen!", true, false, 13));
				this.redDeck.add(new Card(CardColor.RED,
						"Uncle Wiggily hops ahead fifteen. You're one of the best he's ever seen!", true, false, 15));
				
				break;
			case YELLOW:
				this.yellowDeck.clear();
				
				this.yellowDeck.add(new Card(CardColor.YELLOW, 
						"Take a red card if you please. Hope you win this game with ease.", false, true, 0));
				this.yellowDeck.add(new Card(CardColor.YELLOW,
						"Uncle Wiggily moves ahead by one. He takes a walk and has some fun.", true, false, 1));
				this.yellowDeck.add(new Card(CardColor.YELLOW,
						"Uncle Wiggily hops forward by two. He moves right now and then he's through.", true, false, 2));
				this.yellowDeck.add(new Card(CardColor.YELLOW,
						"How near the finish will you be? When Uncle Wiggily hops ahead three.", true, false, 3));
				this.yellowDeck.add(new Card(CardColor.YELLOW,
						"Uncle Wiggily hops along by four. Now he likes you even more.", true, false, 4));
				this.yellowDeck.add(new Card(CardColor.YELLOW,
						"He'd rather walk than take a drive. Uncle Wiggily jumps ahead by five.", true, false, 5));
				this.yellowDeck.add(new Card(CardColor.YELLOW,
						"Move Uncle Wiggily forward by six. The clever rabbit knows all the tricks.", true, false, 6));
				this.yellowDeck.add(new Card(CardColor.YELLOW,
						"Uncle Wiggily takes seven hops. He moves right now and then he stops.", true, false, 7));
				this.yellowDeck.add(new Card(CardColor.YELLOW,
						"Hurry! Hurry! Don't be late! Move Uncle Wiggily ahead by eight.", true, false, 8));
				this.yellowDeck.add(new Card(CardColor.YELLOW,
						"Uncle Wiggily hops ahead by nine. He thinks this game is really fine.", true, false, 9));
				this.yellowDeck.add(new Card(CardColor.YELLOW,
						"Hope you get this card again! Uncle Wiggily goes ahead by ten.", true, false, 10));
				
				break;
			default:
				// ?????
		}// Ending bracket of switch
	}// Ending bracket of method initializeDecks
	
}// Ending bracket of class WiggilyGame
