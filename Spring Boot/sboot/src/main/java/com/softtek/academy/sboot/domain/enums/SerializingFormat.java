package com.softtek.academy.sboot.domain.enums;

public enum SerializingFormat {

    DATE("MM/dd/yyyy"),
    DATE_HYPHEN("MM-dd-yyyy"),
    DATE_TIME("MM/dd/yyyy HH:mm:ss");

    private String format;


    SerializingFormat(final String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

}
