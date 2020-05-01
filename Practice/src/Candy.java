import java.text.DecimalFormat;

/**
 * Abstract class uses to be inherited by in other classes. This program is used to keep track of the total candy sales
 * from a local fundraiser, as well as see if that meet their goal of selling at least 100 candies by November 18.
 */
public abstract class Candy {
    private double cost;
    private String candyName, name;

    // default constructor
    public Candy() {
        cost = 0;
        candyName = "Unknown";
        name = "Bobby Johns";
    }

    // overloaded constructor
    public Candy(double c, String cn, String n) {
        setCost(c);
        setCandyName(cn);
        setName(n);
    }

    // setters
    public void setCost(double c) {
        if (c < 0 || c > 999.99) {
            cost = 0;
        } else {
            cost = c;
        }
    }

    public void setCandyName(String n) {
        switch (n) {
            case "Skittles":
            case "M&M's":
            case "Hershey Bar(s)":
            case "Kit Kat Bar(s)":
            case "Snickers":
            case "Reese's Peanut Butter Cups":
            case "Reese's Pieces":
            case "Butterfinger(s)":
            case "Twix":
            case "Milky Way":
                candyName = n;
            break;
            default:
                candyName = "Unknown";
        }
    }

    public void setName(String n) {
        if (name.isEmpty()) {
            name = "Bobby Johns";
        } else {
            name = n;
        }
    }

    // getters
    public double getCost() {
        return cost;
    }

    public String getCandyName() {
        return candyName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String moneyFormat = "$##0.00";
        DecimalFormat df = new DecimalFormat(moneyFormat);
        return "Cost: " + df.format(getCost()) + "\nCandy: " + getCandyName() + "\nName: " + getName();
    }

    // method that is implemented in child classes to provide feed back
    protected abstract String feedback();
}
