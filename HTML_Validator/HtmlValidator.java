
import java.util.*;
/*
 * @author: Emmalee Roach
 * This is the HtmlValidator class. 
 */

public class HtmlValidator {
	
	private static Queue<HtmlTag> tags;
	
	public HtmlValidator(Queue<HtmlTag> htmltags) {
		HtmlValidator.tags = htmltags;
	}
	//@Override default constructor
	public HtmlValidator(){
		tags = HtmlTag.tokenize("");
	}
	
	/**
     * Adds a tag to the queue for a HtmlValidator object
     * @param tag: The HtmlTag to be added to the Queue
     */
	public void addTag(HtmlTag tag){
		if(tag!=null)
		tags.add(tag);
		else{
			throw new IllegalArgumentException("No HtmlTag to add");
		}	
	}
	/**
     * @return Queue<HtmlTag>: the queue of HtmlTag's that validator contains
     */
	public Queue<HtmlTag> getTags(){
		return tags;
	}
	
	/**
	 * removes any tags from the validator's queue that match the given element 
	 * @param element to remove from the queue
	 */
	public void removeAll(String element){
		for(HtmlTag h: tags){
			if(h.toString().equals(element)){
				tags.remove(h);
			}
		}
	}
	
	/**
	 * examines a sequence of HTML tags and determines if it represents a valid sequence of tags
	 * prints an indented text representation of the HTML tags in the queue
	 */
	public void validate() {
		int indent = 0;
		StackMP2 stack = new StackMP2();
		
		for(HtmlTag h: tags){
			
			if(stack.isEmpty() & !h.isOpenTag()) {
				System.out.println("Error unexpected tag: " + h.toString());
				continue;
			}
				
			if(!h.isOpenTag()){
				
				if(h.matches(stack.peek())) {
					for(int j=0; j<indent-1; j++){
						System.out.print("    ");
					}
					System.out.println(h.toString());
					stack.pop();
					indent--;
				}
				else {
					System.out.println("Error unexpected tag: " + h.toString());
				}
				
				}
	
			
			else {
				
				for( int i=0; i <indent ; i++) {
					System.out.print("    ");
				}
				
				System.out.println(h.toString());
				if(!h.isSelfClosing()) {
					stack.push(h);
					indent++;
				}
			}
		}
		while(!stack.isEmpty()) {
			System.out.println("Error unclosed tag: " + stack.pop().toString());
		}
	}
}
