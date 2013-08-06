package cn.com.widemex.streetDiscount.shopPlatform.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.com.widemex.framework.logging.WideLogger;
import cn.com.widemex.streetDiscount.shopPlatform.exception.AppException;

public class DateUtil {

	public static final String[] DATE_FORMAT = new String[] {
			"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd" };

	public static final String DATE_SIMPLE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static final String DATE_NO_TIME_FORMAT = "yyyy-MM-dd";
	
	public static final String TIME_FORMAT = "HH:mm:ss";
	
	
	private static final  ThreadLocal<DateFormat> timeZoneFormat =  new ThreadLocal<DateFormat>(){
		@Override
        protected synchronized DateFormat initialValue() {
            return new SimpleDateFormat(DATE_SIMPLE_FORMAT); 
        }
	};
	
	private static final  ThreadLocal<DateFormat> noTimeFormat =  new ThreadLocal<DateFormat>(){
		@Override
        protected synchronized DateFormat initialValue() {
            return new SimpleDateFormat(DATE_NO_TIME_FORMAT); 
        }
	};
	
	private static final  ThreadLocal<DateFormat> timeFormat =  new ThreadLocal<DateFormat>(){
		@Override
        protected synchronized DateFormat initialValue() {
            return new SimpleDateFormat(TIME_FORMAT); 
        }
	};
	
	//private static final SimpleDateFormat noTimeFormat = new SimpleDateFormat(DATE_NO_TIME_FORMAT); 
	
	//private static final SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT); 
	
	private static final WideLogger logger = WideLogger.getLogger(DateUtil.class);

	public static Date getStartOfCurrentDay() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		calendar.set(year, month, day, 0, 0, 0);
		return calendar.getTime();
	}

	public static Date getEndOfCurrentDay() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		calendar.set(year, month, day, 23, 59, 59);
		return calendar.getTime();
	}
	
	public static String getNoTimeDateStr(Date date){
		return noTimeFormat.get().format(date);
	}
	
	public static String getTimeDateStr(Date date){
		return timeFormat.get().format(date);
	}
	
	
	
	public static Date now(){
		return new Date();
	}
	
	public static Date parseDate(String dateStr){
		try {
			return timeZoneFormat.get().parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.error("", e);
			throw new AppException(e.getMessage());
		}
	}
	
	public static Date parseNoTimeDate(String dateStr){
		try {
			return noTimeFormat.get().parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.error("", e);
			throw new AppException(e.getMessage());
		}
	}
	
	public static Date nextDay(Date date){
		long time = date.getTime();
		return new Date(time + 24 * 3600 * 1000);
	}
	
	public static Date addHours(Date date, int hours){
		long time = date.getTime();
		return new Date(time + hours * 3600 * 1000);
	}
}
