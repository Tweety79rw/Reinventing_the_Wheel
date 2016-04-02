package reinventing_the_wheel.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import reinventing_the_wheel.Stack;

public class StackTests {

	@Test
	public void testPush() {
		Stack<Integer> stack = new Stack<Integer>();
		assertEquals(stack.size(),0);
		stack.push(5);
		assertEquals(stack.size(),1);
		assertEquals((Integer)stack.peek_head(),(Integer)5);
	}

	@Test
	public void testPop() {
		Stack<Integer> stack = new Stack<Integer>();
		assertEquals(stack.size(),0);
		stack.push(5);
		assertEquals(stack.size(),1);
		assertEquals((Integer)stack.pop().getValue(),(Integer)5);
		assertEquals(stack.size(),0);
	}

}
