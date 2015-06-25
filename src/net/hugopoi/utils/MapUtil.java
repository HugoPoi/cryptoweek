package net.hugopoi.utils;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * Created by hugo on 23/06/15.
 */
public class MapUtil {

        public static <K, V extends Comparable<? super V>> Map<K, V>
        sortByValue( Map<K, V> map )
        {
            List<Map.Entry<K, V>> list =
                    new LinkedList<Map.Entry<K, V>>( map.entrySet() );
            Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
                public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                    return (o2.getValue()).compareTo(o1.getValue());
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

    public static Map<Character, Float> getFrequencies(String message){
        Map<Character, Integer> frequencies = new HashMap<>();

        for (int i = 0 ; i < message.length() ; i++){
            Integer c = frequencies.get(message.charAt(i));
            if(c == null){
                frequencies.put(message.charAt(i), 1);
            }else{
                frequencies.put(message.charAt(i), c+1);
            }
        }

        Map<Character, Float> frequenciesPercent = new HashMap<>();


        frequencies.forEach(new BiConsumer<Character, Integer>() {
            @Override
            public void accept(Character character, Integer integer) {
                frequenciesPercent.put(character, (new Float(integer)/message.length())*100);
            }
        });

        return MapUtil.sortByValue(frequenciesPercent);
    }

}
