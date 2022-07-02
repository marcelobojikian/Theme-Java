package com.arcaroms.theme.os.emulationstation;

import com.arcaroms.theme.os.common.Transformer;
import com.arcaroms.theme.os.common.builder.CommonBuilder;
import com.arcaroms.theme.os.common.builder.ComponentBuilderDefault;
import com.arcaroms.theme.os.common.converter.ContentConverter;
import com.arcaroms.theme.os.common.converter.ElementConverter;
import com.arcaroms.theme.os.common.factory.TagComponentFactory;
import com.arcaroms.theme.os.common.xml.Content;
import com.arcaroms.theme.os.emulationstation.factory.EmulationStationFactory;
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
import com.arcaroms.theme.os.emulationstation.xml.theme.EmulationStationTheme;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;

public class EmulationStationProject extends Transformer<EmulationStationTheme> {
	
	private static final int VERSION = 3; 
	
	private EmulationStationFactory factory;
	private TagComponentFactory tagFactory;
	
	private ElementConverter elementConverter;
	private ContentConverter contentConverter;
	
	public EmulationStationProject() {
		this(new ComponentBuilderDefault()); 
	}
	
//	public EmulationStationProject(ApplicationContext context) {
//		this(new SpringComponentBuilder(context));
//	}
	
	private EmulationStationProject(CommonBuilder builder) {
		factory = new EmulationStationFactory(builder);
		tagFactory = new TagComponentFactory(builder);
		elementConverter = new ElementConverter(tagFactory);
		contentConverter = new ContentConverter();
	}

	@Override
	public EmulationStationTheme createTheme() {
		return factory.createTheme(VERSION);
	}
	
	@Override
	public XStream getXStream() {

		XStream  xstream = new XStream();

		xstream.autodetectAnnotations(true);
		xstream.ignoreUnknownElements();

		xstream.registerConverter(contentConverter);
		xstream.registerConverter(elementConverter);

		xstream.processAnnotations(EmulationStationTheme.class);
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
		
		return xstream;
		
	}

}
