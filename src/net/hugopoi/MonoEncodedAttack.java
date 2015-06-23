package net.hugopoi;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * Created by hugo on 23/06/15.
 */
public class MonoEncodedAttack {

    public ArrayList<String> findKey(String message){
        Map<Character, Integer> frequencies = getFrequencies(message);
        printFrequencies(frequencies);

        return null;
    }

    private Map<Character, Integer> getFrequencies(String message){
        Map<Character, Integer> frequencies = new HashMap<>();

        for (int i = 0 ; i < message.length() ; i++){
            Integer c = frequencies.get(message.charAt(i));
            if(c == null){
                frequencies.put(message.charAt(i), 1);
            }else{
                frequencies.put(message.charAt(i), c+1);
            }
        }

        return MapUtil.sortByValue(frequencies);
    }

    private void printFrequencies(Map<Character, Integer> frequencies){

        frequencies.forEach(new BiConsumer<Character, Integer>() {
            @Override
            public void accept(Character character, Integer integer) {
                System.out.println(character+" : "+integer);
            }
        });

    }
}
