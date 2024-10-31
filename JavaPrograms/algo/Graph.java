package algo;

import java.util.*;

public class Graph<V, E> {

    private final Map<V, List<Edge<V, E>>> adjacencyList = new HashMap<>();
    private final boolean isDirected;

    private static class Edge<V, E> {
        V destination;
        E value;

        public Edge(V destination, E value) {
            this.destination = destination;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + destination + ", " + value + ")";
        }
    }

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public void addVertex(V vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(V source, V destination, E value) {

        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        adjacencyList.get(source).add(
                new Edge<>(destination, value)
        ); // for directed graph

        if (!isDirected) {
            adjacencyList.get(destination).add(
                    new Edge<>(source, value)
            ); // setting bi-direction for undirected graph
        }
    }

    public void displayGraph() {
        for(var entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");

            List<Edge<V, E>> edges = entry.getValue();
            for (Edge<V, E> edge : edges) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        var directedGraph = new Graph<String, Integer>(true);
        directedGraph.addVertex("A");
        directedGraph.addVertex("B");
        directedGraph.addVertex("C");
        directedGraph.addVertex("D");

        directedGraph.addEdge("A", "B", 5);
        directedGraph.addEdge("A", "C", 10);
        directedGraph.addEdge("B", "D", 2);
        directedGraph.addEdge("C", "D", 3);

        System.out.println("Directed graph: ");
        directedGraph.displayGraph();

    }
}
