public class CustomerAccount {
   private int acctNum;
   private double balance;
   public static double HIGH_CREDIT_LIMIT = 20000.00;
   public CustomerAccount(int num, double bal) throws HighBalanceException, InvalidAcctNumException
   {
      acctNum = num;
      if(num <= 0){
         throw(new InvalidAcctNumException());
      }

      balance = bal;
      if(balance > HIGH_CREDIT_LIMIT){
         HighBalanceException hbe = new HighBalanceException();
         throw(hbe);
      }
  }
}
