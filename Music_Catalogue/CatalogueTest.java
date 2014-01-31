package ca.ubc.ece.eece210.mp3;

import java.io.IOException;

import org.junit.Test;

public class CatalogueTest {
	
	@Test
	public void testCalalogueCreation() throws IOException{
	Catalogue c = new Catalogue("./src/catalogue.txt");	
	System.out.println(c.albums.size());
	System.out.println(c.genres.size());
	System.out.println(c.genres.get(1).getStringRepresentation());
	//c.saveCatalogueToFile("");
	}
	@Test
	public void testCatalogueSave() throws IOException{
		Catalogue c = new Catalogue("./src/catalogue.txt");
		c.saveCatalogueToFile("./src/secondTestCatalogue.txt");
	}
	

}
