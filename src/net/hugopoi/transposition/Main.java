package net.hugopoi.transposition;

/**
 * Created by hugo on 26/06/15.
 */
public class Main {

    public static void main(String[] args) {
        CipherTransposition ct = new CipherTransposition();
        System.out.println(ct.encode("VOICI UN MESSAGE CLAIR",ct.generateKey(3)));
    }
}
