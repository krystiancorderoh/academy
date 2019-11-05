package com.softtek.academy.jstl.domain.model;

import java.time.LocalDateTime;

public abstract class Auditable {

    protected String createUser;

    protected LocalDateTime createDate;

    protected String updateUser;

    protected LocalDateTime updateDate;


    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }


    @Override
    public String toString() {
        return String.format("AuditableEntity [createUser=%s, createDate=%s, updateUser=%s, updateDate=%s]",
                createUser, createDate, updateUser, updateDate);
    }



}
