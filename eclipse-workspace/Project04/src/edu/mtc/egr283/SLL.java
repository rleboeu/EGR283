package edu.mtc.egr283;


public class SLL<E> {
	private int length;
	private SLLNode<E> head;
	private SLLNode<E> tail;
	
	public static final String COLON_SPACE = ": ";
	
	public static final String NEW_LINE = "\n";
	public SLL() {
		this.length = 0;
		this.tail = new SLLNode<E>();
		this.head = new SLLNode<E>(null, this.tail);
	}// Ending bracket of constructor
	
	public int size() {
		return this.length;
	}// Ending bracket of the method size
	
	public E getDataAtPosition(int position) {
		return (this.find(position)).getNodeData();
	}//Ending bracket of method getDataAtPosition
	
	public void addAtHead(E newNodeData) {
		this.addAfter(this.head, new SLLNode<E>(newNodeData, null));
	}// Ending bracket of method addAtHead
	
	public void add(E newNodeData, int position) {
		SLLNode<E> cursor = this.head;
		
		if(position > 0) {
			cursor = this.find(position - 1);
		}// Ending bracket of if(position)
		
		this.addAfter(cursor, new SLLNode<E>(newNodeData, null));
	}//Ending bracket of method add
	
	public void setData(E newNodeData, int position) {
		(this.find(position)).setNodeData(newNodeData);
	}// Ending bracket of method setData
	
	private void addAfter(SLLNode<E> currentNode, SLLNode<E> newNode){
		newNode.setNextNode(currentNode.getNextNode());
		currentNode.setNextNode(newNode);
		++this.length;
	}// Ending bracket of method addAfter
	
	public E remove(int position) {
		SLLNode<E> cursor = this.head;
		if(position > 0) {
			cursor = this.find(position - 1);
		}// Ending bracket of if
		SLLNode<E> targetNode = cursor.getNextNode();
		cursor.setNextNode(targetNode.getNextNode());
		--this.length;
		E rv = targetNode.getNodeData();
		targetNode.setNextNode(null);
		targetNode.setNodeData(null);
		return rv;
	}// Ending bracket of method remove
	
	public E removeData(E targetData) {
		return this.remove(this.findIndex(targetData));
	}// Ending bracket of method removeData
	
	private int findIndex(E targetData) {
		int rv = 0;
		SLLNode<E> cursor = this.head.getNextNode();
		while((cursor != this.tail) && (!cursor.getNodeData().equals(targetData))) {
			cursor = cursor.getNextNode();
			++rv;
		}// Ending bracket of while loop
		if(rv == this.size()) {
			rv = -1;
		}// Ending bracket of if
		return rv;
	}// Ending bracket of method findIndex(E)
	
	private SLLNode<E> find(int position) {
		SLLNode<E> cursor = this.head.getNextNode();
		int index = 0;
		while((index != position) && (cursor != this.tail)) {
			++index;
			cursor = cursor.getNextNode();
		}// Ending bracket of while loop
		return cursor;
		}// Ending bracket of method find
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		SLLNode<E> cursor = this.head.getNextNode();
		int index = 0;
		while(cursor != this.tail) {
			sb.append(index + COLON_SPACE);
			sb.append(cursor.getNodeData().toString() + NEW_LINE);
			cursor = cursor.getNextNode();
			++index;
		}// Ending bracket of while loop
		return sb.toString();
	}// Ending bracket of method toString
}// Ending bracket of class SLL