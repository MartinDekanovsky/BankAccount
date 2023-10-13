package bank_account;

/**
 * Class allows to open a new bank account either with zero or specified initial balance.
 * It's possible to deposit, withdraw, show balance or transfer funds to another account.
 *
 * @author Martin Dekanovský
 */
public class BankAccount {

    private double balance;

    /**
     * Constructor for opening a new bank account with zero initial balance.
     */
    public BankAccount() {
        balance = 0;
    }

    /**
     * Constructor for opening a new bank account with specified initial balance.
     *
     * @param balance Account initial balance.
     */
    public BankAccount(double balance) {
        this.balance = balance;
    }

    /**
     * Method for depositing specified amount to bank account.
     *
     * @param amount Amount that will be deposited.
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Method for withdrawing specified amount from bank account.
     *
     * @param amount Amount that will be withdrawn.
     */
    public void withdraw(double amount) {
        balance -= amount;
    }

    /**
     * Method for showing account balance.
     *
     * @return account balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Method for transferring specified amount to another account.
     *
     * @param amount Amount that will be transferred to another account.
     * @param bankAccount Funds will be transferred to this account.
     */
    public void transfer(double amount, BankAccount bankAccount) {
        withdraw(amount);
        bankAccount.deposit(amount);
    }
}
