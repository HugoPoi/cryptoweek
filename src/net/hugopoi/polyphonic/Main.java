package net.hugopoi.polyphonic;

import java.io.IOException;

/**
 * Created by hugo on 24/06/15.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println((new VigenereCipher()).encode("J ADORE ECOUTER LA RADIO TOUTE LA JOURNEE", "MUSIQUE"));
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
        System.out.println((new VigenereAttack()).findKey("cioqxivzovsgamzmgutvgwyxzdbohfufhsazuoseoakyrssskocltgsztitadhlljgghsmznqwzccsir".toUpperCase()));
    }
}
