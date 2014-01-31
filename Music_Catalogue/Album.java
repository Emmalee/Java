package ca.ubc.ece.eece210.mp3;
import java.util.*;
	public final class Album extends Element {
			private String performer;
			private String title;
			private ArrayList<String> songlist;
			private Genre genre;
		/**
	         * Builds an album with the given title, performer and song list
	         * 
	         * @param title
	         *            the title of the album
	         * @param author
	         *            the performer 
	         * @param songlist
	         *                           the list of songs in the album
	         */
	        public Album(String title, String performer, ArrayList<String> songlist) {
	        	this.title = title;
	        	this.performer = performer;
	        	this.songlist = songlist;
	        }

	        /**
	         * Builds an album from the string representation of the object. It is used
	         * when restoring an album from a file.
	         * 
	         * @param stringRepresentation
	         *            the string representation
	         */
	        public Album(String stringRepresentation) {
	        	
	        	songlist = new ArrayList<String>();
	        	String replacement = stringRepresentation.replaceAll("\\[|\\]", "");
	        	String[] array = replacement.trim().split(",");
	        	title = array[0].trim();
	        	performer = array[1].trim();
	        	if(array[2].trim().equals("-")){
	        		genre = null;
	        	}
	        	else{
	        		genre = new Genre(array[2].trim());
	        	}
	        	for(int i=3; i < array.length; i++){
	        	
	        		songlist.add(array[i].trim());
	        	}
	        		        
	        }

	        /**
	         * Returns the string representation of the given album. The representation
	         * contains the title, performer and songlist, as well as all the genre
	         * that the book belongs to.
	         * 
	         * @return the string representation
	         */
	        public String getStringRepresentation() {
	             
	        	 int i = 1;
	        	
	        	StringBuilder str = new StringBuilder();
                str.append(title + ", ");
                str.append(performer + ", ");
                if(this.getGenre() != null){
                	str.append(this.getGenre().name + ", ");
                }	
                	else{
                		str.append("-, ");
                	
                }
                str.append("[");
              
                for(String song :songlist){
                	if(i != songlist.size())
                		str.append( song + ", ");
                	else
                		str.append(song);
                	i = i + 1;
                }
                str.append("]");     
	        	return str.toString(); 
	        }
	        
	       

	        /**
	         * Add the album to the given genre
	         * 
	         * @param genre
	         *            the genre to add the album to.
	         */
	        public void addToGenre(Genre genre) {
	                genre.addToGenre(this);
	                this.genre = genre;
	        }
	        
	        /**
	         * Removes the album from the given genre
	         * 
	         * @param genre the genre to remove the album from
	         */
	        public void removeFromGenre(Genre genre) throws Exception{
	        	if(this.genre == null){
	        		throw new Exception("Album does not contain Genre");
	        	}
	        	if(this.genre.name.equals(genre.name)){
	        		if (genre.children.contains(this)){
	        			genre.children.remove(this);
	        		}
	        		this.genre = null;
	        	}
	        	else{
	        		throw new Exception("Album does not contain Genre");
	        	}
	        }
	        
	        /**
	         * Returns the genre that this album belongs to.
	         * 
	         * @return the genre that this album belongs to
	         */
	        public Genre getGenre() {
	                if(genre == null)
	                	return null;
	                return genre;
	        }
	        

	        /**
	         * Returns the title of the album
	         * 
	         * @return the title
	         */
	        public String getTitle() {
	                return title;
	        }
	        public ArrayList<String> getSongs(){
	        	return songlist;
	        }

	        /**
	         * Returns the performer of the album
	         * 
	         * @return the performer
	         */
	        public String getPerformer() {
	                return performer;
	        }

	        /**
	         * An album cannot have any children (it cannot contain anything).
	         */
	        @Override
	        public boolean hasChildren() {
	                return false;
	        }
	}
