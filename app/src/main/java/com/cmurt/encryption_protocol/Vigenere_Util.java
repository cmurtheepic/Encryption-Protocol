package com.cmurt.encryption_protocol;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by cmurt on 1/26/2016.
 */
public class Vigenere_Util {

    /**
     * description
     *
     * @Viginere is an 2-Dimensional Array
     * @Alphabet is an Array consisting of a temporary alphabet to generate
     * the Viginere Array
     */
    private String[][] Viginere = new String[27][27]; // Declares the Viginere array

    private String[] Alphabet = new String[27]; // Declares the Alphabet array

    // populates the Alphabet array
    private void populateAlphabetArray() {
        Alphabet[1] = "a";
        Alphabet[2] = "b";
        Alphabet[3] = "c";
        Alphabet[4] = "d";
        Alphabet[5] = "e";
        Alphabet[6] = "f";
        Alphabet[7] = "g";
        Alphabet[8] = "h";
        Alphabet[9] = "i";
        Alphabet[10] = "j";
        Alphabet[11] = "k";
        Alphabet[12] = "l";
        Alphabet[13] = "m";
        Alphabet[14] = "n";
        Alphabet[15] = "o";
        Alphabet[16] = "p";
        Alphabet[17] = "q";
        Alphabet[18] = "r";
        Alphabet[19] = "s";
        Alphabet[20] = "t";
        Alphabet[21] = "u";
        Alphabet[22] = "v";
        Alphabet[23] = "w";
        Alphabet[24] = "x";
        Alphabet[25] = "y";
        Alphabet[26] = "z";
    }

    // populates the Viginere Array
    private void populateViginereArray() {
        for (int b = 1; b <= 26; b++) {
            char letter = Alphabet[1].charAt(0);
            for (int a = 2; a <= 26; a++) {
                Alphabet[a-1] = Alphabet[a];
                Viginere[b][a] = Alphabet[a];
            }
            Alphabet[26] = String.valueOf(letter);
            Viginere[b][26] = Alphabet[26];
            Log.d("this is Alphabet Array", "Alphabet :-: " + Arrays.toString(Alphabet));
        }
        Log.d("this is Viginere Array", "Viginere :-: " + Arrays.deepToString(Viginere));
    }

    public String Main() {
        populateAlphabetArray();
        populateViginereArray();
        return null;
    }
}
