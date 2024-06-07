/*
 * Another version of sorting. This uses range for sorting. It maintains an different array to store the count of each element in the range.
 * For example we have an array of length N 0<= N <= 10^9. And the numbers of the array are in range (K) 0 <= K <= 10^4. So we create array of 
 * length K to store the frequency of each number in array
 * 
 * T.C: O(N+K), S.C: O(K), N - length of array, K - numbers range
 */
public class CountSort {

    private int findMinValue(int[] arr) {
        int minValue = Integer.MAX_VALUE;
        for (int num : arr) {
            minValue = Math.min(num, minValue);
        }
        return minValue;
    }

    private int findMaxValue(int[] arr) {
        int maxValue = Integer.MIN_VALUE;
        for (int num : arr) {
            maxValue = Math.max(num, maxValue);
        }
        return maxValue;
    }

    public void sort(int[] arr) {
        int minValue = findMinValue(arr);
        int maxValue = findMaxValue(arr);
        int range = maxValue - minValue + 1;

        int[] freq = new int[range];
        for (int num : arr) {
            freq[num - minValue]++;
        }

        int idx = 0;
        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < freq[i]; j++) {
                arr[idx++] = i + minValue;
            }
        }
    }

}
