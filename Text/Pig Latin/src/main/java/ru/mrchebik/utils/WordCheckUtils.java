package ru.mrchebik.utils;

/**
 * Created by mrchebik on 7/17/17.
 */
public class WordCheckUtils {
    public static final String SYMBOL_BEGIN  = "begin";
    public static final String SYMBOL_END    = "end";
    public static final String SYMBOL_PAIR_0 = "pair0";
    public static final String SYMBOL_PAIR_1 = "pair1";

    public final char[] vowels       = new char[] {'a', 'e', 'i', 'u', 'y', 'o'};
    public final char[] symbolsBegin = new char[] {'#', '$', '%'};
    public final char[] symbolsEnd   = new char[] {'.', ',', '?', '!'};
    public final char[] symbolsPair0 = new char[] {'(', '{', '[', '<', '"', '\''};
    public final char[] symbolsPair1 = new char[] {')', '}', ']', '>', '"', '\''};

    public boolean checkToSymbols(char letter, String type) {
        char[] checkedArray = type.equals("begin") ? symbolsBegin :
                type.equals("end") ? symbolsEnd :
                        type.equals("pair0") ? symbolsPair0 : symbolsPair1;

        for (char symbol : checkedArray) {
            if (symbol == letter) {
                return true;
            }
        }

        return false;
    }

    public boolean checkToVowels(char letter) {
        for (char vowel : vowels) {
            if (vowel == letter) {
                return true;
            }
        }

        return false;
    }

    public boolean checkToNumbers(char letter) {
        for (int i = 0; i < 9; i++) {
            if (((char) 48 + i) == letter) {
                return true;
            }
        }

        return false;
    }
}
