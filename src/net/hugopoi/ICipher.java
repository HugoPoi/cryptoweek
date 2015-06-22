package net.hugopoi;

/**
 * Created by hugo on 22/06/15.
 */
public interface ICipher {
    String encode(String message, String key);
    String decode(String crypted, String key);
}
