import java.util.Collection;
import java.util.Iterator;

public class LinkedList <T> implements Iterable<T>{
    /*
        Необходимо написать свой LinkedList
        Методы:
        +add(E e)
        +add(int index, E element)
        +E get(int index)
        +E remove(int index)
        +Iterator<E> iterator()

        с использованием wildcards:
        +boolean addAll(Collection c)
        +boolean copy(Collection c)
    */

   private Node<T> first;
   private Node<T> last;
   public int size = 0;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E element) {
            this.item = element;
        }
    }
   public LinkedList(){}

    public void add ( T e ) {
        Node<T> node = new Node<> (e);
        node.prev = last;
        last = node;
        node.next = null;
        if (size == 0) {
            first = node;
        }
        else {
            node.prev.next = node;
        }
        ++size;
    }

    private Node <T> getNodeAtIndex (int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException ();
        }
        Node<T> x;
        if (index < (size >> 1)){
            x = first;
            for (int i=0; i < index; ++i) {
                x = x.next;
            }
        }
        else {
            x = last;
            for (int i = size - 1; i > index; --i) {
                x = x.prev;
            }
        }
        return x;
    }

    public void add ( int index, T e ) {

       if (index == size) add (e);
       else {
           Node <T> newNode = new Node <> (e);
           Node <T> x = getNodeAtIndex (index);
           if (x.prev == null){
               newNode.prev = null;
               newNode.next = first;
               first.prev = newNode;
               first = newNode;
           }
           else {
               newNode.prev = x.prev;
               newNode.next = x;
               x.prev.next = newNode;
               x.prev = newNode;
           }
           ++size;
       }
    }

    public T get ( int index ) {
       if (index >= size) throw new  IndexOutOfBoundsException ();
       return getNodeAtIndex (index).item;
    }

    public void remove ( int index ) {
        if (index >= size) throw new IndexOutOfBoundsException ();
        Node <T> x = getNodeAtIndex (index);
        Node <T> prev = x.prev;
        Node <T> next = x.next;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        --size;
    }

    @Override
    public Iterator <T> iterator () {
        return new Iterator<>() {

            private Node<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.item;
                current = current.next;
                return value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    boolean addAll ( Collection<? extends T> collection ) {
        if (collection.size () == 0) return false;
        Node<T> prv = last;
        Object[] objects = collection.toArray ();
        for (Object o : objects) {
            add ((T) o);
        }
        return true;
    }

    boolean copy ( Collection<? super T> collection ) {
       if (size == 0) return false;
       for(T item : this){
           collection.add (item);
        }
        return  true;
    }

    public void printList () {
        if (size != 0) {
            for (T elem : this) {
                System.out.print (elem + " ");
            }
            System.out.println ();
        }
    }

}
