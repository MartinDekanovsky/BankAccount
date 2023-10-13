package bank_account;

/**
 * Class extends the functionality of class BankAccount.
 * It's possible to open a new saving bank account either with zero initial balance and specified interest rate
 * or with specified initial balance and interest rate.
 *
 * @author Martin Dekanovský
 */
public class SavingAccount extends BankAccount {

    private double interestRate;

    /**
     * Constructor for opening a new saving bank account with zero initial balance and specified interest rate.
     *
     * @param interestRate Interest rate.
     */
    public SavingAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Constructor for opening a new saving bank account with specified initial balance and interest rate.
     *
     * @param balance Account initial balance.
     * @param interestRate Interest rate.
     */
    public SavingAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    /**
     * Method for crediting the saving account with interest at the end of the year.
     * The interest is rounded to two decimal places.
     */
    public void creditInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(Math.round(interest * 100.0) / 100.0);
    }
}

