/*
Problem: Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A. Return an array of size 2, such that 
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If num is not found in A, return [-1, -1].
Note : Your algorithm's runtime complexity must be in the order of O(log n).

Solution: We can use binary search to obtain the results.
To first first Index
We have the search range of whole array
We calculate the mid elem and check if it is equal to the look up number
 if yes, this is one of the possible answer and we decrease the search range to left of the mid and store the current mid value let it be ans
If num > arr[mid], search range moves to right of mid
Else search range moves to right of mid
Finally return the  mid value we stored if no mid value stored return -1
To get the last index, we can follow the same steps
*/

// T.C: O(logN), S.C: O(1)
public class SearchForRange {
    private int findFirstIndex(int[] arr, int num) {
        int ans = -1;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == num) {
                ans = mid;
                end = mid - 1;
            } else if (arr[mid] > num) {
                end = mid - 1;
            } else {
                start = end + 1;
            }
        }
        return ans;
    }

    private int findLastIndex(int[] arr, int num) {
        int ans = -1;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == num) {
                ans = mid;
                end = mid + 1;
            } else if (arr[mid] > num) {
                end = mid - 1;
            } else {
                start = end + 1;
            }
        }
        return ans;
    }

    public int[] findRange(int[] arr, int num) {
        int firstIdx = findFirstIndex(arr, num);
        int lastIdx = findLastIndex(arr, num);
        return new int[] { firstIdx, lastIdx };
    }

}
