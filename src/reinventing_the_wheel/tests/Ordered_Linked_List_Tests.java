package reinventing_the_wheel.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import reinventing_the_wheel.Ordered_Linked_List;

public class Ordered_Linked_List_Tests {
	Ordered_Linked_List<Integer> list = null;
	@Before
	public void setUp() throws Exception {
		list = new Ordered_Linked_List<Integer>();
		
	}
	
	@Test
	public void testPush() {
		list.push(5);
		assertEquals(list.size(),1);
		list.push(1);
		list.push(10);
		list.push(8);
		assertEquals(list.size(),4);
		assertEquals((Integer)list.peek_head(),(Integer)1);
		assertEquals((Integer)list.peek_tail(),(Integer)10);
	}

//	@Test
//	public void testPrintDescending() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testPrintAscending() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetMax() {
		list.push(5);
		assertEquals(list.size(),1);
		list.push(1);
		list.push(10);
		list.push(8);
		assertEquals(list.size(),4);
		assertEquals((Integer)list.getMax().getValue(),(Integer)10);
		
	}

	@Test
	public void testGetMin() {
		list.push(5);
		assertEquals(list.size(),1);
		list.push(1);
		list.push(10);
		list.push(8);
		assertEquals(list.size(),4);
		assertEquals((Integer)list.getMin().getValue(),(Integer)1);
	}

	@Test
	public void testCheckIfOrdered() {
		list.push(5);
		assertEquals(list.size(),1);
		list.push(1);
		list.push(10);
		list.push(8);
		assertEquals(list.size(),4);
		assertEquals(list.checkIfOrdered(),true);
	}

}
