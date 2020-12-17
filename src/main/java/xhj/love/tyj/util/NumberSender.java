package xhj.love.tyj.util;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

/**
 * @author 徐浩军 xhj X6241
 * @date 2020/9/26 17:51
 * @description 发号器
 */
public class NumberSender {
    /**
     * 0-9999
     */
    private static int count = 1;

    /**
     * 记录上次获取编码的时间
     */
    private static String oldTime = null;

    /**
     * 获取全局唯一的编码
     * @param moduleName 模块简称
     * @return
     */
    synchronized public static String getCode(String moduleName){
        StringBuffer result = new StringBuffer(moduleName.toUpperCase());

        //获取当前的时间
        String now = getDateTime(LocalDateTime.now());

        //判断是否需要重新计数
        boolean isInit;

        if(oldTime == null || !oldTime.equals(now)) {
            isInit = true;
            oldTime = now;
        } else {
            isInit = false;
        }

        //格式化时间信息
        result.append(now);

        DecimalFormat decimalFormat2 = new DecimalFormat("0000");

        //计数
        count++;
        if(count > 9999 || isInit == true) {
            count = 1;
        }
        result.append(decimalFormat2.format(count));

        return result.toString();
    }

    /**
     * 把LocalDateTime转成字符串(格式化)
     * @param dateTime 日期
     * @return
     */
    private static String getDateTime(LocalDateTime dateTime){
        StringBuffer result = new StringBuffer();
        DecimalFormat decimalFormat = new DecimalFormat("00");
        result.append(dateTime.getYear())
                .append(decimalFormat.format(dateTime.getMonthValue()))
                .append(decimalFormat.format(dateTime.getDayOfMonth()))
                .append(decimalFormat.format(dateTime.getHour()))
                .append(decimalFormat.format(dateTime.getMinute()))
                .append(decimalFormat.format(dateTime.getSecond()));
        return result.toString();
    }
}
