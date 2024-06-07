
/**
 * Problem: N Mice and N holes are placed in a straight line. Each hole can accommodate only one mouse.
The positions of Mice are denoted by array A, and the position of holes is denoted by array B.
A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x − 1. Any of these moves consume 1 minute.
Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.

Solution:
Since there are same number of mices and holes, each mice will have one hole. So to minimize the time to get all the mices to their holes, we need to find the nearest hole for each mice. To minimize for all mices, we can sort the positions of both mices and holes, and assign mice at each index to its respective hole. Assigning mice to its nearest hole might not give correct results
Sort the arrays mices position and holes position
Assign each mice to its respective hole at the same index

 */

import java.util.Arrays;

// T.C: O(NlogN), S.C: O(1)
public class AssignMicesToHoles {
    public int minTime(int[] micesPosition, int[] holesPosition) {
        Arrays.sort(micesPosition);
        Arrays.sort(holesPosition);

        int minTime = 0;
        for (int i = 0; i < micesPosition.length; i++) {
            minTime = Math.max(minTime, Math.abs(micesPosition[i] - holesPosition[i]));
        }
        return minTime;
    }
}
