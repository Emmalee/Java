package ca.ubc.ece.eece210.mp3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GenreTest {
	@Test
	public void addAlbumToGenre(){
		Genre g = new Genre("Country");
		Album a = new Album("Red, Taylor Swift, Country, [Red, 22]");
		g.addToGenre(a);
		assertEquals("Red, Taylor Swift, Country, [Red, 22]", g.getChildren().toString());
	}
	
	@Test
	public void getStringRepresentationTest1(){
		ArrayList<String> songs = new ArrayList<String>();
		songs.add("Red");
		songs.add("I Knew You Were Trouble");
		songs.add("22");
		songs.add("The Lucky One");
		Album a = new Album("Red", "Taylor Swift", songs);
		Genre g = new Genre("Country");
		Genre subGenre = new Genre("Chill Country");
		a.addToGenre(g);
		g.addToGenre(subGenre);
		//System.out.println(g.getStringRepresentation());
	}
	@Test
	public void getStringRepresentationTest2(){
		ArrayList<String> songs = new ArrayList<String>();
		songs.add("Red");
		songs.add("I Knew You Were Trouble");
		songs.add("22");
		songs.add("The Lucky One");
		Album a = new Album("Red", "Taylor Swift", songs);
		Genre g = new Genre("Rock");
		Genre subGenre = new Genre("Pop Rock");
		a.addToGenre(g);
		g.addToGenre(subGenre);
		Album b = new Album("Ride the Lighting, Metallica, -, [Ride the Lighting, Fade to Black]");
		b.addToGenre(g);
		//System.out.println(g.getStringRepresentation());
	}
	@Test
	public void testRestoreCollectionFromStringRepresentation(){
		ArrayList<String> songs1 = new ArrayList<String>();
		songs1.add("Red");
		songs1.add("I Knew You Were Trouble");
		
		ArrayList<String> songs2 = new ArrayList<String>();
		songs2.add("Fearless");
		songs2.add("You Belong With Me");
		
		Album a = new Album("Red", "Taylor Swift", songs1);
		Album b = new Album("Fearless", "Taylor Swift", songs2);
		
		Genre g = new Genre("Country");
		g.addToGenre(a);
		g.addToGenre(b);
		Genre subGenre1 = new Genre("Country Pop");
		Genre subGenre2 = new Genre("Soft Country");
		
		g.addToGenre(subGenre1);
		g.addToGenre(subGenre2);
		
		//System.out.println(g.getStringRepresentation());
}
	@Test
	public void testRestoreGenreFromStringRepresentation(){
		Genre g = Genre.restoreCollection("Country; Country Pop, Soft Country, {Red, Taylor Swift, -, [Red, I Knew You Were Trouble] ~ Fearless, Taylor Swift, -, [Fearless, You Belong With Me] ~ }");
		assertEquals("Country; Country Pop, Soft Country, {Red, Taylor Swift, Country, [Red, I Knew You Were Trouble] ~ Fearless, Taylor Swift, Country, [Fearless, You Belong With Me] ~ }", g.getStringRepresentation());
	
		//System.out.println(g.getStringRepresentation());
}
	@Test
	public void testaddingParentGenretoSubGenre(){
		Genre g = new Genre("Country");
		Genre subGenre = new Genre("Country Pop");
		g.addToGenre(subGenre);
		subGenre.addToGenre(g);
	}
	@Test 
	public void testAddingNewGenreToSubgenre(){
		Genre g = new Genre("Country");
		Genre subGenre1 = new Genre("Country Pop");
		Genre subGenre2 = new Genre("Soft Country");
		g.addToGenre(subGenre1);
		subGenre1.addToGenre(subGenre2);
		assertEquals("Country Pop; Soft Country, {}", subGenre1.getStringRepresentation());
	}
}

