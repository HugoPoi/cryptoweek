package net.hugopoi.transposition;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hugo on 26/06/15.
 */
public class CipherTransposition {


    List<Integer> generateKey(Integer size){
        return Arrays.asList(new Integer[]{2,4,0,1,3});
    }

    String encode(String message, List<Integer> key){

        StringBuilder cryptedMsg = new StringBuilder();
        StringBuilder msgBuild = new StringBuilder(message);

        for (int i = 0; i < (key.size()-(message.length() % key.size())); i++) {
            msgBuild.append('*');
        }

        String sizedMessage = msgBuild.toString();

        for (int i = 0, posKey = 0, posPiece = 0; i < sizedMessage.length(); i++) {

            cryptedMsg.append(sizedMessage.charAt(posPiece+key.get(posKey)));

            if(++posKey >= key.size()){
                posPiece = i+1;
                posKey = 0;
            }
        }
        return cryptedMsg.toString();
    }
}

