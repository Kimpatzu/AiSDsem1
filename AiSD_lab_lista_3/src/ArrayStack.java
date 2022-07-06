public class ArrayStack<T> implements IStack<T>  {

    private T[] array;
    private int topIndex;
    private final int capacityDefault = 32;

    public ArrayStack (int capacity){
        array = (T[])(new Object[capacity]);
        topIndex=0;
    }

    public ArrayStack (){
        array = (T[])(new Object[capacityDefault]);
        topIndex=0;
    }

    @Override
    public boolean isEmpty() {
        return topIndex==0;
    }

    @Override
    public boolean isFull() {
        return topIndex==array.length;
    }

    @Override
    public void push(T object) throws FullStackException {
        if(isFull()){
            throw new FullStackException();
        }
        array[topIndex++]=object;
    }

    @Override
    public T pop() throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return array[--topIndex];
    }

    @Override
    public int size() {
        return topIndex;
    }

    @Override
    public T top() throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return array[topIndex-1];
    }

    public void reverseStack(){
        ArrayStack<T> pomArray = new ArrayStack<>(this.size());
        while(!isEmpty()){
            try{
                pomArray.push(pop());
            } catch (EmptyStackException e){
            } catch (FullStackException e){}
        }
        this.array = pomArray.array;
        this.topIndex = pomArray.topIndex;
    }
}
