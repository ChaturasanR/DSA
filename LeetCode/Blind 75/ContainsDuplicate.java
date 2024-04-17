import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    // T.C: O(N), S.C: O(N)
    public boolean containsDuplicateWithHashSet(int[] nums) {
        Set<Integer> distinctNums = new HashSet<>();
        for (int num : nums) {
            if (distinctNums.contains(num))
                return true;
            distinctNums.add(num);
        }
        return false;
    }

    // T.C: O(NlogN), S.C: O(1)
    public boolean containsDuplicateUsingSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i])
                return true;
        }
        return false;
    }
}
