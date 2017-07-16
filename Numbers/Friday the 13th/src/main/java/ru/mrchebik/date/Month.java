package ru.mrchebik.date;

import ru.mrchebik.utils.DateCheckUtils;
import ru.mrchebik.utils.DateUtils;

/**
 * Created by mrchebik on 7/16/17.
 */
public class Month {
    private String name;
    private int days;

    public Month(String name, int days) {
        this.name = DateCheckUtils.checkMonth(name);
        this.days = DateCheckUtils.checkDay(days);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
