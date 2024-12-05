import java.util.Scanner;

public class TicTacToeJAVA {
    public static void main(String[] args) {
        //initialise board
        char[][] board = new char[3][3];

        //initially the board will be empty
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        //in start of game
        char player = 'X';
        boolean gameOver = false;

        Scanner in = new Scanner(System.in);

        //run loop until we don't have winner
        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + " enters : ");

            //taking input of moves
            int row = in.nextInt();
            int col = in.nextInt();

            //only add move if place is empty
            if (board[row][col] == ' ') {
                board[row][col] = player; //place the move
                gameOver = haveWon(board, player);

                if (gameOver) {
                    System.out.println(player + " has won!!");
                } else {
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                }
            } else {
                System.out.println("Invalid move! Try again");
            }
        }
        printBoard(board);
    }

    public static boolean haveWon(char[][] board, char player) {

        //check row combination
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        //check column combination
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        //check diagonal combination (2 diagonals)
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}