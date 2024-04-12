/**
 * Problem Description
 * You are climbing a staircase and it takes A steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Return the number of distinct ways modulo 1000000007
 * 
 * sol: Nth step can be reached from N-1 and N-2
 * N -> N-1 N-2 -> N-2 N-3 N-3 N-4 => overlapping subproblems and problem can be
 * solved using subproblems
 * 
 * DP state -> dp[i] = calculates the number of ways to reach ith stair
 * 
 * DP expression -> number of ways of reaching i = number of ways of reaching
 * i-1 * 1 + number of ways of reaching i-2 * 1
 * dp[i] = dp[i-1] + dp[i-2];
 * 
 * base case dp[1] = 1, dp[2] = 2
 * 
 * T.C: O(N), S.C: O(1)
 * 
 * This is similar to Fibanocci sequence
 */
public class StaircaseClimbing {
    private final long mod = 1_000_000_007l;

    public int getMinSteps(int N) {
        if (N == 1)
            return 1;

        if (N == 2)
            return 2;

        long i_2thStairWays = 1l;
        long i_1thStairWays = 2l;
        long ithStairWays = 0l;

        for (int i = 3; i <= N; i++) {
            ithStairWays = (i_1thStairWays + i_2thStairWays) % mod;
            i_2thStairWays = i_1thStairWays;
            i_1thStairWays = ithStairWays;
        }
        return (int) ithStairWays;
    }
}
