import java.util.ArrayList;
import java.util.List;

public class SongListProgram {

    // lists are dynamic, do not declare size
    static List<Song> songList = new ArrayList<>();

    public static void main(String[] args){
        Song sample = new Song();
        songList.add(sample); // adds this sample to be part of the list

        sample = new Song("Hurricane", 3.45);
        songList.add(sample);

        // prints out all object in list in one statement
        System.out.println(songList.toString());

        // loop that prints out all objects one at a time
        for (Song s : songList) {
            System.out.println(s.toString());
        }

        // remove an item
        songList.remove(0);
        System.out.println(songList.toString());
    }
}
