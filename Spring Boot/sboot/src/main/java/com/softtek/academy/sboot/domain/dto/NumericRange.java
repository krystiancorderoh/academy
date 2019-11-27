package com.softtek.academy.sboot.domain.dto;

import lombok.Data;

@Data
public class NumericRange<T extends Number> {

    private T min;

    private T max;

}
