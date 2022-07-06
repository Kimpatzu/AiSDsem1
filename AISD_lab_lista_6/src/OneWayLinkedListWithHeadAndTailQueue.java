public class OneWayLinkedListWithHeadAndTailQueue<E> implements IQueue<E>{
    private class Element{
        private E value;
        private Element next;

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
        public Element getNext(){
            return next;
        }
        public void setNext(Element next){
            this.next = next;
        }
        Element (E data){
            this.value = data;
        }
    }

    private Element head=null;
    private Element tail;

    public OneWayLinkedListWithHeadAndTailQueue(){
        tail = new Element(null);
        tail.setNext(null);
        head = new Element(null);
        head.setNext(tail);
    }

    public boolean isEmpty(){
        return head.getNext()==tail;}

    public void clear() {
        head.setNext(tail);}


    public void enqueue(E e){
        Element newElem = new Element(e);
        newElem.setNext(tail);
        if (head.getNext()==tail){
            head.setNext(newElem);
        } else {
            Element _tail = head.getNext();
            while (_tail.getNext() != tail) {
                _tail = _tail.getNext();
            }
            newElem.setNext(tail);
            _tail.setNext(newElem);
        }
    }

    public E dequeue() {
        if (head.getNext() == tail)
            return null;
        Element dequeueElem = head.getNext();
        head.setNext(dequeueElem.getNext());
        return dequeueElem.getValue();
    }

    public E first() {
        if (head.getNext() == tail)
            return null;
        Element firstElem = head.getNext();
        return firstElem.getValue();
    }

    public boolean isFull(){
        return false;
    }

    public int size(){
        if(head.getNext()==tail){
            return 0;
        }
        int i=0;
        Element _tail = head;
        while(_tail.getNext()!=tail){
            _tail = _tail.getNext();
            i++;
        }
        return i;
    }
}
