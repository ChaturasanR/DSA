/**
 * Special Subsequences "AG"
 * You have given a string A having Uppercase English letters.
 * You have to find how many times subsequence "AG" is there in the given
 * string.
 * NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
 * 
 * Approach:
 * Brute Force: For each occurrence of G check the number of A’s to the left and
 * add to the result
 * 
 * T.C: O(N^2), S.C: O(1)
 * 
 * Optimized Way: Instead of checking for the count every time. We can store the
 * number of A’s till current Index and get the count in O(1) for every G
 * 
 * T.C: O(N), S.C: O(1)
 * 
 */

// Running Count - Application of prefixSum
// T.C: O(N), S.C: O(1)
public class SpecialSubSequence {
    private final long MOD = 1_000_000_007l;

    public int findSpecialSubSequenceCount(String str) {
        long acount = 0l;
        long result = 0l;

        for (char ch : str.toCharArray()) {
            if (ch == 'A')
                acount++;
            else if (ch == 'G')
                result += acount;
        }
        return (int) (result % MOD);
    }

    public static void main(String[] args) {
        SpecialSubSequence specialSubSequence = new SpecialSubSequence();
        System.out.println(specialSubSequence.findSpecialSubSequenceCount("ABCGAG"));
    }
}
