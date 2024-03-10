/**
 * Closest MinMax
 * Given an array A, find the size of the smallest subarray such that it
 * contains at least one occurrence of the maximum value of the array
 * and at least one occurrence of the minimum value of the array.
 * 
 * Approach:
 * Brute Force:
 * Find the min and max of the array
 * Iterate over array
 * If curr elem is min element, check for nearest max elem in left and right
 * If curr elem in max element, check for nearest min elem in left and right
 * T.C: O(N^2), S.C: O(1)
 * 
 * Optimized Way:
 * Since we want is min subarray, we can observe that subarray with min and max
 * at the edges make it the min subarray
 * For that, first, find the min and max of the array
 * Then iterate over the array and store the idx at which min or max is found
 * At each min or max is found, update the min or max index with the current
 * index
 * check if the counterpart is already found
 * If yes, get the difference between those indices and update the minimum
 * length accordingly
 * T.C: O(N), S.C: O(1)
 * 
 */

// T.C: O(N), S.C: O(1)
public class ClosestMinMax {
    public int getMinSubArrayLength(int[] numbers) {
        int[] minMaxElems = getMinAndMaxElems(numbers);

        int minLength = numbers.length;
        int minElemIdx = -1;
        int maxElemIdx = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == minMaxElems[0]) {
                minElemIdx = i;
            }

            if (numbers[i] == minMaxElems[1]) {
                maxElemIdx = i;
            }

            if (minElemIdx != -1 && maxElemIdx != -1) {
                minLength = Math.min(minLength, Math.abs(minElemIdx - maxElemIdx) + 1);
            }
        }
        return minLength;
    }

    private int[] getMinAndMaxElems(int[] numbers) {
        int minElem = Integer.MAX_VALUE;
        int maxElem = Integer.MIN_VALUE;

        for (int num : numbers) {
            minElem = Math.min(minElem, num);
            maxElem = Math.max(maxElem, num);
        }
        return new int[] { minElem, maxElem };
    }

    public static void main(String[] args) {
        // int[] numbers = { 2, 6, 1, 6, 9 };
        int[] numbers = { 1, 9, 1, 6, 9 };
        ClosestMinMax closestMinMax = new ClosestMinMax();
        System.out.println(closestMinMax.getMinSubArrayLength(numbers));
    }
}
