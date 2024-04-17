public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }
}