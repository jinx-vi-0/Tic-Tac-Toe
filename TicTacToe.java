import java.util.Scanner;

class TicTacToe {
  public static boolean haveWon(char[][] board, char player) {
    for (int row = 0; row < board.length; row++) {
      if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
        return true;
      }
    }

    for (int col = 0; col < board[0].length; col++) {
      if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
        return true;
      }
    }

    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
      return true;
    }

    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
      return true;
    }
    return false;
  }

  public static void printBoard(char[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        System.out.print(board[row][col] + " | ");
      }
      System.out.println();
    }
  }

  public static boolean check(char[][] board) {
    for (int row = 0; row < board.length; row++) {
      if (board[row][0] == ' ' || board[row][1] == ' ' || board[row][2] == ' ') {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    char[][] board = new char[3][3];
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        board[row][col] = ' ';
      }
    }

    char player = 'X';
    boolean gameOver = false;
    Scanner scanner = new Scanner(System.in);

    while (!gameOver) {
      if (check(board)) {
        System.out.println("Draw!");
        break;
      }
      printBoard(board);
      System.out.print("Player " + player + " enter: ");
      int row = scanner.nextInt();
      int col = scanner.nextInt();
      System.out.println();

      if (board[row][col] == ' ') {
        board[row][col] = player;
        gameOver = haveWon(board, player);
        if (gameOver) {
          System.out.println("Player " + player + " has won.");
        } else
          player = (player == 'X') ? 'O' : 'X';
      } else
        System.out.println("Invalid move. Try again!");
    }
    printBoard(board);
  }
}