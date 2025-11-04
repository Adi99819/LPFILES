import java.util.*;

class Item {
    double weight, value;

    Item(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take number of items
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        double[] weights = new double[n];
        double[] values = new double[n];

        // Step 2: Take weight and value together on same line
        System.out.println("\nEnter weight and value for each item (separated by space):");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            weights[i] = sc.nextDouble();
            values[i] = sc.nextDouble();
        }

        // Step 3: Take knapsack capacity
        System.out.print("\nEnter knapsack capacity: ");
        double capacity = sc.nextDouble();

        // Step 4: Fractional knapsack logic
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new Item(weights[i], values[i]));
        }

        // Sort by value/weight ratio (descending)
        items.sort((a, b) -> Double.compare(b.value / b.weight, a.value / a.weight));

        double res = 0.0;

        System.out.println("\nItem selection process:");
        for (Item item : items) {
            if (capacity <= 0) break;

            if (item.weight <= capacity) {
                res += item.value;
                capacity -= item.weight;
                System.out.println("  Took full item (weight=" + item.weight + ", value=" + item.value + ")");
            } else {
                res += capacity * (item.value / item.weight);
                System.out.println("  Took " + capacity + " weight fraction of item (weight=" + item.weight + ", value=" + item.value + ")");
                capacity = 0;
            }
        }

        System.out.printf("\n Maximum value in knapsack = %.2f\n", res);

        sc.close();
    }
}
