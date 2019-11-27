package com.softtek.academy.jpa.domain.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.softtek.academy.jpa.util.serializer.JsonDateTimeDeserializer;
import com.softtek.academy.jpa.util.serializer.JsonDateTimeSerializer;

import lombok.Data;

@Data
public class CartEntity {

    private Long id;

    private String userId;

    private Double linesAmount;

    private StatusEntity status;

    private String createUser;

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private LocalDateTime createDate;

}
