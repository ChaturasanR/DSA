/**
 * Given a matrix of integers A of size N x M consisting of 0 and 1. A group of
 * connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you
 * can visit any cell that shares a corner with (i, j) and value in that cell is
 * 1.
 * 
 * More formally, from any cell (i, j) if A[i][j] = 1 you can visit:
 * 
 * (i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
 * (i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
 * (i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
 * (i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
 * (i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
 * (i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
 * (i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
 * (i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
 * Return the number of islands.
 * 
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left
 * to right.
 * 
 * Sol:
 * Find the number of components using DFS/BFS
 * 1. When applied DFS/BFS, all nodes of the single component are visited in one
 * go
 * 2. Number of iterations to visit all the nodes => number of components =>
 * number of islands
 * 
 * T.C: O(N*M), S.C: O(1)
 */

public class IslandsCounter {

    public final int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { -1, -1 }, { 1, -1 }, { 1, 1 },
            { -1, 1 } };

    public int getIslandsCount(int[][] matrix) {
        int islandsCount = 0;

        // Counting the islands which are not connect i.e number of components
        for (int u = 0; u < matrix.length; u++) {
            for (int v = 0; v < matrix[u].length; v++) {
                if (matrix[u][v] == 1) {
                    islandsCount++;
                    dfsUtil(matrix, u, v);
                }
            }
        }

        // Reseting to the original matrix
        for (int u = 0; u < matrix.length; u++) {
            for (int v = 0; v < matrix[u].length; v++) {
                if (matrix[u][v] == 2) {
                    matrix[u][v] = 1;
                }
            }
        }
        return islandsCount;
    }

    private void dfsUtil(int[][] matrix, int u, int v) {
        // Using the same matrix to store the visited islands
        matrix[u][v] = 2;
        for (int[] direction : directions) {
            int newU = u + direction[0];
            int newV = v + direction[1];
            if (isValidLand(matrix, newU, newV))
                dfsUtil(matrix, newU, newV);
        }
    }

    private boolean isValidLand(int[][] matrix, int u, int v) {
        return u >= 0 && v >= 0 && u < matrix.length && v < matrix[0].length && matrix[u][v] == 1;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
        IslandsCounter counter = new IslandsCounter();
        System.out.println(counter.getIslandsCount(matrix));
    }

}
