/**
 * 
 * Problem: The monetary system in DarkLand is really simple and systematic. The
 * locals-only use coins. The coins come in different values. The values used
 * are:
 * 1, 5, 25, 125, 625, 3125, 15625, ...
 * Formally, for each K >= 0 there are coins worth 5K.
 * Given an integer A denoting the cost of an item, find and return the smallest
 * number of coins necessary to pay exactly the cost of the item (assuming you
 * have a sufficient supply of coins of each of the types you will need).
 * 
 * Solution: To get the minimum no. of coins, we can always deduce the amount to
 * be paid with the maximum possible denomination until amount reaches 0
 * 
 */

// T.C: O(log5(amount)), S.C: O(1)
public class MinCoins {
    public int getMinCoins(int amount) {
        int maxDenominationPossible = fastPow(5, (int) (Math.log(amount) / Math.log(5)));
        int coinsCount = 0;
        while (amount > 0) {
            coinsCount += (amount / maxDenominationPossible);
            amount %= maxDenominationPossible;
            maxDenominationPossible /= 5;
        }
        return coinsCount;
    }

    private int fastPow(int a, int b) {
        if (b == 0)
            return 1;

        int powVal = fastPow(a, b / 2);
        if (b % 2 == 0)
            return powVal * powVal;
        return a * powVal * powVal;
    }
}
