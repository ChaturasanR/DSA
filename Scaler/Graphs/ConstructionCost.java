import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem Description
 * Given a graph with A nodes and C weighted edges. Cost of constructing the
 * graph is the sum of weights of all the edges in the graph.
 * 
 * Find the minimum cost of constructing the graph by selecting some given edges
 * such that we can reach every other node from the 1st node.
 * 
 * NOTE: Return the answer modulo 109+7 as the answer can be large.
 * 
 * Sol:
 * We need to built the connected graph with minimum total weights. So we use
 * MST
 * 
 * We use both the approachs
 * 1. Kraushal
 * a. Sort the edges based on their weights from lowest to highest
 * b. Pick edge by edge until the graph is connected (Use union-find approach)
 * 
 * 2. Prism
 * a. Pick any vertex and add its edges to min heap
 * b. From min heap pick the next vertex and add its edges to the min heap and
 * repeat until the graph is connected
 * 
 */
public class ConstructionCost {
    class Edge implements Comparable<Edge> {
        private int source;
        private int dest;
        private int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }

        public int getSource() {
            return this.source;
        }

        public int getDest() {
            return this.dest;
        }

        public int getWeight() {
            return this.weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.getWeight();
        }

    }

    class Graph {
        private int V;
        private List<Edge>[] adjList;
        private Edge[] edges;
        private int[] parents;

        public Graph(int V, int[][] edges) {
            this.V = V;
            this.adjList = new ArrayList[V];
            this.parents = new int[this.V];
            this.edges = new Edge[edges.length];

            for (int u = 0; u < V; u++) {
                this.adjList[u] = new ArrayList<>();
                this.parents[u] = u;
            }

            for (int i = 0; i < edges.length; i++) {
                int src = edges[i][0] - 1;
                int dest = edges[i][1] - 1;
                int weight = edges[i][2];

                this.edges[i] = new Edge(src, dest, weight);
                this.adjList[src].add(new Edge(src, dest, weight));
                this.adjList[dest].add(new Edge(dest, src, weight));
            }

        }

        /**
         * 1. Sorts the array based on minimum weight
         * 2. Iterate over each edge and create the connected graph (union & find
         * approach)
         * T.C: O(ElogE + E) S.C: O(E + V)
         */
        public int getMinWeightUsingKrushal() {
            Arrays.sort(this.edges);
            int edgesCount = 0;
            long minWeight = 0;

            if (this.edges.length == 0)
                return 0;

            for (Edge edge : this.edges) {
                int src = edge.getSource();
                int dest = edge.getDest();
                int weight = edge.getWeight();

                if (union(src, dest)) {
                    edgesCount++;
                    minWeight += weight;
                }
                if (edgesCount == this.V - 1)
                    return (int) (minWeight % 1_000_000_007l);
                ;

            }
            return Integer.MAX_VALUE;
        }

        private boolean union(int src, int dest) {
            int rootSrc = find(src);
            int rootDest = find(dest);

            if (rootSrc == rootDest)
                return false;

            this.parents[rootSrc] = rootDest;
            return true;
        }

        private int find(int u) {
            if (parents[u] == u)
                return u;

            // path compression
            parents[u] = find(parents[u]);
            return parents[u];
        }

        /**
         * 1. Pick any vertex and add its edges to min heap
         * 2. From min heap pick the next vertex and add its edges to the min heap and
         * repeat until the graph is connected
         * 
         * T.C: O(ElogE), S.C: O(V + E)
         */
        public int getMinWeightUsingPrism() {
            boolean[] visited = new boolean[this.V];

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            int src = 0;
            visited[src] = true;
            for (Edge edge : this.adjList[src]) {
                pq.add(edge);
            }

            long minWeight = 0;
            int visitedVerticesCount = 1;
            while (!pq.isEmpty()) {
                if (visitedVerticesCount == this.V)
                    break;

                Edge currEdge = pq.poll();
                src = currEdge.getDest();
                if (visited[src])
                    continue;

                minWeight += currEdge.getWeight();
                visited[src] = true;
                visitedVerticesCount++;
                for (Edge edge : this.adjList[src]) {
                    pq.add(edge);
                }
            }
            return (int) (minWeight % 1_000_000_007l);
        }
    }

    public int getMinConstructionCost(int V, int[][] edges) {
        Graph gf = new Graph(V, edges);
        // return gf.getMinWeightUsingKrushal();
        return gf.getMinWeightUsingPrism();
    }
}
