/*
 * Used to search for an element in sorted array
 */
public class BinarySearch {
    // T.C: O(logN), S.C: O(1)
    public int findIdxIteratively(int[] sortedArray, int num) {
        int start = 0, end = sortedArray.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (sortedArray[mid] == num)
                return mid;
            if (sortedArray[mid] < num)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    private int findIdxRecursiveUtil(int[] sortedArray, int num, int start, int end) {
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;
        if (sortedArray[mid] == num)
            return mid;
        if (sortedArray[mid] < num)
            return findIdxRecursiveUtil(sortedArray, num, start + 1, end);
        return findIdxRecursiveUtil(sortedArray, num, start, end - 1);
    }

    // T.C: O(logN), S.C: O(logN)
    public int findIdxRecursively(int[] sortedArray, int num) {
        return findIdxRecursiveUtil(sortedArray, num, 0, sortedArray.length - 1);
    }
}