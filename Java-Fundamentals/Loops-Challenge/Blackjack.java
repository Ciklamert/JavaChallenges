import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        int userNumber1 = randomCardNumber();
        int userNumber2 = randomCardNumber();
        if (userNumber1 > 10) {
            userNumber1 = 10;
        }
        if (userNumber2 > 10) {
            userNumber2 = 10;
        }
        int handValue = userNumber1 + userNumber2;
        String userCard1 = drawRandomCard(userNumber1);
        String userCard2 = drawRandomCard(userNumber2);
        System.out.println("\n You get a \n" + userCard1 + "\n and a \n" + userCard2);
        System.out.println("your total is: " + handValue);
        int dealerNumber1 = randomCardNumber();
        if (dealerNumber1 > 10) {
            dealerNumber1 = 10;
        }
        String dealerCard1 = drawRandomCard(dealerNumber1);
        String dealerCard2 = faceDown();
        System.out.println("\n The dealer shows \n" + dealerCard1 + "\n and has a card facing down \n" + dealerCard2);
        System.out.println("\n The dealer's total is hidden");
        System.out.println("Would you like to hit or stay.");
        int dealerHandValue = dealerNumber1;
        Scanner scan = new Scanner(System.in);
        String option = scan.nextLine();
        if (option.equalsIgnoreCase("hit") || option.equalsIgnoreCase("stay")) {
            while (!option.equalsIgnoreCase("stay")) {
                int randomUserNumber = randomCardNumber();
                if (randomUserNumber > 10) {
                    randomUserNumber = 10;
                }
                String newCard = drawRandomCard(randomUserNumber);
                System.out.println("\n You get a  \n " + newCard);
                handValue = handValue + randomUserNumber;

                System.out.println("your new total is " + handValue);
                if (handValue > 21) {
                    System.out.println("Bust! Player loses");
                    System.exit(0);
                }
                System.out.println("Would you like to hit or stay.");
                option = scan.nextLine();
            }
            System.out.println("\n Dealer's turn");
            int randomNumber = randomCardNumber();
            dealerHandValue = dealerHandValue + randomNumber;
            dealerCard2 = drawRandomCard(randomNumber);
            System.out.println("\n The dealer's cards are \n" + dealerCard1 + "\n and a \n" + dealerCard2);
            System.out.println("\n Dealer's total is " + dealerHandValue);
            if (randomNumber > 10) {
                randomNumber = 10;
            }
            while (option.equalsIgnoreCase("stay") && dealerHandValue < 17) {
                int dealerRandomNumber = randomCardNumber();
                if (dealerRandomNumber > 10) {
                    dealerRandomNumber = 10;
                }
                dealerHandValue = dealerHandValue + dealerRandomNumber;
                String newDealerCard = drawRandomCard(dealerRandomNumber);
                System.out.println("\n Dealer gets a \n" + newDealerCard);
                System.out.println("\n Dealer's total is " + dealerHandValue);
                if (dealerHandValue > 21) {
                    System.out.println("Bust! Dealer loses");
                    System.exit(0);
                }
            }
        } else {
            System.out.println("Please write 'hit' or 'stay'");
        }
        if (handValue > dealerHandValue) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer wins!");
        }
        scan.close();
    }

    public static int randomCardNumber() {
        double number = (Math.random() * 13) + 1;
        int randomNumber = (int) number;
        return randomNumber;
    }

    public static String drawRandomCard(int randomNumber) {

        switch (randomNumber) {
        case 1:
            return "   _____\n" + "  |A _  |\n" + "  | ( ) |\n" + "  |(_'_)|\n" + "  |  |  |\n" + "  |____V|\n";
        case 2:
            return "   _____\n" + "  |2    |\n" + "  |  o  |\n" + "  |     |\n" + "  |  o  |\n" + "  |____Z|\n";
        case 3:
            return "   _____\n" + "  |3    |\n" + "  | o o |\n" + "  |     |\n" + "  |  o  |\n" + "  |____E|\n";
        case 4:
            return "   _____\n" + "  |4    |\n" + "  | o o |\n" + "  |     |\n" + "  | o o |\n" + "  |____h|\n";
        case 5:
            return "   _____ \n" + "  |5    |\n" + "  | o o |\n" + "  |  o  |\n" + "  | o o |\n" + "  |____S|\n";
        case 6:
            return "   _____ \n" + "  |6    |\n" + "  | o o |\n" + "  | o o |\n" + "  | o o |\n" + "  |____6|\n";
        case 7:
            return "   _____ \n" + "  |7    |\n" + "  | o o |\n" + "  |o o o|\n" + "  | o o |\n" + "  |____7|\n";
        case 8:
            return "   _____ \n" + "  |8    |\n" + "  |o o o|\n" + "  | o o |\n" + "  |o o o|\n" + "  |____8|\n";
        case 9:
            return "   _____ \n" + "  |9    |\n" + "  |o o o|\n" + "  |o o o|\n" + "  |o o o|\n" + "  |____9|\n";
        case 10:
            return "   _____ \n" + "  |10  o|\n" + "  |o o o|\n" + "  |o o o|\n" + "  |o o o|\n" + "  |___10|\n";
        case 11:
            return "   _____\n" + "  |J  ww|\n" + "  | o {)|\n" + "  |o o% |\n" + "  | | % |\n" + "  |__%%[|\n";
        case 12:
            return "   _____\n" + "  |Q  ww|\n" + "  | o {(|\n" + "  |o o%%|\n" + "  | |%%%|\n" + "  |_%%%O|\n";
        case 13:
            return "   _____\n" + "  |K  WW|\n" + "  | o {)|\n" + "  |o o%%|\n" + "  | |%%%|\n" + "  |_%%%>|\n";
        default:
            return "This shouldn't get called.";
        }
    }

    public static String faceDown() {
        return "   _____\n" + "  |     |\n" + "  |  J  |\n" + "  | JJJ |\n" + "  |  J  |\n" + "  |_____|\n";
    }
}
