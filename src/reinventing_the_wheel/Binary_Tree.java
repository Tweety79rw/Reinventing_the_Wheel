package reinventing_the_wheel;

public class Binary_Tree<T extends Comparable<T>> {
	public class Node<T>{
		private T value;
		int duplicate;
		int height;
		Node<T> left;
		Node<T> right;
		Node<T> parent;
		public Node(){
			this.left = null;
			this.right = null;
			this.parent = null;
			duplicate = 0;
		}
		public Node(T val){
			this();
			this.value = val;
		}
		@Override
		public String toString(){
			return "the value is " + value;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}
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
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}
		private Binary_Tree<?> getOuterType() {
			return (Binary_Tree<?>) Binary_Tree.this;
		}
		public T getValue(){return value;}
		
		
	}
	
	protected Node<T> root;
	private int count;
	public Binary_Tree(){
		this.root = null;
		count = 0;
	}
	public int size(){
		return count;
	}
	public Node<T> insert(T value){
		return this.root = this.insert(new Node<T>(value),this.root);
	}
	protected void addCount(){
		count++;
	}
	private Node<T> insert(Node<T> newNode, Node<T> node){
		if(node == null){
			node = newNode;
		}else if(node.value.compareTo(newNode.value)>0){
			newNode.parent = node;
			node.left = this.insert(newNode,node.left);
		}else{
			newNode.parent = node;
			node.right = this.insert(newNode,node.right);
		}
		node.height = max(height(node.left),height(node.right)) + 1;
		count++;
		return node;
	}
	public Node<T> search(T value){
		return this.search(value,root);
	}
	private Node<T> search(T value,Node<T> node){
		if(node == null || node.value.equals(value)){
			return node;
		}else if (node.value.compareTo(value)>0){
			return this.search(value,node.left);
		}else{
			return this.search(value,node.right);
		}
	}
	public void inOrderPrint(){
		inOrderPrint(this.root);
	}
	private void inOrderPrint(Node<T> node){
		if(node != null){
			inOrderPrint(node.left);
			System.out.println(node);
			inOrderPrint(node.right);
		}
	}
	public void preorderPrint(){
		preorderPrint(this.root);
	}
	private void preorderPrint(Node<T> node){
		if(node != null){
			System.out.println(node);
			preorderPrint(node.left);
			preorderPrint(node.right);
		}
	}
	public void postOrderPrint(){
		postOrderPrint(this.root);
	}
	private void postOrderPrint(Node<T> node){
		if(node != null){
			postOrderPrint(node.left);
			postOrderPrint(node.right);
			System.out.println(node);
		}
	}
	public boolean remove(T value){
		Node<T> nodeToRemove = this.search(value);
		if(nodeToRemove == null){
			return false;
		}
		Node<T> parent = nodeToRemove.parent;
		boolean isLeftChild = true;
		if(parent != null){ 
			isLeftChild = (parent.value.compareTo(nodeToRemove.value)>0);
		}
		if(nodeToRemove.right == null && nodeToRemove.left == null){
			if(parent == null){
				root = null;
			}else if(isLeftChild){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}else if(nodeToRemove.right == null){
			if(parent == null){
				root = nodeToRemove.left;
			}else if(isLeftChild){
				parent.left = nodeToRemove.left;
			}else{
				parent.right = nodeToRemove.left;
			}
		 
		}else if (nodeToRemove.left == null){
			if(parent == null){
				root = nodeToRemove.right;
			}else if(isLeftChild){
				parent.left = nodeToRemove.right;
			}else{
				parent.right = nodeToRemove.right;
			}
			
		}else{
			Node<T> replacement = walkLeft(nodeToRemove.right);
			if(!replacement.equals(nodeToRemove.right)){
				replacement.parent.left = replacement.right;
				replacement.right = nodeToRemove.right;
			}
			if(parent == null){
				root = replacement;
			}else if(isLeftChild){
				parent.left = replacement;
			}else{
				parent.right = replacement;
			}
			replacement.left = nodeToRemove.left;
		}		
		count--;
		return true;
		
	}
	//traverse to the right most node
	private Node<T> walkRight(Node<T> node){
		if(node.right == null){
			return node;
		}else{
			return walkRight(node.right);
		}
	}
	//traverse to the left most node
	private Node<T> walkLeft(Node<T> node){
		if(node.left == null){
			return node;
		}else{
			return walkLeft(node.left);
		}
	}
	protected int max(int lhs,int rhs){
		return lhs>rhs?lhs:rhs;
	}
	protected int height(Node<T> node){
		return node == null?-1:node.height;
	}
}
