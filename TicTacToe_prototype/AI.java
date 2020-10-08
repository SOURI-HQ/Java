package tictactoe;
import java.util.Random;

public class AI extends Player {
    private static final Random random = new Random();
    private Difficulty difficulty;

    public AI(char symbol) {
        this(symbol, Difficulty.EASY);
    }

    public AI(char symbol, Difficulty difficulty) {
        super(symbol);
        setDifficulty(difficulty);
        setIsUser(false);
    }

    @Override
    public int[] getMove(TicTacToe board) {
        switch (difficulty) {
//            case MEDIUM:
//                return getMoveMedium(board);
//            case HARD:
//                return getMoveHard(board);
            default:
                return getMoveEasy(board);
        }
    }

    public int[] getMoveEasy(TicTacToe board) {
        int randomRow, randomColumn;
        randomRow = random.nextInt(3);
        randomColumn = random.nextInt(3);
        System.out.println("Making move level \"easy\"");
        while (board.getField()[randomRow][randomColumn] != ' ') {
            randomRow = random.nextInt(3);
            randomColumn = random.nextInt(3);
            if (board.getField()[randomRow][randomColumn] == ' ') {
                break;
            }
        }
        return new int[] {randomRow, randomColumn};
    }

//    public int[] getMoveMedium(TicTacToe board) {
//        return 0;
//    }
//
//    public int[] getMoveHard(TicTacToe board) {
//        return 0;
//    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public enum Difficulty {
        EASY(1),
        MEDIUM(2),
        HARD(3);

        int difficulty;

        Difficulty(int difficulty) {
            this.difficulty = difficulty;
        }
    }
}