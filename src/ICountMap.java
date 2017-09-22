import java.util.Map;


public interface ICountMap<T> {
    //Map <T, Integer> hashMap = new HashMap <> ();
    //Set<Map.Entry<T,Integer>> entrySet = hashMap.entrySet ();

    // добавляет элемент в этот контейнер.
    void add(T o);

    //Возвращает количество добавлений данного элемента
    int getCount(T o);

    //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
    int remove(T o);

    //количество разных элементов
    int size();

    //Добавить все элементы из source в текущий контейнер, при совпадении ключей,     суммировать значения
    void addAll( ICountMap<T> source);


    //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
    Map toMap();

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    void toMap(Map<T, Integer> destination);

}

        /*
        пример использования
        ICountMap<Integer> map = new CountMapIml<>();

        map.add(10);
                map.add(10);
                map.add(5);
                map.add(6);
                map.add(5);
                map.add(10);

        int count = map.getCout(5); // 2
        int count = map.getCout(6); // 1
        int count = map.getCout(10); // 3
        */
