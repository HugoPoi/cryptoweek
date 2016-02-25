package net.hugopoi.transposition;

import java.io.IOException;

/**
 * Created by hugo on 26/06/15.
 */
public class Main {

    public static void main(String[] args) throws IOException{
        CipherTransposition ct = new CipherTransposition();
        TranspositionAttack ta = new TranspositionAttack();
        ct.encode("VOICI UN MESSAGE CLAIR", ct.generateKey(3));
        String sample = ct.encode("VOICI UN MESSAGE CLAIR POUR TESTER MON ALGORITHME TROP BIEN CECI EST UN TEST",ct.generateKey(3));
        System.out.println(sample);
        ta.findKey(sample);
    }
}
