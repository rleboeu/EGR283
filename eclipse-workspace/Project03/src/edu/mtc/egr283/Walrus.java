package edu.mtc.egr283;

/**
 * Walrus Class 
 * @author ryanleboeuf
 * @version 1.0.0 09-27-2021
 */
public class Walrus {

	// constants
	private static final String DEFAULT_NAME = "Larry";
	private static final int DEFAULT_AGE = 23;
	private static final double DEFAULT_WEIGHT = 3000d;
	
	// fields
	private String name;
	private int age;
	private double weight;
	
	/**
	 * no-args constructor for Walrus
	 */
	public Walrus() {
		this.setName(DEFAULT_NAME);
		this.setAge(DEFAULT_AGE);
		this.setWeight(DEFAULT_WEIGHT);
	}// Ending bracket of constructor
	
	/**
	 * Accessor for Walrus name
	 * @return name of walrus
	 */
	public String getName() {
		return this.name;
	}// Ending bracket of method getName
	
	/**
	 * Accessor for Walrus age
	 * @return age of walrus
	 */
	public int getAge() {
		return this.age;
	}// Ending bracket of method getAge
	
	/**
	 * Accessor for Walrus weight
	 * @return weight of walrus
	 */
	public double getWeight() {
		return this.weight;
	}// Ending bracket of method getWeight
	
	/**
	 * Mutator for Walrus name
	 * @param newName of the walrus
	 */
	public void setName(String newName) {
		this.name = newName;
	}// Ending bracket of method setName
	
	/**
	 * Mutator for Walrus age
	 * @param newAge of the walrus
	 */
	public void setAge(int newAge) {
		this.age = newAge;
	}// Ending bracket of method setAge
	
	/**
	 * Mutator for Walrus weight
	 * @param newWeight for walrus
	 */
	public void setWeight(double newWeight) {
		this.weight = newWeight;
	}// Ending bracket of method setWeight
	
	/**
	 * Checks to see if the current walrus name matches the other name
	 * @param otherName to compare to
	 * @return otherName == this.name
	 */
	public boolean compareName(String otherName) {
		return this.getName().equals(otherName);
	}// Ending bracket of method compareName
	
	/**
	 * Compares the age of two Walruses. A negative value indicates the calling Walrus
	 * is younger than the parameter Walrus.
	 * @param otherWalrus
	 * @return -,0,+ depending on whether otherWalrus is older,same,younger (respectively)
	 */
	public int compareTo(Walrus otherWalrus) {
		return this.getAge() - otherWalrus.getAge();
	}// Ending bracket of method compareTo
	
	/**
	 * toString method for Walrus
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getName() + " -- ");
		sb.append("Age: " + this.getAge() + ", ");
		sb.append("Weight: " + this.getWeight());
		return sb.toString();
	}// Ending bracket of method toString
	
}// Ending bracket of class Walrus
