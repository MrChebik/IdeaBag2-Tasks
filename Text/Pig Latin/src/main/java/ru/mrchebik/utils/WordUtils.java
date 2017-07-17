package ru.mrchebik.utils;

public class WordUtils extends WordCheckUtils {
    private String beginWord;
    private String endWord;
    private String cluster;

    protected String transformVowels(String word) {
        initialize();

        for (int i = 1; i < word.length(); i++) {
            if (!checkToVowels(word.charAt(i))) {
                if (!isContainCluster(word, i)) {
                    if (word.length() > 2) {
                        cutWord(word, i + 1);
                    } else {
                        cutWord(word, i);
                    }
                }

                break;
            }

            if (beginWord.equals("")) {
                return word + "ay";
            }
        }

        return beginWord + endWord + "ay";
    }

    protected String transformConsonants(String word) {
        initialize();

        if (!isContainCluster(word, 0)) {
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

    private boolean isContainCluster(String word, int length) {
        if (word.length() > length + 3 &&
                (
                        (cluster = checkToConsonantClusters(word.substring(length, length + 3), CLUSTER_3)) != null ||
                        (cluster = checkToConsonantClusters(word.substring(length, length + 2), CLUSTER_2)) != null)
                ) {
                cutWord(word, length + cluster.length());
                return true;
        }

        return false;
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

    private void initialize() {
        beginWord = "";
        endWord = "";
        cluster = "";
    }
}
