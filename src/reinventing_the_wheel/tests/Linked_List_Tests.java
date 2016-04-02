package reinventing_the_wheel.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import reinventing_the_wheel.Linked_List;
import reinventing_the_wheel.Linked_List.Node;

public class Linked_List_Tests {

	@Test
	public void testLinked_List() {
		Linked_List<Integer> list = new Linked_List<Integer>();
		assertNotEquals(list,null);
	}

	@Test
	public void testPush_head() {
		Linked_List<Integer> list = new Linked_List<Integer>();
		list.push_head(5);
		assertEquals(list.size(),1);
		assertEquals((Integer)list.peek_head(),(Integer)5);
	}

	@Test
	public void testPush_tail() {
		Linked_List<Integer> list = new Linked_List<Integer>();
		list.push_tail(5);
		assertEquals(list.size(),1);
		assertEquals((Integer)list.peek_tail(),(Integer)5);
	}

	@Test
	public void testFind() {
		Linked_List<Integer> list = new Linked_List<Integer>();
		list.push_tail(5);
		assertNotEquals(list.find(5),null);
		assertEquals(list.find(10),null);
	}

	@Test
	public void testRemove() {
		Linked_List<Integer> list = new Linked_List<Integer>();
		list.push_tail(5);
		assertNotEquals(list.find(5),null);
		assertEquals(list.remove(5),true);
		assertEquals(list.find(5),null);
		
	}

//	@Test
//	public void testLeftToRightPrint() {
//		Linked_List<Integer> list = new Linked_List<Integer>();
//		list.push_tail(5);
//	}
//
//	@Test
//	public void testRightToLeftPrint() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testSize() {
		Linked_List<Integer> list = new Linked_List<Integer>();
		list.push_tail(5);
		assertEquals(list.size(),1);
	}

	@Test
	public void testContains() {
		Linked_List<Integer> list = new Linked_List<Integer>();
		list.push_tail(5);
		assertEquals(list.size(),1);
		assertEquals(list.contains(5),true);
		assertEquals(list.contains(10),false);
	}

	@Test
	public void testRemoveHead() {
		Linked_List<Integer> list = new Linked_List<Integer>();
		list.push_head(5);
		list.push_head(25);
		assertEquals(list.size(),2);
		assertEquals((Integer)list.removeHead().getValue(),(Integer)25);
		assertEquals((Integer)list.peek_head(),(Integer)5);
		assertEquals(list.size(),1);
	}

	@Test
	public void testRemoveTail() {
		Linked_List<Integer> list = new Linked_List<Integer>();
		list.push_head(5);
		list.push_head(25);
		assertEquals(list.size(),2);
		assertEquals((Integer)list.removeTail().getValue(),(Integer)5);
		assertEquals((Integer)list.peek_tail(),(Integer)25);
		assertEquals(list.size(),1);
	}

	@Test
	public void testPeek_head() {
		Linked_List<Integer> list = new Linked_List<Integer>();
		list.push_head(5);
		assertEquals((Integer)list.peek_head(),(Integer)5);
	}

	@Test
	public void testPeed_tail() {
		Linked_List<Integer> list = new Linked_List<Integer>();
		list.push_head(5);
		assertEquals((Integer)list.peek_tail(),(Integer)5);
	}

//	@Test
//	public void testAddToCount() {
//		Linked_List<Integer> list = new Linked_List<Integer>();
//		list.push_head(5);
//		assertEquals(list.size(),1);
//		list.addToCount();
//		assertEquals(list.size(),2);
//	}

}
