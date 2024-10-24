package algo;

import java.util.*;

public class Graph {

    private int VERTEX;
    private LinkedList<Integer>[] adjacents;

    // Create a graph
    Graph(int vertex) {
        this.VERTEX = vertex;
        this.adjacents = new LinkedList[vertex];

        for (int i = 0; i < vertex; ++i) {
            adjacents[i] = new LinkedList<>();
        }
    }

    void addEdge(int srcVertex, int destVertex) {
        if (srcVertex >= VERTEX || destVertex >= VERTEX || srcVertex < 0 || destVertex < 0) {
            throw new IllegalArgumentException("Vertex out of bounds");
        }
        adjacents[srcVertex].add(destVertex);
    }

    void bfs(int startingVertex) {
        boolean[] visited = new boolean[VERTEX];
        Queue<Integer> queue = new LinkedList<>();

        // Mark starting vertex as visited and add to the queue
        visited[startingVertex] = true;
        queue.add(startingVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            Iterator<Integer> i = adjacents[currentVertex].listIterator();
            while (i.hasNext()) {
                int element = i.next();
                if (!visited[element]) {
                    visited[element] = true;
                    queue.add(element);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.bfs(2);
    }
}
