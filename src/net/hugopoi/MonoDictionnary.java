package net.hugopoi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

/**
 * Created by jonathan on 23/06/15.
 */
public class MonoDictionnary {

    public HashMap<String,Float> getDictionnary (File file) throws Exception {
        HashMap<String, Float> listWord = new HashMap<>();

        file = new File("listemot.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] parts =line.split(";");
            listWord.put(parts[0], Float.parseFloat(parts[1]));
        }
        return listWord;
    }
}
