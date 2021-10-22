import javax.swing.*;

public class TwoDimensionalArrayExample {

    static String[][] rankings = {
            {"ivan", "King"},
            {"Gantic", "King"},
            {"Reton8", "King"},
            {"AmyCline", "Queen"},
            {"RYMM", "Prince"}
        };

    static int[][] points = {
            {1115, 39720},
            {1057, 38865},
            {1115, 36935},
            {1022, 30735},
            {1030, 30550}
        };

    public static void main(String[] args) {
        boolean isFound = false;
        String iName;
        int r;

        //prompt for player name
        iName = JOptionPane.showInputDialog("Enter player name: ");

        //search array for player name
        for (r = 0; r < rankings.length; r++) {
            if (iName.trim().toUpperCase().equals(rankings[r][0].toUpperCase())) {
                isFound = true;
                break;
            }

        }

        if(isFound){
            JOptionPane.showMessageDialog(null, "Player " + rankings[r][0] + " has reached "
                + "Quests: " + points[r][0] + "\nAG Points: " + points[r][1]);
        }
        else {
            JOptionPane.showMessageDialog(null, "Player " + iName + " not found");
        }
    }

}
