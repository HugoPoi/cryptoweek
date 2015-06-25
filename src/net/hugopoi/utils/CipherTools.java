package net.hugopoi.utils;

import net.hugopoi.utils.MapUtil;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * Created by jonathan on 23/06/15.
 */
public class CipherTools {

    public static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + " .,;:\"'";

    public static Map<String,Float> getDictionnary() throws IOException {
        Map<String, Float> listWord = new HashMap<>();

        File file = new File("listemot.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] parts =line.split("#");
            listWord.put(parts[0], Float.parseFloat(parts[1]));
        }
        return MapUtil.sortByValue(listWord);
    }

    public static Map<Character,Float> getLetterFrequencies(String alphabetFilter) throws IOException {
        Map<Character, Float> listLetter = new HashMap<>();
        File file = new File("freqFR2.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] parts =line.split("#");
            if(alphabetFilter.indexOf(parts[0].charAt(0)) != -1){
                listLetter.put(parts[0].charAt(0), Float.parseFloat(parts[1]));
            }
        }
        return MapUtil.sortByValue(listLetter);
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
