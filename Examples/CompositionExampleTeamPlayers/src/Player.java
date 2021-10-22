/*
 * This is the Player class. Each Player has a number, name,
 * position and salary.
 */
public class Player {	
	
	//instance variables
	int playerNum;
	String playerName;
	String playerPosition;
	double playerSalary;
	
	//getters
	public int getPlayerNumber() {
		return playerNum;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public String getPlayerPosition() {
		return playerPosition;
	}
	
	public double getPlayerSalary() {
		return playerSalary;
	}
	
	//setters
	public void setPlayerNumber(int num) {
		if(num >= 0 && num <= 98) {
			playerNum = num;
		}
		else {
			playerNum = 99;
		}
	}
	
	public void setPlayerName(String name) {
		if(!name.isEmpty()) {
			playerName = name;
		}
		else {
			playerName = "Unknown";
		}
	}	

	public void setPlayerPosition(String pos) {
		if(!pos.isEmpty()) {
			playerPosition = pos;
		}
		else {
			playerPosition = "";
		}
	}
	
	public void setPlayerSalary(double sal) {
		if(sal > 0) {
			playerSalary = sal;
		}
		else {
			playerSalary = 0;
		}
	}
	
	//default constructor
	public Player() {
		playerNum = 99;
		playerName = "Unknown";
		playerPosition = "";
		playerSalary = 0;
	}
		
	//overloaded constructor
	public Player(int num, String name, String pos, double sal) {
		setPlayerNumber(num);
		setPlayerName(name);
		setPlayerPosition(pos);
		setPlayerSalary(sal);
	}

	@Override
	public String toString() {
		return "Player: " + playerName + "  Position: " + playerPosition + "\n";
	}
}
