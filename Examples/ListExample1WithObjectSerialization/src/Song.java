import java.io.Serializable;

/**
 * Instantiable class
 * Must have implements Serializable to persist objects
 */
public class Song implements Serializable {
    // instance variables
    private String songTitle;
    private double songLength;

    // getters
    public String getSongTitle() {
        return songTitle;
    }

    public double getSongLength() {
        return songLength;
    }

    // setters
    public void setSongTitle(String t){
        if (!t.isEmpty()) {
            songTitle = t;
        } else {
            songTitle = "Unknown";
        }
    }

    public void setSongLength(double l) {
        if (l > 0) {
            songLength = l;
        } else {
            songLength = 1;
        }
    }

    // default constructor
    public Song() {
        songTitle = "Unknown";
        songLength = 1;
    }

    // overload constructor
    public Song(String t, double l) {
        setSongTitle(t);
        setSongLength(l);
    }

    @Override
    public String toString(){
        return "Song: " + getSongTitle() + " Length: " + getSongLength();
    }
}
