package ca.ubc.ece.eece210.mp3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Container class for all the albums and genres. Its main 
 * responsibility is to save and restore the collection from a file.
 */
public final class Catalogue {

	public ArrayList<Album> albums;
    public ArrayList<Genre> genres;

 /**
 * Builds a new, empty catalogue.
 */
    
	public Catalogue() {
		albums = new ArrayList<Album>();
		genres = new ArrayList<Genre>();
	}

	/**
	 * Builds a new catalogue and restores its contents from the 
	 * given file.
	 * 
	 * @param fileName
	 *            the file from where to restore the library.
	 * @throws IOException 
	 */
	public Catalogue(String fileName) throws IOException {
		albums = new ArrayList<Album>();
		genres = new ArrayList<Genre>();
		
		FileReader fReader = new FileReader(fileName);
		BufferedReader bReader = new BufferedReader(fReader);
		String line = null;
		
		while ((line = bReader.readLine()) != null && !line.equals("genres:")) {
            if(!line.equals("albums:"))
                    albums.add(new Album(line.trim()));
		}
		while((line = bReader.readLine())!= null) {
            genres.add(Genre.restoreCollection(line.trim()));
		}
		bReader.close();
}
	

	/**
	 * Saved the contents of the catalogue to the given file.
	 * @param fileName the file where to save the library
	 * @throws IOException 
	 */
	public void saveCatalogueToFile(String fileName) throws IOException {
      FileWriter open = new FileWriter(fileName, false);
      BufferedWriter writer = new BufferedWriter(open);
      writer.write("albums:");
      writer.newLine();
      for(Album a : albums){
              writer.write(a.getStringRepresentation());
              writer.newLine();
      }
      writer.write("genres:");
      writer.newLine();
      for(Genre g: genres) {
              writer.write(g.getStringRepresentation());
              writer.newLine();
      }
      writer.close();
      }

	}
