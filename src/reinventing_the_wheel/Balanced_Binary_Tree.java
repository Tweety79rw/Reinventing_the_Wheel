package reinventing_the_wheel;


public class Balanced_Binary_Tree<T extends Comparable<T>> extends Binary_Tree<T> {
	
	
	
	@Override
	public Node<T> insert(T value) {
		return root = insert(new Node<T>(value),root);
	}
	private Node<T> insert(Node<T> newNode,Node<T> node){
		if(node == null){
			node = newNode;
		}else if(node.getValue().compareTo(newNode.getValue())>0){
			newNode.parent = node;
			node.left = this.insert(newNode,node.left);
			if (height( node.left ) - height( node.right ) == 2)
                if (newNode.getValue().compareTo(node.left.getValue())<0)
                	node = rotateWithLeftChild( node );
                else
                	node = doubleWithLeftChild( node );
		}else if(node.getValue().compareTo(newNode.getValue())<0){
			newNode.parent = node;
			node.right = this.insert(newNode,node.right);
			if(height(node.right) - height(node.left) == 2)
				if(newNode.getValue().compareTo(node.right.getValue())>0)
					node = rotateWithRightChild(node);
				else
					node = doubleWithRightChild(node);
		}else{
			node.duplicate++;
		}
		node.height = max(height(node.left),height(node.right)) + 1;
		addCount();
		return node;
	}
	private Node<T> rotateWithLeftChild(Node<T> k2){
		Node<T> k1 = k2.left;
        k2.left = k1.right;
        if(k2.left != null)
        	k2.left.parent = k2;
        k1.right = k2;
        k2.parent = k1;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), k2.height ) + 1;
        return k1;
	}
	private Node<T> rotateWithRightChild(Node<T> k1)
    {
		Node<T> k2 = k1.right;
        k1.right = k2.left;
        if(k1.right != null)
        	k1.right.parent = k1;
        k2.left = k1;
        k1.parent = k2;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), k1.height ) + 1;
        return k2;
    }
	/**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private Node<T> doubleWithLeftChild(Node<T> k3)
    {
        k3.left = rotateWithRightChild( k3.left );
        k3.left.parent = k3;
        return rotateWithLeftChild( k3 );
    }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */      
    private Node<T> doubleWithRightChild(Node<T> k1)
    {
        k1.right = rotateWithLeftChild( k1.right );
        k1.right.parent = k1;
        return rotateWithRightChild( k1 );
    }    
}
