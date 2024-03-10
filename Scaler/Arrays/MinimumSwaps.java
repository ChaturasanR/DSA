/**
 * Minimum Swaps
 * Given an array of integers A and an integer B, find and return the minimum
 * number of swaps required to bring all the numbers less than or equal to B
 * together.
 * 
 * Note: It is possible to swap any two elements, not necessarily consecutive.
 * 
 * Approach:
 * Brute Force:
 * All numbers less than or equal to B should come together i.e. subarray
 * For that, we need to find the number of elements <= B, let’s call it K
 * We need to iterate over subarrays of size K and find the number of elements
 * that are greater than B. That gives the number of elements to be swapped
 * From those, return the minimum swaps required
 * 
 * Optimized Way:
 * If we observe, we are redoing some calculations for counting a number of
 * elements > B.
 * We can use the sliding window technique to optimize those calculations
 * 
 */

// T.C: O(N), S.C: O(1)
public class MinimumSwaps {
    public int getMinSwapsRequired(int[] numbers, int threshold) {
        int windowSize = getElemsLessThanOrEqualTo(numbers, threshold);
        int n = numbers.length;
        if (windowSize == n || windowSize == 0)
            return 0;

        int swapsNeeded = 0;
        int minSwapsNeeded = numbers.length;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > threshold)
                swapsNeeded++;
            if (i >= windowSize - 1) {
                minSwapsNeeded = Math.min(minSwapsNeeded, swapsNeeded);
                swapsNeeded -= (numbers[i - windowSize + 1] > threshold ? 1 : 0);
            }
        }
        return minSwapsNeeded;
    }

    private int getElemsLessThanOrEqualTo(int[] numbers, int threshold) {
        int count = 0;
        for (int num : numbers) {
            if (num <= threshold)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 12, 10, 3, 14, 10, 5 };
        MinimumSwaps minimumSwaps = new MinimumSwaps();
        System.out.println(minimumSwaps.getMinSwapsRequired(numbers, 8));
    }
}
