package xhj.love.tyj.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 徐浩军 xhj X6241
 * @date 2020/7/24 15:43
 * @description
 */
public class DateUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 减去指定的天数，拿到yyyyMMdd类型的日期
     *
     * @param minusNum  待减天数
     * @return  处理后的时间
     */
    public static String minusTime(int minusNum){
        LocalDate minusDays = LocalDate.now().minusDays((long) minusNum);
        return minusDays.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    /**
     * 减去指定的天数，拿到yyyy-MM-dd类型的日期
     *
     * @param minusNum  待减天数
     * @return  处理后的时间
     */
    public static String minusTimeExtra(int minusNum){
        LocalDate minusDays = LocalDate.now().minusDays((long) minusNum);
        return minusDays.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * 根据指定格式的日期字符串获取LocalDateTime
     * @param dateTime 日期字符串
     * @param pattern 格式
     * @return LocalDateTime
     */
    public static LocalDateTime str2Ldt(String dateTime, String pattern){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateTime, dateTimeFormatter);
    }

    /**
     * 把yyyyMMdd格式的字符串变为yyyy-MM-dd HH:mm:ss样式的字符串
     * @param date 日期
     * @return 日期时间
     */
    public static String date2dateTime(String date){
        try {
            StringBuffer dateTime = new StringBuffer();
            String year = date.substring(0, 4);
            String month = date.substring(4, 6);
            String day = date.substring(6);
            dateTime.append(year).append("-").append(month).append("-").append(day).append(" 00:00:00");
            return dateTime.toString();
        } catch (Exception e) {
            LOGGER.error("{}日期转换发生异常：{}", date, e.getMessage());
            return "1949-10-01 00:00:00";
        }
    }

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
