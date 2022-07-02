package com.arcaroms.theme.os.batocera.builder;

import java.lang.reflect.Constructor;

import com.arcaroms.theme.os.batocera.xml.feature.AbstractFeature;
import com.arcaroms.theme.os.common.builder.ComponentBuilderDefault;

public class BatoceraBuilderDefault extends ComponentBuilderDefault implements BatoceraBuilder {

	@Override
	public <T extends AbstractFeature> T createFeature(Class<T> clazz) {
		try {
			Constructor<T> ctor = clazz.getDeclaredConstructor();
			ctor.setAccessible(true);
			return ctor.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Fail to instance Feature class " + clazz.getName(), e);
		}
	}

}
