package net.hugopoi.polyphonic;

/**
 * Created by hugo on 24/06/15.
 */
public class VigenereCipher {

    public static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ\" + \" .,;:\"'";

    String encode(String message, String key){
        StringBuilder crypterMsg = new StringBuilder();

        int posKey = 0;
        for(int i = 0; i < message.length() ; i++){


                int pos = (alphabet.indexOf(message.charAt(i)) + alphabet.indexOf(key.charAt(posKey)) ) % alphabet.length();
                crypterMsg.append(alphabet.charAt(pos));
                posKey++;
                if(posKey == key.length()) {
                    posKey = 0;
                }


        }
        return crypterMsg.toString();
    }

    String decode(String message, String key){
        return null;
    }
}
