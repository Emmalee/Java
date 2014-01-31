package bibliothek210;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testOneUser( ) {
		
		User user = new User( "Sathish" );
		assertEquals( true , user.getName( ).equals("Sathish") );
	}
	
	@Test
	public void test2( ) {
		
		User user = new User( "Sathish" );
		Book book = new Book( "Test", "Test Author" );
		Book book2 = book;
		try {
			user.addToList( book );
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals( true, user.hasItem( book2 ));
	}

}
