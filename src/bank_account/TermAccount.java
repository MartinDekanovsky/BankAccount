package bank_account;

/**
 * Class extends the functionality of class BankAccount.
 * It's possible to open a new term bank account either with zero initial balance and specified interest rate and fixed period
 * or with specified initial balance, interest rate and fixed period.
 * A fine will be charged for each withdrawal from the account before the fixed period is over.
 * A transfer to another account is also considered a withdrawal.
 *
 * @author Martin Dekanovský
 */
public class TermAccount extends BankAccount {

    private double interestRate;
    private double fixedPeriodInYears;
    private static final double FINE_FOR_EARLY_WITHDRAWAL = 20;

    /**
     * Constructor for opening a new term bank account with zero initial balance and specified interest rate and fixed period.
     *
     * @param interestRate Interest rate.
     * @param fixedPeriodInYears Fixed period in years.
     */
    public TermAccount(double interestRate, double fixedPeriodInYears) {
        this.interestRate = interestRate;
        this.fixedPeriodInYears = fixedPeriodInYears;
    }

    /**
     * Constructor for opening a new term bank account with specified initial balance, interest rate and fixed period.
     *
     * @param balance Account initial balance.
     * @param interestRate Interest rate.
     * @param fixedPeriodInYears Fixed period in years.
     */
    public TermAccount(double balance, double interestRate, double fixedPeriodInYears) {
        super(balance);
        this.interestRate = interestRate;
        this.fixedPeriodInYears = fixedPeriodInYears;
    }

    /**
     * Method for withdrawing specified amount from bank account.
     * A fine will be charged for each withdrawal before the fixed period is over.
     * A transfer to another account is also considered a withdrawal.
     *
     * @param amount Amount that will be withdrawn.
     */
    @Override
    public void withdraw(double amount) {
        if (fixedPeriodInYears > 0) {
            super.withdraw(amount + FINE_FOR_EARLY_WITHDRAWAL);
        }
        else {
            super.withdraw(amount);
        }
    }

    /**
     * Method for crediting the term account with interest at the end of the year.
     * The interest is rounded to two decimal places.
     * Fixed period is decremented by one year.
     */
    public void creditInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(Math.round(interest * 100.0) / 100.0);
        fixedPeriodInYears--;
    }
}
