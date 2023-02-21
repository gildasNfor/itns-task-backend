package com.test.intern.serialization;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

/**
 * Serializer for Joda Time {@link LocalDate} that returns the date in array format to match previous Jackson
 * functionality.
 */
public class JodaLocalDateAdapter implements JsonSerializer<LocalDate> {

    @Override
    public JsonElement serialize(final LocalDate src, final Type typeOfSrc, final JsonSerializationContext context) {
        JsonArray array = null;
        if (src != null) {
            array = new JsonArray();
            array.add(new JsonPrimitive(src.get(ChronoField.YEAR_OF_ERA)));
            array.add(new JsonPrimitive(src.getMonthValue()));
            array.add(new JsonPrimitive(src.getDayOfMonth()));
        }
        return array;
    }
}