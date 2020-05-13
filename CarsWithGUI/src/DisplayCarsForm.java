import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lucas Chapman 4/30/2020.
 * This class is used to display all GasCar and ElectricCar objects that have been created.
 */
public class DisplayCarsForm extends JFrame implements ActionListener {
    JButton goBack;

    /**
     * DisplayCarsForm's default constructor
     */
    public DisplayCarsForm() {
        /*
         * JFrame
         */
        super("Display Cars Form"); // calls the JFrame class's default constructor
        setSize(855, 625);
        setVisible(true);

        /*
         * JLabels & Fonts
         */
        // Title & Fonts
        Font bigFont = new Font("Helvetica", Font.BOLD, 30);
        Font smallBoldFont = new Font("Helvetica", Font.BOLD, 16);
        Font smallFont = new Font("Helvetica", Font.PLAIN, 14);
        JLabel title = new JLabel("Display Cars Form");
        title.setFont(bigFont);
        setLayout(new FlowLayout());
        add(title);

        /*
         * Two different loops are used to pass the String variable to JLabel's constructor
         * outside of the loop used to loop thru objects as required for this project.
         */
        String data;    // used to store objects in the cars list
        List carObjects = new List(); // used to store the data in the String variable data

        // Loop that stores all the objects in the list
        for (int i = 0; i < MainForm.cars.size(); i++) {
            // Removes line break characters since they are not supported by JLabels
            // Replaces those characters with semicolons
            data = MainForm.cars.get(i).toString().replace("\n", "; ") + ";";
            carObjects.add(data);
        }
        // Loop to add objects to the JFrame
        for (int i = 0; i < carObjects.getItemCount(); i++) {
            data = carObjects.getItem(i); // puts objects back in the String variable data
            JLabel car = new JLabel(data);
            car.setFont(smallFont);
            setLayout(new FlowLayout());
            add(car);
        }

        /*
         * JLabel & JButton
         */
         // Adds an empty row above the button
         String format = " ";
         format = format.repeat(500); // set to 500 spaces (" ")
         JLabel emptyRow = new JLabel(format);
         setLayout(new FlowLayout(FlowLayout.LEADING));
         add(emptyRow);

         // Return Button
         goBack = new JButton("Return");
         goBack.setFont(smallBoldFont);
         goBack.setVerticalAlignment(SwingConstants.BOTTOM);
         goBack.addActionListener(this);
         setLayout(new FlowLayout(FlowLayout.CENTER));
         add(goBack);
    }


    /**
     * Invoked when an action occurs.
     * Closes the JFrame when the Return button is clicked on.
     * @param e the event to be processed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);  // closes the Display Cars Form
    }
}