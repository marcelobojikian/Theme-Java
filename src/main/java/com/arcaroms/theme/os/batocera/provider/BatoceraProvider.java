package com.arcaroms.theme.os.batocera.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.arcaroms.theme.os.batocera.builder.BatoceraBuilder;
import com.arcaroms.theme.os.batocera.xml.feature.AbstractFeature;
import com.arcaroms.theme.os.common.provider.CommonProvider;
import com.arcaroms.theme.os.common.xml.element.CommonElement;
import com.arcaroms.theme.os.emulationstation.xml.View;

public class BatoceraProvider extends CommonProvider implements FeatureProvider {

	private BatoceraBuilder builder;

	public BatoceraProvider(BatoceraBuilder builder) {
		super(builder);
		this.builder = builder;
	}

	@Override
	public <T extends AbstractFeature> T createFeature(Class<T> clazz, String viewName) {
		T feature = builder.createFeature(clazz);
		View view = builder.createView(View.class);
		view.setName(viewName);
		feature.setView(view);
		return feature;
	}

	@Override
	public <T extends AbstractFeature> T createFeature(Class<T> clazz, String viewName, CommonElement... elements) {
		T feature = builder.createFeature(clazz);
		View view = builder.createView(View.class);
		view.setName(viewName);
		view.setElements(new ArrayList<>(Arrays.asList(elements)));
		feature.setView(view);
		return feature;
	}

	@Override
	public <T extends AbstractFeature> T createFeature(Class<T> clazz, String viewName, List<CommonElement> elements) {
		T feature = builder.createFeature(clazz);
		View view = builder.createView(View.class);
		view.setName(viewName);
		view.setElements(elements);
		feature.setView(view);
		return feature;
	}

}
