package net.hugopoi.polyphonic;

/**
 * Created by hugo on 24/06/15.
 */
public class VigenereCipher {

    public static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //+ " .,;:\"'";

    String encode(String message, String key){
        return cypher(message,key, false);
    }

    String decode(String message, String key){
        return cypher(message,key, true);
    }

    private String cypher(String message, String key, boolean decode){
        StringBuilder crypterMsg = new StringBuilder();

        for(int i = 0, pos = 0, posKey = 0; i < message.length() ; i++){
            if(decode){
                pos = (alphabet.indexOf(message.charAt(i)) - alphabet.indexOf(key.charAt(posKey)) );
                if(pos < 0) pos += alphabet.length();
            }else{
                pos = (alphabet.indexOf(message.charAt(i)) + alphabet.indexOf(key.charAt(posKey)) ) % alphabet.length();
            }
            crypterMsg.append(alphabet.charAt(pos));
            posKey++;
            if(posKey == key.length()) {
                posKey = 0;
            }
        }
        return crypterMsg.toString();
    }

}
