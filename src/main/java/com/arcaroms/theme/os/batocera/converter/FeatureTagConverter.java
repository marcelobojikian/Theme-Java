package com.arcaroms.theme.os.batocera.converter;

import com.arcaroms.theme.os.batocera.xml.feature.AbstractFeature;

public interface FeatureTagConverter {

	public AbstractFeature createFeature(String supported);

}
