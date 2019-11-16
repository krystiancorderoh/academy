package com.softtek.academy.ws.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class City {

    private Long id;

    private String description;

    private State state;

}
