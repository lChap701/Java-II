import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Lucas Chapman 4/20/2020.
 * JUnit Tests for testing the CalcCostPerFill() used in this program.
 */
public class CarTestClass {
    /**
     * Test the CalcCostPerFill() in the GasCar class.
     */
    @Test
    public void testGasCar() {
        /*
         * Default Values Test
         */
        GasCar g1 = new GasCar();

        double validDefaultCost= g1.CalcCostPerFill(1);      // added to help with debugging
        assertEquals(12.4, validDefaultCost, 1);   // tests valid data
        assertNotEquals(0, validDefaultCost, 1); // tests invalid data

        /*
         * Tests Possible Values That The User Could Enter
         */
        // Test 1
        double iTankSize = 9.8;                             // simulates user input
        GasCar g2 = new GasCar("make", "model", 2021, "black", 2900,
                iTankSize, "Diesel");

        double validCost = g2.CalcCostPerFill(3);       // used for debugging
        assertEquals(29.4, validCost, 1);     // tests valid data
        assertNotEquals(8.5, validCost, 1); // tests invalid data

        // Test 2
        iTankSize = 13.67;   // simulates user input
        g2 = new GasCar("maker", "mod 5", 2055, "blue", 9000, iTankSize,
                "Gas");

        validCost = g2.CalcCostPerFill(5);                // used for debugging
        assertEquals(68.35, validCost, 1);      // tests valid data
        assertNotEquals(13.55, validCost, 1); // tests invalid data
    }

    /**
     * Tests the CalcCostPerFill() in the ElectricCar class.
     */
    @Test
    public void testElectricCar() {
        /*
         * Default Values Test
         */
        ElectricCar e1 = new ElectricCar();

        double validDefaultCost = e1.CalcCostPerFill(1);     // added for debugging purposes
        assertEquals(85, validDefaultCost, 1);     // tests valid data
        assertNotEquals(0, validDefaultCost, 1); // tests invalid data

        /*
         * Tests Possible Values That The User Could Enter
         */
        // Test 1
        double iTankSize = 10.15;                           // simulates user input
        ElectricCar e2 = new ElectricCar("make", "model", 2021, "black", 2900,
                iTankSize, "Lithium");

        double validCost = e2.CalcCostPerFill(10);      // for debugging purposes
        assertEquals(101.5, validCost, 1);    // tests valid data
        assertNotEquals(5.1, validCost, 1); // tests invalid data

        // Test 2
        iTankSize = 6.2;                                  // simulates user input
        e2 = new ElectricCar("tesla", "model 3", 2025, "white", 3010,
                iTankSize, "ion");
        validCost = e2.CalcCostPerFill(2);            // for debugging purposes
        assertEquals(12.4, validCost, 1);   // tests valid data
        assertNotEquals(6, validCost, 1); // tests invalid data
    }
}