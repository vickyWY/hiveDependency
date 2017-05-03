package com.qianjiali.hiveDependency.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;

public class DateUtil {

	public static final int MILLISECONDS = 1000 * 60 * 60 * 24;
	public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String YYMMDD = "yyMMdd";
	public static final String YYYYMM = "yyyyMM";
	public static final String YYYY = "yyyy";
	public static final String MM = "MM";
	public static final String DD = "DD";
	public static final String HH_MM_SS = "HH:mm:ss";
	public static final String MM_DD_YYYY_HH_MM_SS = "MM/dd/yyyy HH:mm:ss";

	/**
	 * @param date
	 * @return ����Ĭ�ϸ�ʽ(yyyy-MM-dd)�����ַ�
	 */
	public static String DateToString(Date date) {
		DateFormat df = new SimpleDateFormat(YYYY_MM_DD);
		return DateToString(date, df);
	}

	public static String LongToDateString(Long millSec) {
		SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		Date date = new Date(millSec);
		return sdf.format(date);
	}

	/**
	 * @param date
	 * @param format
	 * @return ���ض�Ӧ��ʽ�����ַ�
	 */
	public static String DateToString(Date date, String format) {
		DateFormat df = new SimpleDateFormat(format);
		return DateToString(date, df);
	}

	/**
	 * @param date
	 * @param df
	 * @return ���ض�Ӧ��ʽ�����ַ�
	 */
	private static String DateToString(Date date, DateFormat df) {
		try {
			return df.format(date);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * @param sdate
	 * @param format
	 * @return ���ض�Ӧ��ʽ������
	 * @throws ParseException
	 */
	public static Date StringToDate(String sdate, String format) throws ParseException {
		DateFormat df = new SimpleDateFormat(format);
		return StringToDate(sdate, df);
	}

	/**
	 * @param sdate
	 * @param format
	 * @return ����Ĭ�ϸ�ʽ(yyyy-MM-dd)������
	 * @throws ParseException
	 */
	public static Date StringToDate(String sdate) throws ParseException {
		DateFormat df = new SimpleDateFormat(YYYY_MM_DD);
		return StringToDate(sdate, df);
	}

	/**
	 * @param sdate
	 * @param format
	 * @return ���ض�Ӧ��ʽ������
	 * @throws ParseException
	 */
	private static Date StringToDate(String sdate, DateFormat df) throws ParseException {
		if (StringUtils.isEmpty(sdate)) {
			return null;
		}
		return df.parse(sdate);
	}

	/**
	 * �����׳��쳣������ת��
	 * 
	 * @param sdate
	 * @param format
	 * @return Date
	 */
	public static Date StringToDateNoException(String sdate, String format) {
		Date result;
		try {
			result = StringToDate(sdate, format);
		} catch (ParseException e) {
			e.printStackTrace();
			result = null;
		} finally {

		}
		return result;
	}

	/**
	 * �����׳��쳣������ת��(Ĭ�ϸ�ʽ��yyyy-MM-dd)
	 * 
	 * @param sdate
	 * @return Date
	 */
	public static Date StringToDateNoException(String sdate) {
		Date result;
		try {
			result = StringToDate(sdate);
		} catch (ParseException e) {
			e.printStackTrace();
			result = null;
		} finally {

		}
		return result;
	}

	/**
	 * @param date
	 * @param days
	 * @return ����xx���������ڣ�daysΪ������������
	 */
	public static Date DateAdd(Date date, int days) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, days);
		return calendar.getTime();
	}

	/**
	 * @param date
	 * @param months
	 * @return ����xx���������ڣ�monthsΪ������������
	 */
	public static Date MonthAdd(Date date, int months) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}

	/**
	 * @param date
	 * @param weaks
	 * @return ����xx���������ڣ�weaksΪ������������
	 */
	public static Date WeekAdd(Date date, int weaks) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.WEEK_OF_YEAR, weaks);
		return calendar.getTime();
	}

	/**
	 * 
	 * @param date
	 * @param hours
	 * @return ����Сʱ��, hoursΪ������������
	 */
	public static Date hourAdd(Date date, int hours) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + hours);
		return calendar.getTime();
	}

	/**
	 * 
	 * @param date
	 * @param mins
	 * @return ���ӷ�����, minsΪ������������
	 */
	public static Date minAdd(Date date, int mins) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + mins);
		return calendar.getTime();
	}

	/**
	 * @param begin
	 * @param end
	 * @return �������ڵ������
	 */
	public static int getDateInterval(Date begin, Date end) {
		return (int) java.lang.Math.round((begin.getTime() - end.getTime()) / (double) MILLISECONDS + 0.4999884);
	}

	/*****
	 * ��Ҫ�û�ʱ��β�ѯʱ��ת��������ʼʱ�� ת��Ϊ�����0ʱ0��0��000����
	 * 
	 * @param date
	 * @return
	 */
	public static final Date convertStartDate(Date date) {
		Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/****
	 * ��Ҫ�û�ʱ��β�ѯʱ��ת����������ʱ�� ת��Ϊ�����23ʱ59��59��999����
	 * 
	 * @param date
	 * @return
	 */
	public static final Date convertEndDate(Date date) {
		Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	/****
	 * ��ȡָ������ǰ�����µ����һ�졣������Ϊ������֮��
	 * 
	 * @param date
	 *            ָ������
	 * @param month
	 *            ������֮ǰ
	 * @return
	 */
	public static final Date getLastDayBeforeMonth(Date date, int month) {
		// ��ȡָ��ʱ��ļ�����֮ǰ�ĵ�һ��
		Date d = getFirstDayBeforeMonth(date, month);
		Date d1 = MonthAdd(d, 1);
		return DateAdd(d1, -1);
	}

	/****
	 * ��ȡָ������ǰ�����µĵ�һ��.������Ϊ������֮��
	 * 
	 * @param date
	 *            ָ������
	 * @param month
	 *            ������֮ǰ
	 * @return
	 */
	public static final Date getFirstDayBeforeMonth(Date date, int month) {
		Calendar c = java.util.Calendar.getInstance();
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) - month);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}

	/**
	 * ȡ��ָ����ʱ�� ����ָ��ʱ���ʱ���֣���
	 * 
	 * @param date
	 * @return
	 */
	public static final Date getDateAssignHHMMSS(Date date, int hour, int minute, int second) {
		Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, minute);
		c.set(Calendar.SECOND, second);
		return c.getTime();
	}

	public static String DateDiff(Date localTime, Date fireTime) {
		String dateDiff = "";

		long localMiniSeconds = localTime.getTime();
		long firetimeMiniSeconds = fireTime.getTime();

		long ts = localMiniSeconds - firetimeMiniSeconds;

		long day = ts / (24 * 60 * 60 * 1000);
		long hour = (ts / (60 * 60 * 1000) - day * 24);
		long minute = ((ts / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long second = (ts / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - minute * 60);

		if (day != 0) {
			dateDiff += day + "Days";
		}
		if (hour != 0) {
			dateDiff += hour + "Hours";
		}
		if (minute != 0) {
			dateDiff += minute + "Minutes";
		}
		if (second != 0) {
			dateDiff += second + "Seconds";
		}
		return dateDiff;
	}

	public static String getLastNMonth(int n) {
		Date now = new Date();
		Calendar nowCal = Calendar.getInstance();
		nowCal.set(Calendar.YEAR, Integer.valueOf(DateToString(now, DateUtil.YYYY)));
		nowCal.set(Calendar.MONTH, Integer.valueOf(DateToString(now, DateUtil.MM)) - 1);

		nowCal.add(Calendar.MONTH, -n);
		return DateToString(nowCal.getTime(), DateUtil.YYYYMM);
	}

	public static String getLastNMonth(String month, int n) throws ParseException {
		Date dateMonth = new SimpleDateFormat("yyyyMM").parse(month);

		Calendar nowCal = Calendar.getInstance();
		nowCal.set(Calendar.YEAR, Integer.valueOf(DateToString(dateMonth, DateUtil.YYYY)));
		nowCal.set(Calendar.MONTH, Integer.valueOf(DateToString(dateMonth, DateUtil.MM)) - 1);

		nowCal.add(Calendar.MONTH, -n);
		return DateToString(nowCal.getTime(), DateUtil.YYYYMM);
	}

	public static String getLastNDay(int n) {
		Date now = new Date();
		Calendar nowCal = Calendar.getInstance();
		nowCal.set(Calendar.YEAR, Integer.valueOf(DateToString(now, DateUtil.YYYY)));
		nowCal.set(Calendar.MONTH, Integer.valueOf(DateToString(now, DateUtil.MM)));
		nowCal.set(Calendar.DAY_OF_YEAR, Integer.valueOf(DateToString(now, DateUtil.DD)));

		nowCal.add(Calendar.DAY_OF_YEAR, -n);
		return DateToString(nowCal.getTime(), DateUtil.YYYYMMDD);
	}
}
