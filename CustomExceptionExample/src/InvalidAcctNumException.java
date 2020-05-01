public class InvalidAcctNumException extends Exception {
    public InvalidAcctNumException()
    {
        super("Customer account number must be > 0");
    }
}
