import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = { { '_', '_', '_' }, { '_', '_', '_' }, { '_', '_', '_' } };
        printBoard(board);
        int count = 0;
        for (int i = 0; i < 9; i++) {
            System.out.print("Turn:");
            if (i % 2 == 0) {
                System.out.print(" X\n");
                int[] spot = askUser(board);
                board[spot[0]][spot[1]] = 'X';

            } else {
                System.out.print(" O\n");
                int[] spot = askUser(board);
                board[spot[0]][spot[1]] = 'O';
            }
            printBoard(board);
            count = checkWin(board);
            if (count == 3) {
                System.out.println("X wins!");
                break;
            } else if (count == -3) {
                System.out.println("O wins");
                break;
            } else if (i == 8) {
                System.out.println("It is a tie");
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n\n");
        }
    }

    public static int[] askUser(char[][] board) {

        System.out.print("Pick the row and column: ");
        int row = scan.nextInt();
        int column = scan.nextInt();
        while (board[row][column] != '_') {
            System.out.print("Spot taken, try again: ");
            row = scan.nextInt();
            column = scan.nextInt();
        }
        int[] spots = { row, column };
        return spots;

    }

    public static int checkWin(char[][] board) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                } else if (board[i][j] == 'O') {
                    count--;
                }
            }
            if (count == 3 || count == -3) {
                return count;
            } else {
                count = 0;
            }

        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == 'X') {
                    count++;
                } else if (board[j][i] == 'O') {
                    count--;
                }
            }
            if (count == 3 || count == -3) {
                return count;
            } else {
                count = 0;
            }

        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 'X') {
                count++;
            } else if (board[i][i] == 'O') {
                count--;
            }
        }
        if (count == 3 || count == -3) {
            return count;
        } else {
            count = 0;
        }
        for (int i = board.length - 1; i >= 0; i--) {
            int j = 2 - i;
            if (board[j][i] == 'X') {
                count++;
            } else if (board[j][i] == 'O') {
                count--;
            }

            if (count == 3 || count == -3) {
                return count;
            }

        }
        return count;
    }

}