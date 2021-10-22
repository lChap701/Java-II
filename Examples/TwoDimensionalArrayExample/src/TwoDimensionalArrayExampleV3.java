import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TwoDimensionalArrayExampleV3 {

    public static void main(String[] args) {
        String[][] rankings;
        int rows = 5, cols = 2;
        rankings = new String[rows][cols];
        int[][] points = new int[5][2];

        boolean isFound = false;
        String iName;
        int r;

        init(rankings, points); // referring to the address of the array so can use different names as parameters

        //prompt for player name
        iName = JOptionPane.showInputDialog("Enter player name: ");

        //search array for player name
        for (r = 0; r < rankings.length; r++) {
            if (iName.trim().toUpperCase().equals(rankings[r][0].toUpperCase())) {
                isFound = true;
                break;
            }

        }

        if (isFound) {
            JOptionPane.showMessageDialog(null, "Player " + rankings[r][0] + " has reached "
                    + "Quests: " + points[r][0] + "\nAG Points: " + points[r][1]);
        } else {
            JOptionPane.showMessageDialog(null, "Player " + iName + " not found");
        }
    }

    public static void init(String[][] rank, int[][] pts) { // parameters used to pass rankings and points
        //build array from player_stats file
        loadArrays(rank, pts);

        //other tasks would go here
    }

    public static void loadArrays(String[][] rankings, int[][] points) {
        String record;
        String[] fields;
        Scanner playerScanner;
        boolean eof = false;
        File file = new File("players_stats.dat");

        try {
            playerScanner = new Scanner(file);
            int row = 0;
            //looks for data in file, stops when data is not found
            if(playerScanner.hasNext()) {
                while (!eof) {
                    record = playerScanner.nextLine();
                    // reads each record and splits based on ,
                    fields = record.split(",");
                    rankings[row][0] = fields[0];
                    rankings[row][1] = fields[1];
                    points[row][0] = Integer.parseInt(fields[2]);
                    points[row][1] = Integer.parseInt(fields[3]);
                    row++;          //continues loop
                    if (!playerScanner.hasNext())
                        eof = true;
                }
                JOptionPane.showMessageDialog(null,"Player stat file loaded has been ok");
            }
            else {
                JOptionPane.showMessageDialog(null,"Player stat file empty, aborting " +
                        "program");
            }
        } catch (FileNotFoundException e) {
           JOptionPane.showMessageDialog(null, "Player stat file not found, program " +
                   "aborting");
           System.exit(1);
        }
    }
}
