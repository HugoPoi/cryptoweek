package net.hugopoi;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hugo on 23/06/15.
 */
public class MonoEncodedAttack {

    public ArrayList<String> findKey(String message){
        return null;
    }

    private HashMap<Character, Integer> getFrequencies(String message){
        HashMap<Character, Integer> frequencies = new HashMap<>();

        for (int i = 0 ; i < message.length() ; i++){
            Integer c = frequencies.get(message.charAt(i));
            if(c == null){
                frequencies.put(message.charAt(i), 1);
            }else{
                frequencies.put(message.charAt(i), c+1);
            }
        }

        return frequencies;
    }
}
