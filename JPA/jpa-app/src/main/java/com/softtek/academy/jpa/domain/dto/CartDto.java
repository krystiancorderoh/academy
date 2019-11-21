package com.softtek.academy.jpa.domain.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.softtek.academy.jpa.util.serializer.JsonDateTimeDeserializer;

public class CartDto {

    private String userId;

    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private Date date;

    private List<CartLineDto> lines;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CartLineDto> getLines() {
        return lines;
    }

    public void setLines(List<CartLineDto> lines) {
        this.lines = lines;
    }


    @Override
    public String toString() {
        return String.format("CartDto [userId=%s, date=%s, lines=%s]", userId, date, lines);
    }
}
