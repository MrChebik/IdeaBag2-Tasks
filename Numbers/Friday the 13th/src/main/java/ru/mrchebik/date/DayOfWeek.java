package ru.mrchebik.date;

import ru.mrchebik.utils.DateCheckUtils;
import ru.mrchebik.utils.DateUtils;

/**
 * Created by mrchebik on 7/16/17.
 */
public class DayOfWeek {
    private String dayOfWeek;
    private int number;

    public DayOfWeek(String dayOfWeek, int number) {
        this.dayOfWeek = DateCheckUtils.checkDayOfWeek(dayOfWeek);
        this.number    = DateCheckUtils.checkDay(number);
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
