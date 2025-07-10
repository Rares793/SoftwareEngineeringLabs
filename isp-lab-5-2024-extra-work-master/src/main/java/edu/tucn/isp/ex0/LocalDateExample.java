package edu.tucn.isp.ex0;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Radu Miron
 */
public class LocalDateExample {
    public static void main(String[] args) {
        // Local date
        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDate aLocalDate = LocalDate.of(2011, 12, 24);
        System.out.println(aLocalDate);

        LocalDate anotherLocalDate = LocalDate.parse("1994-11-30");
        System.out.println(anotherLocalDate);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate yetAnotherLocalDate = LocalDate.parse("1983-Jun-02", dateFormatter);
        System.out.println(yetAnotherLocalDate);

        // Local date time
        LocalDateTime nowWithTime = LocalDateTime.now();
        System.out.println(nowWithTime);

        LocalDateTime dt1 = LocalDateTime.of(1987, 10, 25, 13,45, 51);
        System.out.println(dt1);

        LocalDateTime dt2 = LocalDateTime.parse("1974-05-21T15:34:23");
        System.out.println(dt2);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime dt3 = LocalDateTime.parse("2005/06/07 23:24:25", dateTimeFormatter);
        System.out.println(dt3);
    }
}
