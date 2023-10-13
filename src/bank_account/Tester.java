package bank_account;

/**
 * Class for testing of implementation methods of class BankAccount and its subclasses.
 *
 * @author Martin Dekanovský
 */
public class Tester {

    public static void main(String[] args) {

        /*
        First, we test the opening of all accounts with zero initial balance,
        deposits, withdrawals and transfers from each account, the deducting of
        fees from the current account, the crediting of interest on the saving and
        term accounts, and fines for each early withdrawal on the term account:
         */
        System.out.println("Accounts with zero initial balance:\n");

        CurrentAccount currentAccount1 = new CurrentAccount();
        SavingAccount savingAccount1 = new SavingAccount(5.0);
        TermAccount termAccount1 = new TermAccount(10, 3);

        currentAccount1.deposit(1000);
        savingAccount1.deposit(10000);
        termAccount1.deposit(2000);

        currentAccount1.transfer(200, savingAccount1);
        currentAccount1.transfer(200, termAccount1);

        savingAccount1.transfer(1500, currentAccount1);
        savingAccount1.transfer(100, termAccount1);

        termAccount1.transfer(100, currentAccount1);
        termAccount1.transfer(300, savingAccount1);

        currentAccount1.withdraw(400);
        savingAccount1.withdraw(3000);
        termAccount1.withdraw(800);

        // End of first year:
        currentAccount1.deductFees();
        savingAccount1.creditInterest();
        termAccount1.creditInterest();

        System.out.println("Current account balance: " + currentAccount1.getBalance());
        System.out.println("Expected balance: 1797.4\n");

        System.out.println("Saving account balance: " + savingAccount1.getBalance());
        System.out.println("Expected balance: 6195.0\n");

        System.out.println("Term account balance: " + termAccount1.getBalance());
        System.out.println("Expected balance: 1144.0\n");

        /*
        Now we test the opening of all accounts with specified initial balance, deposits to all accounts, withdrawals
        and transfers from all accounts except for the term account in order to avoid the early withdrawal fine.
        Then we test the deducting of fees from the current account and the crediting of interest
        on the saving and term accounts for three years, and finally the withdrawal from the term account
        after the end of the fixed period.
         */
        System.out.println("Accounts with specified initial balance:\n");

        CurrentAccount currentAccount2 = new CurrentAccount(500);
        SavingAccount savingAccount2 = new SavingAccount(500,5.0);
        TermAccount termAccount2 = new TermAccount(500,10, 3);

        currentAccount2.deposit(500);
        savingAccount2.deposit(9500);
        termAccount2.deposit(1500);

        currentAccount2.transfer(200, savingAccount2);
        currentAccount2.transfer(200, termAccount2);

        savingAccount2.transfer(1500, currentAccount2);
        savingAccount2.transfer(100, termAccount2);

        currentAccount2.withdraw(400);
        savingAccount2.withdraw(3000);

        // End of first year:
        currentAccount2.deductFees();
        savingAccount2.creditInterest();
        termAccount2.creditInterest();

        // End of second year:
        currentAccount2.deductFees();
        savingAccount2.creditInterest();
        termAccount2.creditInterest();

        // End of third year:
        currentAccount2.deductFees();
        savingAccount2.creditInterest();
        termAccount2.creditInterest();

        // Fourth year (after the fixed period, i.e., it's now possible to withdraw from term account without fine):
        termAccount2.withdraw(500);

        System.out.println("Current account balance: " + currentAccount2.getBalance());
        System.out.println("Expected balance: 1693.6\n");

        System.out.println("Saving account balance: " + savingAccount2.getBalance());
        System.out.println("Expected balance: 6482.7\n");

        System.out.println("Term account balance: " + termAccount2.getBalance());
        System.out.println("Expected balance: 2561.3");
    }
}
