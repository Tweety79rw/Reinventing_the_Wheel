package reinventing_the_wheel;

public class Linked_List<T> {
	@SuppressWarnings("hiding")
	public class Node<T>{
		private T value;
		private Node<T> next;
		private Node<T> prev;
		public Node(){
			setNext(null);
			setPrev(null);
		}
		public Node(T value2){
			this();
			this.setValue(value2);
		}
		@Override
		public String toString() {
			return "Node [value=" + getValue() + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
			return result;
		}
		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node<T> other = (Node<T>) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (getValue() == null) {
				if (other.getValue() != null)
					return false;
			} else if (!getValue().equals(other.getValue()))
				return false;
			return true;
		}
		@SuppressWarnings("unchecked")
		private Linked_List<T> getOuterType() {
			return (Linked_List<T>) Linked_List.this;
		}
		public T getValue() {
			return value;
		}
		public void setValue(T value) {
			this.value = value;
		}
		public Node<T> getNext() {
			return next;
		}
		public void setNext(Node<T> next) {
			this.next = next;
		}
		public Node<T> getPrev() {
			return prev;
		}
		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}
	}
	
	protected Node<T> head;
	protected Node<T> tail;
	private int count;
	
	public Linked_List(){
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	@SuppressWarnings("unchecked")
	public Node<T> push_head(T value){
		Node<T> node = (Node<T>) new Node<Object>(value);
		if(head == null){
			tail = head = node;
		}else{
			node.setNext(head);
			head.setPrev(node);
			head = node;
		}
		count++;
		return head;
	}
	@SuppressWarnings("unchecked")
	public Node<T> push_tail(T value){
		Node<T> node = (Node<T>) new Node<Object>(value);
		if(tail == null){
			tail = head = node;
		}else{
			node.setPrev(tail);
			tail.setNext(node);
			tail = node;
		}
		count++;
		return tail;
	}
	public Node<T> find(T value){
		return this.find(value,head);
	}
	private Node<T> find(T value,Node<T> node){
		Node<T> currentNode = node;
		while(true){
			if(currentNode == null || currentNode.getValue().equals(value)){
				return currentNode;
			}
			currentNode = currentNode.getNext();
		}
	}
	public boolean remove(T value){
		Node<T> nodeToRemove = this.find(value,head);
		if(nodeToRemove == null){
			return false;
		}
		count--;
		if(nodeToRemove.getNext() == null){
			tail = nodeToRemove.getPrev();
		}
		if(nodeToRemove.getPrev() == null){
			head = nodeToRemove.getNext();
		}else{
			nodeToRemove.getPrev().setNext(nodeToRemove.getNext());
			nodeToRemove.getNext().setPrev(nodeToRemove.getPrev());
		}
		return true;
	}
	public void leftToRightPrint(){
		this.leftToRightPrint(head);
	}
	private void leftToRightPrint(Node<T> node){
		Node<T> currentNode = node;
		while(true){
			if(currentNode == null){
				return;
			}
			System.out.println(currentNode);
			currentNode = currentNode.getNext();
		}
	}
	public void rightToLeftPrint(){
		this.rightToLeftPrint(tail);
	}
	private void rightToLeftPrint(Node<T> node){
		Node<T> currentNode = node;
		while(true){
			if(currentNode == null){
				return;
			}
			System.out.println(currentNode);
			currentNode = currentNode.getPrev();
		}
	}
	public int size(){return this.count;}
	public boolean contains(T value){
		return this.find(value) != null;
	}
	public Node<T> removeHead(){
		Node<T> node = head;
		head = head.getNext();
		count--;
		return node;
	}
	public Node<T> removeTail(){
		Node<T> node = tail;
		tail = tail.getPrev();
		count--;
		return node;
	}
	public T peek_head(){
		return head.value;
	}
	public T peek_tail(){
		return tail.value;
	}
	protected void addToCount(){
		count++;
	}
}
