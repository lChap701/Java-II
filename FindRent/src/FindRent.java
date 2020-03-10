import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FindRent {
    public static void main(String[] args) {
        int[][] rents = new int[4][3];

        loadArray(rents);

        int maxFloors = rents.length - 1;
        int maxBedroom = rents[0].length - 1;

        int floor = floor(maxFloors);
        int bedrooms = bedrooms(maxBedroom);
        output(rents, floor, bedrooms);
    }

    public static void loadArray(int[][] rents) {
        String record;
        String[] fields;

        Scanner playerScanner;
        boolean eof = false;

        File file = new File("rents_dat.dat");

        try {
            playerScanner = new Scanner(file);
            int row = 0;
            //looks for data in file, stops when data is not found
            if (playerScanner.hasNext()) {
                while (!eof) {

                    record = playerScanner.nextLine();
                    // reads each record and splits based on ,
                    fields = record.split(",");
                    rents[row][0] = Integer.parseInt(fields[0]);
                    rents[row][1] = Integer.parseInt(fields[1]);
                    rents[row][2] = Integer.parseInt(fields[2]);
                    row++;          //continues loop
                    if (!playerScanner.hasNext())
                        eof = true;
                }
                JOptionPane.showMessageDialog(null, "Rent file loaded has been ok");
            }
            else {
                JOptionPane.showMessageDialog(null, "Rent file empty, aborting " +
                        "program");
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Rent file not found, program " +
                    "aborting");
            System.exit(1);
        }
    }

    public static void output(int[][] rents, int floor, int bedrooms) {
        JOptionPane.showMessageDialog(null,
                "The rent for a " + bedrooms +
                        " bedroom apartment on floor " + floor +
                        " is $" + rents[floor][bedrooms]);
    }

    public static int bedrooms(int maxBedrooms) {
        int bedrooms;
        String entry = JOptionPane.showInputDialog(null,
                "Enter number of bedrooms ");
        bedrooms = Integer.parseInt(entry);

        try {
            if (bedrooms < 0 || bedrooms > maxBedrooms) {
                JOptionPane.showMessageDialog(null, "Bedrooms must be between 0 - " + maxBedrooms +
                        ", defaulted to zero");
                bedrooms = 0;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Bedrooms must be a whole number, defaulted to " +
                    "zero");
        }
        return bedrooms;
    }

    public static int floor(int maxFloors) {
        String entry;
        int floor = 0;
        try {
            entry = JOptionPane.showInputDialog(null, "Enter a floor number ");
            floor = Integer.parseInt(entry);

            if (floor < 0 || floor > maxFloors) {
                JOptionPane.showMessageDialog(null, "Floor must 0 - " + maxFloors + ", defaulted" +
                        "to zero");
                floor = 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Floor must be a whole number");
        }
        return floor;
    }


}
   