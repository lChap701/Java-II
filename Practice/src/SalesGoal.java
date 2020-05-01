/**
 * Child class which calculates the amount of candies left to sale to reach the fundraiser's goal and determines if
 * their goal was reached.
 */
public class SalesGoal extends Candy {
    private int qty, month, day;

    // default constructor
    public SalesGoal() {
        super();
        qty = 0;
        month = 9;
        day = 1;
    }

    // overload constructor
    public SalesGoal(double c, String cn, String n, int q, int m, int d) {
        super(c, cn, n);
        setQty(q);
        setMonth(m);
        setDay(d);
    }

    // setters
    public void setQty(int q) {
        if (qty < 0) {
            qty = 0;
        } else {
            qty = q;
        }
    }

    public void setMonth(int m) {
        if (m <= 11 && m >= 9) {
            month = m;
        } else {
            month = 9;
        }
    }

    public void setDay(int d) {
        if (month == 9 && d <= 30 && d > 0) {
            day = d;
        } else if (month == 10 && d <= 31 && d > 0) {
            day = d;
        } else if (month == 11 && d <= 18 && d > 0) {
            day = d;
        } else {
            day = 1;
        }
    }

    // getters
    public int getQty() {
        return qty;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    /**
     * Calculates the amount left to reach goal
     * @return returns amount left
     */
    private int amtCalcs() {
        int toGo;
        toGo = 100 - getQty();
        return toGo;
    }

    /**
     * Calculates the amount of time left
     * @return returns amount of time
     */
    private String timeLeftCalcs() {
        int monthsLeft = 0, daysLeft = 0;
        if (getMonth() == 9 && getDay() <= 18) {
            daysLeft = 18 - getDay();
            monthsLeft = 11 - getMonth();
        } else if (getMonth() == 9 && getDay() > 18) {
            daysLeft = getDay() - 18;
            monthsLeft = 10 - getMonth();
        }
        if (getMonth() == 10 && getDay() <= 18) {
            daysLeft = 18 - getDay();
            monthsLeft = 11 - getMonth();
        } else if (getMonth() == 10 && getDay() > 18) {
            daysLeft = getDay() - 18;
            monthsLeft = 10 - getMonth();
        } else if (getMonth() == 11 && getDay() <= 18) {
            daysLeft = 18 - getDay();
            monthsLeft = 11 - getMonth();
        }
        String timeLeft = monthsLeft + " months and " + daysLeft + " days";
        return timeLeft;
    }

    @Override
    public String toString() {
        String months = "";
        if (getMonth() == 9)
            months = "September";
        else if (getMonth() == 10) {
            months = "October";
        } else if (getMonth() == 11) {
            months = "November";
        }
        return super.toString() + "\n\nSold " + getQty() + " bars on " + months + " " + getDay();
    }

    protected String feedback() {
        int leftOver = amtCalcs();
        String time = timeLeftCalcs();
        return "\nNeed To Sell " + leftOver + " more bars by " + time;
    }
}
