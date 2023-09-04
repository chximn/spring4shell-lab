package com.example.vulnerable;

import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;


@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class Patch {

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		String[] abd = new String[]{"class.*", "Class.*", "*.class.*", "*.Class.*"};
		dataBinder.setDisallowedFields(abd);
	}

}