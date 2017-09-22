import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestCountMapIml {
    public static void main ( String[] args ) {
        ICountMap<Integer> map = new CountMapIml<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        System.out.println (map.getCount(5)); // 2
        System.out.println (map.getCount(6)); // 1
        System.out.println (map.getCount(10)); // 3


        ICountMap<Integer> map2 = new CountMapIml <> ();

        map2.add (11);
        map2.add (5);
        map2.add (6);
        map2.add (10);
        map2.add (7);
        map2.add (2);
        map2.add (5);

        map.addAll (map2);

        System.out.println (map.getCount(5)); // 4
        System.out.println (map.getCount(6)); // 2
        System.out.println (map.getCount(10)); // 4
        System.out.println (map.remove (2));

        Map <Integer, Integer> tM = new HashMap <> ();
        Map <Integer, Integer> tM1 = map.toMap ();
        map.toMap (tM);

        System.out.println (tM1.toString ());

    }
}
