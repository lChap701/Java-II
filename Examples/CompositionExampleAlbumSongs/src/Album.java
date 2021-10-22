import java.util.List;

/*
 * This is the Album class. Each Album will have a title, artist name,
 * date released, and a list of of Songs.
 * 
 * Composition is being demonstrated since a Album object is composed of 
 * another object (list of Songs).
 */
public class Album {
	private String albumTitle;
	private String albumArtist;
	private String albumDate;
	private List<Song> albumSongs; // contains the list of Song objects from the Song class
	
	//getters
	public String getAlbumTitle() {
		return albumTitle;
	}
	
	public String getAlbumArtist() {
		return albumArtist;
	}
	
	public String getAlbumDate() {
		return albumDate;
	}
	
	public List<Song> getAlbumSongs() {
		return albumSongs;
	}
	
	//setters
	public void setAlbumTitle(String title) {
		if(!title.isEmpty()) {
			albumTitle = title;
		}
		else {
			albumTitle = "Unknown";
		}
	}
	
	public void setAlbumArtist(String artist) {
		if(!artist.isEmpty()) {
			albumArtist = artist;
		}
		else {
			albumArtist = "Unknown";
		}
	}	
	
	public void setAlbumDate(String date) {
		if(!date.isEmpty()) {
			albumDate = date;
		}
		else {
			albumDate = "Unknown";
		}
	}
	
	public void setAlbumSongs(List<Song> s) {
		if(!(s == null)) {
			albumSongs = s;
		}		
	}
	
	//default constructor (no players)
	public Album() {
		albumTitle = "Unknown";
		albumArtist = "Unknown";
		albumDate = "Unknown";	
	}
	
	//overloaded constructor
	public Album(String title, String artist, String date, List<Song> songs) {
		setAlbumTitle(title);
		setAlbumArtist(artist);
		setAlbumDate(date);
		setAlbumSongs(songs);
	}

	@Override
	public String toString() {
		String str = "Album: " + albumTitle;
		
		if(!(albumSongs == null)) {
			for(Song s : albumSongs) {
				str += ("\n" + s.toString()); // calls toString() in Song class
			}
		}

		return str;
	}

	/**
	 * gets length of song by adding the songLength from the Songs class to length
	 * @return returns the length of an album
	 */
	public double CalcAlbumLength() {
		double length = 0;
		
		if(!(albumSongs == null)) {
			for(Song s : albumSongs) {
				length += (s.getSongLength());			
			}
		}
		
		return length;
	}

	/**
	 * Gets a song from an album and checks to see if the song is greater than the length of a previous song. then sets
	 * the value of that song to the longestSong object
	 * @return returns a Song object that is considered the longest song
	 */
	public Song FindLongestSong() {
		Song longestSong = new Song();
		
		if(!(albumSongs == null)) { // checks if albumSongs contains any songs
			longestSong = albumSongs.get(0); // gets first song in list
			for(int i = 1; i < albumSongs.size(); i++) { // loops through all the objects in albumSong
				if(albumSongs.get(i).getSongLength() > longestSong.getSongLength()) {
					longestSong = albumSongs.get(i); // sets the value of song longer than previous song to longestSong
				}
			}
		}
		return longestSong;
	}
}
