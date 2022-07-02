package com.arcaroms.theme.os.batocera.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arcaroms.theme.os.batocera.converter.FeatureConverter;
import com.arcaroms.theme.os.batocera.xml.feature.BatoceraFeature;
import com.arcaroms.theme.os.batocera.xml.feature.CarouselFeature;
import com.arcaroms.theme.os.batocera.xml.feature.VideoFeature;
import com.arcaroms.theme.os.common.converter.ElementConverter;
import com.arcaroms.theme.os.emulationstation.xml.View;
import com.arcaroms.theme.os.emulationstation.xml.element.Image;
import com.arcaroms.theme.os.emulationstation.xml.element.Text;
import com.arcaroms.theme.os.util.XStreamUtil;
import com.thoughtworks.xstream.XStream;

//@SpringBootTest
public class FeatureTest {

//	XStream xstream;
//
//	@Autowired
//	ElementConverter elementConverter;
//
//	@Autowired
//	FeatureConverter featureConverter;
//
//	@BeforeEach
//	public void init() {
//		xstream = XStreamUtil.createForElements(elementConverter);
//
//		xstream.processAnnotations(CarouselSupport.class);
//		xstream.processAnnotations(VideoSupport.class);
//
//		xstream.alias("feature", CarouselSupport.class);
//		xstream.alias("feature", VideoSupport.class);
//		
//		xstream.registerConverter(featureConverter);
//		
//		xstream.allowTypes(new Class[] {
//				Feature.class,
//				CarouselSupport.class,
//				VideoSupport.class });
//	}
//
//	@Test
//	public void whenCreateFeature_DefaultValues() {
//
//		CarouselSupport carousel = new CarouselSupport();
//
//		assertNull(carousel.getView());
//		assertEquals(carousel.getSupported(), "carousel");
//		assertNull(carousel.getView());
//		
//		VideoSupport video = new VideoSupport();
//
//		assertNull(video.getView());
//		assertEquals(video.getSupported(), "video");
//		assertNull(video.getView());
//
//	}
//	
//	@Test
//	public void sucessWhenCreateXml_FeatureWithoutView() {
//		
//		CarouselSupport carousel = new CarouselSupport();
//		
//		String featureXml = xstream.toXML(carousel);
//		String result = "<feature supported=\"carousel\"/>";
//
//		assertEquals(featureXml, result);
//		
//		VideoSupport video = new VideoSupport();
//		
//		featureXml = xstream.toXML(video);
//		result = "<feature supported=\"video\"/>";
//
//		assertEquals(featureXml, result);
//		
//	}
//
//	@Test
//	public void sucessWhenCreateXml_FeatureWithView() {
//
//		View view = new View();
//		view.setName("ViewElement");
//		
//		CarouselSupport carousel = new CarouselSupport();
//		carousel.setView(view);
//
//		String featureXml = xstream.toXML(carousel);
//		// @formatter:off
//		String result = "<feature supported=\"carousel\">\n"
//					  + "  <view name=\"ViewElement\"/>\n"
//					  + "</feature>";
//		// @formatter:on
//
//		assertEquals(featureXml, result);
//		
//		VideoSupport video = new VideoSupport();
//		video.setView(view);
//
//		featureXml = xstream.toXML(video);
//		// @formatter:off
//		result = "<feature supported=\"video\">\n"
//					  + "  <view name=\"ViewElement\"/>\n"
//					  + "</feature>";
//		// @formatter:on
//
//		assertEquals(featureXml, result);
//
//	}
//	
//	@Test
//	public void errorWhenFeatureAddElement_WithoutView() {
//		
//		CarouselSupport carousel = new CarouselSupport();
//
//		assertThrows(NullPointerException.class, () -> {
//			carousel.addElement(new Text());
//		});
//		
//		VideoSupport video = new VideoSupport();
//
//		assertThrows(NullPointerException.class, () -> {
//			video.addElement(new Text());
//		});
//		
//	}
//
//	@Test
//	public void sucessWhenCreateXml_FeatureWithOneElements() {
//
//		CarouselSupport carousel = new CarouselSupport();
//
//		Text text = new Text();
//		text.setName("TextElement");
//
//		View view = new View();
//		view.setName("ViewElement");
//
//		carousel.setView(view);
//		carousel.addElement(text);
//
//		String featureXml = xstream.toXML(carousel);
//		// @formatter:off
//		String result = "<feature supported=\"carousel\">\n"
//					  + "  <view name=\"ViewElement\">\n"
//					  + "    <text name=\"TextElement\"/>\n"
//					  + "  </view>\n"
//					  + "</feature>";
//		// @formatter:on
//
//		assertEquals(featureXml, result);
//		
//		VideoSupport video = new VideoSupport();
//
//		view = new View();
//		view.setName("ViewElement");
//
//		video.setView(view);
//		video.addElement(text);
//
//		featureXml = xstream.toXML(video);
//		// @formatter:off
//		result = "<feature supported=\"video\">\n"
//					  + "  <view name=\"ViewElement\">\n"
//					  + "    <text name=\"TextElement\"/>\n"
//					  + "  </view>\n"
//					  + "</feature>";
//		// @formatter:on
//
//		assertEquals(featureXml, result);
//		
//	}
//
//	@Test
//	public void sucessWhenCreateXml_FeatureWithManyElements() {
//
//		Text text = new Text();
//		text.setName("TextElement");
//
//		Image image = new Image();
//		image.setName("ImageElement");
//
//		View view = new View();
//		view.setName("ViewElement");
//		
//		CarouselSupport carousel = new CarouselSupport();
//
//		carousel.setView(view);
//		carousel.addElements(text, image);
//
//		String featureXml = xstream.toXML(carousel);
//		// @formatter:off
//		String result = "<feature supported=\"carousel\">\n"
//					  + "  <view name=\"ViewElement\">\n"
//					  + "    <text name=\"TextElement\"/>\n"
//					  + "    <image name=\"ImageElement\"/>\n"
//					  + "  </view>\n"
//					  + "</feature>";
//		// @formatter:on
//
//		assertEquals(featureXml, result);
//		
//		VideoSupport video = new VideoSupport();
//
//		view = new View();
//		view.setName("ViewElement");
//
//		video.setView(view);
//		video.addElements(text, image);
//
//		featureXml = xstream.toXML(video);
//		// @formatter:off
//		result = "<feature supported=\"video\">\n"
//					  + "  <view name=\"ViewElement\">\n"
//					  + "    <text name=\"TextElement\"/>\n"
//					  + "    <image name=\"ImageElement\"/>\n"
//					  + "  </view>\n"
//					  + "</feature>";
//		// @formatter:on
//
//		assertEquals(featureXml, result);
//		
//	}
//
//	@Test
//	public void sucessWhenCreateXml_FeatureWithExtraElements() {
//
//		Text text = new Text();
//		text.setName("TextElement");
//		text.setExtra(true);
//
//		View view = new View();
//		view.setName("ViewElement");
//
//		CarouselSupport carousel = new CarouselSupport();
//		
//		carousel.setView(view);
//		carousel.addElement(text);
//
//		String featureXml = xstream.toXML(carousel);
//		// @formatter:off
//		String result = "<feature supported=\"carousel\">\n"
//					  + "  <view name=\"ViewElement\">\n"
//					  + "    <text extra=\"true\" name=\"TextElement\"/>\n"
//					  + "  </view>\n"
//					  + "</feature>";
//		// @formatter:on
//
//		assertEquals(featureXml, result);
//
//		view = new View();
//		view.setName("ViewElement");
//
//		VideoSupport video = new VideoSupport();
//		
//		video.setView(view);
//		video.addElement(text);
//
//		featureXml = xstream.toXML(video);
//		// @formatter:off
//		result = "<feature supported=\"video\">\n"
//					  + "  <view name=\"ViewElement\">\n"
//					  + "    <text extra=\"true\" name=\"TextElement\"/>\n"
//					  + "  </view>\n"
//					  + "</feature>";
//		// @formatter:on
//
//		assertEquals(featureXml, result);
//
//	}
//
//	@Test
//	void sucessWhenConvertToJava_Feature() {
//
//		// @formatter:off
//		String result = "<feature supported=\"carousel\">\n"
//					  + "  <view name=\"ViewElement\">\n"
//					  + "    <text extra=\"true\" name=\"TextElement\"/>\n"
//					  + "  </view>\n"
//					  + "</feature>";
//		// @formatter:on
//
//		Feature featureObj = (Feature) xstream.fromXML(result);
//
//		assertNotNull(featureObj);
//		assertEquals(featureObj.getSupported(), "carousel");
//		assertInstanceOf(CarouselSupport.class, featureObj);
//
//		// @formatter:off
//		result = "<feature supported=\"video\">\n"
//					  + "  <view name=\"ViewElement\">\n"
//					  + "    <text extra=\"true\" name=\"TextElement\"/>\n"
//					  + "  </view>\n"
//					  + "</feature>";
//		// @formatter:on
//
//		featureObj = (Feature) xstream.fromXML(result);
//
//		assertNotNull(featureObj);
//		assertEquals(featureObj.getSupported(), "video");
//		assertInstanceOf(VideoSupport.class, featureObj);
//
//	}

}
