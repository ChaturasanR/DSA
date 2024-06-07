/*
Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
Elements which are appearing twice are adjacent to each other.
NOTE: Users are expected to solve this in O(log(N)) time.

Solution: We can XOR to get the unique element but that would be O(N). To get in O(logN) we can use binary search

Initially, search range is whole array. Now
Find mid
Check if arr[mid] != arr[mid-1] and arr[mid] != arr[mid+1], return mid
arr[mid] == arr[mid-1], mid = mid-1
If  mid%2 == 0, that means unique number is in right space. As first of the two same numbers come at even index to the left of unique number and at odd index to the right of unique number
Else, search range is left to the mid
*/

// T.C: O(logN), S.C: O(1)
public class FindUniqueNumber {
    public int find(int[] arr) {
        int n = arr.length;

        // Edge cases
        if (n == 0)
            return -1;
        if (n == 1)
            return arr[0];
        if (arr[0] != arr[1])
            return arr[0];
        if (arr[n - 1] != arr[n - 2])
            return arr[n - 1];

        int start = 1, end = n - 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1])
                return arr[mid];

            // if mid is at second element, change to fist element
            if (arr[mid] == arr[mid - 1])
                mid = mid - 1;

            // if the first elem of two same elements is at even index that means unique
            // number is right of mid else that is left of mid
            if (mid % 2 == 0)
                // skipping the same elems
                start = mid + 2;
            else
                end = mid - 1;
        }
        return -1;
    }

}
