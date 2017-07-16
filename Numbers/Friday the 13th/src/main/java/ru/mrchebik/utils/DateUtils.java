package ru.mrchebik.utils;

import ru.mrchebik.date.Month;

/**
 * Created by mrchebik on 7/16/17.
 */
public class DateUtils {
    public static final String[] DAYS_OF_WEEK = new String[] {
            "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    };
    public static final String[] MONTHS = new String[] {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
    };
    public static final Month[] MONTHS_AND_DAYS = new Month[]  {
            new Month("January", 31),
            new Month("February", 28),
            new Month("March", 31),
            new Month("April", 30),
            new Month("May", 31),
            new Month("June", 30),
            new Month("July", 31),
            new Month("August", 31),
            new Month("September", 30),
            new Month("October", 31),
            new Month("November", 30),
            new Month("December", 31)
    };

    protected int getIndexOfDay(int month,
                                int year) {
        int indexOfMonth = -1;
        switch (month) {
            case 0 : indexOfMonth = year % 4 != 0 ? 5 : 4; break;
            case 1 : indexOfMonth = year % 4 != 0 ? 1 : 0; break;
            case 2 : indexOfMonth = 1; break;
            case 3 : indexOfMonth = 4; break;
            case 4 : indexOfMonth = 6; break;
            case 5 : indexOfMonth = 2; break;
            case 6 : indexOfMonth = 4; break;
            case 7 : indexOfMonth = 0; break;
            case 8 : indexOfMonth = 3; break;
            case 9 : indexOfMonth = 5; break;
            case 10 :indexOfMonth = 1; break;
            case 11 :indexOfMonth = 3; break;
        }

        return ((int) (year * 1.25 % 7) + indexOfMonth + 1) % 7;
    }
}
