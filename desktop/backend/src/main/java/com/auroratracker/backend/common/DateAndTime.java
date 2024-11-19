package com.auroratracker.backend.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

    final static DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String getCurrentDateAndTimeFormatted() {
        LocalDateTime ldt = LocalDateTime.now();
        return ldt.format(CUSTOM_FORMATTER);
    }


}
