package com.example.demo.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtil {
	
	private final static Log logger = LogFactory.getLog(DateUtil.class);

    /** 日期格式 **/
    public interface DATE_PATTERN {
        String YYYY = "yyyy";
        String MM = "MM";
        String DD = "dd";
        String HHMMSS = "HHmmss";
        String HH_MM_SS = "HH:mm:ss";
        String YYYYMMDD = "yyyyMMdd";
        String YYYY_MM_DD = "yyyy-MM-dd";
        String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
        String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
        String yyyyMMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
        String yyyyMMddTHHmmssSSS = "yyyy-MM-dd'T'HH:mm:ss.SSS Z";
    }
    /**
     * 将String类型转换成Date对象
     */
    public static Date stringToDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN.YYYY_MM_DD_HH_MM_SS);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    /**
     * 将String类型转换成Date对象
     */
    public static Date stringToDate(String date,String datePattern) {
        String dateStr=null;
        if(StringUtils.isNotBlank(date)){
            dateStr = date.replace("Z", " UTC");//注意是空格+UTC
        }
        SimpleDateFormat format = new SimpleDateFormat(datePattern);
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
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
     * @author baitao
     * @date 2019-9-17
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
     * @author baitao
     * @date 2019-9-17
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

    public static String dateToString(Date date, String pattern) {
        if (date == null || pattern == null){
            return null;
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * @Description: 增加或减去指定小时数
     */
    public static Timestamp addOrMinusHours(Timestamp timestamp, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(timestamp);
        cal.add(Calendar.HOUR, hour);
        return new Timestamp(cal.getTimeInMillis());
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
	 * @Description: 增加或减去指定天数
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
     * @Description: 增加或减去指定年
     * @param year	指定时间
     * @param year	指定的年 正值加  负值减
     * @return
     */
    public static Date addOrMinusYear(Date date, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }
	
	/**
	 * @Description: 获取一天的开始时间  yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static Timestamp getDayStartTime(Date date,int day) throws Exception {
		try{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, day);
			calendar.set(Calendar.HOUR_OF_DAY, Constants.HOUR_OF_DAY_0);
			calendar.set(Calendar.MINUTE, Constants.HOUR_OF_DAY_0);
			calendar.set(Calendar.SECOND, Constants.HOUR_OF_DAY_0);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN.YYYY_MM_DD_HH_MM_SS);
			Date now = simpleDateFormat.parse(simpleDateFormat.format(calendar.getTime()));
			return new Timestamp(now.getTime());
		} catch(Exception e){
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * @Description: 获取一天的结束时间  yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static Timestamp getDayEndTime(Date date,int day) throws Exception {
		try{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, day);
			calendar.set(Calendar.HOUR_OF_DAY, Constants.HOUR_OF_DAY_23);
			calendar.set(Calendar.MINUTE, Constants.MINUTE);
			calendar.set(Calendar.SECOND, Constants.MINUTE);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN.YYYY_MM_DD_HH_MM_SS);
			Date now = simpleDateFormat.parse(simpleDateFormat.format(calendar.getTime()));
			return new Timestamp(now.getTime());
		} catch(Exception e){
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage());
		}
	}

    /**
     * 获取当天0点0分0秒（00:00:00）
     *
     * @return
     */
    public static String getTimesmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Date beginOfDate = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(beginOfDate);
    }
}
