package com.arcaroms.theme.os.util.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.arcaroms.theme.os.common.provider.ThemeProvider;
import com.arcaroms.theme.os.common.xml.theme.AbstractTheme;

public class AbstractThemeTester {
	
	ThemeProvider provider;
	
	public AbstractThemeTester(ThemeProvider provider){
		this.provider = provider;
	}

	public <T extends AbstractTheme> void testTheme(Class<T> clazz) {

		testTheme(clazz, 2);
		testTheme(clazz, 3, "FirstInclude");
		testTheme(clazz, 4, "FirstInclude", "SecondInclude");
		
	}
	
	<T extends AbstractTheme> void testTheme(Class<T> clazz, Integer versionExpected) {
		AbstractTheme theme = provider.createTheme(clazz, versionExpected);
		assertInstanceOf(clazz, theme);
		testThemeContent(theme, versionExpected);
	}
	
	<T extends AbstractTheme> void testTheme(Class<T> clazz, Integer versionExpected, String... includesExpected) {
		AbstractTheme theme = provider.createTheme(clazz, versionExpected, includesExpected);
		assertInstanceOf(clazz, theme);
		testThemeContent(theme, versionExpected, includesExpected);
	}
	
	public static <T extends AbstractTheme> void testThemeContent(T theme, Integer versionExpected, String... includesExpected) {
		assertNotNull(theme);
		assertNotNull(includesExpected);
		assertEquals(versionExpected, theme.getFormatVersion());
		List<String> themeIncludes = theme.getIncludes();
		if(includesExpected.length == 0) {
			assertTrue(themeIncludes.isEmpty());
		} else {
			for (int i = 0; i < includesExpected.length; i++) {
				assertTrue(themeIncludes.contains(includesExpected[i]));
			}
		}
	}

}
