import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Deserializes objects into a list
 */
public class TestObjectDeSerialization {
    static List<Song> songList = new ArrayList<>();
    static List<Album> albumList = new ArrayList<>();
    static List<Object> objectsList = new ArrayList<>();

    public static void main(String[] args) {
        String filename = "songs.ser";
        FileInputStream fileIn;
        ObjectInputStream objectIn;

        // Deserialization
        try {
            fileIn = new FileInputStream(filename);
            objectIn = new ObjectInputStream(fileIn);

            // reads all objects as a list to add to another list
            // must be used if objects are already written
            // adds to file versus adding individual objects
            while (fileIn.available() > 0) {
                objectsList.add(objectIn.readObject());  // gets objects
            }

            // reads all objects in file
            // used if objects are not written
            // used if you wrote objects to file using foreach loop
            /*while(fileIn.available() > 0){ // available() refers to bytes
                // can write if statement to check type of each object
                Object o = objectIn.readObject();   // reads object
                System.out.println(o.toString());
            }*/

            /*// reads entire array
            songList = (List<Song>) objectIn.readObject();*/

            objectIn.close();
            fileIn.close();
        } catch (Exception e) {
            System.out.println("Error in reading objects has occurred");
        }
        // puts generic objects in object list in Album and Song lists
        albumList = (List<Album>) objectsList.get(0);
        songList = (List<Song>) objectsList.get(1);

         /*// prints entire list if what above is not needed
        System.out.println(songList.toString());*/

        // prints entire list of albums
        for (Album a : albumList) {
            System.out.println(a.toString());
        }

        // prints entire list of songs
        for (Song s : songList) {
            System.out.println(s.toString());
        }
    }

}
