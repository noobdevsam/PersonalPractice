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
        System.out.println("DFS: ");
        if (edges != null) {
            for (Edge<V, E> edge : edges) {
                if (!visited.contains(edge.destination())) {
                    dfsUtil(edge.destination(), visited);
                }
            }
        }
    }

    public void kruskalMST() {
        // collect all edges in a list
        List<Edge<V, E>> edges = new ArrayList<>();
        for (List<Edge<V, E>> edgeList : getAdjacencyList().values()) {
            edges.addAll(edgeList);
        }

        // sort edges by their weights(value)
        edges.sort(Comparator.comparing(Edge::value));

        // initialize the parent map with all the unique vertices
        Map<V, V> parent = new HashMap<>();
        for (V currentVertex : getAdjacencyList().keySet()) {

            // each vertex is its own parent initially
            parent.put(currentVertex, currentVertex);
        }

        // create the MST
        List<Edge<V, E>> mst = new ArrayList<>();
        int totalCost = 0; // initial total cost of MST

        for (Edge<V, E> edge : edges) {
            // find roots of the source and destination
            V root1 = find(parent, edge.source());
            V root2 = find(parent, edge.destination());

            // if they have different roots,
            // include the edge in the MST
            if(!root1.equals(root2)) {
                mst.add(edge);
                parent.put(root1, root2); // union the two sets
                totalCost += (Integer) edge.value(); // accumulate the total cost
            }
        }

        // print the MST
        System.out.println("\nKruskal's MST: ");
        for (Edge<V, E> edge : mst) {
            System.out.println(edge.source() + " - " + edge.destination() + " : " + edge.value());
        }
        System.out.println("Total cost of Kruskal's MST: " + totalCost);

    }

    private V find(Map<V,V> parent, V vertex) {
        if (!parent.get(vertex).equals(vertex)) {
            // path compression
            parent.put(vertex, find(parent, parent.get(vertex)));
        }
        return parent.get(vertex);
    }

    // Prims MST algorithm
    public void primsMST(V startVertex) {
        PriorityQueue<Edge<V, E>> priorityQueue = new PriorityQueue<>(Comparator.comparing(Edge::value));
        Set<V> visited = new HashSet<>();
        List<Edge<V, E>> mst = new ArrayList<>();
        int totalCost = 0; // initial the total cost of the MST

        visited.add(startVertex);
        priorityQueue.addAll(getAdjacencyList().get(startVertex));

        while (!priorityQueue.isEmpty() && mst.size() < (getAdjacencyList().size() - 1) ) {
            Edge<V, E> edge = priorityQueue.poll();

            if (edge != null && !visited.contains(edge.destination())) {
                mst.add(edge);
                visited.add(edge.destination());
                priorityQueue.addAll(getAdjacencyList().get(edge.destination()));
                totalCost += (Integer) edge.value(); // accumulate the total cost
            }
        }

        System.out.println("\nPrims MST: ");
        for (Edge<V,E> edge : mst) {
            System.out.println(edge.source() + " - " + edge.destination() + " : " + edge.value());
        }
        System.out.println("Total cost of Prim's MST: " + totalCost);
        
    }
}












