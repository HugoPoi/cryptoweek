package net.hugopoi.polyphonic;

import net.hugopoi.utils.MapUtil;

import java.util.*;
import java.util.function.BiFunction;

/**
 * Created by hugo on 25/06/15.
 */
public class VigenereAttack {

    public String findKey(String message){
        int keySize = findKeyLength(message);
        StringBuilder[] pieces = new StringBuilder[keySize];

        for (int i = 0, j = 0; i < message.length(); i++) {
            pieces[j].append(message.charAt(i));
            if(++j > keySize-1){
                j=0;
            }
        }
        



        return null;
    }

    private int findKeyLength(String message){
        Map<String, Integer> words = new HashMap<>();
        Map<Integer, Integer> dividers = new HashMap<>();

        for (int i = Math.round(message.length() / 2); i >= 2 ; i--) {
            for (int j = 0; j < (message.length()-i); j++) {
                String w = message.substring(j,i+j);

                int pos = message.indexOf(w,i+j);
                if(pos != -1){
                    //System.out.println(w+" found "+(pos-j));
                    for(Integer div : dividers(pos-j)){
                        dividers.compute(div, new BiFunction<Integer, Integer, Integer>() {
                            @Override
                            public Integer apply(Integer integer, Integer integer2) {
                                if(integer2 == null){
                                    return 1;
                                }else{
                                    return integer2+1;
                                }
                            }
                        });
                    }
                }
            }
        }

        return ((Map.Entry<Integer,Integer>) MapUtil.sortByValue(dividers).entrySet().toArray()[0]).getKey();
    }

    private List<Integer> dividers(int number){
        List<Integer> ds = new ArrayList<>();

        for (int i = 2; i < number; i++) {
            if((number%i) == 0) ds.add(i);
        }

        return ds;
    }
}
