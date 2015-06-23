package net.hugopoi;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * Created by hugo on 23/06/15.
 */
public class MonoEncodedAttack {

    public ArrayList<String> findKey(String message) throws Exception{
        Map<Character, Integer> frequencies = getFrequencies(message);

        //Get french frenquencies stats

        Map<Character, Float> frequenciesFR = MonoDictionnary.getLetter();
        Character[] freqFR = new Character[frequenciesFR.size()];
        frequenciesFR.keySet().toArray(freqFR);

        //Get the most probable key
        Map<Character,Character> buildKey = new HashMap<>();
        frequencies.forEach(new BiConsumer<Character, Integer>() {
            int i = 0;
            @Override
            public void accept(Character character, Integer integer) {
                buildKey.put(character,freqFR[i++]);
            }
        });

        //MapUtil.printFrequencies(buildKey);
        System.out.println(decode(message,buildKey));

        //Score confidence


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


    private String toKey(Map<Character, Character> key){
        StringBuilder nkey = new StringBuilder();
        for (int i = 0; i < MonoCipher.alphabet.length(); i++){
            nkey.append(key.get(MonoCipher.alphabet.charAt(i)));
        }
        return nkey.toString();
    }

    private void completeKey(Map<Character, Character> key){

        for(int i = 0 ; i < MonoCipher.alphabet.length(); i++ ){
            if(key.get(MonoCipher.alphabet.charAt(i)) == null){

            }
        }

    }

    private String decode(String message, Map<Character, Character> key){
        StringBuilder clearMsg = new StringBuilder();
        for (int i = 0 ; i < message.length(); i++){
            clearMsg.append(key.get(message.charAt(i)));
        }
        return clearMsg.toString();
    }

}
