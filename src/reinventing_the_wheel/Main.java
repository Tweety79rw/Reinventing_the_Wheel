package reinventing_the_wheel;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
	
		
		
	}
	static void stackTest(){
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(50);
		s.push(25);
		s.push(32);
		s.push(6);
		System.out.println("size " + s.size());
		if(s.pop().getValue() == 6) System.out.println("passed");
		System.out.println("size " + s.size());
		System.out.println(s.peek_head());
		System.out.println("size " + s.size());
		System.out.println(s.pop());
		System.out.println("size " + s.size());
		s.leftToRightPrint();
	}
	static void queueTest(){
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(5);
		q.enqueue(50);
		q.enqueue(25);
		q.enqueue(32);
		q.enqueue(6);
		System.out.println("size " + q.size());
		if(q.dequeue().getValue() == 5) System.out.println("passed");
		System.out.println("size " + q.size());
		System.out.println(q.peek());
		System.out.println("size " + q.size());
		System.out.println(q.dequeue());
		System.out.println("size " + q.size());
		q.leftToRightPrint();
	}
	static void btreeTest(){
	 	Binary_Tree<Integer> bTree = new Binary_Tree<Integer>();
		bTree.insert(50);
		bTree.insert(15);
		bTree.insert(15);
		bTree.insert(25);
		bTree.insert(5);
		bTree.insert(75);
		bTree.insert(80);
		bTree.insert(65);
		bTree.insert(19);

		bTree.preorderPrint();
		System.out.println(bTree.remove(15));
		bTree.inOrderPrint();
		System.out.println(bTree.insert(1000));
		bTree.postOrderPrint();
 }
 static void linkedListTest(){
		Linked_List<Integer> list = new Linked_List<Integer>();
		System.out.println("size "+list.size());
		list.push_head(5);
		list.push_head(25);
		list.push_head(15);
		list.push_head(45);
		list.push_head(3);
		list.push_head(55);
		
		list.leftToRightPrint();
		System.out.println("size "+list.size());
		list.remove(15);
		System.out.println("size "+list.size());
		list.remove(10);
		System.out.println("size "+list.size());
		if(list.find(45) != null && list.find(8) == null)
			System.out.println("passed");
		list.rightToLeftPrint();
 }
 static void orderedLinkedListTest(){
	 	Random rand = new Random();
	 	Ordered_Linked_List<Integer> list = new Ordered_Linked_List<Integer>();
		System.out.println("size "+list.size());
		for(int j = 0; j< 1;j++){
			list = new Ordered_Linked_List<Integer>();
			for(int i =0;i<3160;i++){
				list.push(rand.nextInt(10000));
				if(i % 500 == 0)
					System.out.println("Passing "+i);
			}
		}
		list.printAscending();
		list.printDescending();
		System.out.println(list.checkIfOrdered());
		if(list.size() == 3160) System.out.println("Pass");
 }
}
