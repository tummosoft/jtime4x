package com.tummosoft;

import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import com.tummosoft.jtime4x.jDate;
import com.xkzhangsan.time.calculator.DateTimeCalculatorUtil;
import java.util.HashMap;
import java.util.Map;

import com.xkzhangsan.time.converter.DateTimeConverterUtil;
import com.xkzhangsan.time.formatter.DateTimeFormatterUtil;
import com.xkzhangsan.time.LunarDate;
import static com.xkzhangsan.time.calculator.DateTimeCalculatorUtil.compare;
import static com.xkzhangsan.time.calculator.DateTimeCalculatorUtil.getAge;
import static com.xkzhangsan.time.calculator.DateTimeCalculatorUtil.getDayOfWeek;
import static com.xkzhangsan.time.calculator.DateTimeCalculatorUtil.isBirthDay;
import static com.xkzhangsan.time.calculator.DateTimeCalculatorUtil.isOverlap;
import static com.xkzhangsan.time.calculator.DateTimeCalculatorUtil.minusDays;
import static com.xkzhangsan.time.calculator.DateTimeCalculatorUtil.minusMonths;
import static com.xkzhangsan.time.calculator.DateTimeCalculatorUtil.minusWeeks;
import static com.xkzhangsan.time.calculator.DateTimeCalculatorUtil.minusYears;
import static com.xkzhangsan.time.calculator.DateTimeCalculatorUtil.overlapTime;
import static com.xkzhangsan.time.calculator.DateTimeCalculatorUtil.plus;
import static com.xkzhangsan.time.calculator.DateTimeCalculatorUtil.plusMonths;
import static com.xkzhangsan.time.calculator.DateTimeCalculatorUtil.plusWeeks;
import static com.xkzhangsan.time.calculator.DateTimeCalculatorUtil.plusYears;
import static com.xkzhangsan.time.calculator.DateTimeCalculatorUtil.startTimeOfDay;
import static com.xkzhangsan.time.calculator.DateTimeCalculatorUtil.today;
import com.xkzhangsan.time.utils.StringUtil;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Pattern;

@Version(1.0f)
@ShortName("jtime4x")
public class jtime4x {

    public DateTimeFormatterUtil DateTimeEnum;

    public static LocalDateTime getCurrentLocalDateTime(String ZoneID) {
        LocalDateTime utcTimestamp = LocalDateTime.now(ZoneId.of(ZoneID));
        return utcTimestamp;
    }

    public static LocalTime getCurrentLocalTime(String ZoneID) {
        LocalTime utcTimestamp = LocalTime.now(ZoneId.of(ZoneID));
        return utcTimestamp;
    }

    public static LocalDate getCurrentLocalDate(String ZoneID) {
        LocalDate utcTimestamp = LocalDate.now(ZoneId.of(ZoneID));
        return utcTimestamp;
    }

    public static Date getNDaysAgo(int value, String outputFormat) {
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(
                outputFormat);
        Calendar g = Calendar.getInstance();
        g.setTime(new java.util.Date());
        g.add(java.util.Calendar.DATE, value);

        return g.getTime();
    }

    public static Date getNDaysAgo2(jDate datev, int value, String outputFormat) {
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(
                outputFormat);
        Calendar g = Calendar.getInstance();
        g.setTime(datev.getJavaDate());
        g.add(java.util.Calendar.DATE, value);

        return g.getTime();
    }

    static public int CompareDate1toDate2(jDate day1, jDate day2) throws ParseException {
        return day1.compareTo(day2);
    }

    static private TimeZone getTimeZone(String localtion) {
        return java.util.TimeZone.getTimeZone(localtion);
    }

    public static Date RandomTime(int nums) {
        Random random = new Random();
        int numRandomEvents = nums;
        Date startTime = new Date();

        for (int i = 0; i < numRandomEvents; i++) {

            Calendar calendar = Calendar.getInstance();
            long currentTimeMillis = System.currentTimeMillis();
            calendar.setTimeInMillis(currentTimeMillis + random.nextInt(30) * 60 * 1000);

            if (random.nextBoolean()) {
                startTime = calendar.getTime();
            } else {
                startTime = calendar.getTime();
            }
        }

        return startTime;
    }

    public static Instant StringToInstant(String value) {
        Instant instantDate = Instant.parse(value);
        return instantDate;
    }

    static private String ConvertFullTimeZone(String format, jDate date, String zone) {
        SimpleDateFormat customDateFormat = new SimpleDateFormat(format);
        TimeZone tz = getTimeZone(zone);
        customDateFormat.setTimeZone(tz);
        return customDateFormat.format(date);
    }

    // ***********************************
    public static jDate ConvertDate(int year, int month, int day) {
        Date jdt = new jDate(DateTimeCalculatorUtil.getDate(year, month, day));
        return (jDate) jdt;
    }

    public static boolean isValidDateTime(String value) {
        return DateTimeFormatterUtil.isValidDateTime(value);
    }

    public static boolean isValidDate(String value) {
        return DateTimeFormatterUtil.isValidDate(value);
    }

    // ***********************************
    static public jDate NowUTC() {
        Date nw = new Date();
        jDate jdt = new jDate(nw);
        return jdt;
    }

    static public String NowUTC2(String format) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(now);
    }

    public static LocalDateTime StringToLocal(String date) {
        return DateTimeFormatterUtil.smartParseToLocalDateTime(date);
    }

    public static LocalDateTime ParseIsoToLocal(String date) {
        return DateTimeFormatterUtil.parseIsoToLocalDateTime(date);
    }

    public static LocalDateTime ParseEpochMilliToLocal(String date) {
        return DateTimeFormatterUtil.parseEpochMilliToLocalDateTime(date);
    }

    public static int getAge(jDate birthDay) {
        return DateTimeCalculatorUtil.getAge(birthDay);
    }

    public static int getQuarterOfYear(LocalDateTime localDateTime) {
        return DateTimeCalculatorUtil.getQuarter(localDateTime);
    }

    public static Date PlusYears(Date date, long amountToAdd) {
        return DateTimeCalculatorUtil.plusYears(date, amountToAdd);
    }

    public static Date plusMonths(Date date, long amountToAdd) {
        return DateTimeCalculatorUtil.plus(date, ChronoUnit.MONTHS, amountToAdd);
    }

    public static String timestamp2Date(String timestamp, String newFormat) {
        if (StringUtil.isEmpty(timestamp)
                || !Pattern.matches("^\\+?[1-9][0-9]*$", timestamp)
                || (10 != timestamp.length() && 13 != timestamp.length())) {

            return "";
        }

        long time = Long.parseLong(timestamp);
        long finaltime = timestamp.length() == 10 ? time * 1000 : time;
        return new SimpleDateFormat(newFormat).format(new Date(finaltime));
    }

    private static String getCountdownWithDay(Date start, Date end, String unitNames) {
        return DateTimeCalculatorUtil.countdownWithDay(start, end, unitNames);
    }

    public static long getOverlapTime(Date startDate1, Date endDate1, Date startDate2, Date endDate2) {
        return DateTimeCalculatorUtil.overlapTime(startDate1, endDate1, startDate2, endDate2);
    }

    public static boolean isOverlap(Date startDate1, Date endDate1, Date startDate2, Date endDate2) {
        return DateTimeCalculatorUtil.isOverlap(startDate1, endDate1, startDate2, endDate2, false);
    }

    public static Date getLastYear(Date value) {
        return DateTimeCalculatorUtil.minusYears(value, 1);
    }

    public static Date getLastMonth(Date value) {
        return DateTimeCalculatorUtil.minusMonths(value, 1);
    }

    public static Date getLastWeek(Date value) {
        return DateTimeCalculatorUtil.minusWeeks(value, 1);
    }

    public static Date getYesterday(Date value) {
        return DateTimeCalculatorUtil.minusDays(value, 1);
    }

    public static Date getNextYear(Date value) {
        return DateTimeCalculatorUtil.plusYears(value, 1);
    }

    public static Date getNextMonth(Date value) {
        return DateTimeCalculatorUtil.plusMonths(value, 1);
    }

    public static Date startTimeOfDate(int year, int month, int dayOfMonth) {
        return DateTimeConverterUtil.toDate(LocalDate.of(year, month, dayOfMonth).atTime(startTimeOfDay()));
    }

    public static int compare(Date date1, Date date2) {
        return DateTimeCalculatorUtil.compare(date1, date2);
    }

    public static boolean isBirthDay(Date birthDay) {
        Objects.requireNonNull(birthDay, "birthDay");
        return DateTimeCalculatorUtil.isBirthDay(DateTimeConverterUtil.toLocalDate(birthDay));
    }

    public static Date nextWeek(Date value) {
        return DateTimeCalculatorUtil.plusWeeks(value, 1);
    }

    public static LocalTime getAverageTime(anywheresoftware.b4a.objects.collections.List datelist) {
        List<Date> dList = new ArrayList<Date>();
        for (int i = 0; i < datelist.getSize(); i++) {
            Date dt = (Date) datelist.Get(i);
            dList.add(dt);
        }

        return DateTimeCalculatorUtil.averageTime(dList);
    }

    public static String getCountdown(long millis) {
        return DateTimeCalculatorUtil.countdown(millis);
    }

    public static int periodBetween(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        return Period.between(startDateInclusive, endDateExclusive).getDays();
    }
    
    public static int lengthOfYear(Date date) {
        return DateTimeConverterUtil.toLocalDateTime(date).toLocalDate().lengthOfYear();
    }

    public static int lengthOfMonth(Date date) {
        return DateTimeConverterUtil.toLocalDateTime(date).toLocalDate().lengthOfMonth();
    }

    public static boolean isWorkDay(Date date) {
        int dayOfWeek = getDayOfWeek(date);
        if (dayOfWeek == 6 || dayOfWeek == 7) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4) == 0) && ((year % 100) != 0 || (year % 400) == 0);
    }

    public static String getCountdown(long millis, String unitNames) {
        return DateTimeCalculatorUtil.countdown(millis, unitNames);
    }

    private static String convertDateFormat(String date) {
        if (date.length() < 14) {
            date = String.format("%s%s", date, String.format(("%0" + (14 - date.length()) + "d"), 0));
            date = date.replaceAll("(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})", "$1-$2-$3 $4:$5:$6");
        }
        return date;
    }

    @ShortName("jDate")
    public static class jDate extends Date {

        private Date _dte;

        public void Initialize() {
            _dte = new Date();
        }

        public void Initialize2(String newdate) {
            _dte = DateTimeFormatterUtil.smartParseToDate(newdate);
        }

        public void Initialize3(Date newdate) {
            _dte = newdate;
        }

        public jDate() {
            _dte = null;
        }

        public jDate(Date dt) {
            _dte = dt;
        }

        public jDate(String newdate) {
            _dte = DateTimeFormatterUtil.smartParseToDate(newdate);
        }

        public void setJavaDate(Date newdate) {
            _dte = newdate;
        }

        public void setLocalDateTime(LocalDateTime newdate) {
            _dte = DateTimeConverterUtil.toDate(newdate);

        }

        public void setStringTime(String newdate) {
            Date jdt = new jDate(DateTimeFormatterUtil.smartParseToDate(newdate));
            _dte = jdt;
        }

        public void setLocalTime(LocalTime newdate) {
            _dte = DateTimeConverterUtil.toDate(newdate);
        }

        public void setLocalDate(LocalDate newdate) {
            _dte = DateTimeConverterUtil.toDate(newdate);
        }

        public void setInstantTime(Instant instant) {
            _dte = DateTimeConverterUtil.toDate(instant);
        }

        public void setLongTime(long time) {
            String timestamp = String.valueOf(time);
            long finaltime = timestamp.length() == 10 ? time * 1000 : time;
            _dte = new Date(finaltime);
        }

        @Override
        public Instant toInstant() {
            return _dte.toInstant();
        }

        @Override
        public long getTime() {
            return _dte.getTime();
        }

        public Date getJavaDate() {
            return _dte;
        }

        @Override
        public String toString() {
            return _dte.toString();
        }

        public long toLong() {
            return _dte.getTime();
        }

        public LocalDate toLocalDate() {
            LocalDateTime local = toLocalDateTime();
            return local.toLocalDate();
        }

        public LocalDateTime toLocalDateTime() {
            return DateTimeFormatterUtil.parseDateDefaultStrToLocalDateTime(_dte.toString());

        }

    }

}
