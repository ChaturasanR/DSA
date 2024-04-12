import java.util.Arrays;

/**
 * Problem Description
 * Given an integer A. Return minimum count of numbers, sum of whose squares is
 * equal to A.
 * 
 * Solution:
 * (14) -> 13 10 5 -> 12 9 4 9 6 1 4 1
 * Follows optimal substructure and there are overlaping subproblems
 * DP state dp[i] => for ith number return the minimum count of squares such
 * that they equal i
 * DP Expression dp[i] = min(dp[i], dp[i-j*j] + 1) j*j <= i
 * 
 * Brute Force T.C: Exponential
 */
public class MinimumNumberOfSquares {

    // T.C: O(N*sqrt(N)), S.C: O(N)
    public int minCountOfNumbers(int N) {
        int dp[] = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[N];
    }

    // T.C: O(N*sqrt(N)), S.C: O(N + sqrt(N))
    public int minCountOfNumbersMem(int N) {
        int[] mem = new int[N + 1];
        Arrays.fill(mem, -1);

        return minCountOfNumbersUtil(N, mem);
    }

    private int minCountOfNumbersUtil(int N, int[] mem) {
        if (N == 0)
            return 0;

        if (mem[N] != -1)
            return mem[N];

        int minVal = Integer.MAX_VALUE;
        for (int i = 1; i * i <= N; i++) {
            minVal = Math.min(minVal, minCountOfNumbersUtil(N - i * i, mem) + 1);
        }
        mem[N] = minVal;
        return mem[N];
    }

}
