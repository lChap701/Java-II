import java.util.Scanner;

/**
 * Created by Lucas Chapman on 4/23/2020.
 * Program designed to allow the user to enter the car they want to purchase.
 */
public class CarProgram {
    public static Scanner myScanner;

    public static void main(String[] args) {
        boolean isValid = false;

        init();

        while (!isValid) {
            try {
                int iCar = car();

                if (iCar == 1) {
                    gasCar();
                    isValid = true;
                } else if (iCar == 2) {
                    electricCar();
                    isValid = true;
                } else {
                    System.out.println("Error, invalid car type entered\nPress Enter to " +
                            "try again");
                    myScanner.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Error, invalid car type entered\nPress Enter to try " +
                        "again");
                myScanner.nextLine();
            }
        }
    }

    /**
     * Sets up the Scanner and displays a welcome message.
     */
    private static void init() {
        myScanner = new Scanner(System.in);
        System.out.println("Welcome to the Car Program!");
    }

    /**
     * Prompts the user for if they want to get either a gas car or a electric car.
     * @return returns the type of car that was selected
     */
    private static int car() {
        String iData;
        System.out.println("Please enter the type of car:\n1 - Gas car\n2 - Electric car");
        iData = myScanner.nextLine();
        return Integer.parseInt(iData);
    }

    /**
     * Calls other methods to gather enough information to create a GasCar object to be
     * used to display formatted data in the console.
     */
    private static void gasCar() {
        String iMake = make();
        String iModel = model();
        int iYear = year();
        String iColor = color();
        int iWeight = weight();
        double iTankSize = tankSize();
        String iFuelType = fuelType();
        GasCar gCar = new GasCar(iMake, iModel, iYear, iColor, iWeight, iTankSize,
                iFuelType);
        gasCarOutput(gCar);
    }

    /**
     * Prompts the user for a car's make.
     * @return returns what was entered
     */
    private static String make() {
        String data;
        System.out.println("Please enter the car's make: ");
        data = myScanner.nextLine();

        if (data.trim().isEmpty()) {
            System.out.println("Nothing entered, defaulted to Honda\nPress Enter to " +
                    "continue");
            myScanner.nextLine();
        }
        return data;
    }

    /**
     * Prompts the user for the model of a car.
     * @return returns what was entered
     */
    private static String model() {
        String data;
        System.out.println("Please enter the model of a car: ");
        data = myScanner.nextLine();

        if (data.trim().isEmpty()) {
            System.out.println("Nothing entered, model defaulted to Civic\nPress Enter to" +
                    " continue");
            myScanner.nextLine();
        }
        return data;
    }

    /**
     * Prompts to user for the car's year.
     * @return returns what was entered
     */
    private static int year() {
        String input;
        int year = 0;
        boolean isNumeric = false;

        while (!isNumeric) {
            try {
                System.out.println("Please enter the car's year: ");
                input = myScanner.nextLine();
                year = Integer.parseInt(input);

                // code after formatting will only execute if no exceptions are caught
                if (year <= 0) {
                    System.out.println("Invalid year, year defaulted to 2020\nPress " +
                            "Enter to continue");
                    myScanner.nextLine();
                }
                isNumeric = true;
            } catch (Exception e){
                System.out.println("Error, data entered is not numeric\nPress Enter to " +
                        "continue");
                myScanner.nextLine();
            }
        }
        return year;
    }

    /**
     * Prompts the user for the color of the car.
     * @return returns what was entered
     */
    private static String color() {
        String data;
        System.out.println("Please enter the color of the car: ");
        data = myScanner.nextLine();

        if (data.trim().isEmpty()) {
            System.out.println("Nothing was entered, color defaulted to black\nPress " +
                    "Enter to continue");
            myScanner.nextLine();
        }
        return data;
    }

    /**
     * Prompts the user for the weight of the car.
     * @return returns what was entered
     */
    private static int weight() {
        String input;
        int weight = 0;
        boolean isNumeric = false;

        while (!isNumeric) {
            try {
                System.out.println("Please enter how much the car weighs: ");
                input = myScanner.nextLine();
                weight = Integer.parseInt(input);

                // code after formatting will only execute if no exceptions are caught
                if (weight <= 0) {
                    System.out.println("Invalid weight, weight defaulted to 2,875 lbs\n" +
                            "Press Enter to continue");
                    myScanner.nextLine();
                }
                isNumeric = true;
            } catch (Exception e){
                System.out.println("Error, data entered is not numeric\nPress Enter to " +
                        "continue");
                myScanner.nextLine();
            }
        }
        return weight;
    }

    /**
     * Prompts the user for the size of the car's tank.
     * @return returns what was entered
     */
    private static double tankSize() {
        String input;
        double tankSize = 0;
        boolean isNumeric = false;

        while (!isNumeric) {
            try {
                System.out.println("Please enter the size of the car's tank: ");
                input = myScanner.nextLine();
                tankSize = Double.parseDouble(input);

                // code after formatting will only execute if no exceptions are caught
                if (tankSize <= 0) {
                    System.out.println("Invalid tank size, data defaulted to 12.4 gal" +
                            "\nPress Enter to continue");
                    myScanner.nextLine();
                }
                isNumeric = true;
            } catch (Exception e) {
                System.out.println("Error, data entered is not numeric\nPress Enter to " +
                        "try again");
                myScanner.nextLine();
            }
        }
        return tankSize;
    }

    /**
     * Prompts the user for the type of fuel the car uses.
     * @return returns what was entered
     */
    private static String fuelType() {
        String data;
        System.out.println("Please enter the type of fuel the car uses: ");
        data = myScanner.nextLine();

        if (data.trim().isEmpty()) {
            System.out.println("Nothing was entered, defaulted to gasoline\nPress Enter " +
                    "to continue");
            myScanner.nextLine();
        }
        return data;
    }

    /**
     * Displays formatted gas car data in the console.
     * @param gCar passes over a GasCar object
     */
    private static void gasCarOutput(GasCar gCar) {
        System.out.println(gCar.toString() + "\n\nPress Enter to exit the program");
        myScanner.nextLine();
    }

    /**
     * Calls other methods to gather enough information to create ElectricCar objects to be
     * used to display formatted data back to the user.
     */
    private static void electricCar() {
        String iMake = make();
        String iModel = model();
        int iYear = year();
        String iColor = color();
        int iWeight = weight();
        double iBatterySize = batterySize();
        String iBatteryType = batteryType();
        ElectricCar eCar = new ElectricCar(iMake, iModel, iYear, iColor, iWeight, iBatterySize,
                iBatteryType);
        electricCarOutput(eCar);
    }

    /**
     * Prompts the user for the size of the car's battery.
     * @return returns what was entered
     */
    private static double batterySize() {
        String input;
        double batterySize = 0;
        boolean isNumeric = false;

        while (!isNumeric) {
            try {
                System.out.println("Please enter the size of the car's battery: ");
                input = myScanner.nextLine();
                batterySize = Double.parseDouble(input);

                // code after formatting will only execute if no exceptions are caught
                if (batterySize <= 0) {
                    System.out.println("Invalid battery size, data defaulted to 85 kw\n" +
                            "Press Enter to continue");
                    myScanner.nextLine();
                }
                isNumeric = true;
            } catch (Exception e) {
                System.out.println("Error, data entered is not numeric\nPress Enter to try again");
                myScanner.nextLine();
            }
        }
        return batterySize;
    }

    /**
     * Prompts the user for the type of battery the car uses.
     * @return returns what was entered
     */
    private static String batteryType() {
        String data;
        System.out.println("Please enter the type of battery the car uses: ");
        data = myScanner.nextLine();

        if (data.trim().isEmpty()) {
            System.out.println("Nothing was entered, defaulted to lithium-ion battery" +
                    "\nPress Enter to continue");
            myScanner.nextLine();
        }
        return data;
    }

    /**
     * Displays formatted electric car data to the console.
     * @param eCar passes over a ElectricCar object
     */
    private static void electricCarOutput(ElectricCar eCar) {
        System.out.println(eCar.toString() + "\n\nPress Enter to exit the program");
        myScanner.nextLine();
    }
}