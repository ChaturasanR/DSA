/**
 * Pick From Both Sides
 * Problem Description
 * You are given an integer array A of size N.
 * You have to perform B operations. In one operation, you can remove either the
 * leftmost or the rightmost element of the array A.
 * Find and return the maximum possible sum of the B elements that were removed
 * after the B operations.
 * NOTE: Suppose B = 3, and array A contains 10 elements, then you can:
 * Remove 3 elements from front and 0 elements from the back, OR
 * Remove 2 elements from front and 1 element from the back, OR
 * Remove 1 element from front and 2 elements from the back, OR
 * Remove 0 elements from front and 3 elements from the back.
 * 
 * Approach:
 * Brute Force: Try out all possibilities,
 * Starting with index i = B-1, move towards 0 and calculate Sum. For example
 * For i = B-1, sum = elems from j = 0 to i-1 + arr[n-1]
 * T.C: O(B^2)
 * 
 * Optimized Way: If we observe there is an overlapping sum calculator. So one
 * ways is to use a sliding window to find the min-sum of window Size N-B and
 * remove that sum from the total Sum.
 * 
 * T.C: O(N), S.C: O(1)
 * 
 * Best Way:
 * Calculate the Sum of the first B elements starting from 0
 * Now start removing elem from B-1 and add elements from end
 * Take the max of those sums
 * 
 */

// T.C: O(B), S.c: O(1)
public class BElemsSum {
    public int maxSum(int[] numbers, int B) {
        int n = numbers.length;
        B %= n;

        int BElemsSum = 0;
        for (int i = 0; i < B; i++) {
            BElemsSum += numbers[i];
        }

        int maxSum = BElemsSum;
        for (int i = 0; i < B; i++) {
            BElemsSum -= (numbers[B - i - 1] - numbers[n - i - 1]);
            maxSum = Math.max(maxSum, BElemsSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] numbers = { 5, -2, 3, 1, 2 };
        BElemsSum bElemsSum = new BElemsSum();
        System.out.println(bElemsSum.maxSum(numbers, 3));
    }
}
