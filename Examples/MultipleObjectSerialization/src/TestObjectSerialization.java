/*
 * This program demonstrates how to serialize (output)
 * a list of objects from an instantiable class
 */

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestObjectSerialization {

    static List<Song> songList = new ArrayList<>();
    static List<Album> albumList = new ArrayList<>();
    static List<Object> objectList = new ArrayList<Object>();

	public static void main(String[] args) {
		String filename = "music.ser";
		FileOutputStream outFile;
        ObjectOutputStream outStream;

        //add albums to the album list
        albumList.add(new Album("Foreigner", "Foreigner", "03/08/1977"));
        albumList.add(new Album("Styx", "Grand Illusion", "07/07/1977"));
        albumList.add(new Album("REO Speedwagon", "High Infedelity", "07/07/1980"));

  		//add Foreigner's songs to the song list
  		songList.add(new Song("Cold as Ice", 3.23));
        songList.add(new Song("Feels Like the First Time", 4.0));
        songList.add(new Song("Starrider", 3.34));
        songList.add(new Song("Double Vision", 4.25));
        //add Styx's songs to the song list
        songList.add(new Song("Grand Illusion", 3.40));
        songList.add(new Song("Come Sail Away", 4.40));
        songList.add(new Song("Fooling Yourself", 3.99));
        //add REO's songs to the song list
        songList.add(new Song("Take It on the Run", 3.30));
        songList.add(new Song("Keep on Loving You", 4.12));

        //print the list of albums, one object at a time
        for(Album a : albumList) {
            System.out.println(a.toString());
        }

        //print the list of songs, one object at a time
        for(Song s : songList) {
            System.out.println(s.toString());
        }


		// Serialization of Album and Song objects to the file
        try{    
            //Saving of object in a file 
            outFile = new FileOutputStream(filename); 
            outStream = new ObjectOutputStream(outFile); 

            // write the album objects as an entire list
            outStream.writeObject(albumList);

            // write the song objects as an entire list
            outStream.writeObject(songList);

            outStream.close(); 
            outFile.close();               
          
         } 
        catch(Exception ex){ 
            System.out.println("Error writing music data to file" + ex.getMessage());
        }

	}

}
