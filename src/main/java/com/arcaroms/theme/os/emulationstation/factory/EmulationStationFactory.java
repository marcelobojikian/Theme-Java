package com.arcaroms.theme.os.emulationstation.factory;

import com.arcaroms.theme.os.common.builder.CommonBuilder;
import com.arcaroms.theme.os.common.factory.ComponentFactory;
import com.arcaroms.theme.os.emulationstation.xml.theme.EmulationStationTheme;

public class EmulationStationFactory extends ComponentFactory {

	public EmulationStationFactory(CommonBuilder builder) {
		super(builder);
	}
	
	/**
	 * 
	 * @return EmulationStationTheme
	 */
	public EmulationStationTheme createTheme(Integer version) {
		return createTheme(EmulationStationTheme.class, version);
	}

	public EmulationStationTheme createTheme(Integer version, String... includes) {
		return createTheme(EmulationStationTheme.class, version, includes);
	}
	
}
