package edu.mtc.egr283;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Driver class for the Walrus Herd Analytics program
 * @author ryanleboeuf
 * @version 1.0.0 09-27-2021
 */
public class WalrusHerdDriver {

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");
		
		// ask how many walruses are in the herd
		System.out.print("How many walruses are in the herd? ");
		int numWalrus = input.nextInt();
		
		// instantiate numWalrus walruses into the herd based on user input
		String name;
		int age;
		double weight;
		Herd herd = new Herd();
		for (int i = 1; i <= numWalrus; i++) {
			System.out.print("What is Walrus " + i + "'s name? ");
			name = input.next();
			
			System.out.print("How old is " + name + "? ");
			age = input.nextInt();
			
			System.out.print("How much does " + name + " weigh? ");
			weight = input.nextDouble();
			
			herd.addWalrus(name, age, weight);
		}// Ending bracket of for loop
		
		// print a summary of the herd
		System.out.println("\n");	// formatting
		System.out.println(herd.toString());
		
		// determine largest, smallest, oldest, and youngest walruses
		Walrus largest, smallest, oldest, youngest;
		largest = herd.largestWalrus();
		smallest = herd.smallestWalrus();
		oldest = herd.oldestWalrus();
		youngest = herd.youngestWalrus();
		
		// print results of largest, smallest, oldest, youngest
		System.out.println(""); // formatting
		System.out.println(largest.getName() + " is the largest walrus at " + largest.getWeight() + " units!");
		System.out.println(smallest.getName() + " is the smallest walrus at " + smallest.getWeight() + " units!");
		System.out.println(oldest.getName() + " is the oldest walrus at " + oldest.getAge() + " years!");
		System.out.println(youngest.getName() + " is the youngest walrus at " + youngest.getAge() + " years!");
		
		// print average statistics about Herd
		System.out.println(""); // formatting
		System.out.println("The average weight of the herd is " + df.format(herd.averageWeight()) + " units.");
		System.out.println("The average age of the herd is " + herd.averageAge() + " years.");
		
		// close the input stream
		input.close();
	}// Ending bracket of method main

}// Ending bracket of class WalrusHerdDriver
