import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Chapman 4/30/2020.
 * This program is a modified version of the Cars program that uses a GUI interface and
 * can display all cars that have submitted to the form.
 * This class used to create a JFrame object and JButton objects to create a window with
 * two buttons on it with one being used to select the Car Entry Form and the other being
 * used to select the Display Cars Form.
 */
public class MainForm extends JFrame implements ActionListener {
    public static List<Object> cars = new ArrayList<>();    // list for all forms
    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        mainForm.setVisible(true);
    }

    JButton carEntry, displayCars;
    /**
     * MainForm's default constructor.
     */
    public MainForm() {
        /*
         * JFrame
         */
        super("Welcome");   // call to the JFrame class's default constructor
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 125);

        /*
         * JLabel & Fonts
         */
        // Title & Fonts
        JLabel title = new JLabel("Please Push One Of These Buttons:");
        Font bigFont = new Font("Helvetica", Font.BOLD, 25);
        Font smallFont = new Font("Helvetica", Font.BOLD, 16);
        title.setFont(bigFont);
        setLayout(new FlowLayout());
        add(title);

        /*
         * JButtons
         */
        // Car Entry & Display Cars Buttons
        carEntry = new JButton("Car Entry");
        displayCars = new JButton("Display Cars");
        carEntry.setFont(smallFont);
        displayCars.setFont(smallFont);
        carEntry.addActionListener(this);
        displayCars.addActionListener(this);
        setLayout(new FlowLayout());
        add(carEntry);
        add(displayCars);
    }


    /**
     * Invoked when an action occurs.
     * In this case, it opens a new JFrame depending on the button that was clicked on and
     * the amount of objects in the list of cars.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
       Object source = e.getSource();   // finds the source (a button) that was clicked on

       if (source == carEntry) {
           JOptionPane.showMessageDialog(this, carEntry.getText() +
                   " was selected");
           CarEntryForm entryForm = new CarEntryForm(); // displays form

       } else {
           // Determines if the Display Cars Form should be shown or not
           if (MainForm.cars.isEmpty()) {   // will not be displayed if list is empty
               JOptionPane.showMessageDialog(this, "No cars have " +
                       "been submitted yet, please click on the " + carEntry.getText() +
                       " button");
           } else {
               JOptionPane.showMessageDialog(this, displayCars.getText()
                       + " was selected");
               DisplayCarsForm carsForm = new DisplayCarsForm();   // displays form
           }
       }
    }
}