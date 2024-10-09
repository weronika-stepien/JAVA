public class Main {

      private  static final int GRID_SIZE = 9;   // CONSTANT VARIABLE -> SIZE OF THE GRID

      public static void main(String[] args)
      {
            int[][]  board = {
                    {7, 0, 2, 0, 5, 0, 6, 0, 0},
                    {0, 0, 0, 0, 0, 3, 0, 0, 0},
                    {1, 0, 0, 0, 0, 9, 5, 0, 0},
                    {8, 0, 0, 0, 0, 0, 0, 9, 0},
                    {0, 4, 3, 0, 0, 0, 7, 5, 0},
                    {0, 9, 0, 0, 0, 0, 0, 0, 8},
                    {0, 0, 9, 7, 0, 0, 0, 0, 5},
                    {0, 0, 0, 2, 0, 0, 0, 0, 0},
                    {0, 0, 7, 0, 4, 0, 2, 0, 3}};

            printBoard(board);

            if (solveBoard(board))
            {
                  System.out.println();
                  System.out.println("Made it: ");
            }
            else
            {
                  System.out.println("Unsolvable");
            }

            printBoard(board);
      }

      private static void printBoard(int[][] board)
      {
            for (int row = 0; row < GRID_SIZE; row++)
            {
                  if (row % 3 == 0 && row != 0)  // for every 3rd row except the first one at the top
                  {
                        System.out.println("--------------------");
                  }

                  for (int column = 0; column < GRID_SIZE; column++)
                  {
                        if (column % 3 == 0 && column != 0) // for every 3rd column except the first one at the top
                        {
                              System.out.print("|");
                        }

                        System.out.print(board[row][column]);
                  }
                  System.out.println();
            }
      }

      // Helper method that lets us know if a number is already present in a ROW

      private static boolean isNumberInRow(int[][] board, int number, int row)
      {
            for (int i = 0; i < GRID_SIZE; i++)
            { // array where we search [row] [in every column] == number we are looking for
                  if(board[row][i] == number)
                  {
                        return true;
                  }
            }
            return false;
      }

      // Helper method that lets us know if a number is already present in a COLUMN

      private static boolean isNumberInColumn(int[][] board, int number, int column)
      {
            for (int i = 0; i < GRID_SIZE; i++)
            { // array where we search [in every row][column] == number we are looking for
                  if(board[i][column] == number)
                  {
                        return true;
                  }
            }
            return false;
      }

      // Helper method that lets us know if a number is already present in a 3x3 BOX

      private static boolean isInBox(int[][] board, int number, int row, int column)
      {
            int localBoxRow = row - row % 3; // 0,3
            int localBoxColumn = column - column % 3; // 0,3

            for (int i = localBoxRow; i < localBoxRow + 3; i++)
            {
                  for (int j = localBoxColumn; j < localBoxColumn + 3;  j++)
                  {
                        if (board[i][j] == number)
                        {
                              return true;
                        }
                  }
            }
            return false;
      }

      // Method that checks if placing a number is valid in row, column, and box

      private static boolean isValidPlacement(int[][] board, int number, int row, int column)
      {
            return  !isNumberInRow(board, number, row) && !isNumberInColumn(board, number, column) && !isInBox(board, number, row, column);
      }

      /*
      Algorithm we'll use:
      The computer will try placing numbers from 1 to 9, checking if they're already present, and place them there.

      Then, the computer will move on until it finds an empty spot.

      If the computer fills an empty spot with a number, but it's a wrong choice or would fit better elsewhere, we go back, erase it, and try another number.

      The program then continues.
       */

      private static boolean solveBoard(int[][] board)
      {
            for (int row = 0; row < GRID_SIZE; row++)
            {
                  for (int column = 0; column < GRID_SIZE; column++)
                  {     // The computer sees an empty spot as 0
                        if(board[row][column] == 0)
                        {
                              for (int numberToTry = 1;  numberToTry <= GRID_SIZE; numberToTry++)
                              {
                                    if (isValidPlacement(board, numberToTry, row, column))
                                    {
                                          board[row][column] = numberToTry;

                                          // Recursion - in case we need to go back
                                          if (solveBoard(board))
                                          {
                                                return true;
                                          }
                                          else
                                          {
                                                // Clear the previous number

                                                board[row][column] = 0;
                                          }
                                    }
                              }
                              return false;
                        }
                  }
            }
            return true;
      }
}
