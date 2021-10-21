package edu.mtc.egr283;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Driver class for Project 05
 * @author leboe
 * @version 1.0.0	10-20-2021
 */
public class ArithmeticEvaluatorDriver {

	/**
	 * Main method
	 * @param args 
	 */
	public static void main(String[] args) {
		ArithmeticEvaluator ae = new ArithmeticEvaluator();
		ArrayList<String> equations = new ArrayList<String>();
		DecimalFormat df = new DecimalFormat("#.###");
		
		// add equations to test
		equations.add("((33 - 22) * 22) / (4 / 2)");
		equations.add("((4 * 3) + (3 % 2) * 5)");
		equations.add("(((11 ^ 2) - 21) / 20)");
		equations.add("(121 ^ (1 / 2))");
		equations.add("(2 ^ .5)");
		equations.add("(1.5 % 0.2)");
		
		// variables for the loop
		double result;
		String postfix;
		
		// for each infix equation in equations ArrayList
		for (String infix : equations) {
			postfix = ae.formatPostfix(infix);
			result = ae.evaluatePostfix(postfix);
			
			System.out.println("--------------------------------"); // formatting
			System.out.println("Infix:    " + infix);
			System.out.println("Postfix:  " + postfix);
			System.out.println("Solution: " + df.format(result));
		}// Ending bracket of for each equation
		
	}// Ending bracket of method main

}// Ending bracket of class Driver
