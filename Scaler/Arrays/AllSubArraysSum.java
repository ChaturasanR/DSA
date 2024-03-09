/**
 * Sum of All Subarrays
 * You are given an integer array A of length N.
 * You have to find the sum of all subarray sums of A.
 * More formally, a subarray is defined as a contiguous part of an array which
 * we can obtain by deleting zero or more elements from either end of the array.
 * A subarray sum denotes the sum of all the elements of that subarray.
 * Note : Be careful of integer overflow issues while calculations. Use
 * appropriate datatypes.
 * 
 * Approach:
 * BruteForce:
 * Generate all subarrays
 * Calculate the sum of each subarray and add to result
 * Return result
 * T.C: O(N^3), S.C: O(1)
 * 
 * By using running sum we can reduce this to T.C: O(N^2), S.C: O(1)
 * 
 * Optimized Approach:
 * Use contribution technique to calculate all subarrays sum i.e
 * Instead of generating all subarrays, calculate the number of subarrays
 * current element belongs to
 * Using that we can calculate
 * totalSum = (Number of subarrays containing curr elem * curr elem)
 * To calculate the number of arrays curr elem belongs to, let it be idx i
 * So this elem belongs to startElemIdx <= i and endElemIdx >= i
 * => (i-0+1) ways for startElemIdx, (N-1-i+1) = (N-i) ways for endElemIdx
 * So total subarrays for index i = startElemIdx ways * endElemIdx ways
 * => (i+1)*(N-i)
 * 
 */
// T.C: O(N), S.C: O(1)
// Contribution Technique
public class AllSubArraysSum {
    public long findAllSubArraysSum(int[] numbers) {
        long sum = 0;
        int n = numbers.length;
        for (int idx = 0; idx < n; idx++) {
            sum += 1l * (n - idx) * (idx + 1) * (numbers[idx]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3 };
        AllSubArraysSum allSubArraysSum = new AllSubArraysSum();
        System.out.println(allSubArraysSum.findAllSubArraysSum(numbers));
    }
}