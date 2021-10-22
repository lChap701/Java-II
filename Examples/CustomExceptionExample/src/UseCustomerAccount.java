import javax.swing.*;
public class UseCustomerAccount
{
   public static void main(String[] args)
   {
      int num = 0;
      double balance = 0;
      String input = "";

      try
      {
         input = JOptionPane.showInputDialog(null,
                 "Enter account number");
         num = Integer.parseInt(input);
         input = JOptionPane.showInputDialog(null, "Enter balance due");
         balance = Double.parseDouble(input);
         CustomerAccount ca = new CustomerAccount(num, balance);
         JOptionPane.showMessageDialog(null, "Customer #" +
            num + " has a balance of $" + balance);
      }
      catch( HighBalanceException hbe)
      {
         JOptionPane.showMessageDialog(null, "Customer #" +
            num + " has a balance of $" + balance +
            " which is higher than the credit limit");
      }
      catch( InvalidAcctNumException iAcctNumExc)
      {
         JOptionPane.showMessageDialog(null, iAcctNumExc.getMessage());
      }
      catch( Exception hbe)
      {
         JOptionPane.showMessageDialog(null, "Oops");
      }
   }
}
