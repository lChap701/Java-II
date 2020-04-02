import java.util.Scanner;

/**
 * Created by Lucas Chapman 3/11/2020
 * This class prompts the user
 */
public class BMIProgram {
    private static Scanner myScanner;

    public static void main(String[] args) {
        int iOpt = 0;
        BMI[] bmi = new BMI[100];  // allows user to use program 100 times

        init();

        while (iOpt != 3) {
            for (int x = 0; x < bmi.length; x++) {
                try {
                    iOpt = opt();

                    if (iOpt == 1) {
                        opt1(bmi, iOpt, x);
                    } else if (iOpt == 2) {
                        opt2(bmi, iOpt, x);
                    } else if (iOpt == 3) {
                        System.out.println("You have chosen to exit the program, press Enter to continue");
                        x = 100; // exits for loop
                    } else {
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
        System.out.println("Welcome to BMI Calculator");
    }

    /**
     * Collects the option that the user selected
     * @return returns the option selected to be stored in another variable
     */
    public static int opt() {
        int opt;
        String data;

        System.out.println("Please enter an option: \n1 - Use metric system\n2 - Use standard system\n3 - Exit " +
                "program");
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
        bmi[x] = new BMI(iWeight, iHeight, iOpt);
        System.out.println(bmi[x].toString() + "\nPress Enter to continue");
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
                System.out.println("Height cannot contain any decimals and has to be numeric, press Enter to try " +
                        "again");
                myScanner.nextLine();
            }
        }
        if (height <= 0) {
            System.out.println("The height you entered will be defaulted to 170cm, press Enter to continue");
        } else {
            System.out.println("You entered: " + height + "cm, press Enter to continue");
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
                System.out.println("Weight cannot contain any decimals and has to be numeric, press Enter to try " +
                        "again");
                myScanner.nextLine();
            }
        }
        if (weight <= 0) {
            System.out.println("The weight you entered will be defaulted to 70kg, press Enter to continue");
        } else {
            System.out.println("You entered: " + weight + "kg, press Enter to continue");
        }
        myScanner.nextLine();

        return weight;
    }

    /**
     * Method that calls other methods that are only used for Option 2
     *  @param bmi passes the length of the array to be used in for loop
     * @param x passes value of x to be added back into the array
     * @param iOpt passes value of iOpt to be used when creating a new object
     */
    public static void opt2(BMI[] bmi, int iOpt, int x) {
        System.out.println("You selected Option 2, press Enter to continue");
        myScanner.nextLine();

        int iHeight = standHeight();
        int iWeight = standWeight();
        bmi[x] = new BMI(iWeight, iHeight, iOpt);
        System.out.println(bmi[x].toString() + "\nPress Enter to continue");
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
            System.out.println("The height you entered will be defaulted to 170in, press Enter to continue");
        } else {
            System.out.println("You entered: " + height + "in, press Enter to continue");
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
            System.out.println("The weight you entered will be defaulted to 70lbs, press Enter to continue");
        } else {
            System.out.println("You entered: " + weight + "lbs, press Enter to continue");
        }
        myScanner.nextLine();

        return weight;
    }
}