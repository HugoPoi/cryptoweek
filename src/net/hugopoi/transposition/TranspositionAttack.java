package net.hugopoi.transposition;

import net.hugopoi.utils.CipherTools;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * Created by hugo on 26/06/15.
 */
public class TranspositionAttack {

    Map<Character, Float> baseFrequencies;
    Map<String, Float> dictionary;
    public static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public TranspositionAttack() throws IOException{
        baseFrequencies = CipherTools.getLetterFrequencies(alphabet, false);
        dictionary = CipherTools.getDictionnary();
    }

    List<Integer> findKey(String message){
        baseFrequencies.forEach(new BiConsumer<Character, Float>() {
            @Override
            public void accept(Character character, Float aFloat) {

            }
        });
        return null;
    }

    private Map<String, Float> selectWordsWith(Character f){
        Map<String, Float> words = new HashMap<>();
        dictionary.forEach(new BiConsumer<String, Float>() {
            @Override
            public void accept(String s, Float aFloat) {
                if(s.indexOf(f) != -1){
                    words.put(s, aFloat);
                }
            }
        });
        return words;
    }
}
