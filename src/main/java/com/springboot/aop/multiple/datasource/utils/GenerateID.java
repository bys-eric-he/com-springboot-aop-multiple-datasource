package com.springboot.aop.multiple.datasource.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成全局ID
 */
public class GenerateID {
    private static byte[] lock = new byte[0];

    // 位数，默认是8位
    private final static long w = 100000000;

    public static String createID() {
        long r = 0;
        synchronized (lock) {
            r = (long) ((Math.random() + 1) * w);
        }

        return System.currentTimeMillis() + String.valueOf(r).substring(1);
    }


    /**
     * 根据传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
     *
     * @param sformat yyyyMMddhhmmss
     * @return
     */
    public static String getDate(String sformat) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(sformat);
        return formatter.format(currentTime);
    }

    public static String getRandomNum(int num) {
        StringBuilder numStr = new StringBuilder();
        for (int i = 0; i < num; i++) {
            numStr.append((int) (10 * (Math.random())));
        }
        return numStr.toString();
    }

    /**
     * 生成id
     *
     * @return
     */
    public static Long getGeneratID() {
        String format = "YYYYMMddhhmmss";
        int num = 3;
        String idStr = getDate(format) + getRandomNum(num);
        return Long.valueOf(idStr);
    }
}
