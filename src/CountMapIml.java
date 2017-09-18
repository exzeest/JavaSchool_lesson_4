import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiFunction;

public class CountMapIml <T> implements ICountMap<T>{
    private Map <T, Integer> hashMap = new HashMap <> ();

    @Override
    public void add ( T o ) {
        if (!hashMap.containsKey (o)) hashMap.put (o, 0);
        hashMap.replace (o, hashMap.get (o) + 1);
    }

    @Override
    public int getCount ( T o ) {
        return hashMap.get (o);
    }

    @Override
    public int remove ( T o ) {
        int numberOfAdditions = hashMap.get (o);
        hashMap.remove (o);
        return numberOfAdditions;
    }

    @Override
    public int size () {
        return hashMap.size ();
    }

    @Override
    public void addAll ( ICountMap<T> source ) {
        try {
            for (Map.Entry <T, Integer> entry : ((Map <T, Integer>) source.toMap ()).entrySet ()) {
                if (!hashMap.containsKey (entry.getKey ())) hashMap.put (entry.getKey (), entry.getValue ());
                else {
                    hashMap.replace (entry.getKey (), entry.getValue () + hashMap.get (entry.getKey ()));
                }
            }
        }
        catch (ClassCastException cce) {
            cce.printStackTrace ();
        }
    }

    @Override
    public Map toMap () {
        return new HashMap<> (hashMap);
    }

    @Override
    public void toMap ( Map destination ) {
        destination.clear ();
        for (Map.Entry entry : hashMap.entrySet ())
            destination.put (entry.getKey (), entry.getValue ());
    }

}

