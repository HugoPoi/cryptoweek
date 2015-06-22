package net.hugopoi;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hugo on 22/06/15.
 */
public class MonoCipher implements ICipher {

    private static final String ponct = " .,;:\"'";

    public String generateKey(){

        char[] charTable = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ" + ponct).toCharArray();
        int currentIndex = charTable.length, randomIndex;
        char temporaryValue;

        // While there remain elements to shuffle...
        while (0 != currentIndex) {

            // Pick a remaining element...
            randomIndex = (int) Math.floor(Math.random() * currentIndex);
            currentIndex -= 1;

            // And swap it with the current element.
            temporaryValue = charTable[currentIndex];
            charTable[currentIndex] = charTable[randomIndex];
            charTable[randomIndex] = temporaryValue;
        }

        return new String(charTable);
    }

    private HashMap<Character, Character> buildConversionTable(String key){
        HashMap<Character,Character> table = new HashMap<Character, Character>();
        char el = 'A';
        for(int i = 0 ; i < 26 ; i++){
            table.put((char)(el+i), key.charAt(i));
        }
        for(int i=0 ; i < ponct.length() ; i++){
            table.put(ponct.charAt(i), key.charAt(i+26));
        }
        return table;
    }

    @Override
    public String encode(String message, String key) {
        HashMap<Character,Character> table = buildConversionTable(key);
        StringBuilder stringBuilder = new StringBuilder();
        
        return stringBuilder.toString();
    }

    @Override
    public String decode(String crypted, String key) {
        return null;
    }
}
