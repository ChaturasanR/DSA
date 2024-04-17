# Contains Duplicate

## [Description](https://leetcode.com/problems/contains-duplicate/description/)

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

## Approaches
- **Brute Force**
    - For every number check the same number is repeated in previous numbers
    - T.C: O(N^2), S.C: O(1)

- **Set approach**
    - Iterate over the nums and store the numbers in the hashset. If we come across the number that is already present in hashset return True else False
    - T.C: O(N), S.C: O(N)

- **Sorting**
    - Sort the nums
    - Iterate and check previous number if they are same return True else False
    - T.C: O(NlogN), S.C: O(1)