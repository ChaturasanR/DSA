import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int V;
    private boolean[][] adjMatrix;
    private List<Integer>[] adjList;
    private boolean isAdjList;

    public Graph(int V, int[][] edges, boolean isAdjList, boolean isDirectedGraph, boolean zeroIndexBasedVertices) {
        this.V = V;
        if (isAdjList) {
            adjList = new ArrayList[V];

            for (int[] edge : edges) {
                int startVertex = edge[0];
                int endVertex = edge[1];
                if (!zeroIndexBasedVertices) {
                    startVertex -= 1;
                    endVertex -= 1;
                }

                adjList[startVertex].add(endVertex);
                if (!isDirectedGraph) {
                    adjList[endVertex].add(startVertex);
                }

            }
            return;
        }

        this.adjMatrix = new boolean[V][V];
        for (int[] edge : edges) {
            int startVertex = edge[0];
            int endVertex = edge[1];
            if (!zeroIndexBasedVertices) {
                startVertex -= 1;
                endVertex -= 1;
            }

            adjMatrix[startVertex][endVertex] = true;
            if (!isDirectedGraph) {
                adjMatrix[endVertex][startVertex] = true;
            }
        }
    }

    public List<Integer> getAdjListEdges(int u) {
        if (this.adjList == null)
            throw new RuntimeException("No Adjacency List created");

        return this.adjList[u];
    }

    public boolean isEdgePresentInAdjMatrix(int u, int v) {
        if (this.adjMatrix == null)
            throw new RuntimeException("No Adjacency Matrix created");

        return this.adjMatrix[u][v];
    }
}
