import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[] { 11, 2, 5, -2, 5 };
        numbers = new int[] { 170, 45, 75, -90, -802, -3604, 24, 2, 66 };
        // int[] numbers = new int[] { 11, 4 };
        // BubbleSort bubbleSort = new BubbleSort();
        // bubbleSort.sort(numbers);
        // MergeSort mergeSort = new MergeSort();
        // mergeSort.sort(numbers, 0, numbers.length - 1);
        // InsertionSort insertionSort = new InsertionSort();
        // insertionSort.sort(numbers);
        // QuickSort quickSort = new QuickSort();
        // quickSort.sort(numbers, 0, numbers.length - 1);

        // CountSort countSort = new CountSort();
        // countSort.sort(numbers);
        RadixSort radixSort = new RadixSort();
        radixSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        // numbers = new int[] { 2, 2, 3, 3, 4 };
        // UniqueNumbers uniqueNumbers = new UniqueNumbers();
        // System.out.println(uniqueNumbers.minStepsToMakeUnique(numbers));

        // numbers = new int[] { 0, 2, 1, 4, 3, 5 };
        // MaxChunks maxChunks = new MaxChunks();
        // System.out.println(maxChunks.getMaxChunksPossible(numbers));
    }
}
