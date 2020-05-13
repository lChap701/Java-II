import java.text.DecimalFormat;

/**
 * Created by Lucas Chapman 4/15/2020.
 * A child class which inherits from the parent class and is used to instantiate GasCar objects.
 */
public class GasCar extends Car {
    /*
    Instance Variables
     */
    private double tankSize;
    private String fuelType;

    /**
     * GarCar's default constructor.
     */
    public GasCar() {
        super();            // call to constructor in the base class
        tankSize = 12.4;    // in gal
        fuelType = "Gasoline";
    }

    /**
     * GasCar's overloaded constructor.
     * @param mke parameter for setMake() in the base class
     * @param mdl parameter for setModel() in the base class
     * @param yr parameter for setYear() in the base class
     * @param clr parameter for setColor() in the base class
     * @param wgt parameter for setWeight() in the base class
     * @param tnkSz passes values to setTankSize()
     * @param flTp passes values to setFuelType()
     */
    public GasCar (String mke, String mdl, int yr, String clr, int wgt, double tnkSz, String flTp) {
        super(mke, mdl, yr, clr, wgt);  // call to the base class's overloaded constructor
        setTankSize(tnkSz);
        setFuelType(flTp);
    }

    /**
     * Setter for tank size.
     * @param tnkSz passes values for tankSize
     */
    public void setTankSize(double tnkSz) {
        if(tnkSz <= 0) {
            tankSize = 12.4;
        } else {
            tankSize = tnkSz;
        }
    }

    /**
     * Setter for fuel type.
     * @param flTp passes values for fuelType
     */
    public void setFuelType(String flTp) {
        if (flTp.trim().isEmpty()) {
            fuelType = "Gasoline";
        } else {
            fuelType = flTp;
        }
    }

    /**
     * Getter for tank size.
     * @return returns the size of a tank
     */
    public double getTankSize() {
        return tankSize;
    }

    /**
     * Getter for fuel type.
     * @return returns the type of fuel a car uses
     */
    public String getFuelType() {
        return fuelType;
    }

    /**
     * GasCar's toString() which calls the base class's toString() for reusability.
     * @return returns a message
     */
    @Override
    public String toString() {
        DecimalFormat gal = new DecimalFormat("##0.##");
        String oTankSize = gal.format(getTankSize()) + " gal";
        return super.toString() + "\nTank Size: " + oTankSize + "\nFuel Type: " + getFuelType();
    }

    /**
     * An abstract method that calculates the cost of getting gas.
     * @param pc passes the cost of filling up a tank per fill
     * @return returns the total cost
     */
    protected double CalcCostPerFill(double pc) {
        return pc * getTankSize();
    }
}
