package ru.mrchebik.utils;

/**
 * Created by mrchebik on 7/16/17.
 */
public class DateInputUtils {
    public static int[] createIndexes(String[] types) {
        int[] indexes = new int[3];
        for (int i = 0; i < 3; i++) {
            if (types[i].equals("mm")) {
                indexes[0] = i;
            }
            if (types[i].equals("dd")) {
                indexes[1] = i;
            }
            if (types[i].equals("yyyy")) {
                indexes[2] = i;
            }
        }
        return indexes;
    }

    public static String[] splitPeriod(String period) {
        if (period.contains("/")) {
            return period.split("/");
        } else if (period.contains(".")) {
            return period.split(".");
        }

        throw new NumberFormatException("DATE must to deliver by '/' or '.'");
    }

    public static String[] splitType(String type) {
        if (type.contains("/")) {
            checkColOfDelivers(type, '/');

            return type.split("/");
        } else if (type.contains(".")) {
            checkColOfDelivers(type, '.');

            return type.split(".");
        }

        throw new NumberFormatException("Check your TYPE. That must to deliver by '/' or '.'");
    }

    private static void checkColOfDelivers(String type, char symbol) {
        int col = 0;
        for (int i = 0; i < type.length(); i++) {
            if (type.charAt(i) == symbol) {
                col++;
            }
        }
        if (col != 2) {
            throw new NumberFormatException("TYPE must contains 2 symbols of '" + symbol + "'");
        }
    }
}
