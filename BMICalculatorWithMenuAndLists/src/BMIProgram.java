import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Lucas Chapman 3/24/2020
 * This class calculates the users' BMI and allows users to add patients to a file (meaning their added to a list)
 * and will print out the results as a report to the console by using a list with patients stored in it
 */
public class BMIProgram {
    private static Scanner myScanner;
    static List<BMI> bmiList = new ArrayList<>();

    public static void main(String[] args) {
        int iOpt = 0;
        BMI[] bmi = new BMI[100];

        init();

        while (iOpt != 4) {
            for (int x = 0; x < bmi.length; x++) {
                try {
                    iOpt = opt();

                    switch (iOpt) {
                        case 1:
                            opt1(bmi, iOpt, x);
                            break;
                        case 2:
                            opt2(bmi, iOpt, x);
                            break;
                        case 3:
                            opt3();
                            break;
                        case 4:
                            opt4();
                            x = 100;    // exits for loop
                            break;
                        default:
                            System.out.println("Invalid option, press Enter again");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid option, press Enter try again");
                }
                myScanner.nextLine();
            }
        }
    }

    /**
     * Creates a new Scanner object and prints out a welcome message
     */
    public static void init() {
        myScanner = new Scanner(System.in);
        fileSetUp();
        System.out.println("Welcome to BMI Calculator");
    }

    /**
     * Creates the file storing all objects, uses InputStream variables to read file, then reads file
     */
    public static void fileSetUp() {
         try {
            String filename = "BMI.dat";
            FileInputStream inputFile = new FileInputStream(filename);
            ObjectInputStream inputObject = new ObjectInputStream(inputFile);

            while (inputFile.available() > 0) {
                Object o = inputObject.readObject();
                bmiList = (List<BMI>) o;    // reads any objects in file
            }

            // Checks if list is empty
            if (bmiList.isEmpty()) {
                System.out.println("File is empty");
            } else {
                System.out.println("File was read");
            }

            inputObject.close();
            inputFile.close();

        } catch (FileNotFoundException ex) {
             System.out.println("Error, file was not found");
        } catch (EOFException ex) {
             System.out.println("File is empty");
        } catch (Exception e) {
             System.out.println("Error, unable to read file");  // printed if any other exceptions are caught
        }
    }

    /**
     * Collects the option that the user selected
     * @return returns the option selected to be stored in another variable
     */
    public static int opt() {
        int opt;
        String data;

        System.out.println("Please enter an option: \n1 - Use metric system\n2 - Use standard system\n3 - " +
                "Display all users\n4 - Exit program");
        data = myScanner.nextLine();
        opt = Integer.parseInt(data);

        return opt;
    }

    /**
     * Method that calls other methods related to only Option 1
     * @param bmi passes the length of the array to be used in for loop
     * @param x passes value of x to be added back into the array
     * @param iOpt passes value of iOpt to be used when creating a new object
     */
    public static void opt1(BMI[] bmi, int x, int iOpt) {
        System.out.println("You selected Option 1, press Enter to continue");
        myScanner.nextLine();

        int iHeight = metHeight();
        int iWeight = metWeight();
        String iFirstName = firstName();
        String iLastName = lastName();
        bmi[x] = new BMI(iWeight, iHeight, iOpt, iFirstName, iLastName);
        String oName = iFirstName.concat(" " + iLastName);  // combines first and last name into one variable
        System.out.println(oName + "'s " + bmi[x].toString() + "\nPress Enter to continue");
        myScanner.nextLine();
        addToFile(oName, bmi, x);
    }

    /**
     * Collects the height in centimeters
     * @return returns a valid height
     */
    public static int metHeight() {
        int height = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.println("Please enter a height in centimeters (cm): ");
                String input = myScanner.nextLine();
                height = Integer.parseInt(input);
                isValid = true;
            } catch (Exception e) {
                System.out.println("Height cannot contain any decimals and has to be numeric, press Enter to " +
                        "try again");
                myScanner.nextLine();
            }
        }
        if (height <= 0) {
            System.out.println("Invalid, the height you entered will be defaulted to 170 cm\nPress Enter to " +
                    "continue");
        } else {
            System.out.println("You entered: " + height + " cm, press Enter to continue");
        }
        myScanner.nextLine();

        return height;
    }

    /**
     * Collects the weight entered by user in kilograms
     * @return returns a valid weight
     */
    public static int metWeight() {
        int weight = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.println("Please enter a weight in kilograms (kg): ");
                String input = myScanner.nextLine();
                weight = Integer.parseInt(input);
                isValid = true;
            } catch (Exception e) {
                System.out.println("Weight cannot contain any decimals and has to be numeric, press Enter to " +
                        "try again");
                myScanner.nextLine();
            }
        }
        if (weight <= 0) {
            System.out.println("Invalid, the weight you entered will be defaulted to 70 kg\nPress Enter to " +
                    "continue");
        } else {
            System.out.println("You entered: " + weight + " kg, press Enter to continue");
        }
        myScanner.nextLine();

        return weight;
    }

    /**
     * Collects what user enters for first name
     * @return returns value stored in first name
     */
    public static String firstName() {
        System.out.println("Enter a first name: ");
        String firstName = myScanner.nextLine();

        if (firstName.isEmpty()) {
            firstName = "John";
            System.out.println("Nothing was entered, the first name you entered will be defaulted to " +
                    firstName + "\nPress Enter to continue");
        } else {
            System.out.println("You entered: " + firstName + ", press Enter to continue");
        }
        myScanner.nextLine();

        return firstName;
    }

    /**
     * Collects what user enters for last name
     * @return returns value stored in last name
     */
    public static String lastName() {
        System.out.println("Enter a last name: ");
        String lastName = myScanner.nextLine();

        if (lastName.isEmpty()) {
            lastName = "Doe";
            System.out.println("Nothing was entered, the last name you entered will be defaulted to " + lastName +
                    "\nPress Enter to continue");
        } else {
            System.out.println("You entered: " + lastName + ", press Enter to continue");
        }
        myScanner.nextLine();

        return lastName;
    }

    /**
     * Module that is called to ask the user if they want to add a patient to the file
     * @param oName passes the value you in oName to this method
     * @param bmi passes the value in bmi to this method
     * @param x passes the value in x to this method
     */
    public static void addToFile(String oName, BMI[] bmi, int x) {
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.println("Do you want to add patient to file?\nY or N?");
                char input = myScanner.nextLine().toUpperCase().charAt(0);

                // Forces the user to have to enter a Y for a yes or an N for no
                if (input == 'Y') {
                    bmiList.add(bmi[x]);
                    System.out.println(oName + " was added to file\nPress Enter to continue");
                    isValid = true;
                } else if (input == 'N') {
                    System.out.println(oName + " was not added to file\nPress Enter to continue");
                    isValid = true;
                } else {
                    System.out.println("Error, press Enter to try again");
                    myScanner.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Error, press Enter to try again");
                myScanner.nextLine();
            }
        }
    }

    /**
     * Method that calls other methods that are only used for Option 2
     * @param bmi passes the length of the array to be used in for loop
     * @param x passes value of x to be added back into the array
     * @param iOpt passes value of iOpt to be used when creating a new object
     */
    public static void opt2(BMI[] bmi, int iOpt, int x) {
        System.out.println("You selected Option 2, press Enter to continue");
        myScanner.nextLine();

        int iHeight = standHeight();
        int iWeight = standWeight();
        String iFirstName = firstName();
        String iLastName = lastName();
        bmi[x] = new BMI(iWeight, iHeight, iOpt, iFirstName, iLastName);
        String oName = iFirstName.concat(" " + iLastName);
        System.out.println(oName + "'s " + bmi[x].toString() + "\nPress Enter to continue");
        myScanner.nextLine();
        addToFile(oName, bmi, x);
    }

    /**
     * Collects the height in inches that the user entered
     * @return returns the valid height
     */
    public static int standHeight() {
        int height = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.println("Please enter a height in inches (in): ");
                String input = myScanner.nextLine();
                height = Integer.parseInt(input);
                isValid = true;
            } catch (Exception e) {
                System.out.println("Height cannot contain any decimals and has to be numeric, press Enter to try " +
                        "again");
                myScanner.nextLine();
            }
        }
        if (height <= 0) {
            System.out.println("Invalid, the height you entered will be defaulted to 170 in\nPress Enter to " +
                    "continue");
        } else {
            System.out.println("You entered: " + height + " in, press Enter to continue");
        }
        myScanner.nextLine();

        return height;
    }

    /**
     * Collects that weight in pounds that was entered by the user
     * @return returns the valid weight
     */
    public static int standWeight() {
        int weight = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.println("Please enter a weight in pounds (lbs): ");
                String input = myScanner.nextLine();
                weight = Integer.parseInt(input);
                isValid = true;
            } catch (Exception e) {
                System.out.println("Weight cannot contain any decimals and has to be numeric, press Enter to try " +
                        "again");
                myScanner.nextLine();
            }
        }
        if (weight <= 0) {
            System.out.println("Invalid, the weight you entered will be defaulted to 70 lbs\nPress Enter to " +
                    "continue");
        } else {
            System.out.println("You entered: " + weight + " lbs, press Enter to continue");
        }
        myScanner.nextLine();

        return weight;
    }

    /**
     * Method that calls all other methods related to Option 3
     */
    public static void opt3() {
        System.out.println("You selected Option 3, press Enter to continue");
        myScanner.nextLine();

        print();
    }

    /**
     * Displays/prints all stored data as a report
     */
    public static void print() {
        String colHdgs = String.format("%-26s%5s%-6s%5s%-7s%5s%-8s%5s%-4s%5s%-11s%n", "Name", " ", "Height", " ",
                "Weight", " ", "Type", " ", "BMI", " ", "Status");
        System.out.println(colHdgs);

        // Loop that prints all BMI objects in bmiList
        for (BMI b : bmiList) {
            // Gets a patient's BMI
            double cBMI = b.calcs(); // result will always be rounded by one decimal place

            // Combines first and last name with a comma into one variable
            String oName = b.getLastName().concat(", " + b.getFirstName());

            // Finds the correct option based if what was entered was a 1 or 2
            // Finds the correct symbol to display with weight and height based on what option was selected
            String oOption, oWeight, oHeight;
            if (b.getOption() == 1) {
                oOption = "Metric";
                oWeight = b.getWeight() + " kg ";   // space after the kg added to line up with lbs in report
                oHeight = b.getHeight() + " cm";
            } else {
                oOption = "Standard";
                oWeight = b.getWeight() + " lbs";
                oHeight = b.getHeight() + " in";
            }

            // Finds the correct status based on the BMI that was calculated earlier
            String oStatus;
            if (cBMI < 18.5) {
                oStatus = "Underweight";
            } else if (cBMI >= 18.5 && cBMI < 25) {
                oStatus = "Normal";
            } else if (cBMI >= 25 && cBMI < 30) {
                oStatus = "Overweight";
            } else {
                oStatus = "Obesity";
            }

            String record = String.format("%-26s%5s%6s%5s%7s%5s%-8s%5s%4.1f%5s%-11s", oName, " ", oHeight, " ",
                    oWeight, " ", oOption, " ", cBMI, " ", oStatus);
            System.out.println(record);
        }
        System.out.println("\nPress Enter to return to Menu");
    }

    /**
     * Module that calls the writeToFile() module when Option 4 is selected
     */
    public static void opt4() {
        System.out.println("You have chosen to exit the program, note that any changes made to file will be " +
                "saved after closing this program\nTo continue, press Enter");
        writeToFile();
    }

    /**
     * Writes all objects to file
     */
    public static void writeToFile() {
        try {
            String filename = "BMI.dat";
            FileOutputStream outputFile = new FileOutputStream(filename);
            ObjectOutputStream outputObject = new ObjectOutputStream(outputFile);

            outputObject.writeObject(bmiList);

            outputObject.close();
            outputFile.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Error, file was not found");
        } catch (Exception e) {
            System.out.println("Error, unable to write file");  // printed if any other exceptions are caught
        }
    }
}