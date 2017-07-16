package ru.mrchebik;

import org.junit.BeforeClass;
import org.junit.Test;

import ru.mrchebik.date.Date;
import ru.mrchebik.date.DayOfWeek;
import ru.mrchebik.date.Period;

import static org.junit.Assert.*;

/**
 * Created by mrchebik on 7/16/17.
 */
public class TestTask {
    private static Date date;
    private static DayOfWeek dayOfWeek;

    @BeforeClass
    public static void before() {
        date = new Date();
        dayOfWeek = new DayOfWeek("Friday", 13);
    }

    @Test
    public void testInput2017() {
        assertArrayEquals(new String[] {"January 13, 2017", "October 13, 2017"},
                date.getCountDayOfPeriod(dayOfWeek, new Period(1, 1, 2017), new Period(12, 31, 2017)).toArray());
    }

    @Test
    public void testInputPeriod() {
        assertArrayEquals(new String[] {"October 13, 2017", "April 13, 2018", "July 13, 2018"},
                date.getCountDayOfPeriod(dayOfWeek, new Period(4, 14, 2017), new Period(7, 14, 2018)).toArray());
    }
}