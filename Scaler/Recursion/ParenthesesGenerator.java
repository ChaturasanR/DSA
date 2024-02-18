import java.util.ArrayList;
import java.util.List;

/*
    Problem: Given an integer N, write a function to generate all combinations of well-formed parentheses of length 2*N.
    Approach: Backtracking

    Observations: 
    1. While string generation number of  closed parentheses < number of open parentheses
    2. Length of string = 2*N, we need to print when we reach 2*N length;
    3. We add the open parentheses if number of open parentheses are less than N
    4. closed parentheses are added if number of closed are less than number of open parentheses
    T.C: O(2^N) S.C: O(N)
*/

public class ParenthesesGenerator {
    private void gpHelper(int n, List<String> result, int open, int close, StringBuilder strBuilder) {

        // Assumption: Generate all combinations of parathensis
        if (strBuilder.length() == 2 * n) {
            result.add(strBuilder.toString());
            return;
        }

        if (open < n) {
            strBuilder.append('(');
            gpHelper(n, result, open + 1, close, strBuilder);
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }

        if (close < open) {
            strBuilder.append(')');
            gpHelper(n, result, open, close + 1, strBuilder);
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }
    }

    public List<String> generateParentheses(int A) {
        List<String> result = new ArrayList<>();
        StringBuilder strBuilder = new StringBuilder();
        gpHelper(A, result, 0, 0, strBuilder);
        return result;
    }
}
