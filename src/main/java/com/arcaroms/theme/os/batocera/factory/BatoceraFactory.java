package com.arcaroms.theme.os.batocera.factory;

import java.util.Map;

import com.arcaroms.theme.os.batocera.builder.BatoceraBuilder;
import com.arcaroms.theme.os.batocera.provider.BatoceraProvider;
import com.arcaroms.theme.os.batocera.xml.element.BatoceraCarousel;
import com.arcaroms.theme.os.batocera.xml.feature.CarouselFeature;
import com.arcaroms.theme.os.batocera.xml.feature.VideoFeature;
import com.arcaroms.theme.os.batocera.xml.theme.BatoceraTheme;
import com.arcaroms.theme.os.common.factory.ComponentFactory;
import com.arcaroms.theme.os.emulationstation.xml.element.Text;
import com.arcaroms.theme.os.emulationstation.xml.element.Video;

public class BatoceraFactory extends ComponentFactory {

	private BatoceraProvider provider;

	public BatoceraFactory(BatoceraBuilder builder) {
		super(builder);
		provider = new BatoceraProvider(builder);
	}
	
	/**
	 * 
	 * @param version
	 * @return BatoceraTheme
	 */
	public BatoceraTheme createTheme(Integer version) {
		return provider.createTheme(BatoceraTheme.class, version);
	}
	
	public BatoceraTheme createTheme(Integer version, String... includes) {
		return provider.createTheme(BatoceraTheme.class, version, includes);
	}
	
	/**
	 * 
	 * @return logoText
	 */
	public Text createLogoText() {
		return createText("logoText");
	}
	
	public Text createLogoText(Map<String, String> attributes) {
		return createText("logoText", attributes);
	}
	
	/**
	 * 
	 * @return systemInfo
	 */
	public Text createSystemInfo() {
		return createText("systemInfo");
	}
	
	public Text createSystemInfo(Map<String, String> attributes) {
		return createText("systemInfo", attributes);
	}

	/**
	 * 
	 * @return CarouselSupport
	 */
	public CarouselFeature createFeatureCarousel() {
		BatoceraCarousel carousel = provider.createElement(BatoceraCarousel.class, "systemcarousel");
		return provider.createFeature(CarouselFeature.class, "system", carousel);
	}

	public CarouselFeature createFeatureCarousel(Map<String, String> attributes) {
		BatoceraCarousel carousel = provider.createElement(BatoceraCarousel.class, "systemcarousel", attributes);
		return provider.createFeature(CarouselFeature.class, "system", carousel);
	}
	
	/**
	 * 
	 * @return VideoSupport
	 */
	public VideoFeature createFeatureVideo() {
		Video video = createVideo("md_video");
		return provider.createFeature(VideoFeature.class, "video", video);
	}
	
	public VideoFeature createFeatureVideo(Map<String, String> attributes) {
		Video video = createVideo("md_video", attributes);
		return provider.createFeature(VideoFeature.class, "video", video);
	}

}
