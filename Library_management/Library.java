package bibliothek210;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * 
 * The Library class represents a library,
 * with a collection of items and users.
 * 
 * The class includes methods for processing checkouts and returns
 * and other basic operations.
 *
 */

public class Library {
	
	// the list of items in the library
	private List<LibraryHolding> libraryItems;
	
	// the list of users
	private List<User> users;
	
	/**
	 * Default constructor that creates empty item and user lists.
	 */
	public Library( ) {
		libraryItems = new ArrayList<LibraryHolding>();
		users = new ArrayList<User>();
	}
	
	/**
	 * Obtain the number of users.
	 * 
	 * @return the number of users in the library system.
	 */
	public int getUserCount() {
		return users.size();
	}
	
	/**
	 * Obtain the number of items in the library.
	 * 
	 * @return the number of items in the library system.
	 */
	public int getItemCount() {
		return libraryItems.size();
	}

	/**
	 * Add a new user to the list of users.
	 * 
	 * @param user to add to the library user list
	 */
	public void addUser( User user ) {
		if(!isUser(user)){
		users.add( user );
		}
	}
	
	/**
	 * Checks if a user is part of this library system
	 * @param user to be tested for
	 * @return true of the user is part of the library's user list,
	 * otherwise return false
	 */
	public boolean isUser( User user ) {
		
		return users.contains( user );
	}
	
	/**
	 * Remove a user from the library's user list
	 * 
	 * @param user to be removed
	 */
	public void removeUser( User user ) {
		if(users.contains(user))
		{
		users.remove( user );
		}
	}
	
	/**
	 * Add an item to the library's collection
	 * 
	 * @param item to be added
	 */
	public void addItem( LibraryHolding item ) {
		if(!libraryItems.contains(item))
		libraryItems.add( item );
	}
	
	/**
	 * Return the number of items that have been checked out
	 * @return number of checked out items
	 */
	public int getCheckedoutCount( ) {
		int counter = 0;
		for (LibraryHolding item : libraryItems) {
			if(item.getStatus() == HoldingStatus.CheckedOut ) {
				counter++;
			}
		}
		return counter;
	}
	
	/**
	 * 
	 * @param contentType is a string that represents the item type
	 * @return the number of library items that match the content type
	 */
	public int getContentTypeCount( String contentType ) {
		int counter = 0;
		String className = "class bibliothek210." + contentType;
		for(LibraryHolding item: libraryItems){
			if(item.getClass().toString().equals(className)) {
				counter++;
			}
		}
		return counter;
	}
	
	/**
	 * Process an item checkout
	 * 
	 * @param item being checked out
	 * @param user who is checking the item out
	 * @return true if the checkout succeeded, false otherwise.
	 * If the checkout is successful then the state of the item 
	 * changes to CheckedOut and the user is added to the item
	 * as its current holder. Similarly the item is added to the 
	 * list of items in the user's possession.
	 */
	public boolean checkout( LibraryHolding item, User user ) {
		
			if(libraryItems.contains(item)) {
				if(item.checkOut(user)) {
					try {
						user.addToList(item);
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					return true;
				}
			}
		return false;
	}
	
	/**
	 * Process an item checkout given the item's ID and the user's ID
	 * @param holdingID of item being checked out
	 * @param userID of user who is checking the item out
	 * @return true if the checkout succeeded, false otherwise.
	 * If the checkout is successful then the state of the item 
	 * changes to CheckedOut and the user is added to the item
	 * as its current holder. Similarly the item is added to the 
	 * list of items in the user's possession.
	 */
	public boolean checkout( int holdingID, int userID ) {
		  
		LibraryHolding item = libraryItems.get(holdingID);
		User user = users.get(userID);
		
			if(item != null && user!=null) {
						
				if(item.checkOut(user))	{
					try{
						user.addToList(item);
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					
				}
			}
		return false;
	}
	
	
	/**
	 * @param item which is being returned
	 * @return true if return succeeded, false otherwise.
	 *  If return is successful and item is OnHold 
	 *  then state of item changes to OnHold.
	 *  if return is successful and item is not OnHold 
	 *  then state of item changes to Available.
	 *  The current user and due date are removed from the item. 
	 */
	public boolean processReturn( LibraryHolding item ) {
		if(libraryItems.contains(item))
		{
			if (item.processReturn())
				return true;
		}
		return false;
	}
	
	/**
	 * Process an item's return given the item's ID
	 * @param holdingID of item being returned 
	 * @return true if return succeeded, false otherwise.
	 *  If return is successful and item is OnHold 
	 *  then state of item changes to OnHold.
	 *  if return is successful and item is not OnHold 
	 *  then state of item changes to Available.
	 *  The current user and due date are removed from the item. 
	 */
	public boolean processReturn( int holdingID ) {
		
		LibraryHolding item = libraryItems.get(holdingID);
		
		if(libraryItems.contains(item))
		{
			if (item.processReturn())
				return true;
		}

		return false;
	}

}
