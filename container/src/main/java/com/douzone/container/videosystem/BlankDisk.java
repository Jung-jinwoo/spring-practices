package com.douzone.container.videosystem;

import java.util.List;

public class BlankDisk implements DigitalVideoDisc {

	private String title;
	private String studio;
	private List<String> actors;
	
	public BlankDisk(String title, String studio) {
		this.title = title;
		this.studio = studio;
	}
	
	public BlankDisk(String title, String studio, List<String> actors) {
		this.title = title;
		this.studio = studio;
		this.actors = actors;
	}

	@Override
	public void play() {
		System.out.println("Playing Movie "+ studio +"'s" + title);

	}

}
