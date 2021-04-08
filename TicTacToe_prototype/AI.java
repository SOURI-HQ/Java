package tictactoe;
import java.util.ArrayList;
import java.util.List;
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
            case MEDIUM:
                return getMoveMedium(board);
            case HARD:
                return getMoveHard(board);
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

    public int[] getMoveMedium(TicTacToe board) {
        int numberX = 0;
        int numberO = 0;
        int emptyCells = 0;
        int[] cords = new int[2];
        //vertical check
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getField()[i][j] == 'X') numberX++;
                else if (board.getField()[i][j] == 'O') numberO++;
                else if (emptyCells == 0){
                    emptyCells++;
                    cords[0] = i;
                    cords[1] = j;
                }
            }
            if (emptyCells == 1 && (numberO == 2 || numberX== 2)) return new int[] {cords[0], cords[1]};
            numberO = numberX = emptyCells = 0;
            }
        //horizontal check
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getField()[j][i] == 'X') numberX++;
                else if (board.getField()[j][i] == 'O') numberO++;
                else if (emptyCells == 0){
                    emptyCells++;
                    cords[0] = j;
                    cords[1] = i;
                }
            }
            if (emptyCells == 1 && (numberO == 2 || numberX== 2)) return new int[] {cords[0], cords[1]};
            numberO = numberX = emptyCells = 0;
        }
        //diagonal check
        if (board.getField()[0][0] == ' ' && board.getField()[1][1] == board.getField()[2][2]) return new int[] {0, 0};
        else if (board.getField()[1][1] == ' ' && board.getField()[0][0] == board.getField()[2][2]) return new int[] {1, 1};
        else if (board.getField()[2][2] == ' ' && board.getField()[0][0] == board.getField()[1][1]) return new int[] {2, 2};

        else if (board.getField()[0][2] == ' ' && board.getField()[1][1] == board.getField()[2][0]) return new int[] {0, 2};
        else if (board.getField()[1][1] == ' ' && board.getField()[0][2] == board.getField()[2][0]) return new int[] {1, 1};
        else if (board.getField()[2][0] == ' ' && board.getField()[1][1] == board.getField()[0][2]) return new int[] {2, 0};
        else return getMoveEasy(board);
    }
    public int[] getMoveHard(TicTacToe board) {
        int[] hardMove = minimax(board, getSymbol(), getSymbol() == 'X' ? 'O' : 'X', getSymbol(), 0);
        System.out.println("Making move level \"hard\"");
        return new int[] {hardMove[1], hardMove[2]};
    }

    public List<int[]> getEmptySpots(TicTacToe board) {
        List<int[]> nextMoves = new ArrayList<int[]>();

        if (board.getResults().equals("Draw")) {
            return nextMoves;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getField()[i][j] == ' ') {
                    nextMoves.add(new int[] {i, j});
                }
            }
        }
        return nextMoves;
    }

    public int[] minimax(TicTacToe virtualBoard, char aiPlayer, char huPlayer, char currentPlayer, int depth) {
        List<int[]> nextMoves = getEmptySpots(virtualBoard);

        if (virtualBoard.getResults(huPlayer).equals("true")) {
            return new int[] {-10};
        }
        else if (virtualBoard.getResults(aiPlayer).equals("true")) {
            return new int[] {10};
        }
        else if (nextMoves.size() == 0) {
            return new int[] {0};
        }

        List<int[]> finalMoves = new ArrayList<int[]>();

        for (int i = 0; i < nextMoves.size(); i++) {
            int[] move = new int[3];
            move[1] = nextMoves.get(i)[0];
            move[2] = nextMoves.get(i)[1];
            virtualBoard.getField()[move[1]][move[2]] = currentPlayer;

            if (currentPlayer == aiPlayer) {
                move[0] = minimax(virtualBoard, aiPlayer, huPlayer, huPlayer, depth + 1)[0] - depth;
            }
            else {
                move[0] = minimax(virtualBoard, aiPlayer, huPlayer, aiPlayer, depth + 1)[0] + depth;
            }
            virtualBoard.getField()[move[1]][move[2]] = ' ';
            finalMoves.add(move);
        }
        int bestScore;
        int bestMove = 0;
        if (currentPlayer == aiPlayer) {
            bestScore = -10000;
            for (int i = 0; i < finalMoves.size(); i++) {
                if (finalMoves.get(i)[0] > bestScore) {
                    bestScore = finalMoves.get(i)[0];
                    bestMove = i;
                }
            }
        }
        else {
            bestScore = 10000;
            for (int i = 0; i < finalMoves.size(); i++) {
                if (finalMoves.get(i)[0] < bestScore) {
                    bestScore = finalMoves.get(i)[0];
                    bestMove = i;
                }
            }
        }
        return finalMoves.get(bestMove);
    }

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