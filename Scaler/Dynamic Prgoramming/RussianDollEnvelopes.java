import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem Description
 * Given a matrix of integers A of size N x 2 describing dimensions of N
 * envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1]
 * denotes the width of the ith envelope.
 * 
 * One envelope can fit into another if and only if both the width and height of
 * one envelope is greater than the width and height of the other envelope.
 * 
 * Find the maximum number of envelopes you can put one inside other.
 * 
 * Sol:
 * Brute Force:
 * 
 * Generate all possible combinations of envelopes (similar to subsequences).
 * Find the count where the sequence one card can fit in other
 * 
 * T.C: O(2^N*N)
 * 
 * Optimized approach:
 * 1. Sort on either width or height and apply LIS to get the max count
 * 
 * T.C: O(NlogN + N^2), S.C: O(1)
 */
public class RussianDollEnvelopes {

    private int LIS(int[][] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;

        int[] longestCounts = new int[n];

        for (int i = 0; i < n; i++) {
            longestCounts[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j][0] < arr[i][0] && arr[j][1] < arr[i][1])
                    longestCounts[i] = Math.max(longestCounts[i], longestCounts[j] + 1);
            }
        }

        int maxCount = 0;
        for (int count : longestCounts)
            maxCount = Math.max(count, maxCount);
        return maxCount;
    }

    public int maxCount(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(arr -> arr[0]));
        return LIS(envelopes);
    }
}
