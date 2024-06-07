import java.util.List;

public class Main {

    public static void main(String[] args) {
        GrayCodeGeneration grayCodeGeneration = new GrayCodeGeneration();
        List<Integer> numbers = grayCodeGeneration.genetateGrayCodeNumbers(3);
        numbers.forEach((num) -> System.out.println(num));
    }

}
