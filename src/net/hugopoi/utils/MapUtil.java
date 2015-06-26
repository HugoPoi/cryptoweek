package net.hugopoi.utils;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * Created by hugo on 23/06/15.
 */
public class MapUtil {

        public static <K, V extends Comparable<? super V>> Map<K, V>
        sortByValue( Map<K, V> map , boolean reverse)
        {
            List<Map.Entry<K, V>> list =
                    new LinkedList<Map.Entry<K, V>>( map.entrySet() );
            Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
                public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                    if(reverse){
                        return (o2.getValue()).compareTo(o1.getValue());
                    }else{
                        return (o1.getValue()).compareTo(o2.getValue());
                    }
                }
            });

            Map<K, V> result = new LinkedHashMap<K, V>();
            for (Map.Entry<K, V> entry : list)
            {
                result.put( entry.getKey(), entry.getValue() );
            }
            return result;
        }

    public static <K, V> void printMap(Map<K, V> frequencies){

        frequencies.forEach(new BiConsumer<K, V>() {
            @Override
            public void accept(K character, V integer) {
                System.out.println(character+" : "+integer);
            }
        });

    }

}
