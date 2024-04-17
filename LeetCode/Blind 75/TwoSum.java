import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSumUsingMap(int[] nums, int target) {
        Map<Integer, Integer> valueIdxMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (valueIdxMap.containsKey(diff))
                return new int[] { valueIdxMap.get(diff), i };
            valueIdxMap.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}