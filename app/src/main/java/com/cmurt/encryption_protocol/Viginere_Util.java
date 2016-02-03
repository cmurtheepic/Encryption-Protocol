package com.cmurt.encryption_protocol;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Viginere_Util {

    // below are the declarations of most of the variables in this java class
    String OutputStream;
    // above are the declarations of most of the variables in this java class

    RanGen_Util RG_U = new RanGen_Util();

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

    String[] RGUMAIN = RG_U.Main();

    String[] Main = RGUMAIN; // declares the array 'Main'
                             // and sets it to the value
                             // of RG_U.Main()


    public String[] clean(final String[] v) {
        List<String> list1 = new ArrayList<>(Arrays.asList(v));
        list1.removeAll(Collections.singleton(null));
        return list1.toArray(new String[list1.size()]);
    }

    // main method of the class which initializes the Array(s)
    // and encrypts the Users Data and returns the encrypted data
    public String[] Main(String InputStream) {
//
        // Declares the Alphabet array
        String[] Alphabet = new String[62];

        //TODO add the symbols for the rest of the keyboard keys, etc.
        //TODO add symbols; `, ~, !, @, #, $, %, ^, &, *, (, ), -, _, +, =, ?, \
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
        Alphabet[26] = "A";
        Alphabet[27] = "B";
        Alphabet[28] = "C";
        Alphabet[29] = "D";
        Alphabet[30] = "E";
        Alphabet[31] = "F";
        Alphabet[32] = "G";
        Alphabet[33] = "H";
        Alphabet[34] = "I";
        Alphabet[35] = "J";
        Alphabet[36] = "K";
        Alphabet[37] = "L";
        Alphabet[38] = "M";
        Alphabet[39] = "N";
        Alphabet[40] = "O";
        Alphabet[41] = "P";
        Alphabet[42] = "Q";
        Alphabet[43] = "R";
        Alphabet[44] = "S";
        Alphabet[45] = "T";
        Alphabet[46] = "U";
        Alphabet[47] = "V";
        Alphabet[48] = "W";
        Alphabet[49] = "X";
        Alphabet[50] = "Y";
        Alphabet[51] = "Z";
        Alphabet[52] = " ";
        Alphabet[53] = ".";
        Alphabet[54] = ",";
        Alphabet[55] = "/";
        Alphabet[56] = ";";
        Alphabet[57] = ":";
        Alphabet[58] = "<";
        Alphabet[59] = ">";
        Alphabet[60] = "|";
        Alphabet[61] = "";

        // logs the value(s) of Array 'Alphabet' to the logcat under log level debug
        Log.d("this is Alphabet Array", "Alphabet :-: " + Arrays.toString(Alphabet));

        clean(Main); // removes all null values from the array 'main'

        Log.d("value of Main:", "value: " + Arrays.toString(Main));

        // determines the amount of "real" values there are
        // in the numbers array
        int num=0;
        for(int i=0;i<RGUMAIN.length;i++) {
            if (Main[i] != null) {
                num++;
            }
        }

        int[] Key = new int[num]; // declares the array 'Key'
        String[] SKey = new String[num]; // declares the array 'SKey'

        Log.d("value of num:", "value: " + num);

        // converts String array 'Main' to Integer array 'Key'
        // as well as it converts Integer array 'Key' to String array 'SKey'
        for(int y=0; y < num; y++) {
            try {
                Key[y] = Integer.parseInt(Main[y]);
                SKey[y] = Alphabet[Key[y]];
            } catch (NumberFormatException nfe) {
                Log.e("Key catch:", "catch: " + nfe);
            }
        }

        // removes any null values from the array 'SKey'
        clean(SKey);

        String[] Text; // = new String[InputStream.length()+2]; // declares the array 'Text'
        int[] text = new int[InputStream.length()+1]; // declares the array 'text'
        String[] Encrypted = new String[InputStream.length()+1]; // declares the array 'Encrypted'
        int[] encrypted = new int[InputStream.length()+1]; // declares the array 'encrypted'

        // splits the String 'InputStream' into the String array 'Text'
        Text = InputStream.split("");

        // logs the values in the array 'Text' to the logcat under log level debug
        Log.d("Text array:", "Values: " + Arrays.toString(Text));

        // logs the length of array 'Text' to the logcat under log level debug
        Log.d("Text Length:", "Length" + Text.length);

        int text_length = Text.length; // sets the value of 'text_length' to the length of the array 'Text'
        int key_length = num; // sets the value of 'key_length' to the value of Integer 'num'

        Log.d("text_length", "length: " + text_length);
        Log.d("key_length", "length: " + key_length);

        // converts the String letter characters in array 'Text'
        // to numbers that represent the letter,
        // and stores it in the array 'text'
        try {
            for (int t = 1; t < Text.length; t++) {
                int u = 0;
                Log.d("Text t:", "Text t value: " + Text[t]);
                while(!Text[t].equals(Alphabet[u])) {
                    if(!Text[t].equals(Alphabet[u]) && u < 62) {
                        u++;
                    } else {
                        Log.e("Integer U:", "THE VALUE OF U EXCEEDED 61");
                        break;
                    }
                }
                Log.d("while statement:", "while loop finished");
                if (Text[t].equals(Alphabet[u])) {
                    text[t] = u;
                }

            }
        Log.d("text:", "text value: " + Arrays.toString(text));
        } catch (Exception e) {
            Log.e("T equals A catch:", "catch: " + e);
        }

        // logs the value of array 'key' to the logcat under log level debug
        Log.d("Key:", "value: " + Arrays.toString(Key));

        //TODO fix the problem of encryptor is using up a space in the key to encrypt a 0 value
        //TODO cont. at the beginning of the array 'text'
        // encrypts the User's text
        int li = 0;
        try {
            for (int l = 0; l < text_length - 1; l++) {
                int KL = l%key_length;
                if(text[l+1] == 52 || text[l+1] == 53 || text[l+1] == 54 || text[l+1] == 55
                        || text[l+1] == 56 || text[l+1] == 57 || text[l+1] == 58 || text[l+1] == 59
                        || text[l+1] == 60 || text[l+1] == 61) {
                    encrypted[l] = text[l+1];
                    li++;
                } else {
                    encrypted[l] = ((text[l+1] + Key[KL]) % 26);
                }
            }
            Log.d("encrypted:", "value: " + Arrays.toString(encrypted));
            // adds all the miscellaneous symbols to the Encrypted array
            //TODO add the symbols for the rest of the keyboard keys, etc.
            for (int j = 0; j < text_length; j++) {
//                if(text[j] == 52) {
//                    Encrypted[j] = " ";
//                } else if(text[j] == 53) {
//                    Encrypted[j] = ".";
//                } else if(text[j] == 54) {
//                    Encrypted[j] = ",";
//                } else if(text[j] == 55) {
//                    Encrypted[j] = "/";
//                } else if(text[j] == 56) {
//                    Encrypted[j] = ";";
//                } else if(text[j] == 57) {
//                    Encrypted[j] = ":";
//                } else if(text[j] == 58) {
//                    Encrypted[j] = "<";
//                } else if(text[j] == 59) {
//                    Encrypted[j] = ">";
//                } else if(text[j] == 60) {
//                    Encrypted[j] = "|";
//                } else if(text[j] == 61) {
//                    Encrypted[j] = "";
//                } else {
                    Encrypted[j] = Alphabet[encrypted[j]];
//                }
            }
//            // adds the spaces from the users text to the encrypted text
//            for (int h = 0; h < text_length; h++) {
//                if(text[h] == 52) {
//                    Encrypted[h-1] = " ";
//                }
//            }
            OutputStream = Arrays.toString(Encrypted);
            // removes all commas from the String
            OutputStream = OutputStream.substring(1, OutputStream.length()-1).replaceAll(",","");
        } catch (Exception e) {
            Log.e("Encrypt catch:", "catch: " + e);
        }

        String KeyOutput = Arrays.toString(SKey);
        // removes all commas from the String
        KeyOutput = KeyOutput.substring(1, KeyOutput.length()-1).replaceAll(",","");

        // logs the value of String array 'SKey' to the logcat under log level debug
        Log.d("SKey:", "value: " + KeyOutput);

        // logs the value of String 'OutputStream' to the logcat under log level debug
        Log.d("OutputStream:", "Stream: " + OutputStream);

        String[] Ret = new String[3]; // declares the array 'Return'

        Ret[1] = OutputStream; // sets the array element 1 to the value of OutputStream
        Ret[2] = KeyOutput; // sets the array element 2 to the value of KeyOutput

        return Ret; // returns the encrypted String
    }
}
