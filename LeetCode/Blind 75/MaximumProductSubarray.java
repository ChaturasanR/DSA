public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int runningProduct = 1;
        int maxProduct = Integer.MIN_VALUE;

        for (int num : nums) {
            runningProduct *= num;
            maxProduct = Math.max(maxProduct, runningProduct);
            if (runningProduct == 0)
                runningProduct = 1;
        }

        runningProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            runningProduct *= num;
            maxProduct = Math.max(maxProduct, runningProduct);
            if (runningProduct == 0)
                runningProduct = 1;
        }
        return maxProduct;
    }
}