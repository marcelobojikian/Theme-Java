package com.arcaroms.theme.os.batocera;

import com.arcaroms.theme.os.batocera.builder.BatoceraBuilder;
import com.arcaroms.theme.os.batocera.builder.BatoceraBuilderDefault;
import com.arcaroms.theme.os.batocera.converter.FeatureConverter;
import com.arcaroms.theme.os.batocera.factory.BatoceraFactory;
import com.arcaroms.theme.os.batocera.factory.FeatureComponentFactory;
import com.arcaroms.theme.os.batocera.xml.element.BatoceraCarousel;
import com.arcaroms.theme.os.batocera.xml.feature.BatoceraFeature;
import com.arcaroms.theme.os.batocera.xml.feature.CarouselFeature;
import com.arcaroms.theme.os.batocera.xml.feature.VideoFeature;
import com.arcaroms.theme.os.batocera.xml.theme.BatoceraTheme;
import com.arcaroms.theme.os.common.Transformer;
import com.arcaroms.theme.os.common.converter.ContentConverter;
import com.arcaroms.theme.os.common.converter.ElementConverter;
import com.arcaroms.theme.os.common.xml.Content;
import com.arcaroms.theme.os.emulationstation.xml.View;
import com.arcaroms.theme.os.emulationstation.xml.element.Datetime;
import com.arcaroms.theme.os.emulationstation.xml.element.HelpSystem;
import com.arcaroms.theme.os.emulationstation.xml.element.Image;
import com.arcaroms.theme.os.emulationstation.xml.element.Ninepatch;
import com.arcaroms.theme.os.emulationstation.xml.element.Rating;
import com.arcaroms.theme.os.emulationstation.xml.element.Sound;
import com.arcaroms.theme.os.emulationstation.xml.element.Text;
import com.arcaroms.theme.os.emulationstation.xml.element.TextList;
import com.arcaroms.theme.os.emulationstation.xml.element.Video;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;

public class BatoceraProject extends Transformer<BatoceraTheme> {
	
	private static final int VERSION = 4; 
	
	private BatoceraFactory factory;
	
	private FeatureConverter featureConverter;
	private ElementConverter elementConverter;
	private ContentConverter contentConverter;
	
	public BatoceraProject() {
		this(new BatoceraBuilderDefault()); 
	}
	
//	public BatoceraProject(ApplicationContext context) {
//		this(new SpringBatoceraBuilder(context));
//	}
	
	public BatoceraProject(BatoceraBuilder batoceraBuilder) {
		this(new FeatureComponentFactory(batoceraBuilder));
	}
	
	public BatoceraProject(FeatureComponentFactory componentFactory) {
		featureConverter = new FeatureConverter(componentFactory);
		elementConverter = new ElementConverter(componentFactory);
		contentConverter = new ContentConverter();
	}

	@Override
	public BatoceraTheme createTheme() {
		return factory.createTheme(VERSION);
	}

	@Override
	public XStream getXStream() {

		XStream  xstream = new XStream();

		xstream.autodetectAnnotations(true);
		xstream.ignoreUnknownElements();

		xstream.registerConverter(contentConverter);
		xstream.registerConverter(elementConverter);

		xstream.processAnnotations(BatoceraTheme.class);
		xstream.processAnnotations(Rating.class);
		xstream.processAnnotations(Datetime.class);
		xstream.processAnnotations(HelpSystem.class);
		xstream.processAnnotations(TextList.class);
		xstream.processAnnotations(Video.class);
		xstream.processAnnotations(Sound.class);
		xstream.processAnnotations(View.class);
		xstream.processAnnotations(Text.class);
		xstream.processAnnotations(Image.class);
		xstream.processAnnotations(Ninepatch.class);
		xstream.processAnnotations(Content.class);
		
		xstream.addPermission(NoTypePermission.NONE);
		
		xstream.allowTypes(new Class[] {
				Rating.class,
				Datetime.class,
				HelpSystem.class,
				TextList.class,
				Video.class,
				Sound.class,
				View.class,
				Text.class,
				Image.class,
				Ninepatch.class,
				Content.class });

		xstream.processAnnotations(BatoceraTheme.class);
		xstream.processAnnotations(BatoceraCarousel.class);
		xstream.processAnnotations(CarouselFeature.class);
		xstream.processAnnotations(VideoFeature.class);

		xstream.alias("feature", CarouselFeature.class);
		xstream.alias("feature", VideoFeature.class);
		
		xstream.registerConverter(featureConverter);
		
		xstream.allowTypes(new Class[] {
				BatoceraTheme.class,
				BatoceraCarousel.class,
				BatoceraFeature.class,
				CarouselFeature.class,
				VideoFeature.class });
		
		return xstream;
		
	}

}
