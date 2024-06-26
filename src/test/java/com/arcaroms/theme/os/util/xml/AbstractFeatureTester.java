package com.arcaroms.theme.os.util.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.arcaroms.theme.os.batocera.provider.BatoceraProvider;
import com.arcaroms.theme.os.batocera.provider.FeatureProvider;
import com.arcaroms.theme.os.batocera.xml.feature.AbstractFeature;
import com.arcaroms.theme.os.common.xml.element.CommonElement;
import com.arcaroms.theme.os.emulationstation.xml.element.Image;
import com.arcaroms.theme.os.emulationstation.xml.element.Text;

public class AbstractFeatureTester {
	
	final FeatureProvider provider;

	public AbstractFeatureTester(BatoceraProvider provider) {
		this.provider = provider;
	}
	
	public <T extends AbstractFeature> void testFeature(Class<T> clazz, String supported) {

		testFeature(clazz, supported, "ViewNameFeature");
		
		Text text = new Text();
		text.setName("FirstElement");
		
		testFeature(clazz, supported, "ViewNameFeature", text);
		
		Image image = new Image();
		image.setName("SecondElement");
		
		List<CommonElement> asList = Arrays.asList(text, image);
		
		testFeature(clazz, supported, "ViewNameFeature", asList);
		
	}
	
	<T extends AbstractFeature> void testFeature(Class<T> clazz, String supported, String viewName) {
		AbstractFeature feature = provider.createFeature(clazz, viewName);
		assertInstanceOf(clazz, feature);
		testFeatureContent(feature, supported, viewName);
	}
	
	<T extends AbstractFeature> void testFeature(Class<T> clazz, String supported, String viewName, CommonElement... elements) {
		AbstractFeature feature = provider.createFeature(clazz, viewName, elements);
		assertInstanceOf(clazz, feature);
		testFeatureContent(feature, supported, viewName, elements);
	}
	
	<T extends AbstractFeature> void testFeature(Class<T> clazz, String supported, String viewName, List<CommonElement> elements) {
		AbstractFeature feature = provider.createFeature(clazz, viewName, elements);
		assertInstanceOf(clazz, feature);
		testFeatureContent(feature, supported, viewName, elements);
	}
	
	<T extends AbstractFeature> void testFeatureContent(T feature, String supported, String viewName, CommonElement... elements) {
		assertNotNull(feature);
		assertNotNull(feature.getView());
		assertEquals(feature.getSupported(), supported);
		assertEquals(feature.getView().getName(), viewName);
		testFeatureElements(feature, elements);
	}
	
	<T extends AbstractFeature> void testFeatureContent(T feature, String supported, String viewName, List<CommonElement> elements) {
		assertNotNull(feature);
		assertNotNull(feature.getView());
		assertEquals(feature.getSupported(), supported);
		assertEquals(feature.getView().getName(), viewName);
		testFeatureElements(feature, elements);
	}
	
	<T extends AbstractFeature> void testFeatureElements(T feature, CommonElement... elements) {
		List<CommonElement> viewElements = feature.getView().getElements();
		if(elements.length > 0) {
			for (int i = 0; i < elements.length; i++) {
				assertTrue(viewElements.contains(elements[i]));
			}
		}
	}
	
	<T extends AbstractFeature> void testFeatureElements(T feature, List<CommonElement> elements) {
		List<CommonElement> viewElements = feature.getView().getElements();
		if(elements.size() > 0) {
			Iterator<CommonElement> iterator = elements.iterator();
			while (iterator.hasNext()) {
				assertTrue(viewElements.contains(iterator.next()));	
			}
		}
	}

}
