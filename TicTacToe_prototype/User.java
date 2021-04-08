package tictactoe;
import java.util.Scanner;

public class User extends Player {
    private static final Scanner scanner = new Scanner(System.in);
    public User(char symbol) {
        super(symbol);
        setIsUser(true);
    }

    @Override
    public int[] getMove(TicTacToe board) {
        String[] input;
        int[] coordinates = {0,0,0};
        do {
            System.out.print("Enter the coordinates: > ");
            input = scanner.nextLine().split("\\s+");
            if (input.length != 2) {
                System.out.println("You need to enter 2 coordinates!");
                continue;
            }
            coordinates = board.checkEnteredCoordinatesValidity(input);
        } while (coordinates[2] == 0);
        return coordinates;
    }
}