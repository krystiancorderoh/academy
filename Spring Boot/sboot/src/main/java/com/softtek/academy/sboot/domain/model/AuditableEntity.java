package com.softtek.academy.sboot.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.softtek.academy.sboot.util.serializer.JsonDateTimeDeserializer;
import com.softtek.academy.sboot.util.serializer.JsonDateTimeSerializer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class AuditableEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @CreatedBy
    @Column(name = "CREATE_USER", length = 20)
    protected String createUser;

    @CreatedDate
    @Column(name = "CREATE_DATE")
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    protected LocalDateTime createDate;

    @LastModifiedBy
    @Column(name = "UPDATE_USER", length = 20)
    protected String updateUser;

    @LastModifiedDate
    @Column(name = "UPDATE_DATE")
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    protected LocalDateTime updateDate;

}
