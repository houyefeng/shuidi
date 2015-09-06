/**
 * Created by houyefeng on 2015/8/9.
 */
package com.shuidi.utils;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Random;

public class OrderNoUtil {
    private static final String[] YEAR_CODE = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private static final int START_YEAR = 2015;

    public static String generate12() {
        Calendar now = Calendar.getInstance();

        return getBase(now).toString();
    }

    public static String generate16() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);

        StringBuffer no = new StringBuffer(16);
        //将年份转成1个字符
        no.append(YEAR_CODE[year - START_YEAR]);
        //月份用16进制表示
        int month = now.get(Calendar.MONTH);
        no.append(Integer.toHexString(month));
        //以2位表示的日期
        no.append(format(now.get(Calendar.DAY_OF_MONTH)));

        no.append(getBase(now));
        return no.toString();
    }

    private static StringBuffer getBase(Calendar now) {
        long time = now.getTimeInMillis();
        StringBuffer no = new StringBuffer(12);
        //取以秒表示的时间戳的后5位
        no.append(getLast5Chars(getTime(time)));
        //取以以毫秒表示的时间戳的后5位
        no.append(getLast5Chars(time));
        //最后加0-99的随即数
        no.append(getRand0_99());
        return no;
    }

    private static int getTime(long time) {
        return (int) (time / 1000);
    }

    private static String getLast5Chars(long source) {
        String s = String.valueOf(source);
        return s.substring(-5, s.length());
    }

    private static String getRand0_99() {
        Random r = new Random();
        int n = r.nextInt(100);
        return format(n);
    }

    private static String format(int n) {
        NumberFormat format = NumberFormat.getInstance();
        format.setMinimumFractionDigits(0);
        format.setMaximumFractionDigits(0);
        format.setMaximumIntegerDigits(2);
        format.setMinimumIntegerDigits(2);
        return format.format(n);
    }
}
