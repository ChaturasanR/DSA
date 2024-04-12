/**
 * Problem Description
 * Given a matrix of integers A of size N x N, where A[i][j] represents the
 * weight of directed edge from i to j (i ---> j).
 * 
 * If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to
 * vertex j, A[i][j] = -1.
 * 
 * Return a matrix B of size N x N where B[i][j] = shortest path from vertex i
 * to vertex j.
 * 
 * If there is no possible path from vertex i to vertex j , B[i][j] = -1
 * 
 * Note: Rows are numbered from top to bottom and columns are numbered from left
 * to right.
 * 
 * Solution:
 * Floyd Warshall Algorithm
 * 1. All pairs shortest distance algorithm
 * a. It measures distance between vertices using every other vertex as
 * intermediate.
 * b. It does not work it case of negative cycles - In case of negative cycles
 * the distance can be reduced to -inf
 * 
 * T.C: O(V^3), S.C: O(1)
 */
public class FloydWarshallAlgorithm {
    public int[][] allPairsShortestDistance(int[][] distances) {
        int vertices = distances.length;

        // Taking every other node as intermediate to calculate the shortest distance
        // between edges
        for (int intermediateVertex = 0; intermediateVertex < vertices; intermediateVertex++) {
            for (int startVertex = 0; startVertex < vertices; startVertex++) {
                for (int endVertex = 0; endVertex < vertices; endVertex++) {
                    if (intermediateVertex == startVertex || intermediateVertex == endVertex)
                        continue;

                    int actualDistance = distances[startVertex][endVertex];
                    int distance1 = distances[startVertex][intermediateVertex];
                    int distance2 = distances[intermediateVertex][endVertex];
                    if (distance1 == -1 || distance2 == -1)
                        continue;

                    if (actualDistance == -1 || (distance1 + distance2) < actualDistance)
                        distances[startVertex][endVertex] = distance1 + distance2;
                }
            }
        }
        return distances;
    }
}
