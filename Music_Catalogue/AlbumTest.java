package ca.ubc.ece.eece210.mp3;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;
public class AlbumTest {
	@Test
	public void testRestoreAlbumFromStringRepresentation(){
		Album a = new Album("First Album, MonoPhaze, -, [Blaba, Weeeoooo]");
		assertEquals("MonoPhaze", a.getPerformer());
		assertEquals("First Album", a.getTitle());
	}
	@Test
	public void createStringRepresentation(){
		ArrayList<String> songs = new ArrayList<String> ();
		songs.add("Blaba");
		songs.add("Weeeoooo");
		Album a = new Album("First Album", "MonoPhaze", songs);
		assertEquals("First Album, MonoPhaze, -, [Blaba, Weeeoooo]", a.getStringRepresentation());
	}
	@Test
	public void testgetPeformer(){
		
		Album a = new Album("Red", "Taylor Swift", new ArrayList<String>());
		assertEquals("Taylor Swift",a.getPerformer());
	}
		
	
	@Test
	public void testgetAlbumName(){
		Album a = new Album("Red", "Taylor Swift", new ArrayList<String>());
		assertEquals("Red",a.getTitle());
	}
	@Test
	public void testgetAlbumSongs(){
		ArrayList<String> songs = new ArrayList<String>();
		songs.add("Red");
		songs.add("I Knew You Were Trouble");
		songs.add("22");
		songs.add("The Lucky One");
		
		Album a = new Album("Red", "Taylor Swift", songs);
		assertEquals(songs, a.getSongs());
		

	}
	@Test
	public void testgetGenre(){
		Album a = new Album("Red", "Taylor Swift", new ArrayList<String>());
		Genre g = new Genre("Country");
		a.addToGenre(g);
		System.out.println(a.getGenre().toString());
		assertEquals(g,a.getGenre());	

	}
	@Test
	public void removeAlbumfromGenre() throws Exception{
		Genre g = new Genre("Country");
		Album a = new Album("Red, Taylor Swift, Country, [Red, 22]");
		g.addToGenre(a);
		a.removeFromGenre(g);
		assertEquals(0, g.getChildren().size());
	}


}
