public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return new int[] {};
        if (n == 1)
            return new int[] { nums[0] };

        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int suffixProduct = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffixProduct = suffixProduct * nums[i + 1];
            result[i] = suffixProduct;
        }
        return result;
    }
}
