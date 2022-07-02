package com.arcaroms.theme.os.batocera.factory;

import com.arcaroms.theme.os.batocera.builder.BatoceraBuilder;
import com.arcaroms.theme.os.batocera.converter.FeatureTagConverter;
import com.arcaroms.theme.os.batocera.xml.element.BatoceraCarousel;
import com.arcaroms.theme.os.batocera.xml.feature.AbstractFeature;
import com.arcaroms.theme.os.batocera.xml.feature.CarouselFeature;
import com.arcaroms.theme.os.batocera.xml.feature.VideoFeature;
import com.arcaroms.theme.os.common.factory.TagComponentFactory;
import com.arcaroms.theme.os.common.xml.element.AbstractElement;

public class FeatureComponentFactory extends TagComponentFactory implements FeatureTagConverter {
	
	private BatoceraBuilder builder;

	public FeatureComponentFactory(BatoceraBuilder builder) {
		super(builder);
		this.builder = builder;
	}
	
	@Override
	public AbstractElement createElement(String tagName) {
		
		if(tagName.equals("carousel")) {
			return builder.createElement(BatoceraCarousel.class);
		}
		
		return super.createElement(tagName);
	}

	@Override
	public AbstractFeature createFeature(String supported) {
		switch (supported) {
		case "carousel":
			return builder.createFeature(CarouselFeature.class);
		case "video":
			return builder.createFeature(VideoFeature.class);
		default:
			throw new RuntimeException("Fail to create feature supported " + supported);
		}
	}

}
