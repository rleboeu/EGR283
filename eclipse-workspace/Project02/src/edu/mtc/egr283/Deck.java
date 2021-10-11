package edu.mtc.egr283;

import java.util.ArrayList;
import java.util.Random;

/**
 * Deck class to hold cards
 * @author nopath
 * @version 1.00 21-09-03
 */
public class Deck extends ArrayList<Card> {

	private static final long serialVersionUID = 1L;
	private static Random randomizer;
	
	/**
	 * Default constructor
	 */
	public Deck() {
		super();
		randomizer = new Random();
	}// Ending bracket of default constructor
	
	/**
	 * Randomly select a card, remove it from the list, and return it
	 * @return randomly selected Card
	 */
	public Card dealCard() {
		Card c = null;
		int index = randomizer.nextInt(this.size());
		
		c = this.get(index);
		this.remove(index);
		
		return c;
	}// Ending bracket of method dealCard
	
	
	/**
	 * @return String representation of Deck
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for (Card c : this) {
			sb.append(c.getCardColor() + " --- " + c.getMessage() + "\n");
		}// Ending bracket of for each Card
		
		return sb.toString();
	}// Ending bracket of method toString
	
}// Ending bracket of class Deck
