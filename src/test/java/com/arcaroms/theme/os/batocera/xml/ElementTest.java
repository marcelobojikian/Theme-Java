package com.arcaroms.theme.os.batocera.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arcaroms.theme.os.batocera.xml.element.BatoceraCarousel;
import com.arcaroms.theme.os.batocera.xml.feature.BatoceraFeature;
import com.arcaroms.theme.os.batocera.xml.feature.CarouselFeature;
import com.arcaroms.theme.os.batocera.xml.feature.VideoFeature;
import com.arcaroms.theme.os.batocera.xml.theme.BatoceraTheme;
import com.arcaroms.theme.os.common.converter.ElementConverter;
import com.arcaroms.theme.os.common.xml.Content;
import com.arcaroms.theme.os.common.xml.element.AbstractElement;
import com.arcaroms.theme.os.common.xml.element.CommonElement;
import com.arcaroms.theme.os.util.XStreamUtil;
import com.thoughtworks.xstream.XStream;

//@SpringBootTest
public class ElementTest {

//	XStream xstream;
//	
//	@Autowired
//	ElementConverter elementConverter;
//
//	@BeforeEach
//	public void init() {
//		xstream = XStreamUtil.createForElements(elementConverter);
//
//		xstream.processAnnotations(BatoceraCarousel.class);
//		
//		xstream.allowTypes(new Class[] {
//				BatoceraCarousel.class });
//	}
//
//	@Test
//	public void sucessWhenCreateXml_Element_Carousel() {
//		sucessWhenCreateXml(new BatoceraCarousel(), "carousel", true, "CarouselElement");
//	}
//
//	@Test
//	void sucessWhenConvertToJava_Element_Carousel() {
//		successWhenConvertToJava(BatoceraCarousel.class, "carousel", true, "CarouselElement");
//	}
//
//	void sucessWhenCreateXml(AbstractElement element, String tagName, boolean attributeExtra,  String attributeName) {
//
//		element.setName(attributeName);
//		element.setExtra(attributeExtra);
//		element.setContent(new Content());
//
//		String elementXml = xstream.toXML(element);
//		
//		StringBuilder result = new StringBuilder("<"+tagName);
//		if(attributeExtra) {
//			result.append(" extra=\"true\"");
//		}
//		result.append(" name=\""+attributeName+"\"/>");
//		
//		assertEquals(elementXml, result.toString());
//		
//	}
//	
//	void successWhenConvertToJava(Class<? extends Element> clazz, String tagName, boolean attributeExtra, String attributeName) {
//
//		StringBuilder result = new StringBuilder("<"+tagName);
//		if(attributeExtra) {
//			result.append(" extra=\"true\"");
//		}
//		result.append(" name=\""+attributeName+"\"/>");
//
//		Element elementObj = (Element) xstream.fromXML(result.toString());
//
//		assertNotNull(elementObj);
//		assertInstanceOf(clazz, elementObj);
//		assertEquals(elementObj.getName(), attributeName);
//		assertTrue(elementObj.isExtra());
//		
//	}

}
