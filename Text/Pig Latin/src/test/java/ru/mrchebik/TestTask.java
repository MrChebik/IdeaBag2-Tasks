package ru.mrchebik;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.mrchebik.word.Word;

import static org.junit.Assert.assertEquals;

/**
 * Created by mrchebik on 7/17/17.
 */
public class TestTask {
    private static Word word;

    @BeforeClass
    public static void before() {
        word = new Word();
    }

    @Test
    public void testInputBanana() {
        assertEquals("ananabay", word.transformToPigLatin("banana"));
    }

    @Test
    public void testInput123() {
        assertEquals("Translation error! Numbers are not supported!\n123", word.transformToPigLatin("123"));
    }
}
