/*
 *@author: Emmalee Roach
 * Implementation of a simple stack for HtmlTags.
 */

import java.util.ArrayList;
import java.util.*;

public class StackMP2 {
	// An ArrayList to hold HtmlTag objects.
	// Use this to implement StackMP2.
	private ArrayList<HtmlTag> stack_internal;
	
	/*
	 * Create an empty stack.
	 */
	public StackMP2( ) {
		this.stack_internal = new ArrayList<HtmlTag>( );
	}
	
	/* 
	 * Push a tag onto the top of the stack.
	 */
	public void push( HtmlTag tag ) {
		stack_internal.add(tag);
	}
	
	/*
	 * Removes the tag at the top of the stack.
	 * Should throw an exception if the stack is empty.
	 */
	public HtmlTag pop( ) {
		if(stack_internal.isEmpty()) {
			throw new IllegalArgumentException("The Stack is Empty");
		}
		HtmlTag h = stack_internal.get(stack_internal.size()-1);
		stack_internal.remove(stack_internal.size()-1);
		return h;
	}
	
	/*
	 * Looks at the object at the top of the stack but does not actually remove the object. 
	 * Should throw an exception if the stack is empty.
	 */
	public HtmlTag peek( ) {
		if(stack_internal.isEmpty()) {
			throw new IllegalArgumentException("The Stack is Empty");
		}
		return stack_internal.get(stack_internal.size() - 1);
	}
	
	/*
	 * Tests if the stack is empty.
	 * Returns true if the stack is empty; false otherwise.
	 */
	public boolean isEmpty( ) {
		return stack_internal.isEmpty();
		
	}
}
