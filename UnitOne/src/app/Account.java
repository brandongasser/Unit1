package app;

public class Account {
    
    private float balance;
    private String password;
    private final int accountNumber;

    public Account(float balance, int accountNumber, String password) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.password = password;
    }

    public float getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public void deposit(float amount) {
        this.balance += amount;
    }

    public void withdraw(float amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

}