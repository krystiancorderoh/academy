package com.softtek.academy.ws.domain.dto;

import java.time.LocalDateTime;

import com.softtek.academy.ws.domain.model.Cart;
import com.softtek.academy.ws.domain.model.Status;
import com.softtek.academy.ws.domain.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {

    private String description;

    private Long stateId;

}
