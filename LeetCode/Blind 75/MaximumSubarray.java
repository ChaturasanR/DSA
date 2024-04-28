public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int runningSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int num: nums) {
            runningSum += num;
            maxSum = Math.max(runningSum, maxSum);
            if(runningSum < 0) runningSum = 0;
        }
        return maxSum;
    }
}
