public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        int ans = nums[0];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];

            if (nums[mid] < nums[nums.length - 1])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return ans;
    }
}
