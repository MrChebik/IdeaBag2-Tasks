package ru.mrchebik;

import ru.mrchebik.date.Date;
import ru.mrchebik.date.DayOfWeek;
import ru.mrchebik.date.Period;

import java.util.List;
import java.util.Scanner;

/**
 * Created by mrchebik on 7/16/17.
 */
public class Main {
    public static void main(String[] args) {
        List<String> dates;
        Date customDate = new Date();
        DayOfWeek dayOfWeek = new DayOfWeek("Friday", 13);

        System.out.println("Input:");
        String input = new Scanner(System.in).nextLine();

        int year = -1;
        try {
            year = Integer.parseInt(input);
        } catch (NumberFormatException ignored) {
        }

        if (year != -1) {
            dates = customDate.getCountDayOfPeriod(dayOfWeek,
                    new Period(1, 1, year),
                    new Period(12, 31, year));
        } else {
            String[] datesFromInput = input.split("-");
            if (datesFromInput[1].contains("(")) {
                String[] periodAndType = datesFromInput[1].trim().split(" ");
                String type = periodAndType[1].substring(1, periodAndType[1].length() - 1);
                dates = customDate.getCountDayOfPeriod(dayOfWeek,
                        new Period(datesFromInput[0].trim(), type),
                        new Period(periodAndType[0].trim(), type));
            } else {
                dates = customDate.getCountDayOfPeriod(dayOfWeek,
                        new Period(datesFromInput[0].trim()),
                        new Period(datesFromInput[1].trim()));
            }
        }

        System.out.println("\nOutput:");
        if (dates.size() > 0) {
            for (String date : dates) {
                System.out.println(date);
            }
        } else {
            System.out.println("None");
        }
    }
}
