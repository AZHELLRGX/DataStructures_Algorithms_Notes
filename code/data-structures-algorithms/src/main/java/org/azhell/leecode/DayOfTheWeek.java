package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1185. 一周中的第几天
 * 直接上蔡勒公式了，不去模拟了，尬
 * https://zh.wikipedia.org/wiki/%E8%94%A1%E5%8B%92%E5%85%AC%E5%BC%8F
 */
public class DayOfTheWeek {
    public static void main(String[] args) {
        DayOfTheWeek d = new DayOfTheWeek();
        Utils.print(d.dayOfTheWeek(31, 8, 2019));
        Utils.print(d.dayOfTheWeek(18, 7, 1999));
        Utils.print(d.dayOfTheWeek(15, 8, 1993));
        Utils.print(d.dayOfTheWeek(29, 2, 2016));
        Utils.print(d.dayOfTheWeek(7, 3, 2003));
    }

    public String dayOfTheWeek(int day, int month, int year) {
        //m的取值范围为3至14，即在蔡勒公式中，某年的1、2月要看作上一年的13、14月来计算，比如2003年1月1日要看作2002年的13月1日来计算
        if (month < 3) {
            month += 12;
            // 年份减1
            year -= 1;
        }
        // 默认年份只有4位数(力扣：给出的日期一定是在 1971 到 2100 年之间的有效日期。)
        int c = year / 100;
        int y = year % 100;
        String[] week = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int w = (y + y / 4 + c / 4 - 2 * c + 2 * month + 3 * (month + 1) / 5 + day + 1) % 7;
        // 可能为负数，所以当出现负数的情况下不能直接mod 7
        if (w < 0) {
            w = (w + 7) % 7;
        }
        return week[w];
    }
}
