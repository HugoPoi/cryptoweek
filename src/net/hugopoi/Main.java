package net.hugopoi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import static net.hugopoi.MapUtil.printFrequencies;

public class Main {

    public static void main(String[] args) throws Exception {
        MonoCipher m = new MonoCipher();
        String key = m.generateKey();
        System.out.println(key);
        BufferedReader r = new BufferedReader(new FileReader("text.txt"));
        String s = m.encode(r.readLine(), key);
        System.out.println(s);
        System.out.println(m.decode(s, key));

        MonoEncodedAttack att = new MonoEncodedAttack();
        att.findKey(s);
    }
}
