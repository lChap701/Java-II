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

	public static void main(String[] args) {
		String filename = "songs.ser";
		FileOutputStream outFile;
        ObjectOutputStream outStream;

  		//add songs to the song list
  		songList.add(new Song("Cold as Ice", 3.23));
        songList.add(new Song("Feels Like the First Time", 4.0));
        songList.add(new Song("Starrider", 3.34));
        songList.add(new Song("Double Vision", 4.25));

        //print the list of songs, one object at a time
        for(Song s : songList) {
            System.out.println(s.toString());
        }

		// Serialization of Song objects to the file
        try{    
            //Saving of object in a file 
            outFile = new FileOutputStream(filename); 
            outStream = new ObjectOutputStream(outFile); 
              
            // write each object individually 
            /*for(Object o : songList) {
            	outStream.writeObject(o);
            }*/
            
            // write the objects as an entire array
            outStream.writeObject(songList);
            
            outStream.close(); 
            outFile.close();               
          
         } 
        catch(Exception ex){ 
            System.out.println("Error writing songs to file" + ex.getMessage()); 
        }

	}

}
