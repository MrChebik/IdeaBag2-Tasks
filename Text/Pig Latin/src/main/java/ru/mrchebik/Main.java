package ru.mrchebik;

import ru.mrchebik.word.Word;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Word word = new Word();

        System.out.println("Input:");
        System.out.println("\nOutput:\n" + word.transformToPigLatin(new Scanner(System.in).nextLine()));
    }
}
