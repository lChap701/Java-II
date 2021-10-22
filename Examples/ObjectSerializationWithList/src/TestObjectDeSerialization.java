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

	public static void main(String[] args) {
		String filename = "songs.ser";
		FileInputStream inFile;
        ObjectInputStream inStream;

        // Deserialization
        try
        {
        	inFile = new FileInputStream(filename); 
            inStream = new ObjectInputStream(inFile); 
            
            // read objects individually until end of file
        	/*while(inFile.available() > 0) {
        	    //if logic to determine what type of object is being read in
        		Object o = inStream.readObject();	//get the object        		
    			System.out.println(o.toString());        		
        	}*/
            
            // read the objects as an entire array
            songList = (List<Song>) inStream.readObject();
              
            inStream.close(); 
            inFile.close();               
           
        } 
          
        catch(Exception ex) 
        { 
            System.out.println("Error reading Song file"); 
        } 
          
        //print the entire list of songs
        System.out.println(songList.toString());

        /*for(Album a : newAlbums) {
        	System.out.println(a.toString());
        }*/

  
	}

}
