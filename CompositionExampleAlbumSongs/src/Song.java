/*
 * This is the Song class. Each Song has a title and length.
 */
public class Song {	
	
	//instance variables
	private String songTitle;
	private double songLength;
	
	//getters
	public String getSongTitle() {
		return songTitle;
	}
		
	public double getSongLength() {
		return songLength;
	}
	
	//setters
	public void setSongTitle(String title) {
		if(!title.isEmpty()) {
			songTitle = title;
		}
		else {
			songTitle = "Unknown";
		}
	}	

	public void setSongLength(double len) {
		if(len > 0) {
			songLength = len;
		}
		else {
			songLength = 0;
		}
	}
	
	//default constructor
	public Song() {
		songTitle = "Unknown";
		songLength = 0;
	}
		
	//overloaded constructor
	public Song(String title, double len) {
		setSongTitle(title);
		setSongLength(len);
		
	}

	@Override	
	public String toString() {
		return "Song: " + songTitle + "\n" + "Length: " + songLength;
	}
}
