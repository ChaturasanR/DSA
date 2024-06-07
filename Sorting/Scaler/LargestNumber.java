import java.util.Arrays;

/*
    Given an array A of non-negative integers, arrange them such that they form the largest number.
    Note: The result may be very large, so you need to return a string instead of an integer.

    T.C: O(NlogN), S.C: O(N)
*/

public class LargestNumber {

    public String formLargestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsStr, (str1, str2) -> (str1 + str2).compareTo(str2 + str1));
        StringBuilder result = new StringBuilder();
        for (String numStr : numsStr) {
            result.append(numStr);
        }

        return result.toString();
    }
}