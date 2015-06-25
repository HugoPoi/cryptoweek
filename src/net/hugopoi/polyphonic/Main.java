package net.hugopoi.polyphonic;

import java.io.IOException;

/**
 * Created by hugo on 24/06/15.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println((new VigenereAttack()).findKey("KQOWEFVJPUJUUNUKGLMEKJINMWUXFQMKJBGWRLFNFGHUDWUUMBSVLPS" +
                "NCMUEKQCTESWREEKOYSSIWCTUAXYOTAPXPLWPNTCGOJBGFQHTDWXIZA" +
                "YGFFNSXCSEYNCTSSPNTUJNYTGGWZGRWUUNEJUUQEAPYMEKQHUIDUXFP" +
                "GUYTSMTFFSHNUOCZGMRUWEYTRGKMEEDCTVRECFBDJQCUSWVBPNLGOYL" +
                "SKMTEFVJJTWWMFMWPNMEMTMHRSPXFSSKFFSTNUOCZGMDOEOYEEKCPJR" +
                "GPMURSKHFRSEIUEVGOYCWXIZAYGOSAANYDOEOYJLWUNHAMEBFELXYVL" +
                "WNOJNSIOFRWUCCESWKVIDGMUCGOCRUWGNMAAFFVNSIUDEKQHCEUCPFC" +
                "MPVSUDGAVEMNYMAMVLFMAOYFNTQCUAFVFJNXKLNEIWCWODCCULWRIFT" +
                "WGMUSWOVMATNYBUHTCOCWFYTNMGYTQMKBBNLGFBTWOJFTWGNTEJKNEE" +
                "DCLDHWTYYIDGMVRDGMPLSWGJLAGOEEKJOFEKUYTAANYTDWIYBNLNYNP" +
                "WEBFNLFYNAJEBFR"));
        VigenereAttack va = new VigenereAttack();
        VigenereCipher vc = new VigenereCipher();
        String message = "cioqpotgbjkftyyghakvfjkfsituhfufzyyghckdhmjssyjsjbotmlkftitavnjswuyglyyhrcqcbfuz".toUpperCase();
        System.out.println(va.findKey(message));
        System.out.println(vc.decode(message,va.findKey(message)));


    }
}
