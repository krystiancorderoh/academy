package com.softtek.academy.sboot.web.converter;

import java.io.IOException;

import org.springframework.core.convert.converter.Converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softtek.academy.sboot.domain.dto.NumericRange;

@SuppressWarnings("rawtypes")
public class StringToNumericRangeConverter implements Converter<String, NumericRange> {

    @Override
    public NumericRange convert(String source) {
        NumericRange convertedValue;

        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            convertedValue = objectMapper.readValue(source, NumericRange.class);
        } catch (IOException e) {
            throw new IllegalArgumentException(source + " cannot be converted to NumericRange type", e);
        }

        return convertedValue;
    }
}
