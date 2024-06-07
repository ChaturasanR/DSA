/*
 *  Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)], if we split the array into some number of "chunks" (partitions),
 *  and individually sort each chunk. After concatenating them in order of splitting, the result equals the sorted array.
 *  What is the most number of chunks we could have made?
 * 
 * The intuition is that we can consider a separate chunk if max(arr[0], arr[1]..arr[i]) == i.
 * So we need to track max value while iterating the array and check how many max(arr[0], .. ar[i]) == i
 * 
 * T.C: O(N), S.C: O(1)
 */

public class MaxChunks {

    public int getMaxChunksPossible(int[] numbers) {
        int maxValue = 0;
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            maxValue = Math.max(maxValue, numbers[i]);
            if (maxValue == i)
                count++;
        }
        return count;
    }

}
