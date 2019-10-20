public class SavingsAccount {
    private static double annualInterestRate = 0;
    private int savingsBalance;

    //Constructors
    SavingsAccount(){
        this.savingsBalance=0;
    }
    SavingsAccount(int initialSavings){
        this.savingsBalance = initialSavings;
    }

    //Main
    /*public static void main(String[] args){
        //Below initializes an object obj1
        SavingsAccount obj1 = new SavingsAccount();
    }*/

    //Methods
    public int calculateMonthlyInterest() {
        int interest;

        interest = (int)(this.savingsBalance * annualInterestRate / 12);
        this.savingsBalance = this.savingsBalance+interest;
        return this.savingsBalance;
    }
    public static void modifyInterestRate(double newRate){
        annualInterestRate = newRate;
    }

}
