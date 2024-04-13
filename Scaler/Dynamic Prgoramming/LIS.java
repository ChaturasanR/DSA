/**
 * Problem Description
 * Find the longest increasing subsequence of a given array of integers, A.
 * 
 * In other words, find a subsequence of array in which the subsequence's
 * elements are in strictly increasing order, and in which the subsequence is as
 * long as possible.
 * 
 * In this case, return the length of the longest increasing subsequence.
 * 
 * Solution:
 * Brute Force: Generate all subsequence, for those that are increasing sequence
 * calculate len and return max len T.C: O(2^N*N), S.C: O(N)
 * 
 * Optimised approach: Find every index find the max possible increasing
 * subsequence length and take the max of all indices
 * 
 * T.C: O(N^2), S.C: O(N)
 * 
 */
public class LIS {

    public int getLongestIncreaseSubSequenceCount(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;

        int[] longestCounts = new int[n];

        for (int i = 0; i < n; i++) {
            longestCounts[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i])
                    longestCounts[i] = Math.max(longestCounts[i], longestCounts[j] + 1);
            }
        }

        int maxCount = 0;
        for (int count : longestCounts)
            maxCount = Math.max(count, maxCount);
        return maxCount;
    }
}
