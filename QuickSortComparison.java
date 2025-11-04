import java.util.*;

public class QuickSortComparison {

    // Partition function for deterministic QuickSort
    static int partition(int[] arr, int low, int high, int[] stepsCounter) {
        int steps = 0;
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            steps++; // comparison
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        stepsCounter[0] += steps;
        return i + 1;
    }

    // Random partition for randomized QuickSort
    static int randomPartition(int[] arr, int low, int high, int[] stepsCounter) {
        Random rand = new Random();
        int randIndex = rand.nextInt(high - low + 1) + low;

        // Swap random pivot with last element
        int temp = arr[randIndex];
        arr[randIndex] = arr[high];
        arr[high] = temp;

        return partition(arr, low, high, stepsCounter);
    }

    // Deterministic QuickSort
    static void quickSortDet(int[] arr, int low, int high, int[] stepsCounter) {
        if (low < high) {
            int pi = partition(arr, low, high, stepsCounter);
            quickSortDet(arr, low, pi - 1, stepsCounter);
            quickSortDet(arr, pi + 1, high, stepsCounter);
        }
    }

    // Randomized QuickSort
    static void quickSortRand(int[] arr, int low, int high, int[] stepsCounter) {
        if (low < high) {
            int pi = randomPartition(arr, low, high, stepsCounter);
            quickSortRand(arr, low, pi - 1, stepsCounter);
            quickSortRand(arr, pi + 1, high, stepsCounter);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Main Program ---
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr1 = new int[n];
        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int[] arr2 = arr1.clone();

        int[] detCounter = new int[1];  // for counting comparisons
        int[] randCounter = new int[1];

        quickSortDet(arr1, 0, n - 1, detCounter);
        quickSortRand(arr2, 0, n - 1, randCounter);

        // --- Output ---
        System.out.println("\nDeterministic QuickSort:");
        for (int x : arr1) System.out.print(x + " ");
        System.out.println("\nSteps (approx comparisons): " + detCounter[0]);

        System.out.println("\nRandomized QuickSort:");
        for (int x : arr2) System.out.print(x + " ");
        System.out.println("\nSteps (approx comparisons): " + randCounter[0]);

        sc.close();
    }
}
