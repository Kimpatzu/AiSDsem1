public interface IQueue<T> {
    boolean isEmpty();
    boolean isFull();
    T dequeue();
    void enqueue (T elem);
    int size();
    T first();
}
