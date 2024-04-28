# Maximum Subarray

## [Description](https://leetcode.com/problems/maximum-subarray/description/)

Given an integer array nums, find the 
subarray with the largest sum, and return its sum.

## Approaches
- **Brute Force**
    - Generate all subarrays, calculate sum for each array and return the maximum sum
    - T.C: O(N^3), S.C: O(1)
    - Can be optimized to O(N^2), S.C: O(1) by maintaining running sum

- **Kadane's algo**
    - Observations
        - If all are positive numbers, all numbers are included for maximum sum
        - The problem is when there are negative numbers, when we add up the negative numbers and the subarray sum < 0 => the current sum is handicap for future sums, so we reset the sum and start calculating the max subarray sum
        - Approach is basically, maintain running sum, at each index compare the running sum with max sum till then and update it accordingly. When ever running sum becomes zero reset it to 0
    - T.C: O(N) = O(N), S.C: O(1)