package com.acelrtech.app;

import com.google.android.gms.maps.model.LatLng;

public class NameValue {
	public String name = null;
	public String value = null;
	public LatLng latlng = null;
	public NameValue(String name, String value, LatLng ll) {
		this.name = name;
		this.value = value;
		this.latlng = ll;
	}
}