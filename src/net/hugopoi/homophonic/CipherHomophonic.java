package net.hugopoi.homophonic;

import net.hugopoi.utils.CipherTools;
import net.hugopoi.utils.ICipher;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hugo on 23/06/15.
 */
public class CipherHomophonic implements ICipher{

    @Override
    public void generateKey(File f){
        try {
            int symbolsLength = 256;
            DataOutputStream o = new DataOutputStream(new FileOutputStream(f));

            Map<Character, Float> frequencies = CipherTools.getLetterFrequencies(CipherTools.alphabet, true);
            Object[] freqs = frequencies.entrySet().toArray();

            int used = 0;
            for (int i = 0; i < CipherTools.alphabet.length() ; i++ ){

                int max = used+Math.round(((frequencies.get(CipherTools.alphabet.charAt(i))) / 100) * (symbolsLength-1));
                ByteArrayOutputStream symbols = new ByteArrayOutputStream();

                if(max == used){
                    System.out.println(CipherTools.alphabet.charAt(i)+":"+used);
                    symbols.write(used);
                    used++;
                }else{
                    System.out.print(CipherTools.alphabet.charAt(i) + ":");
                    for(; used < max && used < symbolsLength; used++){
                        System.out.print(used+",");
                        symbols.write(used);
                    }
                    System.out.println();
                }

                o.writeByte(symbols.size());
                o.write(symbols.toByteArray());

            }

            o.write(0);

        }catch (IOException e){
            e.printStackTrace();
        }


    }

    @Override
    public void encode(File msg, File key, File output) {
        try {
            DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(output));
            FileReader clearMessageStream = new FileReader(msg);
            Map<Character, ArrayList<Byte>> buildedKey = buildKey(key);

            while(clearMessageStream.ready()){
                char c = (char) clearMessageStream.read();
                ArrayList<Byte> symbols = buildedKey.get(c);
                int randIndex = (int) Math.floor(Math.random() * symbols.size());
                outputStream.writeByte(symbols.get(randIndex));
            }
            outputStream.close();
            clearMessageStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void decode(File msg, File key, File output) {
        try {
            DataInputStream cryptedMessageStream = new DataInputStream(new FileInputStream(msg));
            FileWriter clearMessageStream = new FileWriter(output);
            Map<Byte, Character> buildedKey = buildKeyForDecode(key);

            while(cryptedMessageStream.available() > 0){
                clearMessageStream.write(buildedKey.get(cryptedMessageStream.readByte()));
            }
            clearMessageStream.close();
            clearMessageStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private Map<Character, ArrayList<Byte>> buildKey(File key) throws IOException{
        FileInputStream file = new FileInputStream(key);
        Map<Character, ArrayList<Byte>> outKey = new HashMap<>();
        for (int i = 0; i < CipherTools.alphabet.length() ; i++ ){
            int nextSize = file.read();
            ArrayList<Byte> symbols = new ArrayList<>();
            for(int j = 0 ; j < nextSize ; j++){
                symbols.add((byte)file.read());
            }
            if(nextSize > 0) outKey.put(CipherTools.alphabet.charAt(i), symbols);
        }
        file.close();
        return outKey;
    }

    private Map<Byte, Character> buildKeyForDecode(File key) throws IOException{
        FileInputStream file = new FileInputStream(key);
        Map<Byte, Character> outKey = new HashMap<>();
        for (int i = 0; i < CipherTools.alphabet.length() ; i++ ){
            int nextSize = file.read();
            for(int j = 0 ; j < nextSize ; j++){
                outKey.put((byte) file.read(), CipherTools.alphabet.charAt(i));
            }
        }
        file.close();
        return outKey;
    }

}
