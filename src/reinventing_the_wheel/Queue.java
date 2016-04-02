package reinventing_the_wheel;

public class Queue<T> extends Linked_List<T> {
	public Node<T> enqueue(T value){
		return push_tail(value);
	}
	public Node<T> dequeue(){
		return removeHead();
	}
	public T peek(){
		return peek_head();
	}
}
