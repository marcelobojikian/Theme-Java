package com.arcaroms.theme.os.batocera.builder;

import com.arcaroms.theme.os.batocera.xml.feature.AbstractFeature;
import com.arcaroms.theme.os.common.builder.CommonBuilder;

public interface BatoceraBuilder extends CommonBuilder {
	
	public <T extends AbstractFeature> T createFeature(Class<T> clazz);

}
