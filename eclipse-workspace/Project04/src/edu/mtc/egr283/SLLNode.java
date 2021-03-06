package edu.mtc.egr283;
/**
* This class is the Single Linked List basic node.
* It has two fields, one to hold the data and one
* to reference the next node.
* @author wiliiamsims
* @param <T>
*/
public class SLLNode<T> {
private T nodeData;
private SLLNode<T> nextNode;
/**
* Default "noaargs" constructor
*/
	public SLLNode() {
		this(null, null);
	}// Ending bracket of default "noargs" constructor
	/**
	* Constructor of Single Linked List Node
	* @param newNodeData
	* @param newNextNode
	*/
	public SLLNode(T newNodeData, SLLNode<T> newNextNode) {
		this.setNodeData(newNodeData);
		this.setNextNode(newNextNode);
	}// Ending bracket of constructor
	/**
	* access method for nodeEata
	* @return the nodeData
	*/
	public T getNodeData() {
		return this.nodeData;
	}// Ending bracket of method getNodeData
	/**
	* Mutator method for nodeData
	* @param newNodeData the node data to set
	*/
	public void setNodeData(T newNodeData) {
		this.nodeData = newNodeData;
	}
	/**
	* Assessor method for nextNode
	* @return the nextNode
	*/
	public SLLNode<T> getNextNode() {
		return this.nextNode;
	}// Ending bracket of method getNextNode
	/**
	* Mutator method for nextNode
	* @param newNextNode the next node to set
	*/
	public void setNextNode(SLLNode<T> newNextNode) {
		this.nextNode = newNextNode;
	}// Ending bracket of method setNextNode
}