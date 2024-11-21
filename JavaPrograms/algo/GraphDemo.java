package algo;

public class GraphDemo {
    public static void main(String[] args) {
        // Create an undirected graph
        AdvancedGraph<String, Integer> undirectedGraph = new AdvancedGraph<>(false);
        undirectedGraph.addEdge("A", "B", 1);
        undirectedGraph.addEdge("A", "C", 3);
        undirectedGraph.addEdge("B", "C", 1);
        undirectedGraph.addEdge("B", "D", 2);
        undirectedGraph.addEdge("C", "D", 1);
        undirectedGraph.addEdge("C", "E", 5);
        undirectedGraph.addEdge("D", "E", 2);

        System.out.println("Undirected Graph:");
        undirectedGraph.displayGraph();

        System.out.println("\nBFS (Undirected) starting from A:");
        undirectedGraph.bfs("A");

        System.out.println("\nDFS (Undirected) starting from A:");
        undirectedGraph.dfs("A");

        System.out.println();
        undirectedGraph.kruskalMST();
        undirectedGraph.primsMST("A");

        System.out.println("------------------------------");
        AdvancedGraph<Integer, Integer> secondUG = new AdvancedGraph<>(false);
        secondUG.addEdge(1, 2, 28);
        secondUG.addEdge(2, 3, 16);
        secondUG.addEdge(3, 4, 12);
        secondUG.addEdge(4, 5, 22);
        secondUG.addEdge(5, 6, 25);
        secondUG.addEdge(6, 1, 10);
        secondUG.addEdge(2, 7, 14);
        secondUG.addEdge(4, 7, 18);
        secondUG.addEdge(5, 7, 24);

        System.out.println("Second Undirected Graph");
        secondUG.displayGraph();
        secondUG.kruskalMST();
        secondUG.primsMST(1);

        System.out.println("------------------------------");
        // Create a directed graph
        AdvancedGraph<String, Integer> directedGraph = new AdvancedGraph<>(true);
        directedGraph.addEdge("A", "B", 1);
        directedGraph.addEdge("A", "C", 3);
        directedGraph.addEdge("B", "C", 1);
        directedGraph.addEdge("B", "D", 2);
        directedGraph.addEdge("C", "D", 1);
        directedGraph.addEdge("C", "E", 5);
        directedGraph.addEdge("D", "E", 2);

        System.out.println("\nDirected Graph:");
        directedGraph.displayGraph();

        System.out.println("\nBFS (Directed) starting from A:");
        directedGraph.bfs("A");

        System.out.println("\nDFS (Directed) starting from A:");
        directedGraph.dfs("A");
    }
}
