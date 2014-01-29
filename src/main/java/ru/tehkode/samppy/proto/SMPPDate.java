package ru.tehkode.samppy.proto;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author t3hk0d3
 */
public class SMPPDate {

    private final static Pattern regexp = Pattern.compile("^(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{1})(\\d{2})([+-R])$");

    public enum Sign {

        BEFORE('-'),
        AFTER('+'),
        RELATIVE('R');
        private final char sign;

        private Sign(char sign) {
            this.sign = sign;
        }

        public char sign() {
            return sign;
        }

        public static Sign byChar(char s) {
            for (Sign sign : Sign.values()) {
                if (sign.sign() == s) {
                    return sign;
                }
            }

            throw new IllegalArgumentException("Unknown date sign (" + s + ")");
        }
    }
    private byte year;
    private byte month;
    private byte day;
    private byte hour;
    private byte minute;
    private byte second;
    private byte subsecond;
    private byte timezone;
    private Sign sign;

    public SMPPDate() {
    }

    public SMPPDate(String date) {
        parse(date);
    }

    public static SMPPDate fromTime(long time) {
        Calendar calendar = GregorianCalendar.getInstance();
        
        calendar.setTimeInMillis(time);

        SMPPDate dt = new SMPPDate();

        // cut year part
        dt.year = Byte.parseByte(Integer.toString(calendar.get(Calendar.YEAR)).substring(2, 4));
        dt.month = (byte) (calendar.get(Calendar.MONTH) + 1);
        dt.day = (byte) calendar.get(Calendar.DAY_OF_MONTH);
        dt.hour = (byte) calendar.get(Calendar.HOUR_OF_DAY);
        dt.minute = (byte) calendar.get(Calendar.MINUTE);
        dt.second = (byte) calendar.get(Calendar.SECOND);
        dt.subsecond = (byte) (calendar.get(Calendar.MILLISECOND) / 100);
        
        int offset = calendar.getTimeZone().getOffset(time) / 3600000;
        
        dt.timezone = (byte)Math.abs(offset);
        dt.sign = (offset >= 0) ? Sign.AFTER : Sign.BEFORE;

        return dt;
    }

    public long toTime() {
        Calendar cal = GregorianCalendar.getInstance();
        int yr = year;
        
        if (isRelative()) {
            cal.add(Calendar.YEAR, yr);
            cal.add(Calendar.MONTH, month - 1);
            cal.add(Calendar.DATE, day);
            cal.add(Calendar.HOUR_OF_DAY, hour);
            cal.add(Calendar.MINUTE, minute);
            cal.add(Calendar.SECOND, second);
            cal.add(Calendar.MILLISECOND, subsecond * 100);
        } else {
            if (yr >= 80) {
                yr += 1900;
            } else {
                yr += 2000;
            }

            cal.set(Calendar.YEAR, yr);
            cal.set(Calendar.MONTH, month - 1);
            cal.set(Calendar.DATE, day);
            cal.set(Calendar.HOUR_OF_DAY, hour);
            cal.set(Calendar.MINUTE, minute);
            cal.set(Calendar.SECOND, second);
            cal.set(Calendar.MILLISECOND, subsecond * 100);
        }
               
        if (!this.isRelative()) {
            String tzs[] = TimeZone.getAvailableIDs(this.timezone * 3600000);

            if (tzs.length == 0) {
                throw new IllegalStateException("No known timezones for '" + this.timezone + "'");
            }
            
            cal.setTimeZone(TimeZone.getTimeZone(tzs[0]));
        }
        
        return cal.getTimeInMillis();
    }

    public byte year() {
        return year;
    }

    public SMPPDate year(int year) {
        if(year > 100) {
            year = Byte.parseByte(Integer.toString(year).substring(2, 4));
        } 
        
        this.year = (byte)year;

        return this;
    }

    public byte month() {
        return month;
    }

    public SMPPDate month(int month) {
        this.month = (byte)month;

        return this;
    }

    public byte day() {
        return day;
    }

    public SMPPDate day(int day) {
        this.day = (byte)day;

        return this;
    }

    public byte hour() {
        return hour;
    }

    public SMPPDate hour(int hour) {
        this.hour = (byte)hour;

        return this;
    }

    public byte minute() {
        return minute;
    }

    public SMPPDate minute(int minute) {
        this.minute = (byte)minute;

        return this;
    }

    public byte second() {
        return second;
    }

    public SMPPDate second(int second) {
        this.second = (byte)second;

        return this;
    }

    public byte subsecond() {
        return subsecond;
    }

    public SMPPDate subsecond(int subsecond) {
        this.subsecond = (byte)subsecond;

        return this;
    }

    public byte timezone() {
        return timezone;
    }

    public SMPPDate timezone(int timezone) {
        this.timezone = (byte)timezone;

        return this;
    }
    
    public SMPPDate timezone(TimeZone tz) {
        this.timezone = (byte)(tz.getOffset(System.currentTimeMillis()) / 3600000);
                
        return this;
    }

    public Sign sign() {
        return sign;
    }

    public SMPPDate sign(Sign sign) {
        this.sign = sign;

        return this;
    }

    public boolean isRelative() {
        return sign == Sign.RELATIVE;
    }

    public String value() {
        byte tzString = timezone;

        if (sign == Sign.RELATIVE) { // should be 00 by specification
            tzString = 0;
        }

        return String.format("%02d%02d%02d%02d%02d%02d%01d%02d%s", year, month, day, hour, minute, second, subsecond, tzString, sign.sign());
    }

    private void parse(String date) {
        Matcher matcher = regexp.matcher(date);

        if (matcher.find()) {
            this.year = Byte.parseByte(matcher.group(1));
            this.month = Byte.parseByte(matcher.group(2));
            this.day = Byte.parseByte(matcher.group(3));
            this.hour = Byte.parseByte(matcher.group(4));
            this.minute = Byte.parseByte(matcher.group(5));
            this.second = Byte.parseByte(matcher.group(6));
            this.subsecond = Byte.parseByte(matcher.group(7));
            this.timezone = Byte.parseByte(matcher.group(8));

            this.sign = Sign.byChar(matcher.group(9).charAt(0));
        } else {
            throw new IllegalArgumentException("Unable to parse '" + date + "'");
        }
    }
}
