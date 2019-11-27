package com.softtek.academy.sboot.domain.model;

import lombok.Data;

@Data
public class ShipToEntity {

    private Long id;

    private UserEntity user;

    private String name;

    private String address;

    private CityEntity city;

    private Long zipCode;

    private String phone;

    private String email;

}
