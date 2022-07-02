package com.arcaroms.theme.os.common.factory;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.arcaroms.theme.os.common.builder.CommonBuilder;
import com.arcaroms.theme.os.common.builder.ComponentBuilderDefault;
import com.arcaroms.theme.os.common.xml.element.AbstractElement;
import com.arcaroms.theme.os.common.xml.view.AbstractViewElement;
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

public class TagComponentFactoryTest {

	private TagComponentFactory factory;

	@BeforeEach
	public void init() {
		CommonBuilder builder = new ComponentBuilderDefault();
		factory= new TagComponentFactory(builder);
	}

	@Test
	void sucessWhenCreateView() {
		
		AbstractViewElement view = factory.createView("view");
		assertNotNull(view);
		assertInstanceOf(View.class, view);
		
	}

	@Test
	void sucessWhenCreateElement() {
		
		AbstractElement element = factory.createElement("text");
		assertNotNull(element);
		assertInstanceOf(Text.class, element);
		
		element = factory.createElement("image");
		assertNotNull(element);
		assertInstanceOf(Image.class, element);
		
		element = factory.createElement("datetime");
		assertNotNull(element);
		assertInstanceOf(Datetime.class, element);
		
		element = factory.createElement("helpsystem");
		assertNotNull(element);
		assertInstanceOf(HelpSystem.class, element);
		
		element = factory.createElement("ninepatch");
		assertNotNull(element);
		assertInstanceOf(Ninepatch.class, element);

		element = factory.createElement("rating");
		assertNotNull(element);
		assertInstanceOf(Rating.class, element);
		
		element = factory.createElement("sound");
		assertNotNull(element);
		assertInstanceOf(Sound.class, element);
		
		element = factory.createElement("textlist");
		assertNotNull(element);
		assertInstanceOf(TextList.class, element);
		
		element = factory.createElement("video");
		assertNotNull(element);
		assertInstanceOf(Video.class, element);
		
	}

	@Test
	void failWhenCreateViewWithOtherParameter() {
		assertThrows(RuntimeException.class, () -> {
			factory.createView("Other");
		});
	}

	@Test
	void failWhenCreateElementWithOtherParameter() {
		assertThrows(RuntimeException.class, () -> {
			factory.createElement("Other");
		});
	}
	
}
