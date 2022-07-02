package com.arcaroms.theme.os.batocera.provider;

import java.util.List;

import com.arcaroms.theme.os.batocera.xml.feature.AbstractFeature;
import com.arcaroms.theme.os.common.xml.element.CommonElement;

public interface FeatureProvider {
	
	public <T extends AbstractFeature> T createFeature(Class<T> clazz, String viewName);
	
	public <T extends AbstractFeature> T createFeature(Class<T> clazz, String viewName, CommonElement... elements);
	
	public <T extends AbstractFeature> T createFeature(Class<T> clazz, String viewName, List<CommonElement> elements);

}
