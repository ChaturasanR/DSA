import java.util.ArrayList;
import java.util.List;

/**
 * PS Given an directed graph having A nodes. A matrix B of size M x 2 is given
 * which represents the M edges such that there is a edge directed from node
 * B[i][0] to node B[i][1].
 * 
 * Find whether the graph contains a cycle or not, return 1 if cycle is present
 * else return 0.
 * 
 * NOTE:
 * 
 * The cycle must contain atleast two nodes.
 * There are no self-loops in the graph.
 * There are no multiple edges between two nodes.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global
 * variables make sure to clear them.
 * 
 * Sol:
 * Apply DFS to check if on a path same node is visited again
 * 1. Maintain two visited status
 * a. Global for general DFS
 * b. For tracking visited nodes in a path
 * 
 * T.C: O(V + E), S.C: O(V + E)
 * worst T.C: O(V^2), S.C: O(V^2)
 * 
 * Other approach can be to use topological sort to detect the cycle
 */
public class DirectedGraphCycleDetector {

    public class Graph {
        private int V;
        private List<Integer>[] adjList;

        public Graph(int V, int[][] edges) {
            this.V = V;

            this.adjList = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjList[i] = new ArrayList<Integer>();
            }

            for (int[] edge : edges) {
                int startVertex = edge[0] - 1;
                int endVertex = edge[1] - 1;
                adjList[startVertex].add(endVertex);
            }

        }

        public List<Integer> getAdjListEdges(int u) {
            if (this.adjList == null)
                throw new RuntimeException("No Adjacency List created");

            return this.adjList[u];
        }

        public boolean isCycleDetected() {
            boolean[] globalVisitedStatus = new boolean[this.V];
            boolean[] pathVisitedStatus = new boolean[this.V];

            for (int u = 0; u < this.V; u++) {
                // Apply DFS from the node which is not visited already
                if (!globalVisitedStatus[u]) {

                    // if in a path node is visited again => there is a cycle
                    if (this.dfsUtil(u, globalVisitedStatus, pathVisitedStatus))
                        return true;
                }
            }
            return false;
        }

        private boolean dfsUtil(int u, boolean[] globalVisitedStatus, boolean[] pathVisitedStatus) {
            // Track the nodes
            globalVisitedStatus[u] = true;
            pathVisitedStatus[u] = true;

            for (int v : this.adjList[u]) {
                // if node is visited already in the path => cycle detected
                if (pathVisitedStatus[v] == true)
                    return true;

                // if node is not visited, visit the node and check if there is a cycle
                if (!globalVisitedStatus[v] && this.dfsUtil(v, globalVisitedStatus, pathVisitedStatus)) {
                    return true;
                }
            }

            // tracking back the path so that it can visited through next path if any
            pathVisitedStatus[u] = false;
            return false;
        }

    }

    public boolean isCycleDetected(int V, int[][] edges) {
        Graph graph = new Graph(V, edges);
        return graph.isCycleDetected();
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = { { 1, 2 }, { 4, 1 }, { 2, 4 }, { 3, 4 }, { 5, 2 }, { 1, 3 } };

        DirectedGraphCycleDetector detector = new DirectedGraphCycleDetector();
        System.out.println(detector.isCycleDetected(V, edges));

        int[][] edges1 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
        System.out.println(detector.isCycleDetected(V, edges1));
    }
}