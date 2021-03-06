package net.hugopoi.polyphonic;

import net.hugopoi.utils.CipherTools;
import net.hugopoi.utils.MapUtil;

import java.io.IOException;
import java.util.*;
import java.util.function.BiFunction;

/**
 * Created by hugo on 25/06/15.
 */
public class VigenereAttack {

    Map<Character, Float> baseFrequencies;

    public static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //+ " .,;:\"'";

    public VigenereAttack() throws IOException{
        baseFrequencies = CipherTools.getLetterFrequencies(alphabet, true);
    }

    public String findKey(String message){
        int keySize = findKeyLength(message);
        StringBuilder[] pieces = new StringBuilder[keySize];

        for (int i = 0, j = 0; i < message.length(); i++) {
            if(pieces[j] == null) pieces[j] = new StringBuilder();
            pieces[j].append(message.charAt(i));
            if(++j > keySize-1){
                j=0;
            }
        }

        StringBuilder key = new StringBuilder();
        for (int i = 0; i < keySize; i++) {
            key.append(mostProbableKey(pieces[i].toString(), alphabet));
        }


        return key.toString();
    }

    private char mostProbableKey(String cesar, String alphabet){
        Map<Character, Float> freq = CipherTools.getFrequencies(cesar);
        //System.out.println(((Map.Entry<Character, Float>) freq.entrySet().toArray()[0]).getKey() + " , " + ((Map.Entry<Character, Float>) freq.entrySet().toArray()[0]).getValue());
        return alphabet.charAt(Math.abs(alphabet.indexOf(((Map.Entry<Character, Float>) freq.entrySet().toArray()[0]).getKey()) - alphabet.indexOf(((Map.Entry<Character, Float>) baseFrequencies.entrySet().toArray()[0]).getKey())));
    }

    private int findKeyLength(String message){
        Map<String, Integer> words = new HashMap<>();
        Map<Integer, Integer> dividers = new HashMap<>();

        for (int i = Math.round(message.length() / 2); i >= 2 ; i--) {
            for (int j = 0; j < (message.length()-i); j++) {
                String w = message.substring(j,i+j);

                int pos=0;
                ArrayList<Integer> ecarts = new ArrayList<>();
                while((pos = message.indexOf(w,i+j+pos+w.length())) != -1){
                    ecarts.add(pos-j);
                }
                if(ecarts.size() > 1){

                    dividers.compute(PGCD(ecarts), new BiFunction<Integer, Integer, Integer>() {
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
        return ((Map.Entry<Integer,Integer>) MapUtil.sortByValue(dividers, true).entrySet().toArray()[0]).getKey();
    }

    private List<Integer> dividers(int number){
        List<Integer> ds = new ArrayList<>();

        for (int i = 2; i < number; i++) {
            if((number%i) == 0) ds.add(i);
        }

        return ds;
    }

    private int PGCD(List<Integer> numbers){
        int a = Math.max(numbers.get(0), numbers.get(1));
        int b = Math.min(numbers.get(0), numbers.get(1));
        int r;
        do{
            r = a % b;
            if(r != 0){
                a = b;
                b = r;
            }
        }while(r != 0);
        return b;
    }
}
