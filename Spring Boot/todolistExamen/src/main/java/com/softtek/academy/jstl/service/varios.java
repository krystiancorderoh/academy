package com.softtek.academy.jstl.service;

import java.util.ArrayList;
import java.util.List;

public class varios {
	
	public void shouldTrowException() {
		List<Long> list =new ArrayList<>();
		list.get(0);
	}
}
