package net.hugopoi.polyphonic;

import java.io.IOException;

/**
 * Created by hugo on 24/06/15.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        String sample = "KQOWEFVJPUJUUNUKGLMEKJINMWUXFQMKJBGWRLFNFGHUDWUUMBSVLPS" +
                "NCMUEKQCTESWREEKOYSSIWCTUAXYOTAPXPLWPNTCGOJBGFQHTDWXIZA" +
                "YGFFNSXCSEYNCTSSPNTUJNYTGGWZGRWUUNEJUUQEAPYMEKQHUIDUXFP" +
                "GUYTSMTFFSHNUOCZGMRUWEYTRGKMEEDCTVRECFBDJQCUSWVBPNLGOYL" +
                "SKMTEFVJJTWWMFMWPNMEMTMHRSPXFSSKFFSTNUOCZGMDOEOYEEKCPJR" +
                "GPMURSKHFRSEIUEVGOYCWXIZAYGOSAANYDOEOYJLWUNHAMEBFELXYVL" +
                "WNOJNSIOFRWUCCESWKVIDGMUCGOCRUWGNMAAFFVNSIUDEKQHCEUCPFC" +
                "MPVSUDGAVEMNYMAMVLFMAOYFNTQCUAFVFJNXKLNEIWCWODCCULWRIFT" +
                "WGMUSWOVMATNYBUHTCOCWFYTNMGYTQMKBBNLGFBTWOJFTWGNTEJKNEE" +
                "DCLDHWTYYIDGMVRDGMPLSWGJLAGOEEKJOFEKUYTAANYTDWIYBNLNYNP" +
                "WEBFNLFYNAJEBFR";

        VigenereAttack va = new VigenereAttack();
        VigenereCipher vc = new VigenereCipher();

        String crypttest = vc.encode(vc.decode(sample, "SCUBA"), "ABCEFGHIJ");

        //String message = "cioqpotgbjkftyyghakvfjkfsituhfufzyyghckdhmjssyjsjbotmlkftitavnjswuyglyyhrcqcbfuz".toUpperCase();
        System.out.println(va.findKey(crypttest));
        //System.out.println(vc.decode(message,va.findKey(message)));


    }
}
