/*
 * This program demonstrates how to deserialize (input)
 * objects into to a list
 */

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class TestObjectDeSerialization {

    static List<Song> songList = new ArrayList<Song>();
    static List<Album> albumList = new ArrayList<Album>();
    static List<Object> objectList = new ArrayList<Object>();

	public static void main(String[] args) {
		String filename = "music.ser";
		FileInputStream inFile;
        ObjectInputStream inStream;

        // Deserialization
        try
        {
        	inFile = new FileInputStream(filename); 
            inStream = new ObjectInputStream(inFile);

            // read objects as a list and add to a generic object list
            // must use this technique if objects were written
            // to file as lists versus individual objects
            while(inFile.available() > 0) {
                objectList.add(inStream.readObject());	//get the list object
            }
            inStream.close();
            inFile.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error reading music file");
        }

        //put each generic object list into the Album and Song lists
        albumList = (List<Album>) objectList.get(0);
        songList = (List<Song>) objectList.get(1);

        //print the entire list of albums
        for (Album a : albumList) {
            System.out.println(a.toString());
        }

        //print the entire list of songs
        for (Song s : songList) {
            System.out.println(s.toString());
        }

	}

}
