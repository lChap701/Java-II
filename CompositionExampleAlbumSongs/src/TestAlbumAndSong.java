import java.util.ArrayList;
import java.util.List;

/*
 * This class tests the Album and Song classes.
 */
public class TestAlbumAndSong {

	//create an empty list of Albums
	static List<Album> albumList = new ArrayList<Album>();

	//create an empty list of songs
	static List<Song> songList = new ArrayList<Song>();

	public static void main(String[] args) {

		//add Foreigner's songs to the song list
		songList.add(new Song("Cold as Ice", 3.23));
		songList.add(new Song("Feels Like the First Time", 4.0));
		songList.add(new Song("Starrider", 3.34));
		songList.add(new Song("Double Vision", 4.25));

		//add Foreigner's album to the list using the previous songs
		albumList.add(new Album("Foreigner Alive", "Foreigner", "07/31/1977", songList)); // sonList added to add songs

		//create an empty list of songs
		songList = new ArrayList<Song>(); // needs instantiated in order to get rid of previous values

		//add Styx's songs to the song list
		songList.add(new Song("Grand Illusion", 3.40));
		songList.add(new Song("Come Sail Away", 4.40));
		songList.add(new Song("Fooling Yourself", 3.99));

		//add Styx's album to the list using the previous songs
		albumList.add(new Album("Styx", "Grand Illusion", "07/07/1977", songList));

		//create an empty list of songs
		songList = new ArrayList<Song>();

		//add REO's songs to the song list
		songList.add(new Song("Take It on the Run", 3.30));
		songList.add(new Song("Keep on Loving You", 4.12));

		//add REO's album to the list using the previous songs
		albumList.add(new Album("REO Speedwagon", "High Infedelity", "07/07/1980", songList));

		//print each album and it's songs
		for(Album a : albumList) {
			System.out.println(a.toString()); // calls toString in Album class
			// format() works like println() but uses format characters
			System.out.format("Album length is: %.2f\n", a.CalcAlbumLength()); // calls method in Album class
			System.out.println("Longest song of " + a.getAlbumTitle() + ": " +
					a.FindLongestSong().getSongTitle() + " " +
					a.FindLongestSong().getSongLength() + "\n\n");
		}
		
	}

}
