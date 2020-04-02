import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * adds a list of objects from Song class and album to a file
 */
public class TestObjectSerialization {
    static List<Song> songList = new ArrayList<>();
    static List<Album> albumList = new ArrayList<>();

    public static void main(String[] args) {
        String filename = "songs.ser";
        FileOutputStream fileOut;
        ObjectOutputStream objectOut;

        // adds new album objects
        albumList.add(new Album("Foreigner", "Foreigner", "03/07/1977"));
        albumList.add(new Album("Queen's Best Hits", "Queen", "11/20/1985"));
        albumList.add(new Album("Death", "Who Are You Again?", "99/99/9999"));

        // adds new songs for Songs Foreigner
        songList.add(new Song("Cold As Ice", 3.23));
        songList.add(new Song("Feels Like The First Time", 4.0));
        songList.add(new Song("Starrider", 3.34));
        songList.add(new Song("Hot Blooded", 3.03));
        // adds new songs for Queen
        songList.add(new Song("Bohemian Rhapsody", 5.59));
        songList.add(new Song("Killer Queen", 3.0));
        songList.add(new Song("Somebody To Love", 5.0));
        // adds new songs for Who Are You Again?
        songList.add(new Song("You Will Forget This Song In One Minute", 1.0));
        songList.add(new Song("Who Even Listens To This?", 60.0));

        // foreach loop for albums that prints one object at a time
        for (Album a : albumList) {
            System.out.println(a.toString());
        }

        // foreach loop for songs that prints one object at a time
        for (Song s : songList) {
            System.out.println(s.toString());
        }

        // Serialization of Song objects to the file
        try {
            // will save objects to files
            fileOut = new FileOutputStream(filename);
            objectOut = new ObjectOutputStream(fileOut);

            // writes each object individually for Album
            /*for (Object o : albumList) {
                objectOut.writeObject(o);
            }*/

            // writes an entire array of albums
            objectOut.writeObject(albumList); // if used, will have to be prepared to write list as an entire list

            // writes each object individually for Song
            /*for (Object o : songList) {
                objectOut.writeObject(o);
            }*/

            // writes an entire array of songs
            objectOut.writeObject(songList); // if used, will have to be prepared to write list as an entire list

            // in this order
            objectOut.close();
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Error in writing objects to file has occurred" + e.getMessage());
        }
    }
}
