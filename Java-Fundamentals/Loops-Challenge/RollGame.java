import java.util.Scanner;

public class RollGame {
    public static void main(String[] args) {
        System.out.println("Let's play Rolling Java. Type anything to start.\n");
        System.out.println("Great, here are the rules:\n");
        System.out.println("• If you roll a 6 the game stops.");
        System.out.println("• If you roll a 4 nothing happens.");
        System.out.println("• Otherwise, you get 1 point\n.");
        System.out.println("You must collect at least 3 points to win. Enter anything to roll:");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        int score = 0;
        while (true) {

            long dice = Math.round(((Math.random()) * 6));
            System.out.print("\nYou rolled a " + dice);
            if (dice == 6) {
                System.out.print(" End of game.");
                break;
            } else if (dice == 4) {
                System.out.print(" Zero point. Keep rolling.");
            } else {
                score++;
                System.out.print(" One point. Keep rolling.");
            }
        }
        if (score >= 3) {
            System.out.println("\nWow, that's lucky. You win!");
        } else {
            System.out.println("\nTough luck, you lose :( ");
        }
        scan.close();
    }

}
