package bank_account;

/**
 * Class extends the functionality of class BankAccount.
 * It's possible to open a new current bank account either with zero or specified initial balance.
 * It does not allow overdraft on the account, i.e. withdrawal of an amount that exceeds the account balance.
 * An annual fee for maintaining the account is deducted from the current account,
 * and if the number of free transactions is exceeded, a fee is also charged for each additional transaction.
 *
 * @author Martin Dekanovský
 */
public class CurrentAccount extends BankAccount {

    private int numberOfTransactions;
    private static final double ACCOUNT_MAINTENANCE_FEE = 2.0;
    private static final int NUMBER_OF_FREE_TRANSACTIONS = 3;
    private static final double TRANSACTION_FEE = 0.20;

    /**
     * Constructor for creating a new current bank account with zero initial balance.
     */
    public CurrentAccount() {
        numberOfTransactions = 0;
    }

    /**
     * Constructor for creating a new current bank account with specified initial balance.
     *
     * @param balance Account initial balance.
     */
    public CurrentAccount(double balance) {
        super(balance);
        numberOfTransactions = 0;
    }

    /**
     * Method for depositing specified amount to current account.
     *
     * @param amount Amount that will be deposited.
     */
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        numberOfTransactions++;
    }

    /**
     * Method for withdrawing specified amount from current account.
     * It does not allow overdraft on the account, i.e. withdrawal of an amount that exceeds the account balance.
     *
     * @param amount Amount that will be withdrawn.
     */
    @Override
    public void withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("Insufficient funds.");
            System.out.println("The transaction was declined!");
        } else {
            super.withdraw(amount);
            numberOfTransactions++;
        }
    }

    /**
     * Method for deducting the fees from current account balance.
     */
    public void deductFees() {
        double fees = ACCOUNT_MAINTENANCE_FEE;

        if (numberOfTransactions > NUMBER_OF_FREE_TRANSACTIONS)
        {
            fees += (numberOfTransactions - NUMBER_OF_FREE_TRANSACTIONS) * TRANSACTION_FEE;
        }

        super.withdraw(fees);
        numberOfTransactions = 0;
    }
}
