package ru.mrchebik.utils;

public class WordUtils extends WordCheckUtils {
    protected String transformVowels(String word) {
        return word + "ay";
    }

    protected String transformConsonants(String word) {
        String beginWord = "";
        String endWord = "";

        for (int i = 1; i < word.length(); i++) {
            if (checkToVowels(word.charAt(i))) {
                beginWord = word.substring(i);
                endWord = word.substring(0, i);

                if (Character.isUpperCase(endWord.charAt(0))) {
                    beginWord = Character.toUpperCase(beginWord.charAt(0)) + beginWord.substring(1);
                    endWord = Character.toLowerCase(endWord.charAt(0)) + endWord.substring(1);
                }

                break;
            }
        }

        if (beginWord.equals("")) {
            return word + "ay";
        }

        return beginWord + endWord + "ay";
    }
}
