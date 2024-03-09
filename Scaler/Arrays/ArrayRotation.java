
/**
 * Rotate Array
 * Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right. Approach:
 * There are two ways
 * Swapping the next idx value with currIdx value until all indices are swapped
 * Reversing the range of arrays
 * E.g: 1, 2, 3, 4 => (2 times rotated) 3, 4, 2, 1
 * Above thing can be obtained by reverse 1, 2, 3, 4 => 4, 3, 2, 1 (reverse(0, N-1))
 * Now reverse first two elements 3, 4, 2, 1 (reverse(0, K-1))
 * Finally reverse the remaining indices 3,4,1,2 (revese(K, N-1))
 *
*/
// Both approaches take O(N), O(1) but reversing the arr is easier to understand
import java.util.Arrays;

public class ArrayRotation {
    public void rotateArrayByReverse(int[] arr, int k) {
        int n = arr.length;
        k %= n;

        if (k == 0)
            return;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    public void rotateArrayByIdx(int[] arr, int k) {
        int n = arr.length;
        k %= n;

        if (k == 0)
            return;

        int currIdx = 0;
        int swapCounts = 0;
        int startIdx = 0;
        int currElem = arr[currIdx];
        while (swapCounts < n) {
            int rotatedArrayIdx = (currIdx + k) % n;
            int elemToBeSwapped = arr[rotatedArrayIdx];
            arr[rotatedArrayIdx] = currElem;

            currIdx = rotatedArrayIdx;
            currElem = elemToBeSwapped;
            swapCounts++;

            if (currIdx == startIdx) {
                startIdx++;
                currIdx = startIdx;
                currElem = arr[currIdx];
            }
        }

    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        ArrayRotation arrayRotation = new ArrayRotation();
        // arrayRotation.rotateArrayByReverse(arr, 3);
        arrayRotation.rotateArrayByIdx(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}
