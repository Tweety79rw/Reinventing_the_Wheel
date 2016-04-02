package reinventing_the_wheel.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import reinventing_the_wheel.Binary_Tree;

public class Binary_Tree_Tests {
	Binary_Tree<Integer> tree = null;
	@Before
	public void setUp() throws Exception {
		tree = new Binary_Tree<Integer>();
		tree.insert(5);
	}
	
	@Test
	public void testBinary_Tree() {
		assertNotEquals(tree,null);
	}

	@Test
	public void testInsert() {
		assertEquals(tree.size(),1);
		assertEquals((Integer)tree.search(5).getValue(),(Integer)5);
	}

	@Test
	public void testSearch() {
		assertEquals(tree.size(),1);
		assertEquals((Integer)tree.search(5).getValue(),(Integer)5);
	}

//	@Test
//	public void testInOrderPrint() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testPreorderPrint() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testPostOrderPrint() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testRemove() {
		assertEquals(tree.size(),1);
		assertEquals((Integer)tree.search(5).getValue(),(Integer)5);
		assertEquals(tree.remove(5),true);
		assertEquals(tree.size(),0);
	}

}
