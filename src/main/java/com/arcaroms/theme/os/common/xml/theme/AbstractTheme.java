package com.arcaroms.theme.os.common.xml.theme;

import java.util.ArrayList;
import java.util.List;

import com.arcaroms.theme.os.emulationstation.xml.View;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public abstract class AbstractTheme implements ThemeElement {
	
	@XStreamAlias("formatVersion")
	private Integer formatVersion;
	
	@XStreamImplicit(itemFieldName="include")
	private List<String> includes = new ArrayList<>();

	@XStreamImplicit
	private List<View> viewElements = new ArrayList<>();

	@Override
	public Integer getFormatVersion() {
		return formatVersion;
	}

	public void setFormatVersion(Integer formatVersion) {
		this.formatVersion = formatVersion;
	}

	@Override
	public List<View> getViewElements() {
		return viewElements;
	}

	public void setViewElements(List<View> viewElements) {
		this.viewElements = viewElements;
	}

	@Override
	public List<String> getIncludes() {
		return includes;
	}

	public void setIncludes(List<String> includes) {
		this.includes = includes;
	}

}
