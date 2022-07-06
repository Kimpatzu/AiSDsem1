public class OneWayLinkedListWithHead<E>  {
    private class Element{
        private E value;
        private Element next;

        Element(E data){
            this.value = data;
        }

        public E getValue(){
            return value;
        }
        public void setValue(E value){
            this.value = value;
        }
        public Element getNext(){
            return next;
        }
        public void setNext(Element next){
            this.next = next;
        }
    }

    Element head = null;

    public OneWayLinkedListWithHead(){}

    public boolean isEmpty(){
        return head==null;
    }

    public void clear(){
        head=null;
    }

    public int size(){
        int pos=0;
        Element actElement = head;
        while(actElement!=null){
            pos++;
            actElement = actElement.getNext();
        }
        return  pos;
    }

    private Element getElement(int index){
        Element actElement =  head;
        while(index>0 && actElement!=null){
            index--;
            actElement = actElement.getNext();
        }
        return  actElement;
    }

    public boolean add(E e){
        Element anotherElement = new Element(e);
        if (head==null){
            head = anotherElement;
            return true;
        }
        Element tail = head;
        while(tail.getNext()!=null){
            tail = tail.getNext();
        }
        tail.setNext(anotherElement);
        return true;
    }

    public boolean add(int index, E data){
        if (index<0){
            return false;
        }
        Element anotherElement = new Element(data);
        if (index==0){
            anotherElement.setNext(head);
            head=anotherElement;
            return true;
        }
        Element actElement = getElement(index-1);
        if (actElement==null){
            return false;
        }
        anotherElement.setNext(actElement.getNext());
        actElement.setNext(anotherElement);
        return true;
    }

    public int indexOf(E data){
        int pos=0;
        Element actElement = head;
        while (actElement!=null){
            if (actElement.getValue().equals(data)){
                return pos;
            }
            pos++;
            actElement = actElement.getNext();
        }
        return -1;
    }

    public boolean contains(E data){
        return indexOf(data)>=0;
    }

    public E get(int index){
        Element actElement = getElement(index);
        return  actElement==null?null:actElement.getValue();
    }

    public E set(int index, E data){
        Element actElement=getElement(index);
        if(actElement==null){
            return null;
        }
        E elementData = actElement.getValue();
        actElement.setValue(data);
        return elementData;
    }

    public E remove(int index){
        if (head==null){
            return null;
        }
        if (index==0){
            E retValue = head.getValue();
            head = head.getNext();
            return retValue;
        }
        Element actElement = getElement(index-1);
        if(actElement==null || actElement.getNext()==null){
            return null;
        }
        E retValue = actElement.getNext().getValue();
        actElement.setNext(actElement.getNext().getNext());
        return retValue;
    }

    public boolean remove(E value){
        if(head==null)
            return false;
        if(head.getValue().equals(value)){
            head=head.getNext();
            return true;}
        Element actElement=head;
        while(actElement.getNext()!=null && !actElement.getNext().getValue().equals(value))
            actElement=actElement.getNext();
        if(actElement.getNext()==null)
            return false;
        actElement.setNext(actElement.getNext().getNext());
        return true;
    }
}
