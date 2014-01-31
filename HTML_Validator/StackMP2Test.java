import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class StackMP2Test {
	
	/*
	 * PushPeek Test
	 * Checks if push() and peek() work by seeing if
     * peek() returns the first HtmlTag pushed to it, and
     * that the stack isn't empty
	 */
	@Test
	public void PushPeektest() {
		StackMP2 myStack = new StackMP2();
		HtmlTag testTag = new HtmlTag("<b>");
		myStack.push(testTag);
		assertEquals(testTag,myStack.peek());
	}

	/*
     * popTest 
     * tests to see that StackMP2 pop() returns the most recent HtmlTag push to it 
     */
	@Test
	public void Poptest(){
		StackMP2 myStack = new StackMP2();
		HtmlTag testTag = new HtmlTag("<i>");
		myStack.push(testTag);
		assertEquals(testTag,myStack.pop());
        assertEquals(true,myStack.isEmpty());
        assertNotNull(testTag);	
	}
	
	/*
	 *isEmptyTest
     * checks that isEmpty returns true if the
     * stack is empty
	 */
	
	@Test
	public void TestIsEmpty(){
        StackMP2 testStack = new StackMP2();
        
        assertEquals(true,testStack.isEmpty());
	}
	
	@Test
    public void nullTagTest() {
		HtmlTag testTag = null;
        StackMP2 testStack = new StackMP2();
               
        try {testStack.push(testTag);}
        catch (IllegalArgumentException e)
        {
         // test successful; IllegalArgumentException caught
        }
       }
}