public class TestReservation{

    public static void main(String[] args) {
        Reservation[] reservations;
        reservations = new Reservation[4];

        // test default constructor
        reservations[0] = new Reservation();

        //test parametrized constructor
        reservations[1] = new Reservation(1001, "Mickey Mouse", true);

        //test setters
        reservations[1].setResNumber(99);
        reservations[1].setResCustName("");

        //test getters
        System.out.println(reservations[1].getResNumber());
        System.out.println(reservations[1].getResCustName());
        System.out.println(reservations[1].getResFreqFlyer());

        System.out.println(reservations[1].toString());
    }
}
