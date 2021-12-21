package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1154. 一年中的第几天
 */
public class DayOfTheYear {
    public static void main(String[] args) {
        DayOfTheYear d = new DayOfTheYear();
        Utils.print(d.dayOfYear("2019-01-09"));
        Utils.print(d.dayOfYear("2019-02-10"));
        Utils.print(d.dayOfYear("2003-03-01"));
        Utils.print(d.dayOfYear("2004-03-01"));
        Utils.print(d.dayOfYear("2000-12-04"));
    }

    public int dayOfYear(String date) {
        String[] times = date.split("-");
        int[] a = new int[]{31, isLeapYear(Integer.parseInt(times[0])) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        final int month = Integer.parseInt(times[1]);
        int day = Integer.parseInt(times[2]);
        for (int i = 0; i < month - 1; i++) {
            day += a[i];
        }
        return day;
    }

    public boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
