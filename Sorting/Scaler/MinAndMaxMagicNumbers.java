import java.util.Arrays;

/*
    Given an array of integers A of size N, N is even. Now divide the array into two subsets
    1. Length of both subsets is equal
    2. Each element of A exists in only one of the subset

    Now the problem is to find the min and max magic number
    Magic number = sum of absolute difference of corresponding elements of subset.

    Sol:
    Since we need to get the min and max magic numbers. For max magic number we can get it if we have the sum like this 
            abs(1st_max_elem - 1st_min_elem) + abs(2nd_max_elem - 2nd_min_elem) + ….

    For min
	        abs(1st_max_elem - 2nd_max_elem) + abs(3st_max_elem - 4th_max_elem) + …..

    For this we can follow below steps
    1. Sort the array
    2. For min have two pointers p1 = 0, p2 = 1 and iterate over the array until p2 reaches the last elem
    3. For max have two pointers p1=0, p2 = arr.length - 1 and iterate over until p1 < p2

    T.C: O(NlogN), S.C: O(1)
*/
public class MinAndMaxMagicNumbers {

    private final long MOD = 1_000_000_007;

    private int findMinMagicNumber(int[] arr) {
        int p1 = 0, p2 = 1;
        long sum = 0;
        while (p2 < arr.length) {
            sum += Math.abs(arr[p2] - arr[p1]);
            p1 += 2;
            p2 += 2;
        }
        return (int) (sum % MOD);
    }

    private int findMaxMagicNumber(int[] arr) {
        int p1 = 0, p2 = arr.length - 1;
        long sum = 0;
        while (p1 < p2) {
            sum += Math.abs(arr[p2] - arr[p1]);
            p1++;
            p2--;
        }
        return (int) (sum % MOD);
    }

    public int[] solve(int[] arr) {
        int[] result = new int[2];
        Arrays.sort(arr);
        result[0] = findMaxMagicNumber(arr);
        result[1] = findMinMagicNumber(arr);
        return result;
    }

}
