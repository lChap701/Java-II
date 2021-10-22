/**
 * This is class is used to instantiate Reservation objects
 */
public class Reservation {
    private  static final double FRED_FYLER_DISCOUNT = .15;
    private int resNumber;
    private String resCustName;
    private boolean resFreqFlyer;

    //default constructor
    /**
     * Instantiates a Reservation object with default values
     */
    Reservation(){
        resNumber = 1000;
        resCustName = "Johnson";
        resFreqFlyer = true;
    }

    //parameterized constructor
    /**
     * Instantiates a Reservation object with parameter values
      * @param resNum Reservation number
     * @param resName Customer Name
     * @param freqFlyer Frequent flyer status
     */
    Reservation (int resNum, String resName, boolean freqFlyer){
        setResNumber(resNum);
        setResCustName(resName);
        setResFreqFlyer(freqFlyer);

    }

    //setters
    /**
     * Sets the reservation number to a number between 1000 and 9999
     * @param num has value stored in num be stored in resNumber
     */
    public void setResNumber(int num){
        if(num >= 1000 && num <= 9999) {
            resNumber = num;
        } else {
            resNumber = 1000;
        }
    }


    /**
     * Set customer name that is not null
     * @param name has value stored in name be stored in resCustName
     */
    public void setResCustName(String name){
        if(name.trim().isEmpty()){
            resCustName = "Johnson";
        } else {
            resCustName = name;
        }
    }

    /**
     * Set frequency flyers status
     * @param flyer has value stored in fyler be stored in resFreqFlyer
     */
    public void setResFreqFlyer(boolean flyer){
        resFreqFlyer = flyer;
    }

    //getters
    /**
     * Gets the reservation number
     * @return returns value in resNumber
     */
    public int getResNumber(){
        return resNumber;
    }

    /**
     * Gets the reservation name
     * @return returns value in resCustName
     */
    public String getResCustName(){
        return resCustName;
    }

    /**
     * Gets the frequency flyer statue
     * @return returns value in resFreqFlyer (True is customer)
     */
    public boolean getResFreqFlyer(){
        return resFreqFlyer;
    }

    private double calcFreqFlyerDis(double cost){
        double discountAmt = 0;
        if(resFreqFlyer){
            discountAmt = cost * FRED_FYLER_DISCOUNT;
        }
        return  discountAmt;
    }


    @Override
    public String toString(){
        return "Reservation number is: " + resNumber +
                "\nCustomer Name: " + getResCustName() +
                "\nStatus: " + (resFreqFlyer ? "Frequent flyer" : "Not a frequent flyer") +
                "\nDiscount: " + calcFreqFlyerDis(250);
    }
}
