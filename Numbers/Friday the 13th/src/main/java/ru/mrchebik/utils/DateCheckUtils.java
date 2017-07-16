package ru.mrchebik.utils;

/**
 * Created by mrchebik on 7/16/17.
 */
public class DateCheckUtils {
    public static int checkMonth(int month) {
        if (month < 1) {
            throw new NumberFormatException("MONTH is lesser than 1");
        }
        if (month > 12) {
            throw new NumberFormatException("MONTH is bigger than 12");
        }

        return month;
    }

    public static String checkMonth(String name) {
        for (String month : DateUtils.MONTHS) {
            if (month.equals(name)) {
                return name;
            }
        }

        throw new NumberFormatException("NAME of MONTH is incorrect.");
    }

    public static int checkDay(int day) {
        if (day < 1) {
            throw new NumberFormatException("DAY is lesser than 1");
        }
        if (day > 31) {
            throw new NumberFormatException("DAY is bigger than 31");
        }

        return day;
    }

    public static String checkDayOfWeek(String dayOfWeek) {
        for (String day : DateUtils.DAYS_OF_WEEK) {
            if (day.equals(dayOfWeek)) {
                return dayOfWeek;
            }
        }

        throw new NumberFormatException("NAME of DAY is incorrect.");
    }

    public static int checkYear(int year) {
        if (year < 1) {
            throw new NumberFormatException("YEAR is lesser than 1");
        }

        return year;
    }
}
