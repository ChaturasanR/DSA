public class Pair<U, V> {
    private final U first;
    private final V second;

    public Pair(U first, V val) {
        this.first = first;
        this.second = val;
    }

    public U getFirst() {
        return this.first;
    }

    public V getSecond() {
        return this.second;
    }

}