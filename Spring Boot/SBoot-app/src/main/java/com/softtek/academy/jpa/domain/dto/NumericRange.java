package com.softtek.academy.jpa.domain.dto;

import lombok.Data;

@Data
public class NumericRange<T extends Number> {

    private T min;

    private T max;

}
