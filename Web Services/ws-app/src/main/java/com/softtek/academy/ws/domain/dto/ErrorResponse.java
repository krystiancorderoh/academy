package com.softtek.academy.ws.domain.dto;

import java.time.LocalDateTime;

import com.softtek.academy.ws.domain.model.Cart;
import com.softtek.academy.ws.domain.model.Status;
import com.softtek.academy.ws.domain.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
	
	private String message;
	private String moreInfo;
	
}
