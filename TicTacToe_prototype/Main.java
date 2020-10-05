package tictactoe;

public class Main {
    public static void main(String[] args) {
        TicTacToe match = new TicTacToe();
        match.play();
    }
}
//    public static void printField (char[][] board) {
//        System.out.println("---------");
//        for (int i = 0; i < 3; i++) {
//            System.out.print("|");
//            for (int j = 0; j < 3; j++) {
//                System.out.print(" " + board[i][j]);
//            }
//            System.out.println(" |");
//        }
//        System.out.println("---------");
//    }

//    private static boolean isInputCorrect (String input) {
//        if (input.matches("[0-9]")) {
//            if (input.matches("[1-3]")) {
//                return true;
//            }
//            else {
//                System.out.println("Coordinates should be from 1 to 3!");
//                return false;
//            }
//        }
//        else {
//            System.out.println("You should enter numbers!");
//            return false;
//        }
//    }

//    public static String getResults (char[][] board) {
//        int j = 0;
//        for (int i = 0; i < 3; i++) {
//            // horizontally
//            if (board[i][j] != ' ' && board[i][j] == board[i][j+1] && board[i][j+1] == board[i][j+2])
//                return board[i][j] + " wins";
//            // vertically
//            if (board[j][i] != ' ' && board[j][i] == board[j+1][i] && board[j][i] == board[j+2][i])
//                return board[j][i] + " wins";
//        }
//        // diagonally
//        if (board[1][1] != ' ' && board[0][0] == board[1][1] && board [1][1] == board[2][2] || board[1][1] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
//            return board[1][1] + " wins";
//
//        for (int i = 0; i < 3; i++) {
//            for (j = 0; j < 3; j++) {
//                if (board[i][j] == ' ') return "Game not finished";
//            }
//        }
//        return "Draw";
//    }


//    public boolean isFinalized() {
//        return getResults();
//    }

//    private static void makeMoveEasy(char[][] board) {
//        Random random = new Random();
//        int randomRow, randomColumn;
//        randomRow = random.nextInt(3);
//        randomColumn = random.nextInt(3);
//        System.out.println("Making move level \"easy\"");
//        while (board[randomRow][randomColumn] != ' ') {
//            randomRow = random.nextInt(3);
//            randomColumn = random.nextInt(3);
//            if (board[randomRow][randomColumn] == ' ') {
//                break;
//            }
//        }
//        board[randomRow][randomColumn] = 'O';
//    }


//        char[][] field = new char[3][3];
//        Scanner scanner = new Scanner(System.in);
//        int xInt, yInt, counter = 0;
//        String x, y;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                field[i][j] = ' ';
//            }
//        }
//        System.out.println("Input command: ");
//
//        while (true) {
//
//        }



//        printField(field);
//        while (true) {
//            scanner.nextLine(); // taking scanner stream to the next line in order to omit last user's input in case of an incorrect input
//            System.out.print("Enter the coordinates: ");
//            x = scanner.next();
//            if (isInputCorrect(x)) {
//                y = scanner.next();
//            }
//            else continue; // skipping current iteration so isInputCorrect won't throw NullPointerException
//            if (isInputCorrect(y)) {
//                xInt = Integer.parseInt(x) - 1;
//                yInt = Integer.parseInt(y);
//                yInt = yInt == 1 ? 2 : yInt == 3 ? 0 : 1;
//                if (field[yInt][xInt] == ' ') {
//                    field[yInt][xInt] = 'X';
//                    printField(field);
//                    if (getResults(field) != "Game not finished") {
//                        System.out.println(getResults(field));
//                        break;
//                    }
//                    makeMoveEasy(field);
//                    printField(field);
//                }
//                else { System.out.println("This cell is occupied! Choose another one!"); }
//
//            }
//        }