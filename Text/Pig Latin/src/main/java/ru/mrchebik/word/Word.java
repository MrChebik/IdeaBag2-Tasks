package ru.mrchebik.word;

import ru.mrchebik.utils.WordUtils;

import java.util.Stack;

/**
 * Created by mrchebik on 7/17/17.
 */
public class Word extends WordUtils {
    public String transformToPigLatin(String line) {
        String[] words = line.trim().split(" ");
        int indexOfNumbers = 0;

        String           bufferBegin;
        Stack<Character> bufferEnd = new Stack<>();

        for (int i = 0; i < words.length; i++) {
            bufferBegin = "";

            char firstChar = words[i].charAt(0);
            char lastChar = words[i].charAt(words[i].length() - 1);

            if (checkToSymbols(firstChar, SYMBOL_PAIR_0) && checkToSymbols(lastChar, SYMBOL_PAIR_1)) {
                bufferBegin += firstChar;
                bufferEnd.add(lastChar);

                words[i]  = words[i].substring(1, words[i].length() - 1);
                firstChar = words[i].charAt(0);
                lastChar  = words[i].charAt(words[i].length() - 1);
            }

            if (checkToSymbols(firstChar, SYMBOL_BEGIN)) {
                bufferBegin += firstChar;

                words[i] = words[i].substring(1);
            }

            if (checkToSymbols(lastChar, SYMBOL_END)) {
                bufferEnd.add(lastChar);

                words[i] = words[i].substring(0, words[i].length() - 1);
            }

            if (checkToVowels(words[i].charAt(0))) {
                words[i] = transformVowels(words[i]);
            } else if (checkToNumbers(words[i].charAt(0))) {
                indexOfNumbers++;
            } else {
                words[i] = transformConsonants(words[i]);
            }

            if (!"".equals(bufferBegin)) {
                words[i] = bufferBegin + words[i];
            }

            if (!bufferEnd.isEmpty()) {
                StringBuilder newLine = new StringBuilder(words[i]);
                while (!bufferEnd.isEmpty()) {
                    newLine.append(bufferEnd.pop());
                }

                words[i] = newLine.toString();
            }
        }

        if (indexOfNumbers == words.length) {
            return "Translation error! Numbers is not supported!\n" + line;
        }

        return merge(words);
    }

    public String merge(String[] words) {
        StringBuilder newLine = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            newLine.append(words[i]);

            if (i != words.length - 1) {
                newLine.append(" ");
            }
        }

        return newLine.toString();
    }
}
