package net.hugopoi;

public class Main {

    public static void main(String[] args) {
        MonoCipher m = new MonoCipher();
        String key = m.generateKey();
        System.out.println(key);
        String s = m.encode("FUCK LA NSA.", key);
        System.out.println(s);
        System.out.println(m.decode(s, key));

        MonoEncodedAttack att = new MonoEncodedAttack();
        att.findKey(s);
    }
}
