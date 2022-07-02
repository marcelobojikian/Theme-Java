package com.arcaroms.theme.os.util;

import com.arcaroms.theme.os.common.converter.ContentConverter;
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
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.security.NoTypePermission;

public class XStreamUtil {
	
	public static XStream create() {

		XStream xstream = new XStream();

		xstream.autodetectAnnotations(true);
		xstream.ignoreUnknownElements();

		xstream.addPermission(NoTypePermission.NONE);
		
		return xstream;
		
	}
	
	public static XStream createForElements(Converter converter ) {

		XStream  xstream = new XStream();

		xstream.autodetectAnnotations(true);
		xstream.ignoreUnknownElements();

		xstream.registerConverter(new ContentConverter());
		xstream.registerConverter(converter);

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
