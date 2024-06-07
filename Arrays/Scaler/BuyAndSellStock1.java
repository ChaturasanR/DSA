/**
 * Best Time to Buy and Sell Stocks I
 * Problem Description
 * Say you have an array, A, for which the ith element is the price of a given
 * stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * Return the maximum possible profit.
 * 
 * Approach:
 * 
 * Brute Force
 * Iterate over the prices and see if you are planning to sell on the current
 * day, what is the profit
 * For that we need to check for the min price on previous days
 * 
 * T.C: O(N^2), S.C: O(1)
 * 
 * Optimized Approach:
 * Since we need to track min price till day, we can use a variable to store the
 * running min price
 * T.C: O(N), S.C: O(1)
 * 
 */
// T.C: O(N), S.C: O(1)
public class BuyAndSellStock1 {
    public int getMaxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int minPrice = prices[0];
        int maxProfitPossible = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfitPossible = Math.max(maxProfitPossible, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfitPossible;
    }

    public static void main(String[] args) {
        int[] prices = { 1, 4, 5, 2, 4 };
        BuyAndSellStock1 buyAndSellStock1 = new BuyAndSellStock1();
        System.out.println(buyAndSellStock1.getMaxProfit(prices));
    }
}
