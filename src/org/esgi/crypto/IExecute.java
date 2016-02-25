package org.esgi.crypto;

import java.io.File;

/**
 * Created by hugo on 26/06/15.
 */
public interface IExecute {

    public void execute(File encoded, File key, File decoded);
}
