package ca.ubc.ece.eece210.mp3;

import java.util.*;

/**
 * An abstract class to represent an entity in the catalogue. The element (in this
 * implementation) can either be an album or a genre.
 * 
 * @author Sathish Gopalakrishnan
 * 
 */
public abstract class Element {

	/**
	 * Returns all the children of this entity. They can be albums or
	 * genres. In this particular application, only genres can have
	 * children. Therefore, this method will return the albums or genres
	 * contained in this genre.
	 * 
	 * @return the children
	 */
	protected List <Element> children;
	
	public List<Element> getChildren() {
		if(this.hasChildren())
		return children;
		
			return null;
		}
	

	/**
	 * Adds a child to this entity. Basically, it is adding an album or genre
	 * to an existing genre
	 * 
	 * @param b
	 *            the entity to be added.
	 * @throws Exception 
	 */
	protected void addChild(Element b) throws Exception {
		// TODO implement this (should throw an exception if trying to add
		// to a leaf object);
		if(b instanceof Genre){
			
			Genre g = (Genre)b;
			if(!g.children.contains(this)){
				children.add(b);
			}
			else
				throw new Exception("Genre Already Exists");
			
		}
		else{
			Genre g = (Genre)this;
			if(g.parent != null){
				Genre parentGenre = g.parent;
				if(!parentGenre.children.contains(b)){
					children.add(b);
				}
				else
					throw new Exception("This album already has a Genre");
			}
			if(hasChildren()){
				children.add(b);
			}
			else{
				throw new Exception("Cannot add genre to a subgenre");
				}
		}
	}
	

	/**
	 * Abstract method to determine if a given entity can (or cannot) contain
	 * any children.
	 * 
	 * @return true if the entity can contain children, or false otherwise.
	 */
	public abstract boolean hasChildren();
}