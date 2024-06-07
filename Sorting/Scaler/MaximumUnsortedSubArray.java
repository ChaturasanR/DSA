/* Given an array A of non-negative integers of size N. Find the minimum sub-array
*  Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array,
*  then the whole array should get sorted. If A is already sorted, output -1.

Solution: If there is a unsorted patch, then there will be breakpoints

[1,2,5,4,3,6,7] break points index = 2, 4
[1, 4, 5, 3, 2, 6, 7] break points index = 1, 4

To solve this we can follow below steps
Find the index from starts where it starts decreasing and find the minimum value for the remaining subarray
Similary we traverse from end and find where it starts increasing and from there we find the maximum value for the remaining subarray
Once we got min and max of unsorted array, we need to find the right place for them by traversing the array again

*/

// T.C: O(N), S.C: O(1)
public class MaximumUnsortedSubArray {

    public int[] getUnsortedSubArrayIndices(int[] numbers) {
        int numbersLength = numbers.length;
        int left = 0;

        // get the break point from left where unsorted portion starts
        while (left < numbersLength) {
            if (numbers[left + 1] < numbers[left])
                break;
            left++;
        }

        // get the break point from right where unsorted portion starts
        int right = numbersLength - 1;
        while (right > 0) {
            if (numbers[right - 1] > numbers[right])
                break;
            right--;
        }

        if (left == numbersLength - 1)
            return new int[] { -1, -1 };

        // with that range find the min and max values so that we map to their sorted
        // positions
        int start = left, end = right;
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            minVal = Math.min(minVal, numbers[i]);
            maxVal = Math.max(maxVal, numbers[i]);
        }

        // map the minimum value to the its position from left
        left = 0;
        while (left <= start) {
            if (numbers[left] > minVal)
                break;
            left++;
        }

        // map the maximum value to the its position from right
        right = numbersLength - 1;
        while (right >= end) {
            if (numbers[right] < maxVal)
                break;
            right--;
        }

        return new int[] { left, right };
    }
}
