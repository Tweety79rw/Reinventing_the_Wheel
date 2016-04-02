package reinventing_the_wheel.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import reinventing_the_wheel.Queue;

public class QueueTests {

	@Test
	public void testEnqueue() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(5);
		assertEquals(queue.size(),1);
		assertEquals((Integer)queue.peek(),(Integer)5);
	}

	@Test
	public void testDequeue() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(5);
		assertEquals(queue.size(),1);
		assertEquals((Integer)queue.dequeue().getValue(),(Integer)5);
		assertEquals(queue.size(),0);
	}

	@Test
	public void testPeek() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(5);
		assertEquals(queue.size(),1);
		assertEquals((Integer)queue.peek(),(Integer)5);
	}

}
