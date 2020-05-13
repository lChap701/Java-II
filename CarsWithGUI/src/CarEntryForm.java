import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Lucas Chapman 4/30/2020.
 * This class is used to create a JFrame to be used to create GasCar and ElectricCar
 * objects depending on what type of car was selected.
 */
public class CarEntryForm extends JFrame implements ActionListener, ItemListener {
    boolean exception, colorSelected;   // flags for Exceptions and selecting colors
    JTextField answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8;
    JRadioButton black, white, red, blue, grey, gas, electric;
    JButton submit, goBack;
    JLabel tank, fuel, batSize, batType;    // made global to be able to enable/disable

    /**
     * CarEntryForm's default constructor.
     */
    public CarEntryForm() {
        /*
         * JFrame
         */
        super("Car Entry Form");    // call to the JFrame class's default constructor
        setSize(388, 418);
        setVisible(true);

        /*
         * JLabels & Fonts
         */
        // Fonts
        Font bigFont = new Font("Helvetica", Font.BOLD, 30);
        Font smallBoldFont = new Font("Helvetica", Font.BOLD, 16);
        Font jRadioFont = new Font("Helvetica", Font.BOLD, 14);
        Font smallFont = new Font("Helvetica", Font.PLAIN, 14);

        // Title & Instructions
        JLabel title = new JLabel("Car Entry Form");
        JLabel instruct = new JLabel("Fill out the form and then hit the submit button");
        title.setFont(bigFont);
        instruct.setFont(smallBoldFont);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(title);
        add(instruct);

        /*
         * JLabels & JTextFields
         */
        // Make Section
        JLabel make = new JLabel("Make:  ");
        make.setFont(smallFont);
        answer1 = new JTextField(34);
        setLayout(new FlowLayout());
        add(make);
        add(answer1);

        // Model Section
        JLabel model = new JLabel("Model: ");
        model.setFont(smallFont);
        answer2 = new JTextField(34);
        setLayout(new FlowLayout());
        add(model);
        add(answer2);

        // Year Section
        JLabel year = new JLabel("Year:   ");
        year.setFont(smallFont);
        answer3 = new JTextField(34);
        setLayout(new FlowLayout());
        add(year);
        add(answer3);

        // Weight Section
        JLabel weight = new JLabel("Weight:");
        weight.setFont(smallFont);
        answer4 = new JTextField(34);
        setLayout(new FlowLayout());
        add(weight);
        add(answer4);

        /*
         * JLabels, JButtons, JRadioButtons, & ButtonGroups
         */
        // Colors Section
        JLabel color = new JLabel("Color:  ");
        color.setFont(smallFont);
        ButtonGroup colors = new ButtonGroup();
        black = new JRadioButton("Black");
        white = new JRadioButton("White");
        red = new JRadioButton("Red");
        blue = new JRadioButton("Blue");
        grey = new JRadioButton("Grey ");
        black.setFont(jRadioFont);
        white.setFont(jRadioFont);
        red.setFont(jRadioFont);
        blue.setFont(jRadioFont);
        grey.setFont(jRadioFont);
        black.addItemListener(this);
        white.addItemListener(this);
        red.addItemListener(this);
        blue.addItemListener(this);
        grey.addItemListener(this);
        // Adds to ButtonGroup
        colors.add(black);
        colors.add(white);
        colors.add(red);
        colors.add(blue);
        colors.add(grey);
        // Adds to JFrame
        setLayout(new FlowLayout());
        add(color);
        add(black);
        add(white);
        add(red);
        add(blue);
        add(grey);

        // Cars Section
        JLabel car = new JLabel("Car:    ");
        car.setFont(smallFont);
        ButtonGroup cars = new ButtonGroup();
        gas = new JRadioButton("Gas");
        electric = new JRadioButton("Electric");
        gas.setFont(jRadioFont);
        electric.setFont(jRadioFont);
        gas.addItemListener(this);
        electric.addItemListener(this);
        // Adds to ButtonGroup
        cars.add(gas);
        cars.add(electric);
        // Adds to JFrame
        setLayout(new FlowLayout());
        add(car);
        add(gas);
        add(electric);

        // Pushes the Cars section to be align with the other sections
        String format = " ";
        format = format.repeat(53);     // set to 53 spaces (" ")
        JLabel spaces = new JLabel(format);
        setLayout(new FlowLayout());
        add(spaces);

        // Tank Size Section
        tank = new JLabel("Tank Size:     ");
        answer5 = new JTextField(30);
        tank.setFont(smallFont);
        tank.setEnabled(false);     // disabled by default
        answer5.setEnabled(false);  // disabled by default
        setLayout(new FlowLayout());
        add(tank);
        add(answer5);

        // Fuel Type Section
        fuel = new JLabel("Fuel Type:     ");
        answer6 = new JTextField(30);
        fuel.setFont(smallFont);
        fuel.setEnabled(false);     // disabled by default
        answer6.setEnabled(false);  // disabled by default
        setLayout(new FlowLayout());
        add(fuel);
        add(answer6);

        // Battery Size Section
        batSize = new JLabel("Battery Size: ");
        answer7 = new JTextField(30);
        batSize.setFont(smallFont);
        batSize.setEnabled(false);  // disabled by default
        answer7.setEnabled(false);  // disabled by default
        setLayout(new FlowLayout());
        add(batSize);
        add(answer7);

        // Battery Type Section
        batType = new JLabel("Battery Type:");
        answer8 = new JTextField(30);
        batType.setFont(smallFont);
        batType.setEnabled(false);  // disabled by default
        answer8.setEnabled(false);  // disabled by default
        setLayout(new FlowLayout());
        add(batType);
        add(answer8);

        // Submit & Return Buttons
        submit = new JButton("Submit");
        goBack = new JButton("Return");
        submit.addActionListener(this);
        goBack.addActionListener(this);
        submit.setFont(smallBoldFont);
        goBack.setFont(smallBoldFont);
        setLayout(new FlowLayout());
        add(submit);
        add(goBack);
        goBack.setVisible(false);   // hidden by default
    }


    /**
     * Invoked when an action occurs.
     * In this case, it performs validation on the data that was submitted and will create
     * objects based on what type of car was selected and creates a default GasCar object
     * when no car type is selected.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();  // gets the source (a button) that was clicked on
        exception =  false; // sets/resets flag so proper validation can be done

        if (source == submit) {
            if (gas.isSelected() || electric.isSelected()) {
                String iMake = checkMake();
                String iModel = checkModel();
                int iYear = checkYear();
                int iWeight = checkWeight();
                String iColor = checkColor();

                if (gas.isSelected()) {
                    gasCar(iMake, iModel, iYear, iWeight, iColor);
                } else {
                    electricCar(iMake, iModel, iYear, iWeight, iColor);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No car " +
                        "type was selected, defaulted to gas car");
                GasCar gCar = new GasCar(); // uses the default constructor
                MainForm.cars.add(gCar);
            }
            // If no Exceptions are caught
            if (!exception) {
                submitted();
            }
        } else {
            setVisible(false);  // closes this JFrame
        }
    }

    /**
     * Checks if the make that was submitted was left blank.
     * If it's blank, it will default to the data in the base class's default constructor.
     * @return returns a make
     */
    private String checkMake() {
        String make;

        if (answer1.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nothing was " +
                    "entered for make, defaulted to Honda");
            make = "Honda";
        } else {
            make = answer1.getText();
        }
        return make;
    }

    /**
     * Checks if the model that was submitted was left blank.
     * If it's blank, it will default to the data in the base class's default constructor.
     * @return returns a model
     */
    private String checkModel() {
        String model;

        if (answer2.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nothing was " +
                    "entered for model, defaulted to Civic");
            model = "Civic";
        } else {
            model = answer2.getText();
        }
        return model;
    }

    /**
     * Checks the year that was submitted is greater than 0.
     * If it's less than or equal to 0, it will default to the year in the base class's
     * default constructor.
     * @return returns a valid year
     */
    private int checkYear() {
        int year = 0;

        try {
            if (Integer.parseInt(answer3.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "Invalid year,"
                        + " defaulted to 2020");
                year = 2020;
            } else {
                year = Integer.parseInt(answer3.getText());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Year must be " +
                    "numeric and filled out");
            exception = true;
        }
        return year;
    }

    /**
     * Checks if the weight that was submitted is greater than 0.
     * If it's less than or equal to 0, it will default to the weight in the base class's
     * default constructor.
     * @return returns a valid weight
     */
    private int checkWeight() {
        int weight = 0;

        try {
            if (Integer.parseInt(answer4.getText()) <= 0 && !exception) {
                JOptionPane.showMessageDialog(this, "Invalid " +
                        "weight, defaulted to 2,875 lbs");
                weight = 2875;
            } else {
                weight = Integer.parseInt(answer4.getText());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Weight must be " +
                    "numeric and filled out");
            exception = true;
        }
        return weight;
    }

    /**
     * Checks if any color was selected.
     * If no color is selected, it will be defaulted to the color in the base class's
     * default constructor.
     * @return returns a color
     */
    private String checkColor() {
        String color = null;
        colorSelected = false;  // a flag for if a color was selected or not

        if (black.isSelected()) {
            color = black.getText();
            colorSelected = true;
        }
        if (white.isSelected()) {
            color = white.getText();
            colorSelected = true;
        }
        if (red.isSelected()) {
            color = red.getText();
            colorSelected = true;
        }
        if (blue.isSelected()) {
            color = blue.getText();
            colorSelected = true;
        }
        if (grey.isSelected()) {
            color = grey.getText();
            colorSelected = true;
        }
        // If no colors are selected and no Exceptions are caught
        if (!colorSelected && !exception) {
            JOptionPane.showMessageDialog(this, "No color was" +
                    " selected, defaulted to black");
            color = black.getText();
        }
        return color;
    }

    /**
     * Calls other methods to finish validation and if no Exceptions were found during
     * validation, it creates new GasCar objects and adds them to the cars list.
     * @param iMake passes the make of the car to create GasCar objects
     * @param iModel pass the car's model to create GasCar objects
     * @param iYear pass the car's year to create GasCar objects
     * @param iWeight pass the weight of the car to create GasCar objects
     * @param iColor pass the color of the color to create GasCar objects
     */
    private void gasCar(String iMake, String iModel, int iYear, int iWeight, String iColor) {
        double iTankSize = checkTankSize();
        String iFuelType = checkFuelType();

        // If no Exceptions are caught
        if (!exception) {
            GasCar gCar = new GasCar(iMake, iModel, iYear, iColor, iWeight, iTankSize, iFuelType);
            MainForm.cars.add(gCar);
        }
    }

    /**
     * Checks if the tank size that was submitted is greater than 0.
     * If it's less than or equal to 0, will default to the data in the GasCar class's
     * default constructor.
     * @return returns a valid tank size
     */
    private double checkTankSize() {
        double tankSize = 0;

        try {
             if (Double.parseDouble(answer5.getText()) <= 0 && !exception) {
                 JOptionPane.showMessageDialog(this, "Invalid " +
                         "tank size, defaulted to 12.4 gal");
                 tankSize = 12.4;
             } else {
                 tankSize = Double.parseDouble(answer5.getText());
             }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tank size must " +
                    "be numeric and filled out");
            exception = true;
        }
        return tankSize;
    }

    /**
     * Checks if the fuel type that was submitted was left blank.
     * If it's blank, it will default to the fuel type in the GasCar's default
     * constructor.
     * @return returns a valid fuel type
     */
    private String checkFuelType() {
        String fuelType;

        if (answer6.getText().trim().isEmpty() && !exception) {
            JOptionPane.showMessageDialog(this, "Nothing was " +
                    "entered for fuel type, defaulted to gasoline");
            fuelType = "Gasoline";
        } else {
            fuelType = answer6.getText();
        }
        return fuelType;
    }

    /**
     * Calls other methods to finish validation and if no Exceptions were found during
     * validation, new ElectricCar objects are created and added to the list.
     * @param iMake passes the make of the car to create ElectricCar objects
     * @param iModel pass the car's model to create ElectricCar objects
     * @param iYear pass the car's year to create ElectricCar objects
     * @param iWeight pass the weight of the car to create ElectricCar objects
     * @param iColor pass the color of the car to create ElectricCar objects
     */
    private void electricCar(String iMake, String iModel, int iYear, int iWeight, String iColor) {
        double iBatterySize = checkBatterySize();
        String iBatteryType = checkBatteryType();

        // If no Exceptions are caught
        if (!exception) {
            ElectricCar eCar = new ElectricCar(iMake, iModel, iYear, iColor, iWeight, iBatterySize, iBatteryType);
            MainForm.cars.add(eCar);
        }
    }

    /**
     * Checks if the battery size that was submitted is greater than 0.
     * If it's less than or equal to 0, it will default to the battery size in the
     * ElectricCar class's default constructor.
     * @return returns a valid battery size
     */
    private double checkBatterySize() {
        double batterySize = 0;

        try {
            if (Double.parseDouble(answer7.getText()) <= 0 && !exception) {
                JOptionPane.showMessageDialog(this, "Invalid" +
                        " battery size, defaulted to 85 kw");
                batterySize = 85;
            } else {
                batterySize = Double.parseDouble(answer7.getText());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Battery size must" +
                    " be numeric and filled out");
            exception = true;
        }
        return batterySize;
    }

    /**
     * Checks if the battery type that was submitted left blank.
     * If it's blank, it will default to the battery type in the ElectricCar class's
     * default constructor.
     * @return returns a valid battery type
     */
    private String checkBatteryType() {
        String batteryType;

        if (answer8.getText().trim().isEmpty() && !exception) {
            JOptionPane.showMessageDialog(this, "Nothing was " +
                    "entered for battery type, defaulted to lithium-ion battery");
            batteryType = "Lithium-ion";
        } else {
            batteryType = answer8.getText();
        }
        return batteryType;
    }

    /**
     * Disables all controls after the form is submitted.
     * Also replaces the submit button with the return button.
     */
    private void submitted() {
        submit.setVisible(false); // hides submit button
        goBack.setVisible(true); // replaces submit button with return button

        if (electric.isSelected()) {
            answer7.setEnabled(false);
            answer8.setEnabled(false);
        } else {
            answer5.setEnabled(false);
            answer6.setEnabled(false);
        }
        answer1.setEnabled(false);
        answer2.setEnabled(false);
        answer3.setEnabled(false);
        answer4.setEnabled(false);
        black.setEnabled(false);
        white.setEnabled(false);
        red.setEnabled(false);
        blue.setEnabled(false);
        grey.setEnabled(false);
        gas.setEnabled(false);
        electric.setEnabled(false);
    }


    /**
     * Invoked when an item has been selected or deselected by the user.
     * The code written for this method performs the operations that need to occur when
     * an item is selected (or deselected).
     * In this case, it enables controls based on which type of car was selected.
     * @param e the event to be processed
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        int selected = e.getStateChange();

        if (source == gas) {
            if (selected == ItemEvent.SELECTED) {
                // Enables gas controls when selected
                tank.setEnabled(true);
                answer5.setEnabled(true);
                fuel.setEnabled(true);
                answer6.setEnabled(true);
            } else {
                // Disables gas controls when not selected
                tank.setEnabled(false);
                answer5.setEnabled(false);
                fuel.setEnabled(false);
                answer6.setEnabled(false);
            }
        } else if (source == electric) {
            if (selected != ItemEvent.SELECTED) {
                // Disables electric controls when not selected
                batSize.setEnabled(false);
                answer7.setEnabled(false);
                batType.setEnabled(false);
                answer8.setEnabled(false);
            } else {
                // Enables electric controls when selected
                batSize.setEnabled(true);
                answer7.setEnabled(true);
                batType.setEnabled(true);
                answer8.setEnabled(true);
            }
        }
    }
}