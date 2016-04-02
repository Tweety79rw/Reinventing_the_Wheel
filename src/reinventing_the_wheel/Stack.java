package reinventing_the_wheel;

public class Stack<T> extends Linked_List<T> {
	public Node<T> push(T value){
		return push_head(value);
	}
	public Node<T> pop(){
		return removeHead();
	}
}
