package com.cmurt.encryption_protocol;

// Dependencies

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Viginere_Util {

    // below are the declarations of most of the variables in this java class
    private String outputStream = ""; // declares a string named 'outputStream' with a value of empty

    private int loop = 0; // declares an integer named 'loop' with a value of '0'

    private final RanGen_Util RG_U = new RanGen_Util(); // declares an instance of RanGen_Util called RG_U

    private final String[] RGUMAIN = RG_U.Main(); // declares the array 'RGUMAIN'
                                                  // and sets it to the value of RG_U.Main()

    private final String[] Main = RGUMAIN; // declares the array 'Main'
                                           // and sets it to the value of RGUMAIN
    // above are the declarations of most of the variables in this java class

    /**
     * description
     *
     * Alphabet is an Array consisting of a temporary alphabet and miscellaneous characters
     * Main is the main method for the class
     */

    @SuppressWarnings("UnusedReturnValue")
    // cleans any null values from specified array 'v'
    // and returns the specified array as a new array minus any null values
    private String[] clean(final String[] v) {
        List<String> list1 = new ArrayList<>(Arrays.asList(v));
        //noinspection SuspiciousMethodCalls
        list1.removeAll(Collections.singleton(null));
        return list1.toArray(new String[list1.size()]);
    }

    // main method of the class which initializes the Array(s)
    // and encrypts the Users Data and returns the encrypted data
    public String[] Main(String InputStream) {
//
        // Declares the Alphabet array
        String[] Alphabet = new String[82];

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
        Alphabet[61] = "`";
        Alphabet[62] = "~";
        Alphabet[63] = "!";
        Alphabet[64] = "@";
        Alphabet[65] = "#";
        Alphabet[66] = "$";
        Alphabet[67] = "%";
        Alphabet[68] = "^";
        Alphabet[69] = "&";
        Alphabet[70] = "*";
        Alphabet[71] = "(";
        Alphabet[72] = ")";
        Alphabet[73] = "-";
        Alphabet[74] = "_";
        Alphabet[75] = "+";
        Alphabet[76] = "=";
        Alphabet[77] = "?";
        Alphabet[78] = "[";
        Alphabet[79] = "]";
        Alphabet[80] = "{";
        Alphabet[81] = "}";

        // logs the value(s) of Array 'Alphabet' to the logcat under log level debug
        Log.d("Viginere_Util", "Alphabet :-: " + Arrays.toString(Alphabet));

        clean(Main); // removes all null values from the array 'main'

        // logs the value of array 'Main' to the logcat under log level debug
        Log.d("Viginere_Util", "value of Main: " + Arrays.toString(Main));

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

        // logs the value of 'num' to the logcat under log level debug
        Log.d("Viginere_Util", "value of num: " + num);

        // converts String array 'Main' to Integer array 'Key'
        // as well as it converts Integer array 'Key' to String array 'SKey'
        for(int y=0; y < num; y++) {
            try {
                Key[y] = Integer.parseInt(Main[y]);
                SKey[y] = Alphabet[Key[y]];
            } catch (NumberFormatException nfe) {
                Log.e("Viginere_Util", "Key catch: " + nfe + " :-: " + Thread.currentThread().getStackTrace()[2].getLineNumber());
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
        Log.d("Viginere_Util", "Text array Values: " + Arrays.toString(Text));

        // logs the length of array 'Text' to the logcat under log level debug
        Log.d("Viginere_Util", "Text_Length: " + Text.length);

        int text_length = Text.length; // sets the value of 'text_length' to the length of the array 'Text'
        int key_length = num; // sets the value of 'key_length' to the value of Integer 'num'

        Log.d("Viginere_Util", "text_length: " + text_length); // logs the value of 'text_length' to the logcat under log level debug
        Log.d("Viginere_Util", "key_length: " + key_length); // logs the value of 'key_length' to the logcat under log level debug

        // converts the String letter characters in array 'Text'
        // to numbers that represent the letter,
        // and stores it in the array 'text'
        try {
            for (int t = 1; t < Text.length; t++) {
                int u = 0;
                // logs the value of array 'Text' element at integer 't'
                // to the logcat under log level debug
                Log.d("Viginere_Util", "Text t value: " + Text[t]);
                // loops as long as array 'Text' element at integer 't' does not equal
                // array 'Alphabet' element at integer 'u', as well as determines if
                // the loop progresses past the length of the array 'Alphabet'
                // if the loop progresses past the length of the array
                // will log error to log cat
                //TODO figure out how this function works, and what it's purpose is
                while(!Text[t].equals(Alphabet[u])) {
                    if(!Text[t].equals(Alphabet[u]) && u < 82) {
                        u++;
                    } else {
                        // will log to the logcat "THE VALUE OF 'U' EXCEEDED 82" with the line number
                        // if somehow the if statement as well as the while loop fails
                        Log.e("Viginere_Util", "THE VALUE OF U EXCEEDED 82 :-: " +
                                Thread.currentThread().getStackTrace()[2].getLineNumber());
                        break;
                    }
                }
                // logs the value 'while loop finished' to the logcat under log level debug
                Log.d("Viginere_Util", "while loop finished");
                // determines if the 'Text element' at integer 't'
                // is equal to the 'Alphabet element' at integer 'u'
                // if this statement is true, will set the array
                // 'text' element at integer 't' to the value of
                // integer 'u'
                if (Text[t].equals(Alphabet[u])) {
                    text[t] = u;
                }

            }
        // logs the value of array 'text' to the logcat under log level debug
        Log.d("Viginere_Util", "text value: " + Arrays.toString(text));

        // logs any exceptions that were detected to the logcat under log level error
        } catch (Exception e) {
            Log.e("Viginere_Util", "T equals A catch: " + e);
        }

        // logs the value of array 'key' to the logcat under log level debug
        Log.d("Viginere_Util", "Key value: " + Arrays.toString(Key));

        // encrypts the User's text using the viginere cipher
        // integer 'li' represents unnecessary increments to integer 'l'
        int li = 0;
        try {
            // counts up integer 'l' through the loop for the length of 'text'
            for (int l = 0; l < text_length - 1; l++) {
                // removes unnecessary increments from 'l' that are a result of spaces
                // and miscellaneous characters in the 'InputStream' for use with the key
                int KL = ((l-li)%key_length);
                // detects if there are miscellaneous characters or spaces in the numerical array 'test'
                if(text[l+1] == 52 || text[l+1] == 53 || text[l+1] == 54 || text[l+1] == 55
                        || text[l+1] == 56 || text[l+1] == 57 || text[l+1] == 58 || text[l+1] == 59
                        || text[l+1] == 60 || text[l+1] == 61 || text[l+1] == 62 || text[l+1] == 63
                        || text[l+1] == 64 || text[l+1] == 65 || text[l+1] == 66 || text[l+1] == 67
                        || text[l+1] == 68 || text[l+1] == 69 || text[l+1] == 70 || text[l+1] == 71
                        || text[l+1] == 72 || text[l+1] == 73 || text[l+1] == 74 || text[l+1] == 75
                        || text[l+1] == 76 || text[l+1] == 77 || text[l+1] == 78 || text[l+1] == 79
                        || text[l+1] == 80 || text[l+1] == 81) {
                    encrypted[l] = text[l+1];
                    li++;
                } else {
                    // continues to here if no miscellaneous characters or spaces were detected
                    encrypted[l] = ((text[l+1] + Key[KL]) % 26);
                }
            }

            // logs the values from array 'encrypted' to the logcat under log level debug
            Log.d("Viginere_Util", "encrypted value: " + Arrays.toString(encrypted));

            // logs the length of array 'Encrypted' to the logcat under log level debug
            Log.d("Viginere_Util", "Encrypted value: " + Encrypted.length);

            // converts the numerical values from array 'encrypted' to string values
            // for use in the array 'Encrypted'
            for (int j = 0; j < text_length; j++) {

                    Encrypted[j] = Alphabet[encrypted[j]];

            }

            // converts the values from array 'Encrypted' to string 'OutputStream'
        String outputStream = Arrays.toString(Encrypted);
            // removes all commas from the String
            outputStream = outputStream.substring(1, outputStream.length() - 1).replaceAll(",","");

        // logs any exception that were detected to the logcat under log level error
        } catch (Exception e) {
            Log.e("Viginere_Util", "Encryption catch: " + e);
        }

        // converts the values from array 'key' to string 'KeyOutput'
        String KeyOutput = Arrays.toString(SKey);
        // removes all commas from the String
        KeyOutput = KeyOutput.substring(1, KeyOutput.length()-1).replaceAll(",","");

        // logs the value of String array 'SKey' to the logcat under log level debug
        Log.d("Viginere_Util", "SKey value: " + KeyOutput);

        // logs the value of String 'OutputStream' to the logcat under log level debug
        Log.d("Viginere_Util", "OutputStream: " + outputStream);

        String[] Ret = new String[3]; // declares the array 'Return'

        Ret[1] = outputStream; // sets the array element 1 to the value of OutputStream
        Ret[2] = KeyOutput; // sets the array element 2 to the value of KeyOutput

        loop = loop + 1; // sets the value of 'loop' to the value of 'loop' + 1

        //logs the value of integer 'loop' to the logcat under log level debug
        Log.d("Viginere_Util", "loop value: " + loop);

        return Ret; // returns the encrypted String
    }
}
