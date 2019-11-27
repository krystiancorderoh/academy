package com.softtek.academy.jpa.domain.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.softtek.academy.jpa.util.serializer.JsonDateTimeDeserializer;
import com.softtek.academy.jpa.util.serializer.JsonDateTimeSerializer;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CouponEntity extends AuditableEntity {

    private static final long serialVersionUID = 1L;

    private String id;

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private Date validFrom;

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private Date validTo;

    private Double value;

    private Double redeemed;

    private Double balance;

    private boolean active;

}
