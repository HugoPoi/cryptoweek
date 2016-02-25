package org.esgi.crypto;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by hugo on 26/06/15.
 */
public class AttackTransposition implements IExecute{

    @Override
    public void execute(File encoded, File key, File decoded) {
        try{
            FileReader f = new FileReader(encoded);
            StringBuilder crypted = new StringBuilder();
            char[] buf = new char[4096];
            while(f.ready()){
                int lgt = f.read(buf);
                crypted.append(buf,0, lgt);
            }
        }catch (IOException e){

        }
    }
}
