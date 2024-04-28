# Find Minimum in Rotated Sorted Array

## [Description](https://leetcode.com/problems/search-in-rotated-sorted-array/description/)
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

## Approaches
- **Brute Force**
    - Linear search to find the target elem
    - T.C: O(N), S.C: O(1)

- **Binary Search algo**
    - Even though it is rotated still it is a sorted array so we can apply binary search
    - only change here is check if arr[mid] < arr[n-1] && arr[mid] < arr[target] start = mid + 1 if found return mid else -1

