package com.example.demo.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private final static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    private DateUtils() {

    }

    /** 日期格式 **/
    public interface DATE_PATTERN {
        String YYYY = "yyyy";
        String MM = "MM";
        String DD = "dd";
        String HHMMSS = "HHmmss";
        String HH_MM_SS = "HH:mm:ss";
        String YYYYMMDD = "yyyyMMdd";
        String YYYYMM = "yyyyMM";
        String YYYY_MM_DD = "yyyy-MM-dd";
        String YYYY_MM = "yyyy-MM";
        String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
        String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
        String yyyyMMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
    }

    /**
     * 将Date类型转换成String类型
     *
     * @param date
     *            Date对象
     * @return 形如:"yyyy-MM-dd HH:mm:ss"
     */
    public static String date2String(Date date) {
        return date2String(date, DATE_PATTERN.YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * @Description: 将string类型的日期按某种格式转化成新的string类型日期
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String date2String(String date, String pattern) {
        Timestamp newDate = Timestamp.valueOf(date);
        return date2String(newDate, pattern);
    }

    /**
     * 获取当前年 的字符串形式：YYYY
     *
     * @return
     */
    public static String getCurrentTimeYY() {
        Format format = new SimpleDateFormat(DATE_PATTERN.YYYY);
        String temp = format.format(new Date());

        return temp;
    }

    /**
     * 将Date按格式转化成String
     *
     * @param date
     *            Date对象
     * @param pattern
     *            日期类型
     * @return String
     */
    public static String date2String(Date date, String pattern) {
        if (date == null || pattern == null){
            return null;
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 去掉时间秒后的小数点
     *
     * @param dateTime
     * @return
     */

    public static String abandonDatePoint(String dateTime) {
        String dateTimeTemp =dateTime;
        if (verifyIsNotNull(dateTimeTemp) && dateTimeTemp.indexOf(".") != -1) {
            dateTimeTemp = dateTimeTemp.substring(0, dateTimeTemp.indexOf("."));
        }
        return dateTimeTemp;

    }

    /**
     * 获取当前时间的字符串形式：YYYY-MM-DD HH24:mi:ss
     *
     * @return
     */
    public static String getCurrentTimeStr() {
        return abandonDatePointByTimestamp(getCurrentTimestamp());
    }

    /**
     * 去掉时间秒后的小数点
     *
     * @param dateTime
     * @return
     */

    public static String abandonDatePointByTimestamp(Timestamp dateTime) {
        String dateTimeTemp = String.valueOf(dateTime);
        if (verifyIsNotNull(dateTimeTemp) && dateTimeTemp.indexOf(".") != -1) {
            dateTimeTemp = dateTimeTemp.substring(0, dateTimeTemp.indexOf("."));
        }
        return dateTimeTemp;

    }

    /**
     * 校验字符串为""或null或"null"
     *
     * @param sourceValue
     * @return
     */
    public static boolean verifyIsNotNull(String sourceValue) {
        if (StringUtils.isNotBlank(sourceValue) && !("null".equals(sourceValue))) {
            return true;
        }
        return false;
    }

    // 获取当前时间
    public static Timestamp getCurrentTimestamp() {
        Format format = new SimpleDateFormat(DATE_PATTERN.YYYY_MM_DD_HH_MM_SS);
        String temp = format.format(new Date());
        Timestamp time = Timestamp.valueOf(temp);
        return time;
    }

    // 获取当前时间
    public static String getYYYYMMDDHHMISS() {
        Format format = new SimpleDateFormat(DATE_PATTERN.YYYYMMDDHHMMSS);
        String temp = format.format(new Date());
        return temp;
    }

    /**
     * 将String日期转换成YYYY_MM_DD
     *
     * @param date
     *            Date对象
     * @return
     */
    public static Date string2YYYMMDD(String date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN.YYYY_MM_DD);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将String类型转换成类型
     *
     * @param date
     *            Date对象
     * @return
     */
    public static Date string2Date(String date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN.YYYY_MM_DD_HH_MM_SS);
        try {
            return format.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * stringToDate
     * @param date
     * @param datePattern
     * @return
     */
    public static Date stringToDate(String date,String datePattern) {
        SimpleDateFormat format = new SimpleDateFormat(datePattern);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将String类型转换成Date类型
     * @param date
     * Date对象
     * @return
     */
    public static Date string2DateH(String date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN.HH_MM_SS);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将String类型转换成String类型
     * YYYY_MM_DD 转为yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String string2String(String date,String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            Date newDate=format.parse(date);
            return date2String(newDate, DATE_PATTERN.YYYY_MM_DD_HH_MM_SS);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 增加或减去指定月数
     * @param timestamp 时间
     * @param month 指定的月数量
     * @return
     */
    public static Timestamp addOrMinusMonth(Timestamp timestamp, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(timestamp);
        cal.add(Calendar.MONTH, month);
        return new Timestamp(cal.getTimeInMillis());
    }

    /**
     * @Description: 增加或减去指定天数
     *
     * @param date	指定时间
     * @param day	指定的天数 正值加  负值减
     * @return
     */
    public static Date addOrMinusDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    /**
     * @Description: 增加或减去指定小时数
     *
     * @param date
     * @param hour
     * @return
     */
    public static Date getAddOrMinusHours(Date date , int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);// 24小时制
        return cal.getTime();
    }

    /**
     * @Description: 增加或减去指定小时数
     *
     * @param timestamp
     * @param hour
     * @return
     */
    public static Timestamp addOrMinusHours(Timestamp timestamp, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(timestamp);
        cal.add(Calendar.HOUR, hour);
        return new Timestamp(cal.getTimeInMillis());
    }

    /**
     * @Description: 增加或减去指定分钟
     *
     * @param date
     * @param minute
     * @return
     */
    public static Date addOrMinusMinutes(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

//    public static long getNowTimeSeconds(){
//        String time = DateUtils.date2String(new Date(), DateUtil.DATE_PATTERN.HH_MM_SS);
//        String[] timeArray = time.split(":");
//        long s = Integer.parseInt(timeArray[0]) * 3600L;    //小时
//        s += Integer.parseInt(timeArray[0]) * 60;    //分钟
//        s += Integer.parseInt(timeArray[0]);    //秒
//        return s;
//    }

    /**
     * @Description: 获得小时
     * @return
     */
    public static long getNowTimeH(Date date){
        String time = DateUtils.date2String(date, DateUtil.DATE_PATTERN.HH_MM_SS);
        String[] timeArray = time.split(":");
        long s = Integer.parseInt(timeArray[0]);    //小时
        return s;
    }

    /**
     * @Description: 增加或减去指定秒数
     *
     * @param date	指定时间
     * @param seconds	指定的秒数 正值加  负值减
     * @return
     */
    public static String addOrMinusSeconds(Date date, int seconds,String pattern ) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        Date addOrMinusDate = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String appointTime = sdf.format(addOrMinusDate);
        return appointTime;
    }

    /**
     * 增加或减去指定秒
     * @param date
     * @param second
     * @return
     */
    public static Timestamp addOrMinusSeconds(Date date, int second) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, second);
        return new Timestamp(cal.getTimeInMillis());
    }

    /**
     * @Description: 获取月初时间  yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static Timestamp getMonthStartTime(Date date) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, 1);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN.YYYY_MM_DD);
        Date now = simpleDateFormat.parse(simpleDateFormat.format(calendar.getTime()));
        return new Timestamp(now.getTime());
    }

    /**
     * @Description: 获取月末时间  yyyy-MM-dd HH:mm:ss
     *
     * @param timestamp
     * @return
     * @throws Exception
     */
    public static Timestamp getMonthEndTime(Timestamp timestamp) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN.YYYY_MM_DD);
        String date = simpleDateFormat.format(calendar.getTime())+" 23:59:59";
        return Timestamp.valueOf(date);
    }

    /**
     * 获取当前时间毫秒
     * @return
     */
    public static Long currentTimeMillis(){
        return System.currentTimeMillis();
    }

    /**
     * 两个时间只差
     * @param startDate
     * @param endDate
     * @return 秒数
     */
    public static long getBetweenSecond(Date startDate, Date endDate) {
        long seconds = 0L;
        try {
            if(startDate!=null&&endDate!=null) {
                long ss = 0L;
                if(startDate.before(endDate)) {
                    ss = endDate.getTime() - startDate.getTime();
                }else {
                    ss = startDate.getTime() - endDate.getTime();
                }
                seconds = ss/(Constants.THOUSAND) ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seconds;
    }

}
