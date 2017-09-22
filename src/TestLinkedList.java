import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestLinkedList {
    public static void main ( String[] args ) {
        LinkedList <Integer> list = new LinkedList <> ();
        for (int i = 2; i < 5; ++i) {
            list.add (i);
        }
        list.add (0,1);
        list.add (list.size, 5);
        list.add (2, 22);
        /*for (Iterator<Integer> iterator = list.iterator (); iterator.hasNext ();) {
            System.out.println (iterator.next ());
        }*/
        /*System.out.println (list.get(0));
        System.out.println (list.get(2));
        System.out.println (list.get(-2)); // Exception.
        System.out.println (list.get(list.size)); // Exception. */
        list.remove (2);
        //list.printList ();
        list.remove (0);
        //list.remove (list.size); // Exception.
        //list.printList ();
        /*for (int i = list.size-1; i >= 0; --i) {
            list.remove (i);
        }
        //list.remove (0); Exception after previous cycle.
        list.printList ();*/

        Collection <Integer> c1 = new ArrayList <> ();
        list.addAll (c1);
        list.printList ();
        Collection <Integer> c2 = new ArrayList <> ();
        c2.add (100);
        c2.add (101);
        list.addAll (c2);
        list.printList ();
        list.copy (c1);
        System.out.println (c1.toString ());
        list.copy (c2);
        System.out.println (c2.toString ());
        LinkedList <Integer> emptyList = new LinkedList <> ();
        emptyList.copy (c2);
        System.out.println (c2.toString ());
    }
}
