import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Let's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
        System.out.println("Are you ready? Write 'yes' if you are.");
        String option = scan.nextLine();
        if (option.equalsIgnoreCase("yes")) {
            System.out.println("Great!");
            System.out.println("rock – paper – scissors, shoot!");
            String userMove = scan.nextLine();
            String computerMove = computerChoice();
            printResult(userMove, computerMove, result(userMove, computerMove));
        } else {
            System.out.println("Darn, some other time...! ");
        }

        scan.close();
    }

    public static String computerChoice() {
        int choice = (int) (Math.random() * 3);
        switch (choice) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                break;
        }
        return "";
    }

    public static String result(String userChoice, String computerChoice) {
        String result = "";
        if ((userChoice.equals("rock") && computerChoice.equals("scissors"))
                || (userChoice.equals("paper") && computerChoice.equals("rock"))
                || (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            result = "You win!";
        } else if ((userChoice.equals("scissors") && computerChoice.equals("rock"))
                || (userChoice.equals("rock") && computerChoice.equals("paper"))
                || (userChoice.equals("paper") && computerChoice.equals("scissors"))) {
            result = "You lose!";
        } else if (userChoice.equals(computerChoice)) {
            result = "It's a tie!";
        }
        return result;
    }

    public static void printResult(String userChoice, String computerChoice, String result) {
        System.out.println("\nYou chose:        " + userChoice);
        System.out.println("The computer chose: " + computerChoice);
        System.out.println(result(userChoice, computerChoice));
    }
}