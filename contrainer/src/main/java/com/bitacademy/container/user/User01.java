package com.bitacademy.container.user;

import org.springframework.stereotype.Component;

@Component("myuser")
public class User01 {
	public String getName() {
		return "둘리";
	}
}
