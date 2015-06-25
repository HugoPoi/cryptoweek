package net.hugopoi.homophonic;

import java.io.File;

/**
 * Created by hugo on 23/06/15.
 */
public class Main {

    public static void main(String[] args) {
        CipherHomophonic homo = new CipherHomophonic();
        homo.generateKey(new File("key.bin"));
        homo.encode(new File("text.txt"), new File("key.bin"), new File("crypted1.bin"));
        homo.encode(new File("text.txt"), new File("key.bin"), new File("crypted2.bin"));
        homo.decode(new File("crypted1.bin"), new File("key.bin"), new File("decipher.txt"));
        homo.decode(new File("crypted2.bin"), new File("key.bin"), new File("decipher2.txt"));
    }
}
