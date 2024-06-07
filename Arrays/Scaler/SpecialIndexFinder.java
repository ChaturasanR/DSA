/**
 * Special Index
 * Given an array, arr[] of size N, the task is to find the count of array
 * indices such that removing an element from these indices makes the sum of
 * even-indexed and odd-indexed array elements equal.
 * 
 * Approach:
 * Brute Force: For each index find the even and odd sums towards left and right
 * and check. If both are equal increment the count
 * 
 * T.C: O(N^2), S.C: O(1)
 * 
 * Better Approach: If we observe, if we remove Idx odd sum and even after that
 * idx will be swapped. Based on idx we need to remove that elem from the
 * respective sum. So
 * Calculate TotalOddSum and TotalEvenSum
 * Maintain running sums for even and oddSums to the left LeftEvenSum,
 * LeftOddSum
 * So if we remove the idx,
 * If idx%2 == 0, RemainingOddSum = TotalEvenSum - num[idx] - LeftEvenSum,
 * RemainingEvenSum = TotalEvenSum - LeftOddSum
 * else, RemainingEvenSum = TotalOddSum - num[idx] - LeftOddSum,
 * RemainingOddSum = TotalEvenSum - LeftEvenSum
 * If LeftEvenSum + RemainingEvenSum = LeftOddSum + RemainingOddSum => special
 * Idx
 * 
 */

// T.C: O(N), S.C: O(1)
public class SpecialIndexFinder {
    private int totalOddSum;
    private int totalEvenSum;

    public int countSpecialIndices(int[] numbers) {
        int count = 0;
        calculateTotalEvenAndOddSums(numbers);
        int leftEvenSum = 0;
        int leftOddSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            int remainingEvenSum = 0;
            int remainingOddSum = 0;
            int totalEvenSumForIdx = 0;
            int totalOddSumForIdx = 0;
            if (i % 2 == 0) {
                remainingOddSum = totalEvenSum - numbers[i] - leftEvenSum;
                remainingEvenSum = totalOddSum - leftOddSum;
                totalEvenSumForIdx = leftEvenSum + remainingEvenSum;
                totalOddSumForIdx = leftOddSum + remainingOddSum;
                leftEvenSum += numbers[i];
            } else {
                remainingEvenSum = totalOddSum - numbers[i] - leftOddSum;
                remainingOddSum = totalEvenSum - leftEvenSum;
                totalEvenSumForIdx = leftEvenSum + remainingEvenSum;
                totalOddSumForIdx = leftOddSum + remainingOddSum;
                leftOddSum += numbers[i];
            }

            if (totalEvenSumForIdx == totalOddSumForIdx)
                count++;
        }
        return count;
    }

    private void calculateTotalEvenAndOddSums(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0)
                totalEvenSum += numbers[i];
            else
                totalOddSum += numbers[i];
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 2, 1, 6, 4 };
        SpecialIndexFinder specialIndexFinder = new SpecialIndexFinder();
        System.out.println(specialIndexFinder.countSpecialIndices(numbers));
    }
}
