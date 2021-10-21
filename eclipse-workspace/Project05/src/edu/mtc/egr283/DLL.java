package edu.mtc.egr283;

public class DLL<E> {
	
	private DLLNode<E> head;
	private DLLNode<E> tail;
	private int size;
	
	public DLL() {
		this.size = 0;
		this.head = new DLLNode<E>();
		this.tail = new DLLNode<E>();
		this.head.setNextNode(tail);
		this.tail.setPrevNode(head);
	}// Ending bracket of constructor
	
	public int size() {
		return this.size;
	}// Ending bracket of method size
	
	public E getNodeDataAt(int position) {
		return (this.find(position)).getNodeData();
	}// Ending bracket of method getNodeDataAt
	
	public void addAtHead(E newNodeData) {
		this.addAfter(this.head, new DLLNode<E>(null, newNodeData, null));
	}// Ending bracket of method addAtHead
	
	public void addAtTail(E newNodeData) {
		this.addAfter(this.tail.getPrevNode(), new DLLNode<E>(null, newNodeData, null));
	}// Ending bracket of method addAtTail
	
	public void addAtPosition(E newNodeData, int position) {
		DLLNode<E> cursor = this.head;
		DLLNode<E> newNode = new DLLNode<E>(null, newNodeData, null);
		if(position > 0) {
			cursor = this.find(position - 1);
		}// Ending bracket of if
		this.addAfter(cursor, newNode);
	}// Ending bracket of method addAtPosition
	
	public E remove(int position) {
		DLLNode<E> cursor = this.head;
		if(position > 0) {
			cursor = this.find(position - 1);
		}// Ending bracket of if
		DLLNode<E> targetNode = cursor.getNextNode();
		(targetNode.getPrevNode()).setNextNode(targetNode.getNextNode());
		(targetNode.getNextNode()).setPrevNode(targetNode.getPrevNode());
		--this.size;
		E rv = targetNode.getNodeData();
		targetNode.setNextNode(null);
		targetNode.setNodeData(null);
		targetNode.setPrevNode(null);
		return rv;
	}// Ending bracket of method remove
	
	public E remove(E target) {
		return this.remove(this.findIndex(target));
	}// Ending bracket of method remove(E)
	
	private void addAfter(DLLNode<E> currentNode, DLLNode<E> newNode){
		newNode.setNextNode(currentNode.getNextNode());
		currentNode.setNextNode(newNode);
		newNode.setPrevNode(currentNode);
		(newNode.getNextNode()).setPrevNode(newNode);
		++this.size;
	}// Ending bracket of method addAfter
	
	private DLLNode<E> findData(E target) {
		DLLNode<E> cursor = this.head.getNextNode();
		while((cursor != this.tail) && (!(cursor.getNodeData().equals(target)))) {
		cursor = cursor.getNextNode();
		}// Ending bracket of while loop
		return cursor;
	}// Ending bracket of method findData
	
	private int findIndex(E target) {
		int index = 0;
		DLLNode<E> cursor = this.head.getNextNode();
		while((cursor != this.tail) && (!(cursor.getNodeData().equals(target)))) {
			cursor = cursor.getNextNode();
			++index;
		}// Ending bracket of while loop
		if (!(cursor.getNodeData().equals(target))) {
			return -1;
		}
		return index;
	} // Ending bracket of method findIndex
	
	private DLLNode<E> find(int position){
		DLLNode<E> cursor = null;
		if(position < (this.size() / 2)) {
			cursor = this.head.getNextNode();
			for(int i = 0; i != position; ++i) {
				cursor = cursor.getNextNode();
			}// Ending bracket of for loop
		} else {
			cursor = this.tail.getPrevNode();
			for(int i = this.size() - 1; i != position; --i) {
				cursor = cursor.getPrevNode();
			}// Ending bracket of for loop
		}// Ending bracket of if
		return cursor;
	}// Ending bracket of method find(fill)
	
}// Ending bracket of method addAfter