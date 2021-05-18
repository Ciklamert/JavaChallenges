import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    public static String[] words = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel", "cat", "clam",
            "cobra", "cougar", "coyote", "crow", "deer", "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog",
            "goat", "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose", "mouse", "mule", "newt",
            "otter", "owl", "panda", "parrot", "pigeon", "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon",
            "seal", "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan", "tiger", "toad", "trout",
            "turkey", "turtle", "weasel", "whale", "wolf", "wombat", "zebra" };

    public static String[] gallows = {
            "+---+\n" + "|   |\n" + "    |\n" + "    |\n" + "    |\n" + "    |\n" + "=========\n",

            "+---+\n" + "|   |\n" + "O   |\n" + "    |\n" + "    |\n" + "    |\n" + "=========\n",

            "+---+\n" + "|   |\n" + "O   |\n" + "|   |\n" + "    |\n" + "    |\n" + "=========\n",

            " +---+\n" + " |   |\n" + " O   |\n" + "/|   |\n" + "     |\n" + "     |\n" + " =========\n",

            " +---+\n" + " |   |\n" + " O   |\n" + "/|\\  |\n" + "     |\n" + "     |\n" + " =========\n",

            " +---+\n" + " |   |\n" + " O   |\n" + "/|\\  |\n" + "/    |\n" + "     |\n" + " =========\n",

            " +---+\n" + " |   |\n" + " O   |\n" + "/|\\  |\n" + "/ \\  |\n" + "     |\n" + " =========\n" };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = randomWord(words);
        int mistakeAmount = 0;
        char[] placeholder = createPlaceholder(word);
        char[] wrongGuesses = new char[7];
        while (mistakeAmount <= 6) {
            printEverything(placeholder, wrongGuesses, mistakeAmount);
            char guess = scan.nextLine().charAt(0);
            if (checkGuess(guess, word)) {
                placeholder = updatePlaceholder(placeholder, guess, word);
            } else {
                wrongGuesses[mistakeAmount] = guess;
                mistakeAmount++;
            }
            if (Arrays.equals(placeholder, word.toCharArray())) {
                System.out.println("You won!");
                break;
            }
        }

        if (mistakeAmount > 6) {
            System.out.println("You lost! The word was " + word);
        }
        scan.close();
    }

    public static char[] createPlaceholder(String word) {
        char[] placeholder = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            placeholder[i] = '_';
        }
        return placeholder;
    }

    public static void printPlaceholder(char[] placeholder) {
        for (int i = 0; i < placeholder.length; i++) {
            System.out.print(placeholder[i] + " ");
        }
    }

    public static char[] updatePlaceholder(char[] placeholder, char guess, String word) {
        char[] newPlaceholder = new char[placeholder.length];
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                newPlaceholder[i] = guess;
            } else {
                newPlaceholder[i] = placeholder[i];
            }
        }
        return newPlaceholder;
    }

    public static String randomWord(String[] words) {
        int indexNumber = (int) (Math.random() * words.length);
        return words[indexNumber];
    }

    public static void printWrongGuesses(char[] wrongGuesses) {
        for (int i = 0; i < wrongGuesses.length; i++) {
            System.out.print(wrongGuesses[i]);
        }
    }

    public static void printEverything(char[] placeholder, char[] wrongGuesses, int mistakeAmount) {
        System.out.print("\n" + gallows[mistakeAmount]);
        System.out.print("\nWord:\t");
        printPlaceholder(placeholder);
        System.out.print("\nMisses:\t");
        printWrongGuesses(wrongGuesses);
        System.out.print("\nGuess:\t");
    }

    public static boolean checkGuess(char guess, String word) {
        boolean isInclude = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                isInclude = true;
            }
        }
        return isInclude;
    }
}