
/**
 * Range Sum Query
You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.

Approach:
Brute Force: For each query, calculate the sum in the range and return T.C: O(N*Q), S.C: O(1). If Q is large, T.C will be worse

Optimized approach: Generate the prefix sum and return the sum for query (start, end) as 
1. prefixSum[end] - prefixSum[start-1], start > 0
2. prefixSum[end], start == 0
 */

//T.C: O(max(N, Q)), S.C: O(1)
//prefixSum Technique
import java.util.Arrays;

public class RangeSumQuery {

    private long[] prefixSum;

    public long[] rangeSum(int[] numbers, int[][] queries) {
        long[] sums = new long[queries.length];

        if (numbers.length == 0) {
            Arrays.fill(sums, 0);
            return sums;
        }

        calculatePrefixSum(numbers);

        int queryNumber = 0;
        for (int[] query : queries) {
            sums[queryNumber] = getSumPerQuery(query);
            queryNumber++;
        }
        return sums;
    }

    private void calculatePrefixSum(int[] numbers) {
        prefixSum = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                prefixSum[i] = numbers[i];
                continue;
            }
            prefixSum[i] = prefixSum[i - 1] + numbers[i];
        }
    }

    // use prefix sum to calculate the sum in the range
    private long getSumPerQuery(int[] query) {
        int start = query[0];
        if (start >= prefixSum.length)
            return 0;

        int end = query[1];
        if (end >= prefixSum.length)
            end = prefixSum.length - 1;

        if (start > end) {
            int temp = end;
            end = start;
            start = temp;
        }

        return start <= 0 ? prefixSum[end] : prefixSum[end] - prefixSum[start - 1];
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5 };
        int[][] queries = { { 0, 3 }, { 1, 2 }, { 5, 6 }, { 3, 2 }, { 1, 5 } };
        RangeSumQuery rangeSumQuery = new RangeSumQuery();
        long[] result = rangeSumQuery.rangeSum(numbers, queries);
        System.out.println(Arrays.toString(result));
    }
}