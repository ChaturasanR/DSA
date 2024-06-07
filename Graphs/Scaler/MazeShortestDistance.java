import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Description
 * Given a matrix of integers A of size N x M describing a maze. The maze
 * consists of empty locations and walls.
 * 
 * 1 represents a wall in a matrix and 0 represents an empty location in a wall.
 * 
 * There is a ball trapped in a maze. The ball can go through empty spaces by
 * rolling up, down, left or right, but it won't stop rolling until hitting a
 * wall (maze boundary is also considered as a wall). When the ball stops, it
 * could choose the next directionection.
 * 
 * Given two array of integers of size B and C of size 2 denoting the starting
 * and destination position of the ball.
 * 
 * Find the shortest distance for the ball to stop at the destination. The
 * distance is defined by the number of empty spaces traveled by the ball from
 * the starting position (excluded) to the destination (included). If the ball
 * cannot stop at the destination, return -1.
 * 
 * Observations:
 * 1. Shortest path to destination is applicable iff it stops at destination
 * 2. Shortest path => Go level by level (BFS)
 * 3. Until it finds the wall, the ball keeps on rolling in straight line
 * (shortest path)
 * 4. At wall it can go in any of the directionections, so we need to try all of
 * the
 * directionections at an encounter of wall/Boundary
 * 
 * Sol:
 * 1. Use BFS to go level by level
 * 2. Cells that are in interest are the ones where the direction can change, we
 * will store them only in the queue
 * 
 * T.C: O(N*M), S.C: O(1)
 */
public class MazeShortestDistance {

    class Point {
        private int x;
        private int y;
        private int distanceFromSource;

        public Point(int x, int y, int distanceFromSource) {
            this.x = x;
            this.y = y;
            this.distanceFromSource = distanceFromSource;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        };

        public int getDistanceFromSource() {
            return this.distanceFromSource;
        }
    }

    private final int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    // Use BFS to find the shortest distance
    public int getShortestDistance(int[][] matrix, int[] source, int[] dest) {
        // corner cases
        int n = matrix.length;
        if (n == 0)
            return -1;

        int m = matrix[0].length;
        if (m == 0)
            return -1;

        // Queue for level order traversal, cells that are in interest are when they hit
        // the wall
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(source[0], source[1], 0));

        // marking the cell as visited
        matrix[source[0]][source[1]] = 2;

        // Level order traversal for cells that can cause direction change
        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            int currX = currentPoint.getX();
            int currY = currentPoint.getY();

            int distFromSource = currentPoint.getDistanceFromSource();

            // if ball hit the wall and curr point is the dest, return the distance
            if (currX == dest[0] && currY == dest[1])
                return distFromSource;

            matrix[currX][currY] = 2;

            // Try all four directions
            for (int[] direction : directions) {
                int newX = currX + direction[0];
                int newY = currY + direction[1];
                int newPointDistanceFromSource = distFromSource + 1;

                // increase the distance until it keeps on rolling, straight line is shortest
                // distance
                while (canRoll(matrix, newX, newY, n, m)) {
                    newX += direction[0];
                    newY += direction[1];
                    newPointDistanceFromSource++;
                }

                newX -= direction[0];
                newY -= direction[1];
                newPointDistanceFromSource--;

                // at curr cell ball hit the wall and also this is not visited already
                if (matrix[newX][newY] != 2) {
                    matrix[newX][newY] = 2;
                    queue.add(new Point(newX, newY, newPointDistanceFromSource));
                }

            }
        }
        return -1;
    }

    private boolean canRoll(int[][] matrix, int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m && matrix[x][y] != 1;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 0 }, { 0, 0 } };
        int[] source = { 0, 0 };
        int[] dest = { 0, 1 };

        MazeShortestDistance mazeShortestDistance = new MazeShortestDistance();
        System.out.println(mazeShortestDistance.getShortestDistance(matrix, source, dest));
    }
}
