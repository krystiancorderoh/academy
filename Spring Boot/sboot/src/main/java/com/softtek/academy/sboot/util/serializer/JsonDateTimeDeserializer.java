package com.softtek.academy.sboot.util.serializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.softtek.academy.sboot.domain.enums.SerializingFormat;

public class JsonDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(SerializingFormat.DATE_TIME.getFormat());


    @Override
    public LocalDateTime deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
            throws IOException {

        return LocalDateTime.parse(paramJsonParser.getText().trim(), formatter);
    }
}
