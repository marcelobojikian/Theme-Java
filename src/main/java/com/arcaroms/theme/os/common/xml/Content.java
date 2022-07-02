package com.arcaroms.theme.os.common.xml;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;

public class Content implements Serializable {

	private Map<String, String> attributes = new HashMap<>();
	
	public Content() {
	}
	
	public Content(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	
	public Content clone() {
		return (Content) SerializationUtils.clone(this);
	}

}
