import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem: Given two arrays, A and B of size N. A[i] represents the time by
 * which you can buy the ith car without paying any money.
 * B[i] represents the profit you can earn by buying the ith car. It takes 1
 * minute to buy a car, so you can only buy the ith car when the current time <=
 * A[i] - 1.
 * Your task is to find the maximum profit one can earn by buying cars
 * considering that you can only buy one car at a time.
 * 
 * Solution:
 * If we got with greedy nature, our aim to maximize the profit so we choose the
 * large possible profit.
 * 
 * E.g: time: [1, 3, 5], profit: [5, 2, 7]
 * 
 * If we got with greedy technique, we pick 7 and 2 which is 9 (as picking 5 is
 * not possible after picking 7)
 * 
 * But answer = 5 + 2 + 7 =14 (t = 0 buy car of profit 5, t = 1 buy car of
 * profit 2, t= 2 buy car of profit 7)
 * 
 * So now the intuition is to buy the cars in order of their expiration time
 * from smallest to largest so sort the pair of time, profit in the ascending
 * order of time
 * 
 * E.g: times: [3, 1, 3, 3, 2] profit: [3, 5, 6, 9, 1]
 * 
 * Sorted with respective to time: [1, 2, 3, 3, 3], profits: [5, 1, 3, 6, 9]
 * At t = 0 buy car of profit = 5
 * At t = 1 buy car of profit = 1
 * At t = 2 buy car of profit = 3
 * At t = 3 you cannot buy anycar and if we see there is a car of profit 6 and 9
 * at t = 3 which is greater any of the previous profits, so maximize the profit
 * and to buy the car with profit 9 at t = 2 we reverse our decision back in
 * time and let go minimum profit car. So below are the steps for the problem
 * 
 * Store the time, profit as a pair and sort them with respect to time
 * Iterate over the those pairs and check if running time is less than current
 * car time.
 * If yes store it
 * Else
 * If curr profit > min(selected_profits): add current car profit and remove the
 * min car profit (reversing the decision)
 * Now iterate over the stored cars profit and accumulate them
 * 
 */

// T.C: O(NlogN), S.C: O(N)
public class MaximizeProfit {

    public int getMaxProfit(int[] time, int[] profits) {
        int size = time.length;
        Pair<Integer, Integer> pairs[] = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairs[i] = new Pair<Integer, Integer>(time[i], profits[i]);
        }

        Arrays.sort(pairs, (p1, p2) -> {
            if (p1.getFirst() == p2.getFirst())
                return p1.getSecond() - p2.getSecond();
            return p1.getFirst() - p2.getFirst();
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int t = 0;
        for (int i = 0; i < size; i++) {
            Pair<Integer, Integer> pair = pairs[i];
            if (t < pair.getFirst()) {
                pq.add(pair.getSecond());
                t++;
            } else {
                if (pair.getSecond() > pq.peek()) {
                    pq.poll();
                    pq.add(pair.getSecond());
                }
            }
        }

        int totalProfit = 0;
        while (!pq.isEmpty()) {
            totalProfit += pq.poll();
        }
        return totalProfit;
    }
}