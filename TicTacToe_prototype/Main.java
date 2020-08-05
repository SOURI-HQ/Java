package tictactoe;

import java.util.Scanner;

public class Main {
    public static void printBoard (char[][] board) {
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


    public static boolean isInteger (String input) {
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

    public static char nextMoveChar (String cells) {
        int numberOfX = 0, numberOfO = 0;
        for (int i = 0; i < cells.length(); i++) {
            if (cells.charAt(i) == 'X') {
                numberOfX++;
            }
            else if (cells.charAt(i) == 'O') {
                numberOfO++;
            }
        }
        if (numberOfX == numberOfO || numberOfX < numberOfO) {
            return 'X';
        }
        else return 'O';
    }

    public static String stateOfGame (char[][] board) {
        int j;
        for (int i = 0; i < 3; i++) {
            j = 0;
            if (board[i][j] != ' ' && board[i][j] == board[i][j+1] && board[i][j+1] == board[i][j+2]) {
                return board[i][j] + " wins";

            }
            if (board[j][i] != ' ' && board[j][i] == board[j+1][i] && board[j][i] == board[j+2][i]) {
                return board[j][i] + " wins";
            }
        }
        if (board[1][1] != ' ' && board[0][0] == board[1][1] && board [1][1] == board[2][2] || board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[1][1] + " wins";
        }
        for (int i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return "Game not finished";
            }
        }
        return "Draw";

    }

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String cells = scanner.next().replace("_", " ");
        int counter = 0;
        int xInt, yInt;
        String x = null, y = null;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = cells.charAt(counter++);
            }
        }
        printBoard(board);

        boolean correctInput = false;
        while (!correctInput) {
            System.out.print("Enter the coordinates: ");
            x = scanner.next();
            correctInput = isInteger(x);
            if(correctInput) {
                y = scanner.next();
                correctInput = isInteger(y);
            }
            if (correctInput) {
                xInt = Integer.parseInt(x) - 1;
                yInt = Integer.parseInt(y);
                yInt = yInt == 1 ? 2 : yInt == 3 ? 0 : 1;
                if (board[yInt][xInt] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    correctInput = false;
                }
                if (correctInput) {
                    board[yInt][xInt] = nextMoveChar(cells);
                    printBoard(board);
                    System.out.println(stateOfGame(board));
                }
            }
        }
    }
}
