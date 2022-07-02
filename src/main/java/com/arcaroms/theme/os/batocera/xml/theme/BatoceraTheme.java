package com.arcaroms.theme.os.batocera.xml.theme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.arcaroms.theme.os.batocera.xml.feature.BatoceraFeature;
import com.arcaroms.theme.os.emulationstation.xml.View;
import com.arcaroms.theme.os.emulationstation.xml.theme.EmulationStationTheme;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("theme")
public class BatoceraTheme extends EmulationStationTheme {

	private static final long serialVersionUID = 1L;

	@XStreamImplicit(itemFieldName = "feature")
	private List<BatoceraFeature> features = new ArrayList<>();

	public List<BatoceraFeature> getFeatures() {
		return features;
	}

	public void setFeatures(List<BatoceraFeature> features) {
		this.features = features;
	}
	
	public BatoceraTheme addFeatures(BatoceraFeature... features) {
		this.features.addAll(new ArrayList<>(Arrays.asList(features)));
		return this;
	}
	
	@Override
	public BatoceraTheme addViews(View... elements) {
		getViewElements().addAll(new ArrayList<>(Arrays.asList(elements)));
		return this;
	}

}
