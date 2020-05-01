import java.text.DecimalFormat;

/**
 * Created by Lucas Chapman 4/15/2020
 * This program is designed to allow users to purchase a gas or electric car.
 * This class is an abstract/parent/base class used for inheritance.
 */
public abstract class Car {
    /*
    Instance Variables
     */
    private String make, model, color;
    private  int year, weight;

    /**
     * The default constructor for the base class
     */
    public Car() {
        make = "Honda";
        model = "Civic";
        year = 2020;
        color = "Black";
        weight = 2875;  // in lbs
    }

    /**
     * The overloaded constructor for the base class
     * @param mke passes values to setMake()
     * @param mdl passes values to setModel()
     * @param yr passes values to setYear()
     * @param clr passes values to setColor()
     * @param wgt passes values to setWeight()
     */
    public Car (String mke, String mdl, int yr, String clr, int wgt) {
        setMake(mke);
        setModel(mdl);
        setYear(yr);
        setColor(clr);
        setWeight(wgt);
    }

    /**
     * Setter for make in the base class
     * @param mke passes value for make
     */
    public void setMake (String mke) {
        if (mke.isEmpty()) {
            make = "Honda";
        } else {
            make = mke;
        }
    }

    /**
     * Setter for model in the base class
     * @param mdl passes value to model
     */
    public void setModel(String mdl) {
        if (mdl.isEmpty()) {
            model = "Civic";
        } else {
            model = mdl;
        }
    }

    /**
     * Setter for the year in the base class
     * @param yr passes values to year
     */
    public void setYear(int yr) {
        if (yr <= 0) {
            year = 2020;
        } else {
            year = yr;
        }
    }

    /**
     * Setter for color in the base class
     * @param clr passes values to color
     */
    public void setColor(String clr) {
        if (clr.isEmpty()) {
            color = "Black";
        } else {
            color = clr;
        }
    }

    /**
     * Setter for weight in the base class
     * @param wgt passes values to weight
     */
    public void setWeight(int wgt) {
        if (wgt <= 0) {
            weight = 2875;
        } else {
            weight = wgt;
        }
    }

    /**
     * Getter for make in the base class
     * @return returns the make of a car
     */
    public String getMake() {
        return make;
    }

    /**
     * Getter for model in the base class
     * @return returns what the model of a car is
     */
    public String getModel() {
        return model;
    }

    /**
     * Getter for the year in the base class
     * @return returns the year of a car
     */
    public int getYear() {
        return year;
    }

    /**
     * Getter for color in the base class
     * @return returns the color of a car
     */
    public String getColor() {
        return color;
    }

    /**
     * Getter for weight in the base class
     * @return returns the weight of a car
     */
    public int getWeight() {
        return weight;
    }

    /**
     * The base class's toString()
     * @return returns a formatted message
     */
    @Override
    public String toString() {
        DecimalFormat wgt = new DecimalFormat("###,##0");
        String oWeight = wgt.format(getWeight()) + " lbs";
        return "Make: " + getMake() + "\nModel: " + getModel() + "\nYear: " + getYear() + "\nColor: " +
                getColor() + "\nWeight: " + oWeight;
    }

    /**
     * An abstract method that calculates the cost filling up the car
     * @param pc passes the cost of filling up a car
     * @return returns the total cost
     */
    protected abstract double CalcCostPerFill(double pc);
}