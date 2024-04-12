import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Description
 * Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
 * 
 * Each cell can have three values:
 * 
 * The value 0 representing an empty cell.
 * 
 * The value 1 representing a fresh orange.
 * 
 * The value 2 representing a rotten orange.
 * 
 * Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom)
 * to a rotten orange becomes rotten. Return the minimum number of minutes that
 * must elapse until no cell has a fresh orange. If this is impossible, return
 * -1 instead.
 * 
 * Note: Your solution will run on multiple test cases. If you are using global
 * variables, make sure to clear them.
 * 
 * Solution:
 * Shortest Distance/Time => BFS
 * Since multiple oranges rotten at every min, we use multi-cell BFS
 * 1. Start with adding the cells whose oranges are rotten (cell value = 2) to
 * the queue
 * 2. For each cell in curr queue, mark the adjacent oranges which are fresh as
 * rotten and add to queue.
 * 3. Repeat this until all oranges are rotten
 * 4. For every such iteration increment the time
 * 5. Check if there is any orange which haven't become rotten
 * a. if yes return -1
 * b. else return time taken
 * 
 * T.C: O(N*M), S.C: O(1)
 */
public class RottenOranges {

    class Cell {
        private final int row;
        private final int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }
    }

    private int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    // apply multi-cell BFS
    public int getMinTime(int[][] matrix) {
        Queue<Cell> queue = new LinkedList<>();

        int M = matrix.length;
        if (M == 0)
            return 0;
        int N = matrix[0].length;
        if (N == 0)
            return 0;

        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                if (matrix[row][col] == 2)
                    queue.add(new Cell(row, col));
            }
        }

        int duration = 0;
        while (!queue.isEmpty()) {
            int currQueueSize = queue.size();
            while (currQueueSize-- > 0) {
                Cell currCell = queue.poll();
                for (int[] direction : directions) {
                    int nextCellRow = currCell.getRow() + direction[0];
                    int nextCellCol = currCell.getCol() + direction[1];

                    if (isValidCell(nextCellRow, nextCellCol, M, N) && matrix[nextCellRow][nextCellCol] == 1) {
                        matrix[nextCellRow][nextCellCol] = 2;
                        queue.add(new Cell(nextCellRow, nextCellCol));
                    }
                }
            }
            duration++;
        }

        // Last level won't have any new cells to be added
        duration--;

        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                if (matrix[row][col] == 1)
                    return -1;
            }
        }
        return duration;
    }

    private boolean isValidCell(int row, int col, int M, int N) {
        return row >= 0 && col >= 0 && row < M && col < N;
    }

}
