package com.github.tnessn.text.replace;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ReplaceMsg")
public class ReplaceMsg {

	@XStreamAlias("extension")
	private String extension;

	@XStreamAlias("places")
	private List<Place> places;


	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}



}
