/**
 * Problem Description
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message denoted by string A containing digits, determine the
 * total number of ways to decode it modulo 109 + 7.
 * 
 * Sol:
 * (112) - (11B) (1L) - (1AB) (KB) (AL). Two overlapping subproblems for 1
 * DP state: dp[i]: calculate number of ways to decode till ith index
 * dp[i] = dp[i-1] + (dp[i-2] if str.substring(i-1, i+1) <= 26)
 * dp[0] = 0
 * 
 * T.C: O(N), S.C: O(N)
 */
public class WaysToDecode {
    private final long MOD = 1_000_000_007l;

    public int numDecodings(String A) {
        int n = A.length();
        long[] dp = new long[n + 1];

        dp[0] = 1l;
        for (int i = 1; i <= n; i++) {
            // Handling 0s
            if (A.charAt(i - 1) != '0')
                dp[i] = dp[i - 1];
            if (i > 1 && A.charAt(i - 2) != '0' && Integer.valueOf(A.substring(i - 2, i)) <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
        }
        return (int) dp[n];
    }
}
