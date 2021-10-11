package edu.mtc.egr283;

/**
 * Class for special spaces
 * @author ryanleboeuf
 * @version 1.00 21-09-03
 */
public class SpecialSpace {

	/**
	 * enum for the type of special space
	 * @author ryanleboeuf
	 * @version 1.00 21-09-03
	 */
	public static enum TYPE { LOSE_TURN, SKIP_TO_SPACE };
	
	private int value;
	private String name;
	private TYPE type;
	
	/**
	 * Constructor 
	 * @param name of the special space
	 * @param type of the special space (SpecialSpace.TYPE)
	 * @param value of the loss in turn or space to move to
	 */
	public SpecialSpace(String name, TYPE type, int value) {
		this.setName(name);
		this.setType(type);
		this.setValue(value);
	}// Ending bracket of constructor
	
	/**
	 * Get the value of the space
	 * @return the magnitude of the change (number of turns lost or space to move to)
	 */
	public int getValue() {
		return this.value;
	}// Ending bracket of method getValue
	
	// set the value of the square
	private void setValue(int newValue) {
		this.value = newValue;
	}// Ending bracket of method setValue
	
	/**
	 * Accessor for SpecialSpace.name
	 * @return the name of the space
	 */
	public String getName() {
		return this.name;
	}// Ending bracket of method getName
	
	// set the name of the space
	private void setName(String newName) {
		this.name = newName;
	}// Ending bracket of method setName
	
	/**
	 * Accessor for type
	 * @return the SpecialSpace.TYPE of the space (LOSE_TURN or SKIP_TO_SPACE)
	 */
	public TYPE getType() {
		return this.type;
	}// Ending bracket of method getType
	
	// set the type of the space
	private void setType(TYPE newType) {
		this.type = newType;
	}// Ending bracket of method setType
}// Ending bracket of class SpecialSpace
