package com.softtek.academy.jpa.util.serializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.softtek.academy.jpa.domain.enums.SerializingFormat;

public class JsonDateTimeSerializer extends JsonSerializer<Date>  {

    private static final SimpleDateFormat formatter = new SimpleDateFormat(SerializingFormat.DATE_TIME.getFormat());

    @Override
    public void serialize(final Date date, final JsonGenerator gen, final SerializerProvider provider)
            throws IOException, JsonProcessingException {

        if (date == null) {
            gen.writeString(StringUtils.EMPTY);
        }
        else {
            gen.writeString(formatter.format(date));
        }
    }
}
