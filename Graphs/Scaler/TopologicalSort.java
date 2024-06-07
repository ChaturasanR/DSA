import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem Description
 * Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is
 * given which represents the M edges such that there is a edge directed from
 * node B[i][0] to node B[i][1].
 * 
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of
 * vertices such that for every directed edge uv, vertex u comes before v in the
 * ordering. Topological Sorting for a graph is not possible if the graph is not
 * a DAG.
 * 
 * Return the topological ordering of the graph and if it doesn't exist then
 * return an empty array.
 * 
 * If there is a solution return the correct ordering. If there are multiple
 * solutions print the lexographically smallest one.
 * 
 * Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f,
 * g) if a < e or if(a==e) then b < f and so on.
 * 
 * NOTE:
 * 
 * There are no self-loops in the graph.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global
 * variables make sure to clear them.
 * 
 * Solution:
 * To sort the dependency items, we use BFS. For lexicographical order we use
 * PriorityQueue
 * 
 * T.C: O(V + E), S.C: O(V+E)
 * 
 * Topological Sort can be used to find cycle in directed graph
 * if there is a -1 in order that means some node is not visited => there exists
 * a cycle
 */
public class TopologicalSort {
    class Graph {
        private int V;
        private int[] inDegree;
        private List<Integer>[] adjList;

        public Graph(int V, int[][] edges) {
            this.V = V;
            this.inDegree = new int[V];
            this.adjList = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjList[i] = new ArrayList<Integer>();
            }

            // 1. Store edges as adjacency List
            // 2. Calculate In degree for each node
            for (int[] edge : edges) {
                int startVertex = edge[0] - 1;
                int endVertex = edge[1] - 1;
                adjList[startVertex].add(endVertex);
                inDegree[endVertex]++;
            }

        }

        public List<Integer> getAdjListEdges(int u) {
            if (this.adjList == null)
                throw new RuntimeException("No Adjacency List created");

            return this.adjList[u];
        }

        // return the sequence of dependency items in lexographical order
        public int[] lexicographicalTopologicalSort() {
            // store the order
            int[] order = new int[this.V];
            Arrays.fill(order, -1);

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int v = 0; v < this.V; v++) {
                if (this.inDegree[v] == 0)
                    pq.add(v);
            }

            int counter = 0;

            while (!pq.isEmpty()) {
                int u = pq.poll();
                order[counter++] = u + 1;

                for (int v : this.adjList[u]) {
                    inDegree[v]--;
                    if (inDegree[v] == 0)
                        pq.add(v);
                }
            }

            return order[0] == -1 ? new int[] {} : order;
        }
    }

    public int[] sort(int V, int[][] edges) {
        Graph graph = new Graph(V, edges);
        return graph.lexicographicalTopologicalSort();
    }

    public static void main(String[] args) {
        int V = 6;
        int[][] edges = { { 6, 3 }, { 6, 1 }, { 5, 1 }, { 5, 2 }, { 3, 4 }, { 4, 2 } };
        TopologicalSort topologicalSort = new TopologicalSort();
        System.out.println(Arrays.toString(topologicalSort.sort(V, edges)));
    }

}
