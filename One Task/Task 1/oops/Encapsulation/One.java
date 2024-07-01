class BankAccount {
    private String accountNumber;
    private int balence;

    BankAccount(String accNo, int bal) {
        this.accountNumber = accNo;
        this.balence = bal;
    }

    void depositMoney(int bal) {
        this.balence += bal;
    }

    void withdrawMoney(int bal) {
        if(this.balence > bal) {
            this.balence -= bal;
        }else {
            System.out.println("Balence is insufficient. Deposit Money To Withdraw");
        }
    }

    void showBankDetails() {
        System.out.println("Bank Account No.: "+this.accountNumber);
        System.out.println("Bank Account Balence: "+this.balence);
    }
}