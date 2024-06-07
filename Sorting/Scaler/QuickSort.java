public class QuickSort {
    /*
     * 1. Select a pivot
     * 2. Assign it to its right place
     * 3. For point 2 we need to re-arrange the array such that arr[i] <= pivot
     * comes to left and remaining to right
     * 
     * Best Case/Avg time complexity: O(NlogN), S.C: O(N)
     * Inplace
     * Not stable
     */

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    private int rearrange(int[] arr, int pivotIdx, int s, int e) {
        swap(arr, s, pivotIdx);
        int l = s + 1, r = e;
        while (l <= r) {
            if (arr[l] <= arr[s])
                l++;
            else if (arr[r] > arr[s])
                r--;
            else {
                swap(arr, l, r);
                l++;
                r--;
            }
        }
        swap(arr, l - 1, s);
        return l - 1;
    }

    public void sort(int[] arr, int s, int e) {
        if (s >= e)
            return;

        int pivotIdx = (int) (Math.random() * (e - s) + s);
        int sortedIdx = rearrange(arr, pivotIdx, s, e);

        sort(arr, s, sortedIdx - 1);
        sort(arr, sortedIdx + 1, e);
    }
}
