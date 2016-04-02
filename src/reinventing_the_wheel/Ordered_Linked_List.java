package reinventing_the_wheel;

public class Ordered_Linked_List<T extends Comparable<T>> extends Linked_List<T> {
	
	public Node<T> push(T value){
		return push(new Node<T>(value),head);
	}
	private Node<T> push(Node<T> newNode,Node<T> node){
		if(head == null){
			addToCount();
			return head = tail = newNode;
		}else if(head.getValue().compareTo(newNode.getValue())>=0){
			return push_head(newNode.getValue());
		}else if(tail.getValue().compareTo(newNode.getValue())<=0){
			return push_tail(newNode.getValue());
		}else{
			Node<T> currentNode = getReplaceNode(newNode,node);
			if(currentNode != null){
				newNode.setNext(currentNode.getNext());
				currentNode.setNext(newNode);
				newNode.setPrev(currentNode);
				if(newNode.getNext()!= null)
					newNode.getNext().setPrev(newNode);
			}
			addToCount();
			return newNode;
		}
	}
	private Node<T> getReplaceNode(Node<T> newNode,Node<T> node){
		Node<T> currentNode = node;
		while(true){
			if((currentNode != null && currentNode.getNext() == null) || 
					(currentNode.getValue().compareTo(newNode.getValue())<0 && currentNode.getNext().getValue().compareTo(newNode.getValue())>=0)){
				return currentNode;
			}
			currentNode = currentNode.getNext();
		}
	}
	public void printDescending(){
		rightToLeftPrint();
	}
	public void printAscending(){
		leftToRightPrint();
	}
	public Node<T> getMax(){
		return tail;
	}
	public Node<T> getMin(){
		return head;
	}
	public boolean checkIfOrdered(){
		
		return checkIfOrdered(head);
	}
	private boolean checkIfOrdered(Node<T> node){
		Node<T> currentNode = node;
		while(true){
			if(currentNode == null || currentNode.getNext() == null){
				return true;
			}
			if(currentNode.getValue().compareTo(currentNode.getNext().getValue())>0){
				return false;
			}
			currentNode = currentNode.getNext();
		}
	}
}
