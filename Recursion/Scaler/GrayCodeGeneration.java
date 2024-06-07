import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Problem: Generate a sequence of ‘N bit’ numbers such that 2 consecutive bits differ by maximum of 1
    T.C: O(2^N), S.C: O(N)
*/
public class GrayCodeGeneration {

    public List<Integer> genetateGrayCodeNumbers(int N) {

        if (N == 1)
            return new ArrayList<>(Arrays.asList(0, 1));

        List<Integer> numbers = genetateGrayCodeNumbers(N - 1);

        int numbersSize = numbers.size();
        for (int i = 0; i < numbersSize; i++) {
            int num = numbers.get(i);
            numbers.add(num + (1 << (N - 1)));
        }
        return numbers;
    }
}
