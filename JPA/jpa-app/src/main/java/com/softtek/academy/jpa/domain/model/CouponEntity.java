package com.softtek.academy.jpa.domain.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.softtek.academy.jpa.util.serializer.JsonDateTimeDeserializer;
import com.softtek.academy.jpa.util.serializer.JsonDateTimeSerializer;

public class CouponEntity extends AuditableEntity {

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getRedeemed() {
        return redeemed;
    }

    public void setRedeemed(Double redeemed) {
        this.redeemed = redeemed;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    @Override
    public String toString() {
        return String.format(
                "CouponEntity [id=%s, validFrom=%s, validTo=%s, value=%s, redeemed=%s, balance=%s, active=%s, createUser=%s, createDate=%s, updateUser=%s, updateDate=%s]",
                id, validFrom, validTo, value, redeemed, balance, active, createUser, createDate, updateUser, updateDate);
    }

}
