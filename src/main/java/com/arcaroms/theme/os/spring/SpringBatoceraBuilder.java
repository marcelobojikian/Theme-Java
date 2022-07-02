package com.arcaroms.theme.os.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.arcaroms.theme.os.batocera.builder.BatoceraBuilder;
import com.arcaroms.theme.os.batocera.xml.element.BatoceraCarousel;
import com.arcaroms.theme.os.batocera.xml.feature.AbstractFeature;
import com.arcaroms.theme.os.batocera.xml.feature.CarouselFeature;
import com.arcaroms.theme.os.batocera.xml.feature.VideoFeature;
import com.arcaroms.theme.os.batocera.xml.theme.BatoceraTheme;
import com.arcaroms.theme.os.common.xml.theme.AbstractTheme;

@Component
public class SpringBatoceraBuilder extends SpringCommonBuilder implements BatoceraBuilder {

	public SpringBatoceraBuilder(ApplicationContext context) {
		super(context);
	}

	@Override
	public <T extends AbstractTheme> T createTheme(Class<T> clazz) {
		return context.getBean("batocera", clazz);
	}

	@Override
	public <T extends AbstractFeature> T createFeature(Class<T> clazz) {
		return context.getBean(clazz);
	}

	@Bean("batocera")
	public BatoceraTheme getBatoceraTheme() {
		return new BatoceraTheme();
	}

	@Bean("carousel")
	public BatoceraCarousel getBatoceraCarousel() {
		return new BatoceraCarousel();
	}

	@Bean("carouselFeature")
	public CarouselFeature getCarouselFeature() {
		return new CarouselFeature();
	}

	@Bean("videoFeature")
	public VideoFeature getVideoFeature() {
		return new VideoFeature();
	}

}
