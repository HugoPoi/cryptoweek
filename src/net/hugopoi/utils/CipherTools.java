package net.hugopoi.utils;

import net.hugopoi.utils.MapUtil;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

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

    public static Map<Character,Float> getLetterFrequencies() throws IOException {
        Map<Character, Float> listLetter = new HashMap<>();
        File file = new File("freqFR2.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] parts =line.split("#");
            listLetter.put(parts[0].charAt(0), Float.parseFloat(parts[1]));
        }
        return MapUtil.sortByValue(listLetter);
    }
}
