package me.pcy.java8to11.dateAndTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App {

    public static void main(String[] args) {
        // 기계용 API
        Instant instant = Instant.now();
        System.out.println("instant = " + instant);  // 기준시 UTC, GMT

        ZoneId zone = ZoneId.systemDefault();
        System.out.println("zone = " + zone);
        ZonedDateTime atZone = instant.atZone(zone);
        System.out.println("atZone = " + atZone);

        // 사람용 일시 표현
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        LocalDateTime plusDay = now.plus(10, ChronoUnit.DAYS);
        System.out.println("plusDay = " + plusDay);

        // 기간을 표현하는 방법
        LocalDate today = LocalDate.now();
        LocalDate myBirthday = LocalDate.of(1995, Month.OCTOBER, 7);
        // 사람용 시간 비교 1
        Period period = Period.between(today, myBirthday);
        System.out.println("period = " + period.getDays());
        // 사람용 시간 비교 2
        Period until = today.until(myBirthday);
        System.out.println("until = " + until.get(ChronoUnit.DAYS));
        // 기계용 시간 비교
        Instant plus = instant.plus(10, ChronoUnit.SECONDS);
        Duration duration = Duration.between(instant, plus);
        System.out.println("duration = " + duration.getSeconds());

        // 포메팅
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("now Formet = " + now.format(MMddyyyy));

        // 파싱
        LocalDate parse = LocalDate.parse("10/07/1995", MMddyyyy);
        System.out.println("parse = " + parse);

        // 레거시 API 지원
        // Date
        Date date = new Date();
        // Date -> Instant
        Instant toInstant = date.toInstant();
        // Instant -> Date
        Date newDate = Date.from(toInstant);

        // GregorianCalendar
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        // GregorianCalendar -> Instant -> ZonedDateTime -> LocalDateTime
        LocalDateTime localDateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        // ZonedDateTime -> GregorianCalendar
        GregorianCalendar from = GregorianCalendar.from(atZone);

        // TimeZone
        // TimeZone -> ZoneId
        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        // ZoneId -> TimeZone
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
    }
}
