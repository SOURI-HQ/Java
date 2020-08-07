package tictactoe;
import java.util.Scanner;

public class Main {
    public static void printField (char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }

    public static boolean isInputCorrect (String input) {
        if (input.matches("[0-9]")) {
            if (input.matches("[1-3]")) {
                return true;
            }
            else {
                System.out.println("Coordinates should be from 1 to 3!");
                return false;
            }
        }
        else {
            System.out.println("You should enter numbers!");
            return false;
        }
    }

    public static char whatIsNextSymbol (String cells) {
        int numberOfX = 0, numberOfO = 0;
        for (int i = 0; i < cells.length(); i++) {
            if (cells.charAt(i) == 'X') numberOfX++;
            else if (cells.charAt(i) == 'O') numberOfO++;
        }
        if (numberOfX == numberOfO || numberOfX < numberOfO) return 'X';

        else return 'O';
    }

    public static String getResults (char[][] board) {
        int j = 0;
        for (int i = 0; i < 3; i++) {
            // horizontally
            if (board[i][j] != ' ' && board[i][j] == board[i][j+1] && board[i][j+1] == board[i][j+2])
                return board[i][j] + " wins";
            // vertically
            if (board[j][i] != ' ' && board[j][i] == board[j+1][i] && board[j][i] == board[j+2][i])
                return board[j][i] + " wins";
        }
        // diagonally
        if (board[1][1] != ' ' && board[0][0] == board[1][1] && board [1][1] == board[2][2] || board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[1][1] + " wins";

        for (int i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return "Game not finished";
            }
        }
        return "Draw";
    }

    public static void main(String[] args) {
        char[][] field = new char[3][3];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String cells = scanner.next().replace("_", " ");
        int xInt, yInt, counter = 0;
        String x, y;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = cells.charAt(counter++);
            }
        }
        printField(field);

        while (true) {
            scanner.nextLine(); // taking scanner stream to the next line in order to omit last user's input
            System.out.print("Enter the coordinates: ");
            x = scanner.next();
            if (isInputCorrect(x)) {
                y = scanner.next();
            }
            else continue; // skipping current iteration so isInputCorrect won't throw NullPointerException
            if (isInputCorrect(y)) {
                xInt = Integer.parseInt(x) - 1;
                yInt = Integer.parseInt(y);
                yInt = yInt == 1 ? 2 : yInt == 3 ? 0 : 1;
                if (field[yInt][xInt] == ' ') {
                    field[yInt][xInt] = whatIsNextSymbol(cells);
                    printField(field);
                    System.out.println(getResults(field));
                }
                else { System.out.println("This cell is occupied! Choose another one!"); continue; }
                break;
            }
        }
    }
}