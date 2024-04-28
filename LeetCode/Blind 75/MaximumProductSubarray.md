# Maximum Product Subarray

## [Description](https://leetcode.com/problems/maximum-product-subarray/description/)
Given an integer array nums, find a 
subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

## Approaches
- **Brute Force**
    - Generate all subarrays, calculate product for each array and return the maximum product
    - T.C: O(N^3), S.C: O(1)
    - Can be optimized to O(N^2), S.C: O(1) by maintaining running product

- **Kadane's algo**
    - Observations
        - If all are positive numbers, all numbers are included for maximum product
        - The problem is when there is zero, when we take the product it becomes 0 => the current product is handicap for future products, so we reset the product to 1 and start calculating the max subarray product
        - Another problem is if we consider only one side of iteration we might be missing certain corner cases e.g: 1 2 3 0 -5 4 6, in this case if we iterate from 0th we will get ans as 6 because after -5 the product becomes negative. So we need to consider from other end as well.
        - Approach is basically, maintain running product, at each index compare the running product with max product till then and update it accordingly. When ever running product becomes zero reset it to 1.
        - Repeat above step from back to front
    - T.C: O(N + N) = O(N), S.C: O(1)