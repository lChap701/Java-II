import java.util.List;

/*
 * This is the Team class. Each Team will have a name, manager,
 * what place they are in, and a list of Players.
 * 
 * Composition is being demonstrated since a Team object is composed of 
 * another object (Player).
 */
public class Team {
	String teamName;
	String teamManager;
	int teamPlace;
	List<Player> teamPlayers;
	
	//getters
	public String getTeamName() {
		return teamName;
	}
	
	public String getTeamManager() {
		return teamManager;
	}
	
	public int getTeamPlace() {
		return teamPlace;
	}
	
	public List<Player> getTeamPlayer() {
		return teamPlayers;
	}
	
	//setters
	public void setTeamName(String name) {
		if(!name.isEmpty()) {
			teamName = name;
		}
		else {
			teamName = "Unknown";
		}
	}
	
	public void setTeamManager(String mgr) {
		if(!mgr.isEmpty()) {
			teamManager = mgr;
		}
		else {
			teamManager = "Unknown";
		}
	}	
	
	public void setTeamPlace(int place) {
		if(place >= 1 && place <= 30) {
			teamPlace = place;
		}
		else {
			teamPlace = 99;
		}
	}
	
	public void setTeamPlayer(List<Player> p) {
		if(p != null) {
			teamPlayers = p;
		}  // else left out on purpose

	}
	
	//default constructor
	//team players is intentionally left out
	public Team() {
		teamName = "Unknown";
		teamManager = "Unknown";
		teamPlace = 99;
	}
	
	//overloaded constructor
	public Team(String tName, String tMgr, int tPlace, List<Player> tPlayers) {
		setTeamName(tName);
		setTeamManager(tMgr);
		setTeamPlace(tPlace);
		setTeamPlayer(tPlayers);
	}

	@Override
	public String toString() {
		return "Team: " + teamName + "\n" + "Players: " + "\n" +
				teamPlayers.toString(); // calls toString() in Player class
				// when program is ran, it will print out like all data in []'s and separated by ,'s
				// to avoid this, use a foreach loop
	}
}
