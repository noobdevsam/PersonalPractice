package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        System.out.print("\n1. 0/1 Knapsack");
        System.out.print("\n2. Fractional Knapsack\n");
        System.out.println();
        choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                ReSult result = knapsack_01(weights, values, capacity);
                System.out.println("Maximum profit (0/1 Knapsack): " + result.profit);
                System.out.println("Item taken (0-indexed)" + result.items);
            }
            case 2 -> {
                ReSult result = knapsack_fractional(weights, values, capacity);
                System.out.println("Maximum profit (Fractional Knapsack): " + result.profit);
                System.out.println("Item taken: " + result.items);
            }
            default -> System.out.println("Invalid choice!");
        }

        scanner.close();
    }

    private static ReSult knapsack_fractional(int[] weights, int[] values, int capacity) {
        var n = weights.length;
        Item[] items = new Item[n];
        double totalValue = 0;
        List<String> takenItems = new ArrayList<>();

        // create an array fo items with value-to-weight ratio
        for (int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], values[i], i);
        }

        // sort items by value-per-weight in descending order
        Arrays.sort(
                items,
                (a, b) -> Double.compare(b.valuePerWeight, a.valuePerWeight)
        );

        // process items
        for (Item item : items) {
            if (capacity >= item.weight) {
                totalValue += item.value;
                takenItems.add("Item " + item.index + " (100%)");
                capacity -= item.weight;
            } else {
                double fraction = (double) capacity / item.weight;
                totalValue += item.value * fraction;
                takenItems.add("Item " + item.index + " (" + (fraction * 100) + " %)");
                break;
            }
        }

        return new ReSult(totalValue, takenItems);
    }

    private static ReSult knapsack_01(int[] weights, int[] values, int capacity) {
        var n = weights.length;
        var dp = new int[n + 1][capacity + 1];

        // fill up the dp table
        for (int i = 1; i <= n; i++) {
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

        // backtrack to find the items taken
        List<Integer> takenItems = new ArrayList<>();
        int w = capacity;
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {

                // add the item index
                takenItems.add(i - 1);
                w -= weights[i - 1];
            }
        }

        return new ReSult(dp[n][capacity], takenItems);
    }

    // Item class for fractional knapsack
    static class Item {

        int weight, value, index;
        double valuePerWeight;

        Item(int weight, int value, int index) {
            this.weight = weight;
            this.index = index;
            this.value = value;
            valuePerWeight = (double) value / weight;
        }
    }

    // ReSult class to hold profit and item list
    static class ReSult {
        double profit;
        List<?> items;

        public ReSult(double profit, List<?> items) {
            this.profit = profit;
            this.items = items;
        }
    }
}


/*
*
* Fractional Knapsack Algorithm Implementation Concept:
 The Fractional Knapsack algorithm solves the problem where items can be divided into smaller parts,
    and you can take fractions of an item. It uses a greedy approach, prioritizing items based on their value-to-weight ratio.

* * Steps in Code:

    Input Handling:
        -Read weights, values, and the capacity of the knapsack.
        -Create an array of Item objects that store weight, value, index, and value-to-weight ratio.

    Sort Items by Value-to-Weight Ratio:
        -Use Arrays.sort() to sort the items in descending order of their value-to-weight ratio.

    Select Items Greedily:
        -Iterate through the sorted items:
            -If the knapsack can fully accommodate the item:
                -Add the item's value to the total profit.
                -Subtract the item's weight from the remaining capacity.
                -Mark the item as fully taken.
            -If the knapsack can only partially accommodate the item:
                -Take as much of the item as possible (fraction).
                -Add the corresponding fraction of the item's value to the total profit.
                -Stop processing further items.

    Output:
        The total profit and the list of items (with fractions if applicable).
*
*
*
*
* 0/1 Knapsack Algorithm Implementation
Concept:

The 0/1 Knapsack algorithm solves the problem where you either take an item entirely or leave it.
    It uses dynamic programming (DP) to compute the maximum value that can fit into the knapsack.
Steps in Code:

    Input Handling:
        Read weights, values, and the capacity of the knapsack.
        Initialize a 2D dp array where dp[i][w] represents the maximum profit for the first i items and capacity w.

    Building the DP Table:
        -Iterate over items (i from 1 to n) and capacities (w from 1 to capacity):
            -If the weight of the current item is less than or equal to the current capacity:
                -Include the item: Add its value to the dp value of the remaining capacity.
                -Exclude the item: Retain the dp value without this item.
                -Store the maximum of these two values in dp[i][w].
            -Otherwise, exclude the item.

    Backtracking to Find Items Taken:
        -Start from the last item and the given capacity.
        -If dp[i][w] is not equal to dp[i-1][w], it means the item was included:
            -Add the item index to the list of taken items.
            -Subtract the item's weight from the remaining capacity.

    Output:
        -The maximum profit is in dp[n][capacity].
        -The list of items taken is constructed during backtracking.
* */