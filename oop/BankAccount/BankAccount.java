public class BankAccount {
    private double checking;
    private double saving;

    public static int numberOfAccounts = 0;
    public static double totalAmount = 0;

    public BankAccount() {
        numberOfAccounts++;
    }

    public double getChecking() {
        return this.checking;
    }

    public double getSaving() {
        return this.saving;
    }

    public void deposit(double amount, String account) {
        if (account == "checking") {
            this.checking += amount;
        }
        if (account == "saving") {
            this.saving += amount;
        }
    }

    public void withdraw(double amount, String account) {
        if (account == "checking") {
            if (amount > this.checking) {
                System.out.println("Insufficient fund!");
            } else {
                this.checking -= amount;
            }
        }
        if (account == "saving") {
            if (amount > this.saving) {
                System.out.println("Insufficient fund!");
            } else {
                this.saving -= amount;
            }
        }
    }

    public double totalMoney() {
        totalAmount = this.checking + this.saving;
        return totalAmount;
    }
}