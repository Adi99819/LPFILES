import java.util.Scanner;

public class NQueen {

    // Function to print the solution board
    static void printSolution(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check if it's safe to place a queen at board[row][col]
    static boolean isSafe(int[][] board, int row, int col, int N) {
        int i, j;

        // Check this row on the left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        // Check upper diagonal on the left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check lower diagonal on the left side
        for (i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Solve N Queen using backtracking
    static boolean solveNQUtil(int[][] board, int col, int N) {
        // Base case: If all queens are placed
        if (col >= N)
            return true;

        // Try placing queen in all rows of current column
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                // Place queen
                board[i][col] = 1;

                // Recur to place the rest
                if (solveNQUtil(board, col + 1, N))
                    return true;

                // Backtrack
                board[i][col] = 0;
            }
        }

        // If queen can't be placed in any row of this column
        return false;
    }

    // Main solver
    static boolean solveNQ(int N) {
        int[][] board = new int[N][N];

        if (!solveNQUtil(board, 0, N)) {
            System.out.println("Solution does not exist for N = " + N);
            return false;
        }

        printSolution(board, N);
        return true;
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of N: ");
        int N = sc.nextInt();
        solveNQ(N);
        sc.close();
    }
}
