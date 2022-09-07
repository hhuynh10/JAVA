public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        account1.deposit(100, "checking");
        account1.deposit(300, "saving");
        account1.withdraw(150, "checking");
        account1.withdraw(150, "saving");
        System.out.println(account1.getChecking());
        System.out.println(account1.getSaving());
        System.out.println(account1.totalMoney());
    }
}