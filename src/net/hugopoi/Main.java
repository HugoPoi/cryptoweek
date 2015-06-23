package net.hugopoi;

import static net.hugopoi.MapUtil.printFrequencies;

public class Main {

    public static void main(String[] args) throws Exception {
        MonoCipher m = new MonoCipher();
        String key = m.generateKey();
        System.out.println(key);
        String s = m.encode("FUCK LA NSA.", key);
        System.out.println(s);
        System.out.println(m.decode(s, key));

        MonoEncodedAttack att = new MonoEncodedAttack();
        MonoDictionnary md = new MonoDictionnary();

        printFrequencies(md.getLetter());
        att.findKey(s);
    }
}
