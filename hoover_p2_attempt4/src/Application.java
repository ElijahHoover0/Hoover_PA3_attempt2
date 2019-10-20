public class Application extends SavingsAccount{
    public static void main(String[] args){
        SavingsAccount saver1 = new SavingsAccount(200000);
        SavingsAccount saver2 = new SavingsAccount(300000);
        SavingsAccount.modifyInterestRate(.04);
        System.out.println("New savings for saver1 is: " + (saver1.calculateMonthlyInterest() * .01));
        System.out.println("New savings for saver2 is: " + (saver2.calculateMonthlyInterest() * .01));
        SavingsAccount.modifyInterestRate(.05);
        System.out.println("New savings for saver1 is: " + (saver1.calculateMonthlyInterest() * .01));
        System.out.println("New savings for saver2 is: " + (saver2.calculateMonthlyInterest() * .01));
    }
}
