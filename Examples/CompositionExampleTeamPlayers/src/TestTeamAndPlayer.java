import java.util.ArrayList;
import java.util.List;

/*
 * This class tests the Team and Player classes using lists.
 */
public class TestTeamAndPlayer {

	public static void main(String[] args) {
		//The next set of statements assumes each Team will have
		//multiple players, so class Team2 is used instead of Team
		
		//create a list of teams
		List<Team> teamList = new ArrayList<Team>();
		
		//create a list of players
		List<Player> playerList = new ArrayList<Player>();

		//add players to the list
		playerList.add(new Player(1, "Donald", "P", 5000));
		playerList.add(new Player(2, "Goofy", "C", 4000));
		playerList.add(new Player(3, "Pluto", "1B", 3000));
		
		//add previous list of players to the first team
		teamList.add(new Team("Disney Boys", "Mickey", 2, playerList));
		
		//create another list of players
		playerList = new ArrayList<Player>();

		//add players to the list
		playerList.add(new Player(1, "Daisy", "P", 5500));
		playerList.add(new Player(2, "Clarabelle", "C", 4500));
		playerList.add(new Player(3, "Figaro", "1B", 3500));
		
		//add previous array of players to the second team
		teamList.add(new Team("Disney Girls", "Minnie", 1, playerList));
		
		//print the teams and their players
		for(Team t : teamList) {
			System.out.println(t.toString()); // calls toString() in Team class
		}

	}

}
