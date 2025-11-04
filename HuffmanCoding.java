import java.util.*;

// Node class for Huffman tree
class Node implements Comparable<Node> {
    int freq;              // Frequency of symbol
    String symbol;         // Symbol (character)
    Node left, right;      // Left and right child
    String huff = "";      // Huffman code (0/1 direction)

    Node(int freq, String symbol, Node left, Node right) {
        this.freq = freq;
        this.symbol = symbol;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node other) {
        return this.freq - other.freq;
    }
}

public class HuffmanCoding {

    // Recursive function to print Huffman codes
    static void printNodes(Node node, String val) {
        String newVal = val + node.huff;
        if (node.left != null)
            printNodes(node.left, newVal);
        if (node.right != null)
            printNodes(node.right, newVal);
        // If it's a leaf node
        if (node.left == null && node.right == null)
            System.out.println(node.symbol + " -> " + newVal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Huffman Coding -----");

        // Input number of characters
        System.out.print("Enter the number of characters: ");
        int n = sc.nextInt();

        List<String> chars = new ArrayList<>();
        List<Integer> freq = new ArrayList<>();

        // Taking input from user
        for (int i = 0; i < n; i++) {
            System.out.print("Enter character " + (i + 1) + ": ");
            String ch = sc.next();
            System.out.print("Enter frequency of '" + ch + "': ");
            int f = sc.nextInt();
            chars.add(ch);
            freq.add(f);
        }

        // Priority queue (min-heap)
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // Create leaf nodes
        for (int i = 0; i < chars.size(); i++) {
            pq.add(new Node(freq.get(i), chars.get(i), null, null));
        }

        // Combine nodes until one remains
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            left.huff = "0";
            right.huff = "1";

            Node newNode = new Node(left.freq + right.freq, left.symbol + right.symbol, left, right);
            pq.add(newNode);
        }

        System.out.println("\nHuffman Codes for each character:");
        System.out.println("--------------------------------");
        printNodes(pq.peek(), "");
        sc.close();
    }
}
