package com.cmurt.encryption_protocol;

import android.util.Log;

import java.util.Arrays;

public class Viginere_Key {

    /**
     * description
     *
     * Viginere is an 2-Dimensional Array
     * Alphabet is an Array consisting of a temporary alphabet to generate
     * the Viginere Array
     * populateAlphabetArray populates the Array 'Alphabet' with the Alphabet
     * populateViginereArray populates the Array 'Viginere' with the 26 characters of the Alphabet,
     * in a manner that resembles the Viginere Cipher Key
     * Main is the main method for the class
     */
    private String[][] Viginere = new String[26][26]; // Declares the Viginere array

    private String[] Alphabet = new String[26]; // Declares the Alphabet array

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

    // populates the Viginere Array
    private void populateViginereArray() {
//        // gets the value of Array 'Alphabet' and stores the Array
//        // in the first row of Array 'Viginere'
//        // using a for loop to get the value of each of the elements
//        // in the Array 'Alphabet'
//        for(int a = 0; a <= 25; a++) {
//            Viginere[0][a] = Alphabet[a];
//        }
        System.arraycopy(Alphabet, 0, Viginere[0],0, 26);
        for (int b = 1; b <= 25; b++) {
            // gets the value of 'Alphabet' Array element at numerical index 0
            // and stores it into the char letter
            char letter = Alphabet[0].charAt(0);
            for (int c = 1; c <= 25; c++) {
                // changes the letter in the place before integer 'c' in the array
                // to the letter in the place of integer 'c' in the array
                Alphabet[c-1] = Alphabet[c];
                // changes the data value of the letter in the place of integer 'c'-1
                // in the current column 'a'-1 and the current row 'b' to the corresponding
                // letter that the Array 'Alphabet' is pointing to with integer 'c'-1
                // in the Array 'Viginere'
                Viginere[b][c-1] = Alphabet[c-1];
            }
            // gets the value of 'letter' and stores it into the corresponding element
            Alphabet[25] = String.valueOf(letter);
            // gets the value of the 'Alphabet' Array element corresponding to numerical index 25
            // and stores it into the current row 'b' 'Viginere' Array element corresponding
            // to numerical index 25
            Viginere[b][25] = Alphabet[25];
            // logs the value of Array 'Alphabet' to the logcat under log level debug
            Log.d("this is Alphabet Array", "Alphabet :-: " + Arrays.toString(Alphabet));
        }
        // this is to add a space between Array print outs to aid in easy reading
        // of the data in the Array(s)
        System.out.println("                                                                 ");
        // logs the value of Array 'Viginere' to the logcat under log level debug
        for(int d = 0; d <= 25; d++) {
            Log.d("this is Viginere Array", "Viginere :-: " + Arrays.deepToString(Viginere[d]));
        }
    }

    public String Main() { // main method of the class which initializes the Array(s)
        populateAlphabetArray();
        populateViginereArray();
        return null;
    }
}
