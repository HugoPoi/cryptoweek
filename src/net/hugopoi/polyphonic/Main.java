package net.hugopoi.polyphonic;

/**
 * Created by hugo on 24/06/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println((new VigenereCipher()).encode("J ADORE ECOUTER LA RADIO TOUTE LA JOURNEE", "MUSIQUE"));
    }
}
