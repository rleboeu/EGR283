package edu.mtc.egr283;

import java.util.Scanner;

/**
 * Driver class for Uncle Wiggily game
 * @author ryanleboeuf
 * @version 1.00 21-09-03
 */
public class Driver {

	/**
	 * Static pointer reference to the keyboard
	 */
	public static final Scanner USER_INPUT = new Scanner(System.in);
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		new WiggilyGame();
	}// Ending bracket of method main
	
}// Ending bracket of class Driver
