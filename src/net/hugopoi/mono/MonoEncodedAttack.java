package net.hugopoi.mono;

import net.hugopoi.utils.CipherTools;
import net.hugopoi.utils.MapUtil;
import net.hugopoi.utils.SimpleEntryClonable;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * Created by hugo on 23/06/15.
 */
public class MonoEncodedAttack {

    Map<String, Float> dic = null;

    public MonoEncodedAttack() throws Exception{
        dic = CipherTools.getDictionnary();
    }

    public ArrayList<String> findKey(String message) throws Exception{
        Map<Character, Float> frequencies = CipherTools.getFrequencies(message);

        Map<Character, Float> frequenciesFR = CipherTools.getLetterFrequencies(CipherTools.alphabet);
        Character[] freqFR = new Character[frequenciesFR.size()];
        frequenciesFR.keySet().toArray(freqFR);

        //Get the most probable key
        TreeMap<Float,SimpleEntryClonable<Character,Character>> buildKey = new TreeMap<>();
        frequencies.forEach(new BiConsumer<Character, Float>() {
            int i = 0;
            @Override
            public void accept(Character character, Float per) {

                buildKey.put(frequenciesFR.get(freqFR[i]),new SimpleEntryClonable<Character,Character>(character,freqFR[i]));
                i++;
            }
        });


        MapUtil.printMap(buildKey);
        String msg = decode(message,toKeyMap(buildKey));
        int score = getConfidence(msg);
        System.out.println("Start : "+ score + " # " + msg);
        int newscore = 0;
        TreeMap<Float,SimpleEntryClonable<Character,Character>> currentkey = buildKey;
        Float minimumChange = 2f;
        //Score confidence
        for(int j = 0 ; j < 5000 ; j++){

            TreeMap<Float,SimpleEntryClonable<Character,Character>> newKey = swapKey(currentkey, minimumChange);
            msg = decode(message,toKeyMap(newKey));
            newscore = getConfidence(msg);


            if(newscore > score){
                currentkey = newKey;
                score = newscore;
            }

            if((j % 1000) == 0) System.out.println("Best : "+score+" # "+ decode(message,toKeyMap(currentkey)));;

        }




        return null;
    }

    private Map<Character, Character> toKeyMap(Map<Float,SimpleEntryClonable<Character,Character>> buildKey){
        Map<Character, Character> key = new HashMap<>();
        for(SimpleEntryClonable<Character, Character> el : buildKey.values()){
            key.put(el.getKey(), el.getValue());
        }
        return key;
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

    private int getConfidence(String message){
        Set<String> uniqueSet = new HashSet<String>(Arrays.asList(message.split(" ")));

        int i = 0;
        for(String word : uniqueSet){
            if(dic.get(word) != null){
                i++;
            }
        }
        return i;
    }

    private TreeMap<Float,SimpleEntryClonable<Character,Character>> swapKey(TreeMap<Float,SimpleEntryClonable<Character,Character>> key, Float min){
        TreeMap<Float,SimpleEntryClonable<Character,Character>> newKey = (TreeMap<Float,SimpleEntryClonable<Character,Character>>) key.clone();
        int i = 0;
        int rand = (int) Math.floor(Math.random() * (newKey.keySet().size()-1));
        Float preceding = null;
        Float following = null;
        Float prepreceding = null;
        SimpleEntryClonable<Character,Character> kb, ka;
        for(Float f : newKey.descendingKeySet()){
            if(i > rand){
                following = f;
                break;
            }
            prepreceding = preceding;
            preceding = f;
            i++;
        }

        if(Math.floor(Math.random() *2) == 1 && prepreceding != null){
            preceding = prepreceding;
            //System.out.println("sawppppppp");
        }

        if(Math.abs(preceding-following) < min){
            ka = newKey.get(preceding);
            kb = newKey.get(following);
            Character ca = ka.getKey();
            Character cb = ka.getValue();
            Character cta = kb.getKey();
            Character ctb = kb.getValue();
            newKey.put(preceding, new SimpleEntryClonable<Character,Character>(ca,ctb));
            newKey.put(following, new SimpleEntryClonable<Character,Character>(cta,cb));
        }


        return newKey;
    }

}
