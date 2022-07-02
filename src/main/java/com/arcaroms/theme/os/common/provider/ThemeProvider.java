package com.arcaroms.theme.os.common.provider;

import com.arcaroms.theme.os.common.xml.theme.AbstractTheme;

public interface ThemeProvider {
	
	public <T extends AbstractTheme> T createTheme(Class<T> clazz, Integer version);
	
	public <T extends AbstractTheme> T createTheme(Class<T> clazz, Integer version, String... includes);

}
