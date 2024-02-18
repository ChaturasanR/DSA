/*
Problem: Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor. This need to be done in O(logN)

Solution: We can try to find the peak element using iteration by picking the max value but T.C is O(N)

We can use binary search to find it. So we follow below steps
Find mid elem and check if arr[mid] >= arr[mid-1] and arr[mid] >= arr[mid+1] that is the element we are looking for
If arr[mid] < arr[mid-1] => element we are looking for is on left side
Else element we are looking for is on right side
If no such element is found return -1

Edge cases
If no elements in arr, return -1
If single element, return it
If arr[0] > arr[1] return arr[0] (corner elements)
If arr[n-1] > arr[n-2] return arr[n-1] (corner elements)
*/

// T.C: O(logN), S.C: O(1)
public class PeakElement {
    public int getPeakElement(int[] arr) {
        int n = arr.length;
        // Edge cases
        if (n == 0)
            return -1;

        if (n == 1)
            return arr[0];
        // Handling corner elements
        if (arr[0] >= arr[1])
            return arr[0];

        if (arr[n - 1] > arr[n - 2])
            return arr[n - 1];

        // Check for element in the middle
        int left = 1, right = n - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1])
                return arr[mid];
            else if (arr[mid] < arr[mid - 1])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
