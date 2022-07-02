package com.arcaroms.theme.os.common.builder;

import java.lang.reflect.Constructor;

import com.arcaroms.theme.os.common.xml.element.AbstractElement;
import com.arcaroms.theme.os.common.xml.theme.AbstractTheme;
import com.arcaroms.theme.os.common.xml.view.AbstractViewElement;

public class ComponentBuilderDefault implements CommonBuilder {

	@Override
	public <T extends AbstractTheme> T createTheme(Class<T> clazz) {
		try {
			Constructor<T> ctor = clazz.getDeclaredConstructor();
			ctor.setAccessible(true);
			return ctor.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Fail to instance Theme class " + clazz.getName(), e);
		}
	}

	@Override
	public <T extends AbstractViewElement> T createView(Class<T> clazz) {
		try {
			Constructor<T> ctor = clazz.getDeclaredConstructor();
			ctor.setAccessible(true);
			return ctor.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Fail to instance View class " + clazz.getName(), e);
		}
	}

	@Override
	public <T extends AbstractElement> T createElement(Class<T> clazz) {
		try {
			Constructor<T> ctor = clazz.getDeclaredConstructor();
			ctor.setAccessible(true);
			return ctor.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Fail to instance Element class " + clazz.getName(), e);
		}
	}

}
