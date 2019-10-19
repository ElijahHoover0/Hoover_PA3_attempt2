import java.util.Scanner;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.NoSuchProviderException;

public class ProblemPartOne {
    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException {
        Scanner scnr = new Scanner(System.in);

        int difficulty;
        int numCorrect;
        int typeOfProblem;
        for(int j = 1;j<2;) {
            System.out.println("Please select your problem difficulty, from 1 to 4, 4 being the most difficult.");
            difficulty = scnr.nextInt();
            System.out.println("Please select a problem type you would like to be tested on.\nType 1 for addition, 2 for multiplication, 3 for subtraction, 4 for division, and 5 for a mix of all types");
            typeOfProblem = scnr.nextInt();
            numCorrect = 0;
            for (int i = 0; i < 10; i++) {
                double answer = questionGenerator(difficulty, typeOfProblem);
                double userAnswer = scnr.nextDouble();
                if (userAnswer == answer) {
                    response(true);
                    numCorrect++;
                } else if((double)Math.abs(answer - userAnswer)<0.01) {
                    response(true);
                } else {
                    response(false);
                }
            }
            System.out.println("You got " + numCorrect + " correct and " + (10 - numCorrect) + " incorrect");
            if((double)(numCorrect/10.0)<.75){
                System.out.println("Please ask your teacher for extra help.");
            }else{
                System.out.println("Congratulations, you are ready to go to the next level!");
            }
            System.out.println("Would you like to start a new session?\n1 = yes, 2 = no");
            j = scnr.nextInt();
        }
    }
    private static int questionDifficulty(int levelOfDifficulty){
        int bounds = 0;
        switch(levelOfDifficulty){
            case 1:
               bounds =  9;
               break;
            case 2:
                bounds = 99;
                break;
            case 3:
                bounds = 999;
                break;
            case 4:
                bounds = 9999;
                break;
        }
        return bounds;
    }
    private static double questionGenerator(int difficultyOfQuestion, int questionType) throws NoSuchProviderException, NoSuchAlgorithmException {
        int num1 = rng(questionDifficulty(difficultyOfQuestion))+1;
        int num2 = rng(questionDifficulty(difficultyOfQuestion))+1;
        double solveFor = 0;
        switch(questionType) {
            case 1:
                solveFor = num1 + num2;
                System.out.println("How much is " + num1 + " plus " + num2 + "?");
                break;
            case 2:
                solveFor = num1 * num2;
                System.out.println("How much is " + num1 + " times " + num2 + "?");
                break;
            case 3:
                solveFor = num1 - num2;
                System.out.println("How much is " + num1 + " minus " + num2 + "?");
                break;
            case 4:
                solveFor = (double)num1 / num2;
                System.out.println("How much is " + num1 + " divided by " + num2 + "?");
                break;
            case 5:
                switch(rng(4)+1){
                    case 1:
                        solveFor = num1 + num2;
                        System.out.println("How much is " + num1 + " plus " + num2 + "?");
                        break;
                    case 2:
                        solveFor = num1 * num2;
                        System.out.println("How much is " + num1 + " times " + num2 + "?");
                        break;
                    case 3:
                        solveFor = num1 - num2;
                        System.out.println("How much is " + num1 + " minus " + num2 + "?");
                        break;
                    case 4:
                        solveFor = (double)num1 / num2;
                        System.out.println("How much is " + num1 + " divided by " + num2 + "?");
                        break;
                }
        }
        return solveFor;
    }
    private static int rng(int bounds) throws NoSuchProviderException, NoSuchAlgorithmException {
        SecureRandom randNumGen = SecureRandom.getInstance("SHA1PRNG","SUN");

        int num = randNumGen.nextInt(bounds);
        return num;
    }
    private static void response(boolean correctOrIncorrect) throws NoSuchProviderException, NoSuchAlgorithmException{
        if(correctOrIncorrect) {
            switch (rng(3)) {
                case 0:
                    System.out.println("Very good!");
                    break;
                case 1:
                    System.out.println("Excellent!");
                    break;
                case 2:
                    System.out.println("Nice work!");
                    break;
                case 3:
                    System.out.println("Keep up the good work!");
                    break;
            }
        }
        else {
            switch (rng(3)) {
                case 0:
                    System.out.println("No. Please try again.");
                    break;
                case 1:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 2:
                    System.out.println("Don’t give up!");
                    break;
                case 3:
                    System.out.println("No. Keep trying.");
                    break;
            }
        }
    }
}
