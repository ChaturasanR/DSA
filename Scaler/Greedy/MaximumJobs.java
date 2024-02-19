
/**
 * Problem: There are N jobs to be done, but you can do only one job at a time.
Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.

Return the maximum number of jobs you can finish.

Solution:

Intuition is to be greedy, we have three ways to pick
Based on starting time, pick the events based on start time from earliest 
Based on time difference, pick the events based on least to longest time difference
Based on end time, pick the events based on end time from earliest 

E.g: [1, 10] [2, 5], [6,9], from 1 max jobs completed = 1 but ans = 2
E.g: [1, 7], [5, 8], [8, 16], from 2 max jobs completed = 1 but ans = 2

For both examples if we choose earliest end time ans = 2. So we follow below steps to achieve the max jobs completed
Store the start and end time as a pair and sort them in ascending order with respect to end time
We iterate over these sorted pairs and calculate the number of jobs completed

 */

import java.util.Arrays;

// T.C: O(NlogN), S.C: O(N)
public class MaximumJobs {
    public int getMaxJobs(int[] startTimes, int[] endTimes) {
        int size = startTimes.length;
        if (size == 0)
            return 0;

        Pair<Integer, Integer> intervals[] = new Pair[size];
        for (int i = 0; i < size; i++) {
            intervals[i] = new Pair<Integer, Integer>(startTimes[i], endTimes[i]);
        }

        Arrays.sort(intervals, (i1, i2) -> i1.getSecond() - i2.getSecond());

        int jobsCompleted = 1;
        int jobEndTime = intervals[0].getSecond();
        for (int i = 1; i < size; i++) {
            if (jobEndTime <= intervals[i].getFirst()) {
                jobsCompleted++;
                jobEndTime = intervals[i].getSecond();
            }
        }
        return jobsCompleted;
    }
}
