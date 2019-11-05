package com.softtek.academy.jstl.domain.model;

import java.time.LocalDateTime;

public class Cart {

    private Long id;

    private User user;

    private Double linesAmount;

    private Status status;

    private String createUser;

    private LocalDateTime createDate;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getLinesAmount() {
        return this.linesAmount;
    }

    public void setLinesAmount(Double linesAmount) {
        this.linesAmount = linesAmount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

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


    @Override
    public String toString() {
        return String.format("Cart [id=%s, user=%s, linesAmount=%s, status=%s, createUser=%s, createDate=%s]",
                id, user, linesAmount, status, createUser, createDate);
    }


}
