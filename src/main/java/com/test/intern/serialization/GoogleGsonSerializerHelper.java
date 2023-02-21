package com.test.intern.serialization;

import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.ZonedDateTime;

public class GoogleGsonSerializerHelper {

    public static void registerTypeAdapters(final GsonBuilder builder) {
        builder.registerTypeAdapter(java.util.Date.class, new DateAdapter());
        builder.registerTypeAdapter(LocalDate.class, new JodaLocalDateAdapter());
        builder.registerTypeAdapter(ZonedDateTime.class, new JodaDateTimeAdapter());
        builder.registerTypeAdapter(MonthDay.class, new JodaMonthDayAdapter());
    }
}
