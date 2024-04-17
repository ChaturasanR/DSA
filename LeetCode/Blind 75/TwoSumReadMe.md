# Two Sum

## [Description](https://leetcode.com/problems/two-sum/description/)

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.


## Approaches
- **Brute Force**
    - Generate all possible pair of numbers and check if their sum is equal to the target. If matched return those indices
    - T.C: O(N^2), S.C: O(1)

- **HashMap approach**
    - Iterate over the nums and store the numbers in the map with num as key and idx as value, while iterating check if target - current num is present in the map, if yes then we found the two numbers whose sum is equal to target
    - T.C: O(N), S.C: O(N)