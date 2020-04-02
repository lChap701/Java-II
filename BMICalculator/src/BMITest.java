/**
 * Created by Lucas Chapman 3/9/2020
 * This class is used to test the BMI class to make sure it is working properly.
 */
public class BMITest {
    public static void main(String[] args) {
        BMI[] bmi = new BMI[8];

        System.out.println("Default constructor");

        bmi[0] = new BMI();

        defaultConstructorTest(bmi);

        System.out.println("\nOverloaded constructor");

        // tests overloaded constructor
        bmi[0] = new BMI(199, 100, 1);
        bmi[1] = new BMI(136, 69, 2);
        bmi[2] = new BMI(100, 155, 1);
        bmi[3] = new BMI(1, 60, 2);
        bmi[4] = new BMI(70, 160, 1);
        bmi[5] = new BMI(120, 72, 2);
        bmi[6] = new BMI(0, 0, 0);
        bmi[7] = new BMI(0, 0, 3);

        overloadedConstructorTest(bmi);

        System.out.println("Setters and getters");

        for (int i = 0; i < bmi.length; i++) {
            bmi[i].setWeight(120);
            bmi[i].setHeight(70);
            bmi[i].setOption(1);

            settersAndGettersTest(bmi, i);
        }
    }

    /**
     * module used to test default constructor and getters
     * @param bmi passed to send value stored in it to module
     */
    public static void defaultConstructorTest(BMI[] bmi) {
        if (bmi[0].getOption() == 1) {
            System.out.println("Weight: " + bmi[0].getWeight() + "kg\nHeight: " + bmi[0].getHeight() +
                    "m\nOption: " + bmi[0].getOption() + "\n");
        } else {
            System.out.println("Weight: " + bmi[0].getWeight() + "lb\nHeight: " + bmi[0].getHeight() +
                    "in\nOption: " + bmi[0].getOption() + "\n");
        }
        System.out.println(bmi[0].toString());
    }

    /**
     * module used to test overloaded constructor and getters
     * @param bmi passed to send value stored in it to module
     */
    public static void overloadedConstructorTest(BMI[] bmi) {
        for (BMI value : bmi) {
            if (value.getOption() == 1) {
                System.out.println("Weight: " + value.getWeight() + "kg\nHeight: " + value.getHeight() +
                        "cm\nOption: " + value.getOption() + "\n");
            } else {
                System.out.println("Weight: " + value.getWeight() + "lb\nHeight: " + value.getHeight() +
                        "in\nOption: " + value.getOption() + "\n");
            }
            System.out.println(value.toString() + "\n");
        }
    }

    /**
     * Module use to just test the setters and getters
     * @param bmi passed to send value stored in it to module
     * @param i passes value from for loop to module
     */
    public static void settersAndGettersTest(BMI[] bmi, int i) {
        System.out.println("Weight: " + bmi[i].getWeight() + "kg\nHeight: " + bmi[i].getHeight() + "cm\nOption: " +
                bmi[i].getOption() + "\n");
    }
}