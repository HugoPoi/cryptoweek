package net.hugopoi.transposition;

import net.hugopoi.utils.CipherTools;
import net.hugopoi.utils.MapUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * Created by hugo on 26/06/15.
 */
public class TranspositionAttack {

    Map<Character, Float> baseFrequencies;
    Map<String, Float> dictionary;
    public static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public TranspositionAttack() throws IOException{
        baseFrequencies = CipherTools.getLetterFrequencies(alphabet, false);
        dictionary = CipherTools.getDictionnary(3);
    }

    List<Integer> findKey(String message){
        Map<String, Integer> words = new HashMap<>();
        baseFrequencies.forEach(new BiConsumer<Character, Float>() {
            @Override
            public void accept(Character character, Float aFloat) {
                System.out.println(character);
                int analysePos = message.indexOf(character);
                for (int i = 1; i < Math.round(message.length()/2); i++) {
                    int start = analysePos-i, end = analysePos+i;
                    if(start < 0) start = 0;
                    if(end >= message.length()) end = message.length()-1;

                    String selectedChar = message.substring(start, end);
                    String match = findMatchingWord(selectWordsWith(character), selectedChar);
                    if(match != null){
                        words.compute(match, new BiFunction<String, Integer, Integer>() {
                            @Override
                            public Integer apply(String s, Integer integer) {
                                if(integer == null){
                                    return 1;
                                }else{
                                    return integer+1;
                                }
                            }
                        });
                        return;
                    }


                }
            }
        });

        MapUtil.printMap(MapUtil.sortByValue(words, true));

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
        return MapUtil.sortByValue(words, true);
    }

    private String findMatchingWord(Map<String, Float> words, String letters){
        for(Map.Entry<String, Float> word : words.entrySet()){
            if(lettersMatch(word.getKey(), letters) == word.getKey().length()){
                return word.getKey();
            }
        }
        return null;
    }

    private int lettersMatch(String a, String b){
        Map<Character, Integer> leta = getLetterCounts(a);
        Map<Character, Integer> letb = getLetterCounts(b);

        int count = 0;
        for(Map.Entry<Character, Integer> el : leta.entrySet()){
            Integer countb = letb.get(el.getKey());
            if(countb != null){
                if(countb >= el.getValue()){
                    count += el.getValue();
                }
            }
        }

        return count;
    }

    private Map<Character, Integer> getLetterCounts(String a){
        Map<Character, Integer> let = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            let.compute(a.charAt(i), new BiFunction<Character, Integer, Integer>() {
                @Override
                public Integer apply(Character character, Integer integer) {
                    if(integer == null){
                        return 1;
                    }else{
                        return integer+1;
                    }
                }
            });
        }
        return let;
    }
}
