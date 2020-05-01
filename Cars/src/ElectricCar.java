import java.text.DecimalFormat;

/**
 * Created by Lucas Chapman 4/15/2020
 * A child class which inherits from the parent class and instantiates new ElectricCar objects
 */
public class ElectricCar extends Car {
    /*
    Instance Variables
     */
    private double batterySize;
    private String batteryType;

    /**
     * Default constructor for the ElectricCar class
     */
    public ElectricCar() {
        super();            // calls the base class's default constructor
        batterySize = 85;   // in kw
        batteryType = "lithium-ion";
    }

    /**
     * The overloaded constructor for the ElectricCar class
     * @param mke parameter for setMake() in the base class
     * @param mdl parameter for setModel() in the base class
     * @param yr parameter for setYear() in the base class
     * @param clr parameter for setColor() in the base class
     * @param wgt parameter for setWeight() in the base class
     * @param batSz parameter for setBatterySize()
     * @param batTp parameter for setBatteryType()
     *
     */
    public ElectricCar(String mke, String mdl, int yr, String clr, int wgt, double batSz, String batTp) {
        super(mke, mdl, yr, clr, wgt);
        setBatterySize(batSz);
        setBatteryType(batTp);
    }

    /**
     * Setter for battery size
     * @param batSz passes values for batterySize
     */
    public void setBatterySize(double batSz) {
        if (batSz <= 0) {
            batterySize = 85;
        } else {
            batterySize = batSz;
        }
    }

    /**
     * Setter for battery type
     * @param batTp passes values to batteryType
     */
    public void setBatteryType(String batTp) {
        if (batTp.isEmpty()) {
            batteryType = "Lithium-ion";
        } else {
            batteryType = batTp;
        }
    }

    /**
     * Getter for battery size
     * @return returns the size of the car's battery
     */
    public double getBatterySize() {
        return batterySize;
    }

    /**
     * Getter for battery type
     * @return returns the type of battery the car uses
     */
    public String getBatteryType() {
        return batteryType;
    }

    /**
     * toString() for the ElectricCar class
     * @return returns a formatted message
     */
    @Override
    public String toString() {
        DecimalFormat batSize = new DecimalFormat("##0.##");
        String oBatterySize = batSize.format(getBatterySize()) + " kw";
        return super.toString() + "\nBattery Size: " + oBatterySize + "\nBattery Type: " +
                getBatteryType() + " Battery";
    }

    /**
     * An abstract method that calculates the cost of charging a battery
     * @param pc passes the cost of charging the battery per fill
     * @return returns the total cost
     */
    protected double CalcCostPerFill(double pc) {
        return pc * getBatterySize();
    }
}
