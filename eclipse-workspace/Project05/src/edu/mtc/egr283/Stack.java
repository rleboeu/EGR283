package edu.mtc.egr283;

/**
 * Stack data structure class
 * @author leboe
 * @version 1.0.0	10-20-2021
 */
public class Stack<E> {

	private DLL<E> stackData;
	
	/**
	 * Constructor
	 */
	public Stack() {
		this.stackData = new DLL<E>();
	}// Ending bracket of constructor
	
	/**
	 * Push an item onto the top of the stack
	 * @param payload to push onto the stack
	 */
	public void push(E data) {
		this.stackData.addAtHead(data);
	}// Ending bracket of method push
	
	/**
	 * Remove the top item from the stack
	 * @return item on the top of the stack
	 */
	public E pop() {
		return this.stackData.remove(0);
	}// Ending bracket of method pop
	
	/**
	 * Clear all data in the stack, resetting the size to 0
	 */
	public void clear() {
		while (this.size() > 0) {
			this.pop();
		}// Ending bracket of while loop
	}// Ending bracket of method clear
	
	/**
	 * Returns the int size of the Stack
	 * @return int
	 */
	public int size() {
		return this.stackData.size();
	}// Ending bracket of method size
	
}// Ending bracket of class Stack
