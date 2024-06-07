import java.util.Arrays;

/**
 * Problem Description
 * Given a string A, partition A such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of A.
 * 
 * Solution:
 * Brute Force: T.C: O(2^N*N^2), S.c: O(N)
 * 1. Starting from 0th index try out all possible substrings, for every
 * palindrome substring make a cut and repeat the same process for remaining
 * substring
 * 2. For ith, get all those cuts count and return the min count
 * aabac - (a, abac) (aa, bac) - (a, a, bac) (aa, b, a, c) => there are
 * overlapping subproblems
 * 
 * Optimized Approach:
 * 1. Use memoization T.C: O(N^3), S.C: O(N)
 * 2. Bottom Up
 * a. DP State - dp[i] = min cuts needed for substring 0-i to become palindrom
 * partitioning
 * b. DP expression dp[i] = min(dp[j] + 1) if dp[j, i] is palindromic j: 0 to
 * i-1;
 * c. Base case: dp[0] = 1
 * 
 * To reduce T.C to O(N^2) we can first find out the possible palindrome
 * substrings and store them
 */
public class PalindromePartitioningII {
    public int getMinCuts(String str) {
        // int[] mem = new int[str.length()];
        // Arrays.fill(mem, -1);
        // return getMinCutsBackTracking(str, 0, mem);

        // return getMinCutsBottomUp(str);
        return getMinCutsOptimized(str);

    }

    // T.C: O(N^2), S.C: O(N^2)
    private int getMinCutsOptimized(String str) {
        int n = str.length();
        if (n == 0)
            return 0;
        boolean[][] isPalindrome = new boolean[n][n];

        int subStringLen = 1;
        while (subStringLen <= n) {
            for (int start = 0; start < n; start++) {
                int end = start + subStringLen - 1;
                if (subStringLen == 1)
                    isPalindrome[start][start] = true;
                else if (subStringLen == 2) {
                    if (end < n && str.charAt(start) == str.charAt(end))
                        isPalindrome[start][end] = true;
                } else {
                    if (end < n && isPalindrome(str, start, end))
                        isPalindrome[start][end] = true;
                }
            }
            subStringLen++;
        }

        if (isPalindrome(str, 0, n - 1))
            return 0;

        int cuts[] = new int[n + 1];
        Arrays.fill(cuts, Integer.MAX_VALUE);
        cuts[0] = 0;
        for (int e = 0; e < n; e++) {
            if (isPalindrome[0][e]) {
                cuts[e + 1] = 0;
                continue;
            }

            for (int s = e; s >= 0; s--) {
                if (isPalindrome[s][e])
                    cuts[e + 1] = Math.min(cuts[e + 1], cuts[s] + 1);
            }
        }

        return cuts[n];
    }

    private int getMinCutsBottomUp(String str) {
        if (isPalindrome(str, 0, str.length() - 1))
            return 0;

        int[] dp = new int[str.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isPalindrome(str, 0, i)) {
                dp[i + 1] = 0;
                continue;
            }

            for (int j = i; j >= 0; j--) {
                if (isPalindrome(str, j, i)) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + 1);
                }
            }
        }
        return dp[str.length()];
    }

    private int getMinCutsBackTracking(String str, int start, int[] mem) {
        if (start == str.length())
            return 0;

        if (isPalindrome(str, start, str.length() - 1))
            return 0;

        if (mem[start] != -1)
            return mem[start];

        int minCuts = Integer.MAX_VALUE;
        for (int s = start; s < str.length(); s++) {
            if (isPalindrome(str, start, s)) {
                minCuts = Math.min(minCuts, getMinCutsBackTracking(str, s + 1, mem) + 1);
            }
        }

        mem[start] = minCuts;
        return mem[start];
    }

    private boolean isPalindrome(String str, int s, int e) {
        while (s < e) {
            if (str.charAt(s) != str.charAt(e))
                return false;
            s++;
            e--;
        }
        return true;
    }

}
