import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a undirected graph having A nodes. A matrix B of size M x 2 is given
 * which represents the edges such that there is an edge between B[i][0] and
 * B[i][1].
 * 
 * Find whether the given graph is bipartite or not.
 * 
 * A graph is bipartite if we can split it's set of nodes into two independent
 * subsets A and B such that every edge in the graph has one node in A and
 * another node in B
 * 
 * Note:
 * 
 * There are no self-loops in the graph.
 * 
 * No multiple edges between two pair of vertices.
 * 
 * The graph may or may not be connected.
 * 
 * Nodes are Numbered from 0 to A-1.
 * 
 * Your solution will run on multiple testcases. If you are using global
 * variables make sure to clear them.
 * 
 * Solution:
 * Bipartitie Graph -
 * q. chromatic number is 2 (Chromatic number - Mininum colors needed to color
 * the graph such that no
 * two adjacent vertices have the same color)
 * b. The graph is bipartitie if we
 * can divide the vertices into two sets such that edges run across them
 * 
 * 1. Create color array of size V and assign them to -1 initially
 * 2. Apply DFS on every node, when ever we are starting with new component
 * assign the initial vertex color to 0
 * 3. While DFS
 * a. Assign color[v] = 1 -color[u] so that adjacent vertices have different
 * color assigned
 * b. if we found curr node and adjacent vertex leds to same color return false
 */
public class BiPartiteGraphChecker {
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
                int startVertex = edge[0];
                int endVertex = edge[1];
                adjList[startVertex].add(endVertex);
                adjList[endVertex].add(startVertex);
            }

        }

        public List<Integer> getAdjListEdges(int u) {
            if (this.adjList == null)
                throw new RuntimeException("No Adjacency List created");

            return this.adjList[u];
        }

        public boolean checkBiParitite() {
            int[] colors = new int[this.V];
            Arrays.fill(colors, -1);

            for (int u = 0; u < this.V; u++) {
                // for each component, set the color of first vertex to 0
                if (colors[u] == -1) {
                    colors[u] = 0;
                    // apply DFS and set the neighbour vertex the opposite color
                    if (!this.dfsUtil(u, colors))
                        return false;
                }
            }
            return true;
        }

        private boolean dfsUtil(int u, int[] colors) {
            for (int v : this.adjList[u]) {
                // if current and neighbour has same color => not a bipartite graph
                if (colors[u] == colors[v])
                    return false;

                if (colors[v] == -1) {
                    colors[v] = 1 - colors[u];
                    if (!dfsUtil(v, colors))
                        return false;
                }
            }
            return true;
        }

    }

    public int checkIfBirpartiteGraph(int V, int[][] edges) {
        Graph graph = new Graph(V, edges);
        return graph.checkBiParitite() ? 1 : 0;
    }

    public static void main(String[] args) {
        int totalVertices = 2;
        int[][] edges = { { 0, 1 } };
        BiPartiteGraphChecker biPartiteGraphChecker = new BiPartiteGraphChecker();
        System.out.println(biPartiteGraphChecker.checkIfBirpartiteGraph(totalVertices, edges));

        totalVertices = 3;
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        System.out.println(biPartiteGraphChecker.checkIfBirpartiteGraph(totalVertices, edges1));
    }
}
