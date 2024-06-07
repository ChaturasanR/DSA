/*
    T.C: O(N^2) , S.C: O(1)
    Best T.C: O(N) when all elems are sorted in non-decreasing order
    Stable sort
    Inplace sort
*/

public class BubbleSort {

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            // Swapping consecutive elems and popping out the largest elem of remaining
            // elems to the last
            // if no swap happened => array is already sorted
            boolean swapped = false;
            for (int j = 1; j < n - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }

}
