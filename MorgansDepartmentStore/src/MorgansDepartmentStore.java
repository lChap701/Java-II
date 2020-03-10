import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Lucas Chapman on 2/24/20
 * This program is a employee bonus calculator created for Morgans Department Store. The bonuses are based off each
 * employee's monthly paycheck amount and their status (part time or full time). This program also allows users to enter
 * and display data for a employee, as well as allow the user to display all available data for every employee. Bonuses
 * are calculated based off a dat file that contains valid pay check amounts and valid rates for a full time and part
 * time employee.
 */
public class MorgansDepartmentStore {
    // Scanner that is used to collect input data
    private static Scanner myScanner;
    // one dimensional array that obtains values after data file is loaded and read
    private static double[][] empBonus = new double[4][3];
    // a two dimensional array that stores the employee's first and last name and status
    private static String[][] empInfo = new String[10][3];
    // a one dimensional array that stores the employee's valid paycheck amount, and rates for their status
    private static double[] empPayAmt = new double[10];

    public static void main(String[] args) {
        byte iOpt = 0;

        init();

        while (iOpt != 4) {
            try {
                iOpt = opt();

                switch (iOpt) {
                    case 1:
                        opt1();
                        break;
                    case 2:
                        opt2();
                        break;
                    case 3:
                        opt3();
                        break;
                    case 4:
                        System.out.println("You have chosen to exit the program, press Enter to continue");
                        break;
                    default:
                        System.out.println("Invalid option, press Enter to continue");
                }
            } catch (Exception e) {
                System.out.println("Invalid option, you must enter a number");
            }
            myScanner.nextLine();
        }
    }

    /**
     * Module that initializes the Scanner that collects input data and calls loadEmpBonus method
     */
    public static void init () {
        myScanner = new Scanner(System.in);
        loadEmpBonus();
        System.out.println("Welcome to Morgan's Department Store's Employee Calculator!");
    }

    /**
     * Reads dat file and moves values from each row to a two dimensional array called empBonus
     */
    public static void loadEmpBonus() {
        Scanner bonusScanner;
        boolean eof = false;
        File f = new File("employee_bonus.dat");


        System.out.println("Loading file...");
        try {
            bonusScanner = new Scanner(f);

            if (bonusScanner.hasNext()) {
                int rows = 0;
                while (!eof) {
                    String record;
                    String[] fields;

                    record = bonusScanner.nextLine();
                    fields = record.split(",");
                    empBonus[rows][0] = Double.parseDouble(fields[0]);
                    empBonus[rows][1] = Double.parseDouble(fields[1]);
                    empBonus[rows][2] = Double.parseDouble(fields[2]);
                    empBonus[rows][0] = Double.parseDouble(fields[0]);
                    empBonus[rows][1] = Double.parseDouble(fields[1]);
                    empBonus[rows][2] = Double.parseDouble(fields[2]);
                    empBonus[rows][0] = Double.parseDouble(fields[0]);
                    empBonus[rows][1] = Double.parseDouble(fields[1]);
                    rows++;
                    if (!bonusScanner.hasNext()) {
                        eof = true;
                    }
                }
                System.out.println("File loaded" + "\n");
            } else {
                System.out.println("File empty, program unable to run properly \nPlease restart program");
                System.exit(1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found \nProgram closed");
            System.exit(1);
        }
    }

    /**
     * Module that collects the data entered for option and stores it in another variable in the main method
     * @return returns the option that was selected and stores it in iOpt up in the main method
     */
    public static byte opt() {
        byte opt;
        System.out.println("Please enter an option:"+"\n1 - Enter Employee Data"+"\n2 - Display All Employees"+ "\n3 " +
                "- Display A Single Employee"+"\n4 - Exit The Program");
        String data = myScanner.nextLine();
        opt = Byte.parseByte(data);
        return opt;
    }

    /**
     * Module for when Option 1 is selected that call other modules that are suppose to be a part of Option 1
     */
    public static void opt1() {
        char input = 'Y';

        System.out.println("You selected Option 1, press Enter to continue");
        myScanner.nextLine();

        // for loop that is used to help prevent user from entering more than 10 employees
        for (int i= 0; i < empInfo.length; i++) {
            if (input != 'N') {
                empFirstName(i);
                empLastName(i);
                empPayCheck(i);
                empStatus(i);
                input = empContinue(i);
            } else {
                System.out.println("Exiting Option 1\nPress Enter to continue");
                i = 10;
            }
        }
    }

    /**
     * Module used to collect data entered for a employee's first name and stores that data in a two dimensional array
     * after validation
     * @param x used to store data in an array based on the value of i in the for loop in the opt1 method
     */
    public static void empFirstName(int x) {
        String iFirstName;
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Enter a first name:");
            iFirstName = myScanner.nextLine();

            if (iFirstName.trim().isEmpty()) {
                System.out.println("A first name is required, press Enter to try again");
            } else {
                empInfo[x][0] = iFirstName;
                System.out.println("You entered " + empInfo[x][0] + "\nPress Enter to continue");
                isValid = true;
            }
            myScanner.nextLine();
        }
    }

    /**
     * Module used to collect data entered for a employee's last name and stores that data in a two dimensional array
     * after validation
     * @param x used to store data in an array based on the value of i in the for loop in the opt1 method
     */
    public static void empLastName(int x) {
        String iLastName;
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Enter a last name:");
            iLastName = myScanner.nextLine();

            if (iLastName.trim().isEmpty()) {
                System.out.println("A last name is required and a last name should only contain letters, press " +
                        "Enter to try again");
            } else {
                empInfo[x][1] = iLastName;
                System.out.println("You entered " + empInfo[x][1] + "\nPress Enter to continue");
                isValid = true;
            }
            myScanner.nextLine();
        }
    }

    /**
     * Module that collects the data entered for a employee's paycheck amount and checks if data is valid by using a one
     * dimensional array with the valid maximum amount a paycheck can be, then any valid data is stored in a different
     * one dimensional array
     * @param x used to store data in an array based on the value of i in the for loop in the opt1 method
     */
    public static void empPayCheck(int x) {
        double iPayCheck;
        boolean isValid = false;
        String moneyPattern = "$#,##0.00";
        DecimalFormat payCheck = new DecimalFormat(moneyPattern);

        while (!isValid) {
            try {
                System.out.println("Enter employee's pay check amount from $0.01 to $9,999.99:");
                String input = myScanner.nextLine();
                iPayCheck = Double.parseDouble(input);

                boolean minPayCheck =  iPayCheck >= 0.01 || iPayCheck >= 100.01 || iPayCheck >= 300.01 ||
                        iPayCheck >= 500.01;
                for (double[] bonus : empBonus) {
                    if (iPayCheck <= bonus[0] && minPayCheck) {
                        if (input.matches("[0-9]{0,4}[.]?[0-9]{0,2}")) { // checks if data has up to 2 decimal places
                            isValid = true;
                            break;
                        }
                    }
                }

                if (isValid) {
                    empPayAmt[x] = iPayCheck;
                    String oPayCheckAmt = payCheck.format(empPayAmt[x]);
                    System.out.println("You entered " + oPayCheckAmt + "\nPress Enter to continue");
                } else {
                    System.out.println("The amount that was entered is invalid, press Enter to try again");
                }

            } catch (Exception e) {
                System.out.println("Data entered is not numeric, press Enter to try again");
            }
            myScanner.nextLine();
        }
    }

    /**
     * Module used to collect what data is entered for a employee's status and checks to see if that data is PT or FT,
     * then will add data that is valid to a two dimensional array
     * @param x used to store data in an array based on the value of i in the for loop in the opt1 method
     */
    public static void empStatus(int x) {
        String iStatus;
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Please enter the employee's status\nPT - For part time\nFT - For full time");
            iStatus = myScanner.nextLine();

            if (iStatus.trim().toUpperCase().equals("PT") || iStatus.trim().toUpperCase().equals("FT")) {
                empInfo[x][2] = iStatus.toUpperCase().trim();
                System.out.println("You entered " + empInfo[x][2] + "\nPress Enter to continue");
                isValid = true;
            } else {
                System.out.println("Status is invalid, press Enter to try again");
            }
            myScanner.nextLine();
        }
    }

    /**
     * Prompts user if the want to continue and displays how many more times they can continue, as well as store the
     * value entered by the user
     * @param x passes the value stored in i based on the for loop in opt1
     * @return returns the value the user entered when prompted to continue and stores it in another variable
     */
    public static char empContinue(int x) {
        char data = ' ';
        int noOffset = x + 1; // used for calculating the amount of times user can continue to enter employees
        int times = 10 - noOffset; // used to show user how many more times they can enter data
        boolean isValid = false;

        // loop that ends when user enters a Y or a N
        while (!isValid) {
            try {
                // condition that checks if the user has entered up to 10 employees
                if (times == 0) {
                    System.out.println("No more employees can be entered, returning to Main Menu \nPress Enter to " +
                            "continue");
                    data = 'N';
                    isValid = true;
                } else {
                    System.out.println("Enter another employee? You can enter up to " + times + " more time(s)? \nY " +
                            "or N?");
                    data = myScanner.nextLine().toUpperCase().charAt(0);
                }

                if (data != 'Y' && data != 'N') {
                    System.out.println("Error, press Enter to try again");
                    myScanner.nextLine();
                } else {
                    isValid = true;
                }

            } catch (Exception e) {
                System.out.println("Error, press Enter to try again");
                myScanner.nextLine();
            }
        }
        return data;
    }

    /**
     * Module for when Option 2 is selected that calls methods that are part of that option
     */
    public static void opt2() {
        double cBonusAmt;
        double cTotBonus = 0;

        System.out.println("You selected Option 2, press Enter to continue");
        myScanner.nextLine();

        colHdgs();

        for (int i = 0; i < empInfo.length; i++) {
            try {
                cBonusAmt = calcs(i);
                output(cBonusAmt, i);
                cTotBonus += cBonusAmt;

                if (i == 9) { // checks if loop is on the last iteration
                    totals(cTotBonus); // called when user has entered 10 employees
                }

            } catch (Exception ex) { // catches when no more records are found
                totals(cTotBonus);
                i = 10;
            }
        }
        System.out.println("Press Enter to exit Option 2");
    }

    /**
     * Module that prints out column headings
     */
    public static void colHdgs() {
        String headings;
        headings = String.format("%-26s%5s%-9s%5s%-9s%5s%-14s%n", "Name", " ", "Paycheck", " ", "Status", " ",
                "Employee Bonus");
        System.out.println(headings);
    }

    /**
     * Calculates the bonus amount for each employee
     * @param x finds the correct value in empInfo and empPayAmt to be used for calculations
     * @return returns value stored in bonusAmt and stores it in another variable
     */
    public static double calcs(int x) {
        double bonusAmt = 0;

        // for loop that calculates the bonus based on the employee's status
        for (int i = 0; i < empBonus.length; i++) {
            if ("PT".equals(empInfo[x][2])) {
                if (empPayAmt[x] <= empBonus[i][0]) {
                    bonusAmt = empPayAmt[x] * empBonus[i][1];
                    i = 8; // exits loop
                }
            } else if ("FT".equals(empInfo[x][2])) {
                if (empPayAmt[x] <= empBonus[i][0]) {
                    bonusAmt = empPayAmt[x] * empBonus[i][2];
                    i = 8;
                }
            } else if (i == 7) { // if nothing is found after the 7th iteration
                bonusAmt = 0;
            }
        }
        return bonusAmt;
    }

    /**
     * Formats and prints data to console
     * @param cBonusAmt passes values to be formatted and printed
     * @param x uses value in x to find the correct employee status
     */
    public static void output(double cBonusAmt, int x) {
        String oName = empInfo[x][1].concat(", " + empInfo[x][0]); // combines first and last name

        String payCheckPattern = "#,##0.00";
        DecimalFormat payCheck = new DecimalFormat(payCheckPattern);
        String oPayCheck = payCheck.format(empPayAmt[x]);

        String bonusAmtPattern = "##0.00";
        DecimalFormat bonusAmt = new DecimalFormat(bonusAmtPattern);
        String oBonusAmt = bonusAmt.format(cBonusAmt);

        String oStatus;
        if ("FT".equals(empInfo[x][2])){
            oStatus = "Full Time";
        } else if ("PT".equals(empInfo[x][2])){
            oStatus = "Part Time";
        } else {
            oStatus = " ";
        }
        String record = String.format("%-26s%5s%8s%6s%9s%5s%14s", oName, " ", oPayCheck, " ", oStatus, " ", oBonusAmt);
        System.out.println(record);
    }

    /**
     * Prints the total number of bonuses paid
     * @param cTotBonus passes value to method to be formatted and printed
     */
    public static void totals(double cTotBonus) {
        String pattern = "$#,##0.00";
        DecimalFormat money = new DecimalFormat(pattern);
        String oTotBonus = money.format(cTotBonus);

        String totals = String.format("%n%n%-26s%35s%12s", "Total Bonuses Paid: ", " ", oTotBonus);
        System.out.println(totals);
    }

    /**
     * Module for when Option 3 is selected that calls methods that are part of that option
     */
    public static void opt3() {
        String iFirstName, iLastName;
        double cBonusAmt;

        System.out.println("You selected Option 3, press Enter to continue");
        myScanner.nextLine();

        iFirstName = opt3EmpFirstName();
        iLastName = opt3EmpLastName();

        for (int x = 0; x < empInfo.length; x++) {
            if (iFirstName.trim().equals(empInfo[x][0]) && iLastName.trim().equals(empInfo[x][1])) {
                cBonusAmt = calcs(x);
                opt3Output(cBonusAmt, x);
                x = 10;  // exits loop
            } if (x == 9) { // if nothing is found on the 9th iteration
                System.out.println("Employee not found, press Enter to exit Option 3");
            }
        }
    }

    /**
     * Prompts user for first name and stores the value they entered
     * @return returns the value entered by the user and stores it in another variable
     */
    public static String opt3EmpFirstName() {
        String firstName = " ";
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Please enter a first name: ");
            firstName = myScanner.nextLine();

            if (firstName.trim().isEmpty()) {
                System.out.println("A first name is required, press Enter to try again");
            } else {
                System.out.println("You entered " + firstName + "\nPress Enter to continue");
                isValid = true;
            }
            myScanner.nextLine();
        }
        return firstName;
    }

    /**
     * Prompts user for last name and stores the value they entered
     * @return returns the value entered and stores in another variable
     */
    public static String opt3EmpLastName() {
        String lastName = " ";
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Please enter a last name: ");
            lastName = myScanner.nextLine();

            if (lastName.trim().isEmpty()) {
                System.out.println("A last name is required, press Enter to continue");
            } else {
                System.out.println("You entered " + lastName + "\nPress Enter to continue");
                isValid = true;
            }
            myScanner.nextLine();
        }
        return lastName;
    }

    /**
     * Formats and prints data in a vertical format
     * @param cBonusAmt pass value stored for a certain employee
     * @param x passes the vakue stored in x based on the for loop in the opt3 method
     */
    public static void opt3Output(double cBonusAmt, int x) {
        String oName = empInfo[x][0].concat(" " + empInfo[x][1]);

        String pattern = "$#,##0.00";
        DecimalFormat money = new DecimalFormat(pattern);
        String oPayCheck = money.format(empPayAmt[x]);
        String oBonusAmt = money.format(cBonusAmt);

        String oStatus;
        if ("PT".equals(empInfo[x][2])) {
            oStatus = "Part Time";
        } else if ("FT".equals(empInfo[x][2])) {
                oStatus = "Full Time";
        } else {
            oStatus = " ";
        }
        System.out.println("Name: " + oName + "\nStatus: " + oStatus + "\nPaycheck Amount: " + oPayCheck +
                "\nBonus Amount: " + oBonusAmt + "\nPress Enter to exit Option 3");
    }
}