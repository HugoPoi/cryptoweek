package net.hugopoi.utils;

import java.io.File;

/**
 * Created by hugo on 23/06/15.
 */
public interface ICipher {

    public void generateKey(File f);

    public void encode(File msg, File key, File output);
    public void decode(File msg, File key, File output);
}
