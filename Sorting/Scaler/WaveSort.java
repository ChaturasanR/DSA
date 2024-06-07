import java.util.Arrays;

/*

    Problem:
    Given an array of integers A, sort the array into a wave-like array and return it.
    In other words, arrange the elements into a sequence such that

    a1 >= a2 <= a3 >= a4 <= a5.....
    Solution:
    1, 2, 3, 4, 5 => 2, 1, 4, 3, 5

    1. Sort the array
    2. Swap adjacent two elems

    T.C: O(NlogN), S.C: O(1)
*/
public class WaveSort {

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public int[] sort(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i += 2) {
            swap(arr, i, i - 1);
        }
        return arr;
    }

}
