package com.softtek.academy.sboot.domain.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.softtek.academy.sboot.util.serializer.JsonDateTimeDeserializer;
import com.softtek.academy.sboot.util.serializer.JsonDateTimeSerializer;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="COUPON")
@EqualsAndHashCode(callSuper = false)
public class CouponEntity extends AuditableEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private String id;

    @Column(name="valid_from")
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private LocalDateTime validFrom;

    @Column(name="valid_to")
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private LocalDateTime validTo;
    
    @Column(name="value", columnDefinition = "NUMERIC(10,2)")
    private Double value;

    @Column(name="redeemed", columnDefinition = "NUMERIC(10,2)")
    private Double redeemed;

    @Column(name="balance", columnDefinition = "NUMERIC(10,2)")
    private Double balance;

    @Type(type="yes_no")
    @Column(name="active")
    private boolean active;

}
