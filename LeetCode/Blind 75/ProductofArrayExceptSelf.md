# Product of Array Except Self

## [Description](https://leetcode.com/problems/product-of-array-except-self/description/)

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

## Approaches
- **Brute Force**
    - For every number, iterate the calculate the product of remaining numbers
    - T.C: O(N^2), S.C: O(1)

- **Two pass approach**
    - If we observe for every number we are repeating the product - for ith - arr[0]*arr[1]*...arr[i-1], similarly for i-1 - arr[0] * arr[1] *...* arr[i-2]. The elements are repeated. Instead we can maintain running product from start and end. Multiple them
    - T.C: O(N + N) = O(N), S.C: O(1)