import java.util.Arrays;

/*
Given an integer array, A of size N. You have to find all possible non-empty subsequences of the array of numbers and then,
for each subsequence, find the difference between the largest and smallest number in that subsequence. Then add up all the differences to get the number.

As the number may be large, output the number modulo 1e9 + 7 (1000000007).

sol: Contribution technique,
E.g: [3, 1, -4], subsequences are 
[3], max_val = 3, min_val = 3, diff = 0
[3, 1], max_val = 3, min_val = 1, diff = 2
[3, 1, -4] max_val = 3, min_val = -4, diff = 7
[1] max_val = 1, min_val = 1, diff = 0
[1, -4] max_val = 1, min_val = -4, diff = 5
[-4] max_val = -4, min_val = -4, diff = 0
[3, -4] max_val = 3, min_val = -4, diff = 7

Total diff = 21, this can be calculated using contribution technique
Check the number of sub sequences, each element is max of (let it be maxcountii)
Check the number of sub sequences, each element is min of (let it be mincounti)
Diff = (maxcounti-mincounti)*arr[i]

For above example, 
Elem = 3, maxcounti = 4, mincounti = 1
Elem = 1, maxcounti = 2, mincounti = 2
Elem = -4, maxcounti = 1, mincounti = 4

Total sum = (3)*3 + (0)*1+(-3)*4 = 21

To calculate the number of subsequences,
Sort the array
For ith elem to be max val, the number of subsequences are 2^(i-1) (2*2*2*..i-1). There are two possibilities for each elem before ith elem. And there won’t be any elem after ith elem
Similary for it to be min, 2^(n-i)

*/

// T.C: O(NlogN), S.c: O(1)
public class DifferenceSum {

    private final long MOD = 1_000_000_007;

    private long fastPow(int a, int b) {
        if (b == 0)
            return 1l;

        long result = fastPow(a, b / 2);
        if (b % 2 == 0)
            return (result * result) % MOD;
        return (result * result * a) % MOD;
    }

    public int findSumOfDifferences(int[] numbers) {
        Arrays.sort(numbers);
        int numbersLength = numbers.length;

        // apply contribution technique
        long diff = 0l;
        for (int i = 0; i < numbers.length; i++) {
            long subsequenceCountWithMaxValuei = fastPow(2, i);
            long subsequenceCountWithMinValuei = fastPow(2, numbersLength - 1 - i);
            diff += ((subsequenceCountWithMaxValuei - subsequenceCountWithMinValuei) * 1l * numbers[i]) % MOD;
            diff = (diff + MOD) % MOD;
        }

        return (int) (diff);
    }

}
