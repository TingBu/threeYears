package utils;

import java.util.StringJoiner;

/**
 * @author xiams
 * @version 1.0
 * @date 2022/1/31 15:42
 * @email 15555470513@163.com
 */

public class SmallUtil {

    /**
     * 睡眠
     *
     * @param mills
     */
    public static void sleepMills(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printTimesAndThreadName(String tag) {
        String result = new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(tag)
                .toString();
        System.out.println(result);
    }
}
