import java.util.Scanner;

public class DiceJack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter three numbers between 1 and 6");
        int userNum1 = scan.nextInt();
        int userNum2 = scan.nextInt();
        int userNum3 = scan.nextInt();
        if (userNum1 < 1 || userNum2 < 1 || userNum3 < 1) {
            System.out.println("Numbers cannot be less than 1. Shutting game down.");
            System.exit(0);
        }
        if (userNum1 > 6 || userNum2 > 6 || userNum3 > 6) {
            System.out.println("Numbers cannot be greater than 6. Shutting game down.");
            System.exit(0);
        }

        int userSum = userNum1 + userNum2 + userNum3;

        int dice1 = rollDice();
        int dice2 = rollDice();
        int dice3 = rollDice();
        int diceSum = dice1 + dice2 + dice3;

        System.out.println(dice1 + " " + dice2 + " " + dice3);
        System.out.println("Dice sum: " + diceSum);
        System.out.println("Sum of numbers: " + userSum);
        if (checkWin(userSum, diceSum)) {
            System.out.println("Congrats, You won!");
        } else {
            System.out.println("Sorry, you lost!");
        }
        scan.close();
    }

    public static int rollDice() {
        int dice = ((int) (Math.random() * 6)) + 1;
        return dice;
    }

    public static boolean checkWin(int userSum, int diceSum) {
        return userSum > diceSum && userSum - diceSum < 3;
    }
}
