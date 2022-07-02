package com.arcaroms.theme.os.emulationstation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arcaroms.theme.os.common.xml.element.CommonElement;
import com.arcaroms.theme.os.emulationstation.factory.EmulationStationFactory;
import com.arcaroms.theme.os.emulationstation.factory.EmulationStationFactory;
import com.arcaroms.theme.os.emulationstation.xml.View;
import com.arcaroms.theme.os.emulationstation.xml.element.Text;

//@SpringBootTest
public class FactoryTest {

//	@Autowired
	EmulationStationFactory factory;
	
//	@Test
	public void successWhenCreateView() {
		
		View view = factory.createView("ViewElement");
		
		assertEquals(view.getName(), "ViewElement");
		assertTrue(view.getElements().isEmpty());
		
		view = factory.createView("SecondViewElement", 
				factory.createText("TextElement"));
		
		assertEquals(view.getName(), "SecondViewElement");
		assertTrue(view.getElements().size() == 1);
		
		CommonElement element = view.getElements().get(0);
		assertInstanceOf(Text.class, element);
		assertEquals(element.getName(), "TextElement");
		
		List<CommonElement> elementList = Arrays.asList(factory.createText("FirstTextElement"), factory.createText("SecondTextElement"));
		
		view = factory.createView("ThirdViewElement", elementList);
		
		assertEquals(view.getName(), "ThirdViewElement");
		assertTrue(view.getElements().size() == 2);
		
	}

//	@Test
	public void successWhenCreateText() {
		
		Text element = factory.createText("TextElement");
		
		assertEquals(element.getName(), "TextElement");
		
		element = factory.createText("SecondTextElement", true);
		
		assertEquals(element.getName(), "SecondTextElement");
		assertTrue(element.isExtra());
		
		Map<String, String> attribute = new HashMap<>();
		attribute.put("key", "value");
		
		element = factory.createText("ThirdTextElement", attribute);
		
		assertEquals(element.getName(), "ThirdTextElement");
		assertFalse(element.isExtra());
		assertFalse(element.getContent().getAttributes().isEmpty());
		
	}
	
	public void successWhenCreateTextList() {
		
	}
	
	public void successWhenCreateHelpSystem() {
		
	}
	
	public void successWhenCreateRating() {
		
	}
	
	public void successWhenCreateDatatime() {
		
	}
	
	public void successWhenCreateImage() {
		
	}
	
	public void successWhenCreateVideo() {
		
	}
	
}
