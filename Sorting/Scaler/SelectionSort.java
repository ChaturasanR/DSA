/*
    Sort the elements in non-decreasing order
    T.C: O(N^2) , S.C: O(1)
    Not a stable sort
    Inplace sort
*/

public class SelectionSort {

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minVal = arr[i], minValIdx = i;
            // ith smallest elem is selected each time
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minValIdx]) {
                    minVal = arr[j];
                    minValIdx = j;
                }
            }

            if (minValIdx != i)
                swap(arr, i, minValIdx);
        }
    }

}
