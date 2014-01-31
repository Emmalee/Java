package bibliothek210;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private static int nextUserId = 1;
	private final String name;
	private final int userId;
	private List<LibraryHolding> itemList;
	
	/**
	 * Constructor for a user object.
	 *  
	 * @param name: user's name
	 * @returns nothing but automatically sets the UserId using the next valid id number.
	 */
	public User( String name ) {
		userId = nextUserId;
		nextUserId++;
		this.name = name;
		itemList = new ArrayList<LibraryHolding>( );
	}
	
	/**
	 * Gets the user's name.
	 * 
	 * @return name
	 */
	public String getName( ) {
		return name;
	}
	
	/**
	 * Gets the user's identification number.
	 * 
	 * @return userId
	 */
	public int getUserId( ) {
		return userId;
	}
	
	/**
	 * Add an item to the user's list of checked out items.
	 * 
	 * @param item: item that is added to the user's list
	 * of checked out items. Requires that the item be checked out to
	 * the user.
	 * @throws Exception 
	 */
	public void addToList( LibraryHolding item ) throws Exception {
		
		if(!itemList.contains(item)) {
		itemList.add( item );
		}
		else {
			if (itemList.contains(item)){
				throw new Exception( "item already added to user's list of checked out items");
			}
		}
	}
	/**
	 * Check if the user has an item.
	 * @param item: check if this item is in the user's list of checked out items
	 * @return true if the item is in the list and false otherwise
	 */
	public boolean hasItem( LibraryHolding item ) {
		for(LibraryHolding i : itemList){
			if (i.equals(item)){
				if(i.getStatus() != HoldingStatus.CheckedOut)
					break;
				else
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Process an item's return for a user by removing the item from
	 * the user's list of checked out items.
	 * 
	 * @param item: item that is being returned by the user.
	 * @return true if the item was correctly returned, false otherwise.
	 */
	public boolean processReturn( LibraryHolding item ) {
	
		if(!(item.getStatus() == HoldingStatus.CheckedOut)){
			itemList.remove(item);
			return true;
		}
		
		return false;
	}
}
