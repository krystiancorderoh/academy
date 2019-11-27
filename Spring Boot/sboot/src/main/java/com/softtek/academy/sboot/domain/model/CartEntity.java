package com.softtek.academy.sboot.domain.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.softtek.academy.sboot.util.serializer.JsonDateTimeDeserializer;
import com.softtek.academy.sboot.util.serializer.JsonDateTimeSerializer;

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
