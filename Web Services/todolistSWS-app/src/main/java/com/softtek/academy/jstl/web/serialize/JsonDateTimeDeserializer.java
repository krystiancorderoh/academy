package com.softtek.academy.jstl.web.serialize;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JsonDateTimeDeserializer extends JsonDeserializer<LocalDateTime>  {

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public LocalDateTime deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
            throws IOException {

        String stringDate = paramJsonParser.getText();

        return LocalDateTime.parse(stringDate, dateFormat);
    }
}
