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
        int[] coordinates;
        do {
            System.out.println("Enter the coordinates: ");
            input = scanner.nextLine().split("\\s+");
            coordinates = board.isInputCorrect(input);
        } while (coordinates[2] == 0);
        return coordinates;
    }
}
