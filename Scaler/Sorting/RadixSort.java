/*
T.C: O(27N) = O(N), S.C: O(N)
*/

public class RadixSort {

    private int findMaxAbsoluteValue(int[] numbers) {
        int maxValue = Integer.MIN_VALUE;
        for (int num : numbers) {
            maxValue = Math.max(maxValue, Math.abs(num));
        }
        return maxValue;
    }

    private int findDigits(int number) {
        int digitsCount = 0;
        while (number > 0) {
            number /= 10;
            digitsCount++;
        }
        return digitsCount;
    }

    private long fastPow(int a, int b) {
        if (b == 0)
            return 1;

        long val = fastPow(a, b / 2);

        if (b % 2 == 0) {
            return val * val;
        }
        return val * val * a;

    }

    private void countSort(int[] numbers, int expr) {
        int numbersLength = numbers.length;
        int[] counts = new int[20];
        int[] sortedArray = new int[numbersLength];

        // Sort the freq of each digits in counts array
        for (int num : numbers) {
            int digit = (num / expr) % 10;
            int countArrayIdx = digit < 0 ? digit + 9 : digit + 10;
            counts[countArrayIdx]++;
        }

        // This gives us the range of indices in original array that numbers with digit
        // i takes. For examples if counts = [1, 1, 0, 2, 0, 0, ..] => [1, 2, 2, 4,
        // 4,..]
        // ...] so num with -9 digit takes 0th idx in original, similarly -6 digit
        // numbers take 2,3 indices
        for (int i = 1; i < 20; i++)
            counts[i] += counts[i - 1];

        // iterating for end for stable sort
        for (int i = numbersLength - 1; i >= 0; i--) {
            int num = numbers[i];
            int digit = (num / expr) % 10;
            int countArrayIdx = digit < 0 ? digit + 9 : digit + 10;
            int sortedArrayIdx = --counts[countArrayIdx];
            sortedArray[sortedArrayIdx] = num;
        }

        System.arraycopy(sortedArray, 0, numbers, 0, numbersLength);

    }

    public void sort(int[] numbers) {
        // Find the absolute max value for obtaining the maximum no of digits for which
        // we need to sort for
        int maxAbsoluteValue = findMaxAbsoluteValue(numbers);
        // int maxNoOfDigits = findDigits(maxValue);

        // Get the max digits
        int maxNoOfDigits = (int) Math.log10(maxAbsoluteValue) + 1;
        for (int digit = 0; digit < maxNoOfDigits; digit++) {
            // For each digit i get the 10^i so that we left shift the digit in the number
            // and then get the digit
            // e.g: 1234 to get digit 2 we need to do (1234/10^2)%10 => 1234/10^2 =>
            // (12)%10 = 2
            countSort(numbers, (int) fastPow(10, digit));
        }
    }
}