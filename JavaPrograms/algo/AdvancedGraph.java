package algo;

import java.util.*;

class AdvancedGraph<V, E extends Comparable<E>> extends Graph<V, E> {

    public AdvancedGraph(boolean isDirected) {
        super(isDirected);
    }

    //BFS algorithm
    public void bfs(V startVertex) {
        if(!getAdjacencyList().containsKey(startVertex)) {
            System.out.println("Start vertex not found in the graph.");
            return;
        }

        Set<V> visited = new HashSet<>();
        Queue<V> queue = new LinkedList<>();

        queue.add(startVertex);
        visited.add(startVertex);

        System.out.println("BFS: ");
        while (!queue.isEmpty()) {
            V currentVertex = queue.poll(); // get the next vertex to process
            System.out.print(currentVertex + " "); // process the vertex

            // getting edges of current vertex
            List<Edge<V, E>> edges = getAdjacencyList().get(currentVertex);
            if (edges != null) {
                for (var edge : edges) {
                    if (!visited.contains(edge.destination())) {
                        queue.add(edge.destination());
                        visited.add(edge.destination());
                    }
                }
            }
        }
    }


    //DFS algorithm
    public void dfs(V startVertex) {
        Set<V> visited = new HashSet<>();
        dfsUtil(startVertex, visited); // call the recursive dfs helper method
    }

    private void dfsUtil(V startVertex, Set<V> visited) {
        visited.add(startVertex);
        System.out.print(startVertex + " "); // process the vertex

        List<Edge<V, E>> edges = getAdjacencyList().get(startVertex);
        if (edges != null) {
            for (Edge<V, E> edge : edges) {
                if (!visited.contains(edge.destination())) {
                    dfsUtil(edge.destination(), visited);
                }
            }
        }
    }

    public void kruskalMST() {
        List<Edge<V, E>> edges = new ArrayList<>();
        for (List<Edge<V, E>> edgeList : getAdjacencyList().values()) {
            edges.addAll(edgeList);
        }

        edges.sort(Comparator.comparing(Edge::value));
        Map<V, V> parent = new HashMap<>();

        for (V currentVertex : getAdjacencyList().keySet()) {
            parent.put(currentVertex, currentVertex);
        }

        List<Edge<V, E>> mst = new ArrayList<>();
        for (Edge<V, E> edge : edges) {
            V root1 = find(parent, edge.source());
            V root2 = find(parent, edge.destination());

            if(!root1.equals(root2)) {
                mst.add(edge);
                parent.put(root1, root2);
            }
        }

        System.out.println("Kruskal's MST: ");
        for (Edge<V, E> edge : mst) {
            System.out.println(edge.source() + " -> " + edge.destination() + " : " + edge.value());
        }

    }

    private V find(Map<V,V> parent, V vertex) {
        if (parent.get(vertex).equals(vertex)) {
            return vertex;
        }
        return find(parent, parent.get(vertex));
    }
}












