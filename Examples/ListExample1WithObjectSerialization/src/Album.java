import java.io.Serializable;

/**
 * Instantiable class for Album objects
 */
public class Album implements Serializable {
    // instance variables
    private String albumTitle;
    private String albumArtist;
    private String albumDate;

    // getters
    public String getAlbumTitle() {
        return albumTitle;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public String getAlbumDate() {
        return albumDate;
    }

    // setters
    public void setAlbumTitle(String t) {
        albumTitle = t;

        if (t.isEmpty()) {
            albumTitle = "Unknown";
        }
    }

    public void setAlbumArtist(String a) {
        albumArtist = a;

        if (a.isEmpty()) {
            albumArtist = "Unknown";
        }
    }

    public void setAlbumDate(String d) {
        albumDate = d;

        if (d.isEmpty()) {
            albumDate = "Unknown";
        }
    }

    // default constructor
    public Album(){
        albumTitle = "Unknown";
        albumArtist = "Unknown";
        albumDate = "Unknown";
    }

    // overloaded constructor
    public Album(String t, String a, String d){
        setAlbumTitle(t);
        setAlbumArtist(a);
        setAlbumDate(d);
    }

    public String toString() {
        return "Album: " + getAlbumTitle() + "\nArtist: " + getAlbumArtist() + "\nDate Released: " +
                getAlbumDate() + "\n";
    }
}
