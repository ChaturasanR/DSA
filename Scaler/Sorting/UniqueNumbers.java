/*
 *  Problem: You are given an array A of N elements. You have to make all elements unique. To do so, in one step you can increase any number by one. Find the minimum number of steps.
 * Solution: To minimize the number of steps, we need to map to the nearest distinct number
 * For e.g: [2, 4, 5, 2, 4]
 * No of steps needed which is minimum is
 *  Sort the array 2, 2, 4, 4, 5
 * For idx = 0, steps = 0, val = 2
 * For idx = 1, steps = 1, val = 3
 * For idx = 2, steps = 0, val = 4
 * For idx = 3, steps = 1, val = 5
 * For idx = 4, steps = 1, val = 6
 * Total steps = 3 which is minimum (Greedy Algo)
 * 
 * First Sort the array
 * Then for index i count the steps to nearest distinct integer which is not present in previous i-1 indices
 * 
 * T.C: O(NlogN), S.C: O(N) - considering stack calls

 */

import java.util.Arrays;

public class UniqueNumbers {
    public int minStepsToMakeUnique(int[] numbers) {
        int steps = 0;
        Arrays.sort(numbers);
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] >= numbers[i]) {
                steps += (numbers[i - 1] - numbers[i] + 1);
                numbers[i] = numbers[i - 1] + 1;
            }
        }
        return steps;
    }
}
