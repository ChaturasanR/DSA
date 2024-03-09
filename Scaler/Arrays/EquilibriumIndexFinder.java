/**
 * Equilibrium index of an array
 * You are given an array A of integers of size N.
 * Your task is to find the equilibrium index of the given array
 * The equilibrium index of an array is an index such that the sum of elements
 * at lower indexes is equal to the sum of elements at higher indexes.
 * If there are no elements that are at lower indexes or at higher indexes, then
 * the corresponding sum of elements is considered as 0.
 * Note:
 * Array indexing starts from 0.
 * If there is no equilibrium index then return -1.
 * If there are more than one equilibrium index then return the minimum index.
 * 
 * Approach:
 * BruteForce: For each index, check sum of value at left indices == sum of
 * value at right indices and return the first such index
 * 
 * T.C: O(N^2), S.C: O(1)
 * 
 * Optimized Approach: If we observe, we are doing repetitive calculations. So
 * we can make use of prefix Sum T.C: O(N), S.C: O(N)
 * 
 * Best Approach: If we observe the range for calculating sum is not varying,
 * end is fixed and start is varying so we can check the left sum by running sum
 * and for right sum we can calculate by totalSum - leftsum - nums[currIdx]
 * 
 * T.C: O(N), S.C: O(1)
 * 
 */

// T.C: O(N), S.C: O(1)
// prefixSum technique
public class EquilibriumIndexFinder {
    private int totalSum;

    public int findFirstEquilibriumIndex(int[] numbers) {
        int leftSum = 0;

        calculateTotalSum(numbers);
        for (int idx = 0; idx < numbers.length; idx++) {
            if (leftSum == totalSum - leftSum - numbers[idx])
                return idx;

            leftSum += numbers[idx];
        }
        return -1;
    }

    private void calculateTotalSum(int[] numbers) {
        for (int num : numbers)
            totalSum += num;
    }

    public static void main(String[] args) {
        int[] numbers = { -7, 1, 5, 2, -4, 3, 0 };
        EquilibriumIndexFinder equilibriumIndexFinder = new EquilibriumIndexFinder();
        System.out.println(equilibriumIndexFinder.findFirstEquilibriumIndex(numbers));
    }
}
