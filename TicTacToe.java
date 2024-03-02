import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    private static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    private static char currentPlayer;
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    public static void main(String[] args) {
        char firstPlayer = getPlayerChoice();
        currentPlayer = firstPlayer;

        boolean gameFinished = false;

        while (!gameFinished) {
            printBoard();
            if (currentPlayer == PLAYER_X) {
                playerMove();
            } else {
                computerMove();
            }

            if (checkWinner()) {
                printBoard();
                System.out.println(currentPlayer == PLAYER_X ? "Player X wins!" : "Computer wins!");
                gameFinished = true;
            } else if (isDraw()) {
                printBoard();
                System.out.println("It's a draw!");
                gameFinished = true;
            }

            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
        }
    }

    private static char getPlayerChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose who plays first (X or O): ");
        char choice = scanner.next().toUpperCase().charAt(0);

        while (choice != PLAYER_X && choice != PLAYER_O) {
            System.out.println("Invalid choice. Choose X or O: ");
            choice = scanner.next().toUpperCase().charAt(0);
        }

        return choice;
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        do {
            System.out.println("Player " + currentPlayer + ", enter row (0-2): ");
            row = scanner.nextInt();
            System.out.println("Player " + currentPlayer + ", enter column (0-2): ");
            col = scanner.nextInt();
        } while (!isValidMove(row, col));

        board[row][col] = currentPlayer;
    }

    private static void computerMove() {
        Random random = new Random();
        int row, col;

        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!isValidMove(row, col));

        System.out.println("Computer chooses row: " + row + " column: " + col);
        board[row][col] = currentPlayer;
    }

    private static boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true; // Check rows
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true; // Check columns
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true; // Check diagonal from top-left to bottom-right
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true; // Check diagonal from top-right to bottom-left
        }
        return false;
    }

    private static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // If there's an empty space, the game is not a draw yet
                }
            }
        }
        return true; // All spaces are filled, and no player has won
    }

    private static boolean isValidMove(int row, int col) {
        return 0 <= row && row < 3 && 0 <= col && col < 3 && board[row][col] == ' ';
    }
}
