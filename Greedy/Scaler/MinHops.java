/**
 * Problem: There is a row of seats represented by string A. Assume that it
 * contains N seats adjacent to each other.
 * There is a group of people who are already seated in that row randomly. i.e.
 * some are sitting together & some are scattered.
 * An occupied seat is marked with a character 'x' and an unoccupied seat is
 * marked with a dot ('.')
 * Now your target is to make the whole group sit together i.e. next to each
 * other, without having any vacant seat between them in such a way that the
 * total number of hops or jumps to move them should be minimum.
 * In one jump a person can move to the adjacent seat (if available).
 * NOTE: 1. Return your answer modulo 10^7 + 3.
 * 
 * Solution:
 * From the observation, we can think of sliding window technique.
 * Find the total number of people (K) and store their positions in array
 * We need to apply sliding window technique with window size K and count the
 * hops by calculating difference between the position in the window and the
 * person position
 * Take the minimum for all those differences
 * T.C: O(N*K), S.C: O(K)
 * If we write the problem in mathematical equal it is equivalent to minimize
 * |ai- x|.
 * The given equation is minimum when x divides a’s into two equal groups. So x
 * is median
 * So to solve the problem
 * First median of the seats that people has currently occupied
 * Then with respect to median calculate the hops required first from left side
 * and then from right side
 * 
 */

// T.C: O(N), S.C: O(1)
public class MinHops {

    private static final int MOD = 10000003;

    public int getMinHops(String seats) {
        // find total seats occupied by people
        int totalPeople = getTotalPeople(seats);
        if (totalPeople == 0)
            return 0;

        // find median index
        int medianIdx = findMedian(seats, totalPeople);
        if (medianIdx == -1)
            return 0;

        // count the left hops
        int left = medianIdx - 1;
        long hops = 0l;
        int count = 0;
        while (left >= 0) {
            if (seats.charAt(left) == 'x') {
                hops += (medianIdx - 1 - left - count);
                hops %= MOD;
                count++;
            }
            left--;
        }

        // count the right hops
        int right = medianIdx + 1;
        count = 0;
        while (right < seats.length()) {
            if (seats.charAt(right) == 'x') {
                hops += (right - medianIdx - 1 - count);
                hops %= MOD;
                count++;
            }
            right++;
        }
        return (int) hops;
    }

    private int findMedian(String seats, int totalPeople) {
        int peopleCount = 0;
        for (int i = 0; i < seats.length(); i++) {
            char seat = seats.charAt(i);
            if (seat == 'x') {
                peopleCount++;
                if (peopleCount == (totalPeople + 1) / 2)
                    return i;
            }

        }
        return -1;
    }

    private int getTotalPeople(String seats) {
        int peopleCount = 0;
        for (char seat : seats.toCharArray()) {
            if (seat == 'x')
                peopleCount++;
        }
        return peopleCount;
    }

}