package ca.ubc.ece.eece210.mp3;
import java.util.*;
/**
 * Represents a genre (or collection of albums/genres).
 * 
 * 
 */
public final class Genre extends Element {
	
	public String name;
	public Genre parent;
	/**
	 * Creates a new genre with the given name.
	 * 
	 * @param name
	 *            the name of the genre.
	 */
	public Genre(String name) {
		this.children = new ArrayList<Element>();
		this.name = name;
	}

	/**
	 * Restores a genre from its given string representation.
	 * 
	 * @param stringRepresentation
	 */
	public static Genre restoreCollection(String stringRepresentation) {
		String[] split1 = stringRepresentation.split("\\;");
		String GenreName = split1[0];
		Genre genre = new Genre(GenreName.trim());
		String split2[] = split1[1].split("\\{");
		String SubGenres = split2[0];
		String Albums = split2[1];
		String[] subgenreArray = SubGenres.trim().split(",");
		
		for(int i=0; i<subgenreArray.length; i++){
			genre.addToGenre(new Genre(subgenreArray[i].trim()));
		}
		String[] AlbumArray = Albums.split("~");
		
		for(int i=0; i<AlbumArray.length-1; i++){
			Album album = new Album(AlbumArray[i].trim());
			album.addToGenre(genre);
		}
		return genre;
	}

	/**
	 * Returns the string representation of a genre
	 * 
	 * @return string which is the string representation of a genre 
	 */
	public String getStringRepresentation() {
		
		StringBuilder str = new StringBuilder();
		str.append(name +"; ");
		for(Element g : children){
			if(g instanceof Genre){
				str.append(((Genre) g).name + ", ");
			}
		}
		str.append("{");
		for(Element a : children){
			if(a instanceof Album){
				str.append(((Album) a).getStringRepresentation() + " ~ ");
			}
		}
		str.append("}");
		return str.toString();
	}

	/**
	 * Adds the given album or genre to this genre
	 * 
	 * @param b
	 *            the element to be added to the collection.
	 */
	public void addToGenre(Element b) {
		try{
			addChild(b);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}

	/**
	 * Returns true, since a genre can contain other albums and/or
	 * genres.
	 */
	@Override
	public boolean hasChildren() {
		return true;
	}
}