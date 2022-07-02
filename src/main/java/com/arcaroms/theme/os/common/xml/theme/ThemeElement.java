package com.arcaroms.theme.os.common.xml.theme;

import java.io.Serializable;
import java.util.List;

import com.arcaroms.theme.os.emulationstation.xml.View;

public interface ThemeElement extends Serializable {

	public Integer getFormatVersion();

	public List<View> getViewElements();

	public List<String> getIncludes();

}
