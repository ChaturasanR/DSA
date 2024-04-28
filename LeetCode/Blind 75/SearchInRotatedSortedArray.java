public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[mid] < nums[n - 1]) {
                if (nums[mid] < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            } else {
                if (nums[mid] > target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
