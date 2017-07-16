package ru.mrchebik.date;

import ru.mrchebik.utils.DateCheckUtils;
import ru.mrchebik.utils.DateInputUtils;

/**
 * Created by mrchebik on 7/16/17.
 */
public class Period {
    private int month;
    private int day;
    private int year;
    
    public Period(int month, int day, int year) {
        this.month = month;
        this.day   = day;
        this.year  = year;
    }

    public Period(String period) {
        String[] values = DateInputUtils.splitPeriod(period);

        this.month = DateCheckUtils.checkMonth(Integer.parseInt(values[0]));
        this.day   = DateCheckUtils.checkDay(Integer.parseInt(values[1]));
        this.year  = DateCheckUtils.checkYear(Integer.parseInt(values[2]));
    }

    public Period(String period, String type) {
        if (!type.contains("mm") || !type.contains("dd") || !type.contains("yyyy")) {
            throw new NumberFormatException("TYPE must contains 'mm', 'dd' and 'yyyy'");
        }

        int[] indexes = DateInputUtils.createIndexes(DateInputUtils.splitType(type));
        String[] values = DateInputUtils.splitPeriod(period);

        this.month = DateCheckUtils.checkMonth(Integer.parseInt(values[indexes[0]]));
        this.day   = DateCheckUtils.checkDay(Integer.parseInt(values[indexes[1]]));
        this.year  = DateCheckUtils.checkYear(Integer.parseInt(values[indexes[2]]));
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
