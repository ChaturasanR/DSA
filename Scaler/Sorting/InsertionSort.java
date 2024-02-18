public class InsertionSort {

    // T.C: O(N^2), S.C: O(1)
    // Stable, inplace sort
    public void sort(int[] arr) {
        int n = arr.length;
        // while iterating the array, keeping the array sorted till ith at each
        // iteration
        for (int i = 1; i < n; i++) {
            int currVal = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > currVal) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = currVal;
        }
    }

}
