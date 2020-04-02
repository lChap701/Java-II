/**
 * Created by Lucas Chapman 3/11/2020
 * This program is a BMI calculator that is designed to prompt the user for the weight and height in order to calculate
 * the BMI and then displays what category they are in based on their results. This is the instantiable class.
 */
public class BMI {
    // instance variables
    private int weight, height, option;

    /**
     * default constructor for BMI class
      */
    BMI() {
        weight = 70; // kg
        height = 170; // cm
        option = 1; // metric
    }

    /**
     * overloaded constructor
     * @param w parameter for weight
     * @param h parameter for height
     * @param o parameter for option
     */
    BMI(int w, int h, int o) {
        setWeight(w);
        setHeight(h);
        setOption(o);
    }

    /**
     * setter for weight
     * @param w stores value in w in weight
     */
    public void setWeight(int w) {
        weight = w;

        if (weight <= 0) {
            weight = 70;
        }
    }

    /**
     * setter for height
     * @param h stores value in h in height
     */
    public void setHeight(int h) {
        height = h;

        if (height <= 0) {
            height = 170;
        }
    }

    /**
     * setter for option
     * @param o stores value in o in option
     */
    public void setOption(int o) {
        option = o;

        if (option != 2 && option != 1) {
            option = 1;
        }
    }

    /**
     * getter for weight
     * @return returns value stored in weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * getter for height
     * @return returns value stored in height
     */
    public int getHeight() {
        return height;
    }

    /**
     * getter for option
     * @return returns value stored in option
     */
    public int getOption() {
        return option;
    }

    /**
     * calculates the BMI based on what option was selected
     * @return returns the BMI of an individual
     */
    private double calcs(){
        double cBMI, rouBMI, cHeightSquared, cHeightMeters;

        if (option == 1) {
            cHeightMeters = height / 100.0;  // converts the height in centimeters to meters
            cHeightSquared = Math.pow(cHeightMeters, 2);
            cBMI = weight / cHeightSquared ;
        } else {
            cHeightSquared = Math.pow(height, 2);
            cBMI = weight / cHeightSquared * 703;
        }
        rouBMI = Math.round(cBMI * 10.0) / 10.0; // rounds value to the nearest tenth

        return rouBMI;
    }

    /**
     * toString method that is overridden to print out a formatted message
      * @return returns message that is printed out in BMITest class
     */
    @Override
    public String toString(){
        double rouBMI =  calcs();
        String oCategory;

        if (rouBMI < 18.5) {
            oCategory = "Underweight";
        } else if (rouBMI >= 18.5 && rouBMI < 25) {
            oCategory = "Normal Weight";
        } else if (rouBMI >= 25 && rouBMI < 30) {
            oCategory = "Overweight";
        } else {
            oCategory = "Obesity";
        }

        return "Your BMI is " + rouBMI + " which is considered " + oCategory;
    }
}