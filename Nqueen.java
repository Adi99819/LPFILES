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
        System.out.println();
    }

    // Check if it's safe to place a queen at board[row][col]
    static boolean isSafe(int[][] board, int row, int col, int N) {
        int i, j;

        // Check this row on the left side
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on the left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on the left side
        for (i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Recursive backtracking to solve N-Queen
    static void solveNQUtil(int[][] board, int col, int N) {
        // Base case: all queens placed
        if (col >= N) {
            printSolution(board, N);
            return;
        }

        // Try placing queen in all rows of this column
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                board[i][col] = 1;
                solveNQUtil(board, col + 1, N);
                board[i][col] = 0; // backtrack
            }
        }
    }

    // Main solver function
    static void solveNQ(int N, int firstRow, int firstCol) {
        int[][] board = new int[N][N];
        board[firstRow][firstCol] = 1; // place first queen

        System.out.println("\nInitial Board:");
        printSolution(board, N);

        System.out.println("Solutions:\n");
        solveNQUtil(board, 0, N);
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of N: ");
        int N = sc.nextInt();

        System.out.print("Enter position of first queen (row and column): ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        // Adjust for 0-indexing
        solveNQ(N, r - 1, c - 1);

        sc.close();
    }
}
