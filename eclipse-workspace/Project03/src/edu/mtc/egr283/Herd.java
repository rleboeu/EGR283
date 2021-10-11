package edu.mtc.egr283;

import java.util.ArrayList;

/**
 * Herd class for grouping Walruses
 * @author ryanmleboeuf
 * @version 1.0.0 09-27-2021
 */
public class Herd {

	// fields
	private ArrayList<Walrus> herd;
	
	/**
	 * No-args constructor
	 */
	public Herd() {
		this.herd = new ArrayList<Walrus>();
	}// Ending bracket of constructor
	
	/**
	 * Add a Walrus to the Herd
	 * @param name of Walrus
	 * @param age of Walrus
	 * @param weight of Walrus
	 */
	public void addWalrus(String name, int age, double weight) {
		Walrus w = new Walrus();
		w.setName(name);
		w.setAge(age);
		w.setWeight(weight);
		
		this.herd.add(w);
	}// Ending bracket of method addWalrus
	
	/**
	 * Add a Walrus to the Herd
	 * @param walrus to add
	 */
	public void addWalrus(Walrus walrus) {
		this.herd.add(walrus);
	}// Ending bracket of method addWalrus
	
	/**
	 * Averages the ages of all Walruses in the Herd
	 * @return average age of the Herd
	 */
	public int averageAge() {
		int avg = 0;
		for (Walrus w : this.herd) {
			avg += w.getAge();
		}// Ending bracket of for each Walrus
		
		avg /= this.herd.size();
		return avg;
	}// Ending bracket of method averageAge
	
	/**
	 * Averages the weights of all Walruses in the Herd
	 * @return average weight of the Herd
	 */
	public double averageWeight() {
		double avg = 0;
		for (Walrus w : this.herd) {
			avg += w.getWeight();
		}// Ending bracket of for each Walrus
		
		avg /= this.herd.size();
		return avg;
	}// Ending bracket of method averageWeight
	
	/**
	 * Returns the walrus at the index
	 * @param index of Walrus
	 * @return walrus at index
	 */
	public Walrus getWalrus(int index) {
		return this.herd.get(index);
	}// Ending bracket of method getWalrus
	
	/**
	 * Get the size of the Herd
	 * @return size of herd
	 */
	public int getSize() {
		return this.herd.size();
	}// Ending bracket of method getSize
	
	/**
	 * Finds the **first** Walrus that matches parameter name
	 * @param name of Walrus
	 * @return Walrus with name == parameter, null if no match
	 */
	public Walrus findWalrus(String name) {
		Walrus targetWalrus = null;
		
		for (Walrus w : this.herd) {
			if (w.getName().equals(name)) {
				targetWalrus = w;
				break;
			}// Ending bracket of if
		}// Ending bracket of for each Walrus
		
		return targetWalrus;
	}// Ending bracket of method findWalrus
	
	/**
	 * Returns the largest Walrus in the Herd
	 * @return largest Walrus
	 */
	public Walrus largestWalrus() {
		Walrus largest = this.herd.get(0);
		
		for (int i = 1; i < this.herd.size(); i++) {
			if (this.herd.get(i).getWeight() > largest.getWeight()) {
				largest = this.herd.get(i);
			}// Ending bracket of if
		}// Ending bracket of for loop
		
		return largest;
	}// Ending bracket of method largestWalrus
	
	/**
	 * Returns the smallest Walrus in the Herd
	 * @return Walrus with the smallest weight
	 */
	public Walrus smallestWalrus() {
		Walrus smallest = this.herd.get(0);
		
		for (int i = 1; i < this.herd.size(); i++) {
			if (this.herd.get(i).getWeight() < smallest.getWeight()) {
				smallest = this.herd.get(i);
			}// Ending bracket of if
		}// Ending bracket of for loop
		
		return smallest;
	}// Ending bracket of method largestWalrus
	
	/**
	 * Returns the oldest Walrus in the Herd
	 * @return oldest Walrus
	 */
	public Walrus oldestWalrus() {
		Walrus oldest = this.herd.get(0);
		
		for (int i = 1; i < this.herd.size(); i++) {
			if (this.herd.get(i).getAge() > oldest.getAge()) {
				oldest = this.herd.get(i);
			}// Ending bracket of if
		}// Ending bracket of for loop
		
		return oldest;
	}// Ending bracket of method oldestWalrus
	
	/**
	 * Returns the youngest Walrus in the Herd
	 * @return Walrus with lowest age
	 */
	public Walrus youngestWalrus() {
		Walrus youngest = this.herd.get(0);
		
		for (int i = 1; i < this.herd.size(); i++) {
			if (this.herd.get(i).getAge() < youngest.getAge()) {
				youngest = this.herd.get(i);
			}// Ending bracket of if
		}// Ending bracket of for loop
		
		return youngest;
	}// Ending bracket of method oldestWalrus
	
	/**
	 * Removes Walrus with matching name IF one is present in the list
	 * @param name of Walrus to remove
	 */
	public void removeWalrus(String name) {
		for (int i = 0; i < this.herd.size(); i++) {
			if (this.herd.get(i).getName().equals(name)) {
				this.herd.remove(i);
			}// Ending bracket of if
		}// Ending bracket of for loop
	}// Ending bracket of method removeWalrus
	
	/**
	 * Returns a String representation of the Walrus Herd
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for (Walrus w : this.herd) {
			sb.append(w.toString() + "\n");
		}// Ending bracket of for each Walrus
		
		return sb.toString();
	}// Ending bracket of method toString
	
}// Ending bracket of class Herd
