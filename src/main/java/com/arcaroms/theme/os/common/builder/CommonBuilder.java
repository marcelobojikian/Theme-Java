package com.arcaroms.theme.os.common.builder;

import com.arcaroms.theme.os.common.xml.element.AbstractElement;
import com.arcaroms.theme.os.common.xml.theme.AbstractTheme;
import com.arcaroms.theme.os.common.xml.view.AbstractViewElement;

public interface CommonBuilder {

	public <T extends AbstractTheme> T createTheme(Class<T> clazz);

	public <T extends AbstractViewElement> T createView(Class<T> clazz);
	
	public <T extends AbstractElement> T createElement(Class<T> clazz);

}
