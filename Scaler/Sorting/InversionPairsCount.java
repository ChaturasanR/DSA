/*
    Problem:Given an array A, find the count where i < j and A[i] > A[j] (inversion count)
    Solution:
    We can get this count while applying merge sort. As merge sort is divide and conquer, it gets divided into individual elems 
    and then combines to get the sort. Also merge sort is inplace sort so relative order does not get changed. So we can get this count while merge

    During merge left[], right[]
    if left[p1] > right[p2]: count += left.len - p1; [4, 5] [1, 2]  4 > 1 => 5 > 1 so count = len_of_left - num_of_elems from current idx = 2 - 0 = 2
    Similary for elem 2 in right array inversion count = 2 so total count = 4. We can apply this rule to get the count because left and right are sorted arrays

    T.C: O(NlogN), S.C: O(N)
*/

public class InversionPairsCount {

    private int merge(int[] arr, int s, int m, int e) {
        int len1 = m - s + 1;
        int len2 = e - m;
        int[] left = new int[m - s + 1];
        int[] right = new int[e - m];

        for (int i = s; i <= m; i++) {
            left[i - s] = arr[i];
        }

        for (int i = m + 1; i <= e; i++) {
            right[i - m - 1] = arr[i];
        }

        int p1 = 0, p2 = 0, p3 = s;

        int invCount = 0;
        while (p1 < len1 && p2 < len2) {
            if (left[p1] <= right[p2]) {
                arr[p3++] = left[p1++];
            } else {
                arr[p3++] = right[p2++];
                // left[p1] > right[p2] => all elems that are right
                // to p1 in left subarray are greater than right[p2]
                invCount += (len1 - p1);
            }
        }

        while (p1 < len1) {
            arr[p3++] = left[p1++];
        }

        while (p2 < len2) {
            arr[p3++] = right[p2++];
        }
        return invCount;

    }

    private int mergeSort(int[] arr, int s, int e) {
        if (s == e)
            return 0;

        int invCount = 0;
        int mid = s + (e - s) / 2;
        invCount += mergeSort(arr, s, mid);
        invCount += mergeSort(arr, mid + 1, e);
        invCount += merge(arr, s, mid, e);
        return invCount;
    }

    public int getCount(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

}
