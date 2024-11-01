package algo;

import java.util.*;

public class Graph<V, E> {

    protected final Map<V, List<Edge<V, E>>> adjacencyList = new HashMap<>();
    protected final boolean isDirected;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public Map<V, List<Edge<V, E>>> getAdjacencyList() {
        return adjacencyList;
    }

    public void addEdge(V source, V destination, E value) {

        adjacencyList.putIfAbsent(source, new ArrayList<>());

        adjacencyList.get(source).add(
                new Edge<>(source,destination, value)
        ); // for directed graph

        if (!isDirected) {
            adjacencyList.putIfAbsent(destination, new ArrayList<>());
            adjacencyList.get(destination).add(
                    new Edge<>(destination, source, value)
            ); // setting bi-direction for undirected graph
        }

    }

    public void displayGraph() {

        for(var entry : adjacencyList.entrySet()) {
            var vertex = entry.getKey();
            var edges = entry.getValue();
            System.out.print(vertex + " -> ");
            for (var edge : edges) {
                System.out.print(edge.destination() + "(" + edge.value() + ")");
            }
            System.out.println();
        }

    }

}
