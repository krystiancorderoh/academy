package com.softtek.academy.jpa.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.softtek.academy.jpa.util.serializer.JsonDateTimeDeserializer;

import lombok.Data;

@Data
public class CartDto {

    private String userId;

    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private LocalDateTime date;

    private List<CartLineDto> lines;
}
