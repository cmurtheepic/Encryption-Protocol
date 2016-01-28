package com.cmurt.encryption_protocol;

import android.util.Log;

import java.util.Arrays;

public class Viginere_Util {

    /**
     * description
     *
     * IGNORE Viginere is an 2-Dimensional Array IGNORE
     * Alphabet is an Array consisting of a temporary alphabet to generate
     * the Viginere Array
     * populateAlphabetArray populates the Array 'Alphabet' with the Alphabet
     * IGNORE populateViginereArray populates the Array 'Viginere' with the 26 characters of the Alphabet, IGNORE
     * IGNORE in a manner that resembles the Viginere Cipher Key IGNORE
     * Main is the main method for the class
     */

    // Declares the Alphabet array
    private String[] Alphabet = new String[26];

    // populates the 'Alphabet' array with the Alphabet
    private void populateAlphabetArray() {
        Alphabet[0] = "a";
        Alphabet[1] = "b";
        Alphabet[2] = "c";
        Alphabet[3] = "d";
        Alphabet[4] = "e";
        Alphabet[5] = "f";
        Alphabet[6] = "g";
        Alphabet[7] = "h";
        Alphabet[8] = "i";
        Alphabet[9] = "j";
        Alphabet[10] = "k";
        Alphabet[11] = "l";
        Alphabet[12] = "m";
        Alphabet[13] = "n";
        Alphabet[14] = "o";
        Alphabet[15] = "p";
        Alphabet[16] = "q";
        Alphabet[17] = "r";
        Alphabet[18] = "s";
        Alphabet[19] = "t";
        Alphabet[20] = "u";
        Alphabet[21] = "v";
        Alphabet[22] = "w";
        Alphabet[23] = "x";
        Alphabet[24] = "y";
        Alphabet[25] = "z";
        // logs the value(s) of Array 'Alphabet' to the logcat under log level debug
        Log.d("this is Alphabet Array", "Alphabet :-: " + Arrays.toString(Alphabet));
    }

    public String Main() { // main method of the class which initializes the Array(s)
        populateAlphabetArray();
        return null;
    }
}
