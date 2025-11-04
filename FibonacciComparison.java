import java.util.*;

public class FibonacciComparison {

    // ---------- Recursive Fibonacci ----------
    static int fibRecursive(int n) {
        if (n <= 1)
            return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // ---------- Non-Recursive Fibonacci ----------
    static void fibNonRecursive(int n) {
        if (n <= 0) return;
        if (n == 1) {
            System.out.print("0 ");
            return;
        }

        int n1 = 0, n2 = 1;
        System.out.print(n1 + " " + n2 + " ");
        for (int i = 2; i < n; i++) {
            int n3 = n1 + n2;
            System.out.print(n3 + " ");
            n1 = n2;
            n2 = n3;
        }
        System.out.println();
    }

    // ---------- Main Function ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        // Recursive Fibonacci
        System.out.print("\nFibonacci Sequence (Recursive): ");
        long start1 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            System.out.print(fibRecursive(i) + " ");
        }
        long end1 = System.nanoTime();
        double timeRecursive = (end1 - start1) / 1000.0; // microseconds

        // Non-Recursive Fibonacci
        System.out.print("\n\nFibonacci Sequence (Non-Recursive): ");
        long start2 = System.nanoTime();
        fibNonRecursive(n);
        long end2 = System.nanoTime();
        double timeNonRecursive = (end2 - start2) / 1000.0; // microseconds

        // ---------- Time & Space Complexity ----------
        System.out.println("\n=== Time and Space Complexity Analysis ===");
        System.out.printf("Recursive Time Taken: %.2f microseconds%n", timeRecursive);
        System.out.println("Recursive Time Complexity: O(2^n)");
        System.out.println("Recursive Space Complexity: O(n)\n");

        System.out.printf("Non-Recursive Time Taken: %.2f microseconds%n", timeNonRecursive);
        System.out.println("Non-Recursive Time Complexity: O(n)");
        System.out.println("Non-Recursive Space Complexity: O(1)");

        sc.close();
    }
}
