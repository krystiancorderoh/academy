package com.softtek.academy.jpa.domain.dto;

public class NumericRange<T extends Number> {

    private T min;

    private T max;


    public T getMin() {
        return min;
    }

    public void setMin(T min) {
        this.min = min;
    }

    public T getMax() {
        return max;
    }

    public void setMax(T max) {
        this.max = max;
    }


    @Override
    public String toString() {
        return String.format("NumericRange [min=%s, max=%s]", min, max);
    }



}
