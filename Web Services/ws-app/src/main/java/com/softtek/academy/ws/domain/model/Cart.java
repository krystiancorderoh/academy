package com.softtek.academy.ws.domain.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.softtek.academy.ws.domain.dto.ErrorResponse;
import com.softtek.academy.ws.web.serialize.JsonDateTimeDeserializer;
import com.softtek.academy.ws.web.serialize.JsonDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
public class Cart {

    private Long id;

    private User user;

    private Double linesAmount;

    private Status status;

    private String createUser;
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private LocalDateTime createDate;


}
