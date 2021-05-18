
public class Dice {
    public static void main(String[] args) {

        long dice1 = 0;
        long dice2 = 1;

        while (dice1 != dice2) {

            dice1 = Math.round(((Math.random()) * 6));
            System.out.println("Dice 1: " + dice1);

            dice2 = Math.round(((Math.random()) * 6));
            System.out.println("Dice 2: " + dice2 + "\n");
        }

        System.out.println("You rolled doubles!");
    }
}
