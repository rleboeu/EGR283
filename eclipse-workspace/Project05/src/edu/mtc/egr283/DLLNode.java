package edu.mtc.egr283;

public class DLLNode<T> {
	private DLLNode<T> prevNode;
	private T nodeData;
	private DLLNode<T> nextNode;
	
	public DLLNode() {
		this(null);
	}// end constructor
	public DLLNode(T newNodeData) {
		this(null, newNodeData, null);
	}// Ending bracket of constructor
	public DLLNode(DLLNode<T> newPrevNode, T newNodeData, DLLNode<T> newNextNode) {
		this.setPrevNode(newPrevNode);
		this.setNodeData(newNodeData);
		this.setNextNode(newNextNode);
	}// Ending bracket of constructor
	
	public DLLNode<T> getPrevNode() {
		return this.prevNode;
	}// Ending bracket of method getPrevNode
	
	public void setPrevNode(DLLNode<T> newPrevNode) {
		this.prevNode = newPrevNode;
	}// Ending bracket of method setPrevNode
	
	public T getNodeData() {
		return this.nodeData;
	}// Ending bracket of method getNodeData
	
	public void setNodeData(T newNodeData) {
		this.nodeData = newNodeData;
	}
	public DLLNode<T> getNextNode() {
		return this.nextNode;
	}
	public void setNextNode(DLLNode<T> newNextNode) {
		this.nextNode = newNextNode;
	}
}
	