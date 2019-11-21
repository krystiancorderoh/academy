package com.softtek.academy.jpa.util.serializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.softtek.academy.jpa.domain.enums.SerializingFormat;

public class JsonDateTimeDeserializer extends JsonDeserializer<Date> {

    private static final SimpleDateFormat formatter = new SimpleDateFormat(SerializingFormat.DATE_TIME.getFormat());


    @Override
    public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
            throws IOException {

        Date date = null;
        try {
            date = formatter.parse(paramJsonParser.getText().trim());
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }

        return date;
    }
}
