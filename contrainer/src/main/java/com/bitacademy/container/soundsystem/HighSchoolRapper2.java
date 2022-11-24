package com.bitacademy.container.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class HighSchoolRapper2 implements CompactDisc {
	private String artist = "김하온";
	private String title = "붕붕";
	
	@Override
	public String play() {
		return "Playing " + title + " by " + artist;
	}

}