package algo;

import java.util.Arrays;
import java.util.Scanner;

public class KnapsackAlgo {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Enter the number of items: ");
        var n = scanner.nextInt();

        var weights = new int[n];
        var values = new int[n];
        int capacity, choice;

        System.out.println("Enter the weights of items: ");
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        System.out.println("Enter the values of items: ");
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        System.out.println("Enter the capacity of knapsack: ");
        capacity = scanner.nextInt();

        System.out.println("\nChoose the algorithm: ");
        System.out.println("\n1. 0/1 Knapsack");
        System.out.println("\n2. Fractional Knapsack\n");
        System.out.println();
        choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                int maxProfit = knapsack_01(weights, values, capacity);
                System.out.println("Maximum profit (0/1 Knapsack): " + maxProfit);
            }
            case 2 -> {
                double maxProfit = knapsack_fractional(weights, values, capacity);
                System.out.println("Maximum profit (Fractional Knapsack): " + maxProfit);
            }
            default -> System.out.println("Invalid choice!");
        }

        scanner.close();
    }

    private static double knapsack_fractional(int[] weights, int[] values, int capacity) {
        var length = weights.length;
        Item[] items = new Item[length];
        double totalValue = 0;

        for (int i = 0; i < length; i++) {
            items[i] = new Item(weights[i], values[i]);
        }

        Arrays.sort(
                items,
                (a, b) -> Double.compare(b.valuePerWeight, a.valuePerWeight)
        );

        for (Item item : items) {
            if (capacity >= item.weight) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue += item.valuePerWeight * capacity;
                break;
            }
        }

        return totalValue;
    }

    private static int knapsack_01(int[] weights, int[] values, int capacity) {
        var length = weights.length;
        var dp = new int[length + 1][capacity + 1];

        for (int i = 1; i <= length; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            dp[i - 1][w],
                            values[i - 1] + dp[i - 1][w - weights[i - 1]]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[length][capacity];
    }

    static class Item {

        int weight, value;
        double valuePerWeight;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            valuePerWeight = (double) value / weight;
        }
    }
}
