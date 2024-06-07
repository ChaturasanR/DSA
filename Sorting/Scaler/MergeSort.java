/*
    Merge sort uses divide and conquer technique
        1. Divides the main problem into subproblems
        2. Once smallest valid subproblem reached, merging starts happening

    T(N) = 2T(N/2) + N
    T(N/2) = 2T(N/4) + N/2
    T(N/4) = 2T(N/8) + N/4;

    T(N) = 8T(N/8) + 3N
    T(N) = 2^kT(N/2^k) + kN
    T(N) = N + Nlog2N

    T.C: O(NlogN), S.C: O(N)

    Stable sort
    Non inplace sort
*/

public class MergeSort {
    public void sort(int[] arr, int s, int e) {
        if (s == e)
            return;
        int mid = s + (e - s) / 2;
        sort(arr, s, mid);
        sort(arr, mid + 1, e);
        merge(arr, s, mid, e);
    }

    public void merge(int[] arr, int s, int m, int e) {
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
        while (p1 < len1 && p2 < len2) {
            if (left[p1] <= right[p2]) {
                arr[p3++] = left[p1++];
            } else {
                arr[p3++] = right[p2++];
            }
        }

        while (p1 < len1) {
            arr[p3++] = left[p1++];
        }

        while (p2 < len2) {
            arr[p3++] = right[p2++];
        }

    }
}
