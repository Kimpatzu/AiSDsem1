public interface IStack<T> {
    boolean isEmpty();
    boolean isFull();
    void push(T object) throws FullStackException;
    T pop() throws EmptyStackException;
    int size();
    T top() throws EmptyStackException;
}
class EmptyStackException extends Exception{
}
class FullStackException extends Exception{
}
