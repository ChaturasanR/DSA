public class Main {
    public static void main(String[] args) {
        int[] sortedArray = new int[] { 1, 2, 3, 4, 5 };
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.findIdxIteratively(sortedArray, 2));
        System.out.println(binarySearch.findIdxIteratively(sortedArray, 6));

        System.out.println(binarySearch.findIdxRecursively(sortedArray, 2));
        System.out.println(binarySearch.findIdxRecursively(sortedArray, 6));
    }
}
