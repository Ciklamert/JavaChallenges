import java.util.Scanner;

public class Javapedia {
    public static void main(String[] args) {
        System.out.println("\n**********Javapedia**********");
        Scanner scan = new Scanner(System.in);
        System.out.print("\nHow many historical figures will you register? ");
        int amount = scan.nextInt();
        scan.nextLine();
        System.out.println();
        String[][] database = new String[amount][3];
        for (int i = 0; i < database.length; i++) {
            System.out.println("\tFigure " + (i + 1));
            for (int j = 0; j < database[i].length; j++) {
                System.out.print("\t");
                switch (j) {
                    case 0:
                        System.out.print("Name: ");
                        break;
                    case 1:
                        System.out.print("Date of birth: ");
                        break;
                    case 2:
                        System.out.print("Occupation: ");
                        break;
                    default:
                        break;
                }
                String entry = scan.nextLine();
                database[i][j] = entry;
            }
            System.out.println();
        }
        print2DArray(database);
        System.out.print("\nWho do you want information on? ");
        String name = scan.nextLine();
        System.out.println();
        for (int i = 0; i < database.length; i++) {
            for (int j = 0; j < database[i].length; j++) {
                System.out.print("\t");
                if (database[i][0].equals(name)) {
                    switch (j) {
                        case 0:
                            System.out.print("Name: ");
                            break;
                        case 1:
                            System.out.print("Date of birth: ");
                            break;
                        case 2:
                            System.out.print("Occupation: ");
                            break;
                        default:
                            break;

                    }
                    System.out.print(database[i][j] + " ");
                }
                System.out.println();
            }
        }
        scan.close();
    }

    public static void print2DArray(String[][] array) {
        System.out.println("These are the values you stored: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
