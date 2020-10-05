package tictactoe;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    private char[][] field = new char[3][3];
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public TicTacToe() {
        this(new User('X'), new AI('O', AI.Difficulty.EASY));
    }

    public TicTacToe(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.field[i][j] = ' ';
            }
        }

    }

    public void play() {
        while (getResults().equals("Game not finished")) {
            printField();
            registerMove(currentPlayer.getMove(this), currentPlayer.getSymbol());
            swapTurns();
        }
        printField();
        System.out.println(getResults());
    }


    public void swapTurns() {
        currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
    }

    public String getResults() {
        int j = 0;
        for (int i = 0; i < 3; i++) {
            // horizontally
            if (field[i][j] != ' ' && field[i][j] == field[i][j+1] && field[i][j+1] == field[i][j+2])
                return field[i][j] + " wins";
            // vertically
            if (field[j][i] != ' ' && field[j][i] == field[j+1][i] && field[j][i] == field[j+2][i])
                return field[j][i] + " wins";
        }
        // diagonally
        if (field[1][1] != ' ' && field[0][0] == field[1][1] && field[1][1] == field[2][2] || field[1][1] != ' ' && field[0][2] == field[1][1] && field[1][1] == field[2][0])
            return field[1][1] + " wins";

        for (int i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (field[i][j] == ' ') return "Game not finished";
            }
        }
        return "Draw";
    }

    public void registerMove(int[] board, char symbol) {
        field[board[0]][board[1]] = symbol;
    }

    public int[] isInputCorrect(String[] input) {
        if (input[0].matches("[0-9]") && input[1].matches("[0-9]")) {
            if (input[0].matches("[1-3]") && input[1].matches("[1-3]")) {
                int xInt = Integer.parseInt(input[0]) - 1;
                int yInt = Integer.parseInt(input[1]);
                yInt = yInt == 1 ? 2 : yInt == 3 ? 0 : 1;
                if (field[yInt][xInt] == ' ') {
                    return new int[] {yInt, xInt, 1};
                }
                else {
                    System.out.println("This cell is occupied! Choose another one!");
                    return new int[] {0, 0, 0};
                }
            }
            else {
                    System.out.println("Coordinates should be from 1 to 3!");
                return new int[] {0, 0, 0};
                }
            } else {
                System.out.println("You should enter numbers!");
            return new int[] {0, 0, 0};
            }
        }

    public void printField () {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + field[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }

    public char[][] getBoard() {
        return field;
    }

}
