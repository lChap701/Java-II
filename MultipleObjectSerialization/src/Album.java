import java.io.Serializable;
import java.util.List;

/**
 * Instantiable class used to create an Album object.
 * 
 * @author kthrockm
 * 
 */
public class Album implements Serializable {
	private String albumTitle;
	private String albumArtist;
	private String albumDate;
	
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

	//default constructor (no songs)
	public Album() {
		albumTitle = "Unknown";
		albumArtist = "Unknown";
		albumDate = "Unknown";	
	}
	
	//overloaded constructor
	/**
	 * 
	 * @param title title of the Album
	 * @param artist who created the Album
	 * @param date when the Album was released
	 */
	public Album(String title, String artist, String date) {
		setAlbumTitle(title);
		setAlbumArtist(artist);
		setAlbumDate(date);
	}

	public String toString() {
		String str = "Album: " + albumTitle + "\n" +
				"Artist: " + albumArtist + "\n" +
				"Date Released: " + albumDate + "\n";

		return str;
	}

}
