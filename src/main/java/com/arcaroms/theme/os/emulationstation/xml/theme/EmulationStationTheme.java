package com.arcaroms.theme.os.emulationstation.xml.theme;

import java.util.ArrayList;
import java.util.Arrays;

import com.arcaroms.theme.os.common.xml.theme.AbstractTheme;
import com.arcaroms.theme.os.emulationstation.xml.View;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("theme")
public class EmulationStationTheme extends AbstractTheme {

	private static final long serialVersionUID = 1L;
	
	public EmulationStationTheme addViews(View... elements) {
		getViewElements().addAll(new ArrayList<>(Arrays.asList(elements)));
		return this;
	}

}
