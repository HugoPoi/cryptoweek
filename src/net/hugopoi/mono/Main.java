package net.hugopoi.mono;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws Exception {
        /*MonoCipher m = new MonoCipher();
        String key = m.generateKey();
        System.out.println(key);
        String s = m.encode("FUCK LA NSA.", key);*/
        BufferedReader r = new BufferedReader(new FileReader("encoded2.txt"));
        MonoEncodedAttack att = new MonoEncodedAttack();
        att.findKey(r.readLine());
    }
}
