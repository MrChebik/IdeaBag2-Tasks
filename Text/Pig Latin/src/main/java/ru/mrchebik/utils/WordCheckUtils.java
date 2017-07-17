package ru.mrchebik.utils;

/**
 * Created by mrchebik on 7/17/17.
 */
public class WordCheckUtils {
    public static final String SYMBOL_BEGIN  = "begin";
    public static final String SYMBOL_END    = "end";
    public static final String SYMBOL_PAIR_0 = "pair0";
    public static final String SYMBOL_PAIR_1 = "pair1";

    public static final String CLUSTER_3 = "cluster3";
    public static final String CLUSTER_2 = "cluster2";

    public final String[] consonantClusters3 = new String[] {
            "sch", "str", "scr", "spl", "squ", "thr", "shr"
    };
    public final String[] consonantClusters2 = new String[] {
            "th", "tr", "dr", "bl", "fl", "sk", "st", "sw", "sn", "sm", "wh", "pr", "cl", "pr", "sh", "tw", "wr", "cr",
            "pl", "fr", "gr", "sc"
    };

    public final char[] vowels       = new char[] {'a', 'e', 'i', 'u', 'y', 'o'};
    public final char[] symbolsBegin = new char[] {'#', '$', '%'};
    public final char[] symbolsEnd   = new char[] {'.', ',', '?', '!'};
    public final char[] symbolsPair0 = new char[] {'(', '{', '[', '<', '"', '\''};
    public final char[] symbolsPair1 = new char[] {')', '}', ']', '>', '"', '\''};

    public String checkToConsonantClusters(String line, String type) {
        for (String consonantCluster : type.equals(CLUSTER_2) ? consonantClusters2 : consonantClusters3) {
            if (line.equalsIgnoreCase(consonantCluster)) {
                return consonantCluster;
            }
        }

        return null;
    }

    public boolean checkToSymbols(char letter, String type) {
        char[] checkedArray = type.equals(SYMBOL_BEGIN) ? symbolsBegin :
                type.equals(SYMBOL_END) ? symbolsEnd :
                        type.equals(SYMBOL_PAIR_0) ? symbolsPair0 : symbolsPair1;

        for (char symbol : checkedArray) {
            if (symbol == letter) {
                return true;
            }
        }

        return false;
    }

    public boolean checkToVowels(char letter) {
        char lowerCase = Character.toLowerCase(letter);
        for (char vowel : vowels) {
            if (vowel == lowerCase) {
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
