package ru.mrchebik.date;

import ru.mrchebik.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrchebik on 7/16/17.
 */
public class Date extends DateUtils {
    public String getCountDayOfMonth(DayOfWeek dayOfWeek,
                                     Period start,
                                     Period end) {
        int month = start.getMonth();
        int year = start.getYear();

        int indexOfDay = getIndexOfDay(month, year);
        String currentDayOfWeek = DateUtils.DAYS_OF_WEEK[indexOfDay];
        for (int i = start.getDay(); i < (end.getDay() == 31 ? (DateUtils.MONTHS_AND_DAYS[month].getDays() + 1 + (month == 1 ? year % 4 == 0 ? 1 : 0 : 0)) : end.getDay()); i++) {
            if (i == dayOfWeek.getNumber() && currentDayOfWeek.equals(dayOfWeek.getDayOfWeek())) {
                return DateUtils.MONTHS_AND_DAYS[month].getName() + " " + dayOfWeek.getNumber() + ", " + year;
            }
            currentDayOfWeek = DateUtils.DAYS_OF_WEEK[indexOfDay == 6 ? indexOfDay = 0 : ++indexOfDay];
        }

        return null;
    }

    public List<String> getCountDayOfPeriod(DayOfWeek dayOfWeek,
                                            Period start,
                                            Period end) {
        List<String> dates = new ArrayList<>();
        if (start.getYear() == end.getYear()) {
            return doAround(dayOfWeek, start.getMonth() - 1, end.getMonth(), start.getDay(), end.getDay(), start.getYear(), true, true);
        } else {
            dates.addAll(doAround(dayOfWeek, start.getMonth() - 1, 12, start.getDay(), 31, start.getYear(), true, false));
            for (int year = start.getYear() + 1; year < end.getYear() + 1; year++) {
                if (year == end.getYear()) {
                    dates.addAll(doAround(dayOfWeek, 1, end.getMonth(), 1, end.getDay(), year, false, true));
                } else {
                    dates.addAll(doAround(dayOfWeek, 1, 12, 1, 31, year, false, false));
                }
            }
        }

        return dates;
    }

    private List<String> doAround(DayOfWeek dayOfWeek,
                                  int startMonth,
                                  int endMonth,
                                  int startDay,
                                  int endDay,
                                  int year,
                                  boolean checkStart,
                                  boolean checkEnd) {
        List<String> listOfDate = new ArrayList<>();

        for (int month = startMonth; month < endMonth; month++) {
            String date;
            if ((date = getCountDayOfMonth(dayOfWeek,
                    new Period(month,
                            checkStart ? month == startMonth ? startDay : 1 : 1,
                            year),
                    new Period(month,
                            checkEnd ? month == endMonth - 1 ? endDay : 31 : 31,
                            year))) != null) {
                listOfDate.add(date);
            }
        }

        return listOfDate;
    }
}
