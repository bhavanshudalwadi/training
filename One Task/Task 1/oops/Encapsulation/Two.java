public class Two {
    public static void main(String args[]) {
        BankAccount b = new BankAccount("911234567890", 0);
        b.depositMoney(1000);
        b.showBankDetails();
        b.withdrawMoney(1500);
        b.withdrawMoney(750);
        b.showBankDetails();
    }
}