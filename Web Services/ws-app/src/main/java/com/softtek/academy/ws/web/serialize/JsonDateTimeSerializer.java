package com.softtek.academy.ws.web.serialize;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonDateTimeSerializer extends JsonSerializer<LocalDateTime>  {

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

    @Override
    public void serialize(LocalDateTime date, final JsonGenerator gen, final SerializerProvider provider)
            throws IOException, JsonProcessingException {

        if (date == null) {
            gen.writeString(StringUtils.EMPTY);
        }
        else {
            gen.writeString(dateFormat.format(date));
        }
    }
}
