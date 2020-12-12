package xhj.love.tyj.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Package xhj.love.tyj
 * @Author 徐浩军
 * @Date 2020/7/24 20:26
 * @Version V1.0
 */
public class DateUtil {
    /**
     * 获取当前的时间(yyyy-MM-dd HH:mm:ss)
     * @return
     */
    public static String getCurrentDate(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDate = localDateTime.format(dateTimeFormatter);
        return formatDate;
    }
}
