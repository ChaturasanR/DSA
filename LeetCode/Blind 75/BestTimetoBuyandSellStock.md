# Best Time to Buy and Sell Stock

## [Description](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)

You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.


## Approaches
- **Brute Force**
    - For each day, look back all previous days and get the min price possible. If it is less than current day price calculate the profit. Calulcate the profit for all days and return the maximum out of them
    - T.C: O(N^2), S.C: O(1)

- **HashMap approach**
    - If we observe the brute force we are visit the days again and again. So we can maintain the running min value till current day and get profit by subtracting current day price - min price till date
    - T.C: O(N), S.C: O(N)