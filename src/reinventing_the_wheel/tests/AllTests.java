package reinventing_the_wheel.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Binary_Tree_Tests.class, Linked_List_Tests.class,
		Ordered_Linked_List_Tests.class, QueueTests.class, StackTests.class })
public class AllTests {

}
