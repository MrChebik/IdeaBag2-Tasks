package ru.mrchebik.utils;

public class WordUtils extends WordCheckUtils {
    private String beginWord;
    private String endWord;

    protected String transformVowels(String word) {
        beginWord = "";
        endWord = "";

        String cluster;
        for (int i = 1; i < word.length(); i++) {
            if (!checkToVowels(word.charAt(i))) {
                if ((cluster = checkToConsonantClusters(word.substring(i, i + 3))) != null) {
                    cutWord(word, i + cluster.length());
                } else {
                    cutWord(word, i + 1);
                }

                break;
            }
        }
        return beginWord + endWord + "ay";
    }

    protected String transformConsonants(String word) {
        beginWord = "";
        endWord = "";

        String cluster;
        if (word.length() > 2 && (cluster = checkToConsonantClusters(word.substring(0, 3))) != null) {
            cutWord(word, cluster.length());
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (checkToVowels(word.charAt(i))) {
                    cutWord(word, i);

                    break;
                }
            }

            if (beginWord.equals("")) {
                return word + "ay";
            }
        }

        return beginWord + endWord + "ay";
    }

    private void cutWord(String word,
                         int length) {
        beginWord = word.substring(length);
        endWord = word.substring(0, length);

        if (Character.isUpperCase(endWord.charAt(0))) {
            beginWord = Character.toUpperCase(beginWord.charAt(0)) + beginWord.substring(1);
            endWord = Character.toLowerCase(endWord.charAt(0)) + endWord.substring(1);
        }
    }
}
